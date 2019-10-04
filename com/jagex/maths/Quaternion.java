// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Gg3;
import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class Quaternion implements B164
{
    public static final Quaternion g;
    public final float w;
    public final float x;
    public final float y;
    public final float z;
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof O166) {
            return z(this, (O166)o);
        }
        return u(this, (Quaternion)o);
    }
    
    public static Quaternion d(final Gg3 gg3) {
        return new Quaternion(gg3);
    }
    
    public static Quaternion e(final float n, final float n2, final float n3, final float n4) {
        final float n5 = (float)Math.sin(n4 * 0.5f);
        return new Quaternion(n * n5, n2 * n5, n3 * n5, (float)Math.cos(n4 * 0.5f));
    }
    
    public static boolean z(final Quaternion quaternion, final O166 o166) {
        return o166 != null && Float.floatToIntBits(quaternion.x) == Float.floatToIntBits(o166.j) && Float.floatToIntBits(quaternion.y) == Float.floatToIntBits(o166.e) && Float.floatToIntBits(quaternion.z) == Float.floatToIntBits(o166.h) && Float.floatToIntBits(quaternion.w) == Float.floatToIntBits(o166.s);
    }
    
    public static void q(final Quaternion quaternion, final Gg3 gg3) {
        Gg3.aq(gg3, quaternion.x);
        Gg3.aq(gg3, quaternion.y);
        Gg3.aq(gg3, quaternion.z);
        Gg3.aq(gg3, quaternion.w);
    }
    
    public static Quaternion j(final Vector3 vector3, final float n) {
        return e(vector3.x, vector3.y, vector3.z, n);
    }
    
    public static Quaternion g(final float n, final float n2, final float n3, final float n4) {
        return new Quaternion(n, n2, n3, n4);
    }
    
    public static Quaternion h(final float n, final float n2, final float n3) {
        final O166 o166 = new O166();
        O166.l(o166, Vector3.g(0.0f, 1.0f, 0.0f), n);
        final O166 d = O166.d();
        O166.l(d, Vector3.g(1.0f, 0.0f, 0.0f), n2);
        O166.i(o166, d);
        O166.l(d, Vector3.g(0.0f, 0.0f, 1.0f), n3);
        O166.i(o166, d);
        O166.e(d);
        return o166.ag();
    }
    
    public final Quaternion b() {
        final float n = 1.0f / w(this);
        return new Quaternion(this.x * n, this.y * n, this.z * n, this.w * n);
    }
    
    public final Quaternion s() {
        return new Quaternion(-this.x, -this.y, -this.z, this.w);
    }
    
    public static final float w(final Quaternion quaternion) {
        return (float)Math.sqrt(l(quaternion, quaternion));
    }
    
    public final Quaternion r(final Quaternion quaternion) {
        return new Quaternion(quaternion.w * this.x + quaternion.x * this.w + quaternion.y * this.z - quaternion.z * this.y, quaternion.w * this.y - quaternion.x * this.z + quaternion.y * this.w + quaternion.z * this.x, quaternion.w * this.z + quaternion.x * this.y - quaternion.y * this.x + quaternion.z * this.w, quaternion.w * this.w - quaternion.x * this.x - quaternion.y * this.y - quaternion.z * this.z);
    }
    
    public final Quaternion p(final Quaternion quaternion, final float n) {
        final O166 o166 = new O166(this);
        if (O166.t(o166, quaternion) < 0.0f) {
            O166.y(o166);
        }
        O166.a(o166, 1.0f - n);
        O166.z(o166, quaternion, n);
        O166.x(o166);
        return o166.ag();
    }
    
    public Vector3 x() {
        float w = this.w;
        if (w > 1.0f) {
            w = 1.0f;
        }
        else if (w < -1.0f) {
            w = -1.0f;
        }
        final float n = (float)(Math.acos(w) * 2.0);
        if (n == 0.0f) {
            return Vector3.g;
        }
        final I48 i48 = new I48(this.x, this.y, this.z);
        if (this.x != 0.0f || this.y != 0.0f || this.z != 0.0f) {
            I48.m(i48);
            I48.aq(i48, n);
        }
        return i48.ao();
    }
    
    @Override
    public int hashCode() {
        return Float.floatToIntBits(this.x) + Float.floatToIntBits(this.y) + Float.floatToIntBits(this.z) + Float.floatToIntBits(this.w);
    }
    
    public M47 m() {
        final float n = this.w * this.w;
        final float n2 = this.w * this.x;
        final float n3 = this.w * this.y;
        final float n4 = this.w * this.z;
        final float n5 = this.x * this.x;
        final float n6 = this.x * this.y;
        final float n7 = this.x * this.z;
        final float n8 = this.y * this.y;
        final float n9 = this.y * this.z;
        final float n10 = this.z * this.z;
        return new M47(n5 + n - n10 - n8, n6 + n4 + n6 + n4, n7 - n3 - n3 + n7, n6 - n4 - n4 + n6, n8 + n - n5 - n10, n9 + n2 + n9 + n2, n7 + n3 + n7 + n3, n9 - n2 - n2 + n9, n10 + n - n8 - n5);
    }
    
    public static boolean u(final Quaternion quaternion, final Quaternion quaternion2) {
        return quaternion2 != null && Float.floatToIntBits(quaternion.x) == Float.floatToIntBits(quaternion2.x) && Float.floatToIntBits(quaternion.y) == Float.floatToIntBits(quaternion2.y) && Float.floatToIntBits(quaternion.z) == Float.floatToIntBits(quaternion2.z) && Float.floatToIntBits(quaternion.w) == Float.floatToIntBits(quaternion2.w);
    }
    
    public Quaternion(final Gg3 gg3) {
        this.x = Gg3.bl(gg3);
        this.y = Gg3.bl(gg3);
        this.z = Gg3.bl(gg3);
        this.w = Gg3.bl(gg3);
    }
    
    @Override
    public String toString() {
        return String.format("{ Quaternion: %.3f,%.3f,%.3f,%.3f }", this.x, this.y, this.z, this.w);
    }
    
    public final Quaternion y(final float n) {
        return new Quaternion(this.x * n, this.y * n, this.z * n, this.w * n);
    }
    
    static {
        g = new Quaternion(0.0f, 0.0f, 0.0f, 1.0f);
    }
    
    @Bs1
    @Be2
    public Quaternion(final float x, final float y, final float z, final float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    public static final float l(final Quaternion quaternion, final Quaternion quaternion2) {
        return quaternion.x * quaternion2.x + quaternion.y * quaternion2.y + quaternion.z * quaternion2.z + quaternion.w * quaternion2.w;
    }
    
    public final Quaternion v(final Quaternion quaternion) {
        return new Quaternion(this.w * quaternion.x + this.x * quaternion.w + this.y * quaternion.z - this.z * quaternion.y, this.w * quaternion.y - this.x * quaternion.z + this.y * quaternion.w + this.z * quaternion.x, this.w * quaternion.z + this.x * quaternion.y - this.y * quaternion.x + this.z * quaternion.w, this.w * quaternion.w - this.x * quaternion.x - this.y * quaternion.y - this.z * quaternion.z);
    }
    
    public static boolean t(final Quaternion quaternion, final Quaternion quaternion2, final float n) {
        return quaternion2.x - quaternion.x <= n && quaternion2.x - quaternion.x >= -n && quaternion2.y - quaternion.y <= n && quaternion2.y - quaternion.y >= -n && quaternion2.z - quaternion.z <= n && quaternion2.z - quaternion.z >= -n && quaternion2.w - quaternion.w <= n && quaternion2.w - quaternion.w >= -n;
    }
}
