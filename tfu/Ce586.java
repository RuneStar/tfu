// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Arrays;

public class Ce586 extends Cx556
{
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
    private Cc648[] ax;
    private Cx556 ay;
    
    private static int m(int n, final int[] array, int n2, int length) {
        if (length > array.length) {
            length = array.length;
        }
        for (int i = 0; i < length; ++i) {
            int n3 = array[n2];
            if (n3 > 0) {
                n3 = -n3;
            }
            if (n3 < n) {
                n = n3;
            }
            if (++n2 == array.length) {
                n2 = 0;
            }
        }
        return n;
    }
    
    private void h() {
        if (Cd585.s) {
            if (this.au == null) {
                for (int i = 0; i < 8; ++i) {
                    Cc648.g(this.ax[i]);
                }
                for (int j = 0; j < 4; ++j) {
                    Cu637.g(this.aj[j]);
                }
                (this.au = new Cc648[8])[0] = new Cc648(1139 * Cd585.h / 44100);
                this.au[1] = new Cc648(1211 * Cd585.h / 44100);
                this.au[2] = new Cc648(1300 * Cd585.h / 44100);
                this.au[3] = new Cc648(1379 * Cd585.h / 44100);
                this.au[4] = new Cc648(1445 * Cd585.h / 44100);
                this.au[5] = new Cc648(1514 * Cd585.h / 44100);
                this.au[6] = new Cc648(1580 * Cd585.h / 44100);
                this.au[7] = new Cc648(1640 * Cd585.h / 44100);
                (this.ak = new Cu637[4])[0] = new Cu637(579 * Cd585.h / 44100);
                this.ak[1] = new Cu637(464 * Cd585.h / 44100);
                this.ak[2] = new Cu637(364 * Cd585.h / 44100);
                this.ak[3] = new Cu637(248 * Cd585.h / 44100);
                this.ad = new int[512];
            }
        }
        else if (this.au != null) {
            for (int k = 0; k < 8; ++k) {
                Cc648.g(this.ax[k]);
            }
            for (int l = 0; l < 4; ++l) {
                Cu637.g(this.aj[l]);
            }
            this.au = null;
            this.ak = null;
            this.ad = new int[256];
        }
    }
    
    @Override
    public synchronized void j(final int[] array, int i, int n) {
        this.h();
        n += i;
        while (i < n) {
            int toIndex = n - i;
            if (toIndex > 256) {
                toIndex = 256;
            }
            if (this.ay != null) {
                this.ay.j(this.ad, 0, toIndex);
            }
            int j = 0;
            for (int k = 0; k < 8; ++k) {
                j = m(j, this.ax[k].d, this.ax[k].q, toIndex);
            }
            for (int l = 0; l < 4; ++l) {
                j = m(j, this.aj[l].g, this.aj[l].d, toIndex);
            }
            if (Cd585.s) {
                for (int n2 = 0; n2 < 8; ++n2) {
                    j = m(j, this.au[n2].d, this.au[n2].q, toIndex);
                }
                for (int n3 = 0; n3 < 4; ++n3) {
                    j = m(j, this.ak[n3].g, this.ak[n3].d, toIndex);
                }
                toIndex <<= 1;
                i <<= 1;
            }
            for (int n4 = 0; n4 < toIndex; ++n4) {
                int n5 = this.ad[n4];
                if (n5 > 0) {
                    n5 = -n5;
                }
                if (n5 < j) {
                    j = n5;
                }
            }
            int n6 = 0;
            while (j <= -4096) {
                ++n6;
                j >>= 1;
            }
            final int n7 = (int)(this.an * 4096.0f);
            final int n8 = (int)(this.as * 4096.0f);
            final int n9 = (int)(this.aw * 4096.0f);
            final int n10 = (int)(this.aa * 65536.0f);
            if (Cd585.s) {
                final int n11 = (int)(this.at * 4096.0f);
                final int n12 = (int)(this.ab * 4096.0f);
                int n13 = 0;
                while (n13 < toIndex) {
                    final int n14 = this.ad[n13++] >> n6;
                    final int n15 = this.ad[n13++] >> n6;
                    final int n16 = (n14 + n15) * n10 >> 17;
                    int n17 = 0;
                    for (int n18 = 0; n18 < 8; ++n18) {
                        final Cc648 cc648 = this.ax[n18];
                        final int n19 = cc648.d[cc648.q] >> n6;
                        final int n20 = cc648.g >> n6;
                        final int n21 = n20 + ((n19 - n20) * n8 + 2048 >> 12);
                        cc648.g = n21 << n6;
                        cc648.d[cc648.q] = n16 + (n21 * n7 + 2048 >> 12) << n6;
                        if (++cc648.q >= cc648.d.length) {
                            cc648.q = 0;
                        }
                        n17 += n19;
                    }
                    for (int n22 = 0; n22 < 4; ++n22) {
                        final Cu637 cu637 = this.aj[n22];
                        final int n23 = cu637.g[cu637.d] >> n6;
                        n17 = n23 - n17;
                        cu637.g[cu637.d] = n16 + (n23 * 2048 + 2048 >> 12) << n6;
                        if (++cu637.d >= cu637.g.length) {
                            cu637.d = 0;
                        }
                    }
                    int n24 = 0;
                    for (int n25 = 0; n25 < 8; ++n25) {
                        final Cc648 cc649 = this.au[n25];
                        final int n26 = cc649.d[cc649.q] >> n6;
                        final int n27 = cc649.g >> n6;
                        final int n28 = n27 + ((n26 - n27) * n8 + 2048 >> 12);
                        cc649.g = n28 << n6;
                        cc649.d[cc649.q] = n16 + (n28 * n7 + 2048 >> 12) << n6;
                        if (++cc649.q >= cc649.d.length) {
                            cc649.q = 0;
                        }
                        n24 += n26;
                    }
                    for (int n29 = 0; n29 < 4; ++n29) {
                        final Cu637 cu638 = this.ak[n29];
                        final int n30 = cu638.g[cu638.d] >> n6;
                        n24 = n30 - n24;
                        cu638.g[cu638.d] = n16 + (n30 * 2048 + 2048 >> 12) << n6;
                        if (++cu638.d >= cu638.g.length) {
                            cu638.d = 0;
                        }
                    }
                    if (n6 > 12) {
                        final int n31 = i++;
                        array[n31] += n17 * n11 + n24 * n12 + n14 * n9 << n6 - 12;
                        final int n32 = i++;
                        array[n32] += n24 * n11 + n17 * n12 + n15 * n9 << n6 - 12;
                    }
                    else {
                        final int n33 = i++;
                        array[n33] += n17 * n11 + n24 * n12 + n14 * n9 >> 12 - n6;
                        final int n34 = i++;
                        array[n34] += n24 * n11 + n17 * n12 + n15 * n9 >> 12 - n6;
                    }
                }
                i >>= 1;
            }
            else {
                final int n35 = (int)(this.ac * 4096.0f);
                for (int n36 = 0; n36 < toIndex; ++n36) {
                    final int n37 = this.ad[n36] >> n6;
                    final int n38 = n37 * n10 >> 16;
                    int n39 = 0;
                    for (int n40 = 0; n40 < 8; ++n40) {
                        final Cc648 cc650 = this.ax[n40];
                        final int n41 = cc650.d[cc650.q] >> n6;
                        final int n42 = cc650.g >> n6;
                        final int n43 = n42 + ((n41 - n42) * n8 + 2048 >> 12);
                        cc650.g = n43 << n6;
                        cc650.d[cc650.q] = n38 + (n43 * n7 + 2048 >> 12) << n6;
                        if (++cc650.q >= cc650.d.length) {
                            cc650.q = 0;
                        }
                        n39 += n41;
                    }
                    for (int n44 = 0; n44 < 4; ++n44) {
                        final Cu637 cu639 = this.aj[n44];
                        final int n45 = cu639.g[cu639.d] >> n6;
                        n39 = n45 - n39;
                        cu639.g[cu639.d] = n38 + (n45 * 2048 + 2048 >> 12) << n6;
                        if (++cu639.d >= cu639.g.length) {
                            cu639.d = 0;
                        }
                    }
                    if (n6 > 12) {
                        final int n46 = i++;
                        array[n46] += n39 * n35 + n37 * n9 << n6 - 12;
                    }
                    else {
                        final int n47 = i++;
                        array[n47] += n39 * n35 + n37 * n9 >> 12 - n6;
                    }
                }
            }
            if (this.ay != null) {
                Arrays.fill(this.ad, 0, toIndex, 0);
            }
        }
    }
    
