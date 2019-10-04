/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.G300;
import com.jagex.maths.I48;
import com.jagex.maths.O166;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import com.jagex.maths.Z165;

public final class D305
implements G300 {
    public O166 d;
    public float g;
    public I48 q;

    public D305(Z165 z165, float f) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        D305.h(this, z165, f);
    }

    public D305(D305 d305) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        D305.d(this, d305);
    }

    public D305(RotTrans rotTrans) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        D305.q(this, rotTrans, true);
    }

    public D305(ScaleRotTrans scaleRotTrans) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        D305.g(this, scaleRotTrans);
    }

    public D305(float f, O166 o166, I48 i48) {
        this.g = f;
        this.d = new O166(o166);
        this.q = new I48(i48);
    }

    public String toString() {
        return "[" + this.g + "|" + this.d.toString() + "|" + this.q.toString() + "]";
    }

    public D305(float f, Quaternion quaternion, Vector3 vector3) {
        this.g = f;
        this.d = new O166(quaternion);
        this.q = new I48(vector3);
    }

    public D305(float f, Quaternion quaternion, I48 i48) {
        this.g = f;
        this.d = new O166(quaternion);
        this.q = new I48(i48);
    }

    public D305(float f, O166 o166, Vector3 vector3) {
        this.g = f;
        this.d = new O166(o166);
        this.q = new I48(vector3);
    }

    public D305(Z165 z165) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        D305.j(this, z165, true);
    }

    public static D305 g(D305 d305, ScaleRotTrans scaleRotTrans) {
        d305.g = scaleRotTrans.scale;
        O166.h(d305.d, scaleRotTrans.rot);
        I48.x(d305.q, scaleRotTrans.trans);
        return d305;
    }

    public static D305 d(D305 d305, D305 d3052) {
        d305.g = d3052.g;
        O166.s(d305.d, d3052.d);
        I48.u(d305.q, d3052.q);
        return d305;
    }

    public static D305 q(D305 d305, RotTrans rotTrans, boolean bl) {
        O166.h(d305.d, rotTrans.rot);
        I48.x(d305.q, rotTrans.trans);
        if (bl) {
            d305.g = 1.0f;
        }
        return d305;
    }

    public static D305 j(D305 d305, Z165 z165, boolean bl) {
        O166.s(d305.d, z165.g);
        I48.u(d305.q, z165.d);
        if (bl) {
            d305.g = 1.0f;
        }
        return d305;
    }

    public static D305 e(D305 d305, RotTrans rotTrans, float f) {
        O166.h(d305.d, rotTrans.rot);
        I48.x(d305.q, rotTrans.trans);
        d305.g = f;
        return d305;
    }

    public D305(RotTrans rotTrans, float f) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        D305.e(this, rotTrans, f);
    }

    public D305() {
        this.g = 1.0f;
        this.d = new O166();
        this.q = new I48();
    }

    public static D305 h(D305 d305, Z165 z165, float f) {
        O166.s(d305.d, z165.g);
        I48.u(d305.q, z165.d);
        d305.g = f;
        return d305;
    }
}

