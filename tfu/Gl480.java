/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

public abstract class Gl480 {
    public static boolean d = false;
    private static final boolean g = true;

    public static byte[] d(Object object, boolean bl) {
        if (object == null) {
            return null;
        }
        if (object instanceof byte[]) {
            byte[] arrby = (byte[])object;
            if (bl) {
                return Arrays.copyOf(arrby, arrby.length);
            }
            return arrby;
        }
        if (object instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer)object;
            byte[] arrby = new byte[byteBuffer.capacity()];
            byteBuffer.position(0);
            byteBuffer.get(arrby);
            return arrby;
        }
        throw new IllegalArgumentException("Not a ByteBuffer!");
    }

    public static Object g(byte[] arrby, boolean bl) {
        if (arrby == null) {
            return null;
        }
        if (arrby.length > 136 && !d) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(arrby.length);
            byteBuffer.position(0);
            byteBuffer.put(arrby);
            return byteBuffer;
        }
        if (bl) {
            return Arrays.copyOf(arrby, arrby.length);
        }
        return arrby;
    }

    private Gl480() {
    }
}

