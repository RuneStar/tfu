/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Cg550;

class Ct636 {
    private int d;
    private int e;
    int g = Cg550.j(16);
    private int h;
    private int j;
    private int q;
    private int[] s;

    Ct636() {
        int n;
        this.d = Cg550.j(24);
        this.q = Cg550.j(24);
        this.j = Cg550.j(24) + 1;
        this.e = Cg550.j(6) + 1;
        this.h = Cg550.j(8);
        int[] arrn = new int[this.e];
        for (n = 0; n < this.e; ++n) {
            boolean bl;
            int n2 = 0;
            int n3 = Cg550.j(3);
            boolean bl2 = bl = Cg550.q() != 0;
            if (bl) {
                n2 = Cg550.j(5);
            }
            arrn[n] = n2 << 3 | n3;
        }
        this.s = new int[this.e * 8];
        for (n = 0; n < this.e * 8; ++n) {
            this.s[n] = (arrn[n >> 3] & 1 << (n & 7)) != 0 ? Cg550.j(8) : -1;
        }
    }
}

