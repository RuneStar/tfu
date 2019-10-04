/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dg449;
import tfu.Dm448;
import tfu.Ef450;
import tfu.Gg3;

class Es576
extends Dm448 {
    int d;
    int g;
    int j;
    int q;
    final /* synthetic */ Dg449 e;

    Es576(Dg449 dg449) {
        this.e = dg449;
    }

    Es576(Dg449 dg449, int n, int n2, int n3, int n4) {
        this.e = dg449;
        this.g = n;
        this.j = n2;
        this.d = n3;
        this.q = n4;
    }

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.bd(gg3);
        this.j = Gg3.bd(gg3);
        this.d = Gg3.ar(gg3);
        this.q = Gg3.ar(gg3);
    }

    @Override
    void d(Ef450 ef450) {
        ef450.v(this.g, this.j, this.d, this.q);
    }
}

