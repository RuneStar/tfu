/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dg449;
import tfu.Dm448;
import tfu.Ef450;
import tfu.Gg3;

class Ep612
extends Dm448 {
    byte d;
    byte e;
    boolean g;
    byte j;
    byte q;
    final /* synthetic */ Dg449 h;

    Ep612(Dg449 dg449, Ef450 ef450) {
        this.h = dg449;
        this.g = ef450.r;
        this.d = ef450.v;
        this.q = ef450.y;
        this.j = ef450.p;
        this.e = ef450.x;
    }

    Ep612(Dg449 dg449) {
        this.h = dg449;
    }

    @Override
    void d(Ef450 ef450) {
        ef450.r = this.g;
        ef450.v = this.d;
        ef450.y = this.q;
        ef450.p = this.j;
        ef450.x = this.e;
    }

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.ar(gg3) == 1;
        this.d = Gg3.ax(gg3);
        this.q = Gg3.ax(gg3);
        this.j = Gg3.ax(gg3);
        this.e = Gg3.ax(gg3);
    }
}

