/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.constants.J204;

public enum Ly234 implements J204
{
    RUNESCAPE(0, "runescape", "RuneScape"),
    FUNORB(1, "funorb", "Fun Orb"),
    WAR_OF_LEGENDS(2, "waroflegends", "War of Legends"),
    STELLAR_DAWN(3, "stellardawn", "Stellar Dawn"),
    EIGHT_REALMS(4, "8realms", "8 Realms"),
    TRANSFORMERS(5, "transformers", "Transformers Universe"),
    SCRATCH(6, "scratch", "Scratch"),
    LEGACY(-1, "legacy", "Legacy", true, new Ly234[]{RUNESCAPE, FUNORB, WAR_OF_LEGENDS, EIGHT_REALMS, STELLAR_DAWN});
    
    public final int l;
    public final String r;
    public final boolean v;
    public final String w;
    public final Ly234[] y;

    private Ly234(int n2, String string2, String string3) {
        this.l = n2;
        this.w = string2;
        this.r = string3;
        this.v = false;
        this.y = new Ly234[0];
    }

    @Override
    public int getId() {
        return this.l;
    }

    public String toString() {
        return this.r;
    }

    private Ly234(int n2, String string2, String string3, boolean bl, Ly234[] arrly234) {
        this.l = n2;
        this.w = string2;
        this.r = string3;
        this.v = bl;
        this.y = arrly234;
    }
}

