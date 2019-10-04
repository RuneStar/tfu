// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public final class Gz143
{
    private static long d;
    private static final boolean g = true;
    private static long q;
    
    private Gz143() {
    }
    
    public static final synchronized long g() {
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < Gz143.d) {
            System.out.println("WARNING: safetime: time jumped back by " + (Gz143.d - currentTimeMillis) + " ms");
            Gz143.q += Gz143.d - currentTimeMillis;
        }
        Gz143.d = currentTimeMillis;
        return currentTimeMillis + Gz143.q;
    }
}
