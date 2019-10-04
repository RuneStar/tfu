// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.login;

import tfu.Gg3;
import tfu.Mf509;
import rs2.client.N272;
import com.jagex.game.runetek6.event.EventHandler;

abstract class Y276
{
    static final int r = 4;
    final EventHandler m;
    float p;
    int t;
    int[] u;
    N272 v;
    float x;
    W274 y;
    int z;
    
    Y276(final N272 v, final float p3, final EventHandler m) {
        this.v = v;
        this.v.o = false;
        this.p = p3;
        this.m = m;
        n(this);
    }
    
    static void n(final Y276 y276) {
        y276.x = 0.0f;
        y276.z = 1;
        y276.y = null;
    }
    
    static void k(final Y276 y276, final E275 e275) {
        y276.i(e275, null);
    }
    
    void i(final E275 e275, final Mf509 mf509) {
        this.y = new W274(e275, mf509, this.m);
    }
    
    public W274 h() {
        return this.y;
    }
    
    abstract void d(final float p0);
    
    Gg3 o() {
        final Gg3 gg3 = new Gg3(518);
        (this.u = new int[4])[0] = (int)(Math.random() * 9.9999999E7);
        this.u[1] = (int)(Math.random() * 9.9999999E7);
        this.u[2] = (int)(Math.random() * 9.9999999E7);
        this.u[3] = (int)(Math.random() * 9.9999999E7);
        Gg3.k(gg3, 10);
        Gg3.a(gg3, this.u[0]);
        Gg3.a(gg3, this.u[1]);
        Gg3.a(gg3, this.u[2]);
        Gg3.a(gg3, this.u[3]);
        return gg3;
    }
    
    abstract void g();
}
