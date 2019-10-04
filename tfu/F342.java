/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.stringtools.general.J173;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.jnibindings.runetek6.Graphics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.A672;
import tfu.Fb341;
import tfu.Fj373;
import tfu.Fm462;
import tfu.Fy467;
import tfu.H149;
import tfu.Kc180;
import tfu.Kj334;

public class F342 {
    public static final int b = 2;
    public static final int h = 0;
    private static String[] i;
    public static final boolean j = false;
    private static int k;
    public static final int l = 3;
    private static final Logger logger;
    private static int m;
    private static int n;
    private static int p;
    public static final int r = 1;
    public static final int s = 1;
    private static int t;
    private static int u;
    public static final int v = 2;
    public static final int w = 0;
    private static int x;
    public static final int y = 3;
    private static int z;
    long d = 0L;
    protected Kj334 e;
    private byte[] o = new byte[512];
    int q = 0;

    static {
        logger = LoggerFactory.getLogger(F342.class);
        p = -1;
        x = -1;
        u = 0;
        z = 0;
        t = 0;
        m = 0;
        n = 0;
        k = 0;
        i = new String[100];
    }

    private static void q(F342 f342, int n, int n2) {
        p = -1;
        x = -1;
        z = u = n;
        F342.n = 0;
        k = 0;
        if (n2 == -1) {
            n2 = 0;
        }
        m = t = n2;
    }

    public static void g(F342 f342, String string, int n, int n2, int n3, int n4) {
        if (string == null) {
            return;
        }
        F342.q(f342, n3, n4);
        F342.e(f342, string, n, n2, null, null, null, 0, 0);
    }

    private static void e(F342 f342, String string, int n, int n2, A672[] arra672, int[] arrn, Fm462 fm462, int n3, int n4) {
        n2 -= f342.e.j;
        int n5 = -1;
        char c = '\uffffffff';
        int n6 = string.length();
        for (int i = 0; i < n6; ++i) {
            char c2 = (char)(J173.g(string.charAt(i)) & 0xFF);
            if (c2 == '<') {
                n5 = i;
                continue;
            }
            if (c2 == '>' && n5 != -1) {
                String string2 = string.substring(n5 + 1, i);
                n5 = -1;
                if (string2.equals("lt")) {
                    c2 = '<';
                } else if (string2.equals("gt")) {
                    c2 = '>';
                } else if (string2.equals("nbsp")) {
                    c2 = '\u00a0';
                } else if (string2.equals("shy")) {
                    c2 = '\u00ad';
                } else if (string2.equals("times")) {
                    c2 = '\u00d7';
                } else if (string2.equals("euro")) {
                    c2 = '\u20ac';
                } else if (string2.equals("copy")) {
                    c2 = '\u00a9';
                } else if (string2.equals("reg")) {
                    c2 = '\u00ae';
                } else {
                    if (string2.startsWith("img=")) {
                        try {
                            int n7;
                            int n8 = StringTools.j(string2.substring(4));
                            A672 a672 = arra672[n8];
                            int n9 = n7 = arrn != null ? arrn[n8] : a672.j();
                            if ((z & 0xFF000000) == -16777216) {
                                A672.e(a672, n, n2 + f342.e.j - n7, Fy467.PREBLEND_NORMAL, 0, Fb341.BLEND_NORMAL);
                            } else {
                                A672.e(a672, n, n2 + f342.e.j - n7, Fy467.PREBLEND_MODULATE, z & 0xFF000000 | 0xFFFFFF, Fb341.BLEND_NORMAL);
                            }
                            n += arra672[n8].q();
                            c = '\uffffffff';
                        }
                        catch (Exception exception) {}
                        continue;
                    }
                    F342.j(f342, string2);
                    continue;
                }
            }
            if (n5 != -1) continue;
            if (c != '\uffffffff') {
                n += Kj334.q(f342.e, c, c2);
            }
            if (c2 != ' ') {
                if (fm462 == null) {
                    if ((m & 0xFF000000) != 0) {
                        F342.h(f342, c2, n + 1, n2 + 1, m, true);
                    }
                    F342.h(f342, c2, n, n2, z, false);
                } else {
                    if ((m & 0xFF000000) != 0) {
                        F342.s(f342, c2, n + 1, n2 + 1, m, true, fm462, n3, n4);
                    }
                    F342.s(f342, c2, n, n2, z, false, fm462, n3, n4);
                }
            } else if (F342.n > 0) {
                n += (k += F342.n) >> 8;
                k &= 0xFF;
            }
            int n10 = Kj334.j(f342.e, c2);
            n += n10;
            c = c2;
        }
    }

    protected static void h(F342 f342, char c, int n, int n2, int n3, boolean bl) {
        int n4 = f342.q / 16;
        int n5 = f342.q / 16;
        H149.s(n += f342.o[c * 2], n2 += f342.o[c * 2 + 1], n + n4, n2 + n5, (float)(c % 16) / 16.0f, (float)(c / 16) / 16.0f, (float)(c % 16 + 1) / 16.0f, (float)(c / 16 + 1) / 16.0f, f342.d, n3);
    }

