// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.math;

import tfu.Gg3;
import tfu.Be2;
import tfu.Bs1;

@Deprecated
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class Quaternion implements D99
{
    private static int d;
    private static Quaternion[] g;
    public static final Quaternion j;
    private static int q;
    public float w;
    public float x;
    public float y;
    public float z;
    
    public static Quaternion g() {
        synchronized (Quaternion.g) {
            if (Quaternion.q == 0) {
                return new Quaternion();
            }
            b(Quaternion.g[--Quaternion.q]);
            return Quaternion.g[Quaternion.q];
        }
    }
    
    public static void d(final Quaternion quaternion) {
        synchronized (Quaternion.g) {
            if (Quaternion.q < Quaternion.d - 1) {
                Quaternion.g[Quaternion.q++] = quaternion;
            }
        }
    }
    
    public Quaternion(final Quaternion quaternion) {
        q(this, quaternion);
    }
    
    public static void s(final Quaternion quaternion, final float n, final float n2, final float n3) {
        e(quaternion, Vector3.g(0.0f, 1.0f, 0.0f), n);
        final Quaternion g = g();
        e(g, Vector3.g(1.0f, 0.0f, 0.0f), n2);
        l(quaternion, g);
        e(g, Vector3.g(0.0f, 0.0f, 1.0f), n3);
        l(quaternion, g);
        d(g);
    }
    
    public Quaternion(final Gg3 gg3) {
        this.x = Gg3.bl(gg3);
        this.y = Gg3.bl(gg3);
        this.z = Gg3.bl(gg3);
        this.w = Gg3.bl(gg3);
    }
    
    public static void q(final Quaternion quaternion, final Quaternion quaternion2) {
        quaternion.x = quaternion2.x;
        quaternion.y = quaternion2.y;
        quaternion.z = quaternion2.z;
        quaternion.w = quaternion2.w;
    }
    
    public static void j(final Quaternion quaternion, final float x, final float y, final float z, final float w) {
        quaternion.x = x;
        quaternion.y = y;
        quaternion.z = z;
        quaternion.w = w;
    }
    
    public static void h(final Quaternion quaternion, final float n, final float n2, final float n3, final float n4) {
        final float n5 = (float)Math.sin(n4 * 0.5f);
        final float w = (float)Math.cos(n4 * 0.5f);
        quaternion.x = n * n5;
        quaternion.y = n2 * n5;
        quaternion.z = n3 * n5;
        quaternion.w = w;
    }
    
    public static final void b(final Quaternion quaternion) {
        final float x = 0.0f;
        quaternion.z = x;
        quaternion.y = x;
        quaternion.x = x;
        quaternion.w = 1.0f;
    }
    
    public static final void l(final Quaternion quaternion, final Quaternion quaternion2) {
        j(quaternion, quaternion2.w * quaternion.x + quaternion2.x * quaternion.w + quaternion2.y * quaternion.z - quaternion2.z * quaternion.y, quaternion2.w * quaternion.y - quaternion2.x * quaternion.z + quaternion2.y * quaternion.w + quaternion2.z * quaternion.x, quaternion2.w * quaternion.z + quaternion2.x * quaternion.y - quaternion2.y * quaternion.x + quaternion2.z * quaternion.w, quaternion2.w * quaternion.w - quaternion2.x * quaternion.x - quaternion2.y * quaternion.y - quaternion2.z * quaternion.z);
    }
    
    @Override
    public String toString() {
        return this.x + "," + this.y + "," + this.z + "," + this.w;
    }
    
    static {
        Quaternion.g = new Quaternion[0];
        j = new Quaternion();
    }
    
    public Quaternion(final float n, final float n2, final float n3) {
        s(this, n, n2, n3);
    }
    
    @Bs1
    @Be2
    public Quaternion(final float n, final float n2, final float n3, final float n4) {
        j(this, n, n2, n3, n4);
    }
    
    public static void e(final Quaternion quaternion, final Vector3 vector3, final float n) {
        h(quaternion, vector3.x, vector3.y, vector3.z, n);
    }
    
    public Quaternion() {
        b(this);
    }
}
