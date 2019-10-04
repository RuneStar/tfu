// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.stringtools.general.StringTools;

public class Md230
{
    @Deprecated
    public static final int d = 12;
    private static Ly234 e;
    public static final int g = 1;
    private static final char[] j;
    public static final char[] q;
    
    public static final int g(final Ly234 ly234) {
        if (ly234 == null) {
            return 12;
        }
        switch (Li493.g[ly234.ordinal()]) {
            case 1: {
                return 20;
            }
            default: {
                return 12;
            }
        }
    }
    
    public static final boolean d(final char ch) {
        if (Character.isISOControl(ch)) {
            return false;
        }
        if (StringTools.r(ch)) {
            return true;
        }
        final char[] q = Md230.q;
        for (int length = q.length, i = 0; i < length; ++i) {
            if (ch == q[i]) {
                return true;
            }
        }
        final char[] j = Md230.j;
        for (int length2 = j.length, k = 0; k < length2; ++k) {
            if (ch == j[k]) {
                return true;
            }
        }
        return false;
    }
    
    @Deprecated
    public static String j(final CharSequence charSequence) {
        return e(charSequence, null);
    }
    
    public static String e(final CharSequence charSequence, final Ly234 ly234) {
        if (charSequence == null) {
            return null;
        }
        int n;
        int length;
        for (n = 0, length = charSequence.length(); n < length && q(charSequence.charAt(n)); ++n) {}
        while (length > n && q(charSequence.charAt(length - 1))) {
            --length;
        }
        final int capacity = length - n;
        if (capacity < 1 || capacity > g(ly234)) {
            return null;
        }
        final StringBuilder sb = new StringBuilder(capacity);
        for (int i = n; i < length; ++i) {
            final char char1 = charSequence.charAt(i);
            if (d(char1)) {
                final char h = h(char1);
                if (h != '\0') {
                    sb.append(h);
                }
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }
    
    static {
        q = new char[] { ' ', ' ', '_', '-', '\u00e0', '\u00e1', '\u00e2', '\u00e4', '\u00e3', '\u00c0', '\u00c1', '\u00c2', '\u00c4', '\u00c3', '\u00e8', '\u00e9', '\u00ea', '\u00eb', '\u00c8', '\u00c9', '\u00ca', '\u00cb', '\u00ed', '\u00ee', '\u00ef', '\u00cd', '\u00ce', '\u00cf', '\u00f2', '\u00f3', '\u00f4', '\u00f6', '\u00f5', '\u00d2', '\u00d3', '\u00d4', '\u00d6', '\u00d5', '\u00f9', '\u00fa', '\u00fb', '\u00fc', '\u00d9', '\u00da', '\u00db', '\u00dc', '\u00e7', '\u00c7', '\u00ff', '\u0178', '\u00f1', '\u00d1', '\u00df' };
        j = new char[] { '[', ']', '#' };
        Md230.e = null;
    }
    
    public static char h(final char ch) {
        switch (ch) {
            case ' ':
            case '-':
            case '_':
            case ' ': {
                return '_';
            }
            case '#':
            case '[':
            case ']': {
                return ch;
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
            default: {
                return Character.toLowerCase(ch);
            }
        }
    }
    
    public static final boolean q(final char c) {
        return c == ' ' || c == ' ' || c == '_' || c == '-';
    }
}
