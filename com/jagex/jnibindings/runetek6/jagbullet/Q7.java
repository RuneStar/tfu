/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;

public class Q7 {
    public static final Q7 q = new Q7(M47.g, Vector3.g);
    public final M47 d;
    public final Vector3 g;

    public boolean equals(Object object) {
        if (!(object instanceof Q7)) {
            return false;
        }
        Q7 q7 = (Q7)object;
        return q7.d.equals(this.d) && Vector3.v(q7.g, this.g);
    }

    public Q7 h(I48 i48) {
        Vector3 vector3 = Vector3.t(this.g, i48);
        return new Q7(this.d, vector3);
    }

    public static Q7 g(RotTrans rotTrans) {
        return new Q7(rotTrans.rot.m(), rotTrans.trans);
    }

    public Q7(M47 m47, Vector3 vector3) {
        this.g = vector3;
        this.d = m47;
    }

    public Q7 s(M47 m47) {
        M47 m472 = this.d.h(m47);
        return new Q7(m472, this.g);
    }

    public Q7 e(Vector3 vector3) {
        Vector3 vector32 = Vector3.z(this.g, vector3);
        return new Q7(this.d, vector32);
    }

    public static RotTrans d(Q7 q7) {
        return q7 == null ? null : q7.q();
    }

    public Q7 j(float f) {
        return new Q7(this.d, this.g.an(f));
    }

    public RotTrans q() {
        return new RotTrans(this.d.q(), this.g);
    }
}

