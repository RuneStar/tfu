/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public final class Mj383 {
    private Mj383() {
    }

    public static int g(CharSequence charSequence) {
        int n = charSequence.length();
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            char c = charSequence.charAt(i);
            if (c <= '\u007f') {
                ++n2;
                continue;
            }
            if (c <= '\u07ff') {
                n2 += 2;
                continue;
            }
            n2 += 3;
        }
        return n2;
    }

    public static int d(byte[] arrby, int n, CharSequence charSequence) {
        int n2 = charSequence.length();
        int n3 = n;
        for (int i = 0; i < n2; ++i) {
            char c = charSequence.charAt(i);
            if (c <= '\u007f') {
                arrby[n3++] = (byte)c;
                continue;
            }
            if (c <= '\u07ff') {
                arrby[n3++] = (byte)(0xC0 | c >> 6);
                arrby[n3++] = (byte)(0x80 | c & 0x3F);
                continue;
            }
            arrby[n3++] = (byte)(0xE0 | c >> 12);
            arrby[n3++] = (byte)(0x80 | c >> 6 & 0x3F);
            arrby[n3++] = (byte)(0x80 | c & 0x3F);
        }
        return n3 - n;
    }

    public static String q(byte[] arrby) {
        return Mj383.j(arrby, 0, arrby.length);
    }

    public static String j(byte[] arrby, int n, int n2) {
        char[] arrc = new char[n2];
        int n3 = 0;
        int n4 = n;
        int n5 = n + n2;
        while (n4 < n5) {
            int n6;
            int n7;
            if ((n6 = arrby[n4++] & 0xFF) < 128) {
                n7 = n6 == 0 ? 65533 : n6;
            } else if (n6 < 192) {
                n7 = 65533;
            } else if (n6 < 224) {
                if (n4 < n5 && (arrby[n4] & 0xC0) == 128) {
                    if ((n7 = (n6 & 0x1F) << 6 | arrby[n4++] & 0x3F) < 128) {
                        n7 = 65533;
                    }
                } else {
                    n7 = 65533;
                }
            } else if (n6 < 240) {
                if (n4 + 1 < n5 && (arrby[n4] & 0xC0) == 128 && (arrby[n4 + 1] & 0xC0) == 128) {
                    if ((n7 = (n6 & 0xF) << 12 | (arrby[n4++] & 0x3F) << 6 | arrby[n4++] & 0x3F) < 2048) {
                        n7 = 65533;
                    }
                } else {
                    n7 = 65533;
                }
            } else {
                n7 = n6 < 248 ? (n4 + 2 < n5 && (arrby[n4] & 0xC0) == 128 && (arrby[n4 + 1] & 0xC0) == 128 && (arrby[n4 + 2] & 0xC0) == 128 ? ((n7 = (n6 & 7) << 18 | (arrby[n4++] & 0x3F) << 12 | (arrby[n4++] & 0x3F) << 6 | arrby[n4++] & 0x3F) < 65536 || n7 > 1114111 ? 65533 : 65533) : 65533) : 65533;
            }
            arrc[n3++] = (char)n7;
        }
        return new String(arrc, 0, n3);
    }
}

