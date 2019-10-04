/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Cs635;
import tfu.Cv549;
import tfu.Cw634;

public class Cj551
extends Cw634 {
    public byte[] e;

    public Cj551(int n, byte[] arrby, int n2, int n3) {
        this.g = n;
        this.e = arrby;
        this.d = n2;
        this.q = n3;
    }

    @Override
    public int g() {
        return this.e.length;
    }

    public Cv549 b(int n, int n2, int n3) {
        if (this.e == null || this.e.length == 0) {
            return null;
        }
        return new Cv549(this, n, n2, n3);
    }

    public Cj551(int n, int n2) {
        this.g = n;
        this.e = new byte[n2];
        this.d = 0;
        this.q = n2;
    }

    public Cj551(int n, byte[] arrby, int n2, int n3, boolean bl) {
        this.g = n;
        this.e = arrby;
        this.d = n2;
        this.q = n3;
        this.j = bl;
    }
}

