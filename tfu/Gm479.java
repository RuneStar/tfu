// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public enum Gm479
{
    BUILDLIVE("BUILDLIVE", 1, "BUILDLIVE", 3), 
    INTBETA("INTBETA", 4, "INTBETA", 4), 
    LIVE("LIVE", 0, "LIVE", 0), 
    WIP("WIP", 3, "WIP", 2), 
    RC("RC", 2, "RC", 1);
    
    public final String h;
    public final int s;
    
    public static Gm479 g(final int n) {
        for (final Gm479 gm479 : values()) {
            if (gm479.s == n) {
                return gm479;
            }
        }
        return null;
    }
    
    private Gm479(final String name, final int ordinal, final String h, final int s) {
        this.h = h;
        this.s = s;
    }
}
