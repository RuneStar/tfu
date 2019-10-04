/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.Matrix4;
import com.jagex.maths.Q10;
import com.jagex.maths.U316;
import com.jagex.maths.Vector3;
import com.jagex.maths.X309;

public final class S318 {
    public final X309 d;
    public final X309 e;
    public final X309 g;
    public final X309 h;
    public final X309 j;
    public final X309 q;

    public S318(U316 u316) {
        this.g = new X309(u316.g[3] + u316.g[0], u316.g[7] + u316.g[4], u316.g[11] + u316.g[8], u316.g[15] + u316.g[12]).g();
        this.d = new X309(u316.g[3] - u316.g[0], u316.g[7] - u316.g[4], u316.g[11] - u316.g[8], u316.g[15] - u316.g[12]).g();
        this.q = new X309(u316.g[3] + u316.g[1], u316.g[7] + u316.g[5], u316.g[11] + u316.g[9], u316.g[15] + u316.g[13]).g();
        this.j = new X309(u316.g[3] - u316.g[1], u316.g[7] - u316.g[5], u316.g[11] - u316.g[9], u316.g[15] - u316.g[13]).g();
        this.e = new X309(u316.g[3] + u316.g[2], u316.g[7] + u316.g[6], u316.g[11] + u316.g[10], u316.g[15] + u316.g[14]).g();
        this.h = new X309(u316.g[3] - u316.g[2], u316.g[7] - u316.g[6], u316.g[11] - u316.g[10], u316.g[15] - u316.g[14]).g();
    }

    public static boolean g(S318 s318, Q10 q10) {
        if (S318.d(s318.g, q10)) {
            return false;
        }
        if (S318.d(s318.d, q10)) {
            return false;
        }
        if (S318.d(s318.j, q10)) {
            return false;
        }
        if (S318.d(s318.q, q10)) {
            return false;
        }
        if (S318.d(s318.e, q10)) {
            return false;
        }
        return !S318.d(s318.h, q10);
    }

    private static boolean d(X309 x309, Q10 q10) {
        Matrix4 matrix4 = q10.g;
        X309 x3092 = new X309(x309.d.x * matrix4.f00 + x309.d.y * matrix4.f01 + x309.d.z * matrix4.f02 + x309.g * matrix4.f03, x309.d.x * matrix4.f10 + x309.d.y * matrix4.f11 + x309.d.z * matrix4.f12 + x309.g * matrix4.f13, x309.d.x * matrix4.f20 + x309.d.y * matrix4.f21 + x309.d.z * matrix4.f22 + x309.g * matrix4.f23, x309.d.x * matrix4.f30 + x309.d.y * matrix4.f31 + x309.d.z * matrix4.f32 + x309.g * matrix4.f33);
        if (X309.d(x3092, -1.0f, -1.0f, -1.0f) >= 0.0f) {
            return false;
        }
        if (X309.d(x3092, 1.0f, -1.0f, -1.0f) >= 0.0f) {
            return false;
        }
        if (X309.d(x3092, -1.0f, 1.0f, -1.0f) >= 0.0f) {
            return false;
        }
        if (X309.d(x3092, 1.0f, 1.0f, -1.0f) >= 0.0f) {
            return false;
        }
        if (X309.d(x3092, -1.0f, -1.0f, 1.0f) >= 0.0f) {
            return false;
        }
        if (X309.d(x3092, 1.0f, -1.0f, 1.0f) >= 0.0f) {
            return false;
        }
        if (X309.d(x3092, -1.0f, 1.0f, 1.0f) >= 0.0f) {
            return false;
        }
        return !(X309.d(x3092, 1.0f, 1.0f, 1.0f) >= 0.0f);
    }
}

