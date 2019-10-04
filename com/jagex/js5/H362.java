// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.js5;

import tfu.Iw364;
import tfu.Gg3;
import java.util.BitSet;
import tfu.Mr366;

public class H362
{
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
    
    private void g(final byte[] array) {
        final Gg3 gg3 = new Gg3(js5.af(array));
        final int ar = Gg3.ar(gg3);
        if (ar < 5 || ar > 7) {
            throw new RuntimeException("Incorrect JS5 protocol number: " + ar);
        }
        if (ar >= 6) {
            this.j = Gg3.bd(gg3);
        }
        else {
            this.j = 0;
        }
        final int ar2 = Gg3.ar(gg3);
        final boolean b = (ar2 & 0x1) != 0x0;
        final boolean b2 = (ar2 & 0x2) != 0x0;
        if (ar >= 7) {
            this.e = Gg3.bv(gg3);
        }
        else {
            this.e = Gg3.au(gg3);
        }
        int n = 0;
        int n2 = -1;
        this.h = new int[this.e];
        if (ar >= 7) {
            for (int i = 0; i < this.e; ++i) {
                n = (this.h[i] = n + Gg3.bv(gg3));
                if (this.h[i] > n2) {
                    n2 = this.h[i];
                }
            }
        }
        else {
            for (int j = 0; j < this.e; ++j) {
                n = (this.h[j] = n + Gg3.au(gg3));
                if (this.h[j] > n2) {
                    n2 = this.h[j];
                }
            }
        }
        this.l = n2 + 1;
        this.w = new int[this.l];
        if (b2) {
            this.r = new byte[this.l][];
        }
        this.v = new int[this.l];
        this.y = new int[this.l];
        this.p = new int[this.l][];
        this.z = new int[this.l];
        if (b) {
            this.s = new int[this.l];
            for (int k = 0; k < this.l; ++k) {
                this.s[k] = -1;
            }
            for (int l = 0; l < this.e; ++l) {
                this.s[this.h[l]] = Gg3.bd(gg3);
            }
            this.b = new Mr366(this.s);
        }
        for (int n3 = 0; n3 < this.e; ++n3) {
            this.w[this.h[n3]] = Gg3.bd(gg3);
        }
        if (b2) {
            for (int n4 = 0; n4 < this.e; ++n4) {
                final byte[] array2 = new byte[64];
                Gg3.bx(gg3, array2, 0, 64);
                this.r[this.h[n4]] = array2;
            }
        }
        for (int n5 = 0; n5 < this.e; ++n5) {
            this.v[this.h[n5]] = Gg3.bd(gg3);
        }
        if (ar >= 7) {
            for (int n6 = 0; n6 < this.e; ++n6) {
                this.y[this.h[n6]] = Gg3.bv(gg3);
            }
            for (int n7 = 0; n7 < this.e; ++n7) {
                final int n8 = this.h[n7];
                final int n9 = this.y[n8];
                int n10 = 0;
                int n11 = -1;
                this.p[n8] = new int[n9];
                for (int n12 = 0; n12 < n9; ++n12) {
                    final int[] array3 = this.p[n8];
                    final int n13 = n12;
                    final int n14 = n10 += Gg3.bv(gg3);
                    array3[n13] = n14;
                    final int n15 = n14;
                    if (n15 > n11) {
                        n11 = n15;
                    }
                }
                this.z[n8] = n11 + 1;
                if (n11 + 1 == n9) {
                    this.p[n8] = null;
                }
            }
        }
        else {
            for (int n16 = 0; n16 < this.e; ++n16) {
                this.y[this.h[n16]] = Gg3.au(gg3);
            }
            for (int n17 = 0; n17 < this.e; ++n17) {
                final int n18 = this.h[n17];
                final int n19 = this.y[n18];
                int n20 = 0;
                int n21 = -1;
                this.p[n18] = new int[n19];
                for (int n22 = 0; n22 < n19; ++n22) {
                    final int[] array4 = this.p[n18];
                    final int n23 = n22;
                    final int n24 = n20 += Gg3.au(gg3);
                    array4[n23] = n24;
                    final int n25 = n24;
                    if (n25 > n21) {
                        n21 = n25;
                    }
                }
                this.z[n18] = n21 + 1;
                if (n21 + 1 == n19) {
                    this.p[n18] = null;
                }
            }
        }
        if (b) {
            this.x = new int[n2 + 1][];
            this.u = new Mr366[n2 + 1];
            for (int n26 = 0; n26 < this.e; ++n26) {
                final int n27 = this.h[n26];
                final int n28 = this.y[n27];
                this.x[n27] = new int[this.z[n27]];
                for (int n29 = 0; n29 < this.z[n27]; ++n29) {
                    this.x[n27][n29] = -1;
                }
                for (int n30 = 0; n30 < n28; ++n30) {
                    int n31;
                    if (this.p[n27] != null) {
                        n31 = this.p[n27][n30];
                    }
                    else {
                        n31 = n30;
                    }
                    this.x[n27][n31] = Gg3.bd(gg3);
                }
                this.u[n27] = new Mr366(this.x[n27]);
            }
        }
    }
    
    H362(final byte[] array, final boolean b) {
        this.d = Gg3.m(array, array.length);
        if (b) {
            this.q = Iw364.e(array, 0, array.length);
        }
        this.g(array);
    }
    
    H362(final byte[] array, final int i, final byte[] array2) {
        this.d = Gg3.m(array, array.length);
        if (this.d != i) {
            throw new RuntimeException("Invalid CRC - expected:" + i + " got:" + this.d);
        }
        if (array2 != null) {
            if (array2.length != 64) {
                throw new RuntimeException("Invalid expectedwhirlpool - must be 64 bytes long");
            }
            this.q = Iw364.e(array, 0, array.length);
            for (int j = 0; j < 64; ++j) {
                if (this.q[j] != array2[j]) {
                    throw new RuntimeException("Invalid Whirlpool - expected:" + js5.av(array2) + " got:" + js5.av(this.q));
                }
            }
        }
        this.g(array);
    }
}
