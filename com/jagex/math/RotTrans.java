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
public final class RotTrans implements D99
{
    protected static final float d = 0.01f;
    public static final RotTrans g;
    public Quaternion rot;
    public Vector3 trans;
    
    public RotTrans(final RotTrans rotTrans) {
        this.rot = new Quaternion();
        this.trans = new Vector3();
        g(this, rotTrans);
    }
    
    public RotTrans() {
        this.rot = new Quaternion();
        this.trans = new Vector3();
    }
    
    public static void g(final RotTrans rotTrans, final RotTrans rotTrans2) {
        Quaternion.q(rotTrans.rot, rotTrans2.rot);
        Vector3.e(rotTrans.trans, rotTrans2.trans);
    }
    
    @Override
    public String toString() {
        return "[" + this.rot.toString() + "|" + this.trans.toString() + "]";
    }
    
    static {
        g = new RotTrans();
    }
    
    @Bs1
    @Be2
    public RotTrans(final Quaternion quaternion, final Vector3 vector3) {
        this.rot = new Quaternion(quaternion);
        this.trans = new Vector3(vector3);
    }
}
