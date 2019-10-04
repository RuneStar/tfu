/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Fp460;
import tfu.Fu461;
import tfu.Gg3;
import tfu.Hp62;
import tfu.Ia63;

public class Fk353
implements Hp62 {
    public static final int d = 6;
    public static final int e = 2047;
    public static final float h = 2048.0f;
    public static final int j = 2048;
    public static final Ia63 k;
    private static final Logger logger;
    public static final int q = 11;
    public int[] b;
    public int[] l;
    public int m;
    public float n = 1.0f;
    public byte[] p;
    public short[] r;
    public int s;
    public int t;
    public int u;
    public short[] v;
    public int[] w;
    public byte[] x;
    public byte[] y;
    public Fp460[] z;

    public Fk353(byte[] arrby) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        Gg3 gg3 = new Gg3(arrby);
        Gg3 gg32 = new Gg3(arrby);
        Gg3 gg33 = new Gg3(arrby);
        Gg3 gg34 = new Gg3(arrby);
        Gg3 gg35 = new Gg3(arrby);
        Gg3 gg36 = new Gg3(arrby);
        Gg3 gg37 = new Gg3(arrby);
        Gg3 gg38 = new Gg3(arrby);
        Gg3 gg39 = new Gg3(arrby);
        int n10 = Gg3.ar(gg3);
        if (n10 > 6) {
            throw new RuntimeException();
        }
        this.s = Gg3.au(gg3);
        this.u = Gg3.au(gg3);
        Gg3.au(gg3);
        int n11 = Gg3.ay(gg3);
        int n12 = Gg3.ay(gg3);
        this.t = Gg3.ay(gg3);
        int n13 = Gg3.ay(gg3);
        int n14 = Gg3.ay(gg3);
        int n15 = Gg3.ay(gg3);
        int n16 = Gg3.ay(gg3);
        int n17 = Gg3.ay(gg3);
        int n18 = Gg3.ay(gg3);
        int n19 = Gg3.ay(gg3);
        int n20 = Gg3.ay(gg3);
        if (n10 >= 6) {
            this.n = Gg3.bl(gg3);
        }
        gg32.v = gg3.v + this.u * (n10 >= 4 ? 6 : 4);
        gg33.v = gg32.v + n11;
        gg34.v = gg33.v + n11 * 2;
        gg35.v = gg34.v + n11;
        gg36.v = gg35.v + n11;
        this.z = new Fp460[this.u];
        for (n2 = 0; n2 < this.u; ++n2) {
            n7 = Gg3.au(gg3);
            Fp460 fp460 = this.z[n2] = new Fp460(n7);
            short[] arrs = fp460.e;
            short[] arrs2 = fp460.h;
            short[] arrs3 = fp460.s;
            fp460.b = Gg3.au(gg3);
            if (fp460.b == 65535) {
                fp460.b = -1;
            }
            if (n10 >= 4) {
                fp460.l = Gg3.au(gg3);
                if (fp460.l == 65535) {
                    fp460.l = -1;
                }
            }
            n = 0;
            n5 = 0;
            n3 = 0;
            n8 = 0;
            for (n4 = 0; n4 < fp460.g; ++n4) {
                int n21;
                int n22;
                n9 = Gg3.ar(gg35);
                if (n9 == 1) {
                    n21 = n10 >= 5 ? Gg3.bg(gg36) : Gg3.by(gg36);
                    n22 = n10 >= 5 ? Gg3.bg(gg36) : Gg3.by(gg36);
                    int n23 = n10 >= 5 ? Gg3.bg(gg36) : Gg3.by(gg36);
                    n8 = n = (int)((short)(n21 + n8));
                    n8 = n5 = (int)((short)(n22 + n8));
                    n8 = n3 = (int)((short)(n23 + n8));
                    arrs[n4] = n;
                    arrs2[n4] = n5;
                    arrs3[n4] = n3;
                }
                if (n9 == 2) {
                    n21 = n10 >= 5 ? Gg3.bg(gg36) : Gg3.by(gg36);
                    n5 = n3;
                    n3 = n21 + n8;
                    n8 = n3;
                    arrs[n4] = n;
                    arrs2[n4] = n5;
                    arrs3[n4] = n3;
                }
                if (n9 == 3) {
                    n21 = n10 >= 5 ? Gg3.bg(gg36) : Gg3.by(gg36);
                    n = n3;
                    n3 = (short)(n21 + n8);
                    n8 = n3;
                    arrs[n4] = n;
                    arrs2[n4] = n5;
                    arrs3[n4] = n3;
                }
                if (n9 == 4) {
                    n21 = n10 >= 5 ? Gg3.bg(gg36) : Gg3.by(gg36);
                    n22 = n;
                    n = n5;
                    n5 = n22;
                    n8 = n3 = (int)((short)(n21 + n8));
                    arrs[n4] = n;
                    arrs2[n4] = n5;
                    arrs3[n4] = n3;
                }
                fp460.j[n4] = Gg3.ax(gg32);
                fp460.d[n4] = n10 > 1 ? (int)Gg3.au(gg33) : 127;
                fp460.q[n4] = n10 > 1 ? (int)Gg3.ax(gg34) : -1;
                this.m += 3;
            }
        }
        gg3.v = gg36.v;
        gg32.v = gg3.v + this.s;
        gg34.v = gg32.v + n13;
        gg35.v = gg34.v + n14;
        gg36.v = gg35.v + n15;
        gg37.v = gg36.v + n16;
        this.r = new short[this.s];
        this.v = new short[this.s];
        this.b = new int[this.s];
        this.l = new int[this.s];
        this.w = new int[this.s];
        n2 = 0;
        n7 = 0;
        int n24 = 0;
        int n25 = 0;
        int n26 = 0;
        if (n10 > 1) {
            for (n6 = 0; n6 < this.s; ++n6) {
                n = Gg3.ar(gg3);
                n5 = 0;
                if ((n & 1) != 0) {
                    n5 = Gg3.bg(gg32);
                }
                n3 = 0;
                if ((n & 2) != 0) {
                    n3 = Gg3.bg(gg34);
                }
                n8 = 0;
                if ((n & 4) != 0) {
                    n8 = Gg3.bg(gg35);
                }
                n4 = 0;
                if ((n & 8) != 0) {
                    n4 = Gg3.bg(gg36);
                }
                n9 = 0;
                if ((n & 0x10) != 0) {
                    n9 = Gg3.bg(gg37);
                }
                this.r[n6] = (short)(n25 + n4);
                n25 = this.r[n6];
                this.v[n6] = (short)(n26 + n9);
                n26 = this.v[n6];
                this.b[n6] = n2 + n5;
                n2 = this.b[n6];
                this.l[n6] = n7 + n3;
                n7 = this.l[n6];
                this.w[n6] = n24 + n8;
                n24 = this.w[n6];
            }
        } else {
            for (n6 = 0; n6 < this.s; ++n6) {
                n = Gg3.ar(gg3);
                n5 = 0;
                if ((n & 1) != 0) {
                    n5 = Gg3.by(gg32);
                }
                n3 = 0;
                if ((n & 2) != 0) {
                    n3 = Gg3.by(gg34);
                }
                n8 = 0;
                if ((n & 4) != 0) {
                    n8 = Gg3.by(gg35);
                }
                n4 = 0;
                if ((n & 8) != 0) {
                    n4 = Gg3.by(gg36);
                }
                n9 = 0;
                if ((n & 0x10) != 0) {
                    n9 = Gg3.by(gg37);
                }
                this.r[n6] = (short)(n25 + n4);
                n25 = this.r[n6];
                this.v[n6] = (short)(n26 + n9);
                n26 = this.v[n6];
                this.b[n6] = n2 + n5;
                n2 = this.b[n6];
                this.l[n6] = n7 + n3;
                n7 = this.l[n6];
                this.w[n6] = n24 + n8;
                n24 = this.w[n6];
            }
        }
        if (n12 > 0) {
            this.p = new byte[n12];
            this.x = new byte[n12];
            this.y = new byte[this.s];
            gg3.v = gg37.v;
            gg32.v = gg3.v + this.s;
            gg33.v = gg32.v + n17;
            gg34.v = gg33.v + n18;
            gg35.v = gg34.v + n19;
            gg36.v = gg35.v + n20;
            gg37.v = gg36.v + n17;
            gg38.v = gg37.v + n18;
            gg39.v = gg38.v + n19;
            n6 = 0;
            for (n = 0; n < this.s; ++n) {
                this.y[n] = Gg3.ax(gg3);
                n5 = this.y[n];
                if (n5 > 0) {
                    this.p[n6] = Gg3.ax(gg32);
                    this.x[n6] = Gg3.ax(gg36);
                    ++n6;
                }
                if (n5 > 1) {
                    this.p[n6] = Gg3.ax(gg33);
                    this.x[n6] = Gg3.ax(gg37);
                    ++n6;
                }
                if (n5 > 2) {
                    this.p[n6] = Gg3.ax(gg34);
                    this.x[n6] = Gg3.ax(gg38);
                    ++n6;
                }
                if (n5 <= 3) continue;
                this.p[n6] = Gg3.ax(gg35);
                this.x[n6] = Gg3.ax(gg39);
                ++n6;
            }
        }
    }

    @Override
    public void onAllRefsReleased() {
    }

    static {
        logger = LoggerFactory.getLogger(Fk353.class);
        k = new Fu461();
    }

    public Fk353() {
    }
}

