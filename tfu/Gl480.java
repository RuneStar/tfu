// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.nio.ByteBuffer;
import java.util.Arrays;

public abstract class Gl480
{
    public static boolean d;
    private static final boolean g = true;
    
    public static byte[] d(final Object o, final boolean b) {
        if (o == null) {
            return null;
        }
        if (o instanceof byte[]) {
            final byte[] original = (byte[])o;
            if (b) {
                return Arrays.copyOf(original, original.length);
            }
            return original;
        }
        else {
            if (o instanceof ByteBuffer) {
                final ByteBuffer byteBuffer = (ByteBuffer)o;
                final byte[] dst = new byte[byteBuffer.capacity()];
                byteBuffer.position(0);
                byteBuffer.get(dst);
                return dst;
            }
            throw new IllegalArgumentException("Not a ByteBuffer!");
        }
    }
    
    static {
        Gl480.d = false;
    }
    
    public static Object g(final byte[] array, final boolean b) {
        if (array == null) {
            return null;
        }
        if (array.length > 136 && !Gl480.d) {
            final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(array.length);
            allocateDirect.position(0);
            allocateDirect.put(array);
            return allocateDirect;
        }
        if (b) {
            return Arrays.copyOf(array, array.length);
        }
        return array;
    }
    
    private Gl480() {
    }
}
