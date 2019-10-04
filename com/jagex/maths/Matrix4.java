// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

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
public final class Matrix4
{
    public static final Matrix4 g;
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
    
    public Matrix4(final RotTrans rotTrans) {
        final float n = rotTrans.rot.w * rotTrans.rot.w;
        final float n2 = rotTrans.rot.w * rotTrans.rot.x;
        final float n3 = rotTrans.rot.w * rotTrans.rot.y;
        final float n4 = rotTrans.rot.w * rotTrans.rot.z;
        final float n5 = rotTrans.rot.x * rotTrans.rot.x;
        final float n6 = rotTrans.rot.x * rotTrans.rot.y;
        final float n7 = rotTrans.rot.x * rotTrans.rot.z;
        final float n8 = rotTrans.rot.y * rotTrans.rot.y;
        final float n9 = rotTrans.rot.y * rotTrans.rot.z;
        final float n10 = rotTrans.rot.z * rotTrans.rot.z;
        this.f00 = n5 + n - n10 - n8;
        this.f01 = n6 + n4 + n6 + n4;
        this.f02 = n7 - n3 - n3 + n7;
        this.f10 = n6 - n4 - n4 + n6;
        this.f11 = n8 + n - n5 - n10;
        this.f12 = n9 + n2 + n9 + n2;
        this.f20 = n7 + n3 + n7 + n3;
        this.f21 = n9 - n2 - n2 + n9;
        this.f22 = n10 + n - n8 - n5;
        this.f03 = 0.0f;
        this.f13 = 0.0f;
        this.f23 = 0.0f;
        this.f30 = rotTrans.trans.x;
        this.f31 = rotTrans.trans.y;
        this.f32 = rotTrans.trans.z;
        this.f33 = 1.0f;
    }
    
    public Matrix4(final float[] array) {
        this.f00 = array[0];
        this.f01 = array[1];
        this.f02 = array[2];
        this.f03 = array[3];
        this.f10 = array[4];
        this.f11 = array[5];
        this.f12 = array[6];
        this.f13 = array[7];
        this.f20 = array[8];
        this.f21 = array[9];
        this.f22 = array[10];
        this.f23 = array[11];
        this.f30 = array[12];
        this.f31 = array[13];
        this.f32 = array[14];
        this.f33 = array[15];
    }
    
    public Matrix4 d(final ScaleRotTrans scaleRotTrans) {
        final Quaternion rot = scaleRotTrans.rot;
        final float n = rot.x * rot.x;
        final float n2 = rot.x * rot.y;
        final float n3 = rot.x * rot.z;
        final float n4 = rot.x * rot.w;
        final float n5 = rot.y * rot.y;
        final float n6 = rot.y * rot.z;
        final float n7 = rot.y * rot.w;
        final float n8 = rot.z * rot.z;
        final float n9 = rot.z * rot.w;
        final float n10 = 1.0f - 2.0f * (n5 + n8);
        final float n11 = 2.0f * (n2 - n9);
        final float n12 = 2.0f * (n3 + n7);
        final float n13 = 2.0f * (n2 + n9);
        final float n14 = 1.0f - 2.0f * (n + n8);
        final float n15 = 2.0f * (n6 - n4);
        final float n16 = 2.0f * (n3 - n7);
        final float n17 = 2.0f * (n6 + n4);
        final float n18 = 1.0f - 2.0f * (n + n5);
        final float scale = scaleRotTrans.scale;
        return new Matrix4((this.f00 * n10 + this.f01 * n11 + this.f02 * n12) * scale, (this.f00 * n13 + this.f01 * n14 + this.f02 * n15) * scale, (this.f00 * n16 + this.f01 * n17 + this.f02 * n18) * scale, this.f03 * scale, (this.f10 * n10 + this.f11 * n11 + this.f12 * n12) * scale, (this.f10 * n13 + this.f11 * n14 + this.f12 * n15) * scale, (this.f10 * n16 + this.f11 * n17 + this.f12 * n18) * scale, this.f13 * scale, (this.f20 * n10 + this.f21 * n11 + this.f22 * n12) * scale, (this.f20 * n13 + this.f21 * n14 + this.f22 * n15) * scale, (this.f20 * n16 + this.f21 * n17 + this.f22 * n18) * scale, this.f23 * scale, this.f30 * n10 + this.f31 * n11 + this.f32 * n12 + scaleRotTrans.trans.x, this.f30 * n13 + this.f31 * n14 + this.f32 * n15 + scaleRotTrans.trans.y, this.f30 * n16 + this.f31 * n17 + this.f32 * n18 + scaleRotTrans.trans.z, this.f33);
    }
    
