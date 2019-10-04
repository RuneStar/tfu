// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.core.stringtools.general;

public class G282
{
    private static char[] d;
    private static char[] g;
    private static int[] q;
    
    private G282() {
    }
    
    public static int g(final char c) {
        if (c >= '\0' && c < G282.q.length) {
            return G282.q[c];
        }
        return -1;
    }
    
    public static byte[] q(final String s) {
        final int length = s.length();
        if (length == 0) {
            return new byte[0];
        }
        final int n = length + 3 & 0xFFFFFFFC;
        int n2 = n / 4 * 3;
        if (n - 2 >= length || g(s.charAt(n - 2)) == -1) {
            n2 -= 2;
        }
        else if (n - 1 >= length || g(s.charAt(n - 1)) == -1) {
            --n2;
        }
        final byte[] array = new byte[n2];
        d(s, array, 0);
        return array;
    }
    
    static {
        G282.g = new char[64];
        for (int i = 0; i < 26; ++i) {
            G282.g[i] = (char)(65 + i);
        }
        for (int j = 26; j < 52; ++j) {
            G282.g[j] = (char)(97 + j - 26);
        }
        for (int k = 52; k < 62; ++k) {
            G282.g[k] = (char)(48 + k - 52);
        }
        G282.g[62] = '+';
        G282.g[63] = '/';
        G282.d = new char[64];
        for (int l = 0; l < 26; ++l) {
            G282.d[l] = (char)(65 + l);
        }
        for (int n = 26; n < 52; ++n) {
            G282.d[n] = (char)(97 + n - 26);
        }
        for (int n2 = 52; n2 < 62; ++n2) {
            G282.d[n2] = (char)(48 + n2 - 52);
        }
        G282.d[62] = '*';
        G282.d[63] = '-';
        G282.q = new int[128];
        for (int n3 = 0; n3 < G282.q.length; ++n3) {
            G282.q[n3] = -1;
        }
        for (int n4 = 65; n4 <= 90; ++n4) {
            G282.q[n4] = n4 - 65;
        }
        for (int n5 = 97; n5 <= 122; ++n5) {
            G282.q[n5] = n5 - 97 + 26;
        }
        for (int n6 = 48; n6 <= 57; ++n6) {
            G282.q[n6] = n6 - 48 + 52;
        }
        G282.q[42] = (G282.q[43] = 62);
        G282.q[45] = (G282.q[47] = 63);
    }
    
    public static int d(final String s, final byte[] array, int n) {
        final int n2 = n;
        for (int length = s.length(), i = 0; i < length; i += 4) {
            final int g = g(s.charAt(i));
            final int n3 = (i + 1 < length) ? g(s.charAt(i + 1)) : -1;
            final int n4 = (i + 2 < length) ? g(s.charAt(i + 2)) : -1;
            final int n5 = (i + 3 < length) ? g(s.charAt(i + 3)) : -1;
            array[n++] = (byte)(g << 2 | n3 >>> 4);
            if (n4 == -1) {
                break;
            }
            array[n++] = (byte)((n3 & 0xF) << 4 | n4 >>> 2);
            if (n5 == -1) {
                break;
            }
            array[n++] = (byte)((n4 & 0x3) << 6 | n5);
        }
        return n - n2;
    }
}
