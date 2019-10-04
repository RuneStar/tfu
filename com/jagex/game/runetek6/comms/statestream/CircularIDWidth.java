/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

public enum CircularIDWidth {
    ONE_BYTE(255, 1),
    TWO_BYTES(65535, 2);
    
    public final int bytes;
    public final int mask;

    public int diffIDs(int n, int n2) {
        if (Math.abs((n &= this.mask) - (n2 &= this.mask)) > this.mask >>> 1) {
            if (n < n2) {
                n += this.mask + 1;
            } else {
                n2 += this.mask + 1;
            }
        }
        return n - n2;
    }

    public void putID(int n, ByteBuffer byteBuffer) {
        switch (this) {
            case ONE_BYTE: {
                byteBuffer.put((byte)n);
                break;
            }
            case TWO_BYTES: {
                byteBuffer.putShort((short)n);
            }
        }
    }

    public int getID(ByteBuffer byteBuffer) {
        switch (this) {
            case ONE_BYTE: {
                return byteBuffer.get() & 0xFF;
            }
            case TWO_BYTES: {
                return byteBuffer.getShort() & 0xFFFF;
            }
        }
        return -1;
    }

    public int sumIDs(int n, int n2) {
        return n + n2 & this.mask;
    }

    private CircularIDWidth(int n2, int n3) {
        this.mask = n2;
        this.bytes = n3;
    }
}

