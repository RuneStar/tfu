/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.core.stringtools.general;

import com.jagex.core.constants.Language;

public class D281 {
    private static final String[] d = new String[]{"\u00a0B", "\u00a0KiB", "\u00a0MiB", "\u00a0GiB", "\u00a0TiB", "\u00a0PiB", "\u00a0EiB"};
    public static final int e = 2;
    private static final String g = "\u00a0";
    public static final int j = 1;
    public static final int q = 0;

    private D281() {
    }

    public static String g(long l, int n, boolean bl, Language language) {
        int n2;
        int n3;
        char c = ',';
        char c2 = '.';
        if (language == Language.EN) {
            c = '.';
            c2 = ',';
        }
        if (language == Language.FR) {
            c2 = '\u00a0';
        }
        boolean bl2 = false;
        if (l < 0L) {
            bl2 = true;
            l = -l;
        }
        StringBuilder stringBuilder = new StringBuilder(26);
        if (n > 0) {
            for (n2 = 0; n2 < n; ++n2) {
                n3 = (int)l;
                stringBuilder.append((char)(48 + n3 - (int)(l /= 10L) * 10));
            }
            stringBuilder.append(c);
        }
        n2 = 0;
        do {
            n3 = (int)l;
            stringBuilder.append((char)(48 + n3 - (int)(l /= 10L) * 10));
            if (l == 0L) break;
            if (!bl || ++n2 % 3 != 0) continue;
            stringBuilder.append(c2);
        } while (true);
        if (bl2) {
            stringBuilder.append('-');
        }
        return stringBuilder.reverse().toString();
    }
}

