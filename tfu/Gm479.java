/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public enum Gm479 {
    LIVE("LIVE", 0),
    BUILDLIVE("BUILDLIVE", 3),
    RC("RC", 1),
    WIP("WIP", 2),
    INTBETA("INTBETA", 4);
    
    public final String h;
    public final int s;

    public static Gm479 g(int n) {
        for (Gm479 gm479 : Gm479.values()) {
            if (gm479.s != n) continue;
            return gm479;
        }
        return null;
    }

    private Gm479(String string2, int n2) {
        this.h = string2;
        this.s = n2;
    }
}

