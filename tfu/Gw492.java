/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.PrintStream;
import tfu.Ge473;

public final class Gw492 {
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
    private static Ge473 t = new Ge473();
    static final int u = 4;
    static final int v = 0;
    static final int w = 258;
    static final int x = 50;
    static final int y = 1;
    static final int z = 18002;

    public static int g(byte[] arrby, int n, byte[] arrby2, int n2, int n3) {
        Ge473 ge473 = t;
        synchronized (ge473) {
            Gw492.t.r = arrby2;
            Gw492.t.v = n3;
            Gw492.t.u = arrby;
            Gw492.t.z = 0;
            Gw492.t.y = n2;
            Gw492.t.t = n;
            Gw492.t.f = 0;
            Gw492.t.a = 0;
            Gw492.t.p = 0;
            Gw492.t.x = 0;
            Gw492.t.m = 0;
            Gw492.t.n = 0;
            Gw492.t.ag = 0;
            Gw492.q(t);
            Gw492.t.r = null;
            Gw492.t.u = null;
            return n -= Gw492.t.t;
        }
    }

    private static byte j(Ge473 ge473) {
        return (byte)Gw492.h(8, ge473);
    }

    private static byte e(Ge473 ge473) {
        return (byte)Gw492.h(1, ge473);
    }

    private static int h(int n, Ge473 ge473) {
        do {
            if (ge473.f >= n) {
                int n2 = ge473.a >> ge473.f - n & (1 << n) - 1;
                ge473.f -= n;
                return n2;
            }
            ge473.a = ge473.a << 8 | ge473.r[ge473.v] & 0xFF;
            ge473.f += 8;
            ++ge473.v;
            --ge473.y;
            ++ge473.p;
            if (ge473.p != 0) continue;
            ++ge473.x;
        } while (true);
    }

