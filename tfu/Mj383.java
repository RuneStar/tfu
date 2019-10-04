// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public final class Mj383
{
    private Mj383() {
    }
    
    public static int g(final CharSequence charSequence) {
        final int length = charSequence.length();
        int n = 0;
        for (int i = 0; i < length; ++i) {
            final char char1 = charSequence.charAt(i);
            if (char1 <= '\u007f') {
                ++n;
            }
            else if (char1 <= '\u07ff') {
                n += 2;
            }
            else {
                n += 3;
            }
        }
        return n;
    }
    
    public static int d(final byte[] array, final int n, final CharSequence charSequence) {
        final int length = charSequence.length();
        int n2 = n;
        for (int i = 0; i < length; ++i) {
            final char char1 = charSequence.charAt(i);
            if (char1 <= '\u007f') {
                array[n2++] = (byte)char1;
            }
            else if (char1 <= '\u07ff') {
                array[n2++] = (byte)(0xC0 | char1 >> 6);
                array[n2++] = (byte)(0x80 | (char1 & '?'));
            }
            else {
                array[n2++] = (byte)(0xE0 | char1 >> 12);
                array[n2++] = (byte)(0x80 | (char1 >> 6 & 0x3F));
                array[n2++] = (byte)(0x80 | (char1 & '?'));
            }
        }
        return n2 - n;
    }
    
    public static String q(final byte[] array) {
        return j(array, 0, array.length);
    }
    
    public static String j(final byte[] array, final int n, final int n2) {
        final char[] value = new char[n2];
        int count = 0;
        int i = n;
        final int n3 = n + n2;
        while (i < n3) {
            final int n4 = array[i++] & 0xFF;
            int n5;
            if (n4 < 128) {
                if (n4 == 0) {
                    n5 = 65533;
                }
                else {
                    n5 = n4;
                }
            }
            else if (n4 < 192) {
                n5 = 65533;
            }
            else if (n4 < 224) {
                if (i < n3 && (array[i] & 0xC0) == 0x80) {
                    n5 = ((n4 & 0x1F) << 6 | (array[i++] & 0x3F));
                    if (n5 < 128) {
                        n5 = 65533;
                    }
                }
                else {
                    n5 = 65533;
                }
            }
            else if (n4 < 240) {
                if (i + 1 < n3 && (array[i] & 0xC0) == 0x80 && (array[i + 1] & 0xC0) == 0x80) {
                    n5 = ((n4 & 0xF) << 12 | (array[i++] & 0x3F) << 6 | (array[i++] & 0x3F));
                    if (n5 < 2048) {
                        n5 = 65533;
                    }
                }
                else {
                    n5 = 65533;
                }
            }
            else if (n4 < 248) {
                if (i + 2 < n3 && (array[i] & 0xC0) == 0x80 && (array[i + 1] & 0xC0) == 0x80 && (array[i + 2] & 0xC0) == 0x80) {
                    final int n6 = (n4 & 0x7) << 18 | (array[i++] & 0x3F) << 12 | (array[i++] & 0x3F) << 6 | (array[i++] & 0x3F);
                    if (n6 < 65536 || n6 > 1114111) {
                        n5 = 65533;
                    }
                    else {
                        n5 = 65533;
                    }
                }
                else {
                    n5 = 65533;
                }
            }
            else {
                n5 = 65533;
            }
            value[count++] = (char)n5;
        }
        return new String(value, 0, count);
    }
}
