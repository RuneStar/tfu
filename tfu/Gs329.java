/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Gg3;
import tfu.Ic327;

public class Gs329
extends Gg3 {
    private static final int[] d = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
    private Ic327 g;
    private int j;
    private int q;

    public static void h(Gs329 gs329) {
        gs329.j = gs329.v * 8;
    }

    public Gs329(byte[] arrby) {
        super(arrby);
    }

    public static void g(Gs329 gs329, Ic327 ic327) {
        gs329.g = ic327;
    }

    public static void d(Gs329 gs329, int n) {
        gs329.r[gs329.v++] = (byte)(n + Ic327.d(gs329.g));
    }

    public static void e(Gs329 gs329, byte[] arrby, int n, int n2) {
        for (int i = 0; i < n2; ++i) {
            arrby[i + n] = (byte)(gs329.r[gs329.v++] - Ic327.d(gs329.g));
        }
    }

    public static int j(Gs329 gs329) {
        int n;
        if ((n = gs329.r[gs329.v++] - Ic327.d(gs329.g) & 0xFF) < 128) {
            return n;
        }
        return (n - 128 << 8) + (gs329.r[gs329.v++] - Ic327.d(gs329.g) & 0xFF);
    }

    public Gs329(int n) {
        super(n);
    }

    public static void b(Gs329 gs329) {
        gs329.v = (gs329.j + 7) / 8;
    }

    public int s(int n) {
        if (n > 32) {
            throw new IllegalArgumentException();
        }
        int n2 = this.j >> 3;
        int n3 = 8 - (this.j & 7);
        int n4 = 0;
        this.j += n;
        while (n > n3) {
            n4 += (this.r[n2++] & d[n3]) << n - n3;
            n -= n3;
            n3 = 8;
        }
        n4 = n == n3 ? (n4 += this.r[n2] & d[n3]) : (n4 += this.r[n2] >> n3 - n & d[n]);
        return n4;
    }

    public static boolean q(Gs329 gs329) {
        int n = gs329.r[gs329.v] - Ic327.q(gs329.g) & 0xFF;
        return n >= 128;
    }
}

