/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import jaclib.nanotime.QueryPerformanceCounter;
import tfu.Ds621;

class Dc622
extends Ds621 {
    private long d = 0L;
    private int e = 0;
    private long g = 0L;
    private int h = 1;
    private long[] j = new long[10];
    private long q = 0L;

    @Override
    public long g() {
        this.g += Dc622.q(this);
        if (this.d > this.g) {
            return (this.d - this.g) / 1000000L;
        }
        return 0L;
    }

    private static long q(Dc622 dc622) {
        long l = QueryPerformanceCounter.nanoTime();
        long l2 = l - dc622.q;
        dc622.q = l;
        if (l2 > -5000000000L && l2 < 5000000000L) {
            dc622.j[dc622.e] = l2;
            dc622.e = (dc622.e + 1) % 10;
            if (dc622.h < 1) {
                ++dc622.h;
            }
        }
        long l3 = 0L;
        for (int i = 1; i <= dc622.h; ++i) {
            l3 += dc622.j[(dc622.e - i + 10) % 10];
        }
        return l3 / (long)dc622.h;
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

    Dc622() {
        this.d = this.g = QueryPerformanceCounter.nanoTime();
        if (this.g == 0L) {
            throw new RuntimeException();
        }
    }
}

