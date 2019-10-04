/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dd615;
import tfu.Dj617;
import tfu.Dr574;
import tfu.Dx616;
import tfu.Eg572;
import tfu.Ek609;
import tfu.Er571;
import tfu.Gg3;
import tfu.Gx298;
import tfu.Ln265;

public class Ee573 {
    private static final int b = 5;
    private static final int e = 2;
    private static final int h = 3;
    private static final int j = 1;
    private static final int s = 4;
    public long d = -1L;
    public long g;
    public Gx298 q = new Gx298();

    public void d(Dr574 dr574) {
        if (dr574.bq != this.g || dr574.n != this.d) {
            throw new RuntimeException("ClanChannelDelta.applyToClanChannel(): Credentials do not match! cc.clanHash:" + dr574.bq + " updateNum:" + dr574.n + " delta.clanHash:" + this.g + " updateNum:" + this.d);
        }
        Eg572 eg572 = (Eg572)Gx298.i(this.q);
        while (eg572 != null) {
            eg572.d(dr574);
            eg572 = (Eg572)Gx298.c(this.q);
        }
        ++dr574.n;
    }

    public Ee573(Gg3 gg3) {
        this.g(gg3);
    }

    public Ee573(Dr574 dr574) {
        this.g = dr574.bq;
        this.d = dr574.n;
    }

    public void g(Gg3 gg3) {
        this.g = Gg3.bq(gg3);
        this.d = Gg3.bq(gg3);
        int n = Gg3.ar(gg3);
        while (n != 0) {
            Eg572 eg572;
            if (n == 1) {
                eg572 = new Ek609(this);
            } else if (n == 4) {
                eg572 = new Dd615(this);
            } else if (n == 3) {
                eg572 = new Dx616(this);
            } else if (n == 2) {
                eg572 = new Dj617(this);
            } else if (n == 5) {
                eg572 = new Er571(this);
            } else {
                throw new RuntimeException("Unrecognised ClanChannelDelta type in decode()");
            }
            ((Eg572)eg572).g(gg3);
            Gx298.t(this.q, eg572);
            n = Gg3.ar(gg3);
        }
    }
}

