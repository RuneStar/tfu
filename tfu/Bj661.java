/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import tfu.Jb525;
import tfu.Jj524;

public class Bj661
implements Jj524 {
    private final String d;
    private final js5 g;

    @Override
    public Jb525 d() {
        return Jb525.JS5_GROUP;
    }

    public Bj661(js5 js52, String string) {
        this.g = js52;
        this.d = string;
    }

    @Override
    public int g() {
        if (js5.ai(this.g, this.d)) {
            return 100;
        }
        return js5.al(this.g, this.d);
    }
}

