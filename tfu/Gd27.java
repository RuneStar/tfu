// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public enum Gd27
{
    STELLARDAWN("STELLARDAWN", 1, "stellardawn", "Stellar Dawn", 1, Ly234.STELLAR_DAWN), 
    SCRATCH("SCRATCH", 4, "scratch", "Scratch", 4, Ly234.SCRATCH), 
    RUNESCAPE("RUNESCAPE", 0, "runescape", "RuneScape", 0, Ly234.RUNESCAPE), 
    TRANSFORMERS("TRANSFORMERS", 3, "transformers", "Transformers", 3, Ly234.TRANSFORMERS), 
    ALTERNATEREALITY("ALTERNATEREALITY", 2, "alternatereality", "AlternateReality", 2, Ly234.RUNESCAPE);
    
    public final int b;
    public final String h;
    public final Ly234 l;
    public final String s;
    
    public static Gd27 g(final int n) {
        for (final Gd27 gd27 : values()) {
            if (gd27.b == n) {
                return gd27;
            }
        }
        return null;
    }
    
    private Gd27(final String name, final int ordinal, final String h, final String s, final int b, final Ly234 l) {
        this.h = h;
        this.s = s;
        this.b = b;
        this.l = l;
    }
}
