// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

public final class H303
{
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
    
    public H303(final H303 h303) {
        d(this, h303);
    }
    
    public static H303 d(final H303 h303, final H303 h304) {
        h303.g = h304.g;
        h303.j = h304.j;
        h303.s = h304.s;
        h303.w = h304.w;
        h303.d = h304.d;
        h303.e = h304.e;
        h303.b = h304.b;
        h303.r = h304.r;
        h303.q = h304.q;
        h303.h = h304.h;
        h303.l = h304.l;
        h303.v = h304.v;
        return h303;
    }
    
    public H303() {
        e(this);
    }
    
    public static H303 e(final H303 h303) {
        final float d = 0.0f;
        h303.v = d;
        h303.r = d;
        h303.w = d;
        h303.b = d;
        h303.s = d;
        h303.h = d;
        h303.j = d;
        h303.q = d;
        h303.d = d;
        final float g = 1.0f;
        h303.l = g;
        h303.e = g;
        h303.g = g;
        return h303;
    }
    
    public static H303 h(final H303 h303, final Quaternion quaternion) {
        s(h303, quaternion.x, quaternion.y, quaternion.z, quaternion.w);
        return h303;
    }
    
    public static H303 b(final H303 h303, final Vector3 vector3) {
        l(h303, vector3.x, vector3.y, vector3.z);
        return h303;
    }
    
    public static H303 l(final H303 h303, final float n, final float n2, final float n3) {
        h303.w += n;
        h303.r += n2;
        h303.v += n3;
        return h303;
    }
    
    public static H303 w(final H303 h303, final float[] array) {
        final float n = array[0] - h303.w;
        final float n2 = array[1] - h303.r;
        final float n3 = array[2] - h303.v;
        array[0] = (float)(int)(h303.g * n + h303.d * n2 + h303.q * n3);
        array[1] = (float)(int)(h303.j * n + h303.e * n2 + h303.h * n3);
        array[2] = (float)(int)(h303.s * n + h303.b * n2 + h303.l * n3);
        return h303;
    }
    
    public static float[] r(final H303 h303, final float[] array, final int n) {
        array[0 + n] = h303.g;
        array[1 + n] = h303.d;
        array[2 + n] = h303.q;
        array[3 + n] = 0.0f;
        array[4 + n] = h303.j;
        array[5 + n] = h303.e;
        array[6 + n] = h303.h;
        array[7 + n] = 0.0f;
        array[8 + n] = h303.s;
        array[9 + n] = h303.b;
        array[10 + n] = h303.l;
        array[11 + n] = 0.0f;
        array[12 + n] = h303.w;
        array[13 + n] = h303.r;
        array[14 + n] = h303.v;
        array[15 + n] = 1.0f;
        return array;
    }
    
    @Override
    public String toString() {
        return this.g + "," + this.j + "," + this.s + "," + this.w + " - " + this.d + "," + this.e + "," + this.b + "," + this.r + " - " + this.q + "," + this.h + "," + this.l + "," + this.v;
    }
    
    public static H303 s(final H303 h303, final float n, final float n2, final float n3, final float n4) {
        final float n5 = n * n;
        final float n6 = n * n2;
        final float n7 = n * n3;
        final float n8 = n * n4;
        final float n9 = n2 * n2;
        final float n10 = n2 * n3;
        final float n11 = n2 * n4;
        final float n12 = n3 * n3;
        final float n13 = n3 * n4;
        h303.g = 1.0f - 2.0f * (n9 + n12);
        h303.j = 2.0f * (n6 - n13);
        h303.s = 2.0f * (n7 + n11);
        h303.d = 2.0f * (n6 + n13);
        h303.e = 1.0f - 2.0f * (n5 + n12);
        h303.b = 2.0f * (n10 - n8);
        h303.q = 2.0f * (n7 - n11);
        h303.h = 2.0f * (n10 + n8);
        h303.l = 1.0f - 2.0f * (n5 + n9);
        final float w = 0.0f;
        h303.v = w;
        h303.r = w;
        h303.w = w;
        return h303;
    }
    
    public H303(final K299 k299) {
        g(this, k299);
    }
    
    public static H303 g(final H303 h303, final K299 k299) {
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
    
    public static H303 j(final H303 h303, final float g, final float j, final float s, final float w, final float d, final float e, final float b, final float r, final float q, final float h304, final float l, final float v) {
        h303.g = g;
        h303.d = d;
        h303.q = q;
        h303.j = j;
        h303.e = e;
        h303.h = h304;
        h303.s = s;
        h303.b = b;
        h303.l = l;
        h303.w = w;
        h303.r = r;
        h303.v = v;
        return h303;
    }
    
    public H303(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8, final float n9, final float n10, final float n11, final float n12) {
        j(this, n, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12);
    }
    
    public static H303 q(final H303 h303, final RotTrans rotTrans) {
        h(h303, rotTrans.rot);
        b(h303, rotTrans.trans);
        return h303;
    }
}