    public Matrix4 g(final Matrix4 matrix4) {
        return new Matrix4(this.f00 * matrix4.f00 + this.f01 * matrix4.f10 + this.f02 * matrix4.f20 + this.f03 * matrix4.f30, this.f00 * matrix4.f01 + this.f01 * matrix4.f11 + this.f02 * matrix4.f21 + this.f03 * matrix4.f31, this.f00 * matrix4.f02 + this.f01 * matrix4.f12 + this.f02 * matrix4.f22 + this.f03 * matrix4.f32, this.f00 * matrix4.f03 + this.f01 * matrix4.f13 + this.f02 * matrix4.f23 + this.f03 * matrix4.f33, this.f10 * matrix4.f00 + this.f11 * matrix4.f10 + this.f12 * matrix4.f20 + this.f13 * matrix4.f30, this.f10 * matrix4.f01 + this.f11 * matrix4.f11 + this.f12 * matrix4.f21 + this.f13 * matrix4.f31, this.f10 * matrix4.f02 + this.f11 * matrix4.f12 + this.f12 * matrix4.f22 + this.f13 * matrix4.f32, this.f10 * matrix4.f03 + this.f11 * matrix4.f13 + this.f12 * matrix4.f23 + this.f13 * matrix4.f33, this.f20 * matrix4.f00 + this.f21 * matrix4.f10 + this.f22 * matrix4.f20 + this.f23 * matrix4.f30, this.f20 * matrix4.f01 + this.f21 * matrix4.f11 + this.f22 * matrix4.f21 + this.f23 * matrix4.f31, this.f20 * matrix4.f02 + this.f21 * matrix4.f12 + this.f22 * matrix4.f22 + this.f23 * matrix4.f32, this.f20 * matrix4.f03 + this.f21 * matrix4.f13 + this.f22 * matrix4.f23 + this.f23 * matrix4.f33, this.f30 * matrix4.f00 + this.f31 * matrix4.f10 + this.f32 * matrix4.f20 + this.f33 * matrix4.f30, this.f30 * matrix4.f01 + this.f31 * matrix4.f11 + this.f32 * matrix4.f21 + this.f33 * matrix4.f31, this.f30 * matrix4.f02 + this.f31 * matrix4.f12 + this.f32 * matrix4.f22 + this.f33 * matrix4.f32, this.f30 * matrix4.f03 + this.f31 * matrix4.f13 + this.f32 * matrix4.f23 + this.f33 * matrix4.f33);
    }
    
