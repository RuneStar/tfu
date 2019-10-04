/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.ref.SoftReference;
import tfu.Fv466;

class Ew569
extends Fv466 {
    private SoftReference g;

    Ew569(Object object, int n) {
        super(n);
        this.g = new SoftReference<Object>(object);
    }

    @Override
    boolean d() {
        return true;
    }

    @Override
    Object g() {
        return this.g.get();
    }
}

