// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.core.stringtools.general.J173;

public class Mi507
{
    private Mi507() {
    }
    
    public static String d(final CharSequence charSequence) {
        final int length = charSequence.length();
        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            final char char1 = charSequence.charAt(i);
            if ((char1 >= 'a' && char1 <= 'z') || (char1 >= 'A' && char1 <= 'Z') || (char1 >= '0' && char1 <= '9') || char1 == '.' || char1 == '-' || char1 == '*' || char1 == '_') {
                sb.append(char1);
            }
            else if (char1 == ' ') {
                sb.append('+');
            }
            else {
                final byte g = J173.g(char1);
                sb.append('%');
                final int n = g >> 4 & 0xF;
                if (n >= 10) {
                    sb.append((char)(55 + n));
                }
                else {
                    sb.append((char)(48 + n));
                }
                final int n2 = g & 0xF;
                if (n2 >= 10) {
                    sb.append((char)(55 + n2));
                }
                else {
                    sb.append((char)(48 + n2));
                }
            }
        }
        return sb.toString();
    }
    
    public static String g(final String s) {
        final StringBuilder sb = new StringBuilder();
        for (int length = s.length(), i = 0; i < length; ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '%' && length > i + 2) {
                final char char2 = s.charAt(i + 1);
                int n;
                if (char2 >= '0' && char2 <= '9') {
                    n = char2 - '0';
                }
                else if (char2 >= 'a' && char2 <= 'f') {
                    n = '\n' + char2 - 97;
                }
                else {
                    if (char2 < 'A' || char2 > 'F') {
                        sb.append('%');
                        continue;
                    }
                    n = '\n' + char2 - 65;
                }
                final int n2 = n * 16;
                final char char3 = s.charAt(i + 2);
                int n3;
                if (char3 >= '0' && char3 <= '9') {
                    n3 = n2 + (char3 - '0');
                }
                else if (char3 >= 'a' && char3 <= 'f') {
                    n3 = n2 + ('\n' + char3 - 97);
                }
                else {
                    if (char3 < 'A' || char3 > 'F') {
                        sb.append('%');
                        continue;
                    }
                    n3 = n2 + ('\n' + char3 - 65);
                }
                if (n3 != 0 && J173.d((byte)n3)) {
                    sb.append(J173.q((byte)n3));
                }
                i += 2;
            }
            else if (char1 == '+') {
                sb.append(' ');
            }
            else {
                sb.append(char1);
            }
        }
        return sb.toString();
    }
}
