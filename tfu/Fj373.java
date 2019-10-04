// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public class Fj373
{
    public byte[] b;
    public int d;
    public int e;
    public int g;
    public int h;
    public int j;
    public byte[] l;
    public int q;
    public int[] s;
    
    public static Fj373 g(final js5 js5, final int n, final int n2) {
        final byte[] getfile = js5.getfile(n, n2);
        if (getfile == null) {
            return null;
        }
        return d(getfile)[0];
    }
    
    public static int q(final Fj373 fj373) {
        return fj373.g + fj373.q + fj373.j;
    }
    
    public static int j(final Fj373 fj373) {
        return fj373.d + fj373.e + fj373.h;
    }
    
    public static int[] e(final Fj373 fj373) {
        final int q = q(fj373);
        final int[] array = new int[q * j(fj373)];
        if (fj373.l != null) {
            for (int i = 0; i < fj373.d; ++i) {
                int n = i * fj373.g;
                int n2 = fj373.q + (i + fj373.e) * q;
                for (int j = 0; j < fj373.g; ++j) {
                    array[n2++] = (fj373.l[n] << 24 | fj373.s[fj373.b[n] & 0xFF]);
                    ++n;
                }
            }
        }
        else {
            for (int k = 0; k < fj373.d; ++k) {
                int n3 = k * fj373.g;
                int n4 = fj373.q + (k + fj373.e) * q;
                for (int l = 0; l < fj373.g; ++l) {
                    final int n5 = fj373.s[fj373.b[n3++] & 0xFF];
                    if (n5 != 0) {
                        array[n4++] = (0xFF000000 | n5);
                    }
                    else {
                        array[n4++] = 0;
                    }
                }
            }
        }
        return array;
    }
    
    public static Fj373[] d(final byte[] array) {
        final Gg3 gg3 = new Gg3(array);
        gg3.v = array.length - 2;
        final int au = Gg3.au(gg3);
        final Fj373[] array2 = new Fj373[au];
        for (int i = 0; i < au; ++i) {
            array2[i] = new Fj373();
        }
        gg3.v = array.length - 7 - au * 8;
        final int au2 = Gg3.au(gg3);
        final int au3 = Gg3.au(gg3);
        final int n = (Gg3.ar(gg3) & 0xFF) + 1;
        for (int j = 0; j < au; ++j) {
            array2[j].q = Gg3.au(gg3);
        }
        for (int k = 0; k < au; ++k) {
            array2[k].e = Gg3.au(gg3);
        }
        for (int l = 0; l < au; ++l) {
            array2[l].g = Gg3.au(gg3);
        }
        for (int n2 = 0; n2 < au; ++n2) {
            array2[n2].d = Gg3.au(gg3);
        }
        for (final Fj373 fj373 : array2) {
            fj373.j = au2 - fj373.g - fj373.q;
            fj373.h = au3 - fj373.d - fj373.e;
        }
        gg3.v = array.length - 7 - au * 8 - (n - 1) * 3;
        final int[] s = new int[n];
        for (int n4 = 1; n4 < n; ++n4) {
            s[n4] = Gg3.ay(gg3);
            if (s[n4] == 0) {
                s[n4] = 1;
            }
        }
        for (int n5 = 0; n5 < au; ++n5) {
            array2[n5].s = s;
        }
        gg3.v = 0;
        for (final Fj373 fj374 : array2) {
            final int n7 = fj374.g * fj374.d;
            fj374.b = new byte[n7];
            final int ar = Gg3.ar(gg3);
            if ((ar & 0x2) == 0x0) {
                if ((ar & 0x1) == 0x0) {
                    for (int n8 = 0; n8 < n7; ++n8) {
                        fj374.b[n8] = Gg3.ax(gg3);
                    }
                }
                else {
                    for (int n9 = 0; n9 < fj374.g; ++n9) {
                        for (int n10 = 0; n10 < fj374.d; ++n10) {
                            fj374.b[n9 + n10 * fj374.g] = Gg3.ax(gg3);
                        }
                    }
                }
            }
            else {
                boolean b = false;
                fj374.l = new byte[n7];
                if ((ar & 0x1) == 0x0) {
                    for (int n11 = 0; n11 < n7; ++n11) {
                        fj374.b[n11] = Gg3.ax(gg3);
                    }
                    for (int n12 = 0; n12 < n7; ++n12) {
                        final byte[] m = fj374.l;
                        final int n13 = n12;
                        final byte ax = Gg3.ax(gg3);
                        m[n13] = ax;
                        b |= (ax != -1);
                    }
                }
                else {
                    for (int n14 = 0; n14 < fj374.g; ++n14) {
                        for (int n15 = 0; n15 < fj374.d; ++n15) {
                            fj374.b[n14 + n15 * fj374.g] = Gg3.ax(gg3);
                        }
                    }
                    for (int n16 = 0; n16 < fj374.g; ++n16) {
                        for (int n17 = 0; n17 < fj374.d; ++n17) {
                            final byte[] l2 = fj374.l;
                            final int n18 = n16 + n17 * fj374.g;
                            final byte ax2 = Gg3.ax(gg3);
                            l2[n18] = ax2;
                            b |= (ax2 != -1);
                        }
                    }
                }
                if (!b) {
                    fj374.l = null;
                }
            }
        }
        return array2;
    }
}
