/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.stringtools.general.J173;

public class Mi507 {
    private Mi507() {
    }

    public static String d(CharSequence charSequence) {
        int n = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            char c = charSequence.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9' || c == '.' || c == '-' || c == '*' || c == '_') {
                stringBuilder.append(c);
                continue;
            }
            if (c == ' ') {
                stringBuilder.append('+');
                continue;
            }
            byte by = J173.g(c);
            stringBuilder.append('%');
            int n2 = by >> 4 & 0xF;
            if (n2 >= 10) {
                stringBuilder.append((char)(55 + n2));
            } else {
                stringBuilder.append((char)(48 + n2));
            }
            n2 = by & 0xF;
            if (n2 >= 10) {
                stringBuilder.append((char)(55 + n2));
                continue;
            }
            stringBuilder.append((char)(48 + n2));
        }
        return stringBuilder.toString();
    }

    public static String g(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = string.length();
        for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            if (c == '%' && n > i + 2) {
                c = string.charAt(i + 1);
                int n2 = 0;
                if (c >= '0' && c <= '9') {
                    n2 = c - 48;
                } else if (c >= 'a' && c <= 'f') {
                    n2 = 10 + c - 97;
                } else if (c >= 'A' && c <= 'F') {
                    n2 = 10 + c - 65;
                } else {
                    stringBuilder.append('%');
                    continue;
                }
                n2 *= 16;
                c = string.charAt(i + 2);
                if (c >= '0' && c <= '9') {
                    n2 += c - 48;
                } else if (c >= 'a' && c <= 'f') {
                    n2 += 10 + c - 97;
                } else if (c >= 'A' && c <= 'F') {
                    n2 += 10 + c - 65;
                } else {
                    stringBuilder.append('%');
                    continue;
                }
                if (n2 != 0 && J173.d((byte)n2)) {
                    stringBuilder.append(J173.q((byte)n2));
                }
                i += 2;
                continue;
            }
            if (c == '+') {
                stringBuilder.append(' ');
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

