/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.PrintStream;

public final class Gz143 {
    private static long d;
    private static final boolean g = true;
    private static long q;

    private Gz143() {
    }

    public static final synchronized long g() {
        long l = System.currentTimeMillis();
        if (l < d) {
            System.out.println("WARNING: safetime: time jumped back by " + (d - l) + " ms");
            q += d - l;
        }
        d = l;
        return l + q;
    }
}

