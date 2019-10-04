/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dg449;
import tfu.Dm448;
import tfu.Ef450;
import tfu.Gg3;

class Eh618
extends Dm448 {
    byte d;
    int g = -1;
    final /* synthetic */ Dg449 q;

    Eh618(Dg449 dg449, int n, byte by) {
        this.q = dg449;
        this.g = n;
        this.d = by;
    }

    Eh618(Dg449 dg449) {
        this.q = dg449;
    }

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.au(gg3);
        this.d = Gg3.ax(gg3);
    }

    @Override
    void d(Ef450 ef450) {
        Ef450.b(ef450, this.g, this.d);
    }
}

