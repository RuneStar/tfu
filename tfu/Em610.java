/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dg449;
import tfu.Dm448;
import tfu.Ef450;
import tfu.Gg3;

class Em610
extends Dm448 {
    int d;
    int g;
    final /* synthetic */ Dg449 q;

    Em610(Dg449 dg449, int n, int n2) {
        this.q = dg449;
        this.g = n;
        this.d = n2;
    }

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.bd(gg3);
        this.d = Gg3.bd(gg3);
    }

    @Override
    void d(Ef450 ef450) {
        ef450.r(this.g, this.d);
    }

    Em610(Dg449 dg449) {
        this.q = dg449;
    }
}

