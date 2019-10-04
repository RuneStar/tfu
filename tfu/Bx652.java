/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import rs2.client.client;
import tfu.Df147;
import tfu.Jb525;
import tfu.Jj524;

public class Bx652
implements Jj524 {
    private boolean d;
    private final String g;

    @Override
    public int g() {
        if (this.d) {
            return 100;
        }
        int n = client.el.d(this.g);
        if (n >= 0 && n <= 100) {
            return n;
        }
        this.d = true;
        return 100;
    }

    public static boolean w(Bx652 bx652) {
        return bx652.d;
    }

    @Override
    public Jb525 d() {
        return Jb525.NATIVE_LIBRARY;
    }

    public Bx652(String string) {
        this.g = string;
    }
}

