// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.core.constants;

import java.util.Locale;
import tfu.Bs1;

@Q269(8)
@Bs1
public enum Language implements J204
{
    DE("DE", 1, "de", "German", D123.LIVE, 1, "DE"), 
    NL("NL", 4, "nl", "Dutch", D123.WTWIP, 4, "NL"), 
    EN("EN", 0, "en", "English", D123.LIVE, 0, "GB"), 
    ES("ES", 5, "es", "Spanish", D123.LIVE, 5, "ES"), 
    PT("PT", 3, "pt", "Portuguese", D123.LIVE, 3, "BR"), 
    FR("FR", 2, "fr", "French", D123.LIVE, 2, "FR"), 
    ES_MX("ES_MX", 6, "es-mx", "Spanish (Latin American)", D123.WTWIP, 6, "MX");
    
    public static final int b = 7;
    private static final Language[] p;
    private final String l;
    private final D123 r;
    public final int v;
    private final String w;
    private final Locale y;
    
    private Language(final String name, final int ordinal, final String l, final String w, final D123 r, final int v, final String country) {
        this.l = l;
        this.w = w;
        this.r = r;
        this.v = v;
        if (country != null) {
            this.y = new Locale(l.substring(0, 2), country);
        }
        else {
            this.y = new Locale(l.substring(0, 2));
        }
    }
    
    public static Language q(final String s) {
        final String lowerCase = s.toLowerCase(Locale.ENGLISH);
        for (final Language language : Language.p) {
            if (language != null && d(language).equals(lowerCase)) {
                return language;
            }
        }
        return null;
    }
    
    public static String d(final Language language) {
        return language.l;
    }
    
    @Override
    public int getId() {
        return this.v;
    }
    
    public static Language j(final int n) {
        if (n < 0 || n >= Language.p.length) {
            return null;
        }
        return Language.p[n];
    }
    
    @Override
    public String toString() {
        return d(this).toLowerCase(Locale.ENGLISH);
    }
    
    static {
        final Language[] values = values();
        p = new Language[values.length];
        for (final Language obj : values) {
            if (Language.p[obj.v] != null) {
                throw new IllegalStateException("Clashing IDs for " + Language.p[obj.v] + " and " + obj);
            }
            Language.p[obj.v] = obj;
        }
    }
}
