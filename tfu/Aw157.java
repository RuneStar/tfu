// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.HashMap;
import java.util.Map;
import com.jagex.js5.js5;

public class Aw157
{
    final js5 d;
    Map e;
    final js5 g;
    final int[] j;
    final Eq28 q;
    
    public void g(final Ab158 ab158) {
        this.e = new HashMap(this.j.length);
        for (int i = 0; i < this.j.length; ++i) {
            final int n = this.j[i];
            final Kj334 g = Kj334.g(this.d, n);
            this.e.put(i, new Jk523(ab158.d(js5.v(this.g, n), g, true), g));
        }
    }
    
    public static int q(final Aw157 aw157, final boolean b) {
        if (aw157.j == null) {
            return 0;
        }
        if (!b && aw157.e != null) {
            return aw157.j.length * 2;
        }
        int n = 0;
        for (int i = 0; i < aw157.j.length; ++i) {
            final int n2 = aw157.j[i];
            if (aw157.g.b(n2)) {
                ++n;
            }
            if (aw157.d.b(n2)) {
                ++n;
            }
        }
        return n;
    }
    
    public static int d(final Aw157 aw157) {
        return q(aw157, false);
    }
    
    public static Object e(final Aw157 aw157, final Ab158 ab158, final int n, final boolean b, final boolean b2) {
        final Jk523 s = aw157.s(ab158, n, b, b2);
        if (s == null) {
            return null;
        }
        return s.g;
    }
    
    private Jk523 s(final Ab158 ab158, final int n, final boolean b, final boolean b2) {
        if (n == -1) {
            return null;
        }
        if (this.j != null) {
            for (int i = 0; i < this.j.length; ++i) {
                if (this.j[i] == n) {
                    return (Jk523)this.e.get(i);
                }
            }
        }
        final Jk523 jk523 = (Jk523)this.q.g(n << 1 | (b2 ? 1 : 0));
        if (jk523 != null) {
            if (b && jk523.d == null) {
                final Kj334 g = Kj334.g(this.d, n);
                if (g == null) {
                    return null;
                }
                jk523.d = g;
            }
            return jk523;
        }
        final byte[] v = js5.v(this.g, n);
        if (v == null) {
            return null;
        }
        final Kj334 g2 = Kj334.g(this.d, n);
        if (g2 == null) {
            return null;
        }
        Jk523 jk524;
        if (b) {
            jk524 = new Jk523(ab158.d(v, g2, b2), g2);
        }
        else {
            jk524 = new Jk523(ab158.d(v, g2, b2), null);
        }
        Eq28.j(this.q, jk524, n << 1 | (b2 ? 1 : 0));
        return jk524;
    }
    
    public Aw157(final js5 g, final js5 d, final int[] j) {
        this.q = new Eq28(20);
        this.e = null;
        this.g = g;
        this.d = d;
        if (j != null) {
            this.j = j;
        }
        else {
            this.j = null;
        }
    }
    
    public static Kj334 h(final Aw157 aw157, final Ab158 ab158, final int n) {
        final Jk523 s = aw157.s(ab158, n, true, true);
        if (s == null) {
            return null;
        }
        return (Kj334)s.d;
    }
    
    public static void w(final Aw157 aw157) {
        Eq28.b(aw157.q);
    }
    
    public static int j(final Aw157 aw157) {
        if (aw157.j == null) {
            return 0;
        }
        return aw157.j.length * 2;
    }
    
    public static void l(final Aw157 aw157, final int n) {
        aw157.q.h(n);
    }
    
    public static void b(final Aw157 aw157) {
        Eq28.s(aw157.q);
    }
}