    public Matrix4 j() {
        final float n = 1.0f / q(this);
        return new Matrix4((this.f11 * this.f22 * this.f33 - this.f11 * this.f23 * this.f32 - this.f12 * this.f21 * this.f33 + this.f12 * this.f23 * this.f31 + this.f13 * this.f21 * this.f32 - this.f13 * this.f22 * this.f31) * n, (-this.f01 * this.f22 * this.f33 + this.f01 * this.f23 * this.f32 + this.f02 * this.f21 * this.f33 - this.f02 * this.f23 * this.f31 - this.f03 * this.f21 * this.f32 + this.f03 * this.f22 * this.f31) * n, (this.f01 * this.f12 * this.f33 - this.f01 * this.f13 * this.f32 - this.f02 * this.f11 * this.f33 + this.f02 * this.f13 * this.f31 + this.f03 * this.f11 * this.f32 - this.f03 * this.f12 * this.f31) * n, (-this.f01 * this.f12 * this.f23 + this.f01 * this.f13 * this.f22 + this.f02 * this.f11 * this.f23 - this.f02 * this.f13 * this.f21 - this.f03 * this.f11 * this.f22 + this.f03 * this.f12 * this.f21) * n, (-this.f10 * this.f22 * this.f33 + this.f10 * this.f23 * this.f32 + this.f12 * this.f20 * this.f33 - this.f12 * this.f23 * this.f30 - this.f13 * this.f20 * this.f32 + this.f13 * this.f22 * this.f30) * n, (this.f00 * this.f22 * this.f33 - this.f00 * this.f23 * this.f32 - this.f02 * this.f20 * this.f33 + this.f02 * this.f23 * this.f30 + this.f03 * this.f20 * this.f32 - this.f03 * this.f22 * this.f30) * n, (-this.f00 * this.f12 * this.f33 + this.f00 * this.f13 * this.f32 + this.f02 * this.f10 * this.f33 - this.f02 * this.f13 * this.f30 - this.f03 * this.f10 * this.f32 + this.f03 * this.f12 * this.f30) * n, (this.f00 * this.f12 * this.f23 - this.f00 * this.f13 * this.f22 - this.f02 * this.f10 * this.f23 + this.f02 * this.f13 * this.f20 + this.f03 * this.f10 * this.f22 - this.f03 * this.f12 * this.f20) * n, (this.f10 * this.f21 * this.f33 - this.f10 * this.f23 * this.f31 - this.f11 * this.f20 * this.f33 + this.f11 * this.f23 * this.f30 + this.f13 * this.f20 * this.f31 - this.f13 * this.f21 * this.f30) * n, (-this.f00 * this.f21 * this.f33 + this.f00 * this.f23 * this.f31 + this.f01 * this.f20 * this.f33 - this.f01 * this.f23 * this.f30 - this.f03 * this.f20 * this.f31 + this.f03 * this.f21 * this.f30) * n, (this.f00 * this.f11 * this.f33 - this.f00 * this.f13 * this.f31 - this.f01 * this.f10 * this.f33 + this.f01 * this.f13 * this.f30 + this.f03 * this.f10 * this.f31 - this.f03 * this.f11 * this.f30) * n, (-this.f00 * this.f11 * this.f23 + this.f00 * this.f13 * this.f21 + this.f01 * this.f10 * this.f23 - this.f01 * this.f13 * this.f20 - this.f03 * this.f10 * this.f21 + this.f03 * this.f11 * this.f20) * n, (-this.f10 * this.f21 * this.f32 + this.f10 * this.f22 * this.f31 + this.f11 * this.f20 * this.f32 - this.f11 * this.f22 * this.f30 - this.f12 * this.f20 * this.f31 + this.f12 * this.f21 * this.f30) * n, (this.f00 * this.f21 * this.f32 - this.f00 * this.f22 * this.f31 - this.f01 * this.f20 * this.f32 + this.f01 * this.f22 * this.f30 + this.f02 * this.f20 * this.f31 - this.f02 * this.f21 * this.f30) * n, (-this.f00 * this.f11 * this.f32 + this.f00 * this.f12 * this.f31 + this.f01 * this.f10 * this.f32 - this.f01 * this.f12 * this.f30 - this.f02 * this.f10 * this.f31 + this.f02 * this.f11 * this.f30) * n, (this.f00 * this.f11 * this.f22 - this.f00 * this.f12 * this.f21 - this.f01 * this.f10 * this.f22 + this.f01 * this.f12 * this.f20 + this.f02 * this.f10 * this.f21 - this.f02 * this.f11 * this.f20) * n);
    }
    
    public static Matrix4 w(final float n, final float n2, final float n3) {
        return b(-10000.0f / n3, 10000.0f / n3, -10000.0f / n3, 10000.0f / n3, n, n2);
    }
    
    public Matrix4(final Quaternion quaternion) {
        final float n = quaternion.w * quaternion.w;
        final float n2 = quaternion.w * quaternion.x;
        final float n3 = quaternion.w * quaternion.y;
        final float n4 = quaternion.w * quaternion.z;
        final float n5 = quaternion.x * quaternion.x;
        final float n6 = quaternion.x * quaternion.y;
        final float n7 = quaternion.x * quaternion.z;
        final float n8 = quaternion.y * quaternion.y;
        final float n9 = quaternion.y * quaternion.z;
        final float n10 = quaternion.z * quaternion.z;
        this.f00 = n5 + n - n10 - n8;
        this.f01 = n6 + n4 + n6 + n4;
        this.f02 = n7 - n3 - n3 + n7;
        this.f03 = 0.0f;
        this.f10 = n6 - n4 - n4 + n6;
        this.f11 = n8 + n - n5 - n10;
        this.f12 = n9 + n2 + n9 + n2;
        this.f13 = 0.0f;
        this.f20 = n7 + n3 + n7 + n3;
        this.f21 = n9 - n2 - n2 + n9;
        this.f22 = n10 + n - n8 - n5;
        this.f23 = 0.0f;
        this.f30 = 0.0f;
        this.f31 = 0.0f;
        this.f32 = 0.0f;
        this.f33 = 1.0f;
    }
    
