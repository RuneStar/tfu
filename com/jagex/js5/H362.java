/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.js5;

import com.jagex.js5.js5;
import java.util.BitSet;
import tfu.Gg3;
import tfu.Iw364;
import tfu.Mr366;

public class H362 {
    private static final int g = 7;
    Mr366 b;
    public int d;
    int e;
    int[] h;
    public int j;
    int l;
    BitSet[] m;
    int[][] p;
    public byte[] q;
    byte[][] r;
    int[] s;
    BitSet t;
    Mr366[] u;
    int[] v;
    int[] w;
    int[][] x;
    int[] y;
    int[] z;

    private void g(byte[] arrby) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        Gg3 gg3 = new Gg3(js5.af(arrby));
        int n6 = Gg3.ar(gg3);
        if (n6 < 5 || n6 > 7) {
            throw new RuntimeException("Incorrect JS5 protocol number: " + n6);
        }
        this.j = n6 >= 6 ? Gg3.bd(gg3) : 0;
        int n7 = Gg3.ar(gg3);
        boolean bl = (n7 & 1) != 0;
        boolean bl2 = (n7 & 2) != 0;
        this.e = n6 >= 7 ? Gg3.bv(gg3) : Gg3.au(gg3);
        int n8 = 0;
        int n9 = -1;
        this.h = new int[this.e];
        if (n6 >= 7) {
            for (n = 0; n < this.e; ++n) {
                this.h[n] = n8 += Gg3.bv(gg3);
                if (this.h[n] <= n9) continue;
                n9 = this.h[n];
            }
        } else {
            for (n = 0; n < this.e; ++n) {
                this.h[n] = n8 += Gg3.au(gg3);
                if (this.h[n] <= n9) continue;
                n9 = this.h[n];
            }
        }
        this.l = n9 + 1;
        this.w = new int[this.l];
        if (bl2) {
            this.r = new byte[this.l][];
        }
        this.v = new int[this.l];
        this.y = new int[this.l];
        this.p = new int[this.l][];
        this.z = new int[this.l];
        if (bl) {
            this.s = new int[this.l];
            for (n = 0; n < this.l; ++n) {
                this.s[n] = -1;
            }
            for (n = 0; n < this.e; ++n) {
                this.s[this.h[n]] = Gg3.bd(gg3);
            }
            this.b = new Mr366(this.s);
        }
        for (n = 0; n < this.e; ++n) {
            this.w[this.h[n]] = Gg3.bd(gg3);
        }
        if (bl2) {
            for (n = 0; n < this.e; ++n) {
                byte[] arrby2 = new byte[64];
                Gg3.bx(gg3, arrby2, 0, 64);
                this.r[this.h[n]] = arrby2;
            }
        }
        for (n = 0; n < this.e; ++n) {
            this.v[this.h[n]] = Gg3.bd(gg3);
        }
        if (n6 >= 7) {
            for (n = 0; n < this.e; ++n) {
                this.y[this.h[n]] = Gg3.bv(gg3);
            }
            for (n = 0; n < this.e; ++n) {
                int n10 = this.h[n];
                n3 = this.y[n10];
                n8 = 0;
                n2 = -1;
                this.p[n10] = new int[n3];
                for (n4 = 0; n4 < n3; ++n4) {
                    this.p[n10][n4] = n8 += Gg3.bv(gg3);
                    n5 = n8;
                    if (n5 <= n2) continue;
                    n2 = n5;
                }
                this.z[n10] = n2 + 1;
                if (n2 + 1 != n3) continue;
                this.p[n10] = null;
            }
        } else {
            for (n = 0; n < this.e; ++n) {
                this.y[this.h[n]] = Gg3.au(gg3);
            }
            for (n = 0; n < this.e; ++n) {
                int n11 = this.h[n];
                n3 = this.y[n11];
                n8 = 0;
                n2 = -1;
                this.p[n11] = new int[n3];
                for (n4 = 0; n4 < n3; ++n4) {
                    this.p[n11][n4] = n8 += Gg3.au(gg3);
                    n5 = n8;
                    if (n5 <= n2) continue;
                    n2 = n5;
                }
                this.z[n11] = n2 + 1;
                if (n2 + 1 != n3) continue;
                this.p[n11] = null;
            }
        }
        if (bl) {
            this.x = new int[n9 + 1][];
            this.u = new Mr366[n9 + 1];
            for (n = 0; n < this.e; ++n) {
                int n12 = this.h[n];
                n3 = this.y[n12];
                this.x[n12] = new int[this.z[n12]];
                for (n2 = 0; n2 < this.z[n12]; ++n2) {
                    this.x[n12][n2] = -1;
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    n4 = this.p[n12] != null ? this.p[n12][n2] : n2;
                    this.x[n12][n4] = Gg3.bd(gg3);
                }
                this.u[n12] = new Mr366(this.x[n12]);
            }
        }
    }

    H362(byte[] arrby, boolean bl) {
        this.d = Gg3.m(arrby, arrby.length);
        if (bl) {
            this.q = Iw364.e(arrby, 0, arrby.length);
        }
        this.g(arrby);
    }

    H362(byte[] arrby, int n, byte[] arrby2) {
        this.d = Gg3.m(arrby, arrby.length);
        if (this.d != n) {
            throw new RuntimeException("Invalid CRC - expected:" + n + " got:" + this.d);
        }
        if (arrby2 != null) {
            if (arrby2.length != 64) {
                throw new RuntimeException("Invalid expectedwhirlpool - must be 64 bytes long");
            }
            this.q = Iw364.e(arrby, 0, arrby.length);
            for (int i = 0; i < 64; ++i) {
                if (this.q[i] == arrby2[i]) continue;
                throw new RuntimeException("Invalid Whirlpool - expected:" + js5.av(arrby2) + " got:" + js5.av(this.q));
            }
        }
        this.g(arrby);
    }
}

