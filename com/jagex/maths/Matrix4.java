/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.H303;
import com.jagex.maths.K299;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class Matrix4 {
    public static final Matrix4 g = new Matrix4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
    public final float f00;
    public final float f01;
    public final float f02;
    public final float f03;
    public final float f10;
    public final float f11;
    public final float f12;
    public final float f13;
    public final float f20;
    public final float f21;
    public final float f22;
    public final float f23;
    public final float f30;
    public final float f31;
    public final float f32;
    public final float f33;

    public Matrix4(RotTrans rotTrans) {
        float f = rotTrans.rot.w * rotTrans.rot.w;
        float f2 = rotTrans.rot.w * rotTrans.rot.x;
        float f3 = rotTrans.rot.w * rotTrans.rot.y;
        float f4 = rotTrans.rot.w * rotTrans.rot.z;
        float f5 = rotTrans.rot.x * rotTrans.rot.x;
        float f6 = rotTrans.rot.x * rotTrans.rot.y;
        float f7 = rotTrans.rot.x * rotTrans.rot.z;
        float f8 = rotTrans.rot.y * rotTrans.rot.y;
        float f9 = rotTrans.rot.y * rotTrans.rot.z;
        float f10 = rotTrans.rot.z * rotTrans.rot.z;
        this.f00 = f5 + f - f10 - f8;
        this.f01 = f6 + f4 + f6 + f4;
        this.f02 = f7 - f3 - f3 + f7;
        this.f10 = f6 - f4 - f4 + f6;
        this.f11 = f8 + f - f5 - f10;
        this.f12 = f9 + f2 + f9 + f2;
        this.f20 = f7 + f3 + f7 + f3;
        this.f21 = f9 - f2 - f2 + f9;
        this.f22 = f10 + f - f8 - f5;
        this.f03 = 0.0f;
        this.f13 = 0.0f;
        this.f23 = 0.0f;
        this.f30 = rotTrans.trans.x;
        this.f31 = rotTrans.trans.y;
        this.f32 = rotTrans.trans.z;
        this.f33 = 1.0f;
    }

    public Matrix4(float[] arrf) {
        this.f00 = arrf[0];
        this.f01 = arrf[1];
        this.f02 = arrf[2];
        this.f03 = arrf[3];
        this.f10 = arrf[4];
        this.f11 = arrf[5];
        this.f12 = arrf[6];
        this.f13 = arrf[7];
        this.f20 = arrf[8];
        this.f21 = arrf[9];
        this.f22 = arrf[10];
        this.f23 = arrf[11];
        this.f30 = arrf[12];
        this.f31 = arrf[13];
        this.f32 = arrf[14];
        this.f33 = arrf[15];
    }

    public Matrix4 d(ScaleRotTrans scaleRotTrans) {
        Quaternion quaternion = scaleRotTrans.rot;
        float f = quaternion.x * quaternion.x;
        float f2 = quaternion.x * quaternion.y;
        float f3 = quaternion.x * quaternion.z;
        float f4 = quaternion.x * quaternion.w;
        float f5 = quaternion.y * quaternion.y;
        float f6 = quaternion.y * quaternion.z;
        float f7 = quaternion.y * quaternion.w;
        float f8 = quaternion.z * quaternion.z;
        float f9 = quaternion.z * quaternion.w;
        float f10 = 1.0f - 2.0f * (f5 + f8);
        float f11 = 2.0f * (f2 - f9);
        float f12 = 2.0f * (f3 + f7);
        float f13 = 2.0f * (f2 + f9);
        float f14 = 1.0f - 2.0f * (f + f8);
        float f15 = 2.0f * (f6 - f4);
        float f16 = 2.0f * (f3 - f7);
        float f17 = 2.0f * (f6 + f4);
        float f18 = 1.0f - 2.0f * (f + f5);
        float f19 = scaleRotTrans.scale;
        return new Matrix4((this.f00 * f10 + this.f01 * f11 + this.f02 * f12) * f19, (this.f00 * f13 + this.f01 * f14 + this.f02 * f15) * f19, (this.f00 * f16 + this.f01 * f17 + this.f02 * f18) * f19, this.f03 * f19, (this.f10 * f10 + this.f11 * f11 + this.f12 * f12) * f19, (this.f10 * f13 + this.f11 * f14 + this.f12 * f15) * f19, (this.f10 * f16 + this.f11 * f17 + this.f12 * f18) * f19, this.f13 * f19, (this.f20 * f10 + this.f21 * f11 + this.f22 * f12) * f19, (this.f20 * f13 + this.f21 * f14 + this.f22 * f15) * f19, (this.f20 * f16 + this.f21 * f17 + this.f22 * f18) * f19, this.f23 * f19, this.f30 * f10 + this.f31 * f11 + this.f32 * f12 + scaleRotTrans.trans.x, this.f30 * f13 + this.f31 * f14 + this.f32 * f15 + scaleRotTrans.trans.y, this.f30 * f16 + this.f31 * f17 + this.f32 * f18 + scaleRotTrans.trans.z, this.f33);
    }

    public Matrix4 g(Matrix4 matrix4) {
        float f = this.f00 * matrix4.f00 + this.f01 * matrix4.f10 + this.f02 * matrix4.f20 + this.f03 * matrix4.f30;
        float f2 = this.f00 * matrix4.f01 + this.f01 * matrix4.f11 + this.f02 * matrix4.f21 + this.f03 * matrix4.f31;
        float f3 = this.f00 * matrix4.f02 + this.f01 * matrix4.f12 + this.f02 * matrix4.f22 + this.f03 * matrix4.f32;
        float f4 = this.f00 * matrix4.f03 + this.f01 * matrix4.f13 + this.f02 * matrix4.f23 + this.f03 * matrix4.f33;
        float f5 = this.f10 * matrix4.f00 + this.f11 * matrix4.f10 + this.f12 * matrix4.f20 + this.f13 * matrix4.f30;
        float f6 = this.f10 * matrix4.f01 + this.f11 * matrix4.f11 + this.f12 * matrix4.f21 + this.f13 * matrix4.f31;
        float f7 = this.f10 * matrix4.f02 + this.f11 * matrix4.f12 + this.f12 * matrix4.f22 + this.f13 * matrix4.f32;
        float f8 = this.f10 * matrix4.f03 + this.f11 * matrix4.f13 + this.f12 * matrix4.f23 + this.f13 * matrix4.f33;
        float f9 = this.f20 * matrix4.f00 + this.f21 * matrix4.f10 + this.f22 * matrix4.f20 + this.f23 * matrix4.f30;
        float f10 = this.f20 * matrix4.f01 + this.f21 * matrix4.f11 + this.f22 * matrix4.f21 + this.f23 * matrix4.f31;
        float f11 = this.f20 * matrix4.f02 + this.f21 * matrix4.f12 + this.f22 * matrix4.f22 + this.f23 * matrix4.f32;
        float f12 = this.f20 * matrix4.f03 + this.f21 * matrix4.f13 + this.f22 * matrix4.f23 + this.f23 * matrix4.f33;
        float f13 = this.f30 * matrix4.f00 + this.f31 * matrix4.f10 + this.f32 * matrix4.f20 + this.f33 * matrix4.f30;
        float f14 = this.f30 * matrix4.f01 + this.f31 * matrix4.f11 + this.f32 * matrix4.f21 + this.f33 * matrix4.f31;
        float f15 = this.f30 * matrix4.f02 + this.f31 * matrix4.f12 + this.f32 * matrix4.f22 + this.f33 * matrix4.f32;
        float f16 = this.f30 * matrix4.f03 + this.f31 * matrix4.f13 + this.f32 * matrix4.f23 + this.f33 * matrix4.f33;
        return new Matrix4(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16);
    }

    public Matrix4 j() {
        float f = 1.0f / Matrix4.q(this);
        float f2 = (this.f11 * this.f22 * this.f33 - this.f11 * this.f23 * this.f32 - this.f12 * this.f21 * this.f33 + this.f12 * this.f23 * this.f31 + this.f13 * this.f21 * this.f32 - this.f13 * this.f22 * this.f31) * f;
        float f3 = (-this.f01 * this.f22 * this.f33 + this.f01 * this.f23 * this.f32 + this.f02 * this.f21 * this.f33 - this.f02 * this.f23 * this.f31 - this.f03 * this.f21 * this.f32 + this.f03 * this.f22 * this.f31) * f;
        float f4 = (this.f01 * this.f12 * this.f33 - this.f01 * this.f13 * this.f32 - this.f02 * this.f11 * this.f33 + this.f02 * this.f13 * this.f31 + this.f03 * this.f11 * this.f32 - this.f03 * this.f12 * this.f31) * f;
        float f5 = (-this.f01 * this.f12 * this.f23 + this.f01 * this.f13 * this.f22 + this.f02 * this.f11 * this.f23 - this.f02 * this.f13 * this.f21 - this.f03 * this.f11 * this.f22 + this.f03 * this.f12 * this.f21) * f;
        float f6 = (-this.f10 * this.f22 * this.f33 + this.f10 * this.f23 * this.f32 + this.f12 * this.f20 * this.f33 - this.f12 * this.f23 * this.f30 - this.f13 * this.f20 * this.f32 + this.f13 * this.f22 * this.f30) * f;
        float f7 = (this.f00 * this.f22 * this.f33 - this.f00 * this.f23 * this.f32 - this.f02 * this.f20 * this.f33 + this.f02 * this.f23 * this.f30 + this.f03 * this.f20 * this.f32 - this.f03 * this.f22 * this.f30) * f;
        float f8 = (-this.f00 * this.f12 * this.f33 + this.f00 * this.f13 * this.f32 + this.f02 * this.f10 * this.f33 - this.f02 * this.f13 * this.f30 - this.f03 * this.f10 * this.f32 + this.f03 * this.f12 * this.f30) * f;
        float f9 = (this.f00 * this.f12 * this.f23 - this.f00 * this.f13 * this.f22 - this.f02 * this.f10 * this.f23 + this.f02 * this.f13 * this.f20 + this.f03 * this.f10 * this.f22 - this.f03 * this.f12 * this.f20) * f;
        float f10 = (this.f10 * this.f21 * this.f33 - this.f10 * this.f23 * this.f31 - this.f11 * this.f20 * this.f33 + this.f11 * this.f23 * this.f30 + this.f13 * this.f20 * this.f31 - this.f13 * this.f21 * this.f30) * f;
        float f11 = (-this.f00 * this.f21 * this.f33 + this.f00 * this.f23 * this.f31 + this.f01 * this.f20 * this.f33 - this.f01 * this.f23 * this.f30 - this.f03 * this.f20 * this.f31 + this.f03 * this.f21 * this.f30) * f;
        float f12 = (this.f00 * this.f11 * this.f33 - this.f00 * this.f13 * this.f31 - this.f01 * this.f10 * this.f33 + this.f01 * this.f13 * this.f30 + this.f03 * this.f10 * this.f31 - this.f03 * this.f11 * this.f30) * f;
        float f13 = (-this.f00 * this.f11 * this.f23 + this.f00 * this.f13 * this.f21 + this.f01 * this.f10 * this.f23 - this.f01 * this.f13 * this.f20 - this.f03 * this.f10 * this.f21 + this.f03 * this.f11 * this.f20) * f;
        float f14 = (-this.f10 * this.f21 * this.f32 + this.f10 * this.f22 * this.f31 + this.f11 * this.f20 * this.f32 - this.f11 * this.f22 * this.f30 - this.f12 * this.f20 * this.f31 + this.f12 * this.f21 * this.f30) * f;
        float f15 = (this.f00 * this.f21 * this.f32 - this.f00 * this.f22 * this.f31 - this.f01 * this.f20 * this.f32 + this.f01 * this.f22 * this.f30 + this.f02 * this.f20 * this.f31 - this.f02 * this.f21 * this.f30) * f;
        float f16 = (-this.f00 * this.f11 * this.f32 + this.f00 * this.f12 * this.f31 + this.f01 * this.f10 * this.f32 - this.f01 * this.f12 * this.f30 - this.f02 * this.f10 * this.f31 + this.f02 * this.f11 * this.f30) * f;
        float f17 = (this.f00 * this.f11 * this.f22 - this.f00 * this.f12 * this.f21 - this.f01 * this.f10 * this.f22 + this.f01 * this.f12 * this.f20 + this.f02 * this.f10 * this.f21 - this.f02 * this.f11 * this.f20) * f;
        return new Matrix4(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17);
    }

    public static Matrix4 w(float f, float f2, float f3) {
        return Matrix4.b(-10000.0f / f3, 10000.0f / f3, -10000.0f / f3, 10000.0f / f3, f, f2);
    }

    public Matrix4(Quaternion quaternion) {
        float f = quaternion.w * quaternion.w;
        float f2 = quaternion.w * quaternion.x;
        float f3 = quaternion.w * quaternion.y;
        float f4 = quaternion.w * quaternion.z;
        float f5 = quaternion.x * quaternion.x;
        float f6 = quaternion.x * quaternion.y;
        float f7 = quaternion.x * quaternion.z;
        float f8 = quaternion.y * quaternion.y;
        float f9 = quaternion.y * quaternion.z;
        float f10 = quaternion.z * quaternion.z;
        this.f00 = f5 + f - f10 - f8;
        this.f01 = f6 + f4 + f6 + f4;
        this.f02 = f7 - f3 - f3 + f7;
        this.f03 = 0.0f;
        this.f10 = f6 - f4 - f4 + f6;
        this.f11 = f8 + f - f5 - f10;
        this.f12 = f9 + f2 + f9 + f2;
        this.f13 = 0.0f;
        this.f20 = f7 + f3 + f7 + f3;
        this.f21 = f9 - f2 - f2 + f9;
        this.f22 = f10 + f - f8 - f5;
        this.f23 = 0.0f;
        this.f30 = 0.0f;
        this.f31 = 0.0f;
        this.f32 = 0.0f;
        this.f33 = 1.0f;
    }

    public static float q(Matrix4 matrix4) {
        return matrix4.f00 * matrix4.f11 * matrix4.f22 * matrix4.f33 - matrix4.f00 * matrix4.f11 * matrix4.f23 * matrix4.f32 - matrix4.f00 * matrix4.f12 * matrix4.f21 * matrix4.f33 + matrix4.f00 * matrix4.f12 * matrix4.f23 * matrix4.f31 + matrix4.f00 * matrix4.f13 * matrix4.f21 * matrix4.f32 - matrix4.f00 * matrix4.f13 * matrix4.f22 * matrix4.f31 - matrix4.f01 * matrix4.f10 * matrix4.f22 * matrix4.f33 + matrix4.f01 * matrix4.f10 * matrix4.f23 * matrix4.f32 + matrix4.f01 * matrix4.f12 * matrix4.f20 * matrix4.f33 - matrix4.f01 * matrix4.f12 * matrix4.f23 * matrix4.f30 - matrix4.f01 * matrix4.f13 * matrix4.f20 * matrix4.f32 + matrix4.f01 * matrix4.f13 * matrix4.f22 * matrix4.f30 + matrix4.f02 * matrix4.f10 * matrix4.f21 * matrix4.f33 - matrix4.f02 * matrix4.f10 * matrix4.f23 * matrix4.f31 - matrix4.f02 * matrix4.f11 * matrix4.f20 * matrix4.f33 + matrix4.f02 * matrix4.f11 * matrix4.f23 * matrix4.f30 + matrix4.f02 * matrix4.f13 * matrix4.f20 * matrix4.f31 - matrix4.f02 * matrix4.f13 * matrix4.f21 * matrix4.f30 - matrix4.f03 * matrix4.f10 * matrix4.f21 * matrix4.f32 + matrix4.f03 * matrix4.f10 * matrix4.f22 * matrix4.f31 + matrix4.f03 * matrix4.f11 * matrix4.f20 * matrix4.f32 - matrix4.f03 * matrix4.f11 * matrix4.f22 * matrix4.f30 - matrix4.f03 * matrix4.f12 * matrix4.f20 * matrix4.f31 + matrix4.f03 * matrix4.f12 * matrix4.f21 * matrix4.f30;
    }

    public static Matrix4 l(float f, float f2, float f3, float f4) {
        float f5 = (float)(Math.tan(f3 / 2.0f) * (double)f);
        float f6 = (float)(Math.tan(f4 / 2.0f) * (double)f);
        return Matrix4.r(-f5, f5, -f6, f6, f, f2);
    }

    public static void h(Matrix4 matrix4, float[] arrf) {
        float f = arrf[0];
        float f2 = arrf[1];
        float f3 = arrf[2];
        arrf[0] = matrix4.f00 * f + matrix4.f10 * f2 + matrix4.f20 * f3 + matrix4.f30;
        arrf[1] = matrix4.f01 * f + matrix4.f11 * f2 + matrix4.f21 * f3 + matrix4.f31;
        arrf[2] = matrix4.f02 * f + matrix4.f12 * f2 + matrix4.f22 * f3 + matrix4.f32;
    }

    public static Matrix4 b(float f, float f2, float f3, float f4, float f5, float f6) {
        return new Matrix4(2.0f / (f2 - f), 0.0f, 0.0f, 0.0f, 0.0f, 2.0f / (f4 - f3), 0.0f, 0.0f, 0.0f, 0.0f, 2.0f / (f6 - f5), 0.0f, -(f2 + f) / (f2 - f), -(f4 + f3) / (f4 - f3), -(f6 + f5) / (f6 - f5), 1.0f);
    }

    public Matrix4(H303 h303) {
        this.f00 = h303.g;
        this.f01 = h303.d;
        this.f02 = h303.q;
        this.f03 = 0.0f;
        this.f10 = h303.j;
        this.f11 = h303.e;
        this.f12 = h303.h;
        this.f13 = 0.0f;
        this.f20 = h303.s;
        this.f21 = h303.b;
        this.f22 = h303.l;
        this.f23 = 0.0f;
        this.f30 = h303.w;
        this.f31 = h303.r;
        this.f32 = h303.v;
        this.f33 = 1.0f;
    }

    public static Matrix4 r(float f, float f2, float f3, float f4, float f5, float f6) {
        return new Matrix4(2.0f * f5 / (f2 - f), 0.0f, 0.0f, 0.0f, 0.0f, 2.0f * f5 / (f4 - f3), 0.0f, 0.0f, (f2 + f) / (f2 - f), (f4 + f3) / (f4 - f3), (f6 + f5) / (f6 - f5), 1.0f, 0.0f, 0.0f, -(2.0f * f6 * f5) / (f6 - f5), 0.0f);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Matrix4 matrix4 = (Matrix4)object;
        if (Float.floatToIntBits(this.f00) != Float.floatToIntBits(matrix4.f00)) {
            return false;
        }
        if (Float.floatToIntBits(this.f01) != Float.floatToIntBits(matrix4.f01)) {
            return false;
        }
        if (Float.floatToIntBits(this.f02) != Float.floatToIntBits(matrix4.f02)) {
            return false;
        }
        if (Float.floatToIntBits(this.f03) != Float.floatToIntBits(matrix4.f03)) {
            return false;
        }
        if (Float.floatToIntBits(this.f10) != Float.floatToIntBits(matrix4.f10)) {
            return false;
        }
        if (Float.floatToIntBits(this.f11) != Float.floatToIntBits(matrix4.f11)) {
            return false;
        }
        if (Float.floatToIntBits(this.f12) != Float.floatToIntBits(matrix4.f12)) {
            return false;
        }
        if (Float.floatToIntBits(this.f13) != Float.floatToIntBits(matrix4.f13)) {
            return false;
        }
        if (Float.floatToIntBits(this.f20) != Float.floatToIntBits(matrix4.f20)) {
            return false;
        }
        if (Float.floatToIntBits(this.f21) != Float.floatToIntBits(matrix4.f21)) {
            return false;
        }
        if (Float.floatToIntBits(this.f22) != Float.floatToIntBits(matrix4.f22)) {
            return false;
        }
        if (Float.floatToIntBits(this.f23) != Float.floatToIntBits(matrix4.f23)) {
            return false;
        }
        if (Float.floatToIntBits(this.f30) != Float.floatToIntBits(matrix4.f30)) {
            return false;
        }
        if (Float.floatToIntBits(this.f31) != Float.floatToIntBits(matrix4.f31)) {
            return false;
        }
        if (Float.floatToIntBits(this.f32) != Float.floatToIntBits(matrix4.f32)) {
            return false;
        }
        return Float.floatToIntBits(this.f33) == Float.floatToIntBits(matrix4.f33);
    }

    public Matrix4 v(float f, float f2, float f3) {
        return new Matrix4(this.f00, this.f01, this.f02, this.f03, this.f10, this.f11, this.f12, this.f13, this.f20, this.f21, this.f22, this.f23, this.f30 + f, this.f31 + f2, this.f32 + f3, this.f33);
    }

    @Bs1
    @Be2
    public Matrix4(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f00 = f;
        this.f01 = f2;
        this.f02 = f3;
        this.f03 = f4;
        this.f10 = f5;
        this.f11 = f6;
        this.f12 = f7;
        this.f13 = f8;
        this.f20 = f9;
        this.f21 = f10;
        this.f22 = f11;
        this.f23 = f12;
        this.f30 = f13;
        this.f31 = f14;
        this.f32 = f15;
        this.f33 = f16;
    }

    public Matrix4(K299 k299) {
        this.f00 = k299.d;
        this.f01 = k299.q;
        this.f02 = k299.j;
        this.f03 = 0.0f;
        this.f10 = k299.e;
        this.f11 = k299.h;
        this.f12 = k299.s;
        this.f13 = 0.0f;
        this.f20 = k299.b;
        this.f21 = k299.l;
        this.f22 = k299.w;
        this.f23 = 0.0f;
        this.f30 = k299.r;
        this.f31 = k299.v;
        this.f32 = k299.y;
        this.f33 = 1.0f;
    }

    public static Matrix4 e(float f, float f2, float f3, float f4) {
        return new Matrix4(f, 0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, f3, 0.0f, 0.0f, 0.0f, 0.0f, f4);
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + Float.floatToIntBits(this.f00);
        n2 = 31 * n2 + Float.floatToIntBits(this.f01);
        n2 = 31 * n2 + Float.floatToIntBits(this.f02);
        n2 = 31 * n2 + Float.floatToIntBits(this.f03);
        n2 = 31 * n2 + Float.floatToIntBits(this.f10);
        n2 = 31 * n2 + Float.floatToIntBits(this.f11);
        n2 = 31 * n2 + Float.floatToIntBits(this.f12);
        n2 = 31 * n2 + Float.floatToIntBits(this.f13);
        n2 = 31 * n2 + Float.floatToIntBits(this.f20);
        n2 = 31 * n2 + Float.floatToIntBits(this.f21);
        n2 = 31 * n2 + Float.floatToIntBits(this.f22);
        n2 = 31 * n2 + Float.floatToIntBits(this.f23);
        n2 = 31 * n2 + Float.floatToIntBits(this.f30);
        n2 = 31 * n2 + Float.floatToIntBits(this.f31);
        n2 = 31 * n2 + Float.floatToIntBits(this.f32);
        n2 = 31 * n2 + Float.floatToIntBits(this.f33);
        return n2;
    }

    public String toString() {
        return this.f00 + "\t" + this.f01 + "\t" + this.f02 + "\t" + this.f03 + "\n" + this.f10 + "\t" + this.f11 + "\t" + this.f12 + "\t" + this.f13 + "\n" + this.f20 + "\t" + this.f21 + "\t" + this.f22 + "\t" + this.f23 + "\n" + this.f30 + "\t" + this.f31 + "\t" + this.f32 + "\t" + this.f33 + "\n";
    }

    public static float s(Matrix4 matrix4, float f, float f2, float f3) {
        return matrix4.f03 * f + matrix4.f13 * f2 + matrix4.f23 * f3 + matrix4.f33;
    }
}

