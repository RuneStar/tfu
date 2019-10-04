/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

public final class K299 {
    public static final K299 g = new K299(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
    public final float b;
    public final float d;
    public final float e;
    public final float h;
    public final float j;
    public final float l;
    public final float q;
    public final float r;
    public final float s;
    public final float v;
    public final float w;
    public final float y;

    public static float[] g(K299 k299, float[] arrf, int n) {
        arrf[0 + n] = k299.d;
        arrf[1 + n] = k299.q;
        arrf[2 + n] = k299.j;
        arrf[3 + n] = 0.0f;
        arrf[4 + n] = k299.e;
        arrf[5 + n] = k299.h;
        arrf[6 + n] = k299.s;
        arrf[7 + n] = 0.0f;
        arrf[8 + n] = k299.b;
        arrf[9 + n] = k299.l;
        arrf[10 + n] = k299.w;
        arrf[11 + n] = 0.0f;
        arrf[12 + n] = k299.r;
        arrf[13 + n] = k299.v;
        arrf[14 + n] = k299.y;
        arrf[15 + n] = 1.0f;
        return arrf;
    }

    public String toString() {
        return this.d + "," + this.e + "," + this.b + "," + this.r + " - " + this.q + "," + this.h + "," + this.l + "," + this.v + " - " + this.j + "," + this.s + "," + this.w + "," + this.y;
    }

    public K299(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        this.d = f;
        this.q = f5;
        this.j = f9;
        this.e = f2;
        this.h = f6;
        this.s = f10;
        this.b = f3;
        this.l = f7;
        this.w = f11;
        this.r = f4;
        this.v = f8;
        this.y = f12;
    }
}

