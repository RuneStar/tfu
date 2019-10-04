/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Cg550;
import tfu.Cm645;
import tfu.Cs635;
import tfu.Cw634;

public class Ci646
extends Cw634 {
    private float[] e;
    private Cg550 s;

    public Ci646(int n, float[] arrf, int n2, int n3, boolean bl) {
        this.g = n;
        this.e = arrf;
        this.d = n2;
        this.q = n3;
        this.j = bl;
    }

    @Override
    public int g() {
        return this.e.length;
    }

    public Cm645 b(int n, int n2, int n3) {
        if (this.e == null || this.e.length == 0) {
            return null;
        }
        return new Cm645(this, n, n2, n3);
    }

    public static float[] l(Ci646 ci646) {
        return ci646.e;
    }

    public static boolean w(Ci646 ci646) {
        if (ci646.s != null && !Cg550.r(ci646.s)) {
            ci646.s = null;
        }
        return ci646.s != null;
    }

    public Ci646(int n, Cg550 cg550, float[] arrf, int n2, int n3, boolean bl) {
        this.g = n;
        this.s = cg550;
        this.e = arrf;
        this.d = n2;
        this.q = n3;
        this.j = bl;
    }

    public static int r(Ci646 ci646) {
        if (!Ci646.w(ci646)) {
            return ci646.e.length - 1;
        }
        return Cg550.w(ci646.s);
    }
}

