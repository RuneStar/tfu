// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import tfu.Gg3;
import java.util.Iterator;
import fmod.X243;
import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedList;

class X675
{
    public float b;
    public String d;
    public LinkedList e;
    private Random g;
    private long[] h;
    long i;
    public ArrayList j;
    int k;
    public long l;
    int m;
    int n;
    float o;
    public int p;
    private ArrayList q;
    public int r;
    private float[] s;
    int t;
    int u;
    public int v;
    public int w;
    int x;
    public int y;
    int z;
    
    public static void g(final X675 s) {
        j(s, 1.0f);
        s.o = 0.0f;
        l(s, null);
        final Iterator iterator = s.e.iterator();
        while (iterator.hasNext()) {
            Av695.e(iterator.next());
        }
        final Iterator iterator2 = s.e.iterator();
        while (iterator2.hasNext()) {
            X243.n(iterator2.next().g, false);
        }
        s.l = K589.g();
        b(K589.s = s);
    }
    
    public static void h(final X675 x675) {
        x675.q.clear();
    }
    
    public static void q(final X675 x675) {
        final Iterator iterator = x675.e.iterator();
        while (iterator.hasNext()) {
            Av695.s(iterator.next());
        }
    }
    
    public static void j(final X675 x675, final float b) {
        x675.b = b;
    }
    
    public static float e(final X675 x675) {
        return x675.b;
    }
    
    public static void l(final X675 x675, final String s) {
        if (s == null) {
            final Iterator iterator = x675.e.iterator();
            while (iterator.hasNext()) {
                iterator.next().j = 0.0f;
            }
            if (x675.e.size() > 0) {
                x675.e.get(0).j = 1.0f;
            }
        }
        else {
            final Iterator iterator2 = x675.e.iterator();
            while (iterator2.hasNext()) {
                Av695.j(iterator2.next(), s, !w(x675));
            }
        }
    }
    
    public X675() {
        this.g = new Random();
        this.q = new ArrayList();
        this.j = new ArrayList();
        this.e = new LinkedList();
        this.h = new long[] { 0L, 0L };
        this.s = new float[] { 1.0f, 1.0f };
        this.b = 1.0f;
        this.l = 0L;
        this.i = 0L;
        this.o = 0.0f;
    }
    
    public static synchronized void r(final X675 x675) {
        final long n = (K589.s == null) ? 0L : x(K589.s);
        if (x675.o != 0.0f) {
            final float n2 = e(x675) + x675.o;
            if (n2 < 0.0f) {
                x675.o = 0.0f;
                q(x675);
            }
            else {
                j(x675, n2);
            }
        }
        final int size = x675.q.size();
        if (size > 0) {
            for (int i = size - 1; i >= 0; --i) {
                final N680 n3 = x675.q.get(i);
                if (n > n3.s) {
                    switch (n3.w) {
                        case 0: {
                            if (K589.s != null) {
                                K589.s.o = -(33.333332f / x675.y);
                            }
                            d(x675, (int)(n - n3.s));
                            K589.b = null;
                            break;
                        }
                        case 1: {
                            q(x675);
                            break;
                        }
                        case 4: {
                            final float n4 = (n3.b - n3.s) / 1000.0f;
                            x675.o = -0.01f;
                            break;
                        }
                        case 2: {
                            x675.h[0] = n3.s;
                            x675.h[1] = n3.b;
                            x675.s[0] = e(x675);
                            x675.s[1] = n3.h;
                            break;
                        }
                        case 3: {
                            l(x675, n3.l);
                            break;
                        }
                    }
                    x675.q.remove(i);
                }
            }
        }
        final Iterator iterator = x675.e.iterator();
        while (iterator.hasNext()) {
            Av695.b(iterator.next());
        }
    }
    
    public void v() {
        final M682 m682 = new M682(this);
        if (K589.s == this) {
            return;
        }
        if (this.e.size() > 0) {
            if (SoundManager.c.r(this.e.get(0).e, 4).ai()) {
                m682.g("", this);
            }
            else {
                final String[] aq = SoundManager.c.r(this.e.get(0).e, 4).aq();
                if (aq != null && aq.length > 0) {
                    G593.g(aq[0], 180000L, true, m682, this);
                }
            }
        }
    }
    
    public static void y(final X675 x675) {
        if (x675.j.size() > 0) {
            X675 e;
            do {
                e = K589.e(x675.j.get(x675.g.nextInt(x675.j.size())));
            } while (e == K589.s);
            if (e != null) {
                e.v();
                return;
            }
        }
        x675.v();
    }
    
    public void p(final Gg3 gg3) {
        this.d = Gg3.bk(gg3);
        this.x = Gg3.ar(gg3);
        this.u = Gg3.ar(gg3);
        this.z = Gg3.ar(gg3);
        this.t = Gg3.ar(gg3);
        this.m = Gg3.ar(gg3);
        this.n = Gg3.ar(gg3);
        this.k = Gg3.ar(gg3);
        for (int au = Gg3.au(gg3), i = 0; i < au; ++i) {
            this.j.add(Gg3.bk(gg3));
        }
        for (int ar = Gg3.ar(gg3), j = 0; j < ar; ++j) {
            final Av695 e = new Av695("", this);
            Av695.w(e, gg3);
            this.e.add(e);
        }
    }
    
    public static int u(final X675 x675) {
        if (x675.e.size() == 0) {
            return 0;
        }
        return Av695.d(x675.e.get(0));
    }
    
    private static void b(final X675 x675) {
        x675.w = (int)(60000.0f / x675.x);
        x675.r = x675.w * x675.t;
        x675.v = x675.w * x675.m;
        x675.y = x675.w * x675.n;
        x675.p = x675.w * x675.k;
    }
    
    public static void s(final X675 x675, final N680 n680) {
        final int size = x675.q.size();
        if (size == 0 || ((N680)x675.q.get(size - 1)).s <= n680.s) {
            x675.q.add(n680);
        }
        else {
            for (int i = 0; i < size; ++i) {
                if (((N680)x675.q.get(i)).s > n680.s) {
                    x675.q.add(i, n680);
                    break;
                }
            }
        }
    }
    
    public static void d(final X675 s, final int n) {
        j(s, 1.0f);
        s.o = 0.0f;
        l(s, null);
        final Iterator iterator = s.e.iterator();
        while (iterator.hasNext()) {
            Av695.h(iterator.next(), n);
        }
        final Iterator iterator2 = s.e.iterator();
        while (iterator2.hasNext()) {
            X243.n(iterator2.next().g, false);
        }
        s.l = K589.g();
        b(K589.s = s);
    }
    
    public static boolean w(final X675 x675) {
        boolean b = false;
        final Iterator iterator = x675.e.iterator();
        while (iterator.hasNext()) {
            b |= Av695.q(iterator.next());
        }
        return b;
    }
    
    public static long x(final X675 x675) {
        if (x675.e.size() == 0) {
            return 0L;
        }
        return Av695.g(x675.e.get(0));
    }
}
