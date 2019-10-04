// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;
import java.util.Collection;

public class Gx298 implements Iterable, Collection
{
    private Ln265 d;
    public Ln265 g;
    
    public static void z(final Gx298 gx298) {
        while (gx298.g.bo != gx298.g) {
            Ln265.ef(gx298.g.bo);
        }
    }
    
    public static void t(final Gx298 gx298, final Ln265 ln265) {
        if (ln265.bl != null) {
            Ln265.ef(ln265);
        }
        ln265.bl = gx298.g.bl;
        ln265.bo = gx298.g;
        ln265.bl.bo = ln265;
        ln265.bo.bl = ln265;
    }
    
    public static void m(final Gx298 gx298, final Ln265 ln265) {
        if (ln265.bl != null) {
            Ln265.ef(ln265);
        }
        ln265.bl = gx298.g;
        ln265.bo = gx298.g.bo;
        ln265.bl.bo = ln265;
        ln265.bo.bl = ln265;
    }
    
    public static void n(final Ln265 ln265, final Ln265 bo) {
        if (ln265.bl != null) {
            Ln265.ef(ln265);
        }
        ln265.bl = bo.bl;
        ln265.bo = bo;
        ln265.bl.bo = ln265;
        ln265.bo.bl = ln265;
    }
    
    public static Ln265 k(final Gx298 gx298) {
        final Ln265 bl = gx298.g.bl;
        if (bl == gx298.g) {
            return null;
        }
        Ln265.ef(bl);
        return bl;
    }
    
    public static Ln265 i(final Gx298 gx298) {
        return o(gx298, null);
    }
    
    public static Ln265 a(final Gx298 gx298) {
        return f(gx298, null);
    }
    
    public static Ln265 o(final Gx298 gx298, final Ln265 ln265) {
        Ln265 bo;
        if (ln265 == null) {
            bo = gx298.g.bo;
        }
        else {
            bo = ln265;
        }
        if (bo == gx298.g) {
            return gx298.d = null;
        }
        gx298.d = bo.bo;
        return bo;
    }
    
    public static int aq(final Gx298 gx298) {
        int n = 0;
        for (Ln265 ln265 = gx298.g.bo; ln265 != gx298.g; ln265 = ln265.bo) {
            ++n;
        }
        return n;
    }
    
    public static boolean ai(final Gx298 gx298) {
        return gx298.g.bo == gx298.g;
    }
    
    public static Ln265[] af(final Gx298 gx298) {
        final Ln265[] array = new Ln265[aq(gx298)];
        int n = 0;
        for (Ln265 ln265 = gx298.g.bo; ln265 != gx298.g; ln265 = ln265.bo) {
            array[n++] = ln265;
        }
        return array;
    }
    
    @Override
    public Iterator iterator() {
        return new Gr482(this);
    }
    
    @Override
    public int size() {
        return aq(this);
    }
    
    @Override
    public boolean isEmpty() {
        return ai(this);
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        throw new RuntimeException();
    }
    
    @Override
    public Object[] toArray() {
        return af(this);
    }
    
    public static boolean av(final Gx298 gx298, final Ln265 ln265) {
        t(gx298, ln265);
        return true;
    }
    
    @Override
    public boolean remove(final Object o) {
        throw new RuntimeException();
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        throw new RuntimeException();
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        throw new RuntimeException();
    }
    
    public static int al(final Gx298 gx298, final Ln265[] array) {
        int n = 0;
        for (Ln265 ln265 = gx298.g.bo; ln265 != gx298.g; ln265 = ln265.bo) {
            array[n++] = ln265;
        }
        return n;
    }
    
    @Override
    public void clear() {
        z(this);
    }
    
    public Gx298() {
        this.g = new Ln265();
        this.g.bo = this.g;
        this.g.bl = this.g;
    }
    
    @Override
    public boolean contains(final Object o) {
        throw new RuntimeException();
    }
    
    public static Ln265 c(final Gx298 gx298) {
        final Ln265 d = gx298.d;
        if (d == gx298.g) {
            return gx298.d = null;
        }
        gx298.d = d.bo;
        return d;
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        int n = 0;
        for (Ln265 ln265 = this.g.bo; ln265 != this.g; ln265 = ln265.bo) {
            array[n++] = ln265;
        }
        return array;
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        throw new RuntimeException();
    }
    
    public static Ln265 f(final Gx298 gx298, final Ln265 ln265) {
        Ln265 bl;
        if (ln265 == null) {
            bl = gx298.g.bl;
        }
        else {
            bl = ln265;
        }
        if (bl == gx298.g) {
            return gx298.d = null;
        }
        gx298.d = bl.bl;
        return bl;
    }
    
    public static Ln265 ag(final Gx298 gx298) {
        final Ln265 d = gx298.d;
        if (d == gx298.g) {
            return gx298.d = null;
        }
        gx298.d = d.bl;
        return d;
    }
}
