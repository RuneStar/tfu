/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.math;

import com.jagex.math.D99;
import com.jagex.math.Quaternion;
import com.jagex.math.RotTrans;
import com.jagex.math.Vector3;
import tfu.Be2;
import tfu.Bs1;

@Deprecated
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class ScaleRotTrans
implements D99 {
    public static final ScaleRotTrans g = new ScaleRotTrans();
    public Quaternion rot;
    public float scale;
    public Vector3 trans;

    public ScaleRotTrans(RotTrans rotTrans, float f) {
        this.rot = new Quaternion();
        this.trans = new Vector3();
        this.scale = 1.0f;
        ScaleRotTrans.q(this, rotTrans, f);
    }

    public static void d(ScaleRotTrans scaleRotTrans, RotTrans rotTrans, boolean bl) {
        Quaternion.q(scaleRotTrans.rot, rotTrans.rot);
        Vector3.e(scaleRotTrans.trans, rotTrans.trans);
        if (bl) {
            scaleRotTrans.scale = 1.0f;
        }
    }

    public ScaleRotTrans(RotTrans rotTrans) {
        this.rot = new Quaternion();
        this.trans = new Vector3();
        this.scale = 1.0f;
        ScaleRotTrans.d(this, rotTrans, true);
    }

    public ScaleRotTrans(ScaleRotTrans scaleRotTrans) {
        this.rot = new Quaternion();
        this.trans = new Vector3();
        this.scale = 1.0f;
        ScaleRotTrans.g(this, scaleRotTrans);
    }

    public static void g(ScaleRotTrans scaleRotTrans, ScaleRotTrans scaleRotTrans2) {
        scaleRotTrans.scale = scaleRotTrans2.scale;
        Quaternion.q(scaleRotTrans.rot, scaleRotTrans2.rot);
        Vector3.e(scaleRotTrans.trans, scaleRotTrans2.trans);
    }

    @Bs1
    @Be2
    public ScaleRotTrans(float f, Quaternion quaternion, Vector3 vector3) {
        this.scale = f;
        this.rot = new Quaternion(quaternion);
        this.trans = new Vector3(vector3);
    }

    public static void q(ScaleRotTrans scaleRotTrans, RotTrans rotTrans, float f) {
        Quaternion.q(scaleRotTrans.rot, rotTrans.rot);
        Vector3.e(scaleRotTrans.trans, rotTrans.trans);
        scaleRotTrans.scale = f;
    }

    public String toString() {
        return "[" + this.scale + "|" + this.rot.toString() + "|" + this.trans.toString() + "]";
    }

    public ScaleRotTrans() {
        this.scale = 1.0f;
        this.rot = new Quaternion();
        this.trans = new Vector3();
    }
}

