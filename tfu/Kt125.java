/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Ks126;

public class Kt125 {
    private static Ks126 g;

    public static boolean q() {
        return g != null;
    }

    public static void g(Ks126 ks126) {
        if (g != null) {
            throw new IllegalStateException("Duplicate NativeLibraryRegistry initialisation!");
        }
        g = ks126;
    }

    public static Ks126 d() {
        if (g == null) {
            throw new IllegalStateException("NativeLibraryRegistry not initialised!");
        }
        return g;
    }
}

