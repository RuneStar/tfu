/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.G300;
import com.jagex.maths.I48;
import com.jagex.maths.O166;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;

public final class Z165
implements G300 {
    public I48 d;
    public O166 g;

    public static Z165 j(Z165 z165, RotTrans rotTrans) {
        O166.k(z165.g, rotTrans.rot);
        I48.al(z165.d, rotTrans.rot);
        I48.n(z165.d, rotTrans.trans);
        return z165;
    }

    public Z165(RotTrans rotTrans) {
        this.g = new O166();
        this.d = new I48();
        Z165.g(this, rotTrans);
    }

    public static Z165 d(Z165 z165, Z165 z1652) {
        O166.s(z165.g, z1652.g);
        I48.u(z165.d, z1652.d);
        return z165;
    }

    public static Z165 s(Z165 z165, RotTrans rotTrans, float f) {
        O166.f(z165.g, rotTrans.rot, f);
        I48.av(z165.d, rotTrans.trans, f);
        return z165;
    }

    public Z165(Quaternion quaternion, I48 i48) {
        this.g = new O166(quaternion);
        this.d = new I48(i48);
    }

    public Z165(Z165 z165) {
        this.g = new O166();
        this.d = new I48();
        Z165.d(this, z165);
    }

    public Z165(O166 o166, I48 i48) {
        this.g = new O166(o166);
        this.d = new I48(i48);
    }

    public static Z165 g(Z165 z165, RotTrans rotTrans) {
        O166.h(z165.g, rotTrans.rot);
        I48.x(z165.d, rotTrans.trans);
        return z165;
    }

    public Z165(O166 o166, Vector3 vector3) {
        this.g = new O166(o166);
        this.d = new I48(vector3);
    }

    public static Z165 q(Z165 z165) {
        O166.v(z165.g);
        I48.z(z165.d);
        return z165;
    }

    public String toString() {
        return "[" + this.g.toString() + "|" + this.d.toString() + "]";
    }

    public static Z165 e(Z165 z165, RotTrans rotTrans) {
        I48 i48 = I48.r(rotTrans.trans);
        I48.af(i48, z165.g);
        I48.k(z165.d, i48);
        I48.y(i48);
        O166.o(z165.g, rotTrans.rot);
        return z165;
    }

    public static Z165 h(Z165 z165, Quaternion quaternion) {
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

    public Z165(Quaternion quaternion, Vector3 vector3) {
        this.g = new O166(quaternion);
        this.d = new I48(vector3);
    }
}

