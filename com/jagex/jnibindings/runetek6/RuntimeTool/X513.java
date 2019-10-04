/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import tfu.Gz143;

class X513 {
    private static final long g = Gz143.g();
    private String d = "";
    private long j = 0L;
    private long q = 0L;

    static void d(X513 x513) {
        x513.q = X513.g(x513);
    }

    static long b(X513 x513) {
        long l = 0L;
        l = X513.j(x513) ? x513.j - x513.q : X513.g(x513) - x513.q;
        return l;
    }

    static boolean j(X513 x513) {
        return x513.j > 0L;
    }

    static void e(X513 x513, String string) {
        x513.d = string;
    }

    String h() {
        return (X513.j(this) ? "ended,  " : "in progress,  ") + this.d;
    }

    static long s(X513 x513) {
        return x513.q - g;
    }

    static long g(X513 x513) {
        return Gz143.g();
    }

    X513() {
    }

    static void q(X513 x513) {
        x513.j = X513.g(x513);
    }
}

