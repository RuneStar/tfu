/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dg449;
import tfu.Dm448;
import tfu.Ef450;
import tfu.Gg3;

class Eb613
extends Dm448 {
    String d;
    int g;
    final /* synthetic */ Dg449 q;

    Eb613(Dg449 dg449, int n, String string) {
        this.q = dg449;
        this.g = n;
        this.d = string;
    }

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.bd(gg3);
        this.d = Gg3.bk(gg3);
    }

    @Override
    void d(Ef450 ef450) {
        ef450.p(this.g, this.d);
    }

    Eb613(Dg449 dg449) {
        this.q = dg449;
    }
}

