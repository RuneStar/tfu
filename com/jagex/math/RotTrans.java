/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.math;

import com.jagex.math.D99;
import com.jagex.math.Quaternion;
import com.jagex.math.Vector3;
import tfu.Be2;
import tfu.Bs1;

@Deprecated
@Bs1
@Be2
@Bs1
@Be2
public final class RotTrans
implements D99 {
    protected static final float d = 0.01f;
    public static final RotTrans g = new RotTrans();
    public Quaternion rot;
    public Vector3 trans;

    public RotTrans(RotTrans rotTrans) {
        this.rot = new Quaternion();
        this.trans = new Vector3();
        RotTrans.g(this, rotTrans);
    }

    public RotTrans() {
        this.rot = new Quaternion();
        this.trans = new Vector3();
    }

    public static void g(RotTrans rotTrans, RotTrans rotTrans2) {
        Quaternion.q(rotTrans.rot, rotTrans2.rot);
        Vector3.e(rotTrans.trans, rotTrans2.trans);
    }

    public String toString() {
        return "[" + this.rot.toString() + "|" + this.trans.toString() + "]";
    }

    @Bs1
    @Be2
    public RotTrans(Quaternion quaternion, Vector3 vector3) {
        this.rot = new Quaternion(quaternion);
        this.trans = new Vector3(vector3);
    }
}

