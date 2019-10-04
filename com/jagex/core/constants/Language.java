/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.core.constants;

import com.jagex.core.constants.D123;
import com.jagex.core.constants.J204;
import com.jagex.core.constants.Q269;
import java.util.Locale;
import tfu.Bs1;

@Q269(value=8)
@Bs1
public enum Language implements J204
{
    EN("en", "English", D123.LIVE, 0, "GB"),
    DE("de", "German", D123.LIVE, 1, "DE"),
    FR("fr", "French", D123.LIVE, 2, "FR"),
    PT("pt", "Portuguese", D123.LIVE, 3, "BR"),
    NL("nl", "Dutch", D123.WTWIP, 4, "NL"),
    ES("es", "Spanish", D123.LIVE, 5, "ES"),
    ES_MX("es-mx", "Spanish (Latin American)", D123.WTWIP, 6, "MX");
    
    public static final int b = 7;
    private static final Language[] p;
    private final String l;
    private final D123 r;
    public final int v;
    private final String w;
    private final Locale y;

    private Language(String string2, String string3, D123 d123, int n2, String string4) {
        this.l = string2;
        this.w = string3;
        this.r = d123;
        this.v = n2;
        this.y = string4 != null ? new Locale(string2.substring(0, 2), string4) : new Locale(string2.substring(0, 2));
    }

    public static Language q(String string) {
        String string2 = string.toLowerCase(Locale.ENGLISH);
        for (Language language : p) {
            if (language == null || !Language.d(language).equals(string2)) continue;
            return language;
        }
        return null;
    }

    public static String d(Language language) {
        return language.l;
    }

    @Override
    public int getId() {
        return this.v;
    }

    public static Language j(int n) {
        if (n < 0 || n >= p.length) {
            return null;
        }
        return p[n];
    }

    public String toString() {
        return Language.d(this).toLowerCase(Locale.ENGLISH);
    }

    static {
        Language[] arrlanguage = Language.values();
        p = new Language[arrlanguage.length];
        for (Language language : arrlanguage) {
            if (p[language.v] != null) {
                throw new IllegalStateException("Clashing IDs for " + p[language.v] + " and " + language);
            }
            Language.p[language.v] = language;
        }
    }
}

