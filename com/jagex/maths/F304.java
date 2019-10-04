/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.Matrix4;
import com.jagex.maths.V198;
import tfu.Gg3;
import tfu.Kl267;

public final class F304
implements Kl267 {
    public float d;
    public float g;
    public float j;
    public float q;

    public F304(V198 v198) {
        F304.d(this, v198);
    }

    public static final F304 e(F304 f304) {
        f304.j = 0.0f;
        f304.q = 0.0f;
        f304.d = 0.0f;
        f304.g = 0.0f;
        return f304;
    }

    public F304(Gg3 gg3) {
        this.g = Gg3.bl(gg3);
        this.d = Gg3.bl(gg3);
        this.q = Gg3.bl(gg3);
        this.j = Gg3.bl(gg3);
    }

    public static F304 g(F304 f304, float f, float f2, float f3, float f4) {
        f304.g = f;
        f304.d = f2;
        f304.q = f3;
        f304.j = f4;
        return f304;
    }

    public static F304 d(F304 f304, V198 v198) {
        F304.g(f304, v198.d, v198.q, v198.j, v198.e);
        return f304;
    }

    public static F304 j(F304 f304, F304 f3042) {
        F304.g(f304, f3042.g, f3042.d, f3042.q, f3042.j);
        return f304;
    }

    public F304(float f, float f2, float f3, float f4) {
        F304.g(this, f, f2, f3, f4);
    }

    public static final F304 h(F304 f304, Matrix4 matrix4) {
        float f = f304.g;
        float f2 = f304.d;
        float f3 = f304.q;
        float f4 = f304.j;
        f304.g = matrix4.f00 * f + matrix4.f10 * f2 + matrix4.f20 * f3 + matrix4.f30 * f4;
        f304.d = matrix4.f01 * f + matrix4.f11 * f2 + matrix4.f21 * f3 + matrix4.f31 * f4;
        f304.q = matrix4.f02 * f + matrix4.f12 * f2 + matrix4.f22 * f3 + matrix4.f32 * f4;
        f304.j = matrix4.f03 * f + matrix4.f13 * f2 + matrix4.f23 * f3 + matrix4.f33 * f4;
        return f304;
    }

    public String toString() {
        return this.g + "," + this.d + "," + this.q + "," + this.j;
    }

    public F304 s() {
        return new F304(this);
    }

    public F304() {
        F304.e(this);
    }

    public F304(F304 f304) {
        F304.j(this, f304);
    }
}

