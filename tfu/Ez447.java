/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dg449;
import tfu.Dm448;
import tfu.Ef450;
import tfu.Gg3;

class Ez447
extends Dm448 {
    int d;
    String g;
    final /* synthetic */ Dg449 q;

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.bk(gg3);
        this.d = Gg3.bd(gg3);
    }

    Ez447(Dg449 dg449, String string, int n) {
        this.q = dg449;
        this.g = string;
        this.d = n;
    }

    @Override
    void d(Ef450 ef450) {
        ef450.b = this.g;
        ef450.w = this.d;
    }

    Ez447(Dg449 dg449) {
        this.q = dg449;
    }
}

