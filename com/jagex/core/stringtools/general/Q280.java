/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.core.stringtools.general;

public final class Q280 {
    private static long[] d;
    private static final char[] g;

    public static String g(long l) {
        if (l <= 0L || l >= 6582952005840035281L) {
            return null;
        }
        if (l % 37L == 0L) {
            return null;
        }
        int n = 0;
        for (long i = l; i != 0L; i /= 37L) {
            ++n;
        }
        StringBuilder stringBuilder = new StringBuilder(n);
        while (l != 0L) {
            long l2 = l;
            stringBuilder.append(g[(int)(l2 - (l /= 37L) * 37L)]);
        }
        return stringBuilder.reverse().toString();
    }

    public static String d(long l) {
        if (l <= 0L || l >= 6582952005840035281L) {
            return null;
        }
        if (l % 37L == 0L) {
            return null;
        }
        int n = 0;
        for (long i = l; i != 0L; i /= 37L) {
            ++n;
        }
        StringBuilder stringBuilder = new StringBuilder(n);
        while (l != 0L) {
            long l2 = l;
            int n2 = g[(int)(l2 - (l /= 37L) * 37L)];
            if (n2 == 95) {
                int n3 = stringBuilder.length() - 1;
                stringBuilder.setCharAt(n3, Character.toUpperCase(stringBuilder.charAt(n3)));
                n2 = 160;
            }
            stringBuilder.append((char)n2);
        }
        stringBuilder.reverse();
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
        return stringBuilder.toString();
    }

    static {
        g = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        d = new long[12];
        for (int i = 0; i < d.length; ++i) {
            Q280.d[i] = (long)Math.pow(37.0, i);
        }
    }

    private Q280() {
    }
}

