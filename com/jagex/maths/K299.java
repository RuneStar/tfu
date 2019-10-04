// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

public final class K299
{
    public static final K299 g;
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
    
    public static float[] g(final K299 k299, final float[] array, final int n) {
        array[0 + n] = k299.d;
        array[1 + n] = k299.q;
        array[2 + n] = k299.j;
        array[3 + n] = 0.0f;
        array[4 + n] = k299.e;
        array[5 + n] = k299.h;
        array[6 + n] = k299.s;
        array[7 + n] = 0.0f;
        array[8 + n] = k299.b;
        array[9 + n] = k299.l;
        array[10 + n] = k299.w;
        array[11 + n] = 0.0f;
        array[12 + n] = k299.r;
        array[13 + n] = k299.v;
        array[14 + n] = k299.y;
        array[15 + n] = 1.0f;
        return array;
    }
    
    @Override
    public String toString() {
        return this.d + "," + this.e + "," + this.b + "," + this.r + " - " + this.q + "," + this.h + "," + this.l + "," + this.v + " - " + this.j + "," + this.s + "," + this.w + "," + this.y;
    }
    
    static {
        g = new K299(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
    }
    
    public K299(final float d, final float e, final float b, final float r, final float q, final float h, final float l, final float v, final float j, final float s, final float w, final float y) {
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
        this.h = h;
        this.s = s;
        this.b = b;
        this.l = l;
        this.w = w;
        this.r = r;
        this.v = v;
        this.y = y;
    }
}
