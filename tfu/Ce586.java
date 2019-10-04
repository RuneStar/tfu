/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Arrays;
import tfu.Cc648;
import tfu.Cd585;
import tfu.Cu637;
import tfu.Cx556;

public class Ce586
extends Cx556 {
    private static final int a = 1514;
    private static final int af = 441;
    private static final int ag = 1617;
    private static final int ah = 364;
    private static final int ai = 556;
    private static final int al = 579;
    private static final int ao = 248;
    private static final int ap = 225;
    private static final int aq = 1640;
    private static final int av = 464;
    private static final int az = 341;
    public static final float b = 1.0f;
    private static final int c = 1580;
    private static final int d = 8;
    public static final float e = 0.84f;
    private static final int f = 1557;
    private static final boolean g = true;
    public static final float h = 7000.0f;
    private static final int i = 1445;
    public static final float j = 0.045f;
    private static final int k = 1422;
    public static final float l = 1.0f;
    private static final int m = 1356;
    private static final int n = 1379;
    private static final int o = 1491;
    private static final int p = 1139;
    private static final int q = 4;
    private static final int r = 23;
    public static final float s = 1.0f;
    private static final int t = 1300;
    private static final int u = 1211;
    private static final float v = 0.5f;
    private static final int x = 1188;
    private static final int y = 1116;
    private static final int z = 1277;
    private float aa;
    private float ab;
    private float ac;
    private int[] ad;
    private Cu637[] aj;
    private Cu637[] ak;
    private float am;
    private float an;
    private float ar;
    private float as;
    private float at;
    private Cc648[] au;
    private float aw;
    private Cc648[] ax = new Cc648[8];
    private Cx556 ay;

    private static int m(int n, int[] arrn, int n2, int n3) {
        if (n3 > arrn.length) {
            n3 = arrn.length;
        }
        for (int i = 0; i < n3; ++i) {
            int n4 = arrn[n2];
            if (n4 > 0) {
                n4 = -n4;
            }
            if (n4 < n) {
                n = n4;
            }
            if (++n2 != arrn.length) continue;
            n2 = 0;
        }
        return n;
    }

    private void h() {
        if (Cd585.s) {
            if (this.au == null) {
                int n;
                for (n = 0; n < 8; ++n) {
                    Cc648.g(this.ax[n]);
                }
                for (n = 0; n < 4; ++n) {
                    Cu637.g(this.aj[n]);
                }
                this.au = new Cc648[8];
                this.au[0] = new Cc648(1139 * Cd585.h / 44100);
                this.au[1] = new Cc648(1211 * Cd585.h / 44100);
                this.au[2] = new Cc648(1300 * Cd585.h / 44100);
                this.au[3] = new Cc648(1379 * Cd585.h / 44100);
                this.au[4] = new Cc648(1445 * Cd585.h / 44100);
                this.au[5] = new Cc648(1514 * Cd585.h / 44100);
                this.au[6] = new Cc648(1580 * Cd585.h / 44100);
                this.au[7] = new Cc648(1640 * Cd585.h / 44100);
                this.ak = new Cu637[4];
                this.ak[0] = new Cu637(579 * Cd585.h / 44100);
                this.ak[1] = new Cu637(464 * Cd585.h / 44100);
                this.ak[2] = new Cu637(364 * Cd585.h / 44100);
                this.ak[3] = new Cu637(248 * Cd585.h / 44100);
                this.ad = new int[512];
            }
        } else if (this.au != null) {
            int n;
            for (n = 0; n < 8; ++n) {
                Cc648.g(this.ax[n]);
            }
            for (n = 0; n < 4; ++n) {
                Cu637.g(this.aj[n]);
            }
            this.au = null;
            this.ak = null;
            this.ad = new int[256];
        }
    }

    @Override
    public synchronized void j(int[] arrn, int n, int n2) {
        this.h();
        n2 += n;
        while (n < n2) {
            int n10;
            int n11;
            int n8;
            Object object;
            int n3;
            int n9;
            int n4;
            int n5;
            int n32;
            int n6;
            int n12 = n2 - n;
            if (n12 > 256) {
                n12 = 256;
            }
            if (this.ay != null) {
                this.ay.j(this.ad, 0, n12);
            }
            int n13 = 0;
            for (n9 = 0; n9 < 8; ++n9) {
                n13 = Ce586.m(n13, this.ax[n9].d, this.ax[n9].q, n12);
            }
            for (n9 = 0; n9 < 4; ++n9) {
                n13 = Ce586.m(n13, this.aj[n9].g, this.aj[n9].d, n12);
            }
            if (Cd585.s) {
                for (n9 = 0; n9 < 8; ++n9) {
                    n13 = Ce586.m(n13, this.au[n9].d, this.au[n9].q, n12);
                }
                for (n9 = 0; n9 < 4; ++n9) {
                    n13 = Ce586.m(n13, this.ak[n9].g, this.ak[n9].d, n12);
                }
                n12 <<= 1;
                n <<= 1;
            }
            for (n9 = 0; n9 < n12; ++n9) {
                n11 = this.ad[n9];
                if (n11 > 0) {
                    n11 = -n11;
                }
                if (n11 >= n13) continue;
                n13 = n11;
            }
            n9 = 0;
            while (n13 <= -4096) {
                ++n9;
                n13 >>= 1;
            }
            n11 = (int)(this.an * 4096.0f);
            int n14 = (int)(this.as * 4096.0f);
            int n15 = (int)(this.aw * 4096.0f);
            int n16 = (int)(this.aa * 65536.0f);
            if (Cd585.s) {
                n32 = (int)(this.at * 4096.0f);
                n10 = (int)(this.ab * 4096.0f);
                n5 = 0;
                while (n5 < n12) {
                    int n7;
                    int cu637;
                    n4 = this.ad[n5++] >> n9;
                    n8 = this.ad[n5++] >> n9;
                    n6 = (n4 + n8) * n16 >> 17;
                    int n17 = 0;
                    for (n3 = 0; n3 < 8; ++n3) {
                        object = this.ax[n3];
                        cu637 = object.d[object.q] >> n9;
                        n7 = object.g >> n9;
                        n7 += (cu637 - n7) * n14 + 2048 >> 12;
                        object.g = n7 << n9;
                        object.d[object.q] = n6 + (n7 * n11 + 2048 >> 12) << n9;
                        if (++object.q >= object.d.length) {
                            object.q = 0;
                        }
                        n17 += cu637;
                    }
                    for (n3 = 0; n3 < 4; ++n3) {
                        Cu637 cu6372 = this.aj[n3];
                        cu637 = cu6372.g[cu6372.d] >> n9;
                        n17 = cu637 - n17;
                        cu6372.g[cu6372.d] = n6 + (cu637 * 2048 + 2048 >> 12) << n9;
                        if (++cu6372.d < cu6372.g.length) continue;
                        cu6372.d = 0;
                    }
                    n3 = 0;
                    for (object = 0; object < 8; ++object) {
                        Cc648 cc648 = this.au[object];
                        n7 = cc648.d[cc648.q] >> n9;
                        int n18 = cc648.g >> n9;
                        n18 += (n7 - n18) * n14 + 2048 >> 12;
                        cc648.g = n18 << n9;
                        cc648.d[cc648.q] = n6 + (n18 * n11 + 2048 >> 12) << n9;
                        if (++cc648.q >= cc648.d.length) {
                            cc648.q = 0;
                        }
                        n3 += n7;
                    }
                    for (object = 0; object < 4; ++object) {
                        Cu637 cu6373 = this.ak[object];
                        n7 = cu6373.g[cu6373.d] >> n9;
                        n3 = n7 - n3;
                        cu6373.g[cu6373.d] = n6 + (n7 * 2048 + 2048 >> 12) << n9;
                        if (++cu6373.d < cu6373.g.length) continue;
                        cu6373.d = 0;
                    }
                    if (n9 > 12) {
                        int[] arrn2 = arrn;
                        int n19 = n++;
                        arrn2[n19] = arrn2[n19] + (n17 * n32 + n3 * n10 + n4 * n15 << n9 - 12);
                        int[] arrn3 = arrn;
                        int n20 = n++;
                        arrn3[n20] = arrn3[n20] + (n3 * n32 + n17 * n10 + n8 * n15 << n9 - 12);
                        continue;
                    }
                    int[] arrn4 = arrn;
                    int n21 = n++;
                    arrn4[n21] = arrn4[n21] + (n17 * n32 + n3 * n10 + n4 * n15 >> 12 - n9);
                    int[] arrn5 = arrn;
                    int n22 = n++;
                    arrn5[n22] = arrn5[n22] + (n3 * n32 + n17 * n10 + n8 * n15 >> 12 - n9);
                }
                n >>= 1;
            } else {
                n32 = (int)(this.ac * 4096.0f);
                for (n10 = 0; n10 < n12; ++n10) {
                    n5 = this.ad[n10] >> n9;
                    n4 = n5 * n16 >> 16;
                    n8 = 0;
                    for (n6 = 0; n6 < 8; ++n6) {
                        Cc648 cc648 = this.ax[n6];
                        n3 = cc648.d[cc648.q] >> n9;
                        object = cc648.g >> n9;
                        object += (n3 - object) * n14 + 2048 >> 12;
                        cc648.g = object << n9;
                        cc648.d[cc648.q] = n4 + (object * n11 + 2048 >> 12) << n9;
                        if (++cc648.q >= cc648.d.length) {
                            cc648.q = 0;
                        }
                        n8 += n3;
                    }
                    for (n6 = 0; n6 < 4; ++n6) {
                        Cu637 cu637 = this.aj[n6];
                        n3 = cu637.g[cu637.d] >> n9;
                        n8 = n3 - n8;
                        cu637.g[cu637.d] = n4 + (n3 * 2048 + 2048 >> 12) << n9;
                        if (++cu637.d < cu637.g.length) continue;
                        cu637.d = 0;
                    }
                    if (n9 > 12) {
                        int[] arrn6 = arrn;
                        int n23 = n++;
                        arrn6[n23] = arrn6[n23] + (n8 * n32 + n5 * n15 << n9 - 12);
                        continue;
                    }
                    int[] arrn7 = arrn;
                    int n24 = n++;
                    arrn7[n24] = arrn7[n24] + (n8 * n32 + n5 * n15 >> 12 - n9);
                }
            }
            if (this.ay == null) continue;
            Arrays.fill(this.ad, 0, n12, 0);
        }
    }

    public static synchronized void r(Ce586 ce586, float f) {
        ce586.an = f;
    }

    public static synchronized void v(Ce586 ce586, float f) {
        ce586.am = f;
        ce586.as = 1.0f - (float)Math.pow(0.5, 1000000.0 / (double)(ce586.am * (float)Cd585.h));
    }

    public static synchronized void z(Ce586 ce586, float f) {
        ce586.aw = f;
    }

    public synchronized void t(float f) {
        if (this.ar < -1.0f || this.ar > 1.0f) {
            throw new IllegalArgumentException("Width must be between -1 and 1");
        }
        this.ar = f;
        this.at = (float)((double)this.ac * Math.sqrt((double)(1.0f + this.ar) * 0.5));
        this.ab = (float)((double)this.ac * Math.sqrt((double)(1.0f - this.ar) * 0.5));
    }

    @Override
    protected Cx556 g() {
        return this.ay;
    }

    public Ce586(Cx556 cx556) {
        this.ax[0] = new Cc648(1116 * Cd585.h / 44100);
        this.ax[1] = new Cc648(1188 * Cd585.h / 44100);
        this.ax[2] = new Cc648(1277 * Cd585.h / 44100);
        this.ax[3] = new Cc648(1356 * Cd585.h / 44100);
        this.ax[4] = new Cc648(1422 * Cd585.h / 44100);
        this.ax[5] = new Cc648(1491 * Cd585.h / 44100);
        this.ax[6] = new Cc648(1557 * Cd585.h / 44100);
        this.ax[7] = new Cc648(1617 * Cd585.h / 44100);
        this.aj = new Cu637[4];
        this.aj[0] = new Cu637(556 * Cd585.h / 44100);
        this.aj[1] = new Cu637(441 * Cd585.h / 44100);
        this.aj[2] = new Cu637(341 * Cd585.h / 44100);
        this.aj[3] = new Cu637(225 * Cd585.h / 44100);
        if (!Cd585.s) {
            this.ad = new int[256];
        }
        this.h();
        Ce586.s(this, 0.045f);
        Ce586.u(this, 1.0f);
        Ce586.r(this, 0.84f);
        Ce586.z(this, 1.0f);
        Ce586.v(this, 7000.0f);
        this.t(1.0f);
        this.ay = cx556;
    }

    public static synchronized void u(Ce586 ce586, float f) {
        ce586.ac = f;
        ce586.at = (float)((double)ce586.ac * Math.sqrt((double)(1.0f + ce586.ar) * 0.5));
        ce586.ab = (float)((double)ce586.ac * Math.sqrt((double)(1.0f - ce586.ar) * 0.5));
    }

    @Override
    public synchronized void e(int n) {
        if (this.ay != null) {
            this.ay.e(n);
        }
    }

    public static synchronized void s(Ce586 ce586, float f) {
        ce586.aa = f;
    }

    @Override
    protected int q() {
        return 8;
    }

    @Override
    protected Cx556 d() {
        return null;
    }
}

