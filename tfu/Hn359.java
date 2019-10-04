/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Iterator;
import tfu.Hr428;
import tfu.Kp349;

public class Hn359
implements Iterable {
    private Kp349 d;
    public Kp349 g;

    public Hn359() {
        this.g.x = this.g = new Kp349();
        this.g.u = this.g;
    }

    public static void d(Hn359 hn359) {
        while (hn359.g.x != hn359.g) {
            Kp349.t(hn359.g.x);
        }
    }

    public static void q(Hn359 hn359, Kp349 kp349) {
        if (kp349.u != null) {
            Kp349.t(kp349);
        }
        kp349.u = hn359.g.u;
        kp349.x = hn359.g;
        kp349.u.x = kp349;
        kp349.x.u = kp349;
    }

    public static Kp349 e(Hn359 hn359) {
        Kp349 kp349 = hn359.g.x;
        if (kp349 == hn359.g) {
            return null;
        }
        Kp349.t(kp349);
        return kp349;
    }

    public static Kp349 s(Hn359 hn359, Kp349 kp349) {
        Kp349 kp3492 = kp349 == null ? hn359.g.x : kp349;
        if (kp3492 == hn359.g) {
            hn359.d = null;
            return null;
        }
        hn359.d = kp3492.x;
        return kp3492;
    }

    public static Kp349 b(Hn359 hn359) {
        Kp349 kp349 = hn359.d;
        if (kp349 == hn359.g) {
            hn359.d = null;
            return null;
        }
        hn359.d = kp349.x;
        return kp349;
    }

    public static int l(Hn359 hn359) {
        int n = 0;
        Kp349 kp349 = hn359.g.x;
        while (kp349 != hn359.g) {
            ++n;
            kp349 = kp349.x;
        }
        return n;
    }

    public Iterator iterator() {
        return new Hr428(this);
    }

    public static Kp349 h(Hn359 hn359) {
        return Hn359.s(hn359, null);
    }

    public static void j(Kp349 kp349, Kp349 kp3492) {
        if (kp349.u != null) {
            Kp349.t(kp349);
        }
        kp349.u = kp3492;
        kp349.x = kp3492.x;
        kp349.u.x = kp349;
        kp349.x.u = kp349;
    }
}

