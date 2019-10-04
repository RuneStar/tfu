// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Et578
{
    public static String g(final String s) {
        final int length = s.length();
        int n = 0;
        for (int i = 0; i < length; ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '<' || char1 == '>') {
                n += 3;
            }
        }
        final StringBuilder sb = new StringBuilder(length + n);
        for (int j = 0; j < length; ++j) {
            final char char2 = s.charAt(j);
            if (char2 == '<') {
                sb.append("<lt>");
            }
            else if (char2 == '>') {
                sb.append("<gt>");
            }
            else {
                sb.append(char2);
            }
        }
        return sb.toString();
    }
}
