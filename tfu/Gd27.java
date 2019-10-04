/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Ly234;

public enum Gd27 {
    RUNESCAPE("runescape", "RuneScape", 0, Ly234.RUNESCAPE),
    STELLARDAWN("stellardawn", "Stellar Dawn", 1, Ly234.STELLAR_DAWN),
    ALTERNATEREALITY("alternatereality", "AlternateReality", 2, Ly234.RUNESCAPE),
    TRANSFORMERS("transformers", "Transformers", 3, Ly234.TRANSFORMERS),
    SCRATCH("scratch", "Scratch", 4, Ly234.SCRATCH);
    
    public final int b;
    public final String h;
    public final Ly234 l;
    public final String s;

    public static Gd27 g(int n) {
        for (Gd27 gd27 : Gd27.values()) {
            if (gd27.b != n) continue;
            return gd27;
        }
        return null;
    }

    private Gd27(String string2, String string3, int n2, Ly234 ly234) {
        this.h = string2;
        this.s = string3;
        this.b = n2;
        this.l = ly234;
    }
}

