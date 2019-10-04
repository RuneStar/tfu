// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
@Bs1
@Be2
public final class RotTrans implements B164
{
    public static final RotTrans g;
    public final Quaternion rot;
    public final Vector3 trans;
    
    public static boolean q(final RotTrans rotTrans, final RotTrans rotTrans2, final float n) {
        return Vector3.p(rotTrans.trans, rotTrans2.trans, n) && Quaternion.t(rotTrans.rot, rotTrans2.rot, n);
    }
    
    @Override
    public int hashCode() {
        return this.rot.hashCode() + this.trans.hashCode();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof Z165) {
            return d(this, (Z165)o);
        }
        return g(this, (RotTrans)o);
    }
    
    public RotTrans v(final float n, final float n2, final float n3) {
        return new RotTrans(this.rot, Vector3.i(this.trans, n, n2, n3));
    }
    
    public RotTrans j() {
        final Quaternion s = this.rot.s();
        return new RotTrans(s, Vector3.al(Vector3.x(this.trans), s));
    }
    
    public RotTrans h(final RotTrans rotTrans) {
        return new RotTrans(this.rot.v(rotTrans.rot), Vector3.z(this.trans, Vector3.al(rotTrans.trans, this.rot)));
    }
    
    public RotTrans s(final Quaternion quaternion) {
        return new RotTrans(this.rot.v(quaternion), this.trans);
    }
    
    public RotTrans l(final I48 i48) {
        return new RotTrans(this.rot, Vector3.t(this.trans, i48));
    }
    
    public RotTrans w(final float n, final float n2, final float n3) {
        return new RotTrans(this.rot, Vector3.m(this.trans, n, n2, n3));
    }
    
    public RotTrans e(final RotTrans rotTrans) {
        return new RotTrans(this.rot.r(rotTrans.rot), Vector3.z(Vector3.al(this.trans, rotTrans.rot), rotTrans.trans));
    }
    
    public RotTrans r(final Vector3 vector3, final float n) {
        return new RotTrans(this.rot, Vector3.n(this.trans, vector3, n));
    }
    
    public RotTrans p(final RotTrans rotTrans, final float n) {
        return new RotTrans(this.rot.p(rotTrans.rot, n), Vector3.av(this.trans, rotTrans.trans, n));
    }
    
    @Override
    public String toString() {
        return String.format("{ ScaleRotTrans: rot=%.3f,%.3f,%.3f,%.3f | trans=%.3f,%.3f,%.3f }", this.rot.x, this.rot.y, this.rot.z, this.rot.w, this.trans.x, this.trans.y, this.trans.z);
    }
    
    static {
        g = new RotTrans(Quaternion.g, Vector3.g);
    }
    
    public static boolean g(final RotTrans rotTrans, final RotTrans rotTrans2) {
        return rotTrans2 != null && Quaternion.u(rotTrans.rot, rotTrans2.rot) && Vector3.v(rotTrans.trans, rotTrans2.trans);
    }
    
    @Bs1
    @Be2
    public RotTrans(final Quaternion rot, final Vector3 trans) {
        this.rot = rot;
        this.trans = trans;
    }
    
    public RotTrans y(final float n) {
        return new RotTrans(this.rot, Vector3.ai(this.trans, n));
    }
    
    public static boolean d(final RotTrans rotTrans, final Z165 z165) {
        return z165 != null && Quaternion.z(rotTrans.rot, z165.g) && Vector3.y(rotTrans.trans, z165.d);
    }
    
    public RotTrans b(final Vector3 vector3) {
        return new RotTrans(this.rot, Vector3.z(this.trans, vector3));
    }
}
