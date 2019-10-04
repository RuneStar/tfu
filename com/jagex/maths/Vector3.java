// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Gg3;
import tfu.Be2;
import tfu.Bs1;
import tfu.Kl267;
import tfu.Lp301;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class Vector3 implements B164, Lp301, Kl267
{
    public static final Vector3 d;
    public static final Vector3 e;
    public static final Vector3 g;
    public static final Vector3 j;
    public static final Vector3 q;
    public final float x;
    public final float y;
    public final float z;
    
    public static Vector3 d(final Gg3 gg3) {
        return new Vector3(gg3);
    }
    
    @Bs1
    @Be2
    public Vector3(final float x, final float y, final float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector3(final Gg3 gg3) {
        this.x = Gg3.bl(gg3);
        this.y = Gg3.bl(gg3);
        this.z = Gg3.bl(gg3);
    }
    
    public static Vector3 g(final float n, final float n2, final float n3) {
        return new Vector3(n, n2, n3);
    }
    
    public static int r(final Vector3 vector3) {
        return 12;
    }
    
    @Override
    public int hashCode() {
        return Float.floatToIntBits(this.x) + Float.floatToIntBits(this.y) + Float.floatToIntBits(this.z);
    }
    
    public static void w(final Vector3 vector3, final Gg3 gg3) {
        Gg3.aq(gg3, vector3.x);
        Gg3.aq(gg3, vector3.y);
        Gg3.aq(gg3, vector3.z);
    }
    
    public static boolean v(final Vector3 vector3, final Vector3 vector4) {
        return vector4 != null && Float.floatToIntBits(vector3.x) == Float.floatToIntBits(vector4.x) && Float.floatToIntBits(vector3.y) == Float.floatToIntBits(vector4.y) && Float.floatToIntBits(vector3.z) == Float.floatToIntBits(vector4.z);
    }
    
    public static final Vector3 k(final Vector3 vector3, final Vector3 vector4) {
        return g(vector3.x - vector4.x, vector3.y - vector4.y, vector3.z - vector4.z);
    }
    
    public static boolean p(final Vector3 vector3, final Vector3 vector4, final float n) {
        return Math.abs(vector4.x - vector3.x) <= n && Math.abs(vector4.y - vector3.y) <= n && Math.abs(vector4.z - vector3.z) <= n;
    }
    
    public static final Vector3 u(final Vector3 vector3) {
        final float n = 1.0f / f(vector3);
        return g(vector3.x * n, vector3.y * n, vector3.z * n);
    }
    
    public static final Vector3 z(final Vector3 vector3, final Vector3 vector4) {
        return g(vector3.x + vector4.x, vector3.y + vector4.y, vector3.z + vector4.z);
    }
    
    public static final Vector3 m(final Vector3 vector3, final float n, final float n2, final float n3) {
        return g(vector3.x + n, vector3.y + n2, vector3.z + n3);
    }
    
    public static final Vector3 n(final Vector3 vector3, final Vector3 vector4, final float n) {
        return g(vector3.x + vector4.x * n, vector3.y + vector4.y * n, vector3.z + vector4.z * n);
    }
    
    public Vector3 ao() {
        return new Vector3(-this.x, this.y, -this.z);
    }
    
    public static final Vector3 i(final Vector3 vector3, final float n, final float n2, final float n3) {
        return g(vector3.x - n, vector3.y - n2, vector3.z - n3);
    }
    
    public static final float o(final Vector3 vector3, final Vector3 vector4) {
        return vector3.x * vector4.x + vector3.y * vector4.y + vector3.z * vector4.z;
    }
    
    public static Vector3 ap(final Vector3 vector3) {
        return vector3;
    }
    
    public Vector3 an(final float n) {
        return new Vector3(this.x, n, this.z);
    }
    
    public static final float c(final Vector3 vector3) {
        return vector3.x * vector3.x + vector3.y * vector3.y + vector3.z * vector3.z;
    }
    
    public static float ag(final Vector3 vector3, final Vector3 vector4) {
        final float n = vector4.x - vector3.x;
        final float n2 = vector4.y - vector3.y;
        final float n3 = vector4.z - vector3.z;
        return (float)Math.sqrt(n * n + n2 * n2 + n3 * n3);
    }
    
    public static final Vector3 ai(final Vector3 vector3, final float n) {
        return g(vector3.x * n, vector3.y * n, vector3.z * n);
    }
    
    public static final Vector3 al(final Vector3 vector3, final Quaternion quaternion) {
        final Quaternion g = Quaternion.g(vector3.x, vector3.y, vector3.z, 0.0f);
        final O166 j = O166.j(quaternion.s());
        O166.k(j, g);
        O166.k(j, quaternion);
        return g(j.j, j.e, j.h);
    }
    
    public static final Vector3 af(final Vector3 vector3, final M47 m47) {
        return g(m47.f00 * vector3.x + m47.f10 * vector3.y + m47.f20 * vector3.z, m47.f01 * vector3.x + m47.f11 * vector3.y + m47.f21 * vector3.z, m47.f02 * vector3.x + m47.f12 * vector3.y + m47.f22 * vector3.z);
    }
    
    public static final Vector3 av(final Vector3 vector3, final Vector3 vector4, final float n) {
        return g(vector3.x + (vector4.x - vector3.x) * n, vector3.y + (vector4.y - vector3.y) * n, vector3.z + (vector4.z - vector3.z) * n);
    }
    
    @Override
    public String toString() {
        return String.format("{ Vector3: %.3f,%.3f,%.3f }", this.x, this.y, this.z);
    }
    
    @Override
    public Vector3 e() {
        return this;
    }
    
    @Override
    public Vector3 j() {
        return this;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof I48) {
            return y(this, (I48)o);
        }
        return v(this, (Vector3)o);
    }
    
    public Vector3(final Gg3 gg3, final int n) {
        final float n2 = (float)Math.pow(10.0, n);
        this.x = Gg3.by(gg3) / n2;
        this.y = Gg3.by(gg3) / n2;
        this.z = Gg3.by(gg3) / n2;
    }
    
    public static final Vector3 t(final Vector3 vector3, final I48 i48) {
        return g(vector3.x + i48.j, vector3.y + i48.e, vector3.z + i48.h);
    }
    
    public static float aq(final Vector3 vector3, final Vector3 vector4) {
        final float n = vector4.x - vector3.x;
        final float n2 = vector4.y - vector3.y;
        final float n3 = vector4.z - vector3.z;
        return n * n + n2 * n2 + n3 * n3;
    }
    
    public static final Vector3 a(final Vector3 vector3, final Vector3 vector4) {
        return g(vector3.y * vector4.z - vector3.z * vector4.y, vector3.z * vector4.x - vector3.x * vector4.z, vector3.x * vector4.y - vector3.y * vector4.x);
    }
    
    public Vector3 aa(final float n) {
        return new Vector3(n, this.y, this.z);
    }
    
    public static boolean y(final Vector3 vector3, final I48 i48) {
        return i48 != null && Float.floatToIntBits(vector3.x) == Float.floatToIntBits(i48.j) && Float.floatToIntBits(vector3.y) == Float.floatToIntBits(i48.e) && Float.floatToIntBits(vector3.z) == Float.floatToIntBits(i48.h);
    }
    
    public static final Vector3 x(final Vector3 vector3) {
        return g(-vector3.x, -vector3.y, -vector3.z);
    }
    
    static {
        g = new Vector3(0.0f, 0.0f, 0.0f);
        d = new Vector3(1.0f, 0.0f, 0.0f);
        q = new Vector3(0.0f, 1.0f, 0.0f);
        j = new Vector3(0.0f, 0.0f, 1.0f);
        e = new Vector3(Float.NaN, Float.NaN, Float.NaN);
    }
    
    public static final float f(final Vector3 vector3) {
        return (float)Math.sqrt(c(vector3));
    }
}
