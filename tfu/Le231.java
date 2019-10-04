/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public final class Le231 {
    private static final String g = "#";

    public static final boolean g(String string, String string2, String string3, String string4) {
        if (string == null || string3 == null) {
            return false;
        }
        if (string.startsWith(g) || string3.startsWith(g)) {
            return string.equals(string3);
        }
        return string2.equals(string4);
    }
}

