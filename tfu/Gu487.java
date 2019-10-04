/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import tfu.Hs30;
import tfu.Ib29;

public class Gu487
implements Ib29 {
    public static final int g = 16777216;
    private final js5 d;
    private int e = -1;
    private final String j;
    private final int q;

    @Override
    public String getIdentifier() {
        return this.j;
    }

    public byte[] h(Integer n) throws Hs30 {
        if (!this.d.q(this.q)) {
            throw new Hs30("Unrecognised " + this.j + ": " + n);
        }
        while (!this.d.requestgroupdownload(this.q)) {
            Thread.yield();
        }
        byte[] arrby = this.d.getfile(this.q, n);
        return arrby;
    }

    public static Integer s(Gu487 gu487, String string) {
        int n = gu487.d.getfileid(gu487.q, string);
        if (n >= 0) {
            return n;
        }
        return null;
    }

    public Gu487(js5 js52, String string, String string2) {
        if (js52 == null) {
            throw new IllegalArgumentException();
        }
        this.d = js52;
        this.j = string2;
        this.q = this.d.getgroupid(string);
    }
}

