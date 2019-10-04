/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Collection;
import java.util.Iterator;
import tfu.Gr482;
import tfu.Ln265;

public class Gx298
implements Iterable,
Collection {
    private Ln265 d;
    public Ln265 g;

    public static void z(Gx298 gx298) {
        while (gx298.g.bo != gx298.g) {
            Ln265.ef(gx298.g.bo);
        }
    }

    public static void t(Gx298 gx298, Ln265 ln265) {
        if (ln265.bl != null) {
            Ln265.ef(ln265);
        }
        ln265.bl = gx298.g.bl;
        ln265.bo = gx298.g;
        ln265.bl.bo = ln265;
        ln265.bo.bl = ln265;
    }

    public static void m(Gx298 gx298, Ln265 ln265) {
        if (ln265.bl != null) {
            Ln265.ef(ln265);
        }
        ln265.bl = gx298.g;
        ln265.bo = gx298.g.bo;
        ln265.bl.bo = ln265;
        ln265.bo.bl = ln265;
    }

    public static void n(Ln265 ln265, Ln265 ln2652) {
        if (ln265.bl != null) {
            Ln265.ef(ln265);
        }
        ln265.bl = ln2652.bl;
        ln265.bo = ln2652;
        ln265.bl.bo = ln265;
        ln265.bo.bl = ln265;
    }

    public static Ln265 k(Gx298 gx298) {
        Ln265 ln265 = gx298.g.bl;
        if (ln265 == gx298.g) {
            return null;
        }
        Ln265.ef(ln265);
        return ln265;
    }

    public static Ln265 i(Gx298 gx298) {
        return Gx298.o(gx298, null);
    }

    public static Ln265 a(Gx298 gx298) {
        return Gx298.f(gx298, null);
    }

    public static Ln265 o(Gx298 gx298, Ln265 ln265) {
        Ln265 ln2652 = ln265 == null ? gx298.g.bo : ln265;
        if (ln2652 == gx298.g) {
            gx298.d = null;
            return null;
        }
        gx298.d = ln2652.bo;
        return ln2652;
    }

    public static int aq(Gx298 gx298) {
        int n = 0;
        Ln265 ln265 = gx298.g.bo;
        while (ln265 != gx298.g) {
            ++n;
            ln265 = ln265.bo;
        }
        return n;
    }

    public static boolean ai(Gx298 gx298) {
        return gx298.g.bo == gx298.g;
    }

    public static Ln265[] af(Gx298 gx298) {
        Ln265[] arrln265 = new Ln265[Gx298.aq(gx298)];
        int n = 0;
        Ln265 ln265 = gx298.g.bo;
        while (ln265 != gx298.g) {
            arrln265[n++] = ln265;
            ln265 = ln265.bo;
        }
        return arrln265;
    }

    @Override
    public Iterator iterator() {
        return new Gr482(this);
    }

    @Override
    public int size() {
        return Gx298.aq(this);
    }

    @Override
    public boolean isEmpty() {
        return Gx298.ai(this);
    }

    public boolean containsAll(Collection collection) {
        throw new RuntimeException();
    }

    @Override
    public Object[] toArray() {
        return Gx298.af(this);
    }

    public static boolean av(Gx298 gx298, Ln265 ln265) {
        Gx298.t(gx298, ln265);
        return true;
    }

    @Override
    public boolean remove(Object object) {
        throw new RuntimeException();
    }

    public boolean addAll(Collection collection) {
        throw new RuntimeException();
    }

    public boolean removeAll(Collection collection) {
        throw new RuntimeException();
    }

    public static int al(Gx298 gx298, Ln265[] arrln265) {
        int n = 0;
        Ln265 ln265 = gx298.g.bo;
        while (ln265 != gx298.g) {
            arrln265[n++] = ln265;
            ln265 = ln265.bo;
        }
        return n;
    }

    @Override
    public void clear() {
        Gx298.z(this);
    }

    public Gx298() {
        this.g.bo = this.g = new Ln265();
        this.g.bl = this.g;
    }

    @Override
    public boolean contains(Object object) {
        throw new RuntimeException();
    }

    public static Ln265 c(Gx298 gx298) {
        Ln265 ln265 = gx298.d;
        if (ln265 == gx298.g) {
            gx298.d = null;
            return null;
        }
        gx298.d = ln265.bo;
        return ln265;
    }

    public Object[] toArray(Object[] arrobject) {
        int n = 0;
        Ln265 ln265 = this.g.bo;
        while (ln265 != this.g) {
            arrobject[n++] = ln265;
            ln265 = ln265.bo;
        }
        return arrobject;
    }

    public boolean retainAll(Collection collection) {
        throw new RuntimeException();
    }

    public static Ln265 f(Gx298 gx298, Ln265 ln265) {
        Ln265 ln2652 = ln265 == null ? gx298.g.bl : ln265;
        if (ln2652 == gx298.g) {
            gx298.d = null;
            return null;
        }
        gx298.d = ln2652.bl;
        return ln2652;
    }

    public static Ln265 ag(Gx298 gx298) {
        Ln265 ln265 = gx298.d;
        if (ln265 == gx298.g) {
            gx298.d = null;
            return null;
        }
        gx298.d = ln265.bl;
        return ln265;
    }
}

