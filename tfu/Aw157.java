/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import java.util.HashMap;
import java.util.Map;
import tfu.Ab158;
import tfu.Eq28;
import tfu.Jk523;
import tfu.Kj334;

public class Aw157 {
    final js5 d;
    Map e = null;
    final js5 g;
    final int[] j;
    final Eq28 q = new Eq28(20);

    public void g(Ab158 ab158) {
        this.e = new HashMap(this.j.length);
        for (int i = 0; i < this.j.length; ++i) {
            int n = this.j[i];
            Kj334 kj334 = Kj334.g(this.d, n);
            byte[] arrby = js5.v(this.g, n);
            Object object = ab158.d(arrby, kj334, true);
            this.e.put(i, new Jk523(object, kj334));
        }
    }

    public static int q(Aw157 aw157, boolean bl) {
        if (aw157.j == null) {
            return 0;
        }
        if (!bl && aw157.e != null) {
            return aw157.j.length * 2;
        }
        int n = 0;
        for (int i = 0; i < aw157.j.length; ++i) {
            int n2 = aw157.j[i];
            if (aw157.g.b(n2)) {
                ++n;
            }
            if (!aw157.d.b(n2)) continue;
            ++n;
        }
        return n;
    }

    public static int d(Aw157 aw157) {
        return Aw157.q(aw157, false);
    }

    public static Object e(Aw157 aw157, Ab158 ab158, int n, boolean bl, boolean bl2) {
        Jk523 jk523 = aw157.s(ab158, n, bl, bl2);
        if (jk523 == null) {
            return null;
        }
        return jk523.g;
    }

    private Jk523 s(Ab158 ab158, int n, boolean bl, boolean bl2) {
        Jk523 jk523;
        if (n == -1) {
            return null;
        }
        if (this.j != null) {
            for (int i = 0; i < this.j.length; ++i) {
                if (this.j[i] != n) continue;
                return (Jk523)this.e.get(i);
            }
        }
        if ((jk523 = (Jk523)this.q.g(n << 1 | (bl2 ? 1 : 0))) != null) {
            if (bl && jk523.d == null) {
                Kj334 kj334 = Kj334.g(this.d, n);
                if (kj334 == null) {
                    return null;
                }
                jk523.d = kj334;
            }
            return jk523;
        }
        byte[] arrby = js5.v(this.g, n);
        if (arrby == null) {
            return null;
        }
        Kj334 kj334 = Kj334.g(this.d, n);
        if (kj334 == null) {
            return null;
        }
        jk523 = bl ? new Jk523(ab158.d(arrby, kj334, bl2), kj334) : new Jk523(ab158.d(arrby, kj334, bl2), null);
        Eq28.j(this.q, jk523, n << 1 | (bl2 ? 1 : 0));
        return jk523;
    }

    public Aw157(js5 js52, js5 js53, int[] arrn) {
        this.g = js52;
        this.d = js53;
        this.j = arrn != null ? arrn : null;
    }

    public static Kj334 h(Aw157 aw157, Ab158 ab158, int n) {
        Jk523 jk523 = aw157.s(ab158, n, true, true);
        if (jk523 == null) {
            return null;
        }
        return (Kj334)jk523.d;
    }

    public static void w(Aw157 aw157) {
        Eq28.b(aw157.q);
    }

    public static int j(Aw157 aw157) {
        if (aw157.j == null) {
            return 0;
        }
        return aw157.j.length * 2;
    }

    public static void l(Aw157 aw157, int n) {
        aw157.q.h(n);
    }

    public static void b(Aw157 aw157) {
        Eq28.s(aw157.q);
    }
}

