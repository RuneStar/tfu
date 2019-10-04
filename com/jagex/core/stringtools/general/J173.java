/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.core.stringtools.general;

public class J173 {
    private static final char[] g = new char[]{'\u20ac', '\u0000', '\u201a', '\u0192', '\u201e', '\u2026', '\u2020', '\u2021', '\u02c6', '\u2030', '\u0160', '\u2039', '\u0152', '\u0000', '\u017d', '\u0000', '\u0000', '\u2018', '\u2019', '\u201c', '\u201d', '\u2022', '\u2013', '\u2014', '\u02dc', '\u2122', '\u0161', '\u203a', '\u0153', '\u0000', '\u017e', '\u0178'};

    public static byte[] j(CharSequence charSequence) {
        int n = charSequence.length();
        byte[] arrby = new byte[n];
        for (int i = 0; i < n; ++i) {
            char c = charSequence.charAt(i);
            arrby[i] = c > '\u0000' && c < '\u0080' || c >= '\u00a0' && c <= '\u00ff' ? (int)c : (c == '\u20ac' ? -128 : (c == '\u201a' ? -126 : (c == '\u0192' ? -125 : (c == '\u201e' ? -124 : (c == '\u2026' ? -123 : (c == '\u2020' ? -122 : (c == '\u2021' ? -121 : (c == '\u02c6' ? -120 : (c == '\u2030' ? -119 : (c == '\u0160' ? -118 : (c == '\u2039' ? -117 : (c == '\u0152' ? -116 : (c == '\u017d' ? -114 : (c == '\u2018' ? -111 : (c == '\u2019' ? -110 : (c == '\u201c' ? -109 : (c == '\u201d' ? -108 : (c == '\u2022' ? -107 : (c == '\u2013' ? -106 : (c == '\u2014' ? -105 : (c == '\u02dc' ? -104 : (c == '\u2122' ? -103 : (c == '\u0161' ? -102 : (c == '\u203a' ? -101 : (c == '\u0153' ? -100 : (c == '\u017e' ? -98 : (c == '\u0178' ? -97 : 63)))))))))))))))))))))))))));
        }
        return arrby;
    }

    public static byte g(char c) {
        int n = c > '\u0000' && c < '\u0080' || c >= '\u00a0' && c <= '\u00ff' ? (int)c : (c == '\u20ac' ? -128 : (c == '\u201a' ? -126 : (c == '\u0192' ? -125 : (c == '\u201e' ? -124 : (c == '\u2026' ? -123 : (c == '\u2020' ? -122 : (c == '\u2021' ? -121 : (c == '\u02c6' ? -120 : (c == '\u2030' ? -119 : (c == '\u0160' ? -118 : (c == '\u2039' ? -117 : (c == '\u0152' ? -116 : (c == '\u017d' ? -114 : (c == '\u2018' ? -111 : (c == '\u2019' ? -110 : (c == '\u201c' ? -109 : (c == '\u201d' ? -108 : (c == '\u2022' ? -107 : (c == '\u2013' ? -106 : (c == '\u2014' ? -105 : (c == '\u02dc' ? -104 : (c == '\u2122' ? -103 : (c == '\u0161' ? -102 : (c == '\u203a' ? -101 : (c == '\u0153' ? -100 : (c == '\u017e' ? -98 : (c == '\u0178' ? -97 : 63)))))))))))))))))))))))))));
        return (byte)n;
    }

    public static String s(byte[] arrby, int n, int n2) {
        char[] arrc = new char[n2];
        int n3 = 0;
        for (int i = 0; i < n2; ++i) {
            int n4 = arrby[n + i] & 0xFF;
            if (n4 == 0) continue;
            if (n4 >= 128 && n4 < 160) {
                int n5 = g[n4 - 128];
                if (n5 == 0) {
                    n5 = 63;
                }
                n4 = n5;
            }
            arrc[n3++] = (char)n4;
        }
        return new String(arrc, 0, n3);
    }

    public static boolean d(byte by) {
        int n = by & 0xFF;
        if (n == 0) {
            return false;
        }
        return n < 128 || n >= 160 || g[n - 128] != '\u0000';
    }

    public static char q(byte by) {
        int n = by & 0xFF;
        if (n == 0) {
            throw new IllegalArgumentException("Non cp1252 character 0x" + Integer.toString(n, 16) + " provided");
        }
        if (n >= 128 && n < 160) {
            int n2 = g[n - 128];
            if (n2 == 0) {
                n2 = 63;
            }
            n = n2;
        }
        return (char)n;
    }

    public static int e(CharSequence charSequence, int n, int n2, byte[] arrby, int n3) {
        int n4 = n2 - n;
        for (int i = 0; i < n4; ++i) {
            char c = charSequence.charAt(n + i);
            arrby[n3 + i] = c > '\u0000' && c < '\u0080' || c >= '\u00a0' && c <= '\u00ff' ? (int)c : (c == '\u20ac' ? -128 : (c == '\u201a' ? -126 : (c == '\u0192' ? -125 : (c == '\u201e' ? -124 : (c == '\u2026' ? -123 : (c == '\u2020' ? -122 : (c == '\u2021' ? -121 : (c == '\u02c6' ? -120 : (c == '\u2030' ? -119 : (c == '\u0160' ? -118 : (c == '\u2039' ? -117 : (c == '\u0152' ? -116 : (c == '\u017d' ? -114 : (c == '\u2018' ? -111 : (c == '\u2019' ? -110 : (c == '\u201c' ? -109 : (c == '\u201d' ? -108 : (c == '\u2022' ? -107 : (c == '\u2013' ? -106 : (c == '\u2014' ? -105 : (c == '\u02dc' ? -104 : (c == '\u2122' ? -103 : (c == '\u0161' ? -102 : (c == '\u203a' ? -101 : (c == '\u0153' ? -100 : (c == '\u017e' ? -98 : (c == '\u0178' ? -97 : 63)))))))))))))))))))))))))));
        }
        return n4;
    }

    public static String h(byte[] arrby) {
        return J173.s(arrby, 0, arrby.length);
    }

    private J173() {
    }
}

