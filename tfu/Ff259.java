/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.constants.Language;
import tfu.Fe459;
import tfu.Gd27;

public abstract class Ff259
implements Fe459 {
    public final Language d;
    public final Gd27 g;
    protected int q;

    @Override
    public int length() {
        return this.q;
    }

    protected Ff259(Gd27 gd27, Language language, int n) {
        this.g = gd27;
        this.d = language;
        this.q = n;
    }
}

