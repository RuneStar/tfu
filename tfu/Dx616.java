/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dr574;
import tfu.Ee573;
import tfu.Eg572;
import tfu.Gg3;

public class Dx616
extends Eg572 {
    public int d;
    public int g = -1;
    public long q;
    final /* synthetic */ Ee573 j;

    Dx616(Ee573 ee573, int n, int n2, long l) {
        this.j = ee573;
        this.g = n;
        this.d = n2;
        this.q = l;
    }

    Dx616(Ee573 ee573) {
        this.j = ee573;
    }

    @Override
    void g(Gg3 gg3) {
        this.g = Gg3.au(gg3);
        this.d = Gg3.ar(gg3);
        if (Gg3.ar(gg3) != 255) {
            --gg3.v;
            this.q = Gg3.bq(gg3);
        }
    }

    @Override
    void d(Dr574 dr574) {
        Dr574.q(dr574, this.g);
    }
}

