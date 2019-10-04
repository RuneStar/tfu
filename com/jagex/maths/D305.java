// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

public final class D305 implements G300
{
    public O166 d;
    public float g;
    public I48 q;
    
    public D305(final Z165 z165, final float n) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        h(this, z165, n);
    }
    
    public D305(final D305 d305) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        d(this, d305);
    }
    
    public D305(final RotTrans rotTrans) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        q(this, rotTrans, true);
    }
    
    public D305(final ScaleRotTrans scaleRotTrans) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        g(this, scaleRotTrans);
    }
    
    public D305(final float g, final O166 o166, final I48 i48) {
        this.g = g;
        this.d = new O166(o166);
        this.q = new I48(i48);
    }
    
    @Override
    public String toString() {
        return "[" + this.g + "|" + this.d.toString() + "|" + this.q.toString() + "]";
    }
    
    public D305(final float g, final Quaternion quaternion, final Vector3 vector3) {
        this.g = g;
        this.d = new O166(quaternion);
        this.q = new I48(vector3);
    }
    
    public D305(final float g, final Quaternion quaternion, final I48 i48) {
        this.g = g;
        this.d = new O166(quaternion);
        this.q = new I48(i48);
    }
    
    public D305(final float g, final O166 o166, final Vector3 vector3) {
        this.g = g;
        this.d = new O166(o166);
        this.q = new I48(vector3);
    }
    
    public D305(final Z165 z165) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        j(this, z165, true);
    }
    
    public static D305 g(final D305 d305, final ScaleRotTrans scaleRotTrans) {
        d305.g = scaleRotTrans.scale;
        O166.h(d305.d, scaleRotTrans.rot);
        I48.x(d305.q, scaleRotTrans.trans);
        return d305;
    }
    
    public static D305 d(final D305 d305, final D305 d306) {
        d305.g = d306.g;
        O166.s(d305.d, d306.d);
        I48.u(d305.q, d306.q);
        return d305;
    }
    
    public static D305 q(final D305 d305, final RotTrans rotTrans, final boolean b) {
        O166.h(d305.d, rotTrans.rot);
        I48.x(d305.q, rotTrans.trans);
        if (b) {
            d305.g = 1.0f;
        }
        return d305;
    }
    
    public static D305 j(final D305 d305, final Z165 z165, final boolean b) {
        O166.s(d305.d, z165.g);
        I48.u(d305.q, z165.d);
        if (b) {
            d305.g = 1.0f;
        }
        return d305;
    }
    
    public static D305 e(final D305 d305, final RotTrans rotTrans, final float g) {
        O166.h(d305.d, rotTrans.rot);
        I48.x(d305.q, rotTrans.trans);
        d305.g = g;
        return d305;
    }
    
    public D305(final RotTrans rotTrans, final float n) {
        this.d = new O166();
        this.q = new I48();
        this.g = 1.0f;
        e(this, rotTrans, n);
    }
    
    public D305() {
        this.g = 1.0f;
        this.d = new O166();
        this.q = new I48();
    }
    
    public static D305 h(final D305 d305, final Z165 z165, final float g) {
        O166.s(d305.d, z165.g);
        I48.u(d305.q, z165.d);
        d305.g = g;
        return d305;
    }
}
