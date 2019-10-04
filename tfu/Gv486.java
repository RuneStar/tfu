/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import tfu.Ip424;

public class Gv486
implements Ip424 {
    private final js5 g;

    public Gv486(js5 js52) {
        this.g = js52;
        if (!js5.i(this.g)) {
            throw new IllegalArgumentException();
        }
    }

    public static int g(Gv486 gv486, String string) {
        return gv486.g.getgroupid(string);
    }
}

