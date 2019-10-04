/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Iterator;
import tfu.Hn359;
import tfu.Kp349;

public class Hr428
implements Iterator {
    private Kp349 d;
    private Hn359 g;
    private Kp349 q = null;

    @Override
    public boolean hasNext() {
        return this.d != this.g.g;
    }

    public static Kp349 g(Hr428 hr428) {
        Kp349 kp349 = hr428.d;
        if (kp349 == hr428.g.g) {
            kp349 = null;
            hr428.d = null;
        } else {
            hr428.d = kp349.x;
        }
        hr428.q = kp349;
        return kp349;
    }

    @Override
    public void remove() {
        if (this.q == null) {
            throw new IllegalStateException();
        }
        Kp349.t(this.q);
        this.q = null;
    }

    public Hr428(Hn359 hn359) {
        this.g = hn359;
        this.d = this.g.g.x;
        this.q = null;
    }
}

