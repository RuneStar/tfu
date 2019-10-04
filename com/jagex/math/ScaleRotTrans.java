// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.math;

import tfu.Be2;
import tfu.Bs1;

@Deprecated
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class ScaleRotTrans implements D99
{
    public static final ScaleRotTrans g;
    public Quaternion rot;
    public float scale;
    public Vector3 trans;
    
    public ScaleRotTrans(final RotTrans rotTrans, final float n) {
        this.rot = new Quaternion();
        this.trans = new Vector3();
        this.scale = 1.0f;
        q(this, rotTrans, n);
    }
    
    public static void d(final ScaleRotTrans scaleRotTrans, final RotTrans rotTrans, final boolean b) {
        Quaternion.q(scaleRotTrans.rot, rotTrans.rot);
        Vector3.e(scaleRotTrans.trans, rotTrans.trans);
        if (b) {
            scaleRotTrans.scale = 1.0f;
        }
    }
    
    public ScaleRotTrans(final RotTrans rotTrans) {
        this.rot = new Quaternion();
        this.trans = new Vector3();
        this.scale = 1.0f;
        d(this, rotTrans, true);
    }
    
    public ScaleRotTrans(final ScaleRotTrans scaleRotTrans) {
        this.rot = new Quaternion();
        this.trans = new Vector3();
        this.scale = 1.0f;
        g(this, scaleRotTrans);
    }
    
    public static void g(final ScaleRotTrans scaleRotTrans, final ScaleRotTrans scaleRotTrans2) {
        scaleRotTrans.scale = scaleRotTrans2.scale;
        Quaternion.q(scaleRotTrans.rot, scaleRotTrans2.rot);
        Vector3.e(scaleRotTrans.trans, scaleRotTrans2.trans);
    }
    
    @Bs1
    @Be2
    public ScaleRotTrans(final float scale, final Quaternion quaternion, final Vector3 vector3) {
        this.scale = scale;
        this.rot = new Quaternion(quaternion);
        this.trans = new Vector3(vector3);
    }
    
    public static void q(final ScaleRotTrans scaleRotTrans, final RotTrans rotTrans, final float scale) {
        Quaternion.q(scaleRotTrans.rot, rotTrans.rot);
        Vector3.e(scaleRotTrans.trans, rotTrans.trans);
        scaleRotTrans.scale = scale;
    }
    
    @Override
    public String toString() {
        return "[" + this.scale + "|" + this.rot.toString() + "|" + this.trans.toString() + "]";
    }
    
    static {
        g = new ScaleRotTrans();
    }
    
    public ScaleRotTrans() {
        this.scale = 1.0f;
        this.rot = new Quaternion();
        this.trans = new Vector3();
    }
}