    private static void q(Ge473 ge473) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        byte by = 0;
        byte by2 = 0;
        int n17 = 0;
        int[] arrn = null;
        int[] arrn2 = null;
        int[] arrn3 = null;
        ge473.c = 1;
        if (Ge473.ap == null) {
            Ge473.ap = new int[ge473.c * 100000];
        }
        boolean bl = true;
        while (bl) {
            int n18;
            int n19;
            int n20;
            byte by3 = Gw492.j(ge473);
            if (by3 == 23) {
                return;
            }
            by3 = Gw492.j(ge473);
            by3 = Gw492.j(ge473);
            by3 = Gw492.j(ge473);
            by3 = Gw492.j(ge473);
            by3 = Gw492.j(ge473);
            ++ge473.ag;
            by3 = Gw492.j(ge473);
            by3 = Gw492.j(ge473);
            by3 = Gw492.j(ge473);
            by3 = Gw492.j(ge473);
            by3 = Gw492.e(ge473);
            ge473.o = by3 != 0;
            if (ge473.o) {
                System.out.println("PANIC! RANDOMISED BLOCK!");
            }
            ge473.aq = 0;
            by3 = Gw492.j(ge473);
            ge473.aq = ge473.aq << 8 | by3 & 0xFF;
            by3 = Gw492.j(ge473);
            ge473.aq = ge473.aq << 8 | by3 & 0xFF;
            by3 = Gw492.j(ge473);
            ge473.aq = ge473.aq << 8 | by3 & 0xFF;
            for (n = 0; n < 16; ++n) {
                by3 = Gw492.e(ge473);
                ge473.an[n] = by3 == 1;
            }
            for (n = 0; n < 256; ++n) {
                ge473.aa[n] = false;
            }
            for (n = 0; n < 16; ++n) {
                if (!ge473.an[n]) continue;
                for (n2 = 0; n2 < 16; ++n2) {
                    by3 = Gw492.e(ge473);
                    if (by3 != 1) continue;
                    ge473.aa[n * 16 + n2] = true;
                }
            }
            Gw492.s(ge473);
            n4 = ge473.ao + 2;
            n5 = Gw492.h(3, ge473);
            n6 = Gw492.h(15, ge473);
            for (n = 0; n < n6; ++n) {
                n2 = 0;
                while ((by3 = Gw492.e(ge473)) != 0) {
                    ++n2;
                }
                ge473.ab[n] = (byte)n2;
            }
            byte[] arrby = new byte[6];
            for (n18 = 0; n18 < n5; n18 = (int)((byte)(n18 + 1))) {
                arrby[n18] = n18;
            }
            for (n = 0; n < n6; ++n) {
                n20 = arrby[n18];
                for (n18 = ge473.ab[n]; n18 > 0; n18 = (int)((byte)(n18 - 1))) {
                    arrby[n18] = arrby[n18 - 1];
                }
                arrby[0] = n20;
                ge473.at[n] = n20;
            }
            for (n3 = 0; n3 < n5; ++n3) {
                n14 = Gw492.h(5, ge473);
                for (n = 0; n < n4; ++n) {
                    while ((by3 = Gw492.e(ge473)) != 0) {
                        by3 = Gw492.e(ge473);
                        if (by3 == 0) {
                            ++n14;
                            continue;
                        }
                        --n14;
                    }
                    ge473.aw[n3][n] = (byte)n14;
                }
            }
            for (n3 = 0; n3 < n5; ++n3) {
                int n21 = 32;
                byte by4 = 0;
                for (n = 0; n < n4; ++n) {
                    if (ge473.aw[n3][n] > by4) {
                        by4 = ge473.aw[n3][n];
                    }
                    if (ge473.aw[n3][n] >= n21) continue;
                    n21 = ge473.aw[n3][n];
                }
                Gw492.b(ge473.ar[n3], ge473.ax[n3], ge473.au[n3], ge473.aw[n3], n21, by4, n4);
                ge473.aj[n3] = n21;
            }
            n7 = ge473.ao + 1;
            n8 = -1;
            n9 = 0;
            for (n = 0; n <= 255; ++n) {
                ge473.af[n] = 0;
            }
            n18 = 4095;
            for (n19 = 15; n19 >= 0; --n19) {
                for (n20 = 15; n20 >= 0; --n20) {
                    ge473.as[n18] = (byte)(n19 * 16 + n20);
                    --n18;
                }
                ge473.ac[n19] = n18 + 1;
            }
            n11 = 0;
            if (n9 == 0) {
                n9 = 50;
                by2 = ge473.at[++n8];
                n17 = ge473.aj[by2];
                arrn = ge473.ar[by2];
                arrn3 = ge473.au[by2];
                arrn2 = ge473.ax[by2];
            }
            --n9;
            n15 = n17;
            n16 = Gw492.h(n15, ge473);
            while (n16 > arrn[n15]) {
                ++n15;
                by = Gw492.e(ge473);
                n16 = n16 << 1 | by;
            }
            n10 = arrn3[n16 - arrn2[n15]];
            while (n10 != n7) {
                int n22;
                if (n10 == 0 || n10 == 1) {
                    n12 = -1;
                    n13 = 1;
                    do {
                        if (n10 == 0) {
                            n12 += 1 * n13;
                        } else if (n10 == 1) {
                            n12 += 2 * n13;
                        }
                        n13 *= 2;
                        if (n9 == 0) {
                            n9 = 50;
                            by2 = ge473.at[++n8];
                            n17 = ge473.aj[by2];
                            arrn = ge473.ar[by2];
                            arrn3 = ge473.au[by2];
                            arrn2 = ge473.ax[by2];
                        }
                        --n9;
                        n15 = n17;
                        n16 = Gw492.h(n15, ge473);
                        while (n16 > arrn[n15]) {
                            ++n15;
                            by = Gw492.e(ge473);
                            n16 = n16 << 1 | by;
                        }
                    } while ((n10 = arrn3[n16 - arrn2[n15]]) == 0 || n10 == 1);
                    by3 = ge473.am[ge473.as[ge473.ac[0]] & 0xFF];
                    int[] arrn4 = ge473.af;
                    int n23 = by3 & 0xFF;
                    arrn4[n23] = arrn4[n23] + ++n12;
                    while (n12 > 0) {
                        Ge473.ap[n11] = by3 & 0xFF;
                        ++n11;
                        --n12;
                    }
                    continue;
                }
                int n24 = n10 - 1;
                if (n24 < 16) {
                    n22 = ge473.ac[0];
                    by3 = ge473.as[n22 + n24];
                    while (n24 > 3) {
                        int n25 = n22 + n24;
                        ge473.as[n25] = ge473.as[n25 - 1];
                        ge473.as[n25 - 1] = ge473.as[n25 - 2];
                        ge473.as[n25 - 2] = ge473.as[n25 - 3];
                        ge473.as[n25 - 3] = ge473.as[n25 - 4];
                        n24 -= 4;
                    }
                    while (n24 > 0) {
                        ge473.as[n22 + n24] = ge473.as[n22 + n24 - 1];
                        --n24;
                    }
                    ge473.as[n22] = by3;
                } else {
                    int n26 = n24 / 16;
                    int n27 = n24 % 16;
                    by3 = ge473.as[n22];
                    for (n22 = ge473.ac[n26] + n27; n22 > ge473.ac[n26]; --n22) {
                        ge473.as[n22] = ge473.as[n22 - 1];
                    }
                    int[] arrn5 = ge473.ac;
                    int n28 = n26;
                    arrn5[n28] = arrn5[n28] + 1;
                    while (n26 > 0) {
                        int[] arrn6 = ge473.ac;
                        int n29 = n26;
                        arrn6[n29] = arrn6[n29] - 1;
                        ge473.as[ge473.ac[n26]] = ge473.as[ge473.ac[n26 - 1] + 16 - 1];
                        --n26;
                    }
                    int[] arrn7 = ge473.ac;
                    arrn7[0] = arrn7[0] - 1;
                    ge473.as[ge473.ac[0]] = by3;
                    if (ge473.ac[0] == 0) {
                        n18 = 4095;
                        for (n19 = 15; n19 >= 0; --n19) {
                            for (n20 = 15; n20 >= 0; --n20) {
                                ge473.as[n18] = ge473.as[ge473.ac[n19] + n20];
                                --n18;
                            }
                            ge473.ac[n19] = n18 + 1;
                        }
                    }
                }
                int[] arrn8 = ge473.af;
                int n30 = ge473.am[by3 & 0xFF] & 0xFF;
                arrn8[n30] = arrn8[n30] + 1;
                Ge473.ap[n11] = ge473.am[by3 & 0xFF] & 0xFF;
                ++n11;
                if (n9 == 0) {
                    n9 = 50;
                    by2 = ge473.at[++n8];
                    n17 = ge473.aj[by2];
                    arrn = ge473.ar[by2];
                    arrn3 = ge473.au[by2];
                    arrn2 = ge473.ax[by2];
                }
                --n9;
                n15 = n17;
                n16 = Gw492.h(n15, ge473);
                while (n16 > arrn[n15]) {
                    ++n15;
                    by = Gw492.e(ge473);
                    n16 = n16 << 1 | by;
                }
                n10 = arrn3[n16 - arrn2[n15]];
            }
            ge473.i = 0;
            ge473.k = 0;
            ge473.az[0] = 0;
            for (n = 1; n <= 256; ++n) {
                ge473.az[n] = ge473.af[n - 1];
            }
            for (n = 1; n <= 256; ++n) {
                int[] arrn9 = ge473.az;
                int n31 = n;
                arrn9[n31] = arrn9[n31] + ge473.az[n - 1];
            }
            for (n = 0; n < n11; ++n) {
                by3 = (byte)(Ge473.ap[n] & 0xFF);
                int[] arrn10 = Ge473.ap;
                int n32 = ge473.az[by3 & 0xFF];
                arrn10[n32] = arrn10[n32] | n << 8;
                int[] arrn11 = ge473.az;
                int n33 = by3 & 0xFF;
                arrn11[n33] = arrn11[n33] + 1;
            }
            ge473.ai = Ge473.ap[ge473.aq] >> 8;
            ge473.av = 0;
            ge473.ai = Ge473.ap[ge473.ai];
            ge473.al = (byte)(ge473.ai & 0xFF);
            ge473.ai >>= 8;
            ++ge473.av;
            ge473.ak = n11;
            Gw492.d(ge473);
            if (ge473.av == ge473.ak + 1 && ge473.i == 0) {
                bl = true;
                continue;
            }
            bl = false;
        }
    }

    private static void b(int[] arrn, int[] arrn2, int[] arrn3, byte[] arrby, int n, int n2, int n3) {
        int n4;
        int n5 = 0;
        for (n4 = n; n4 <= n2; ++n4) {
            for (int i = 0; i < n3; ++i) {
                if (arrby[i] != n4) continue;
                arrn3[n5] = i;
                ++n5;
            }
        }
        for (n4 = 0; n4 < 23; ++n4) {
            arrn2[n4] = 0;
        }
        for (n4 = 0; n4 < n3; ++n4) {
            int[] arrn4 = arrn2;
            int n6 = arrby[n4] + 1;
            arrn4[n6] = arrn4[n6] + 1;
        }
        for (n4 = 1; n4 < 23; ++n4) {
            int[] arrn5 = arrn2;
            int n7 = n4;
            arrn5[n7] = arrn5[n7] + arrn2[n4 - 1];
        }
        for (n4 = 0; n4 < 23; ++n4) {
            arrn[n4] = 0;
        }
        int n8 = 0;
        for (n4 = n; n4 <= n2; ++n4) {
            arrn[n4] = (n8 += arrn2[n4 + 1] - arrn2[n4]) - 1;
            n8 <<= 1;
        }
        for (n4 = n + 1; n4 <= n2; ++n4) {
            arrn2[n4] = (arrn[n4 - 1] + 1 << 1) - arrn2[n4];
        }
    }

    private static void s(Ge473 ge473) {
        ge473.ao = 0;
        for (int i = 0; i < 256; ++i) {
            if (!ge473.aa[i]) continue;
            ge473.am[ge473.ao] = (byte)i;
            ++ge473.ao;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static void d(Ge473 var0) {
        var2_1 = var0.k;
        var3_2 = var0.i;
        var4_3 = var0.av;
        var5_4 = var0.al;
        var6_5 = Ge473.ap;
        var7_6 = var0.ai;
        var8_7 = var0.u;
        var9_8 = var0.z;
        var11_10 = var10_9 = var0.t;
        var12_11 = var0.ak + 1;
        block0 : do {
            if (var3_2 <= 0) ** GOTO lbl30
            while (var10_9 != 0) {
                block11 : {
                    block12 : {
                        block10 : {
                            if (var3_2 != 1) break block10;
                            if (var10_9 != 0) break block11;
                            break block12;
                        }
                        var8_7[var9_8] = var2_1;
                        --var3_2;
                        ++var9_8;
                        --var10_9;
                        continue;
                    }
                    var3_2 = 1;
                    break block0;
                }
                var8_7[var9_8] = var2_1;
                ++var9_8;
                --var10_9;
lbl30: // 2 sources:
                do {
                    if (var4_3 == var12_11) {
                        var3_2 = 0;
                        break block0;
                    }
                    var2_1 = (byte)var5_4;
                    var7_6 = var6_5[var7_6];
                    var1_12 = (byte)var7_6;
                    var7_6 >>= 8;
                    ++var4_3;
                    if (var1_12 != var5_4) {
                        var5_4 = var1_12;
                        if (var10_9 == 0) {
                            var3_2 = 1;
                            break block0;
                        }
                        var8_7[var9_8] = var2_1;
                        ++var9_8;
                        --var10_9;
                        continue;
                    }
                    if (var4_3 != var12_11) break;
                    if (var10_9 == 0) {
                        var3_2 = 1;
                        break block0;
                    }
                    var8_7[var9_8] = var2_1;
                    ++var9_8;
                    --var10_9;
                } while (true);
                var3_2 = 2;
                var7_6 = var6_5[var7_6];
                var1_12 = (byte)var7_6;
                var7_6 >>= 8;
                if (++var4_3 == var12_11) continue block0;
                if (var1_12 != var5_4) {
                    var5_4 = var1_12;
                    continue block0;
                }
                var3_2 = 3;
                var7_6 = var6_5[var7_6];
                var1_12 = (byte)var7_6;
                var7_6 >>= 8;
                if (++var4_3 == var12_11) continue block0;
                if (var1_12 != var5_4) {
                    var5_4 = var1_12;
                    continue block0;
                }
                var7_6 = var6_5[var7_6];
                var1_12 = (byte)var7_6;
                var7_6 >>= 8;
                ++var4_3;
                var3_2 = (var1_12 & 255) + 4;
                var7_6 = var6_5[var7_6];
                var5_4 = (byte)var7_6;
                var7_6 >>= 8;
                ++var4_3;
                continue block0;
            }
            break;
        } while (true);
        var13_13 = var0.m;
        var0.m += var11_10 - var10_9;
        if (var0.m < var13_13) {
            ++var0.n;
        }
        var0.k = var2_1;
        var0.i = var3_2;
        var0.av = var4_3;
        var0.al = var5_4;
        Ge473.ap = var6_5;
        var0.ai = var7_6;
        var0.u = var8_7;
        var0.z = var9_8;
        var0.t = var10_9;
    }

    private Gw492() {
    }
}

