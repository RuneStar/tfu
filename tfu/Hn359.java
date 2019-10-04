// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;

public class Hn359 implements Iterable
{
    private Kp349 d;
    public Kp349 g;
    
    public Hn359() {
        this.g = new Kp349();
        this.g.x = this.g;
        this.g.u = this.g;
    }
    
    public static void d(final Hn359 hn359) {
        while (hn359.g.x != hn359.g) {
            Kp349.t(hn359.g.x);
        }
    }
    
    public static void q(final Hn359 hn359, final Kp349 kp349) {
        if (kp349.u != null) {
            Kp349.t(kp349);
        }
        kp349.u = hn359.g.u;
        kp349.x = hn359.g;
        kp349.u.x = kp349;
        kp349.x.u = kp349;
    }
    
    public static Kp349 e(final Hn359 hn359) {
        final Kp349 x = hn359.g.x;
        if (x == hn359.g) {
            return null;
        }
        Kp349.t(x);
        return x;
    }
    
    public static Kp349 s(final Hn359 hn359, final Kp349 kp349) {
        Kp349 x;
        if (kp349 == null) {
            x = hn359.g.x;
        }
        else {
            x = kp349;
        }
        if (x == hn359.g) {
            return hn359.d = null;
        }
        hn359.d = x.x;
        return x;
    }
    
    public static Kp349 b(final Hn359 hn359) {
        final Kp349 d = hn359.d;
        if (d == hn359.g) {
            return hn359.d = null;
        }
        hn359.d = d.x;
        return d;
    }
    
    public static int l(final Hn359 hn359) {
        int n = 0;
        for (Kp349 kp349 = hn359.g.x; kp349 != hn359.g; kp349 = kp349.x) {
            ++n;
        }
        return n;
    }
    
    @Override
    public Iterator iterator() {
        return new Hr428(this);
    }
    
    public static Kp349 h(final Hn359 hn359) {
        return s(hn359, null);
    }
    
    public static void j(final Kp349 kp349, final Kp349 u) {
        if (kp349.u != null) {
            Kp349.t(kp349);
        }
        kp349.u = u;
        kp349.x = u.x;
        kp349.u.x = kp349;
        kp349.x.u = kp349;
    }
}
