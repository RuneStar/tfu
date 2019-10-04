/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Ky391;

public class Hb335 {
    private Ky391 d;
    public Ky391 g;

    public static void g(Hb335 hb335) {
        Ky391 ky391;
        while ((ky391 = hb335.g.s) != hb335.g) {
            Ky391.g(ky391);
        }
        hb335.d = null;
    }

    public static void d(Hb335 hb335, Ky391 ky391) {
        if (ky391.b != null) {
            Ky391.g(ky391);
        }
        ky391.b = hb335.g.b;
        ky391.s = hb335.g;
        ky391.b.s = ky391;
        ky391.s.b = ky391;
    }

    public Hb335() {
        this.g.s = this.g = new Ky391();
        this.g.b = this.g;
    }
}

