// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import jaclib.nanotime.QueryPerformanceCounter;

class Dc622 extends Ds621
{
    private long d;
    private int e;
    private long g;
    private int h;
    private long[] j;
    private long q;
    
    @Override
    public long g() {
        this.g += q(this);
        if (this.d > this.g) {
            return (this.d - this.g) / 1000000L;
        }
        return 0L;
    }
    
    private static long q(final Dc622 dc622) {
        final long nanoTime = QueryPerformanceCounter.nanoTime();
        final long n = nanoTime - dc622.q;
        dc622.q = nanoTime;
        if (n > -5000000000L && n < 5000000000L) {
            dc622.j[dc622.e] = n;
            dc622.e = (dc622.e + 1) % 10;
            if (dc622.h < 1) {
                ++dc622.h;
            }
        }
        long n2 = 0L;
        for (int i = 1; i <= dc622.h; ++i) {
            n2 += dc622.j[(dc622.e - i + 10) % 10];
        }
        return n2 / dc622.h;
    }
    
    @Override
    public int d(final long n) {
        if (this.d > this.g) {
            this.q += this.d - this.g;
            this.g += this.d - this.g;
            this.d += n;
            return 1;
        }
        int n2 = 0;
        do {
            ++n2;
            this.d += n;
        } while (n2 < 10 && this.d < this.g);
        if (this.d < this.g) {
            this.d = this.g;
        }
        return n2;
    }
    
    Dc622() {
        this.g = 0L;
        this.d = 0L;
        this.q = 0L;
        this.j = new long[10];
        this.e = 0;
        this.h = 1;
        final long nanoTime = QueryPerformanceCounter.nanoTime();
        this.g = nanoTime;
        this.d = nanoTime;
        if (this.g == 0L) {
            throw new RuntimeException();
        }
    }
}
