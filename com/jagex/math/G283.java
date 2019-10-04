// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.math;

@Deprecated
public class G283
{
    public static final G283 g;
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
    
    public G283(final G283 g283) {
        g(this, g283);
    }
    
    @Override
    public String toString() {
        return this.d + "," + this.e + "," + this.b + "," + this.r + " - " + this.q + "," + this.h + "," + this.l + "," + this.v + " - " + this.j + "," + this.s + "," + this.w + "," + this.y;
    }
    
    public G283(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8, final float n9, final float n10, final float n11, final float n12) {
        d(this, n, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12);
    }
    
    public static void d(final G283 g283, final float d, final float e, final float b, final float r, final float q, final float h, final float l, final float v, final float j, final float s, final float w, final float y) {
        g283.d = d;
        g283.q = q;
        g283.j = j;
        g283.e = e;
        g283.h = h;
        g283.s = s;
        g283.b = b;
        g283.l = l;
        g283.w = w;
        g283.r = r;
        g283.v = v;
        g283.y = y;
    }
    
    public static void q(final G283 g283) {
        final float q = 0.0f;
        g283.y = q;
        g283.v = q;
        g283.r = q;
        g283.l = q;
        g283.b = q;
        g283.s = q;
        g283.e = q;
        g283.j = q;
        g283.q = q;
        final float d = 1.0f;
        g283.w = d;
        g283.h = d;
        g283.d = d;
    }
    
    public static float[] j(final G283 g283, final float[] array, final int n) {
        array[0 + n] = g283.d;
        array[1 + n] = g283.q;
        array[2 + n] = g283.j;
        array[3 + n] = 0.0f;
        array[4 + n] = g283.e;
        array[5 + n] = g283.h;
        array[6 + n] = g283.s;
        array[7 + n] = 0.0f;
        array[8 + n] = g283.b;
        array[9 + n] = g283.l;
        array[10 + n] = g283.w;
        array[11 + n] = 0.0f;
        array[12 + n] = g283.r;
        array[13 + n] = g283.v;
        array[14 + n] = g283.y;
        array[15 + n] = 1.0f;
        return array;
    }
    
    public G283() {
        q(this);
    }
    
    static {
        g = new G283();
    }
    
    public static void g(final G283 g283, final G283 g284) {
        g283.d = g284.d;
        g283.e = g284.e;
        g283.b = g284.b;
        g283.r = g284.r;
        g283.q = g284.q;
        g283.h = g284.h;
        g283.l = g284.l;
        g283.v = g284.v;
        g283.j = g284.j;
        g283.s = g284.s;
        g283.w = g284.w;
        g283.y = g284.y;
    }
}
