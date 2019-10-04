/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import tfu.Gg3;
import tfu.Ha262;
import tfu.Ld263;
import tfu.Ln265;
import tfu.Z693;

public class P689
extends Ln265 {
    private static final boolean g = true;
    public Ha262 d;
    byte[] q;

    public static P689 g(js5 js52, int n, int n2) {
        byte[] arrby = js52.getfile(n, n2);
        if (arrby == null) {
            return null;
        }
        return new P689(new Gg3(arrby));
    }

    public P689(Gg3 gg3) {
        int n;
        int n2;
        int n3;
        int n4;
        gg3.v = gg3.r.length - 3;
        int n5 = Gg3.ar(gg3);
        int n6 = Gg3.au(gg3);
        int n7 = 14 + n5 * 10;
        gg3.v = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        block0 : for (n3 = 0; n3 < n5; ++n3) {
            n = -1;
            do {
                if ((n2 = Gg3.ar(gg3)) != n) {
                    ++n7;
                }
                n = n2 & 0xF;
                if (n2 == 7) continue block0;
                if (n2 == 23) {
                    ++n8;
                    continue;
                }
                if (n == 0) {
                    ++n10;
                    continue;
                }
                if (n == 1) {
                    ++n11;
                    continue;
                }
                if (n == 2) {
                    ++n9;
                    continue;
                }
                if (n == 3) {
                    ++n12;
                    continue;
                }
                if (n == 4) {
                    ++n13;
                    continue;
                }
                if (n == 5) {
                    ++n14;
                    continue;
                }
                if (n != 6) break;
                ++n15;
            } while (true);
            throw new RuntimeException("Unrecognised status " + n2);
        }
        n7 += 5 * n8;
        n7 += 2 * (n10 + n11 + n9 + n12 + n14);
        n7 += n13 + n15;
        n3 = gg3.v;
        n = n5 + n8 + n9 + n10 + n11 + n12 + n13 + n14 + n15;
        for (n2 = 0; n2 < n; ++n2) {
            Gg3.bn(gg3);
        }
        n7 += gg3.v - n3;
        n2 = gg3.v;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        int n19 = 0;
        int n20 = 0;
        int n21 = 0;
        int n22 = 0;
        int n23 = 0;
        int n24 = 0;
        int n25 = 0;
        int n26 = 0;
        int n27 = 0;
        int n28 = 0;
        for (n4 = 0; n4 < n9; ++n4) {
            if ((n28 = n28 + Gg3.ar(gg3) & 0x7F) == 0 || n28 == 32) {
                ++n15;
                continue;
            }
            if (n28 == 1) {
                ++n16;
                continue;
            }
            if (n28 == 33) {
                ++n17;
                continue;
            }
            if (n28 == 7) {
                ++n18;
                continue;
            }
            if (n28 == 39) {
                ++n19;
                continue;
            }
            if (n28 == 10) {
                ++n20;
                continue;
            }
            if (n28 == 42) {
                ++n21;
                continue;
            }
            if (n28 == 99) {
                ++n22;
                continue;
            }
            if (n28 == 98) {
                ++n23;
                continue;
            }
            if (n28 == 101) {
                ++n24;
                continue;
            }
            if (n28 == 100) {
                ++n25;
                continue;
            }
            if (n28 == 64 || n28 == 65 || n28 == 120 || n28 == 121 || n28 == 123) {
                ++n26;
                continue;
            }
            ++n27;
        }
        n4 = 0;
        int n29 = gg3.v;
        gg3.v += n26;
        int n30 = gg3.v;
        gg3.v += n14;
        int n31 = gg3.v;
        gg3.v += n13;
        int n32 = gg3.v;
        gg3.v += n12;
        int n33 = gg3.v;
        gg3.v += n16;
        int n34 = gg3.v;
        gg3.v += n18;
        int n35 = gg3.v;
        gg3.v += n20;
        int n36 = gg3.v;
        gg3.v += n10 + n11 + n14;
        int n37 = gg3.v;
        gg3.v += n10;
        int n38 = gg3.v;
        gg3.v += n27;
        int n39 = gg3.v;
        gg3.v += n11;
        int n40 = gg3.v;
        gg3.v += n17;
        int n41 = gg3.v;
        gg3.v += n19;
        int n42 = gg3.v;
        gg3.v += n21;
        int n43 = gg3.v;
        gg3.v += n15;
        int n44 = gg3.v;
        gg3.v += n12;
        int n45 = gg3.v;
        gg3.v += n22;
        int n46 = gg3.v;
        gg3.v += n23;
        int n47 = gg3.v;
        gg3.v += n24;
        int n48 = gg3.v;
        gg3.v += n25;
        int n49 = gg3.v;
        gg3.v += n8 * 3;
        if (gg3.v != gg3.r.length - 3) {
            throw new RuntimeException("Chunk lengths added up wrong");
        }
        this.q = new byte[n7];
        Gg3 gg32 = new Gg3(this.q);
        Gg3.a(gg32, 1297377380);
        Gg3.a(gg32, 6);
        Gg3.i(gg32, n5 > 1 ? 1 : 0);
        Gg3.i(gg32, n5);
        Gg3.i(gg32, n6);
        gg3.v = n3;
        int n50 = 0;
        int n51 = 0;
        int n52 = 0;
        int n53 = 0;
        int n54 = 0;
        int n55 = 0;
        int n56 = 0;
        int[] arrn = new int[128];
        n28 = 0;
        for (int i = 0; i < n5; ++i) {
            int n57;
            block45 : {
                int n58;
                Gg3.a(gg32, 1297379947);
                gg32.v += 4;
                n57 = gg32.v;
                int n59 = -1;
                do {
                    int n60 = Gg3.bn(gg3);
                    Gg3.ab(gg32, n60);
                    n58 = gg3.r[n4++] & 0xFF;
                    boolean bl = n58 != n59;
                    n59 = n58 & 0xF;
                    if (n58 == 7) {
                        if (bl) {
                            Gg3.k(gg32, 255);
                        }
                        break block45;
                    }
                    if (n58 == 23) {
                        if (bl) {
                            Gg3.k(gg32, 255);
                        }
                        Gg3.k(gg32, 81);
                        Gg3.k(gg32, 3);
                        Gg3.k(gg32, gg3.r[n49++]);
                        Gg3.k(gg32, gg3.r[n49++]);
                        Gg3.k(gg32, gg3.r[n49++]);
                        continue;
                    }
                    n50 ^= n58 >> 4;
                    if (n59 == 0) {
                        if (bl) {
                            Gg3.k(gg32, 144 + n50);
                        }
                        int n61 = n36++;
                        int n62 = n37++;
                        Gg3.k(gg32, (n51 += gg3.r[n61]) & 0x7F);
                        Gg3.k(gg32, (n52 += gg3.r[n62]) & 0x7F);
                        continue;
                    }
                    if (n59 == 1) {
                        if (bl) {
                            Gg3.k(gg32, 128 + n50);
                        }
                        int n63 = n36++;
                        int n64 = n39++;
                        Gg3.k(gg32, (n51 += gg3.r[n63]) & 0x7F);
                        Gg3.k(gg32, (n53 += gg3.r[n64]) & 0x7F);
                        continue;
                    }
                    if (n59 == 2) {
                        if (bl) {
                            Gg3.k(gg32, 176 + n50);
                        }
                        n28 = n28 + gg3.r[n2++] & 0x7F;
                        Gg3.k(gg32, n28);
                        int n65 = n28 == 0 || n28 == 32 ? gg3.r[n43++] : (n28 == 1 ? gg3.r[n33++] : (n28 == 33 ? gg3.r[n40++] : (n28 == 7 ? gg3.r[n34++] : (n28 == 39 ? gg3.r[n41++] : (n28 == 10 ? gg3.r[n35++] : (n28 == 42 ? gg3.r[n42++] : (n28 == 99 ? gg3.r[n45++] : (n28 == 98 ? gg3.r[n46++] : (n28 == 101 ? gg3.r[n47++] : (n28 == 100 ? gg3.r[n48++] : (n28 == 64 || n28 == 65 || n28 == 120 || n28 == 121 || n28 == 123 ? gg3.r[n29++] : gg3.r[n38++])))))))))));
                        arrn[n28] = n65 += arrn[n28];
                        Gg3.k(gg32, n65 & 0x7F);
                        continue;
                    }
                    if (n59 == 3) {
                        if (bl) {
                            Gg3.k(gg32, 224 + n50);
                        }
                        n54 += gg3.r[n44++];
                        Gg3.k(gg32, (n54 += gg3.r[n32++] << 7) & 0x7F);
                        Gg3.k(gg32, n54 >> 7 & 0x7F);
                        continue;
                    }
                    if (n59 == 4) {
                        if (bl) {
                            Gg3.k(gg32, 208 + n50);
                        }
                        Gg3.k(gg32, (n55 += gg3.r[n31++]) & 0x7F);
                        continue;
                    }
                    if (n59 == 5) {
                        if (bl) {
                            Gg3.k(gg32, 160 + n50);
                        }
                        int n66 = n36++;
                        int n67 = n30++;
                        Gg3.k(gg32, (n51 += gg3.r[n66]) & 0x7F);
                        Gg3.k(gg32, (n56 += gg3.r[n67]) & 0x7F);
                        continue;
                    }
                    if (n59 != 6) break;
                    if (bl) {
                        Gg3.k(gg32, 192 + n50);
                    }
                    Gg3.k(gg32, gg3.r[n43++]);
                } while (true);
                throw new RuntimeException("Unrecognised status " + n58);
            }
            Gg3.k(gg32, 47);
            Gg3.k(gg32, 0);
            Gg3.am(gg32, gg32.v - n57);
        }
        if (gg32.v != gg32.r.length) {
            throw new RuntimeException(".mid size calculation was wrong");
        }
    }

    public P689(byte[] arrby) {
        this.q = arrby;
    }

    public static void q(P689 p689) {
        p689.d = null;
    }

    public void d() {
        int n;
        if (this.d != null) {
            return;
        }
        this.d = new Ha262(16);
        int[] arrn = new int[16];
        int[] arrn2 = new int[16];
        arrn2[9] = 128;
        arrn[9] = 128;
        Z693 z693 = new Z693(this.q);
        int n2 = Z693.j(z693);
        for (n = 0; n < n2; ++n) {
            Z693.e(z693, n);
            Z693.b(z693, n);
            Z693.h(z693, n);
        }
        block1 : do {
            n = Z693.y(z693);
            int n3 = z693.s[n];
            do {
                int n4;
                int n5;
                int n6;
                if (z693.s[n] != n3) continue block1;
                Z693.e(z693, n);
                int n7 = z693.l(n);
                if (n7 == 1) {
                    Z693.s(z693);
                    Z693.h(z693, n);
                    if (Z693.p(z693)) break block1;
                    continue block1;
                }
                int n8 = n7 & 0xF0;
                if (n8 == 176) {
                    n4 = n7 & 0xF;
                    n6 = n7 >> 8 & 0x7F;
                    n5 = n7 >> 16 & 0x7F;
                    if (n6 == 0) {
                        arrn[n4] = (arrn[n4] & 0xFFE03FFF) + (n5 << 14);
                    }
                    if (n6 == 32) {
                        arrn[n4] = (arrn[n4] & 0xFFFFC07F) + (n5 << 7);
                    }
                }
                if (n8 == 192) {
                    n4 = n7 & 0xF;
                    n6 = n7 >> 8 & 0x7F;
                    arrn2[n4] = arrn[n4] + n6;
                }
                if (n8 == 144) {
                    n4 = n7 & 0xF;
                    n6 = n7 >> 8 & 0x7F;
                    n5 = n7 >> 16 & 0x7F;
                    if (n5 > 0) {
                        int n9 = arrn2[n4];
                        Ld263 ld263 = (Ld263)Ha262.d(this.d, n9);
                        if (ld263 == null) {
                            ld263 = new Ld263(new byte[128]);
                            Ha262.q(this.d, ld263, n9);
                        }
                        ((byte[])ld263.g)[n6] = 1;
                    }
                }
                Z693.b(z693, n);
                Z693.h(z693, n);
            } while (true);
            break;
        } while (true);
    }
}