    public static float q(final Matrix4 matrix4) {
        return matrix4.f00 * matrix4.f11 * matrix4.f22 * matrix4.f33 - matrix4.f00 * matrix4.f11 * matrix4.f23 * matrix4.f32 - matrix4.f00 * matrix4.f12 * matrix4.f21 * matrix4.f33 + matrix4.f00 * matrix4.f12 * matrix4.f23 * matrix4.f31 + matrix4.f00 * matrix4.f13 * matrix4.f21 * matrix4.f32 - matrix4.f00 * matrix4.f13 * matrix4.f22 * matrix4.f31 - matrix4.f01 * matrix4.f10 * matrix4.f22 * matrix4.f33 + matrix4.f01 * matrix4.f10 * matrix4.f23 * matrix4.f32 + matrix4.f01 * matrix4.f12 * matrix4.f20 * matrix4.f33 - matrix4.f01 * matrix4.f12 * matrix4.f23 * matrix4.f30 - matrix4.f01 * matrix4.f13 * matrix4.f20 * matrix4.f32 + matrix4.f01 * matrix4.f13 * matrix4.f22 * matrix4.f30 + matrix4.f02 * matrix4.f10 * matrix4.f21 * matrix4.f33 - matrix4.f02 * matrix4.f10 * matrix4.f23 * matrix4.f31 - matrix4.f02 * matrix4.f11 * matrix4.f20 * matrix4.f33 + matrix4.f02 * matrix4.f11 * matrix4.f23 * matrix4.f30 + matrix4.f02 * matrix4.f13 * matrix4.f20 * matrix4.f31 - matrix4.f02 * matrix4.f13 * matrix4.f21 * matrix4.f30 - matrix4.f03 * matrix4.f10 * matrix4.f21 * matrix4.f32 + matrix4.f03 * matrix4.f10 * matrix4.f22 * matrix4.f31 + matrix4.f03 * matrix4.f11 * matrix4.f20 * matrix4.f32 - matrix4.f03 * matrix4.f11 * matrix4.f22 * matrix4.f30 - matrix4.f03 * matrix4.f12 * matrix4.f20 * matrix4.f31 + matrix4.f03 * matrix4.f12 * matrix4.f21 * matrix4.f30;
    }
    
    public static Matrix4 l(final float n, final float n2, final float n3, final float n4) {
        final float n5 = (float)(Math.tan(n3 / 2.0f) * n);
        final float n6 = (float)(Math.tan(n4 / 2.0f) * n);
        return r(-n5, n5, -n6, n6, n, n2);
    }
    
    public static void h(final Matrix4 matrix4, final float[] array) {
        final float n = array[0];
        final float n2 = array[1];
        final float n3 = array[2];
        array[0] = matrix4.f00 * n + matrix4.f10 * n2 + matrix4.f20 * n3 + matrix4.f30;
        array[1] = matrix4.f01 * n + matrix4.f11 * n2 + matrix4.f21 * n3 + matrix4.f31;
        array[2] = matrix4.f02 * n + matrix4.f12 * n2 + matrix4.f22 * n3 + matrix4.f32;
    }
    
    public static Matrix4 b(final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        return new Matrix4(2.0f / (n2 - n), 0.0f, 0.0f, 0.0f, 0.0f, 2.0f / (n4 - n3), 0.0f, 0.0f, 0.0f, 0.0f, 2.0f / (n6 - n5), 0.0f, -(n2 + n) / (n2 - n), -(n4 + n3) / (n4 - n3), -(n6 + n5) / (n6 - n5), 1.0f);
    }
    