    public static synchronized void r(final Ce586 ce586, final float an) {
        ce586.an = an;
    }
    
    public static synchronized void v(final Ce586 ce586, final float am) {
        ce586.am = am;
        ce586.as = 1.0f - (float)Math.pow(0.5, 1000000.0 / (ce586.am * Cd585.h));
    }
    
    public static synchronized void z(final Ce586 ce586, final float aw) {
        ce586.aw = aw;
    }
    
    public synchronized void t(final float ar) {
        if (this.ar < -1.0f || this.ar > 1.0f) {
            throw new IllegalArgumentException("Width must be between -1 and 1");
        }
        this.ar = ar;
        this.at = (float)(this.ac * Math.sqrt((1.0f + this.ar) * 0.5));
        this.ab = (float)(this.ac * Math.sqrt((1.0f - this.ar) * 0.5));
    }
    
    @Override
    protected Cx556 g() {
        return this.ay;
    }
    
    public Ce586(final Cx556 ay) {
        (this.ax = new Cc648[8])[0] = new Cc648(1116 * Cd585.h / 44100);
        this.ax[1] = new Cc648(1188 * Cd585.h / 44100);
        this.ax[2] = new Cc648(1277 * Cd585.h / 44100);
        this.ax[3] = new Cc648(1356 * Cd585.h / 44100);
        this.ax[4] = new Cc648(1422 * Cd585.h / 44100);
        this.ax[5] = new Cc648(1491 * Cd585.h / 44100);
        this.ax[6] = new Cc648(1557 * Cd585.h / 44100);
        this.ax[7] = new Cc648(1617 * Cd585.h / 44100);
        (this.aj = new Cu637[4])[0] = new Cu637(556 * Cd585.h / 44100);
        this.aj[1] = new Cu637(441 * Cd585.h / 44100);
        this.aj[2] = new Cu637(341 * Cd585.h / 44100);
        this.aj[3] = new Cu637(225 * Cd585.h / 44100);
        if (!Cd585.s) {
            this.ad = new int[256];
        }
        this.h();
        s(this, 0.045f);
        u(this, 1.0f);
        r(this, 0.84f);
        z(this, 1.0f);
        v(this, 7000.0f);
        this.t(1.0f);
        this.ay = ay;
    }
    
    public static synchronized void u(final Ce586 ce586, final float ac) {
        ce586.ac = ac;
        ce586.at = (float)(ce586.ac * Math.sqrt((1.0f + ce586.ar) * 0.5));
        ce586.ab = (float)(ce586.ac * Math.sqrt((1.0f - ce586.ar) * 0.5));
    }
    
    @Override
    public synchronized void e(final int n) {
        if (this.ay != null) {
            this.ay.e(n);
        }
    }
    
    public static synchronized void s(final Ce586 ce586, final float aa) {
        ce586.aa = aa;
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
