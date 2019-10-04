// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public final class Gw492
{
    static final int b = 4096;
    static final int d = 1;
    static final int e = 14;
    private static final boolean g = true;
    static final int h = 0;
    static final int j = 10;
    static final int l = 16;
    static final int p = 6;
    static final int q = 2;
    static final int r = 23;
    static final int s = 4;
    private static Ge473 t;
    static final int u = 4;
    static final int v = 0;
    static final int w = 258;
    static final int x = 50;
    static final int y = 1;
    static final int z = 18002;
    
    static {
        Gw492.t = new Ge473();
    }
    
    public static int g(final byte[] u, int t, final byte[] r, final int y, final int v) {
        synchronized (Gw492.t) {
            Gw492.t.r = r;
            Gw492.t.v = v;
            Gw492.t.u = u;
            Gw492.t.z = 0;
            Gw492.t.y = y;
            Gw492.t.t = t;
            Gw492.t.f = 0;
            Gw492.t.a = 0;
            Gw492.t.p = 0;
            Gw492.t.x = 0;
            Gw492.t.m = 0;
            Gw492.t.n = 0;
            Gw492.t.ag = 0;
            q(Gw492.t);
            t -= Gw492.t.t;
            Gw492.t.r = null;
            Gw492.t.u = null;
            return t;
        }
    }
    
    private static byte j(final Ge473 ge473) {
        return (byte)h(8, ge473);
    }
    
    private static byte e(final Ge473 ge473) {
        return (byte)h(1, ge473);
    }
    
    private static int h(final int n, final Ge473 ge473) {
        while (ge473.f < n) {
            ge473.a = (ge473.a << 8 | (ge473.r[ge473.v] & 0xFF));
            ge473.f += 8;
            ++ge473.v;
            --ge473.y;
            ++ge473.p;
            if (ge473.p == 0) {
                ++ge473.x;
            }
        }
        final int n2 = ge473.a >> ge473.f - n & (1 << n) - 1;
        ge473.f -= n;
        return n2;
    }
    
    private static void q(final Ge473 ge473) {
        int n = 0;
        int[] array = null;
        int[] array2 = null;
        int[] array3 = null;
        ge473.c = 1;
        if (Ge473.ap == null) {
            Ge473.ap = new int[ge473.c * 100000];
        }
        int i = 1;
        while (i != 0) {
            if (j(ge473) == 23) {
                return;
            }
            j(ge473);
            j(ge473);
            j(ge473);
            j(ge473);
            j(ge473);
            ++ge473.ag;
            j(ge473);
            j(ge473);
            j(ge473);
            j(ge473);
            if (e(ge473) != 0) {
                ge473.o = true;
            }
            else {
                ge473.o = false;
            }
            if (ge473.o) {
                System.out.println("PANIC! RANDOMISED BLOCK!");
            }
            ge473.aq = 0;
            ge473.aq = (ge473.aq << 8 | (j(ge473) & 0xFF));
            ge473.aq = (ge473.aq << 8 | (j(ge473) & 0xFF));
            ge473.aq = (ge473.aq << 8 | (j(ge473) & 0xFF));
            for (int j = 0; j < 16; ++j) {
                if (e(ge473) == 1) {
                    ge473.an[j] = true;
                }
                else {
                    ge473.an[j] = false;
                }
            }
            for (int k = 0; k < 256; ++k) {
                ge473.aa[k] = false;
            }
            for (int l = 0; l < 16; ++l) {
                if (ge473.an[l]) {
                    for (int n2 = 0; n2 < 16; ++n2) {
                        if (e(ge473) == 1) {
                            ge473.aa[l * 16 + n2] = true;
                        }
                    }
                }
            }
            s(ge473);
            final int n3 = ge473.ao + 2;
            final int h = h(3, ge473);
            final int h2 = h(15, ge473);
            for (int n4 = 0; n4 < h2; ++n4) {
                int n5 = 0;
                while (e(ge473) != 0) {
                    ++n5;
                }
                ge473.ab[n4] = (byte)n5;
            }
            final byte[] array4 = new byte[6];
            for (byte b = 0; b < h; ++b) {
                array4[b] = b;
            }
            for (int n6 = 0; n6 < h2; ++n6) {
                byte b2 = ge473.ab[n6];
                final byte b3 = array4[b2];
                while (b2 > 0) {
                    array4[b2] = array4[b2 - 1];
                    --b2;
                }
                array4[0] = b3;
                ge473.at[n6] = b3;
            }
            for (byte b4 = 0; b4 < h; ++b4) {
                int h3 = h(5, ge473);
                for (int n7 = 0; n7 < n3; ++n7) {
                    while (e(ge473) != 0) {
                        if (e(ge473) == 0) {
                            ++h3;
                        }
                        else {
                            --h3;
                        }
                    }
                    ge473.aw[b4][n7] = (byte)h3;
                }
            }
            for (byte b5 = 0; b5 < h; ++b5) {
                byte b6 = 32;
                byte b7 = 0;
                for (int n8 = 0; n8 < n3; ++n8) {
                    if (ge473.aw[b5][n8] > b7) {
                        b7 = ge473.aw[b5][n8];
                    }
                    if (ge473.aw[b5][n8] < b6) {
                        b6 = ge473.aw[b5][n8];
                    }
                }
                b(ge473.ar[b5], ge473.ax[b5], ge473.au[b5], ge473.aw[b5], b6, b7, n3);
                ge473.aj[b5] = b6;
            }
            final int n9 = ge473.ao + 1;
            int n10 = -1;
            int n11 = 0;
            for (int n12 = 0; n12 <= 255; ++n12) {
                ge473.af[n12] = 0;
            }
            int n13 = 4095;
            for (int n14 = 15; n14 >= 0; --n14) {
                for (int n15 = 15; n15 >= 0; --n15) {
                    ge473.as[n13] = (byte)(n14 * 16 + n15);
                    --n13;
                }
                ge473.ac[n14] = n13 + 1;
            }
            int ak = 0;
            if (n11 == 0) {
                ++n10;
                n11 = 50;
                final byte b8 = ge473.at[n10];
                n = ge473.aj[b8];
                array = ge473.ar[b8];
                array3 = ge473.au[b8];
                array2 = ge473.ax[b8];
            }
            --n11;
            int n16;
            int h4;
            for (n16 = n, h4 = h(n16, ge473); h4 > array[n16]; ++n16, h4 = (h4 << 1 | e(ge473))) {}
            int n34;
            int h6;
            for (int n17 = array3[h4 - array2[n16]]; n17 != n9; n17 = array3[h6 - array2[n34]]) {
                if (n17 == 0 || n17 == 1) {
                    int n18 = -1;
                    int n19 = 1;
                    do {
                        if (n17 == 0) {
                            n18 += 1 * n19;
                        }
                        else if (n17 == 1) {
                            n18 += 2 * n19;
                        }
                        n19 *= 2;
                        if (n11 == 0) {
                            ++n10;
                            n11 = 50;
                            final byte b9 = ge473.at[n10];
                            n = ge473.aj[b9];
                            array = ge473.ar[b9];
                            array3 = ge473.au[b9];
                            array2 = ge473.ax[b9];
                        }
                        --n11;
                        int n20;
                        int h5;
                        for (n20 = n, h5 = h(n20, ge473); h5 > array[n20]; ++n20, h5 = (h5 << 1 | e(ge473))) {}
                        n17 = array3[h5 - array2[n20]];
                    } while (n17 == 0 || n17 == 1);
                    ++n18;
                    final byte b10 = ge473.am[ge473.as[ge473.ac[0]] & 0xFF];
                    final int[] af = ge473.af;
                    final int n21 = b10 & 0xFF;
                    af[n21] += n18;
                    while (n18 > 0) {
                        Ge473.ap[ak] = (b10 & 0xFF);
                        ++ak;
                        --n18;
                    }
                }
                else {
                    int n22 = n17 - 1;
                    byte b11;
                    if (n22 < 16) {
                        final int n23 = ge473.ac[0];
                        b11 = ge473.as[n23 + n22];
                        while (n22 > 3) {
                            final int n24 = n23 + n22;
                            ge473.as[n24] = ge473.as[n24 - 1];
                            ge473.as[n24 - 1] = ge473.as[n24 - 2];
                            ge473.as[n24 - 2] = ge473.as[n24 - 3];
                            ge473.as[n24 - 3] = ge473.as[n24 - 4];
                            n22 -= 4;
                        }
                        while (n22 > 0) {
                            ge473.as[n23 + n22] = ge473.as[n23 + n22 - 1];
                            --n22;
                        }
                        ge473.as[n23] = b11;
                    }
                    else {
                        int n25 = n22 / 16;
                        int n26 = ge473.ac[n25] + n22 % 16;
                        b11 = ge473.as[n26];
                        while (n26 > ge473.ac[n25]) {
                            ge473.as[n26] = ge473.as[n26 - 1];
                            --n26;
                        }
                        final int[] ac = ge473.ac;
                        final int n27 = n25;
                        ++ac[n27];
                        while (n25 > 0) {
                            final int[] ac2 = ge473.ac;
                            final int n28 = n25;
                            --ac2[n28];
                            ge473.as[ge473.ac[n25]] = ge473.as[ge473.ac[n25 - 1] + 16 - 1];
                            --n25;
                        }
                        final int[] ac3 = ge473.ac;
                        final int n29 = 0;
                        --ac3[n29];
                        ge473.as[ge473.ac[0]] = b11;
                        if (ge473.ac[0] == 0) {
                            int n30 = 4095;
                            for (int n31 = 15; n31 >= 0; --n31) {
                                for (int n32 = 15; n32 >= 0; --n32) {
                                    ge473.as[n30] = ge473.as[ge473.ac[n31] + n32];
                                    --n30;
                                }
                                ge473.ac[n31] = n30 + 1;
                            }
                        }
                    }
                    final int[] af2 = ge473.af;
                    final int n33 = ge473.am[b11 & 0xFF] & 0xFF;
                    ++af2[n33];
                    Ge473.ap[ak] = (ge473.am[b11 & 0xFF] & 0xFF);
                    ++ak;
                    if (n11 == 0) {
                        ++n10;
                        n11 = 50;
                        final byte b12 = ge473.at[n10];
                        n = ge473.aj[b12];
                        array = ge473.ar[b12];
                        array3 = ge473.au[b12];
                        array2 = ge473.ax[b12];
                    }
                    --n11;
                    for (n34 = n, h6 = h(n34, ge473); h6 > array[n34]; ++n34, h6 = (h6 << 1 | e(ge473))) {}
                }
            }
            ge473.i = 0;
            ge473.k = 0;
            ge473.az[0] = 0;
            for (int n35 = 1; n35 <= 256; ++n35) {
                ge473.az[n35] = ge473.af[n35 - 1];
            }
            for (int n36 = 1; n36 <= 256; ++n36) {
                final int[] az = ge473.az;
                final int n37 = n36;
                az[n37] += ge473.az[n36 - 1];
            }
            for (int n38 = 0; n38 < ak; ++n38) {
                final byte b13 = (byte)(Ge473.ap[n38] & 0xFF);
                final int[] ap = Ge473.ap;
                final int n39 = ge473.az[b13 & 0xFF];
                ap[n39] |= n38 << 8;
                final int[] az2 = ge473.az;
                final int n40 = b13 & 0xFF;
                ++az2[n40];
            }
            ge473.ai = Ge473.ap[ge473.aq] >> 8;
            ge473.av = 0;
            ge473.ai = Ge473.ap[ge473.ai];
            ge473.al = (byte)(ge473.ai & 0xFF);
            ge473.ai >>= 8;
            ++ge473.av;
            ge473.ak = ak;
            d(ge473);
            if (ge473.av == ge473.ak + 1 && ge473.i == 0) {
                i = 1;
            }
            else {
                i = 0;
            }
        }
    }
    
    private static void b(final int[] array, final int[] array2, final int[] array3, final byte[] array4, final int n, final int n2, final int n3) {
        int n4 = 0;
        for (int i = n; i <= n2; ++i) {
            for (int j = 0; j < n3; ++j) {
                if (array4[j] == i) {
                    array3[n4] = j;
                    ++n4;
                }
            }
        }
        for (int k = 0; k < 23; ++k) {
            array2[k] = 0;
        }
        for (int l = 0; l < n3; ++l) {
            final int n5 = array4[l] + 1;
            ++array2[n5];
        }
        for (int n6 = 1; n6 < 23; ++n6) {
            final int n7 = n6;
            array2[n7] += array2[n6 - 1];
        }
        for (int n8 = 0; n8 < 23; ++n8) {
            array[n8] = 0;
        }
        int n9 = 0;
        for (int n10 = n; n10 <= n2; ++n10) {
            final int n11 = n9 + (array2[n10 + 1] - array2[n10]);
            array[n10] = n11 - 1;
            n9 = n11 << 1;
        }
        for (int n12 = n + 1; n12 <= n2; ++n12) {
            array2[n12] = (array[n12 - 1] + 1 << 1) - array2[n12];
        }
    }
    
    private static void s(final Ge473 ge473) {
        ge473.ao = 0;
        for (int i = 0; i < 256; ++i) {
            if (ge473.aa[i]) {
                ge473.am[ge473.ao] = (byte)i;
                ++ge473.ao;
            }
        }
    }
    
    private static void d(final Ge473 ge473) {
        byte k = ge473.k;
        int i = ge473.i;
        int j = ge473.av;
        int al = ge473.al;
        final int[] ap = Ge473.ap;
        int ai = ge473.ai;
        final byte[] u = ge473.u;
        int z = ge473.z;
        final int t;
        int l = t = ge473.t;
        final int n = ge473.ak + 1;
    Label_0370:
        while (true) {
            Label_0123: {
                if (i > 0) {
                    while (l != 0) {
                        if (i == 1) {
                            if (l == 0) {
                                i = 1;
                                break;
                            }
                            u[z] = k;
                            ++z;
                            --l;
                            break Label_0123;
                        }
                        else {
                            u[z] = k;
                            --i;
                            ++z;
                            --l;
                        }
                    }
                    break;
                }
            }
            while (j != n) {
                k = (byte)al;
                final int n2 = ap[ai];
                final byte b = (byte)n2;
                ai = n2 >> 8;
                ++j;
                if (b != al) {
                    al = b;
                    if (l == 0) {
                        i = 1;
                        break Label_0370;
                    }
                    u[z] = k;
                    ++z;
                    --l;
                }
                else if (j == n) {
                    if (l == 0) {
                        i = 1;
                        break Label_0370;
                    }
                    u[z] = k;
                    ++z;
                    --l;
                }
                else {
                    i = 2;
                    final int n3 = ap[ai];
                    final byte b2 = (byte)n3;
                    ai = n3 >> 8;
                    if (++j == n) {
                        continue Label_0370;
                    }
                    if (b2 != al) {
                        al = b2;
                        continue Label_0370;
                    }
                    i = 3;
                    final int n4 = ap[ai];
                    final byte b3 = (byte)n4;
                    ai = n4 >> 8;
                    if (++j == n) {
                        continue Label_0370;
                    }
                    if (b3 != al) {
                        al = b3;
                        continue Label_0370;
                    }
                    final int n5 = ap[ai];
                    final byte b4 = (byte)n5;
                    final int n6 = n5 >> 8;
                    ++j;
                    i = (b4 & 0xFF) + 4;
                    final int n7 = ap[n6];
                    al = (byte)n7;
                    ai = n7 >> 8;
                    ++j;
                    continue Label_0370;
                }
            }
            i = 0;
            break;
        }
        final int m = ge473.m;
        ge473.m += t - l;
        if (ge473.m < m) {
            ++ge473.n;
        }
        ge473.k = k;
        ge473.i = i;
        ge473.av = j;
        ge473.al = al;
        Ge473.ap = ap;
        ge473.ai = ai;
        ge473.u = u;
        ge473.z = z;
        ge473.t = l;
    }
    
    private Gw492() {
    }
}
