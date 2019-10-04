/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.PrintStream;
import tfu.Dg449;
import tfu.Dm448;
import tfu.Ef450;
import tfu.Gg3;

class Ei604
extends Dm448 {
    String d = null;
    long g = -1L;
    int q = 0;
    final /* synthetic */ Dg449 j;

    @Override
    void g(Gg3 gg3) {
        if (Gg3.ar(gg3) != 255) {
            --gg3.v;
            this.g = Gg3.bq(gg3);
        }
        this.d = Gg3.bj(gg3);
        this.q = Gg3.au(gg3);
        if (Ef450.g) {
            System.out.println("memberhash:" + this.g + " membername:" + this.d);
        }
    }

    Ei604(Dg449 dg449, long l, String string, int n) {
        this.j = dg449;
        this.g = l;
        this.d = string;
        this.q = n;
    }

    @Override
    void d(Ef450 ef450) {
        ef450.q(this.g, this.d, this.q);
    }

    Ei604(Dg449 dg449) {
        this.j = dg449;
    }
}

