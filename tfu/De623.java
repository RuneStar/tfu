/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Ds621;

class De623
extends Ds621 {
    private long d = 0L;
    private int e = 0;
    private long g = 0L;
    private int h = 1;
    private long[] j = new long[10];
    private long q = 0L;

    @Override
    public long g() {
        this.g += De623.q(this);
        if (this.d > this.g) {
            return (this.d - this.g) / 1000000L;
        }
        return 0L;
    }

    De623() {
        this.g = System.nanoTime();
        this.d = System.nanoTime();
    }

    @Override
    public int d(long l) {
        if (this.d > this.g) {
            this.q += this.d - this.g;
            this.g += this.d - this.g;
            this.d += l;
            return 1;
        }
        int n = 0;
        do {
            this.d += l;
        } while (++n < 10 && this.d < this.g);
        if (this.d < this.g) {
            this.d = this.g;
        }
        return n;
    }

    private static long q(De623 de623) {
        long l = System.nanoTime();
        long l2 = l - de623.q;
        de623.q = l;
        if (l2 > -5000000000L && l2 < 5000000000L) {
            de623.j[de623.e] = l2;
            de623.e = (de623.e + 1) % 10;
            if (de623.h < 1) {
                ++de623.h;
            }
        }
        long l3 = 0L;
        for (int i = 1; i <= de623.h; ++i) {
            l3 += de623.j[(de623.e - i + 10) % 10];
        }
        return l3 / (long)de623.h;
    }
}

