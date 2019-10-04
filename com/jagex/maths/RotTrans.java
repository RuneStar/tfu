/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.B164;
import com.jagex.maths.I48;
import com.jagex.maths.O166;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import com.jagex.maths.Z165;
import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
@Bs1
@Be2
public final class RotTrans
implements B164 {
    public static final RotTrans g = new RotTrans(Quaternion.g, Vector3.g);
    public final Quaternion rot;
    public final Vector3 trans;

    public static boolean q(RotTrans rotTrans, RotTrans rotTrans2, float f) {
        if (!Vector3.p(rotTrans.trans, rotTrans2.trans, f)) {
            return false;
        }
        return Quaternion.t(rotTrans.rot, rotTrans2.rot, f);
    }

    public int hashCode() {
        return this.rot.hashCode() + this.trans.hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof Z165) {
            return RotTrans.d(this, (Z165)object);
        }
        return RotTrans.g(this, (RotTrans)object);
    }

    public RotTrans v(float f, float f2, float f3) {
        Vector3 vector3 = Vector3.i(this.trans, f, f2, f3);
        return new RotTrans(this.rot, vector3);
    }

    public RotTrans j() {
        Quaternion quaternion = this.rot.s();
        Vector3 vector3 = Vector3.al(Vector3.x(this.trans), quaternion);
        return new RotTrans(quaternion, vector3);
    }

    public RotTrans h(RotTrans rotTrans) {
        Vector3 vector3 = Vector3.al(rotTrans.trans, this.rot);
        Vector3 vector32 = Vector3.z(this.trans, vector3);
        Quaternion quaternion = this.rot.v(rotTrans.rot);
        return new RotTrans(quaternion, vector32);
    }

    public RotTrans s(Quaternion quaternion) {
        Quaternion quaternion2 = this.rot.v(quaternion);
        return new RotTrans(quaternion2, this.trans);
    }

    public RotTrans l(I48 i48) {
        Vector3 vector3 = Vector3.t(this.trans, i48);
        return new RotTrans(this.rot, vector3);
    }

    public RotTrans w(float f, float f2, float f3) {
        Vector3 vector3 = Vector3.m(this.trans, f, f2, f3);
        return new RotTrans(this.rot, vector3);
    }

    public RotTrans e(RotTrans rotTrans) {
        Quaternion quaternion = this.rot.r(rotTrans.rot);
        Vector3 vector3 = Vector3.z(Vector3.al(this.trans, rotTrans.rot), rotTrans.trans);
        return new RotTrans(quaternion, vector3);
    }

    public RotTrans r(Vector3 vector3, float f) {
        Vector3 vector32 = Vector3.n(this.trans, vector3, f);
        return new RotTrans(this.rot, vector32);
    }

    public RotTrans p(RotTrans rotTrans, float f) {
        return new RotTrans(this.rot.p(rotTrans.rot, f), Vector3.av(this.trans, rotTrans.trans, f));
    }

    public String toString() {
        return String.format("{ ScaleRotTrans: rot=%.3f,%.3f,%.3f,%.3f | trans=%.3f,%.3f,%.3f }", Float.valueOf(this.rot.x), Float.valueOf(this.rot.y), Float.valueOf(this.rot.z), Float.valueOf(this.rot.w), Float.valueOf(this.trans.x), Float.valueOf(this.trans.y), Float.valueOf(this.trans.z));
    }

    public static boolean g(RotTrans rotTrans, RotTrans rotTrans2) {
        return rotTrans2 != null && Quaternion.u(rotTrans.rot, rotTrans2.rot) && Vector3.v(rotTrans.trans, rotTrans2.trans);
    }

    @Bs1
    @Be2
    public RotTrans(Quaternion quaternion, Vector3 vector3) {
        this.rot = quaternion;
        this.trans = vector3;
    }

    public RotTrans y(float f) {
        Vector3 vector3 = Vector3.ai(this.trans, f);
        return new RotTrans(this.rot, vector3);
    }

    public static boolean d(RotTrans rotTrans, Z165 z165) {
        return z165 != null && Quaternion.z(rotTrans.rot, z165.g) && Vector3.y(rotTrans.trans, z165.d);
    }

    public RotTrans b(Vector3 vector3) {
        Vector3 vector32 = Vector3.z(this.trans, vector3);
        return new RotTrans(this.rot, vector32);
    }
}

