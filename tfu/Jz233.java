// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Random;

public class Jz233
{
    private static final Object d;
    private static Random g;
    private static final String[] q;
    
    static {
        d = new Object();
        q = new String[] { "", "0", "00", "000", "0000", "00000" };
    }
    
    public static int j(int n) {
        n = (--n | n >>> 1);
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }
    
    public static boolean h(final int n) {
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
    
    public static int b(int n, int i) {
        int n2 = 0;
        while (i > 0) {
            n2 = (n2 << 1 | (n & 0x1));
            n >>>= 1;
            --i;
        }
        return n2;
    }
    
    public static int l(final int n, final int n2) {
        final int n3 = n >>> 31;
        return (n + n3) / n2 - n3;
    }
    
    public static int w(final int n, final int n2) {
        return (n + (n >>> 31)) % n2 + (n >> 31 & n2 - 1);
    }
    
    public static int r(Random random, final int n) {
        if (random == null) {
            random = Jz233.g;
            if (random == null) {
                synchronized (Jz233.d) {
                    if (Jz233.g == null) {
                        Jz233.g = new Random();
                    }
                    random = Jz233.g;
                }
            }
        }
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (h(n)) {
            return (int)(((long)random.nextInt() & 0xFFFFFFFFL) * n >> 32);
        }
        int i;
        do {
            i = random.nextInt();
        } while (i >= Integer.MIN_VALUE - (int)(4294967296L % n));
        return w(i, n);
    }
    
    public static int e(final int n) {
        final int n2 = n >>> 1;
        final int n3 = n2 | n2 >>> 1;
        final int n4 = n3 | n3 >>> 2;
        final int n5 = n4 | n4 >>> 4;
        final int n6 = n5 | n5 >>> 8;
        return n & ~(n6 | n6 >>> 16);
    }
    
    public static int g(int n, int i) {
        int n2 = 1;
        while (i > 1) {
            if ((i & 0x1) != 0x0) {
                n2 *= n;
            }
            n *= n;
            i >>= 1;
        }
        if (i == 1) {
            return n2 * n;
        }
        return n2;
    }
    
    public static int d(int n, int i) {
        if (i > n) {
            final int n2 = n;
            n = i;
            i = n2;
        }
        while (i != 0) {
            final int n3 = n % i;
            n = i;
            i = n3;
        }
        return n;
    }
}
