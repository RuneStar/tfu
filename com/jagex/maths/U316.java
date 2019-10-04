// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import java.util.Arrays;

public final class U316
{
    public float[] g;
    
    public static U316 g(final U316 u316) {
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
    
    public U316(final Matrix4 matrix4) {
        this.g = new float[16];
        d(this, matrix4);
    }
    
    public U316(final U316 u316) {
        this.g = new float[16];
        q(this, u316);
    }
    
    public U316(final float[] array) {
        System.arraycopy(array, 0, this.g = new float[16], 0, 16);
    }
    
    public U316(final K299 k299) {
        K299.g(k299, this.g = new float[16], 0);
    }
    
    public U316(final H303 h303) {
        H303.r(h303, this.g = new float[16], 0);
    }
    
    public U316() {
        this.g = new float[16];
        g(this);
    }
    
    public static U316 q(final U316 u316, final U316 u317) {
        System.arraycopy(u317.g, 0, u316.g, 0, 16);
        return u316;
    }
    
    public static U316 j(final U316 u316, final Matrix4 matrix4) {
        final float n = u316.g[0] * matrix4.f00 + u316.g[1] * matrix4.f10 + u316.g[2] * matrix4.f20 + u316.g[3] * matrix4.f30;
        final float n2 = u316.g[0] * matrix4.f01 + u316.g[1] * matrix4.f11 + u316.g[2] * matrix4.f21 + u316.g[3] * matrix4.f31;
        final float n3 = u316.g[0] * matrix4.f02 + u316.g[1] * matrix4.f12 + u316.g[2] * matrix4.f22 + u316.g[3] * matrix4.f32;
        final float n4 = u316.g[0] * matrix4.f03 + u316.g[1] * matrix4.f13 + u316.g[2] * matrix4.f23 + u316.g[3] * matrix4.f33;
        final float n5 = u316.g[4] * matrix4.f00 + u316.g[5] * matrix4.f10 + u316.g[6] * matrix4.f20 + u316.g[7] * matrix4.f30;
        final float n6 = u316.g[4] * matrix4.f01 + u316.g[5] * matrix4.f11 + u316.g[6] * matrix4.f21 + u316.g[7] * matrix4.f31;
        final float n7 = u316.g[4] * matrix4.f02 + u316.g[5] * matrix4.f12 + u316.g[6] * matrix4.f22 + u316.g[7] * matrix4.f32;
        final float n8 = u316.g[4] * matrix4.f03 + u316.g[5] * matrix4.f13 + u316.g[6] * matrix4.f23 + u316.g[7] * matrix4.f33;
        final float n9 = u316.g[8] * matrix4.f00 + u316.g[9] * matrix4.f10 + u316.g[10] * matrix4.f20 + u316.g[11] * matrix4.f30;
        final float n10 = u316.g[8] * matrix4.f01 + u316.g[9] * matrix4.f11 + u316.g[10] * matrix4.f21 + u316.g[11] * matrix4.f31;
        final float n11 = u316.g[8] * matrix4.f02 + u316.g[9] * matrix4.f12 + u316.g[10] * matrix4.f22 + u316.g[11] * matrix4.f32;
        final float n12 = u316.g[8] * matrix4.f03 + u316.g[9] * matrix4.f13 + u316.g[10] * matrix4.f23 + u316.g[11] * matrix4.f33;
        final float n13 = u316.g[12] * matrix4.f00 + u316.g[13] * matrix4.f10 + u316.g[14] * matrix4.f20 + u316.g[15] * matrix4.f30;
        final float n14 = u316.g[12] * matrix4.f01 + u316.g[13] * matrix4.f11 + u316.g[14] * matrix4.f21 + u316.g[15] * matrix4.f31;
        final float n15 = u316.g[12] * matrix4.f02 + u316.g[13] * matrix4.f12 + u316.g[14] * matrix4.f22 + u316.g[15] * matrix4.f32;
        final float n16 = u316.g[12] * matrix4.f03 + u316.g[13] * matrix4.f13 + u316.g[14] * matrix4.f23 + u316.g[15] * matrix4.f33;
        u316.g[0] = n;
        u316.g[1] = n2;
        u316.g[2] = n3;
        u316.g[3] = n4;
        u316.g[4] = n5;
        u316.g[5] = n6;
        u316.g[6] = n7;
        u316.g[7] = n8;
        u316.g[8] = n9;
        u316.g[9] = n10;
        u316.g[10] = n11;
        u316.g[11] = n12;
        u316.g[12] = n13;
        u316.g[13] = n14;
        u316.g[14] = n15;
        u316.g[15] = n16;
        return u316;
    }
    
    @Override
    public int hashCode() {
        return 31 * 1 + Arrays.hashCode(this.g);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof U316)) {
            return false;
        }
        final U316 u316 = (U316)o;
        for (int i = 0; i < 16; ++i) {
            if (this.g[i] != u316.g[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static U316 e(final U316 u316, final H303 h303) {
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
    
    public static U316 d(final U316 u316, final Matrix4 matrix4) {
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
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (j > 0) {
                    sb.append("\t");
                }
                sb.append(this.g[i * 4 + j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
