/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.stringtools.general.StringTools;
import tfu.Ly234;

public class Md230 {
    public static final int d = 12;
    private static Ly234 e;
    public static final int g = 1;
    private static final char[] j;
    public static final char[] q;

    public static final int g(Ly234 ly234) {
        if (ly234 == null) {
            return 12;
        }
        switch (ly234) {
            case TRANSFORMERS: {
                return 20;
            }
        }
        return 12;
    }

    public static final boolean d(char c) {
        if (Character.isISOControl(c)) {
            return false;
        }
        if (StringTools.r(c)) {
            return true;
        }
        for (char c2 : q) {
            if (c != c2) continue;
            return true;
        }
        for (char c2 : j) {
            if (c != c2) continue;
            return true;
        }
        return false;
    }

    public static String j(CharSequence charSequence) {
        return Md230.e(charSequence, null);
    }

    public static String e(CharSequence charSequence, Ly234 ly234) {
        int n;
        if (charSequence == null) {
            return null;
        }
        int n2 = charSequence.length();
        for (n = 0; n < n2 && Md230.q(charSequence.charAt(n)); ++n) {
        }
        while (n2 > n && Md230.q(charSequence.charAt(n2 - 1))) {
            --n2;
        }
        int n3 = n2 - n;
        if (n3 < 1 || n3 > Md230.g(ly234)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(n3);
        for (int i = n; i < n2; ++i) {
            char c;
            char c2 = charSequence.charAt(i);
            if (!Md230.d(c2) || (c = Md230.h(c2)) == '\u0000') continue;
            stringBuilder.append(c);
        }
        if (stringBuilder.length() == 0) {
            return null;
        }
        return stringBuilder.toString();
    }

    static {
        q = new char[]{' ', '\u00a0', '_', '-', '\u00e0', '\u00e1', '\u00e2', '\u00e4', '\u00e3', '\u00c0', '\u00c1', '\u00c2', '\u00c4', '\u00c3', '\u00e8', '\u00e9', '\u00ea', '\u00eb', '\u00c8', '\u00c9', '\u00ca', '\u00cb', '\u00ed', '\u00ee', '\u00ef', '\u00cd', '\u00ce', '\u00cf', '\u00f2', '\u00f3', '\u00f4', '\u00f6', '\u00f5', '\u00d2', '\u00d3', '\u00d4', '\u00d6', '\u00d5', '\u00f9', '\u00fa', '\u00fb', '\u00fc', '\u00d9', '\u00da', '\u00db', '\u00dc', '\u00e7', '\u00c7', '\u00ff', '\u0178', '\u00f1', '\u00d1', '\u00df'};
        j = new char[]{'[', ']', '#'};
        e = null;
    }

    public static char h(char c) {
        switch (c) {
            case ' ': 
            case '-': 
            case '_': 
            case '\u00a0': {
                return '_';
            }
            case '#': 
            case '[': 
            case ']': {
                return c;
            }
            case '\u00c0': 
            case '\u00c1': 
            case '\u00c2': 
            case '\u00c3': 
            case '\u00c4': 
            case '\u00e0': 
            case '\u00e1': 
            case '\u00e2': 
            case '\u00e3': 
            case '\u00e4': {
                return 'a';
            }
            case '\u00c8': 
            case '\u00c9': 
            case '\u00ca': 
            case '\u00cb': 
            case '\u00e8': 
            case '\u00e9': 
            case '\u00ea': 
            case '\u00eb': {
                return 'e';
            }
            case '\u00cd': 
            case '\u00ce': 
            case '\u00cf': 
            case '\u00ed': 
            case '\u00ee': 
            case '\u00ef': {
                return 'i';
            }
            case '\u00d2': 
            case '\u00d3': 
            case '\u00d4': 
            case '\u00d5': 
            case '\u00d6': 
            case '\u00f2': 
            case '\u00f3': 
            case '\u00f4': 
            case '\u00f5': 
            case '\u00f6': {
                return 'o';
            }
            case '\u00d9': 
            case '\u00da': 
            case '\u00db': 
            case '\u00dc': 
            case '\u00f9': 
            case '\u00fa': 
            case '\u00fb': 
            case '\u00fc': {
                return 'u';
            }
            case '\u00c7': 
            case '\u00e7': {
                return 'c';
            }
            case '\u00ff': 
            case '\u0178': {
                return 'y';
            }
            case '\u00d1': 
            case '\u00f1': {
                return 'n';
            }
            case '\u00df': {
                return 'b';
            }
        }
        return Character.toLowerCase(c);
    }

    public static final boolean q(char c) {
        return c == '\u00a0' || c == ' ' || c == '_' || c == '-';
    }
}

