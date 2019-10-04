// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public abstract class Ds621
{
    private static final boolean s = true;
    
    public static Ds621 r() {
        try {
            return new Dc622();
        }
        catch (Throwable t) {
            return new De623();
        }
    }
    
    public static final int v(final Ds621 ds621, final long n) {
        final long g = ds621.g();
        if (g > 0L) {
            Gi430.g(g);
        }
        return ds621.d(n);
    }
    
    public abstract long g();
    
    public abstract int d(final long p0);
}
