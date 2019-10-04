/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.PrintStream;
import tfu.Dg449;
import tfu.Dm448;
import tfu.Ef450;
import tfu.Gg3;

class Ec614
extends Dm448 {
    String d = null;
    long g = -1L;
    final /* synthetic */ Dg449 q;

    @Override
    void d(Ef450 ef450) {
        ef450.q(this.g, this.d, 0);
    }

    Ec614(Dg449 dg449, long l, String string) {
        this.q = dg449;
        this.g = l;
        this.d = string;
    }

    @Override
    void g(Gg3 gg3) {
        if (Gg3.ar(gg3) != 255) {
            --gg3.v;
            this.g = Gg3.bq(gg3);
        }
        this.d = Gg3.bj(gg3);
        if (Ef450.g) {
            System.out.println("memberhash:" + this.g + " membername:" + this.d);
        }
    }

    Ec614(Dg449 dg449) {
        this.q = dg449;
    }
}

