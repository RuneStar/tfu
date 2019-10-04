// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.core.stringtools.general;

import com.jagex.core.constants.Language;

public class D281
{
    private static final String[] d;
    public static final int e = 2;
    private static final String g = " ";
    public static final int j = 1;
    public static final int q = 0;
    
    static {
        d = new String[] { " B", " KiB", " MiB", " GiB", " TiB", " PiB", " EiB" };
    }
    
    private D281() {
    }
    
    public static String g(long n, final int n2, final boolean b, final Language language) {
        char c = ',';
        char c2 = '.';
        if (language == Language.EN) {
            c = '.';
            c2 = ',';
        }
        if (language == Language.FR) {
            c2 = ' ';
        }
        boolean b2 = false;
        if (n < 0L) {
            b2 = true;
            n = -n;
        }
        final StringBuilder sb = new StringBuilder(26);
        if (n2 > 0) {
            for (int i = 0; i < n2; ++i) {
                final int n3 = (int)n;
                n /= 10L;
                sb.append((char)(48 + n3 - (int)n * 10));
            }
            sb.append(c);
        }
        int n4 = 0;
        while (true) {
            final int n5 = (int)n;
            n /= 10L;
            sb.append((char)(48 + n5 - (int)n * 10));
            if (n == 0L) {
                break;
            }
            if (!b || ++n4 % 3 != 0) {
                continue;
            }
            sb.append(c2);
        }
        if (b2) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}