    public Matrix4(final H303 h303) {
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
    
    public static Matrix4 r(final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        return new Matrix4(2.0f * n5 / (n2 - n), 0.0f, 0.0f, 0.0f, 0.0f, 2.0f * n5 / (n4 - n3), 0.0f, 0.0f, (n2 + n) / (n2 - n), (n4 + n3) / (n4 - n3), (n6 + n5) / (n6 - n5), 1.0f, 0.0f, 0.0f, -(2.0f * n6 * n5) / (n6 - n5), 0.0f);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        final Matrix4 matrix4 = (Matrix4)o;
        return Float.floatToIntBits(this.f00) == Float.floatToIntBits(matrix4.f00) && Float.floatToIntBits(this.f01) == Float.floatToIntBits(matrix4.f01) && Float.floatToIntBits(this.f02) == Float.floatToIntBits(matrix4.f02) && Float.floatToIntBits(this.f03) == Float.floatToIntBits(matrix4.f03) && Float.floatToIntBits(this.f10) == Float.floatToIntBits(matrix4.f10) && Float.floatToIntBits(this.f11) == Float.floatToIntBits(matrix4.f11) && Float.floatToIntBits(this.f12) == Float.floatToIntBits(matrix4.f12) && Float.floatToIntBits(this.f13) == Float.floatToIntBits(matrix4.f13) && Float.floatToIntBits(this.f20) == Float.floatToIntBits(matrix4.f20) && Float.floatToIntBits(this.f21) == Float.floatToIntBits(matrix4.f21) && Float.floatToIntBits(this.f22) == Float.floatToIntBits(matrix4.f22) && Float.floatToIntBits(this.f23) == Float.floatToIntBits(matrix4.f23) && Float.floatToIntBits(this.f30) == Float.floatToIntBits(matrix4.f30) && Float.floatToIntBits(this.f31) == Float.floatToIntBits(matrix4.f31) && Float.floatToIntBits(this.f32) == Float.floatToIntBits(matrix4.f32) && Float.floatToIntBits(this.f33) == Float.floatToIntBits(matrix4.f33);
    }
    
    public Matrix4 v(final float n, final float n2, final float n3) {
        return new Matrix4(this.f00, this.f01, this.f02, this.f03, this.f10, this.f11, this.f12, this.f13, this.f20, this.f21, this.f22, this.f23, this.f30 + n, this.f31 + n2, this.f32 + n3, this.f33);
    }
    
    static {
        g = new Matrix4(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
    }
    
    @Bs1
    @Be2
    public Matrix4(final float f00, final float f2, final float f3, final float f4, final float f5, final float f6, final float f7, final float f8, final float f9, final float f10, final float f11, final float f12, final float f13, final float f14, final float f15, final float f16) {
        this.f00 = f00;
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
    
    public Matrix4(final K299 k299) {
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
    
    public static Matrix4 e(final float n, final float n2, final float n3, final float n4) {
        return new Matrix4(n, 0.0f, 0.0f, 0.0f, 0.0f, n2, 0.0f, 0.0f, 0.0f, 0.0f, n3, 0.0f, 0.0f, 0.0f, 0.0f, n4);
    }
    
    @Override
    public int hashCode() {
        return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * 1 + Float.floatToIntBits(this.f00)) + Float.floatToIntBits(this.f01)) + Float.floatToIntBits(this.f02)) + Float.floatToIntBits(this.f03)) + Float.floatToIntBits(this.f10)) + Float.floatToIntBits(this.f11)) + Float.floatToIntBits(this.f12)) + Float.floatToIntBits(this.f13)) + Float.floatToIntBits(this.f20)) + Float.floatToIntBits(this.f21)) + Float.floatToIntBits(this.f22)) + Float.floatToIntBits(this.f23)) + Float.floatToIntBits(this.f30)) + Float.floatToIntBits(this.f31)) + Float.floatToIntBits(this.f32)) + Float.floatToIntBits(this.f33);
    }
    
    @Override
    public String toString() {
        return this.f00 + "\t" + this.f01 + "\t" + this.f02 + "\t" + this.f03 + "\n" + this.f10 + "\t" + this.f11 + "\t" + this.f12 + "\t" + this.f13 + "\n" + this.f20 + "\t" + this.f21 + "\t" + this.f22 + "\t" + this.f23 + "\n" + this.f30 + "\t" + this.f31 + "\t" + this.f32 + "\t" + this.f33 + "\n";
    }
    
    public static float s(final Matrix4 matrix4, final float n, final float n2, final float n3) {
        return matrix4.f03 * n + matrix4.f13 * n2 + matrix4.f23 * n3 + matrix4.f33;
    }
}
