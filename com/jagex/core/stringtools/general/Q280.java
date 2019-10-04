// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.core.stringtools.general;

public final class Q280
{
    private static long[] d;
    private static final char[] g;
    
    public static String g(long n) {
        if (n <= 0L || n >= 6582952005840035281L) {
            return null;
        }
        if (n % 37L == 0L) {
            return null;
        }
        int capacity = 0;
        for (long n2 = n; n2 != 0L; n2 /= 37L) {
            ++capacity;
        }
        final StringBuilder sb = new StringBuilder(capacity);
        while (n != 0L) {
            final long n3 = n;
            n /= 37L;
            sb.append(Q280.g[(int)(n3 - n * 37L)]);
        }
        return sb.reverse().toString();
    }
    
    public static String d(long n) {
        if (n <= 0L || n >= 6582952005840035281L) {
            return null;
        }
        if (n % 37L == 0L) {
            return null;
        }
        int capacity = 0;
        for (long n2 = n; n2 != 0L; n2 /= 37L) {
            ++capacity;
        }
        final StringBuilder sb = new StringBuilder(capacity);
        while (n != 0L) {
            final long n3 = n;
            n /= 37L;
            char c = Q280.g[(int)(n3 - n * 37L)];
            if (c == '_') {
                final int n4 = sb.length() - 1;
                sb.setCharAt(n4, Character.toUpperCase(sb.charAt(n4)));
                c = ' ';
            }
            sb.append(c);
        }
        sb.reverse();
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }
    
    static {
        g = new char[] { '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        Q280.d = new long[12];
        for (int i = 0; i < Q280.d.length; ++i) {
            Q280.d[i] = (long)Math.pow(37.0, i);
        }
    }
    
    private Q280() {
    }
}
