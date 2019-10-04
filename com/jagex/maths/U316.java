/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.H303;
import com.jagex.maths.K299;
import com.jagex.maths.Matrix4;
import java.util.Arrays;

public final class U316 {
    public float[] g = new float[16];

    public static U316 g(U316 u316) {
        u316.g[0] = 1.0f;
        u316.g[1] = 0.0f;
        u316.g[2] = 0.0f;
        u316.g[3] = 0.0f;
        u316.g[4] = 0.0f;
        u316.g[5] = 1.0f;
        u316.g[6] = 0.0f;
        u316.g[7] = 0.0f;
        u316.g[8] = 0.0f;
        u316.g[9] = 0.0f;
        u316.g[10] = 1.0f;
        u316.g[11] = 0.0f;
        u316.g[12] = 0.0f;
        u316.g[13] = 0.0f;
        u316.g[14] = 0.0f;
        u316.g[15] = 1.0f;
        return u316;
    }

    public U316(Matrix4 matrix4) {
        U316.d(this, matrix4);
    }

    public U316(U316 u316) {
        U316.q(this, u316);
    }

    public U316(float[] arrf) {
        System.arraycopy(arrf, 0, this.g, 0, 16);
    }

    public U316(K299 k299) {
        K299.g(k299, this.g, 0);
    }

    public U316(H303 h303) {
        H303.r(h303, this.g, 0);
    }

    public U316() {
        U316.g(this);
    }

    public static U316 q(U316 u316, U316 u3162) {
        System.arraycopy(u3162.g, 0, u316.g, 0, 16);
        return u316;
    }

    public static U316 j(U316 u316, Matrix4 matrix4) {
        float f = u316.g[0] * matrix4.f00 + u316.g[1] * matrix4.f10 + u316.g[2] * matrix4.f20 + u316.g[3] * matrix4.f30;
        float f2 = u316.g[0] * matrix4.f01 + u316.g[1] * matrix4.f11 + u316.g[2] * matrix4.f21 + u316.g[3] * matrix4.f31;
        float f3 = u316.g[0] * matrix4.f02 + u316.g[1] * matrix4.f12 + u316.g[2] * matrix4.f22 + u316.g[3] * matrix4.f32;
        float f4 = u316.g[0] * matrix4.f03 + u316.g[1] * matrix4.f13 + u316.g[2] * matrix4.f23 + u316.g[3] * matrix4.f33;
        float f5 = u316.g[4] * matrix4.f00 + u316.g[5] * matrix4.f10 + u316.g[6] * matrix4.f20 + u316.g[7] * matrix4.f30;
        float f6 = u316.g[4] * matrix4.f01 + u316.g[5] * matrix4.f11 + u316.g[6] * matrix4.f21 + u316.g[7] * matrix4.f31;
        float f7 = u316.g[4] * matrix4.f02 + u316.g[5] * matrix4.f12 + u316.g[6] * matrix4.f22 + u316.g[7] * matrix4.f32;
        float f8 = u316.g[4] * matrix4.f03 + u316.g[5] * matrix4.f13 + u316.g[6] * matrix4.f23 + u316.g[7] * matrix4.f33;
        float f9 = u316.g[8] * matrix4.f00 + u316.g[9] * matrix4.f10 + u316.g[10] * matrix4.f20 + u316.g[11] * matrix4.f30;
        float f10 = u316.g[8] * matrix4.f01 + u316.g[9] * matrix4.f11 + u316.g[10] * matrix4.f21 + u316.g[11] * matrix4.f31;
        float f11 = u316.g[8] * matrix4.f02 + u316.g[9] * matrix4.f12 + u316.g[10] * matrix4.f22 + u316.g[11] * matrix4.f32;
        float f12 = u316.g[8] * matrix4.f03 + u316.g[9] * matrix4.f13 + u316.g[10] * matrix4.f23 + u316.g[11] * matrix4.f33;
        float f13 = u316.g[12] * matrix4.f00 + u316.g[13] * matrix4.f10 + u316.g[14] * matrix4.f20 + u316.g[15] * matrix4.f30;
        float f14 = u316.g[12] * matrix4.f01 + u316.g[13] * matrix4.f11 + u316.g[14] * matrix4.f21 + u316.g[15] * matrix4.f31;
        float f15 = u316.g[12] * matrix4.f02 + u316.g[13] * matrix4.f12 + u316.g[14] * matrix4.f22 + u316.g[15] * matrix4.f32;
        float f16 = u316.g[12] * matrix4.f03 + u316.g[13] * matrix4.f13 + u316.g[14] * matrix4.f23 + u316.g[15] * matrix4.f33;
        u316.g[0] = f;
        u316.g[1] = f2;
        u316.g[2] = f3;
        u316.g[3] = f4;
        u316.g[4] = f5;
        u316.g[5] = f6;
        u316.g[6] = f7;
        u316.g[7] = f8;
        u316.g[8] = f9;
        u316.g[9] = f10;
        u316.g[10] = f11;
        u316.g[11] = f12;
        u316.g[12] = f13;
        u316.g[13] = f14;
        u316.g[14] = f15;
        u316.g[15] = f16;
        return u316;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + Arrays.hashCode(this.g);
        return n2;
    }

    public boolean equals(Object object) {
        if (!(object instanceof U316)) {
            return false;
        }
        U316 u316 = (U316)object;
        for (int i = 0; i < 16; ++i) {
            if (this.g[i] == u316.g[i]) continue;
            return false;
        }
        return true;
    }

    public static U316 e(U316 u316, H303 h303) {
        u316.g[0] = h303.g;
        u316.g[1] = h303.d;
        u316.g[2] = h303.q;
        u316.g[3] = 0.0f;
        u316.g[4] = h303.j;
        u316.g[5] = h303.e;
        u316.g[6] = h303.h;
        u316.g[7] = 0.0f;
        u316.g[8] = h303.s;
        u316.g[9] = h303.b;
        u316.g[10] = h303.l;
        u316.g[11] = 0.0f;
        u316.g[12] = h303.w;
        u316.g[13] = h303.r;
        u316.g[14] = h303.v;
        u316.g[15] = 1.0f;
        return u316;
    }

    public static U316 d(U316 u316, Matrix4 matrix4) {
        u316.g[0] = matrix4.f00;
        u316.g[1] = matrix4.f01;
        u316.g[2] = matrix4.f02;
        u316.g[3] = matrix4.f03;
        u316.g[4] = matrix4.f10;
        u316.g[5] = matrix4.f11;
        u316.g[6] = matrix4.f12;
        u316.g[7] = matrix4.f13;
        u316.g[8] = matrix4.f20;
        u316.g[9] = matrix4.f21;
        u316.g[10] = matrix4.f22;
        u316.g[11] = matrix4.f23;
        u316.g[12] = matrix4.f30;
        u316.g[13] = matrix4.f31;
        u316.g[14] = matrix4.f32;
        u316.g[15] = matrix4.f33;
        return u316;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (j > 0) {
                    stringBuilder.append("\t");
                }
                stringBuilder.append(this.g[i * 4 + j]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}

