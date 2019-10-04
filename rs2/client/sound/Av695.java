// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import tfu.Gg3;
import fmod.E245;
import java.util.Hashtable;
import fmod.X243;

class Av695
{
    private float[] b;
    X675 d;
    String e;
    X243 g;
    Hashtable h;
    float j;
    int q;
    private long[] s;
    
    public static long g(final Av695 av695) {
        return (av695.g == null) ? 0L : X243.an(av695.g);
    }
    
    public static void h(final Av695 av695, final int n) {
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
    
    public static int d(final Av695 av695) {
        return (av695.g == null) ? 0 : X243.as(av695.g);
    }
    
    public static boolean q(final Av695 av695) {
        return X243.y(av695.g);
    }
    
    public static void j(final Av695 av695, final String s, final boolean b) {
        if (av695.h.containsKey(s)) {
            if (!b) {
                l(av695, av695.h.get(s), av695.d.p);
            }
            else {
                X243.i(av695.g, av695.h.get(s));
                av695.j = av695.h.get(s);
            }
        }
        else {
            av695.j = 1.0f;
        }
    }
    
    public static void e(final Av695 av695) {
        if (X243.y(av695.g)) {
            X243.c(av695.g);
        }
        X243.n(av695.g = E245.v(SoundManager.c, av695.e), true);
        av695.g.a();
        X243.i(av695.g, av695.j * av695.d.b);
    }
    
    public Av695(final String e, final X675 d) {
        this.g = null;
        this.j = 0.0f;
        this.e = "";
        this.h = new Hashtable();
        this.s = new long[] { 0L, 0L };
        this.b = new float[] { 1.0f, 1.0f };
        this.d = d;
        this.e = e;
        this.g = SoundManager.c.r(this.e, 0);
    }
    
    public static void b(final Av695 av695) {
        final long g = K589.g();
        if (av695.s[0] != 0L) {
            if (g > av695.s[1]) {
                X243.i(av695.g, av695.b[1]);
                av695.s[0] = 0L;
            }
        }
        else if (g >= av695.s[0] && g <= av695.s[1]) {
            final float j = av695.b[0] + (g - av695.s[0]) / (float)(av695.s[1] - av695.s[0]) * (av695.b[1] - av695.b[0]);
            av695.j = j;
            X243.i(av695.g, j * av695.d.b);
        }
        else {
            X243.i(av695.g, av695.d.b);
        }
    }
    
    public static void l(final Av695 av695, final float n, final long n2) {
        final long g = K589.g();
        av695.s[0] = g;
        av695.s[1] = g + n2;
        av695.b[0] = av695.j;
        av695.b[1] = n;
    }
    
    public static void w(final Av695 av695, final Gg3 gg3) {
        av695.e = Gg3.bk(gg3);
        for (int ar = Gg3.ar(gg3), i = 0; i < ar; ++i) {
            av695.h.put(Gg3.bk(gg3), Gg3.ar(gg3) / 100.0f);
        }
    }
    
    public static void s(final Av695 av695) {
        if (X243.y(av695.g)) {
            X243.c(av695.g);
        }
    }
}
