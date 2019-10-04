// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

public enum CircularIDWidth
{
    ONE_BYTE("ONE_BYTE", 0, 255, 1), 
    TWO_BYTES("TWO_BYTES", 1, 65535, 2);
    
    public final int bytes;
    public final int mask;
    
    public int diffIDs(int n, int n2) {
        n2 &= this.mask;
        n &= this.mask;
        if (Math.abs(n - n2) > this.mask >>> 1) {
            if (n < n2) {
                n += this.mask + 1;
            }
            else {
                n2 += this.mask + 1;
            }
        }
        return n - n2;
    }
    
    public void putID(final int n, final ByteBuffer byteBuffer) {
        switch (CircularIDWidth$1.$SwitchMap$com$jagex$game$runetek6$comms$statestream$CircularIDWidth[this.ordinal()]) {
            case 1: {
                byteBuffer.put((byte)n);
                break;
            }
            case 2: {
                byteBuffer.putShort((short)n);
                break;
            }
        }
    }
    
    public int getID(final ByteBuffer byteBuffer) {
        switch (CircularIDWidth$1.$SwitchMap$com$jagex$game$runetek6$comms$statestream$CircularIDWidth[this.ordinal()]) {
            case 1: {
                return byteBuffer.get() & 0xFF;
            }
            case 2: {
                return byteBuffer.getShort() & 0xFFFF;
            }
            default: {
                return -1;
            }
        }
    }
    
    public int sumIDs(final int n, final int n2) {
        return n + n2 & this.mask;
    }
    
    private CircularIDWidth(final String name, final int ordinal, final int mask, final int bytes) {
        this.mask = mask;
        this.bytes = bytes;
    }
}
