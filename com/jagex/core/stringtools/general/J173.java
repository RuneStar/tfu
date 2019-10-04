// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.core.stringtools.general;

public class J173
{
    private static final char[] g;
    
    public static byte[] j(final CharSequence charSequence) {
        final int length = charSequence.length();
        final byte[] array = new byte[length];
        for (int i = 0; i < length; ++i) {
            final char char1 = charSequence.charAt(i);
            if ((char1 > '\0' && char1 < '\u0080') || (char1 >= ' ' && char1 <= '\u00ff')) {
                array[i] = (byte)char1;
            }
            else if (char1 == '\u20ac') {
                array[i] = -128;
            }
            else if (char1 == '\u201a') {
                array[i] = -126;
            }
            else if (char1 == '\u0192') {
                array[i] = -125;
            }
            else if (char1 == '\u201e') {
                array[i] = -124;
            }
            else if (char1 == '\u2026') {
                array[i] = -123;
            }
            else if (char1 == '\u2020') {
                array[i] = -122;
            }
            else if (char1 == '\u2021') {
                array[i] = -121;
            }
            else if (char1 == '\u02c6') {
                array[i] = -120;
            }
            else if (char1 == '\u2030') {
                array[i] = -119;
            }
            else if (char1 == '\u0160') {
                array[i] = -118;
            }
            else if (char1 == '\u2039') {
                array[i] = -117;
            }
            else if (char1 == '\u0152') {
                array[i] = -116;
            }
            else if (char1 == '\u017d') {
                array[i] = -114;
            }
            else if (char1 == '\u2018') {
                array[i] = -111;
            }
            else if (char1 == '\u2019') {
                array[i] = -110;
            }
            else if (char1 == '\u201c') {
                array[i] = -109;
            }
            else if (char1 == '\u201d') {
                array[i] = -108;
            }
            else if (char1 == '\u2022') {
                array[i] = -107;
            }
            else if (char1 == '\u2013') {
                array[i] = -106;
            }
            else if (char1 == '\u2014') {
                array[i] = -105;
            }
            else if (char1 == '\u02dc') {
                array[i] = -104;
            }
            else if (char1 == '\u2122') {
                array[i] = -103;
            }
            else if (char1 == '\u0161') {
                array[i] = -102;
            }
            else if (char1 == '\u203a') {
                array[i] = -101;
            }
            else if (char1 == '\u0153') {
                array[i] = -100;
            }
            else if (char1 == '\u017e') {
                array[i] = -98;
            }
            else if (char1 == '\u0178') {
                array[i] = -97;
            }
            else {
                array[i] = 63;
            }
        }
        return array;
    }
    
    public static byte g(final char c) {
        byte b;
        if ((c > '\0' && c < '\u0080') || (c >= ' ' && c <= '\u00ff')) {
            b = (byte)c;
        }
        else if (c == '\u20ac') {
            b = -128;
        }
        else if (c == '\u201a') {
            b = -126;
        }
        else if (c == '\u0192') {
            b = -125;
        }
        else if (c == '\u201e') {
            b = -124;
        }
        else if (c == '\u2026') {
            b = -123;
        }
        else if (c == '\u2020') {
            b = -122;
        }
        else if (c == '\u2021') {
            b = -121;
        }
        else if (c == '\u02c6') {
            b = -120;
        }
        else if (c == '\u2030') {
            b = -119;
        }
        else if (c == '\u0160') {
            b = -118;
        }
        else if (c == '\u2039') {
            b = -117;
        }
        else if (c == '\u0152') {
            b = -116;
        }
        else if (c == '\u017d') {
            b = -114;
        }
        else if (c == '\u2018') {
            b = -111;
        }
        else if (c == '\u2019') {
            b = -110;
        }
        else if (c == '\u201c') {
            b = -109;
        }
        else if (c == '\u201d') {
            b = -108;
        }
        else if (c == '\u2022') {
            b = -107;
        }
        else if (c == '\u2013') {
            b = -106;
        }
        else if (c == '\u2014') {
            b = -105;
        }
        else if (c == '\u02dc') {
            b = -104;
        }
        else if (c == '\u2122') {
            b = -103;
        }
        else if (c == '\u0161') {
            b = -102;
        }
        else if (c == '\u203a') {
            b = -101;
        }
        else if (c == '\u0153') {
            b = -100;
        }
        else if (c == '\u017e') {
            b = -98;
        }
        else if (c == '\u0178') {
            b = -97;
        }
        else {
            b = 63;
        }
        return b;
    }
    
