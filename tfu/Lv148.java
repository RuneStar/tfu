/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.La499;
import tfu.Lm295;

public abstract class Lv148 {
    private static Lv148 g;

    public static void d(boolean bl) {
        if (g != null) {
            g.h(bl);
        }
    }

    public static Lm295 q(String string) {
        return g != null ? g.s(string) : null;
    }

    public abstract Lm295 s(String var1);

    protected abstract void h(boolean var1);

    public static La499 j(String string) {
        return g != null ? g.b(string) : null;
    }

    public abstract La499 b(String var1);

    protected abstract void e(boolean var1);

    public static void g(boolean bl) {
        if (g != null) {
            g.e(bl);
        }
    }
}

