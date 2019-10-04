/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Iterator;
import tfu.Ha262;
import tfu.Ln265;

public class Hv415
implements Iterator {
    private Ln265 d;
    private Ha262 g;
    private Ln265 j = null;
    private int q;

    public static Ln265 j(Hv415 hv415) {
        if (hv415.d != hv415.g.d[hv415.q - 1]) {
            Ln265 ln265 = hv415.d;
            hv415.d = ln265.bo;
            hv415.j = ln265;
            return ln265;
        }
        while (hv415.q < hv415.g.g) {
            Ln265 ln265 = hv415.g.d[hv415.q++].bo;
            if (ln265 == hv415.g.d[hv415.q - 1]) continue;
            hv415.d = ln265.bo;
            hv415.j = ln265;
            return ln265;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (this.d != this.g.d[this.q - 1]) {
            return true;
        }
        while (this.q < this.g.g) {
            if (this.g.d[this.q++].bo != this.g.d[this.q - 1]) {
                this.d = this.g.d[this.q - 1].bo;
                return true;
            }
            this.d = this.g.d[this.q - 1];
        }
        return false;
    }

    public Hv415(Ha262 ha262) {
        this.g = ha262;
        Hv415.g(this);
    }

    public static void g(Hv415 hv415) {
        hv415.d = hv415.g.d[0].bo;
        hv415.q = 1;
        hv415.j = null;
    }

    @Override
    public void remove() {
        if (this.j == null) {
            throw new IllegalStateException();
        }
        Ln265.ef(this.j);
        this.j = null;
    }
}