    public static String s(final byte[] array, final int n, final int n2) {
        final char[] value = new char[n2];
        int count = 0;
        for (int i = 0; i < n2; ++i) {
            int n3 = array[n + i] & 0xFF;
            if (n3 != 0) {
                if (n3 >= 128 && n3 < 160) {
                    int n4 = J173.g[n3 - 128];
                    if (n4 == 0) {
                        n4 = 63;
                    }
                    n3 = n4;
                }
                value[count++] = (char)n3;
            }
        }
        return new String(value, 0, count);
    }
    
    public static boolean d(final byte b) {
        final int n = b & 0xFF;
        return n != 0 && (n < 128 || n >= 160 || J173.g[n - 128] != '\0');
    }
    
    public static char q(final byte b) {
        int i = b & 0xFF;
        if (i == 0) {
            throw new IllegalArgumentException("Non cp1252 character 0x" + Integer.toString(i, 16) + " provided");
        }
        if (i >= 128 && i < 160) {
            int n = J173.g[i - 128];
            if (n == 0) {
                n = 63;
            }
            i = n;
        }
        return (char)i;
    }
    
    public static int e(final CharSequence charSequence, final int n, final int n2, final byte[] array, final int n3) {
        final int n4 = n2 - n;
        for (int i = 0; i < n4; ++i) {
            final char char1 = charSequence.charAt(n + i);
            if ((char1 > '\0' && char1 < '\u0080') || (char1 >= ' ' && char1 <= '\u00ff')) {
                array[n3 + i] = (byte)char1;
            }
            else if (char1 == '\u20ac') {
                array[n3 + i] = -128;
            }
            else if (char1 == '\u201a') {
                array[n3 + i] = -126;
            }
            else if (char1 == '\u0192') {
                array[n3 + i] = -125;
            }
            else if (char1 == '\u201e') {
                array[n3 + i] = -124;
            }
            else if (char1 == '\u2026') {
                array[n3 + i] = -123;
            }
            else if (char1 == '\u2020') {
                array[n3 + i] = -122;
            }
            else if (char1 == '\u2021') {
                array[n3 + i] = -121;
            }
            else if (char1 == '\u02c6') {
                array[n3 + i] = -120;
            }
            else if (char1 == '\u2030') {
                array[n3 + i] = -119;
            }
            else if (char1 == '\u0160') {
                array[n3 + i] = -118;
            }
            else if (char1 == '\u2039') {
                array[n3 + i] = -117;
            }
            else if (char1 == '\u0152') {
                array[n3 + i] = -116;
            }
            else if (char1 == '\u017d') {
                array[n3 + i] = -114;
            }
            else if (char1 == '\u2018') {
                array[n3 + i] = -111;
            }
            else if (char1 == '\u2019') {
                array[n3 + i] = -110;
            }
            else if (char1 == '\u201c') {
                array[n3 + i] = -109;
            }
            else if (char1 == '\u201d') {
                array[n3 + i] = -108;
            }
            else if (char1 == '\u2022') {
                array[n3 + i] = -107;
            }
            else if (char1 == '\u2013') {
                array[n3 + i] = -106;
            }
            else if (char1 == '\u2014') {
                array[n3 + i] = -105;
            }
            else if (char1 == '\u02dc') {
                array[n3 + i] = -104;
            }
            else if (char1 == '\u2122') {
                array[n3 + i] = -103;
            }
            else if (char1 == '\u0161') {
                array[n3 + i] = -102;
            }
            else if (char1 == '\u203a') {
                array[n3 + i] = -101;
            }
            else if (char1 == '\u0153') {
                array[n3 + i] = -100;
            }
            else if (char1 == '\u017e') {
                array[n3 + i] = -98;
            }
            else if (char1 == '\u0178') {
                array[n3 + i] = -97;
            }
            else {
                array[n3 + i] = 63;
            }
        }
        return n4;
    }
    
    public static String h(final byte[] array) {
        return s(array, 0, array.length);
    }
    
    static {
        g = new char[] { '\u20ac', '\0', '\u201a', '\u0192', '\u201e', '\u2026', '\u2020', '\u2021', '\u02c6', '\u2030', '\u0160', '\u2039', '\u0152', '\0', '\u017d', '\0', '\0', '\u2018', '\u2019', '\u201c', '\u201d', '\u2022', '\u2013', '\u2014', '\u02dc', '\u2122', '\u0161', '\u203a', '\u0153', '\0', '\u017e', '\u0178' };
    }
    
    private J173() {
    }
}
