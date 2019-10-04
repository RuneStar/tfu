/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.core.stringtools.general;

import com.jagex.core.stringtools.general.J173;
import tfu.Bs1;

@Bs1
public final class StringTools {
    public static String x(byte[] arrby) {
        if (arrby == null) {
            return "";
        }
        String string = "";
        for (byte by : arrby) {
            string = by >= 128 || by < 32 ? string + "." : string + Character.toChars(by)[0];
        }
        return string;
    }

    public static boolean d(CharSequence charSequence) {
        return StringTools.q(charSequence, 10, true);
    }

    public static boolean q(CharSequence charSequence, int n, boolean bl) {
        if (n < 2 || n > 36) {
            throw new IllegalArgumentException("Invalid radix:" + n);
        }
        boolean bl2 = false;
        boolean bl3 = false;
        int n2 = 0;
        int n3 = charSequence.length();
        for (int i = 0; i < n3; ++i) {
            int n4;
            int n5 = charSequence.charAt(i);
            if (i == 0) {
                if (n5 == 45) {
                    bl2 = true;
                    continue;
                }
                if (n5 == 43 && bl) continue;
            }
            if (n5 >= 48 && n5 <= 57) {
                n5 -= 48;
            } else if (n5 >= 65 && n5 <= 90) {
                n5 -= 55;
            } else if (n5 >= 97 && n5 <= 122) {
                n5 -= 87;
            } else {
                return false;
            }
            if (n5 >= n) {
                return false;
            }
            if (bl2) {
                n5 = -n5;
            }
            if ((n4 = n2 * n + n5) / n != n2) {
                return false;
            }
            n2 = n4;
            bl3 = true;
        }
        return bl3;
    }

    public static int j(CharSequence charSequence) {
        return StringTools.h(charSequence, 10, true);
    }

    public static int b(CharSequence charSequence) {
        int n = charSequence.length();
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            n2 = (n2 << 5) - n2 + J173.g(charSequence.charAt(i));
        }
        return n2;
    }

    public static boolean w(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean r(char c) {
        return c >= '0' && c <= '9' || c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }

    public static String v(String string, char c, String string2) {
        int n;
        int n2 = string.length();
        int n3 = string2.length();
        int n4 = n2;
        int n5 = n3 - 1;
        if (n5 != 0) {
            int n6 = 0;
            while ((n6 = string.indexOf(c, n6)) >= 0) {
                ++n6;
                n4 += n5;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(n4);
        int n7 = 0;
        while ((n = string.indexOf(c, n7)) >= 0) {
            stringBuilder.append(string.substring(n7, n));
            stringBuilder.append(string2);
            n7 = n + 1;
        }
        stringBuilder.append(string.substring(n7));
        return stringBuilder.toString();
    }

    public static String[] p(String string, char c) {
        int n;
        int n2 = 0;
        for (n = 0; n < string.length(); ++n) {
            if (string.charAt(n) != c) continue;
            ++n2;
            while (n < string.length() && string.charAt(n) == c) {
                ++n;
            }
        }
        String[] arrstring = new String[n2 + 1];
        int n3 = 0;
        int n4 = 0;
        for (n = 0; n < n2; ++n) {
            int n5 = n4;
            while (string.charAt(n5) != c) {
                ++n5;
            }
            arrstring[n3++] = string.substring(n4, n5);
            n4 = n5 + 1;
            while (string.charAt(n4) == c) {
                ++n4;
            }
        }
        arrstring[n2] = string.substring(n4);
        return arrstring;
    }

    public static int l(CharSequence charSequence) {
        int n = charSequence.length();
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            n2 = (n2 << 5) - n2 + charSequence.charAt(i);
        }
        return n2;
    }

    private static boolean u(String string, String string2, int n, int n2) {
        int n3 = string.length();
        int n4 = string2.length();
        while (n < n3 && n2 < n4) {
            char c = string.charAt(n);
            char c2 = string2.charAt(n2);
            if (c == '*') {
                if (n == n3 - 1) {
                    return true;
                }
                for (int i = n2; i < n4; ++i) {
                    if (!StringTools.u(string, string2, n + 1, i)) continue;
                    return true;
                }
                return false;
            }
            if (c != '?' && c != c2) {
                return false;
            }
            ++n;
            ++n2;
        }
        return n == n3 && n2 == n4;
    }

    public static int e(CharSequence charSequence, int n) {
        return StringTools.h(charSequence, n, true);
    }

    public static int g(CharSequence charSequence, char c) {
        int n = 0;
        int n2 = charSequence.length();
        for (int i = 0; i < n2; ++i) {
            if (charSequence.charAt(i) != c) continue;
            ++n;
        }
        return n;
    }

    private StringTools() {
    }

    public static String[] y(String string, char c) {
        int n = StringTools.g(string, c);
        String[] arrstring = new String[n + 1];
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < n; ++i) {
            int n4 = n3;
            while (string.charAt(n4) != c) {
                ++n4;
            }
            arrstring[n2++] = string.substring(n3, n4);
            n3 = n4 + 1;
        }
        arrstring[n] = string.substring(n3);
        return arrstring;
    }

    public static int h(CharSequence charSequence, int n, boolean bl) {
        if (n < 2 || n > 36) {
            throw new IllegalArgumentException("Invalid radix:" + n);
        }
        boolean bl2 = false;
        boolean bl3 = false;
        int n2 = 0;
        int n3 = charSequence.length();
        for (int i = 0; i < n3; ++i) {
            int n4;
            int n5 = charSequence.charAt(i);
            if (i == 0) {
                if (n5 == 45) {
                    bl2 = true;
                    continue;
                }
                if (n5 == 43 && bl) continue;
            }
            if (n5 >= 48 && n5 <= 57) {
                n5 -= 48;
            } else if (n5 >= 65 && n5 <= 90) {
                n5 -= 55;
            } else if (n5 >= 97 && n5 <= 122) {
                n5 -= 87;
            } else {
                throw new NumberFormatException();
            }
            if (n5 >= n) {
                throw new NumberFormatException();
            }
            if (bl2) {
                n5 = -n5;
            }
            if ((n4 = n2 * n + n5) / n != n2) {
                throw new NumberFormatException();
            }
            n2 = n4;
            bl3 = true;
        }
        if (!bl3) {
            throw new NumberFormatException();
        }
        return n2;
    }

    public static String s(int n, int n2, boolean bl) {
        if (n2 < 2 || n2 > 36) {
            throw new IllegalArgumentException("Invalid radix:" + n2);
        }
        if (!bl || n < 0) {
            return Integer.toString(n, n2);
        }
        int n3 = 2;
        int n4 = n / n2;
        while (n4 != 0) {
            n4 /= n2;
            ++n3;
        }
        char[] arrc = new char[n3];
        arrc[0] = 43;
        for (int i = n3 - 1; i > 0; --i) {
            int n5 = n;
            int n6 = n5 - (n /= n2) * n2;
            arrc[i] = n6 >= 10 ? (char)(87 + n6) : (char)(48 + n6);
        }
        return new String(arrc);
    }
}

