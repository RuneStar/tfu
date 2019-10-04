/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.K299;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;

public final class H303 {
    public float b;
    public float d;
    public float e;
    public float g;
    public float h;
    public float j;
    public float l;
    public float q;
    public float r;
    public float s;
    public float v;
    public float w;

    public H303(H303 h303) {
        H303.d(this, h303);
    }

    public static H303 d(H303 h303, H303 h3032) {
        h303.g = h3032.g;
        h303.j = h3032.j;
        h303.s = h3032.s;
        h303.w = h3032.w;
        h303.d = h3032.d;
        h303.e = h3032.e;
        h303.b = h3032.b;
        h303.r = h3032.r;
        h303.q = h3032.q;
        h303.h = h3032.h;
        h303.l = h3032.l;
        h303.v = h3032.v;
        return h303;
    }

    public H303() {
        H303.e(this);
    }

    public static H303 e(H303 h303) {
        h303.v = 0.0f;
        h303.r = 0.0f;
        h303.w = 0.0f;
        h303.b = 0.0f;
        h303.s = 0.0f;
        h303.h = 0.0f;
        h303.j = 0.0f;
        h303.q = 0.0f;
        h303.d = 0.0f;
        h303.l = 1.0f;
        h303.e = 1.0f;
        h303.g = 1.0f;
        return h303;
    }

    public static H303 h(H303 h303, Quaternion quaternion) {
        H303.s(h303, quaternion.x, quaternion.y, quaternion.z, quaternion.w);
        return h303;
    }

    public static H303 b(H303 h303, Vector3 vector3) {
        H303.l(h303, vector3.x, vector3.y, vector3.z);
        return h303;
    }

    public static H303 l(H303 h303, float f, float f2, float f3) {
        h303.w += f;
        h303.r += f2;
        h303.v += f3;
        return h303;
    }

    public static H303 w(H303 h303, float[] arrf) {
        float f = arrf[0] - h303.w;
        float f2 = arrf[1] - h303.r;
        float f3 = arrf[2] - h303.v;
        arrf[0] = (int)(h303.g * f + h303.d * f2 + h303.q * f3);
        arrf[1] = (int)(h303.j * f + h303.e * f2 + h303.h * f3);
        arrf[2] = (int)(h303.s * f + h303.b * f2 + h303.l * f3);
        return h303;
    }

    public static float[] r(H303 h303, float[] arrf, int n) {
        arrf[0 + n] = h303.g;
        arrf[1 + n] = h303.d;
        arrf[2 + n] = h303.q;
        arrf[3 + n] = 0.0f;
        arrf[4 + n] = h303.j;
        arrf[5 + n] = h303.e;
        arrf[6 + n] = h303.h;
        arrf[7 + n] = 0.0f;
        arrf[8 + n] = h303.s;
        arrf[9 + n] = h303.b;
        arrf[10 + n] = h303.l;
        arrf[11 + n] = 0.0f;
        arrf[12 + n] = h303.w;
        arrf[13 + n] = h303.r;
        arrf[14 + n] = h303.v;
        arrf[15 + n] = 1.0f;
        return arrf;
    }

    public String toString() {
        return this.g + "," + this.j + "," + this.s + "," + this.w + " - " + this.d + "," + this.e + "," + this.b + "," + this.r + " - " + this.q + "," + this.h + "," + this.l + "," + this.v;
    }

    public static H303 s(H303 h303, float f, float f2, float f3, float f4) {
        float f5 = f * f;
        float f6 = f * f2;
        float f7 = f * f3;
        float f8 = f * f4;
        float f9 = f2 * f2;
        float f10 = f2 * f3;
        float f11 = f2 * f4;
        float f12 = f3 * f3;
        float f13 = f3 * f4;
        h303.g = 1.0f - 2.0f * (f9 + f12);
        h303.j = 2.0f * (f6 - f13);
        h303.s = 2.0f * (f7 + f11);
        h303.d = 2.0f * (f6 + f13);
        h303.e = 1.0f - 2.0f * (f5 + f12);
        h303.b = 2.0f * (f10 - f8);
        h303.q = 2.0f * (f7 - f11);
        h303.h = 2.0f * (f10 + f8);
        h303.l = 1.0f - 2.0f * (f5 + f9);
        h303.v = 0.0f;
        h303.r = 0.0f;
        h303.w = 0.0f;
        return h303;
    }

    public H303(K299 k299) {
        H303.g(this, k299);
    }

    public static H303 g(H303 h303, K299 k299) {
        h303.g = k299.d;
        h303.j = k299.e;
        h303.s = k299.b;
        h303.w = k299.r;
        h303.d = k299.q;
        h303.e = k299.h;
        h303.b = k299.l;
        h303.r = k299.v;
        h303.q = k299.j;
        h303.h = k299.s;
        h303.l = k299.w;
        h303.v = k299.y;
        return h303;
    }

    public static H303 j(H303 h303, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        h303.g = f;
        h303.d = f5;
        h303.q = f9;
        h303.j = f2;
        h303.e = f6;
        h303.h = f10;
        h303.s = f3;
        h303.b = f7;
        h303.l = f11;
        h303.w = f4;
        h303.r = f8;
        h303.v = f12;
        return h303;
    }

    public H303(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        H303.j(this, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12);
    }

    public static H303 q(H303 h303, RotTrans rotTrans) {
        H303.h(h303, rotTrans.rot);
        H303.b(h303, rotTrans.trans);
        return h303;
    }
}

