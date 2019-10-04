/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.stringtools.general.J173;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.js5.js5;
import tfu.Gg3;
import tfu.Km535;

public class Kj334 {
    public static final boolean g = false;
    private static String[] l = new String[100];
    public int b;
    private byte[] d;
    public int e;
    public int h;
    public int j;
    private byte[][] q;
    public int s;

    private Kj334(byte[] arrby) {
        Gg3 gg3 = new Gg3(arrby);
        int n = Gg3.ar(gg3);
        if (n != 0) {
            throw new RuntimeException("");
        }
        boolean bl = Gg3.ar(gg3) == 1;
        this.d = new byte[256];
        Gg3.bx(gg3, this.d, 0, 256);
        if (bl) {
            int n2;
            int n3;
            int n4;
            int[] arrn = new int[256];
            int[] arrn2 = new int[256];
            for (n4 = 0; n4 < 256; ++n4) {
                arrn[n4] = Gg3.ar(gg3);
            }
            for (n4 = 0; n4 < 256; ++n4) {
                arrn2[n4] = Gg3.ar(gg3);
            }
            byte[][] arrarrby = new byte[256][];
            for (int i = 0; i < 256; ++i) {
                arrarrby[i] = new byte[arrn[i]];
                n3 = 0;
                for (n2 = 0; n2 < arrarrby[i].length; ++n2) {
                    arrarrby[i][n2] = n3 = (int)((byte)(n3 + Gg3.ax(gg3)));
                }
            }
            byte[][] arrarrby2 = new byte[256][];
            for (n3 = 0; n3 < 256; ++n3) {
                arrarrby2[n3] = new byte[arrn[n3]];
                n2 = 0;
                for (int i = 0; i < arrarrby2[n3].length; ++i) {
                    arrarrby2[n3][i] = n2 = (int)((byte)(n2 + Gg3.ax(gg3)));
                }
            }
            this.q = new byte[256][256];
            for (n3 = 0; n3 < 256; ++n3) {
                if (n3 == 32 || n3 == 160) continue;
                for (n2 = 0; n2 < 256; ++n2) {
                    if (n2 == 32 || n2 == 160) continue;
                    this.q[n3][n2] = (byte)Kj334.d(arrarrby, arrarrby2, arrn2, this.d, arrn, n3, n2);
                }
            }
            this.j = arrn2[32] + arrn[32];
        } else {
            this.j = Gg3.ar(gg3);
        }
        this.s = Gg3.ar(gg3);
        this.b = Gg3.ar(gg3);
        this.e = Gg3.ar(gg3);
        this.h = Gg3.ar(gg3);
    }

    public static Kj334 g(js5 js52, int n) {
        byte[] arrby = js5.v(js52, n);
        if (arrby == null) {
            return null;
        }
        return new Kj334(arrby);
    }

    public static int j(Kj334 kj334, int n) {
        return kj334.d[n] & 0xFF;
    }

    static int d(byte[][] arrby, byte[][] arrby2, int[] arrn, byte[] arrby3, int[] arrn2, int n, int n2) {
        int n3;
        int n4 = arrn[n];
        int n5 = n4 + arrn2[n];
        int n6 = arrn[n2];
        int n7 = n6 + arrn2[n2];
        int n8 = n4;
        if (n6 > n4) {
            n8 = n6;
        }
        int n9 = n5;
        if (n7 < n5) {
            n9 = n7;
        }
        if ((arrby3[n2] & 0xFF) < (n3 = arrby3[n] & 0xFF)) {
            n3 = arrby3[n2] & 0xFF;
        }
        byte[] arrby4 = arrby2[n];
        byte[] arrby5 = arrby[n2];
        int n10 = n8 - n4;
        int n11 = n8 - n6;
        for (int i = n8; i < n9; ++i) {
            int n12;
            if ((n12 = arrby4[n10++] + arrby5[n11++]) >= n3) continue;
            n3 = n12;
        }
        return -n3;
    }

    public Kj334(byte[] arrby, byte[][] arrby2, int n, int n2, int n3, int n4, int n5) {
        this.d = arrby;
        this.q = arrby2;
        this.j = n;
        this.e = n2;
        this.h = n3;
        this.s = n4;
        this.b = n5;
    }

    public static int e(Kj334 kj334, String string) {
        return Kj334.h(kj334, string, null);
    }

    public static int h(Kj334 kj334, String string, Km535[] arrkm535) {
        if (string == null) {
            return 0;
        }
        int n = -1;
        int n2 = -1;
        int n3 = 0;
        int n4 = string.length();
        for (int i = 0; i < n4; ++i) {
            int n5 = string.charAt(i);
            if (n5 == 60) {
                n = i;
                continue;
            }
            if (n5 == 62 && n != -1) {
                String string2 = string.substring(n + 1, i);
                n = -1;
                if (string2.equals("lt")) {
                    n5 = 60;
                } else if (string2.equals("gt")) {
                    n5 = 62;
                } else if (string2.equals("nbsp")) {
                    n5 = 160;
                } else if (string2.equals("shy")) {
                    n5 = 173;
                } else if (string2.equals("times")) {
                    n5 = 215;
                } else if (string2.equals("euro")) {
                    n5 = 8364;
                } else if (string2.equals("copy")) {
                    n5 = 169;
                } else if (string2.equals("reg")) {
                    n5 = 174;
                } else {
                    if (!string2.startsWith("img=") || arrkm535 == null) continue;
                    try {
                        int n6 = StringTools.j(string2.substring(4));
                        n3 += arrkm535[n6].q();
                        n2 = -1;
                    }
                    catch (Exception exception) {}
                    continue;
                }
            }
            if (n != -1) continue;
            n3 += kj334.d[J173.g((char)n5) & 0xFF] & 0xFF;
            if (kj334.q != null && n2 != -1) {
                n3 += kj334.q[n2][n5];
            }
            n2 = n5;
        }
        return n3;
    }

    public static int q(Kj334 kj334, int n, char c) {
        if (kj334.q != null) {
            return kj334.q[n][c];
        }
        return 0;
    }
}

