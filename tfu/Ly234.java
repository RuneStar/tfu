// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.constants.J204;

public enum Ly234 implements J204
{
    LEGACY("LEGACY", 7, -1, "legacy", "Legacy", true, new Ly234[] { Ly234.RUNESCAPE, Ly234.FUNORB, Ly234.WAR_OF_LEGENDS, Ly234.EIGHT_REALMS, Ly234.STELLAR_DAWN }), 
    FUNORB("FUNORB", 1, 1, "funorb", "Fun Orb"), 
    EIGHT_REALMS("EIGHT_REALMS", 4, 4, "8realms", "8 Realms"), 
    RUNESCAPE("RUNESCAPE", 0, 0, "runescape", "RuneScape"), 
    TRANSFORMERS("TRANSFORMERS", 5, 5, "transformers", "Transformers Universe"), 
    STELLAR_DAWN("STELLAR_DAWN", 3, 3, "stellardawn", "Stellar Dawn"), 
    WAR_OF_LEGENDS("WAR_OF_LEGENDS", 2, 2, "waroflegends", "War of Legends"), 
    SCRATCH("SCRATCH", 6, 6, "scratch", "Scratch");
    
    public final int l;
    public final String r;
    public final boolean v;
    public final String w;
    public final Ly234[] y;
    
    private Ly234(final String name, final int ordinal, final int l, final String w, final String r) {
        this.l = l;
        this.w = w;
        this.r = r;
        this.v = false;
        this.y = new Ly234[0];
    }
    
    @Override
    public int getId() {
        return this.l;
    }
    
    @Override
    public String toString() {
        return this.r;
    }
    
    private Ly234(final String name, final int ordinal, final int l, final String w, final String r, final boolean v, final Ly234[] y) {
        this.l = l;
        this.w = w;
        this.r = r;
        this.v = v;
        this.y = y;
    }
}
