/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.PrintStream;
import tfu.Dr574;
import tfu.Dt575;
import tfu.Ee573;
import tfu.Eg572;
import tfu.Gg3;

public class Ek609
extends Eg572 {
    String d = null;
    long e;
    long g = -1L;
    byte j;
    int q;
    final /* synthetic */ Ee573 h;

    Ek609(Ee573 ee573, long l, String string, int n, byte by, long l2) {
        this.h = ee573;
        this.g = l;
        this.d = string;
        this.q = n;
        this.j = by;
        this.e = l2;
    }

    @Override
    void g(Gg3 gg3) {
        if (Gg3.ar(gg3) != 255) {
            --gg3.v;
            this.g = Gg3.bq(gg3);
        }
        this.d = Gg3.bj(gg3);
        this.q = Gg3.au(gg3);
        this.j = Gg3.ax(gg3);
        this.e = Gg3.bq(gg3);
        if (Dr574.g) {
            System.out.println("memberhash:" + this.g + " membername:" + this.d);
        }
    }

    Ek609(Ee573 ee573) {
        this.h = ee573;
    }

    @Override
    void d(Dr574 dr574) {
        Dt575 dt575 = new Dt575();
        dt575.g = this.g;
        dt575.j = this.d;
        dt575.q = this.q;
        dt575.d = this.j;
        dt575.e = this.e;
        Dr574.d(dr574, dt575);
    }
}

