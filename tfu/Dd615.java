/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dr574;
import tfu.Ee573;
import tfu.Eg572;
import tfu.Gg3;

class Dd615
extends Eg572 {
    boolean d;
    String g;
    byte j;
    byte q;
    final /* synthetic */ Ee573 e;

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.bj(gg3);
        if (this.g != null) {
            this.d = Gg3.ar(gg3) == 1;
            this.q = Gg3.ax(gg3);
            this.j = Gg3.ax(gg3);
        }
    }

    Dd615(Ee573 ee573, String string, boolean bl, byte by, byte by2) {
        this.e = ee573;
        this.g = string;
        this.d = bl;
        this.q = by;
        this.j = by2;
    }

    @Override
    void d(Dr574 dr574) {
        dr574.k = this.g;
        if (this.g != null) {
            dr574.i = this.d;
            dr574.o = this.q;
            dr574.a = this.j;
        }
    }

    Dd615(Ee573 ee573) {
        this.e = ee573;
    }
}

