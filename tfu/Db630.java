/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dg449;
import tfu.Dm448;
import tfu.Ef450;
import tfu.Gg3;

class Db630
extends Dm448 {
    int g = -1;
    final /* synthetic */ Dg449 d;

    Db630(Dg449 dg449) {
        this.d = dg449;
    }

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.au(gg3);
    }

    @Override
    void d(Ef450 ef450) {
        ef450.j(this.g);
    }

    Db630(Dg449 dg449, int n) {
        this.d = dg449;
        this.g = n;
    }
}

