/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.E41;
import com.jagex.maths.Matrix4;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import com.jagex.maths.X309;

public final class Q10 {
    public final Matrix4 g;

    public static float g(Q10 q10) {
        return q10.g.f30 + (Math.abs(q10.g.f00) + Math.abs(q10.g.f10) + Math.abs(q10.g.f20));
    }

    public static float q(Q10 q10) {
        return q10.g.f31 + (Math.abs(q10.g.f01) + Math.abs(q10.g.f11) + Math.abs(q10.g.f21));
    }

    public static float j(Q10 q10) {
        return q10.g.f31 - (Math.abs(q10.g.f01) + Math.abs(q10.g.f11) + Math.abs(q10.g.f21));
    }

    public Vector3 l() {
        float f = this.g.f30;
        float f2 = this.g.f31;
        float f3 = this.g.f32;
        return new Vector3(f, f2, f3);
    }

    public Q10(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = (f4 - f) * 0.5f;
        float f8 = (f5 - f2) * 0.5f;
        float f9 = (f6 - f3) * 0.5f;
        this.g = Matrix4.e(f7, f8, f9, 1.0f).v(f + f7, f2 + f8, f3 + f9);
    }

    public Q10 s(ScaleRotTrans scaleRotTrans) {
        return new Q10(this.g.d(scaleRotTrans));
    }

    public boolean b(E41 e41) {
        X309[] arrx309 = new X309[]{new X309(-1.0f, 0.0f, 0.0f, e41.g), new X309(1.0f, 0.0f, 0.0f, e41.j), new X309(0.0f, -1.0f, 0.0f, e41.d), new X309(0.0f, 1.0f, 0.0f, e41.e), new X309(0.0f, 0.0f, -1.0f, e41.q), new X309(0.0f, 0.0f, 1.0f, e41.h)};
        for (int i = 0; i < 6; ++i) {
            X309 x309 = arrx309[i];
            X309 x3092 = new X309(x309.d.x * this.g.f00 + x309.d.y * this.g.f01 + x309.d.z * this.g.f02 + x309.g * this.g.f03, x309.d.x * this.g.f10 + x309.d.y * this.g.f11 + x309.d.z * this.g.f12 + x309.g * this.g.f13, x309.d.x * this.g.f20 + x309.d.y * this.g.f21 + x309.d.z * this.g.f22 + x309.g * this.g.f23, x309.d.x * this.g.f30 + x309.d.y * this.g.f31 + x309.d.z * this.g.f32 + x309.g * this.g.f33);
            if (X309.d(x3092, -1.0f, -1.0f, -1.0f) >= 0.0f || X309.d(x3092, 1.0f, -1.0f, -1.0f) >= 0.0f || X309.d(x3092, -1.0f, 1.0f, -1.0f) >= 0.0f || X309.d(x3092, 1.0f, 1.0f, -1.0f) >= 0.0f || X309.d(x3092, -1.0f, -1.0f, 1.0f) >= 0.0f || X309.d(x3092, 1.0f, -1.0f, 1.0f) >= 0.0f || X309.d(x3092, -1.0f, 1.0f, 1.0f) >= 0.0f || X309.d(x3092, 1.0f, 1.0f, 1.0f) >= 0.0f) continue;
            return false;
        }
        return true;
    }

    public Q10(Matrix4 matrix4) {
        this.g = matrix4;
    }

    public static float e(Q10 q10) {
        return q10.g.f32 + (Math.abs(q10.g.f02) + Math.abs(q10.g.f12) + Math.abs(q10.g.f22));
    }

    public static float h(Q10 q10) {
        return q10.g.f32 - (Math.abs(q10.g.f02) + Math.abs(q10.g.f12) + Math.abs(q10.g.f22));
    }

    public static float d(Q10 q10) {
        return q10.g.f30 - (Math.abs(q10.g.f00) + Math.abs(q10.g.f10) + Math.abs(q10.g.f20));
    }
}

