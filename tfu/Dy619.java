/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dg449;
import tfu.Dm448;
import tfu.Ef450;
import tfu.Gg3;

class Dy619
extends Dm448 {
    int d;
    int g = -1;
    int j;
    int q;
    final /* synthetic */ Dg449 e;

    Dy619(Dg449 dg449) {
        this.e = dg449;
    }

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.au(gg3);
        this.d = Gg3.bd(gg3);
        this.q = Gg3.ar(gg3);
        this.j = Gg3.ar(gg3);
    }

    @Override
    void d(Ef450 ef450) {
        Ef450.w(ef450, this.g, this.d, this.q, this.j);
    }

    Dy619(Dg449 dg449, int n, int n2, int n3, int n4) {
        this.e = dg449;
        this.g = n;
        this.d = n2;
        this.q = n3;
        this.j = n4;
    }
}

