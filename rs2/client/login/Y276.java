/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.login;

import com.jagex.game.runetek6.event.EventHandler;
import rs2.client.N272;
import rs2.client.login.E275;
import rs2.client.login.W274;
import tfu.Gg3;
import tfu.Mf509;

abstract class Y276 {
    static final int r = 4;
    final EventHandler m;
    float p;
    int t;
    int[] u;
    N272 v;
    float x;
    W274 y;
    int z;

    Y276(N272 n272, float f, EventHandler eventHandler) {
        this.v = n272;
        this.v.o = false;
        this.p = f;
        this.m = eventHandler;
        Y276.n(this);
    }

    static void n(Y276 y276) {
        y276.x = 0.0f;
        y276.z = 1;
        y276.y = null;
    }

    static void k(Y276 y276, E275 e275) {
        y276.i(e275, null);
    }

    void i(E275 e275, Mf509 mf509) {
        this.y = new W274(e275, mf509, this.m);
    }

    public W274 h() {
        return this.y;
    }

    abstract void d(float var1);

    Gg3 o() {
        Gg3 gg3 = new Gg3(518);
        this.u = new int[4];
        this.u[0] = (int)(Math.random() * 9.9999999E7);
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

