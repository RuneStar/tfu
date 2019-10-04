/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import fmod.E245;
import fmod.X243;
import java.util.Hashtable;
import rs2.client.sound.K589;
import rs2.client.sound.SoundManager;
import rs2.client.sound.X675;
import tfu.Gg3;

class Av695 {
    private float[] b;
    X675 d;
    String e = "";
    X243 g = null;
    Hashtable h = new Hashtable();
    float j = 0.0f;
    int q;
    private long[] s = new long[]{0L, 0L};

    public static long g(Av695 av695) {
        return av695.g == null ? 0L : X243.an(av695.g);
    }

    public static void h(Av695 av695, int n) {
        if (X243.y(av695.g)) {
            X243.c(av695.g);
        }
        av695.g = E245.v(SoundManager.c, av695.e);
        if (X243.h(av695.g)) {
            if (n > 20) {
                X243.av(av695.g, 36, 250);
            }
            X243.n(av695.g, true);
            av695.g.a();
            X243.am(av695.g, n);
            X243.i(av695.g, av695.j * av695.d.b);
        }
    }

    public static int d(Av695 av695) {
        return av695.g == null ? 0 : X243.as(av695.g);
    }

    public static boolean q(Av695 av695) {
        return X243.y(av695.g);
    }

    public static void j(Av695 av695, String string, boolean bl) {
        if (av695.h.containsKey(string)) {
            if (!bl) {
                Av695.l(av695, ((Float)av695.h.get(string)).floatValue(), av695.d.p);
            } else {
                X243.i(av695.g, ((Float)av695.h.get(string)).floatValue());
                av695.j = ((Float)av695.h.get(string)).floatValue();
            }
        } else {
            av695.j = 1.0f;
        }
    }

    public static void e(Av695 av695) {
        if (X243.y(av695.g)) {
            X243.c(av695.g);
        }
        av695.g = E245.v(SoundManager.c, av695.e);
        X243.n(av695.g, true);
        av695.g.a();
        X243.i(av695.g, av695.j * av695.d.b);
    }

    public Av695(String string, X675 x675) {
        this.b = new float[]{1.0f, 1.0f};
        this.d = x675;
        this.e = string;
        this.g = SoundManager.c.r(this.e, 0);
    }

    public static void b(Av695 av695) {
        long l = K589.g();
        if (av695.s[0] != 0L) {
            if (l > av695.s[1]) {
                X243.i(av695.g, av695.b[1]);
                av695.s[0] = 0L;
            }
        } else if (l >= av695.s[0] && l <= av695.s[1]) {
            float f;
            float f2 = (float)(l - av695.s[0]) / (float)(av695.s[1] - av695.s[0]);
            av695.j = f = av695.b[0] + f2 * (av695.b[1] - av695.b[0]);
            X243.i(av695.g, f * av695.d.b);
        } else {
            X243.i(av695.g, av695.d.b);
        }
    }

    public static void l(Av695 av695, float f, long l) {
        long l2;
        av695.s[0] = l2 = K589.g();
        av695.s[1] = l2 + l;
        av695.b[0] = av695.j;
        av695.b[1] = f;
    }

    public static void w(Av695 av695, Gg3 gg3) {
        av695.e = Gg3.bk(gg3);
        int n = Gg3.ar(gg3);
        for (int i = 0; i < n; ++i) {
            String string = Gg3.bk(gg3);
            float f = (float)Gg3.ar(gg3) / 100.0f;
            av695.h.put(string, Float.valueOf(f));
        }
    }

    public static void s(Av695 av695) {
        if (X243.y(av695.g)) {
            X243.c(av695.g);
        }
    }
}

