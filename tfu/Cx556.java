/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Cb633;
import tfu.Ln265;

public abstract class Cx556
extends Ln265 {
    Cx556 ae;
    int bd;
    public Cb633 bm;
    public volatile boolean w = true;

    protected abstract Cx556 g();

    public abstract void j(int[] var1, int var2, int var3);

    protected abstract Cx556 d();

    public static final void ck(Cx556 cx556, int[] arrn, int n, int n2) {
        if (cx556.w) {
            cx556.j(arrn, n, n2);
        } else {
            cx556.e(n2);
        }
    }

    protected abstract int q();

    public abstract void e(int var1);

    protected int cd() {
        return 255;
    }
}

