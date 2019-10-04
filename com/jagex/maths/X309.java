/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.Vector3;

public final class X309 {
    public final Vector3 d;
    public final float g;

    public static float d(X309 x309, float f, float f2, float f3) {
        return x309.d.x * f + x309.d.y * f2 + x309.d.z * f3 + x309.g;
    }

    public X309(Vector3 vector3, float f) {
        this.d = vector3;
        this.g = f;
    }

    public X309(float f, float f2, float f3, float f4) {
        this.d = new Vector3(f, f2, f3);
        this.g = f4;
    }

    public X309 g() {
        float f = 1.0f / Vector3.f(this.d);
        return new X309(Vector3.ai(this.d, f), this.g * f);
    }

    public X309() {
        this.d = Vector3.g;
        this.g = 0.0f;
    }
}

