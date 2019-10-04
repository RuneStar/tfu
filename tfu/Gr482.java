/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Iterator;
import tfu.Gx298;
import tfu.Ln265;

public class Gr482
implements Iterator {
    private Ln265 d;
    private Gx298 g;
    private Ln265 q = null;

    public static Ln265 g(Gr482 gr482) {
        Ln265 ln265 = gr482.d;
        if (ln265 == gr482.g.g) {
            ln265 = null;
            gr482.d = null;
        } else {
            gr482.d = ln265.bo;
        }
        gr482.q = ln265;
        return ln265;
    }

    @Override
    public boolean hasNext() {
        return this.d != this.g.g;
    }

    @Override
    public void remove() {
        if (this.q == null) {
            throw new IllegalStateException();
        }
        Ln265.ef(this.q);
        this.q = null;
    }

    public Gr482(Gx298 gx298) {
        this.g = gx298;
        this.d = this.g.g.bo;
        this.q = null;
    }
}

