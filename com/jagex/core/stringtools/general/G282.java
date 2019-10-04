/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.core.stringtools.general;

public class G282 {
    private static char[] d;
    private static char[] g;
    private static int[] q;

    private G282() {
    }

    public static int g(char c) {
        if (c >= '\u0000' && c < q.length) {
            return q[c];
        }
        return -1;
    }

    public static byte[] q(String string) {
        int n = string.length();
        if (n == 0) {
            return new byte[0];
        }
        int n2 = n + 3 & 0xFFFFFFFC;
        int n3 = n2 / 4 * 3;
        if (n2 - 2 >= n || G282.g(string.charAt(n2 - 2)) == -1) {
            n3 -= 2;
        } else if (n2 - 1 >= n || G282.g(string.charAt(n2 - 1)) == -1) {
            --n3;
        }
        byte[] arrby = new byte[n3];
        G282.d(string, arrby, 0);
        return arrby;
    }

    static {
        int n;
        g = new char[64];
        for (n = 0; n < 26; ++n) {
            G282.g[n] = (char)(65 + n);
        }
        for (n = 26; n < 52; ++n) {
            G282.g[n] = (char)(97 + n - 26);
        }
        for (n = 52; n < 62; ++n) {
            G282.g[n] = (char)(48 + n - 52);
        }
        G282.g[62] = 43;
        G282.g[63] = 47;
        d = new char[64];
        for (n = 0; n < 26; ++n) {
            G282.d[n] = (char)(65 + n);
        }
        for (n = 26; n < 52; ++n) {
            G282.d[n] = (char)(97 + n - 26);
        }
        for (n = 52; n < 62; ++n) {
            G282.d[n] = (char)(48 + n - 52);
        }
        G282.d[62] = 42;
        G282.d[63] = 45;
        q = new int[128];
        for (n = 0; n < q.length; ++n) {
            G282.q[n] = -1;
        }
        for (n = 65; n <= 90; ++n) {
            G282.q[n] = n - 65;
        }
        for (n = 97; n <= 122; ++n) {
            G282.q[n] = n - 97 + 26;
        }
        for (n = 48; n <= 57; ++n) {
            G282.q[n] = n - 48 + 52;
        }
        G282.q[43] = 62;
        G282.q[42] = 62;
        G282.q[47] = 63;
        G282.q[45] = 63;
    }

    public static int d(String string, byte[] arrby, int n) {
        int n2 = n;
        int n3 = string.length();
        for (int i = 0; i < n3; i += 4) {
            int n4 = G282.g(string.charAt(i));
            int n5 = i + 1 < n3 ? G282.g(string.charAt(i + 1)) : -1;
            int n6 = i + 2 < n3 ? G282.g(string.charAt(i + 2)) : -1;
            int n7 = i + 3 < n3 ? G282.g(string.charAt(i + 3)) : -1;
            arrby[n++] = (byte)(n4 << 2 | n5 >>> 4);
            if (n6 == -1) break;
            arrby[n++] = (byte)((n5 & 0xF) << 4 | n6 >>> 2);
            if (n7 == -1) break;
            arrby[n++] = (byte)((n6 & 3) << 6 | n7);
        }
        return n - n2;
    }
}

