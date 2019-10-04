// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public class Y692 extends Ln265
{
    private int[] b;
    public Cw634[] d;
    public byte[] e;
    public int g;
    public V686[] h;
    public byte[] j;
    public short[] q;
    public byte[] s;
    
    public Y692(final byte[] array) {
        this.d = new Cw634[128];
        this.q = new short[128];
        this.j = new byte[128];
        this.e = new byte[128];
        this.h = new V686[128];
        this.s = new byte[128];
        this.b = new int[128];
        Gg3 gg3;
        int n;
        for (gg3 = new Gg3(array), n = 0; gg3.r[gg3.v + n] != 0; ++n) {}
        final byte[] array2 = new byte[n];
        for (int i = 0; i < n; ++i) {
            array2[i] = Gg3.ax(gg3);
        }
        final Gg3 gg4 = gg3;
        ++gg4.v;
        ++n;
        int v = gg3.v;
        final Gg3 gg5 = gg3;
        gg5.v += n;
        int n2;
        for (n2 = 0; gg3.r[gg3.v + n2] != 0; ++n2) {}
        final byte[] array3 = new byte[n2];
        for (int j = 0; j < n2; ++j) {
            array3[j] = Gg3.ax(gg3);
        }
        final Gg3 gg6 = gg3;
        ++gg6.v;
        ++n2;
        int v2 = gg3.v;
        final Gg3 gg7 = gg3;
        gg7.v += n2;
        int n3;
        for (n3 = 0; gg3.r[gg3.v + n3] != 0; ++n3) {}
        final byte[] array4 = new byte[n3];
        for (int k = 0; k < n3; ++k) {
            array4[k] = Gg3.ax(gg3);
        }
        final Gg3 gg8 = gg3;
        ++gg8.v;
        final byte[] array5 = new byte[++n3];
        int n5;
        if (n3 > 1) {
            array5[1] = 1;
            int n4 = 1;
            n5 = 2;
            for (int l = 2; l < n3; ++l) {
                int ar = Gg3.ar(gg3);
                if (ar == 0) {
                    n4 = n5++;
                }
                else {
                    if (ar <= n4) {
                        --ar;
                    }
                    n4 = ar;
                }
                array5[l] = (byte)n4;
            }
        }
        else {
            n5 = n3;
        }
        final V686[] array6 = new V686[n5];
        for (int n6 = 0; n6 < array6.length; ++n6) {
            final V686[] array7 = array6;
            final int n7 = n6;
            final V686 v3 = new V686();
            array7[n7] = v3;
            final V686 v4 = v3;
            final int ar2 = Gg3.ar(gg3);
            if (ar2 > 0) {
                v4.g = new byte[ar2 * 2];
            }
            final int ar3 = Gg3.ar(gg3);
            if (ar3 > 0) {
                (v4.d = new byte[ar3 * 2 + 2])[1] = 64;
            }
        }
        final int ar4 = Gg3.ar(gg3);
        final byte[] array8 = (byte[])((ar4 > 0) ? new byte[ar4 * 2] : null);
        final int ar5 = Gg3.ar(gg3);
        final byte[] array9 = (byte[])((ar5 > 0) ? new byte[ar5 * 2] : null);
        int n8;
        for (n8 = 0; gg3.r[gg3.v + n8] != 0; ++n8) {}
        final byte[] array10 = new byte[n8];
        for (int n9 = 0; n9 < n8; ++n9) {
            array10[n9] = Gg3.ax(gg3);
        }
        final Gg3 gg9 = gg3;
        ++gg9.v;
        ++n8;
        int n10 = 0;
        for (int n11 = 0; n11 < 128; ++n11) {
            n10 += Gg3.ar(gg3);
            this.q[n11] = (short)n10;
        }
        int n12 = 0;
        for (int n13 = 0; n13 < 128; ++n13) {
            n12 += Gg3.ar(gg3);
            final short[] q = this.q;
            final int n14 = n13;
            q[n14] += (short)(n12 << 8);
        }
        int n15 = 0;
        int n16 = 0;
        int bn = 0;
        for (int n17 = 0; n17 < 128; ++n17) {
            if (n15 == 0) {
                if (n16 < array10.length) {
                    n15 = array10[n16++];
                }
                else {
                    n15 = -1;
                }
                bn = Gg3.bn(gg3);
            }
            final short[] q2 = this.q;
            final int n18 = n17;
            q2[n18] += (short)((bn - 1 & 0x2) << 14);
            this.b[n17] = bn;
            --n15;
        }
        int n19 = 0;
        int n20 = 0;
        int n21 = 0;
        for (int n22 = 0; n22 < 128; ++n22) {
            if (this.b[n22] != 0) {
                if (n19 == 0) {
                    if (n20 < array2.length) {
                        n19 = array2[n20++];
                    }
                    else {
                        n19 = -1;
                    }
                    n21 = gg3.r[v++] - 1;
                }
                this.s[n22] = (byte)n21;
                --n19;
            }
        }
        int n23 = 0;
        int n24 = 0;
        int n25 = 0;
        for (int n26 = 0; n26 < 128; ++n26) {
            if (this.b[n26] != 0) {
                if (n23 == 0) {
                    if (n24 < array3.length) {
                        n23 = array3[n24++];
                    }
                    else {
                        n23 = -1;
                    }
                    n25 = gg3.r[v2++] + 16 << 2;
                }
                this.e[n26] = (byte)n25;
                --n23;
            }
        }
        int n27 = 0;
        int n28 = 0;
        V686 v5 = null;
        for (int n29 = 0; n29 < 128; ++n29) {
            if (this.b[n29] != 0) {
                if (n27 == 0) {
                    v5 = array6[array5[n28]];
                    if (n28 < array4.length) {
                        n27 = array4[n28++];
                    }
                    else {
                        n27 = -1;
                    }
                }
                this.h[n29] = v5;
                --n27;
            }
        }
        int n30 = 0;
        int n31 = 0;
        int n32 = 0;
        for (int n33 = 0; n33 < 128; ++n33) {
            if (n30 == 0) {
                if (n31 < array10.length) {
                    n30 = array10[n31++];
                }
                else {
                    n30 = -1;
                }
                if (this.b[n33] > 0) {
                    n32 = Gg3.ar(gg3) + 1;
                }
            }
            this.j[n33] = (byte)n32;
            --n30;
        }
        this.g = Gg3.ar(gg3) + 1;
        for (final V686 v6 : array6) {
            if (v6.g != null) {
                for (int n35 = 1; n35 < v6.g.length; n35 += 2) {
                    v6.g[n35] = Gg3.ax(gg3);
                }
            }
            if (v6.d != null) {
                for (int n36 = 3; n36 < v6.d.length - 2; n36 += 2) {
                    v6.d[n36] = Gg3.ax(gg3);
                }
            }
        }
        if (array8 != null) {
            for (int n37 = 1; n37 < array8.length; n37 += 2) {
                array8[n37] = Gg3.ax(gg3);
            }
        }
        if (array9 != null) {
            for (int n38 = 1; n38 < array9.length; n38 += 2) {
                array9[n38] = Gg3.ax(gg3);
            }
        }
        for (final V686 v7 : array6) {
            if (v7.d != null) {
                int n40 = 0;
                for (int n41 = 2; n41 < v7.d.length; n41 += 2) {
                    n40 = n40 + 1 + Gg3.ar(gg3);
                    v7.d[n41] = (byte)n40;
                }
            }
        }
        for (final V686 v8 : array6) {
            if (v8.g != null) {
                int n43 = 0;
                for (int n44 = 2; n44 < v8.g.length; n44 += 2) {
                    n43 = n43 + 1 + Gg3.ar(gg3);
                    v8.g[n44] = (byte)n43;
                }
            }
        }
        if (array8 != null) {
            int ar6 = Gg3.ar(gg3);
            array8[0] = (byte)ar6;
            for (int n45 = 2; n45 < array8.length; n45 += 2) {
                ar6 = ar6 + 1 + Gg3.ar(gg3);
                array8[n45] = (byte)ar6;
            }
            byte b = array8[0];
            byte b2 = array8[1];
            for (byte b3 = 0; b3 < b; ++b3) {
                this.j[b3] = (byte)(this.j[b3] * b2 + 32 >> 6);
            }
            for (int n46 = 2; n46 < array8.length; n46 += 2) {
                final byte b4 = array8[n46];
                final byte b5 = array8[n46 + 1];
                int n47 = b2 * (b4 - b) + (b4 - b) / 2;
                for (byte b6 = b; b6 < b4; ++b6) {
                    this.j[b6] = (byte)(this.j[b6] * Jz233.l(n47, b4 - b) + 32 >> 6);
                    n47 += b5 - b2;
                }
                b = b4;
                b2 = b5;
            }
            for (int n48 = b; n48 < 128; ++n48) {
                this.j[n48] = (byte)(this.j[n48] * b2 + 32 >> 6);
            }
        }
        if (array9 != null) {
            int ar7 = Gg3.ar(gg3);
            array9[0] = (byte)ar7;
            for (int n49 = 2; n49 < array9.length; n49 += 2) {
                ar7 = ar7 + 1 + Gg3.ar(gg3);
                array9[n49] = (byte)ar7;
            }
            byte b7 = array9[0];
            int n50 = array9[1] << 1;
            for (byte b8 = 0; b8 < b7; ++b8) {
                int n51 = (this.e[b8] & 0xFF) + n50;
                if (n51 < 0) {
                    n51 = 0;
                }
                if (n51 > 128) {
                    n51 = 128;
                }
                this.e[b8] = (byte)n51;
            }
            for (int n52 = 2; n52 < array9.length; n52 += 2) {
                final byte b9 = array9[n52];
                final int n53 = array9[n52 + 1] << 1;
                int n54 = n50 * (b9 - b7) + (b9 - b7) / 2;
                for (byte b10 = b7; b10 < b9; ++b10) {
                    int n55 = (this.e[b10] & 0xFF) + Jz233.l(n54, b9 - b7);
                    if (n55 < 0) {
                        n55 = 0;
                    }
                    if (n55 > 128) {
                        n55 = 128;
                    }
                    this.e[b10] = (byte)n55;
                    n54 += n53 - n50;
                }
                b7 = b9;
                n50 = n53;
            }
            for (int n56 = b7; n56 < 128; ++n56) {
                int n57 = (this.e[n56] & 0xFF) + n50;
                if (n57 < 0) {
                    n57 = 0;
                }
                if (n57 > 128) {
                    n57 = 128;
                }
                this.e[n56] = (byte)n57;
            }
        }
        for (int n58 = 0; n58 < n5; ++n58) {
            array6[n58].q = Gg3.ar(gg3);
        }
        for (final V686 v9 : array6) {
            if (v9.g != null) {
                v9.j = Gg3.ar(gg3);
            }
            if (v9.d != null) {
                v9.e = Gg3.ar(gg3);
            }
            if (v9.q > 0) {
                v9.h = Gg3.ar(gg3);
            }
        }
        for (int n60 = 0; n60 < n5; ++n60) {
            array6[n60].b = Gg3.ar(gg3);
        }
        for (final V686 v10 : array6) {
            if (v10.b > 0) {
                v10.s = Gg3.ar(gg3);
            }
        }
        for (final V686 v11 : array6) {
            if (v11.s > 0) {
                v11.l = Gg3.ar(gg3);
            }
        }
    }
    
    public static Y692 g(final js5 js5, final int n) {
        final byte[] v = js5.v(js5, n);
        if (v == null) {
            return null;
        }
        return new Y692(v);
    }
    
    public static boolean d(final Y692 y692, final Ca649 ca649, final byte[] array, final int[] array2) {
        boolean b = true;
        int n = 0;
        Cw634 cw634 = null;
        for (int i = 0; i < 128; ++i) {
            if (array == null || array[i] != 0) {
                int n2 = y692.b[i];
                if (n2 != 0) {
                    if (n2 != n) {
                        n = n2;
                        if ((--n2 & 0x1) == 0x0) {
                            cw634 = ca649.q(n2 >> 2, array2);
                        }
                        else {
                            cw634 = ca649.j(n2 >> 2, array2);
                        }
                        if (cw634 == null) {
                            b = false;
                        }
                    }
                    if (cw634 != null) {
                        y692.d[i] = cw634;
                        y692.b[i] = 0;
                    }
                }
            }
        }
        return b;
    }
    
    public static void q(final Y692 y692) {
        y692.b = null;
    }
    
    public Y692() {
    }
}
