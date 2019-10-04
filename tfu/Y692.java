/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import tfu.Ca649;
import tfu.Ci646;
import tfu.Cj551;
import tfu.Cw634;
import tfu.Gg3;
import tfu.Jz233;
import tfu.Ln265;
import tfu.V686;

public class Y692
extends Ln265 {
    private int[] b;
    public Cw634[] d;
    public byte[] e;
    public int g;
    public V686[] h;
    public byte[] j;
    public short[] q;
    public byte[] s;

    public Y692(byte[] arrby) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        Object object;
        int n13;
        Object object2;
        int n14;
        this.d = new Cw634[128];
        this.q = new short[128];
        this.j = new byte[128];
        this.e = new byte[128];
        this.h = new V686[128];
        this.s = new byte[128];
        this.b = new int[128];
        Gg3 gg3 = new Gg3(arrby);
        int n15 = 0;
        while (gg3.r[gg3.v + n15] != 0) {
            ++n15;
        }
        byte[] arrby2 = new byte[n15];
        for (n4 = 0; n4 < n15; ++n4) {
            arrby2[n4] = Gg3.ax(gg3);
        }
        ++gg3.v;
        n4 = gg3.v;
        gg3.v += ++n15;
        int n16 = 0;
        while (gg3.r[gg3.v + n16] != 0) {
            ++n16;
        }
        byte[] arrby3 = new byte[n16];
        for (n3 = 0; n3 < n16; ++n3) {
            arrby3[n3] = Gg3.ax(gg3);
        }
        ++gg3.v;
        n3 = gg3.v;
        gg3.v += ++n16;
        int n17 = 0;
        while (gg3.r[gg3.v + n17] != 0) {
            ++n17;
        }
        byte[] arrby4 = new byte[n17];
        for (int i = 0; i < n17; ++i) {
            arrby4[i] = Gg3.ax(gg3);
        }
        ++gg3.v;
        byte[] arrby5 = new byte[++n17];
        if (n17 > 1) {
            arrby5[1] = 1;
            int n18 = 1;
            n10 = 2;
            for (n2 = 2; n2 < n17; ++n2) {
                int n19 = Gg3.ar(gg3);
                if (n19 == 0) {
                    n18 = n10++;
                } else {
                    if (n19 <= n18) {
                        // empty if block
                    }
                    n18 = --n19;
                }
                arrby5[n2] = (byte)n18;
            }
        } else {
            n10 = n17;
        }
        V686[] arrv686 = new V686[n10];
        for (n2 = 0; n2 < arrv686.length; ++n2) {
            V686 v686 = arrv686[n2] = new V686();
            int n20 = Gg3.ar(gg3);
            if (n20 > 0) {
                v686.g = new byte[n20 * 2];
            }
            if ((n20 = Gg3.ar(gg3)) <= 0) continue;
            v686.d = new byte[n20 * 2 + 2];
            v686.d[1] = 64;
        }
        n2 = Gg3.ar(gg3);
        byte[] arrby6 = n2 > 0 ? new byte[n2 * 2] : null;
        n2 = Gg3.ar(gg3);
        byte[] arrby7 = n2 > 0 ? new byte[n2 * 2] : null;
        int n21 = 0;
        while (gg3.r[gg3.v + n21] != 0) {
            ++n21;
        }
        byte[] arrby8 = new byte[n21];
        for (n8 = 0; n8 < n21; ++n8) {
            arrby8[n8] = Gg3.ax(gg3);
        }
        ++gg3.v;
        ++n21;
        n8 = 0;
        for (n11 = 0; n11 < 128; ++n11) {
            this.q[n11] = (short)(n8 += Gg3.ar(gg3));
        }
        n8 = 0;
        n11 = 0;
        while (n11 < 128) {
            short[] arrs = this.q;
            int n22 = n11++;
            arrs[n22] = (short)(arrs[n22] + ((n8 += Gg3.ar(gg3)) << 8));
        }
        n11 = 0;
        int n23 = 0;
        int n24 = 0;
        int n25 = 0;
        while (n25 < 128) {
            if (n11 == 0) {
                n11 = n23 < arrby8.length ? arrby8[n23++] : -1;
                n24 = Gg3.bn(gg3);
            }
            short[] arrs = this.q;
            int n26 = n25++;
            arrs[n26] = (short)(arrs[n26] + ((n24 - 1 & 2) << 14));
            this.b[n25] = n24;
            --n11;
        }
        n11 = 0;
        n23 = 0;
        n25 = 0;
        for (n9 = 0; n9 < 128; ++n9) {
            if (this.b[n9] == 0) continue;
            if (n11 == 0) {
                n11 = n23 < arrby2.length ? arrby2[n23++] : -1;
                n25 = gg3.r[n4++] - 1;
            }
            this.s[n9] = (byte)n25;
            --n11;
        }
        n11 = 0;
        n23 = 0;
        n9 = 0;
        for (int i = 0; i < 128; ++i) {
            if (this.b[i] == 0) continue;
            if (n11 == 0) {
                n11 = n23 < arrby3.length ? arrby3[n23++] : -1;
                n9 = gg3.r[n3++] + 16 << 2;
            }
            this.e[i] = (byte)n9;
            --n11;
        }
        n11 = 0;
        n23 = 0;
        V686 v686 = null;
        for (n12 = 0; n12 < 128; ++n12) {
            if (this.b[n12] == 0) continue;
            if (n11 == 0) {
                v686 = arrv686[arrby5[n23]];
                n11 = n23 < arrby4.length ? arrby4[n23++] : -1;
            }
            this.h[n12] = v686;
            --n11;
        }
        n11 = 0;
        n23 = 0;
        n12 = 0;
        for (n7 = 0; n7 < 128; ++n7) {
            if (n11 == 0) {
                n11 = n23 < arrby8.length ? arrby8[n23++] : -1;
                if (this.b[n7] > 0) {
                    n12 = Gg3.ar(gg3) + 1;
                }
            }
            this.j[n7] = (byte)n12;
            --n11;
        }
        this.g = Gg3.ar(gg3) + 1;
        for (n7 = 0; n7 < n10; ++n7) {
            object = arrv686[n7];
            if (object.g != null) {
                for (n6 = 1; n6 < object.g.length; n6 += 2) {
                    object.g[n6] = Gg3.ax(gg3);
                }
            }
            if (object.d == null) continue;
            for (n6 = 3; n6 < object.d.length - 2; n6 += 2) {
                object.d[n6] = Gg3.ax(gg3);
            }
        }
        if (arrby6 != null) {
            for (n7 = 1; n7 < arrby6.length; n7 += 2) {
                arrby6[n7] = Gg3.ax(gg3);
            }
        }
        if (arrby7 != null) {
            for (n7 = 1; n7 < arrby7.length; n7 += 2) {
                arrby7[n7] = Gg3.ax(gg3);
            }
        }
        for (n7 = 0; n7 < n10; ++n7) {
            object = arrv686[n7];
            if (object.d == null) continue;
            n8 = 0;
            for (n6 = 2; n6 < object.d.length; n6 += 2) {
                n8 = n8 + 1 + Gg3.ar(gg3);
                object.d[n6] = (byte)n8;
            }
        }
        for (n7 = 0; n7 < n10; ++n7) {
            object = arrv686[n7];
            if (object.g == null) continue;
            n8 = 0;
            for (n6 = 2; n6 < object.g.length; n6 += 2) {
                n8 = n8 + 1 + Gg3.ar(gg3);
                object.g[n6] = (byte)n8;
            }
        }
        if (arrby6 != null) {
            n8 = Gg3.ar(gg3);
            arrby6[0] = (byte)n8;
            for (n7 = 2; n7 < arrby6.length; n7 += 2) {
                n8 = n8 + 1 + Gg3.ar(gg3);
                arrby6[n7] = (byte)n8;
            }
            n7 = arrby6[0];
            int n27 = arrby6[1];
            for (n6 = 0; n6 < n7; ++n6) {
                this.j[n6] = (byte)(this.j[n6] * n27 + 32 >> 6);
            }
            for (n6 = 2; n6 < arrby6.length; n6 += 2) {
                n5 = arrby6[n6];
                n14 = arrby6[n6 + 1];
                object2 = n27 * (n5 - n7) + (n5 - n7) / 2;
                for (n = n7; n < n5; ++n) {
                    n13 = Jz233.l(object2, n5 - n7);
                    this.j[n] = (byte)(this.j[n] * n13 + 32 >> 6);
                    object2 += n14 - n27;
                }
                n7 = n5;
                n27 = n14;
            }
            for (n5 = n7; n5 < 128; ++n5) {
                this.j[n5] = (byte)(this.j[n5] * n27 + 32 >> 6);
            }
            arrby6 = null;
        }
        if (arrby7 != null) {
            n8 = Gg3.ar(gg3);
            arrby7[0] = (byte)n8;
            for (n7 = 2; n7 < arrby7.length; n7 += 2) {
                n8 = n8 + 1 + Gg3.ar(gg3);
                arrby7[n7] = (byte)n8;
            }
            n7 = arrby7[0];
            object = arrby7[1] << 1;
            for (n6 = 0; n6 < n7; ++n6) {
                n5 = (this.e[n6] & 0xFF) + object;
                if (n5 < 0) {
                    n5 = 0;
                }
                if (n5 > 128) {
                    n5 = 128;
                }
                this.e[n6] = (byte)n5;
            }
            for (n6 = 2; n6 < arrby7.length; n6 += 2) {
                n5 = arrby7[n6];
                n14 = arrby7[n6 + 1] << 1;
                object2 = object * (n5 - n7) + (n5 - n7) / 2;
                for (n = n7; n < n5; ++n) {
                    n13 = Jz233.l(object2, n5 - n7);
                    int n28 = (this.e[n] & 0xFF) + n13;
                    if (n28 < 0) {
                        n28 = 0;
                    }
                    if (n28 > 128) {
                        n28 = 128;
                    }
                    this.e[n] = (byte)n28;
                    object2 += n14 - object;
                }
                n7 = n5;
                object = n14;
            }
            for (n5 = n7; n5 < 128; ++n5) {
                n14 = (this.e[n5] & 0xFF) + object;
                if (n14 < 0) {
                    n14 = 0;
                }
                if (n14 > 128) {
                    n14 = 128;
                }
                this.e[n5] = (byte)n14;
            }
            arrby7 = null;
        }
        for (n7 = 0; n7 < n10; ++n7) {
            arrv686[n7].q = Gg3.ar(gg3);
        }
        for (n7 = 0; n7 < n10; ++n7) {
            V686 v6862 = arrv686[n7];
            if (v6862.g != null) {
                v6862.j = Gg3.ar(gg3);
            }
            if (v6862.d != null) {
                v6862.e = Gg3.ar(gg3);
            }
            if (v6862.q <= 0) continue;
            v6862.h = Gg3.ar(gg3);
        }
        for (n7 = 0; n7 < n10; ++n7) {
            arrv686[n7].b = Gg3.ar(gg3);
        }
        for (n7 = 0; n7 < n10; ++n7) {
            V686 v6863 = arrv686[n7];
            if (v6863.b <= 0) continue;
            v6863.s = Gg3.ar(gg3);
        }
        for (n7 = 0; n7 < n10; ++n7) {
            V686 v6864 = arrv686[n7];
            if (v6864.s <= 0) continue;
            v6864.l = Gg3.ar(gg3);
        }
    }

    public static Y692 g(js5 js52, int n) {
        byte[] arrby = js5.v(js52, n);
        if (arrby == null) {
            return null;
        }
        return new Y692(arrby);
    }

    public static boolean d(Y692 y692, Ca649 ca649, byte[] arrby, int[] arrn) {
        boolean bl = true;
        int n = 0;
        Cw634 cw634 = null;
        for (int i = 0; i < 128; ++i) {
            int n2;
            if (arrby != null && arrby[i] == 0 || (n2 = y692.b[i]) == 0) continue;
            if (n2 != n) {
                n = n2--;
                cw634 = (n2 & 1) == 0 ? ca649.q(n2 >> 2, arrn) : ca649.j(n2 >> 2, arrn);
                if (cw634 == null) {
                    bl = false;
                }
            }
            if (cw634 == null) continue;
            y692.d[i] = cw634;
            y692.b[i] = 0;
        }
        return bl;
    }

    public static void q(Y692 y692) {
        y692.b = null;
    }

    public Y692() {
    }
}