    protected static void s(F342 f342, char c, int n, int n2, int n3, boolean bl, Fm462 fm462, int n4, int n5) {
    }

    public static void d(F342 f342, String string, int n, int n2, int n3, int n4) {
        if (string == null) {
            return;
        }
        F342.q(f342, n3, n4);
        F342.e(f342, string, n - Kj334.e(f342.e, string), n2, null, null, null, 0, 0);
    }

    private static void j(F342 f342, String string) {
        try {
            if (string.startsWith("col=")) {
                z = z & 0xFF000000 | StringTools.e(string.substring(4), 16) & 0xFFFFFF;
            } else if (string.equals("/col")) {
                z = z & 0xFF000000 | u & 0xFFFFFF;
            }
            if (string.startsWith("argb=")) {
                z = StringTools.e(string.substring(5), 16);
            } else if (string.equals("/argb")) {
                z = u;
            } else if (string.startsWith("str=")) {
                p = z & 0xFF000000 | StringTools.e(string.substring(4), 16);
            } else if (string.equals("str")) {
                p = z & 0xFF000000 | 0x800000;
            } else if (string.equals("/str")) {
                p = -1;
            } else if (string.startsWith("u=")) {
                x = z & 0xFF000000 | StringTools.e(string.substring(2), 16);
            } else if (string.equals("u")) {
                x = z & 0xFF000000;
            } else if (string.equals("/u")) {
                x = -1;
            } else if (string.equalsIgnoreCase("shad=-1")) {
                m = 0;
            } else if (string.startsWith("shad=")) {
                m = z & 0xFF000000 | StringTools.e(string.substring(5), 16);
            } else if (string.equals("shad")) {
                m = z & 0xFF000000;
            } else if (string.equals("/shad")) {
                m = t;
            } else if (string.equals("br")) {
                F342.q(f342, u, t);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public F342(Kj334 kj334, Fj373[] arrfj373, boolean bl) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        Object object;
        int n6;
        this.e = kj334;
        int n7 = 0;
        for (int i = 0; i < 256; ++i) {
            Fj373 fj373 = arrfj373[i];
            if (fj373.d > n7) {
                n7 = fj373.d;
            }
            if (fj373.g <= n7) continue;
            n7 = fj373.g;
        }
        long l = H149.j;
        this.q = n7 * 16;
        if (bl) {
            int n8;
            byte[] arrby = new byte[this.q * this.q];
            for (n8 = 0; n8 < 256; ++n8) {
                byte[] arrby2;
                object = arrfj373[n8];
                int n9 = object.d;
                int n10 = object.g;
                n4 = n8 % 16 * n7;
                n5 = n8 / 16 * n7;
                n2 = n5 * this.q + n4;
                n6 = 0;
                if (object.l == null) {
                    arrby2 = object.b;
                    for (n = 0; n < n9; ++n) {
                        for (n3 = 0; n3 < n10; ++n3) {
                            arrby[n2++] = (byte)(arrby2[n6++] == 0 ? 0 : -1);
                        }
                        n2 += this.q - n10;
                    }
                    continue;
                }
                arrby2 = object.l;
                for (n = 0; n < n9; ++n) {
                    for (n3 = 0; n3 < n10; ++n3) {
                        arrby[n2++] = arrby2[n6++];
                    }
                    n2 += this.q - n10;
                }
            }
            for (n8 = 0; n8 < arrby.length; ++n8) {
                Kc180.r(l + (long)(n8 * 4), arrby[n8] << 24 | arrby[n8] << 16 | arrby[n8] << 8 | arrby[n8]);
            }
        } else {
            for (int i = 0; i < 256; ++i) {
                int n11;
                byte by;
                Fj373 fj373 = arrfj373[i];
                object = fj373.s;
                byte[] arrby = fj373.l;
                byte[] arrby3 = fj373.b;
                n4 = fj373.d;
                n5 = fj373.g;
                n2 = i % 16 * n7;
                n6 = i / 16 * n7;
                int n12 = n6 * this.q + n2;
                n = 0;
                if (arrby != null) {
                    for (n3 = 0; n3 < n4; ++n3) {
                        for (n11 = 0; n11 < n5; ++n11) {
                            by = (byte)(l + (long)(n12 * 4));
                            Kc180.r(by, arrby[n] << 24 | object[arrby3[n] & 0xFF]);
                            ++n12;
                            ++n;
                        }
                        n12 += this.q - n5;
                    }
                    continue;
                }
                for (n3 = 0; n3 < n4; ++n3) {
                    for (n11 = 0; n11 < n5; ++n11) {
                        if ((by = arrby3[n++]) == 0) continue;
                        long l2 = l + (long)(n12 * 4);
                        Kc180.r(l2, 0xFF000000 | object[by & 0xFF]);
                        ++n12;
                    }
                    n12 += this.q - n5;
                }
            }
        }
        this.d = Graphics.createTexture2D(21, this.q, this.q, 1, 0, l, 1);
        for (int i = 0; i < 256; ++i) {
            Fj373 fj373 = arrfj373[i];
            this.o[i * 2] = (byte)fj373.q;
            this.o[i * 2 + 1] = (byte)fj373.e;
        }
    }
}

