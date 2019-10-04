/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class Kc180 {
    private static long d;
    public static final Unsafe g;

    public static void b(long l, byte by) {
        g.putByte(l, by);
    }

    public static long g(long l) {
        long l2 = g.allocateMemory(l += 8L);
        g.putLong(l2, l);
        d += l;
        return l2 += 8L;
    }

    public static void d(long l) {
        long l2 = g.getLong(l -= 8L);
        g.freeMemory(l);
        d -= l2;
    }

    public static long q() {
        return d;
    }

    public static void j(long l, long l2, int n) {
        g.copyMemory(l, l2, n);
    }

    public static int e() {
        return g.addressSize();
    }

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            g = (Unsafe)field.get(null);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static byte y(long l) {
        return g.getByte(l);
    }

    public static void l(long l, char c) {
        g.putChar(l, c);
    }

    public static void r(long l, int n) {
        g.putInt(l, n);
    }

    public static void v(long l, float f) {
        g.putFloat(l, f);
    }

    private Kc180() {
    }

    public static short p(long l) {
        return g.getShort(l);
    }

    public static int x(long l) {
        return g.getInt(l);
    }

    public static float u(long l) {
        return g.getFloat(l);
    }

    public static void s(long l, long l2) {
        g.putAddress(l, l2);
    }

    public static void w(long l, short s) {
        g.putShort(l, s);
    }

    public static long h(long l) {
        return g.getAddress(l);
    }
}

