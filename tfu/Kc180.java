// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class Kc180
{
    private static long d;
    public static final Unsafe g;
    
    public static void b(final long address, final byte x) {
        Kc180.g.putByte(address, x);
    }
    
    public static long g(long n) {
        n += 8L;
        final long allocateMemory = Kc180.g.allocateMemory(n);
        Kc180.g.putLong(allocateMemory, n);
        final long n2 = allocateMemory + 8L;
        Kc180.d += n;
        return n2;
    }
    
    public static void d(long n) {
        n -= 8L;
        final long long1 = Kc180.g.getLong(n);
        Kc180.g.freeMemory(n);
        Kc180.d -= long1;
    }
    
    public static long q() {
        return Kc180.d;
    }
    
    public static void j(final long srcAddress, final long destAddress, final int n) {
        Kc180.g.copyMemory(srcAddress, destAddress, n);
    }
    
    public static int e() {
        return Kc180.g.addressSize();
    }
    
    static {
        try {
            final Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            g = (Unsafe)declaredField.get(null);
        }
        catch (Exception cause) {
            throw new RuntimeException(cause);
        }
    }
    
    public static byte y(final long address) {
        return Kc180.g.getByte(address);
    }
    
    public static void l(final long address, final char x) {
        Kc180.g.putChar(address, x);
    }
    
    public static void r(final long address, final int x) {
        Kc180.g.putInt(address, x);
    }
    
    public static void v(final long address, final float x) {
        Kc180.g.putFloat(address, x);
    }
    
    private Kc180() {
    }
    
    public static short p(final long address) {
        return Kc180.g.getShort(address);
    }
    
    public static int x(final long address) {
        return Kc180.g.getInt(address);
    }
    
    public static float u(final long address) {
        return Kc180.g.getFloat(address);
    }
    
    public static void s(final long address, final long x) {
        Kc180.g.putAddress(address, x);
    }
    
    public static void w(final long address, final short x) {
        Kc180.g.putShort(address, x);
    }
    
    public static long h(final long address) {
        return Kc180.g.getAddress(address);
    }
}
