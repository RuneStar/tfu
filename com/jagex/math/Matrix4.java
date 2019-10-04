/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.math;

import com.jagex.math.G283;
import java.util.Arrays;
import tfu.Be2;
import tfu.Bs1;

@Deprecated
@Bs1
@Be2
public final class Matrix4 {
    public static final Matrix4 g = new Matrix4();
    public float[] f = new float[16];

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + Arrays.hashCode(this.f);
        return n2;
    }

    @Bs1
    @Be2
    public Matrix4(float[] arrf) {
        System.arraycopy(arrf, 0, this.f, 0, 16);
    }

    public static void g(Matrix4 matrix4) {
        matrix4.f[0] = 1.0f;
        matrix4.f[1] = 0.0f;
        matrix4.f[2] = 0.0f;
        matrix4.f[3] = 0.0f;
        matrix4.f[4] = 0.0f;
        matrix4.f[5] = 1.0f;
        matrix4.f[6] = 0.0f;
        matrix4.f[7] = 0.0f;
        matrix4.f[8] = 0.0f;
        matrix4.f[9] = 0.0f;
        matrix4.f[10] = 1.0f;
        matrix4.f[11] = 0.0f;
        matrix4.f[12] = 0.0f;
        matrix4.f[13] = 0.0f;
        matrix4.f[14] = 0.0f;
        matrix4.f[15] = 1.0f;
    }

    public static void d(Matrix4 matrix4, Matrix4 matrix42) {
        System.arraycopy(matrix42.f, 0, matrix4.f, 0, 16);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (j > 0) {
                    stringBuilder.append("\t");
                }
                stringBuilder.append(this.f[i * 4 + j]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof Matrix4)) {
            return false;
        }
        Matrix4 matrix4 = (Matrix4)object;
        for (int i = 0; i < 16; ++i) {
            if (this.f[i] == matrix4.f[i]) continue;
            return false;
        }
        return true;
    }

    public Matrix4() {
        Matrix4.g(this);
    }

    public Matrix4(G283 g283) {
        G283.j(g283, this.f, 0);
    }

    public Matrix4(Matrix4 matrix4) {
        Matrix4.d(this, matrix4);
    }
}

