/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.B164;
import com.jagex.maths.D305;
import com.jagex.maths.I48;
import com.jagex.maths.O166;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class ScaleRotTrans
implements B164 {
    public static final ScaleRotTrans g = new ScaleRotTrans(1.0f, Quaternion.g, Vector3.g);
    public final Quaternion rot;
    public final float scale;
    public final Vector3 trans;

    public ScaleRotTrans l(float f, float f2, float f3) {
        Vector3 vector3 = new Vector3(f, f2, f3);
        return new ScaleRotTrans(this.scale, this.rot, vector3);
    }

    public String toString() {
        return String.format("{ ScaleRotTrans: %.3f | rot=%.3f,%.3f,%.3f,%.3f | trans=%.3f,%.3f,%.3f }", Float.valueOf(this.scale), Float.valueOf(this.rot.x), Float.valueOf(this.rot.y), Float.valueOf(this.rot.z), Float.valueOf(this.rot.w), Float.valueOf(this.trans.x), Float.valueOf(this.trans.y), Float.valueOf(this.trans.z));
    }

    public static boolean d(ScaleRotTrans scaleRotTrans, D305 d305) {
        return d305 != null && Float.floatToIntBits(scaleRotTrans.scale) == Float.floatToIntBits(d305.g) && Quaternion.z(scaleRotTrans.rot, d305.d) && Vector3.y(scaleRotTrans.trans, d305.q);
    }

    public ScaleRotTrans(RotTrans rotTrans, float f) {
        this.rot = rotTrans.rot;
        this.trans = rotTrans.trans;
        this.scale = f;
    }

    @Bs1
    @Be2
    public ScaleRotTrans(float f, Quaternion quaternion, Vector3 vector3) {
        this.scale = f;
        this.rot = quaternion;
        this.trans = vector3;
    }

    public RotTrans q() {
        return new RotTrans(this.rot, this.trans);
    }

    public ScaleRotTrans e(ScaleRotTrans scaleRotTrans) {
        float f = this.scale * scaleRotTrans.scale;
        Quaternion quaternion = this.rot.r(scaleRotTrans.rot);
        Vector3 vector3 = Vector3.z(Vector3.al(Vector3.ai(this.trans, scaleRotTrans.scale), scaleRotTrans.rot), scaleRotTrans.trans);
        return new ScaleRotTrans(f, quaternion, vector3);
    }

    public ScaleRotTrans j() {
        float f = 1.0f / this.scale;
        Quaternion quaternion = this.rot.s();
        Vector3 vector3 = Vector3.ai(Vector3.al(Vector3.x(this.trans), quaternion), f);
        return new ScaleRotTrans(f, quaternion, vector3);
    }

    public ScaleRotTrans s(float f) {
        return new ScaleRotTrans(f, this.rot, this.trans);
    }

    public ScaleRotTrans b(Quaternion quaternion) {
        return new ScaleRotTrans(this.scale, quaternion, this.trans);
    }

    public ScaleRotTrans w(Vector3 vector3) {
        return new ScaleRotTrans(this.scale, this.rot, vector3);
    }

    public ScaleRotTrans h(Vector3 vector3) {
        Vector3 vector32 = Vector3.z(this.trans, vector3);
        return new ScaleRotTrans(this.scale, this.rot, vector32);
    }

    public boolean equals(Object object) {
        if (object instanceof D305) {
            return ScaleRotTrans.d(this, (D305)object);
        }
        return ScaleRotTrans.g(this, (ScaleRotTrans)object);
    }

    public static boolean g(ScaleRotTrans scaleRotTrans, ScaleRotTrans scaleRotTrans2) {
        return scaleRotTrans2 != null && Float.floatToIntBits(scaleRotTrans.scale) == Float.floatToIntBits(scaleRotTrans2.scale) && Quaternion.u(scaleRotTrans.rot, scaleRotTrans2.rot) && Vector3.v(scaleRotTrans.trans, scaleRotTrans2.trans);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.scale) + this.rot.hashCode() + this.trans.hashCode();
    }

    public ScaleRotTrans(RotTrans rotTrans) {
        this.rot = rotTrans.rot;
        this.trans = rotTrans.trans;
        this.scale = 1.0f;
    }
}

