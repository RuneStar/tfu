/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import tfu.Jb525;
import tfu.Jj524;

public class Bp655
implements Jj524 {
    private final js5 g;

    public Bp655(js5 js52) {
        this.g = js52;
    }

    @Override
    public Jb525 d() {
        return Jb525.JS5;
    }

    @Override
    public int g() {
        if (js5.l(this.g)) {
            return 100;
        }
        return js5.r(this.g);
    }
}

