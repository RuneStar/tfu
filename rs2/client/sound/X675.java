/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import fmod.E245;
import fmod.X243;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import rs2.client.sound.Av695;
import rs2.client.sound.G593;
import rs2.client.sound.K589;
import rs2.client.sound.M682;
import rs2.client.sound.N680;
import rs2.client.sound.SoundManager;
import tfu.Gg3;

class X675 {
    public float b = 1.0f;
    public String d;
    public LinkedList e;
    private Random g = new Random();
    private long[] h;
    long i = 0L;
    public ArrayList j;
    int k;
    public long l = 0L;
    int m;
    int n;
    float o = 0.0f;
    public int p;
    private ArrayList q = new ArrayList();
    public int r;
    private float[] s;
    int t;
    int u;
    public int v;
    public int w;
    int x;
    public int y;
    int z;

    public static void g(X675 x675) {
        X675.j(x675, 1.0f);
        x675.o = 0.0f;
        X675.l(x675, null);
        for (Av695 av695 : x675.e) {
            Av695.e(av695);
        }
        for (Av695 av695 : x675.e) {
            X243.n(av695.g, false);
        }
        x675.l = K589.g();
        K589.s = x675;
        X675.b(x675);
    }

    public static void h(X675 x675) {
        x675.q.clear();
    }

    public static void q(X675 x675) {
        for (Av695 av695 : x675.e) {
            Av695.s(av695);
        }
    }

    public static void j(X675 x675, float f) {
        x675.b = f;
    }

    public static float e(X675 x675) {
        return x675.b;
    }

    public static void l(X675 x675, String string) {
        if (string == null) {
            for (Av695 av695 : x675.e) {
                av695.j = 0.0f;
            }
            if (x675.e.size() > 0) {
                ((Av695)x675.e.get((int)0)).j = 1.0f;
            }
        } else {
            for (Av695 av695 : x675.e) {
                Av695.j(av695, string, !X675.w(x675));
            }
        }
    }

    public X675() {
        this.j = new ArrayList();
        this.e = new LinkedList();
        this.h = new long[]{0L, 0L};
        this.s = new float[]{1.0f, 1.0f};
    }

    public static synchronized void r(X675 x675) {
        long l;
        int n;
        long l2 = l = K589.s == null ? 0L : X675.x(K589.s);
        if (x675.o != 0.0f) {
            float f = X675.e(x675) + x675.o;
            if (f < 0.0f) {
                f = 0.0f;
                x675.o = 0.0f;
                X675.q(x675);
            } else {
                X675.j(x675, f);
            }
        }
        if ((n = x675.q.size()) > 0) {
            for (int i = n - 1; i >= 0; --i) {
                Object object = (N680)x675.q.get(i);
                if (l <= ((N680)object).s) continue;
                switch (((N680)object).w) {
                    case 0: {
                        if (K589.s != null) {
                            K589.s.o = -(33.333332f / (float)x675.y);
                        }
                        X675.d(x675, (int)(l - ((N680)object).s));
                        K589.b = null;
                        break;
                    }
                    case 1: {
                        X675.q(x675);
                        break;
                    }
                    case 4: {
                        float f = (float)(((N680)object).b - ((N680)object).s) / 1000.0f;
                        x675.o = -0.01f;
                        break;
                    }
                    case 2: {
                        x675.h[0] = ((N680)object).s;
                        x675.h[1] = ((N680)object).b;
                        x675.s[0] = X675.e(x675);
                        x675.s[1] = ((N680)object).h;
                        break;
                    }
                    case 3: {
                        X675.l(x675, ((N680)object).l);
                    }
                }
                x675.q.remove(i);
            }
        }
        for (Object object : x675.e) {
            Av695.b((Av695)object);
        }
    }

    public void v() {
        M682 m682 = new M682(this);
        if (K589.s == this) {
            return;
        }
        if (this.e.size() > 0) {
            if (SoundManager.c.r(((Av695)this.e.get((int)0)).e, 4).ai()) {
                m682.g("", this);
            } else {
                String[] arrstring = SoundManager.c.r(((Av695)this.e.get((int)0)).e, 4).aq();
                if (arrstring != null && arrstring.length > 0) {
                    G593.g(arrstring[0], 180000L, true, m682, this);
                }
            }
        }
    }

    public static void y(X675 x675) {
        if (x675.j.size() > 0) {
            int n;
            X675 x6752;
            while ((x6752 = K589.e((String)x675.j.get(n = x675.g.nextInt(x675.j.size())))) == K589.s) {
            }
            if (x6752 != null) {
                x6752.v();
                return;
            }
        }
        x675.v();
    }

    public void p(Gg3 gg3) {
        int n;
        this.d = Gg3.bk(gg3);
        this.x = Gg3.ar(gg3);
        this.u = Gg3.ar(gg3);
        this.z = Gg3.ar(gg3);
        this.t = Gg3.ar(gg3);
        this.m = Gg3.ar(gg3);
        this.n = Gg3.ar(gg3);
        this.k = Gg3.ar(gg3);
        int n2 = Gg3.au(gg3);
        for (n = 0; n < n2; ++n) {
            this.j.add(Gg3.bk(gg3));
        }
        n = Gg3.ar(gg3);
        for (int i = 0; i < n; ++i) {
            Av695 av695 = new Av695("", this);
            Av695.w(av695, gg3);
            this.e.add(av695);
        }
    }

    public static int u(X675 x675) {
        if (x675.e.size() == 0) {
            return 0;
        }
        return Av695.d((Av695)x675.e.get(0));
    }

    static /* synthetic */ void z(X675 x675) {
        X675.b(x675);
    }

    private static void b(X675 x675) {
        x675.w = (int)(60000.0f / (float)x675.x);
        x675.r = x675.w * x675.t;
        x675.v = x675.w * x675.m;
        x675.y = x675.w * x675.n;
        x675.p = x675.w * x675.k;
    }

    public static void s(X675 x675, N680 n680) {
        int n = x675.q.size();
        if (n == 0 || ((N680)x675.q.get((int)(n - 1))).s <= n680.s) {
            x675.q.add(n680);
        } else {
            for (int i = 0; i < n; ++i) {
                if (((N680)x675.q.get((int)i)).s <= n680.s) continue;
                x675.q.add(i, n680);
                break;
            }
        }
    }

    public static void d(X675 x675, int n) {
        X675.j(x675, 1.0f);
        x675.o = 0.0f;
        X675.l(x675, null);
        for (Av695 av695 : x675.e) {
            Av695.h(av695, n);
        }
        for (Av695 av695 : x675.e) {
            X243.n(av695.g, false);
        }
        x675.l = K589.g();
        K589.s = x675;
        X675.b(x675);
    }

    public static boolean w(X675 x675) {
        boolean bl = false;
        for (Av695 av695 : x675.e) {
            bl |= Av695.q(av695);
        }
        return bl;
    }

    public static long x(X675 x675) {
        if (x675.e.size() == 0) {
            return 0L;
        }
        return Av695.g((Av695)x675.e.get(0));
    }
}

