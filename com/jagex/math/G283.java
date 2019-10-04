/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.math;

@Deprecated
public class G283 {
    public static final G283 g = new G283();
    public float b;
    public float d;
    public float e;
    public float h;
    public float j;
    public float l;
    public float q;
    public float r;
    public float s;
    public float v;
    public float w;
    public float y;

    public G283(G283 g283) {
        G283.g(this, g283);
    }

    public String toString() {
        return this.d + "," + this.e + "," + this.b + "," + this.r + " - " + this.q + "," + this.h + "," + this.l + "," + this.v + " - " + this.j + "," + this.s + "," + this.w + "," + this.y;
    }

    public G283(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        G283.d(this, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12);
    }

    public static void d(G283 g283, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        g283.d = f;
        g283.q = f5;
        g283.j = f9;
        g283.e = f2;
        g283.h = f6;
        g283.s = f10;
        g283.b = f3;
        g283.l = f7;
        g283.w = f11;
        g283.r = f4;
        g283.v = f8;
        g283.y = f12;
    }

    public static void q(G283 g283) {
        g283.y = 0.0f;
        g283.v = 0.0f;
        g283.r = 0.0f;
        g283.l = 0.0f;
        g283.b = 0.0f;
        g283.s = 0.0f;
        g283.e = 0.0f;
        g283.j = 0.0f;
        g283.q = 0.0f;
        g283.w = 1.0f;
        g283.h = 1.0f;
        g283.d = 1.0f;
    }

    public static float[] j(G283 g283, float[] arrf, int n) {
        arrf[0 + n] = g283.d;
        arrf[1 + n] = g283.q;
        arrf[2 + n] = g283.j;
        arrf[3 + n] = 0.0f;
        arrf[4 + n] = g283.e;
        arrf[5 + n] = g283.h;
        arrf[6 + n] = g283.s;
        arrf[7 + n] = 0.0f;
        arrf[8 + n] = g283.b;
        arrf[9 + n] = g283.l;
        arrf[10 + n] = g283.w;
        arrf[11 + n] = 0.0f;
        arrf[12 + n] = g283.r;
        arrf[13 + n] = g283.v;
        arrf[14 + n] = g283.y;
        arrf[15 + n] = 1.0f;
        return arrf;
    }

    public G283() {
        G283.q(this);
    }

    public static void g(G283 g283, G283 g2832) {
        g283.d = g2832.d;
        g283.e = g2832.e;
        g283.b = g2832.b;
        g283.r = g2832.r;
        g283.q = g2832.q;
        g283.h = g2832.h;
        g283.l = g2832.l;
        g283.v = g2832.v;
        g283.j = g2832.j;
        g283.s = g2832.s;
        g283.w = g2832.w;
        g283.y = g2832.y;
    }
}

