/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Iterator;
import tfu.Hv415;
import tfu.Ln265;

public final class Ha262
implements Iterable {
    Ln265[] d;
    private Ln265 e;
    int g;
    private int h = 0;
    private Ln265 j;
    private long q;

    public static Ln265 d(Ha262 ha262, long l) {
        ha262.q = l;
        Ln265 ln265 = ha262.d[(int)(l & (long)(ha262.g - 1))];
        ha262.j = ln265.bo;
        while (ha262.j != ln265) {
            if (ha262.j.bq == l) {
                Ln265 ln2652 = ha262.j;
                ha262.j = ha262.j.bo;
                return ln2652;
            }
            ha262.j = ha262.j.bo;
        }
        ha262.j = null;
        return null;
    }

    public static void q(Ha262 ha262, Ln265 ln265, long l) {
        if (ln265.bl != null) {
            Ln265.ef(ln265);
        }
        Ln265 ln2652 = ha262.d[(int)(l & (long)(ha262.g - 1))];
        ln265.bl = ln2652.bl;
        ln265.bo = ln2652;
        ln265.bl.bo = ln265;
        ln265.bo.bl = ln265;
        ln265.bq = l;
    }

    public static void j(Ha262 ha262) {
        for (int i = 0; i < ha262.g; ++i) {
            Ln265 ln265;
            Ln265 ln2652 = ha262.d[i];
            while ((ln265 = ln2652.bo) != ln2652) {
                Ln265.ef(ln265);
            }
        }
        ha262.j = null;
        ha262.e = null;
    }

    public static Ln265 e(Ha262 ha262) {
        ha262.h = 0;
        return Ha262.h(ha262);
    }

    public static Ln265 h(Ha262 ha262) {
        if (ha262.h > 0 && ha262.e != ha262.d[ha262.h - 1]) {
            Ln265 ln265 = ha262.e;
            ha262.e = ln265.bo;
            return ln265;
        }
        while (ha262.h < ha262.g) {
            Ln265 ln265 = ha262.d[ha262.h++].bo;
            if (ln265 == ha262.d[ha262.h - 1]) continue;
            ha262.e = ln265.bo;
            return ln265;
        }
        return null;
    }

    public Iterator iterator() {
        return new Hv415(this);
    }

    public Ha262(int n) {
        this.g = n;
        this.d = new Ln265[n];
        for (int i = 0; i < n; ++i) {
            Ln265 ln265;
            ln265.bo = ln265 = (this.d[i] = new Ln265());
            ln265.bl = ln265;
        }
    }
}

