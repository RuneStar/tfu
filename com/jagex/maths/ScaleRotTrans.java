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
@Bs1
@Be2
public final class ScaleRotTrans implements B164
{
    public static final ScaleRotTrans g;
    public final Quaternion rot;
    public final float scale;
    public final Vector3 trans;
    
    public ScaleRotTrans l(final float n, final float n2, final float n3) {
        return new ScaleRotTrans(this.scale, this.rot, new Vector3(n, n2, n3));
    }
    
    @Override
    public String toString() {
        return String.format("{ ScaleRotTrans: %.3f | rot=%.3f,%.3f,%.3f,%.3f | trans=%.3f,%.3f,%.3f }", this.scale, this.rot.x, this.rot.y, this.rot.z, this.rot.w, this.trans.x, this.trans.y, this.trans.z);
    }
    
    public static boolean d(final ScaleRotTrans scaleRotTrans, final D305 d305) {
        return d305 != null && Float.floatToIntBits(scaleRotTrans.scale) == Float.floatToIntBits(d305.g) && Quaternion.z(scaleRotTrans.rot, d305.d) && Vector3.y(scaleRotTrans.trans, d305.q);
    }
    
    public ScaleRotTrans(final RotTrans rotTrans, final float scale) {
        this.rot = rotTrans.rot;
        this.trans = rotTrans.trans;
        this.scale = scale;
    }
    
    @Bs1
    @Be2
    public ScaleRotTrans(final float scale, final Quaternion rot, final Vector3 trans) {
        this.scale = scale;
        this.rot = rot;
        this.trans = trans;
    }
    
    public RotTrans q() {
        return new RotTrans(this.rot, this.trans);
    }
    
    public ScaleRotTrans e(final ScaleRotTrans scaleRotTrans) {
        return new ScaleRotTrans(this.scale * scaleRotTrans.scale, this.rot.r(scaleRotTrans.rot), Vector3.z(Vector3.al(Vector3.ai(this.trans, scaleRotTrans.scale), scaleRotTrans.rot), scaleRotTrans.trans));
    }
    
    public ScaleRotTrans j() {
        final float n = 1.0f / this.scale;
        final Quaternion s = this.rot.s();
        return new ScaleRotTrans(n, s, Vector3.ai(Vector3.al(Vector3.x(this.trans), s), n));
    }
    
    public ScaleRotTrans s(final float n) {
        return new ScaleRotTrans(n, this.rot, this.trans);
    }
    
    public ScaleRotTrans b(final Quaternion quaternion) {
        return new ScaleRotTrans(this.scale, quaternion, this.trans);
    }
    
    public ScaleRotTrans w(final Vector3 vector3) {
        return new ScaleRotTrans(this.scale, this.rot, vector3);
    }
    
    static {
        g = new ScaleRotTrans(1.0f, Quaternion.g, Vector3.g);
    }
    
    public ScaleRotTrans h(final Vector3 vector3) {
        return new ScaleRotTrans(this.scale, this.rot, Vector3.z(this.trans, vector3));
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof D305) {
            return d(this, (D305)o);
        }
        return g(this, (ScaleRotTrans)o);
    }
    
    public static boolean g(final ScaleRotTrans scaleRotTrans, final ScaleRotTrans scaleRotTrans2) {
        return scaleRotTrans2 != null && Float.floatToIntBits(scaleRotTrans.scale) == Float.floatToIntBits(scaleRotTrans2.scale) && Quaternion.u(scaleRotTrans.rot, scaleRotTrans2.rot) && Vector3.v(scaleRotTrans.trans, scaleRotTrans2.trans);
    }
    
    @Override
    public int hashCode() {
        return Float.floatToIntBits(this.scale) + this.rot.hashCode() + this.trans.hashCode();
    }
    
    public ScaleRotTrans(final RotTrans rotTrans) {
        this.rot = rotTrans.rot;
        this.trans = rotTrans.trans;
        this.scale = 1.0f;
    }
}
