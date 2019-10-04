// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

public final class Z165 implements G300
{
    public I48 d;
    public O166 g;
    
    public static Z165 j(final Z165 z165, final RotTrans rotTrans) {
        O166.k(z165.g, rotTrans.rot);
        I48.al(z165.d, rotTrans.rot);
        I48.n(z165.d, rotTrans.trans);
        return z165;
    }
    
    public Z165(final RotTrans rotTrans) {
        this.g = new O166();
        this.d = new I48();
        g(this, rotTrans);
    }
    
    public static Z165 d(final Z165 z165, final Z165 z166) {
        O166.s(z165.g, z166.g);
        I48.u(z165.d, z166.d);
        return z165;
    }
    
    public static Z165 s(final Z165 z165, final RotTrans rotTrans, final float n) {
        O166.f(z165.g, rotTrans.rot, n);
        I48.av(z165.d, rotTrans.trans, n);
        return z165;
    }
    
    public Z165(final Quaternion quaternion, final I48 i48) {
        this.g = new O166(quaternion);
        this.d = new I48(i48);
    }
    
    public Z165(final Z165 z165) {
        this.g = new O166();
        this.d = new I48();
        d(this, z165);
    }
    
    public Z165(final O166 o166, final I48 i48) {
        this.g = new O166(o166);
        this.d = new I48(i48);
    }
    
    public static Z165 g(final Z165 z165, final RotTrans rotTrans) {
        O166.h(z165.g, rotTrans.rot);
        I48.x(z165.d, rotTrans.trans);
        return z165;
    }
    
    public Z165(final O166 o166, final Vector3 vector3) {
        this.g = new O166(o166);
        this.d = new I48(vector3);
    }
    
    public static Z165 q(final Z165 z165) {
        O166.v(z165.g);
        I48.z(z165.d);
        return z165;
    }
    
    @Override
    public String toString() {
        return "[" + this.g.toString() + "|" + this.d.toString() + "]";
    }
    
    public static Z165 e(final Z165 z165, final RotTrans rotTrans) {
        final I48 r = I48.r(rotTrans.trans);
        I48.af(r, z165.g);
        I48.k(z165.d, r);
        I48.y(r);
        O166.o(z165.g, rotTrans.rot);
        return z165;
    }
    
    public static Z165 h(final Z165 z165, final Quaternion quaternion) {
        O166.o(z165.g, quaternion);
        return z165;
    }
    
    public Z165() {
        this.g = new O166();
        this.d = new I48();
    }
    
    public RotTrans b() {
        return new RotTrans(this.g.ag(), this.d.ao());
    }
    
    public Z165(final Quaternion quaternion, final Vector3 vector3) {
        this.g = new O166(quaternion);
        this.d = new I48(vector3);
    }
}
