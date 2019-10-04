// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;

public final class Ha262 implements Iterable
{
    Ln265[] d;
    private Ln265 e;
    int g;
    private int h;
    private Ln265 j;
    private long q;
    
    public static Ln265 d(final Ha262 ha262, final long q) {
        ha262.q = q;
        final Ln265 ln265 = ha262.d[(int)(q & (long)(ha262.g - 1))];
        ha262.j = ln265.bo;
        while (ha262.j != ln265) {
            if (ha262.j.bq == q) {
                final Ln265 j = ha262.j;
                ha262.j = ha262.j.bo;
                return j;
            }
            ha262.j = ha262.j.bo;
        }
        return ha262.j = null;
    }
    
    public static void q(final Ha262 ha262, final Ln265 ln265, final long bq) {
        if (ln265.bl != null) {
            Ln265.ef(ln265);
        }
        final Ln265 bo = ha262.d[(int)(bq & (long)(ha262.g - 1))];
        ln265.bl = bo.bl;
        ln265.bo = bo;
        ln265.bl.bo = ln265;
        ln265.bo.bl = ln265;
        ln265.bq = bq;
    }
    
    public static void j(final Ha262 ha262) {
        for (int i = 0; i < ha262.g; ++i) {
            final Ln265 ln265 = ha262.d[i];
            while (true) {
                final Ln265 bo = ln265.bo;
                if (bo == ln265) {
                    break;
                }
                Ln265.ef(bo);
            }
        }
        ha262.j = null;
        ha262.e = null;
    }
    
    public static Ln265 e(final Ha262 ha262) {
        ha262.h = 0;
        return h(ha262);
    }
    
    public static Ln265 h(final Ha262 ha262) {
        if (ha262.h > 0 && ha262.e != ha262.d[ha262.h - 1]) {
            final Ln265 e = ha262.e;
            ha262.e = e.bo;
            return e;
        }
        while (ha262.h < ha262.g) {
            final Ln265 bo = ha262.d[ha262.h++].bo;
            if (bo != ha262.d[ha262.h - 1]) {
                ha262.e = bo.bo;
                return bo;
            }
        }
        return null;
    }
    
    @Override
    public Iterator iterator() {
        return new Hv415(this);
    }
    
    public Ha262(final int g) {
        this.h = 0;
        this.g = g;
        this.d = new Ln265[g];
        for (int i = 0; i < g; ++i) {
            final Ln265[] d = this.d;
            final int n = i;
            final Ln265 ln265 = new Ln265();
            d[n] = ln265;
            final Ln265 ln266 = ln265;
            ln266.bo = ln266;
            ln266.bl = ln266;
        }
    }
}
