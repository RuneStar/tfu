// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class De623 extends Ds621
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
    
    De623() {
        this.g = 0L;
        this.d = 0L;
        this.q = 0L;
        this.j = new long[10];
        this.e = 0;
        this.h = 1;
        this.g = System.nanoTime();
        this.d = System.nanoTime();
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
    
    private static long q(final De623 de623) {
        final long nanoTime = System.nanoTime();
        final long n = nanoTime - de623.q;
        de623.q = nanoTime;
        if (n > -5000000000L && n < 5000000000L) {
            de623.j[de623.e] = n;
            de623.e = (de623.e + 1) % 10;
            if (de623.h < 1) {
                ++de623.h;
            }
        }
        long n2 = 0L;
        for (int i = 1; i <= de623.h; ++i) {
            n2 += de623.j[(de623.e - i + 10) % 10];
        }
        return n2 / de623.h;
    }
}
