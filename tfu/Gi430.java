// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Gi430
{
    private static final void d(final long n) {
        try {
            Thread.sleep(n);
        }
        catch (InterruptedException ex) {}
    }
    
    public static final void g(final long n) {
        if (n <= 0L) {
            return;
        }
        if (n % 10L == 0L) {
            d(n - 1L);
            d(1L);
        }
        else {
            d(n);
        }
    }
}
