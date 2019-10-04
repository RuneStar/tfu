// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.core.stringtools.general;

import tfu.Bs1;

@Bs1
public final class StringTools
{
    public static String x(final byte[] array) {
        if (array == null) {
            return "";
        }
        String s = "";
        for (final byte codePoint : array) {
            if (codePoint >= 128 || codePoint < 32) {
                s += ".";
            }
            else {
                s += Character.toChars(codePoint)[0];
            }
        }
        return s;
    }
    
    public static boolean d(final CharSequence charSequence) {
        return q(charSequence, 10, true);
    }
    
    public static boolean q(final CharSequence charSequence, final int i, final boolean b) {
        if (i < 2 || i > 36) {
            throw new IllegalArgumentException("Invalid radix:" + i);
        }
        boolean b2 = false;
        boolean b3 = false;
        int n = 0;
        for (int length = charSequence.length(), j = 0; j < length; ++j) {
            int char1 = charSequence.charAt(j);
            if (j == 0) {
                if (char1 == 45) {
                    b2 = true;
                    continue;
                }
                if (char1 == 43 && b) {
                    continue;
                }
            }
            if (char1 >= 48 && char1 <= 57) {
                char1 -= 48;
            }
            else if (char1 >= 65 && char1 <= 90) {
                char1 -= 55;
            }
            else {
                if (char1 < 97 || char1 > 122) {
                    return false;
                }
                char1 -= 87;
            }
            if (char1 >= i) {
                return false;
            }
            if (b2) {
                char1 = -char1;
            }
            final int n2 = n * i + char1;
            if (n2 / i != n) {
                return false;
            }
            n = n2;
            b3 = true;
        }
        return b3;
    }
    
    public static int j(final CharSequence charSequence) {
        return h(charSequence, 10, true);
    }
    
    @Deprecated
    public static int b(final CharSequence charSequence) {
        final int length = charSequence.length();
        int n = 0;
        for (int i = 0; i < length; ++i) {
            n = (n << 5) - n + J173.g(charSequence.charAt(i));
        }
        return n;
    }
    
    public static boolean w(final char c) {
        return c >= '0' && c <= '9';
    }
    
    public static boolean r(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
    
    public static String v(final String s, final char c, final String str) {
        final int length = s.length();
        final int length2 = str.length();
        int capacity = length;
        final int n = length2 - 1;
        if (n != 0) {
            int index = 0;
            while (true) {
                index = s.indexOf(c, index);
                if (index < 0) {
                    break;
                }
                ++index;
                capacity += n;
            }
        }
        final StringBuilder sb = new StringBuilder(capacity);
        int beginIndex = 0;
        while (true) {
            final int index2 = s.indexOf(c, beginIndex);
            if (index2 < 0) {
                break;
            }
            sb.append(s.substring(beginIndex, index2));
            sb.append(str);
            beginIndex = index2 + 1;
        }
        sb.append(s.substring(beginIndex));
        return sb.toString();
    }
    
    public static String[] p(final String s, final char c) {
        int n = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                ++n;
                while (i < s.length() && s.charAt(i) == c) {
                    ++i;
                }
            }
        }
        final String[] array = new String[n + 1];
        int n2 = 0;
        int beginIndex = 0;
        for (int j = 0; j < n; ++j) {
            int n3;
            for (n3 = beginIndex; s.charAt(n3) != c; ++n3) {}
            array[n2++] = s.substring(beginIndex, n3);
            for (beginIndex = n3 + 1; s.charAt(beginIndex) == c; ++beginIndex) {}
        }
        array[n] = s.substring(beginIndex);
        return array;
    }
    
    public static int l(final CharSequence charSequence) {
        final int length = charSequence.length();
        int n = 0;
        for (int i = 0; i < length; ++i) {
            n = (n << 5) - n + charSequence.charAt(i);
        }
        return n;
    }
    
    private static boolean u(final String s, final String s2, int index, int index2) {
        final int length = s.length();
        final int length2 = s2.length();
        while (index < length && index2 < length2) {
            final char char1 = s.charAt(index);
            final char char2 = s2.charAt(index2);
            if (char1 == '*') {
                if (index == length - 1) {
                    return true;
                }
                for (int i = index2; i < length2; ++i) {
                    if (u(s, s2, index + 1, i)) {
                        return true;
                    }
                }
                return false;
            }
            else {
                if (char1 != '?' && char1 != char2) {
                    return false;
                }
                ++index;
                ++index2;
            }
        }
        return index == length && index2 == length2;
    }
    
    public static int e(final CharSequence charSequence, final int n) {
        return h(charSequence, n, true);
    }
    
    public static int g(final CharSequence charSequence, final char c) {
        int n = 0;
        for (int length = charSequence.length(), i = 0; i < length; ++i) {
            if (charSequence.charAt(i) == c) {
                ++n;
            }
        }
        return n;
    }
    
    private StringTools() {
    }
    
    public static String[] y(final String s, final char c) {
        final int g = g(s, c);
        final String[] array = new String[g + 1];
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < g; ++i) {
            int n3;
            for (n3 = n2; s.charAt(n3) != c; ++n3) {}
            array[n++] = s.substring(n2, n3);
            n2 = n3 + 1;
        }
        array[g] = s.substring(n2);
        return array;
    }
    
    public static int h(final CharSequence charSequence, final int i, final boolean b) {
        if (i < 2 || i > 36) {
            throw new IllegalArgumentException("Invalid radix:" + i);
        }
        boolean b2 = false;
        boolean b3 = false;
        int n = 0;
        for (int length = charSequence.length(), j = 0; j < length; ++j) {
            int char1 = charSequence.charAt(j);
            if (j == 0) {
                if (char1 == 45) {
                    b2 = true;
                    continue;
                }
                if (char1 == 43 && b) {
                    continue;
                }
            }
            if (char1 >= 48 && char1 <= 57) {
                char1 -= 48;
            }
            else if (char1 >= 65 && char1 <= 90) {
                char1 -= 55;
            }
            else {
                if (char1 < 97 || char1 > 122) {
                    throw new NumberFormatException();
                }
                char1 -= 87;
            }
            if (char1 >= i) {
                throw new NumberFormatException();
            }
            if (b2) {
                char1 = -char1;
            }
            final int n2 = n * i + char1;
            if (n2 / i != n) {
                throw new NumberFormatException();
            }
            n = n2;
            b3 = true;
        }
        if (!b3) {
            throw new NumberFormatException();
        }
        return n;
    }
    
    public static String s(int i, final int n, final boolean b) {
        if (n < 2 || n > 36) {
            throw new IllegalArgumentException("Invalid radix:" + n);
        }
        if (!b || i < 0) {
            return Integer.toString(i, n);
        }
        int n2 = 2;
        for (int j = i / n; j != 0; j /= n, ++n2) {}
        final char[] value = new char[n2];
        value[0] = '+';
        for (int k = n2 - 1; k > 0; --k) {
            final int n3 = i;
            i /= n;
            final int n4 = n3 - i * n;
            if (n4 >= 10) {
                value[k] = (char)(87 + n4);
            }
            else {
                value[k] = (char)(48 + n4);
            }
        }
        return new String(value);
    }
}
