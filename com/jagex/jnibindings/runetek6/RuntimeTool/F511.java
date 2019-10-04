/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.I512;

public class F511 {
    private int d = 0;
    private I512 g = I512.UNUSED;

    public static void g(F511 f511) {
        f511.g = I512.UNUSED;
        ++f511.d;
    }

    public static void q(F511 f511) {
        f511.g = I512.ENDED;
    }

    public static boolean j(F511 f511) {
        return f511.g.compareTo(I512.STARTED) >= 0;
    }

    public static int h(F511 f511) {
        return f511.d;
    }

    public static boolean e(F511 f511) {
        return f511.g.compareTo(I512.ENDED) >= 0;
    }

    public static void d(F511 f511) {
        f511.g = I512.STARTED;
    }
}

