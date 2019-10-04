/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import tfu.Gg3;

public class Fj373 {
    public byte[] b;
    public int d;
    public int e;
    public int g;
    public int h;
    public int j;
    public byte[] l;
    public int q;
    public int[] s;

    public static Fj373 g(js5 js52, int n, int n2) {
        byte[] arrby = js52.getfile(n, n2);
        if (arrby == null) {
            return null;
        }
        return Fj373.d(arrby)[0];
    }

    public static int q(Fj373 fj373) {
        return fj373.g + fj373.q + fj373.j;
    }

    public static int j(Fj373 fj373) {
        return fj373.d + fj373.e + fj373.h;
    }

    public static int[] e(Fj373 fj373) {
        int n = Fj373.q(fj373);
        int[] arrn = new int[n * Fj373.j(fj373)];
        if (fj373.l != null) {
            for (int i = 0; i < fj373.d; ++i) {
                int n2 = i * fj373.g;
                int n3 = fj373.q + (i + fj373.e) * n;
                for (int j = 0; j < fj373.g; ++j) {
                    arrn[n3++] = fj373.l[n2] << 24 | fj373.s[fj373.b[n2] & 0xFF];
                    ++n2;
                }
            }
        } else {
            for (int i = 0; i < fj373.d; ++i) {
                int n4 = i * fj373.g;
                int n5 = fj373.q + (i + fj373.e) * n;
                for (int j = 0; j < fj373.g; ++j) {
                    int n6;
                    arrn[n5++] = (n6 = fj373.s[fj373.b[n4++] & 0xFF]) != 0 ? 0xFF000000 | n6 : 0;
                }
            }
        }
        return arrn;
    }

    public static Fj373[] d(byte[] arrby) {
        int n;
        int n2;
        int n3;
        Gg3 gg3 = new Gg3(arrby);
        gg3.v = arrby.length - 2;
        int n4 = Gg3.au(gg3);
        Fj373[] arrfj373 = new Fj373[n4];
        for (n = 0; n < n4; ++n) {
            arrfj373[n] = new Fj373();
        }
        gg3.v = arrby.length - 7 - n4 * 8;
        n = Gg3.au(gg3);
        int n5 = Gg3.au(gg3);
        int n6 = (Gg3.ar(gg3) & 0xFF) + 1;
        for (n2 = 0; n2 < n4; ++n2) {
            arrfj373[n2].q = Gg3.au(gg3);
        }
        for (n2 = 0; n2 < n4; ++n2) {
            arrfj373[n2].e = Gg3.au(gg3);
        }
        for (n2 = 0; n2 < n4; ++n2) {
            arrfj373[n2].g = Gg3.au(gg3);
        }
        for (n2 = 0; n2 < n4; ++n2) {
            arrfj373[n2].d = Gg3.au(gg3);
        }
        for (n2 = 0; n2 < n4; ++n2) {
            Fj373 fj373 = arrfj373[n2];
            fj373.j = n - fj373.g - fj373.q;
            fj373.h = n5 - fj373.d - fj373.e;
        }
        gg3.v = arrby.length - 7 - n4 * 8 - (n6 - 1) * 3;
        int[] arrn = new int[n6];
        for (n3 = 1; n3 < n6; ++n3) {
            arrn[n3] = Gg3.ay(gg3);
            if (arrn[n3] != 0) continue;
            arrn[n3] = 1;
        }
        for (n3 = 0; n3 < n4; ++n3) {
            arrfj373[n3].s = arrn;
        }
        gg3.v = 0;
        for (n3 = 0; n3 < n4; ++n3) {
            int n7;
            int n8;
            int n9;
            Fj373 fj373 = arrfj373[n3];
            int n10 = fj373.g * fj373.d;
            fj373.b = new byte[n10];
            int n11 = Gg3.ar(gg3);
            if ((n11 & 2) == 0) {
                if ((n11 & 1) == 0) {
                    for (n7 = 0; n7 < n10; ++n7) {
                        fj373.b[n7] = Gg3.ax(gg3);
                    }
                    continue;
                }
                for (n7 = 0; n7 < fj373.g; ++n7) {
                    for (n9 = 0; n9 < fj373.d; ++n9) {
                        fj373.b[n7 + n9 * fj373.g] = Gg3.ax(gg3);
                    }
                }
                continue;
            }
            n7 = 0;
            fj373.l = new byte[n10];
            if ((n11 & 1) == 0) {
                for (n9 = 0; n9 < n10; ++n9) {
                    fj373.b[n9] = Gg3.ax(gg3);
                }
                for (n9 = 0; n9 < n10; ++n9) {
                    fj373.l[n9] = Gg3.ax(gg3);
                    n8 = fj373.l[n9];
                    n7 |= n8 != -1 ? 1 : 0;
                }
            } else {
                for (n9 = 0; n9 < fj373.g; ++n9) {
                    for (n8 = 0; n8 < fj373.d; ++n8) {
                        fj373.b[n9 + n8 * fj373.g] = Gg3.ax(gg3);
                    }
                }
                for (n9 = 0; n9 < fj373.g; ++n9) {
                    for (n8 = 0; n8 < fj373.d; ++n8) {
                        byte by = Gg3.ax(gg3);
                        fj373.l[n9 + n8 * fj373.g] = by;
                        byte by2 = by;
                        n7 |= by2 != -1 ? 1 : 0;
                    }
                }
            }
            if (n7 != 0) continue;
            fj373.l = null;
        }
        return arrfj373;
    }
}

