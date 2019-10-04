/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dr574;
import tfu.Dt575;
import tfu.Ee573;
import tfu.Eg572;
import tfu.Gg3;

class Dj617
extends Eg572 {
    byte d;
    String e;
    int g = -1;
    long j;
    int q;
    final /* synthetic */ Ee573 h;

    Dj617(Ee573 ee573, int n, byte by, int n2, long l, String string) {
        this.h = ee573;
        this.g = n;
        this.d = by;
        this.q = n2;
        this.j = l;
        this.e = string;
    }

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.au(gg3);
        this.d = Gg3.ax(gg3);
        this.q = Gg3.au(gg3);
        this.j = Gg3.bq(gg3);
        this.e = Gg3.bk(gg3);
    }

    @Override
    void d(Dr574 dr574) {
        Dt575 dt575 = dr574.z[this.g];
        dt575.d = this.d;
        dt575.q = this.q;
        dt575.e = this.j;
        dt575.j = this.e;
    }

    Dj617(Ee573 ee573) {
        this.h = ee573;
    }
}

