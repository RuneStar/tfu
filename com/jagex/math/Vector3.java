// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.math;

import tfu.Gg3;
import tfu.Be2;
import tfu.Bs1;
import tfu.Kl267;
import tfu.Kn266;

@Deprecated
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public class Vector3 implements D99, Kn266, Kl267
{
    private static Vector3[] d;
    public static final Vector3 g;
    private static int j;
    private static int q;
    public float x;
    public float y;
    public float z;
    
    public Vector3(final Gg3 gg3, final int n) {
        final float n2 = (float)Math.pow(10.0, n);
        this.x = Gg3.by(gg3) / n2;
        this.y = Gg3.by(gg3) / n2;
        this.z = Gg3.by(gg3) / n2;
    }
    
    public static Vector3 d(final Vector3 vector3) {
        synchronized (Vector3.d) {
            if (Vector3.j == 0) {
                return new Vector3(vector3);
            }
            e(Vector3.d[--Vector3.j], vector3);
            return Vector3.d[Vector3.j];
        }
    }
    
    @Bs1
    @Be2
    public Vector3(final float x, final float y, final float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector3(final Vector3 vector3) {
        this.x = vector3.x;
        this.y = vector3.y;
        this.z = vector3.z;
    }
    
    public static void j(final Vector3 vector3, final float x, final float y, final float z) {
        vector3.x = x;
        vector3.y = y;
        vector3.z = z;
    }
    
    public static void e(final Vector3 vector3, final Vector3 vector4) {
        j(vector3, vector4.x, vector4.y, vector4.z);
    }
    
    public Vector3() {
    }
    
    public static Vector3 h(final Vector3 vector3) {
        return d(vector3);
    }
    
    static {
        g = new Vector3(0.0f, 0.0f, 0.0f);
        Vector3.d = new Vector3[0];
    }
    
    public static Vector3 g(final float n, final float n2, final float n3) {
        synchronized (Vector3.d) {
            if (Vector3.j == 0) {
                return new Vector3(n, n2, n3);
            }
            j(Vector3.d[--Vector3.j], n, n2, n3);
            return Vector3.d[Vector3.j];
        }
    }
    
    public Vector3(final Gg3 gg3) {
        this.x = Gg3.bl(gg3);
        this.y = Gg3.bl(gg3);
        this.z = Gg3.bl(gg3);
    }
    
    @Override
    public String toString() {
        return String.format("{Vector 3: %f,%f,%f}", this.x, this.y, this.z);
    }
}
