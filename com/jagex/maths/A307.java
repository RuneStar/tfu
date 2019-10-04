/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.P308;
import com.jagex.maths.Vector3;

final class A307 {
    private float d;
    private final Vector3[] g = new Vector3[4];
    private P308 j;
    private float[] q;

    static void d(A307 a307, int n, Vector3 vector3) {
        a307.g[n] = vector3;
        A307.g(a307);
    }

    private static void g(A307 a307) {
        a307.d = -1.0f;
        a307.q = null;
        a307.j = null;
    }

    A307() {
        A307.g(this);
    }

    static Vector3 q(A307 a307, int n) {
        return a307.g[n];
    }
}

