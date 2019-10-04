/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import org.slf4j.Logger;
import tfu.Hs30;
import tfu.Ib29;

public final class Gt488
implements Ib29 {
    private final String d;
    private final js5 g;
    private int q = -1;

    public static Integer s(Gt488 gt488, String string) {
        int n = gt488.g.getgroupid(string);
        if (n >= 0) {
            return n;
        }
        return null;
    }

    public byte[] h(Integer n) throws Hs30 {
        if (!this.g.q(n)) {
            String string = "Unrecognised " + this.d + ": " + n;
            Object.logger.error(string);
            if (this.q >= 0 && this.g.q(this.q)) {
                while (!this.g.requestgroupdownload(this.q)) {
                    Thread.yield();
                }
                return this.g.getfile(this.q, 0);
            }
            throw new Hs30(string);
        }
        while (!this.g.requestgroupdownload(n)) {
            Thread.yield();
        }
        return this.g.getfile(n, 0);
    }

    @Override
    public String getIdentifier() {
        return this.d;
    }

    public Gt488(js5 js52, String string) {
        if (js52 == null) {
            throw new IllegalArgumentException();
        }
        this.g = js52;
        this.d = string;
    }
}

