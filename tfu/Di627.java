/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dg449;
import tfu.Dm448;
import tfu.Ef450;
import tfu.Gg3;

class Di627
extends Dm448 {
    boolean d;
    int g = -1;
    final /* synthetic */ Dg449 q;

    Di627(Dg449 dg449, int n, boolean bl) {
        this.q = dg449;
        this.g = n;
        this.d = bl;
    }

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.au(gg3);
        this.d = Gg3.ar(gg3) == 1;
    }

    Di627(Dg449 dg449) {
        this.q = dg449;
    }

    @Override
    void d(Ef450 ef450) {
        Ef450.l(ef450, this.g, this.d);
    }
}

