/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Random;

public class Jz233 {
    private static final Object d = new Object();
    private static Random g;
    private static final String[] q;

    static {
        q = new String[]{"", "0", "00", "000", "0000", "00000"};
    }

    public static int j(int n) {
        --n;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    public static boolean h(int n) {
        return (n & -n) == n;
    }

    public static int s(int n) {
        int n2 = 0;
        if (n < 0 || n >= 65536) {
            n >>>= 16;
            n2 += 16;
        }
        if (n >= 256) {
            n >>>= 8;
            n2 += 8;
        }
        if (n >= 16) {
            n >>>= 4;
            n2 += 4;
        }
        if (n >= 4) {
            n >>>= 2;
            n2 += 2;
        }
        if (n >= 1) {
            n >>>= 1;
            ++n2;
        }
        return n2 + n;
    }

    public static int b(int n, int n2) {
        int n3 = 0;
        while (n2 > 0) {
            n3 = n3 << 1 | n & 1;
            n >>>= 1;
            --n2;
        }
        return n3;
    }

    public static int l(int n, int n2) {
        int n3 = n >>> 31;
        return (n + n3) / n2 - n3;
    }

    public static int w(int n, int n2) {
        int n3 = n >> 31 & n2 - 1;
        return (n + (n >>> 31)) % n2 + n3;
    }

    public static int r(Random random, int n) {
        int n2;
        if (random == null && (random = g) == null) {
            Object object = d;
            synchronized (object) {
                if (g == null) {
                    g = new Random();
                }
                random = g;
            }
        }
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (Jz233.h(n)) {
            return (int)(((long)random.nextInt() & 0xFFFFFFFFL) * (long)n >> 32);
        }
        int n3 = Integer.MIN_VALUE - (int)(0x100000000L % (long)n);
        while ((n2 = random.nextInt()) >= n3) {
        }
        return Jz233.w(n2, n);
    }

    public static int e(int n) {
        int n2 = n >>> 1;
        n2 |= n2 >>> 1;
        n2 |= n2 >>> 2;
        n2 |= n2 >>> 4;
        n2 |= n2 >>> 8;
        n2 |= n2 >>> 16;
        return n & ~n2;
    }

    public static int g(int n, int n2) {
        int n3 = 1;
        while (n2 > 1) {
            if ((n2 & 1) != 0) {
                n3 *= n;
            }
            n *= n;
            n2 >>= 1;
        }
        if (n2 == 1) {
            return n3 * n;
        }
        return n3;
    }

    public static int d(int n, int n2) {
        int n3;
        if (n2 > n) {
            n3 = n;
            n = n2;
            n2 = n3;
        }
        while (n2 != 0) {
            n3 = n % n2;
            n = n2;
            n2 = n3;
        }
        return n;
    }
}

