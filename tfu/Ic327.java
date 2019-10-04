/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Ic327 {
    private static final int d = 256;
    private static final int g = 8;
    private static final int q = 1020;
    private int b;
    private int[] e;
    private int[] h;
    private int j;
    private int l;
    private int s;

    private static final void j(Ic327 ic327) {
        ic327.b += ++ic327.l;
        for (int i = 0; i < 256; ++i) {
            int n;
            int n2 = ic327.h[i];
            ic327.s = (i & 2) == 0 ? ((i & 1) == 0 ? (ic327.s ^= ic327.s << 13) : (ic327.s ^= ic327.s >>> 6)) : ((i & 1) == 0 ? (ic327.s ^= ic327.s << 2) : (ic327.s ^= ic327.s >>> 16));
            ic327.s += ic327.h[i + 128 & 0xFF];
            ic327.h[i] = n = ic327.h[(n2 & 0x3FC) >> 2] + ic327.s + ic327.b;
            ic327.e[i] = ic327.b = ic327.h[(n >> 8 & 0x3FC) >> 2] + n2;
        }
    }

    public Ic327(int[] arrn) {
        this.h = new int[256];
        this.e = new int[256];
        for (int i = 0; i < arrn.length; ++i) {
            this.e[i] = arrn[i];
        }
        Ic327.e(this);
    }

    public static int d(Ic327 ic327) {
        return Ic327.g(ic327);
    }

    public static int q(Ic327 ic327) {
        if (ic327.j == 0) {
            Ic327.j(ic327);
            ic327.j = 256;
        }
        return ic327.e[ic327.j - 1];
    }

    private Ic327() {
    }

    private static final void e(Ic327 ic327) {
        int n;
        int n2 = -1640531527;
        int n3 = -1640531527;
        int n4 = -1640531527;
        int n5 = -1640531527;
        int n6 = -1640531527;
        int n7 = -1640531527;
        int n8 = -1640531527;
        int n9 = -1640531527;
        for (n = 0; n < 4; ++n) {
            n6 += (n9 ^= n8 << 11);
            n8 += n7;
            n5 += (n8 ^= n7 >>> 2);
            n7 += n6;
            n4 += (n7 ^= n6 << 8);
            n6 += n5;
            n3 += (n6 ^= n5 >>> 16);
            n5 += n4;
            n2 += (n5 ^= n4 << 10);
            n4 += n3;
            n9 += (n4 ^= n3 >>> 4);
            n3 += n2;
            n8 += (n3 ^= n2 << 8);
            n2 += n9;
            n7 += (n2 ^= n9 >>> 9);
            n9 += n8;
        }
        for (n = 0; n < 256; n += 8) {
            n9 += ic327.e[n];
            n6 += ic327.e[n + 3];
            n5 += ic327.e[n + 4];
            n4 += ic327.e[n + 5];
            n3 += ic327.e[n + 6];
            n2 += ic327.e[n + 7];
            n8 += (n7 += ic327.e[n + 2]);
            n5 += (n8 ^= n7 >>> 2);
            n7 += (n6 += (n9 ^= (n8 += ic327.e[n + 1]) << 11));
            n4 += (n7 ^= n6 << 8);
            n6 += n5;
            n3 += (n6 ^= n5 >>> 16);
            n5 += n4;
            n2 += (n5 ^= n4 << 10);
            n4 += n3;
            n9 += (n4 ^= n3 >>> 4);
            n3 += n2;
            n8 += (n3 ^= n2 << 8);
            n2 += n9;
            n7 += (n2 ^= n9 >>> 9);
            ic327.h[n] = n9 += n8;
            ic327.h[n + 1] = n8;
            ic327.h[n + 2] = n7;
            ic327.h[n + 3] = n6;
            ic327.h[n + 4] = n5;
            ic327.h[n + 5] = n4;
            ic327.h[n + 6] = n3;
            ic327.h[n + 7] = n2;
        }
        for (n = 0; n < 256; n += 8) {
            n9 += ic327.h[n];
            n6 += ic327.h[n + 3];
            n5 += ic327.h[n + 4];
            n4 += ic327.h[n + 5];
            n3 += ic327.h[n + 6];
            n2 += ic327.h[n + 7];
            n8 += (n7 += ic327.h[n + 2]);
            n5 += (n8 ^= n7 >>> 2);
            n7 += (n6 += (n9 ^= (n8 += ic327.h[n + 1]) << 11));
            n4 += (n7 ^= n6 << 8);
            n6 += n5;
            n3 += (n6 ^= n5 >>> 16);
            n5 += n4;
            n2 += (n5 ^= n4 << 10);
            n4 += n3;
            n9 += (n4 ^= n3 >>> 4);
            n3 += n2;
            n8 += (n3 ^= n2 << 8);
            n2 += n9;
            n7 += (n2 ^= n9 >>> 9);
            ic327.h[n] = n9 += n8;
            ic327.h[n + 1] = n8;
            ic327.h[n + 2] = n7;
            ic327.h[n + 3] = n6;
            ic327.h[n + 4] = n5;
            ic327.h[n + 5] = n4;
            ic327.h[n + 6] = n3;
            ic327.h[n + 7] = n2;
        }
        Ic327.j(ic327);
        ic327.j = 256;
    }

    private static final int g(Ic327 ic327) {
        if (ic327.j == 0) {
            Ic327.j(ic327);
            ic327.j = 256;
        }
        return ic327.e[--ic327.j];
    }
}

