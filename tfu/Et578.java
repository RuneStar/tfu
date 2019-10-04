/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Et578 {
    public static String g(String string) {
        int n;
        int n2 = string.length();
        int n3 = 0;
        for (int i = 0; i < n2; ++i) {
            n = string.charAt(i);
            if (n != 60 && n != 62) continue;
            n3 += 3;
        }
        StringBuilder stringBuilder = new StringBuilder(n2 + n3);
        for (n = 0; n < n2; ++n) {
            char c = string.charAt(n);
            if (c == '<') {
                stringBuilder.append("<lt>");
                continue;
            }
            if (c == '>') {
                stringBuilder.append("<gt>");
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

