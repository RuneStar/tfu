/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.core.constants;

import com.jagex.core.constants.G320;
import com.jagex.core.constants.J204;
import java.util.EnumSet;

@Deprecated
public enum D123 implements J204
{
    LOCAL("LOCAL", 4),
    WTWIP("WTWIP", 3, G320.OFFICE),
    WTI("WTI", 5, G320.OFFICE, G320.HAS_EXTERNAL_ACCESS),
    WTITU("WTITU", 8, G320.OFFICE, G320.HAS_EXTERNAL_ACCESS),
    WTQA("WTQA", 2, G320.OFFICE, G320.QA),
    WTQA2("WTQA2", 9, G320.OFFICE, G320.QA),
    WTRC("WTRC", 1, G320.OFFICE, G320.HAS_EXTERNAL_ACCESS),
    INTBETA("INTBETA", 6, G320.HAS_EXTERNAL_ACCESS),
    LIVE("LIVE", 0, G320.HAS_EXTERNAL_ACCESS);
    
    private static final D123[] w;
    private final EnumSet p = EnumSet.noneOf(G320.class);
    private final int r;
    private String v;
    private String y = "";

    private D123(String string2, int n2) {
        this.v = string2;
        this.r = n2;
    }

    private D123(String string2, int n2, G320 ... arrg320) {
        this.v = string2;
        this.r = n2;
        for (G320 g320 : arrg320) {
            this.p.add(g320);
        }
    }

    public static boolean d(D123 d123, G320 g320) {
        return d123.p.contains((Object)g320);
    }

    @Override
    public int getId() {
        return this.r;
    }

    public String toString() {
        return this.name().toLowerCase() + this.y;
    }

    static {
        w = D123.values();
    }
}

