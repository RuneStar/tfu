// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.core.constants;

import java.util.EnumSet;

@Deprecated
public enum D123 implements J204
{
    INTBETA("INTBETA", 7, "INTBETA", 6, new G320[] { G320.HAS_EXTERNAL_ACCESS }), 
    WTWIP("WTWIP", 1, "WTWIP", 3, new G320[] { G320.OFFICE }), 
    WTQA("WTQA", 4, "WTQA", 2, new G320[] { G320.OFFICE, G320.QA }), 
    LOCAL("LOCAL", 0, "LOCAL", 4), 
    WTQA2("WTQA2", 5, "WTQA2", 9, new G320[] { G320.OFFICE, G320.QA }), 
    WTITU("WTITU", 3, "WTITU", 8, new G320[] { G320.OFFICE, G320.HAS_EXTERNAL_ACCESS }), 
    LIVE("LIVE", 8, "LIVE", 0, new G320[] { G320.HAS_EXTERNAL_ACCESS }), 
    WTI("WTI", 2, "WTI", 5, new G320[] { G320.OFFICE, G320.HAS_EXTERNAL_ACCESS }), 
    WTRC("WTRC", 6, "WTRC", 1, new G320[] { G320.OFFICE, G320.HAS_EXTERNAL_ACCESS });
    
    private static final D123[] w;
    private final EnumSet p;
    private final int r;
    private String v;
    @Deprecated
    private String y;
    
    private D123(final String name, final int ordinal, final String v, final int r) {
        this.y = "";
        this.p = EnumSet.noneOf(G320.class);
        this.v = v;
        this.r = r;
    }
    
    private D123(final String name, final int ordinal, final String v, final int r, final G320... array) {
        this.y = "";
        this.p = EnumSet.noneOf(G320.class);
        this.v = v;
        this.r = r;
        for (int length = array.length, i = 0; i < length; ++i) {
            this.p.add(array[i]);
        }
    }
    
    public static boolean d(final D123 d123, final G320 o) {
        return d123.p.contains(o);
    }
    
    @Override
    public int getId() {
        return this.r;
    }
    
    @Override
    public String toString() {
        return this.name().toLowerCase() + this.y;
    }
    
    static {
        w = values();
    }
}
