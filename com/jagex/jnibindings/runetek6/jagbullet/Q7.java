// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.RotTrans;
import com.jagex.maths.I48;
import com.jagex.maths.Vector3;
import com.jagex.maths.M47;

public class Q7
{
    public static final Q7 q;
    public final M47 d;
    public final Vector3 g;
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Q7)) {
            return false;
        }
        final Q7 q7 = (Q7)o;
        return q7.d.equals(this.d) && Vector3.v(q7.g, this.g);
    }
    
    public Q7 h(final I48 i48) {
        return new Q7(this.d, Vector3.t(this.g, i48));
    }
    
    public static Q7 g(final RotTrans rotTrans) {
        return new Q7(rotTrans.rot.m(), rotTrans.trans);
    }
    
    public Q7(final M47 d, final Vector3 g) {
        this.g = g;
        this.d = d;
    }
    
    public Q7 s(final M47 m47) {
        return new Q7(this.d.h(m47), this.g);
    }
    
    public Q7 e(final Vector3 vector3) {
        return new Q7(this.d, Vector3.z(this.g, vector3));
    }
    
    public static RotTrans d(final Q7 q7) {
        return (q7 == null) ? null : q7.q();
    }
    
    static {
        q = new Q7(M47.g, Vector3.g);
    }
    
    public Q7 j(final float n) {
        return new Q7(this.d, this.g.an(n));
    }
    
    public RotTrans q() {
        return new RotTrans(this.d.q(), this.g);
    }
}
