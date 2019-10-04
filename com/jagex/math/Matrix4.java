// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.math;

import java.util.Arrays;
import tfu.Be2;
import tfu.Bs1;

@Deprecated
@Bs1
@Be2
public final class Matrix4
{
    public static final Matrix4 g;
    public float[] f;
    
    @Override
    public int hashCode() {
        return 31 * 1 + Arrays.hashCode(this.f);
    }
    
    @Bs1
    @Be2
    public Matrix4(final float[] array) {
        System.arraycopy(array, 0, this.f = new float[16], 0, 16);
    }
    
    public static void g(final Matrix4 matrix4) {
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
    
    public static void d(final Matrix4 matrix4, final Matrix4 matrix5) {
        System.arraycopy(matrix5.f, 0, matrix4.f, 0, 16);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (j > 0) {
                    sb.append("\t");
                }
                sb.append(this.f[i * 4 + j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Matrix4)) {
            return false;
        }
        final Matrix4 matrix4 = (Matrix4)o;
        for (int i = 0; i < 16; ++i) {
            if (this.f[i] != matrix4.f[i]) {
                return false;
            }
        }
        return true;
    }
    
    public Matrix4() {
        this.f = new float[16];
        g(this);
    }
    
    static {
        g = new Matrix4();
    }
    
    public Matrix4(final G283 g283) {
        G283.j(g283, this.f = new float[16], 0);
    }
    
    public Matrix4(final Matrix4 matrix4) {
        this.f = new float[16];
        d(this, matrix4);
    }
}
