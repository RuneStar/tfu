// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public class P689 extends Ln265
{
    private static final boolean g = true;
    public Ha262 d;
    byte[] q;
    
    public static P689 g(final js5 js5, final int n, final int n2) {
        final byte[] getfile = js5.getfile(n, n2);
        if (getfile == null) {
            return null;
        }
        return new P689(new Gg3(getfile));
    }
    
    public P689(final Gg3 gg3) {
        gg3.v = gg3.r.length - 3;
        final int ar = Gg3.ar(gg3);
        final int au = Gg3.au(gg3);
        int n = 14 + ar * 10;
        gg3.v = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        for (int i = 0; i < ar; ++i) {
            int n10 = -1;
            while (true) {
                final int ar2 = Gg3.ar(gg3);
                if (ar2 != n10) {
                    ++n;
                }
                n10 = (ar2 & 0xF);
                if (ar2 == 7) {
                    break;
                }
                if (ar2 == 23) {
                    ++n2;
                }
                else if (n10 == 0) {
                    ++n4;
                }
                else if (n10 == 1) {
                    ++n5;
                }
                else if (n10 == 2) {
                    ++n3;
                }
                else if (n10 == 3) {
                    ++n6;
                }
                else if (n10 == 4) {
                    ++n7;
                }
                else if (n10 == 5) {
                    ++n8;
                }
                else {
                    if (n10 != 6) {
                        throw new RuntimeException("Unrecognised status " + ar2);
                    }
                    ++n9;
                }
            }
        }
        final int n11 = n + 5 * n2 + 2 * (n4 + n5 + n3 + n6 + n8) + (n7 + n9);
        final int v = gg3.v;
        for (int n12 = ar + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9, j = 0; j < n12; ++j) {
            Gg3.bn(gg3);
        }
        final int n13 = n11 + (gg3.v - v);
        int v2 = gg3.v;
        int n14 = 0;
        int n15 = 0;
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
        for (int k = 0; k < n3; ++k) {
            n26 = (n26 + Gg3.ar(gg3) & 0x7F);
            if (n26 == 0 || n26 == 32) {
                ++n9;
            }
            else if (n26 == 1) {
                ++n14;
            }
            else if (n26 == 33) {
                ++n15;
            }
            else if (n26 == 7) {
                ++n16;
            }
            else if (n26 == 39) {
                ++n17;
            }
            else if (n26 == 10) {
                ++n18;
            }
            else if (n26 == 42) {
                ++n19;
            }
            else if (n26 == 99) {
                ++n20;
            }
            else if (n26 == 98) {
                ++n21;
            }
            else if (n26 == 101) {
                ++n22;
            }
            else if (n26 == 100) {
                ++n23;
            }
            else if (n26 == 64 || n26 == 65 || n26 == 120 || n26 == 121 || n26 == 123) {
                ++n24;
            }
            else {
                ++n25;
            }
        }
        int n27 = 0;
        int v3 = gg3.v;
        gg3.v += n24;
        int v4 = gg3.v;
        gg3.v += n8;
        int v5 = gg3.v;
        gg3.v += n7;
        int v6 = gg3.v;
        gg3.v += n6;
        int v7 = gg3.v;
        gg3.v += n14;
        int v8 = gg3.v;
        gg3.v += n16;
        int v9 = gg3.v;
        gg3.v += n18;
        int v10 = gg3.v;
        gg3.v += n4 + n5 + n8;
        int v11 = gg3.v;
        gg3.v += n4;
        int v12 = gg3.v;
        gg3.v += n25;
        int v13 = gg3.v;
        gg3.v += n5;
        int v14 = gg3.v;
        gg3.v += n15;
        int v15 = gg3.v;
        gg3.v += n17;
        int v16 = gg3.v;
        gg3.v += n19;
        int v17 = gg3.v;
        gg3.v += n9;
        int v18 = gg3.v;
        gg3.v += n6;
        int v19 = gg3.v;
        gg3.v += n20;
        int v20 = gg3.v;
        gg3.v += n21;
        int v21 = gg3.v;
        gg3.v += n22;
        int v22 = gg3.v;
        gg3.v += n23;
        int v23 = gg3.v;
        gg3.v += n2 * 3;
        if (gg3.v != gg3.r.length - 3) {
            throw new RuntimeException("Chunk lengths added up wrong");
        }
        this.q = new byte[n13];
        final Gg3 gg4 = new Gg3(this.q);
        Gg3.a(gg4, 1297377380);
        Gg3.a(gg4, 6);
        Gg3.i(gg4, (ar > 1) ? 1 : 0);
        Gg3.i(gg4, ar);
        Gg3.i(gg4, au);
        gg3.v = v;
        int n28 = 0;
        int n29 = 0;
        int n30 = 0;
        int n31 = 0;
        int n32 = 0;
        int n33 = 0;
        int n34 = 0;
        final int[] array = new int[128];
        int n35 = 0;
        for (int l = 0; l < ar; ++l) {
            Gg3.a(gg4, 1297379947);
            final Gg3 gg5 = gg4;
            gg5.v += 4;
            final int v24 = gg4.v;
            int n36 = -1;
            while (true) {
                Gg3.ab(gg4, Gg3.bn(gg3));
                final int m = gg3.r[n27++] & 0xFF;
                final boolean b = m != n36;
                n36 = (m & 0xF);
                if (m == 7) {
                    if (b) {
                        Gg3.k(gg4, 255);
                    }
                    Gg3.k(gg4, 47);
                    Gg3.k(gg4, 0);
                    Gg3.am(gg4, gg4.v - v24);
                    break;
                }
                if (m == 23) {
                    if (b) {
                        Gg3.k(gg4, 255);
                    }
                    Gg3.k(gg4, 81);
                    Gg3.k(gg4, 3);
                    Gg3.k(gg4, gg3.r[v23++]);
                    Gg3.k(gg4, gg3.r[v23++]);
                    Gg3.k(gg4, gg3.r[v23++]);
                }
                else {
                    n28 ^= m >> 4;
                    if (n36 == 0) {
                        if (b) {
                            Gg3.k(gg4, 144 + n28);
                        }
                        n29 += gg3.r[v10++];
                        n30 += gg3.r[v11++];
                        Gg3.k(gg4, n29 & 0x7F);
                        Gg3.k(gg4, n30 & 0x7F);
                    }
                    else if (n36 == 1) {
                        if (b) {
                            Gg3.k(gg4, 128 + n28);
                        }
                        n29 += gg3.r[v10++];
                        n31 += gg3.r[v13++];
                        Gg3.k(gg4, n29 & 0x7F);
                        Gg3.k(gg4, n31 & 0x7F);
                    }
                    else if (n36 == 2) {
                        if (b) {
                            Gg3.k(gg4, 176 + n28);
                        }
                        n35 = (n35 + gg3.r[v2++] & 0x7F);
                        Gg3.k(gg4, n35);
                        byte b2;
                        if (n35 == 0 || n35 == 32) {
                            b2 = gg3.r[v17++];
                        }
                        else if (n35 == 1) {
                            b2 = gg3.r[v7++];
                        }
                        else if (n35 == 33) {
                            b2 = gg3.r[v14++];
                        }
                        else if (n35 == 7) {
                            b2 = gg3.r[v8++];
                        }
                        else if (n35 == 39) {
                            b2 = gg3.r[v15++];
                        }
                        else if (n35 == 10) {
                            b2 = gg3.r[v9++];
                        }
                        else if (n35 == 42) {
                            b2 = gg3.r[v16++];
                        }
                        else if (n35 == 99) {
                            b2 = gg3.r[v19++];
                        }
                        else if (n35 == 98) {
                            b2 = gg3.r[v20++];
                        }
                        else if (n35 == 101) {
                            b2 = gg3.r[v21++];
                        }
                        else if (n35 == 100) {
                            b2 = gg3.r[v22++];
                        }
                        else if (n35 == 64 || n35 == 65 || n35 == 120 || n35 == 121 || n35 == 123) {
                            b2 = gg3.r[v3++];
                        }
                        else {
                            b2 = gg3.r[v12++];
                        }
                        Gg3.k(gg4, (array[n35] += b2) & 0x7F);
                    }
                    else if (n36 == 3) {
                        if (b) {
                            Gg3.k(gg4, 224 + n28);
                        }
                        n32 = n32 + gg3.r[v18++] + (gg3.r[v6++] << 7);
                        Gg3.k(gg4, n32 & 0x7F);
                        Gg3.k(gg4, n32 >> 7 & 0x7F);
                    }
                    else if (n36 == 4) {
                        if (b) {
                            Gg3.k(gg4, 208 + n28);
                        }
                        n33 += gg3.r[v5++];
                        Gg3.k(gg4, n33 & 0x7F);
                    }
                    else if (n36 == 5) {
                        if (b) {
                            Gg3.k(gg4, 160 + n28);
                        }
                        n29 += gg3.r[v10++];
                        n34 += gg3.r[v4++];
                        Gg3.k(gg4, n29 & 0x7F);
                        Gg3.k(gg4, n34 & 0x7F);
                    }
                    else {
                        if (n36 != 6) {
                            throw new RuntimeException("Unrecognised status " + m);
                        }
                        if (b) {
                            Gg3.k(gg4, 192 + n28);
                        }
                        Gg3.k(gg4, gg3.r[v17++]);
                    }
                }
            }
        }
        if (gg4.v != gg4.r.length) {
            throw new RuntimeException(".mid size calculation was wrong");
        }
    }
    
    public P689(final byte[] q) {
        this.q = q;
    }
    
    public static void q(final P689 p) {
        p.d = null;
    }
    
    public void d() {
        if (this.d != null) {
            return;
        }
        this.d = new Ha262(16);
        final int[] array = new int[16];
        final int[] array2 = new int[16];
        array[9] = (array2[9] = 128);
        final Z693 z693 = new Z693(this.q);
        for (int j = Z693.j(z693), i = 0; i < j; ++i) {
            Z693.e(z693, i);
            Z693.b(z693, i);
            Z693.h(z693, i);
        }
    Label_0410:
        while (true) {
            final int y = Z693.y(z693);
            while (z693.s[y] == z693.s[y]) {
                Z693.e(z693, y);
                final int l = z693.l(y);
                if (l == 1) {
                    Z693.s(z693);
                    Z693.h(z693, y);
                    if (!Z693.p(z693)) {
                        break;
                    }
                    break Label_0410;
                }
                else {
                    final int n = l & 0xF0;
                    if (n == 176) {
                        final int n2 = l & 0xF;
                        final int n3 = l >> 8 & 0x7F;
                        final int n4 = l >> 16 & 0x7F;
                        if (n3 == 0) {
                            array[n2] = (array[n2] & 0xFFE03FFF) + (n4 << 14);
                        }
                        if (n3 == 32) {
                            array[n2] = (array[n2] & 0xFFFFC07F) + (n4 << 7);
                        }
                    }
                    if (n == 192) {
                        final int n5 = l & 0xF;
                        array2[n5] = array[n5] + (l >> 8 & 0x7F);
                    }
                    if (n == 144) {
                        final int n6 = l & 0xF;
                        final int n7 = l >> 8 & 0x7F;
                        if ((l >> 16 & 0x7F) > 0) {
                            final int n8 = array2[n6];
                            Ld263 ld263 = (Ld263)Ha262.d(this.d, n8);
                            if (ld263 == null) {
                                ld263 = new Ld263(new byte[128]);
                                Ha262.q(this.d, ld263, n8);
                            }
                            ((byte[])ld263.g)[n7] = 1;
                        }
                    }
                    Z693.b(z693, y);
                    Z693.h(z693, y);
                }
            }
        }
    }
}
