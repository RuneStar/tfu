// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.jnibindings.runetek6.Graphics;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.core.stringtools.general.J173;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class F342
{
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
    long d;
    protected Kj334 e;
    private byte[] o;
    int q;
    
    static {
        logger = LoggerFactory.getLogger(F342.class);
        F342.p = -1;
        F342.x = -1;
        F342.u = 0;
        F342.z = 0;
        F342.t = 0;
        F342.m = 0;
        F342.n = 0;
        F342.k = 0;
        F342.i = new String[100];
    }
    
    private static void q(final F342 f342, final int n, int t) {
        F342.p = -1;
        F342.x = -1;
        F342.u = n;
        F342.z = n;
        F342.n = 0;
        F342.k = 0;
        if (t == -1) {
            t = 0;
        }
        F342.m = (F342.t = t);
    }
    
    public static void g(final F342 f342, final String s, final int n, final int n2, final int n3, final int n4) {
        if (s == null) {
            return;
        }
        q(f342, n3, n4);
        e(f342, s, n, n2, null, null, null, 0, 0);
    }
    
    private static void e(final F342 f342, final String s, int n, int n2, final A672[] array, final int[] array2, final Fm462 fm462, final int n3, final int n4) {
        n2 -= f342.e.j;
        int n5 = -1;
        int n6 = -1;
        for (int length = s.length(), i = 0; i < length; ++i) {
            char c = (char)(J173.g(s.charAt(i)) & 0xFF);
            if (c == '<') {
                n5 = i;
            }
            else {
                if (c == '>' && n5 != -1) {
                    final String substring = s.substring(n5 + 1, i);
                    n5 = -1;
                    if (substring.equals("lt")) {
                        c = '<';
                    }
                    else if (substring.equals("gt")) {
                        c = '>';
                    }
                    else if (substring.equals("nbsp")) {
                        c = ' ';
                    }
                    else if (substring.equals("shy")) {
                        c = '\u00ad';
                    }
                    else if (substring.equals("times")) {
                        c = '\u00d7';
                    }
                    else if (substring.equals("euro")) {
                        c = '\u20ac';
                    }
                    else if (substring.equals("copy")) {
                        c = '©';
                    }
                    else if (substring.equals("reg")) {
                        c = '®';
                    }
                    else {
                        if (substring.startsWith("img=")) {
                            try {
                                final int j = StringTools.j(substring.substring(4));
                                final A672 a672 = array[j];
                                final int n7 = (array2 != null) ? array2[j] : a672.j();
                                if ((F342.z & 0xFF000000) == 0xFF000000) {
                                    A672.e(a672, n, n2 + f342.e.j - n7, Fy467.PREBLEND_NORMAL, 0, Fb341.BLEND_NORMAL);
                                }
                                else {
                                    A672.e(a672, n, n2 + f342.e.j - n7, Fy467.PREBLEND_MODULATE, (F342.z & 0xFF000000) | 0xFFFFFF, Fb341.BLEND_NORMAL);
                                }
                                n += array[j].q();
                                n6 = -1;
                            }
                            catch (Exception ex) {}
                            continue;
                        }
                        j(f342, substring);
                        continue;
                    }
                }
                if (n5 == -1) {
                    if (n6 != -1) {
                        n += Kj334.q(f342.e, n6, c);
                    }
                    if (c != ' ') {
                        if (fm462 == null) {
                            if ((F342.m & 0xFF000000) != 0x0) {
                                h(f342, c, n + 1, n2 + 1, F342.m, true);
                            }
                            h(f342, c, n, n2, F342.z, false);
                        }
                        else {
                            if ((F342.m & 0xFF000000) != 0x0) {
                                s(f342, c, n + 1, n2 + 1, F342.m, true, fm462, n3, n4);
                            }
                            s(f342, c, n, n2, F342.z, false, fm462, n3, n4);
                        }
                    }
                    else if (F342.n > 0) {
                        F342.k += F342.n;
                        n += F342.k >> 8;
                        F342.k &= 0xFF;
                    }
                    n += Kj334.j(f342.e, c);
                    n6 = c;
                }
            }
        }
    }
    
    protected static void h(final F342 f342, final char c, int n, int n2, final int n3, final boolean b) {
        final int n4 = f342.q / 16;
        final int n5 = f342.q / 16;
        n += f342.o[c * '\u0002'];
        n2 += f342.o[c * '\u0002' + 1];
        H149.s((float)n, (float)n2, (float)(n + n4), (float)(n2 + n5), c % '\u0010' / 16.0f, c / '\u0010' / 16.0f, (c % '\u0010' + 1) / 16.0f, (c / '\u0010' + 1) / 16.0f, f342.d, n3);
    }
    
    protected static void s(final F342 f342, final char c, final int n, final int n2, final int n3, final boolean b, final Fm462 fm462, final int n4, final int n5) {
    }
    
    public static void d(final F342 f342, final String s, final int n, final int n2, final int n3, final int n4) {
        if (s == null) {
            return;
        }
        q(f342, n3, n4);
        e(f342, s, n - Kj334.e(f342.e, s), n2, null, null, null, 0, 0);
    }
    
    private static void j(final F342 f342, final String s) {
        try {
            if (s.startsWith("col=")) {
                F342.z = ((F342.z & 0xFF000000) | (StringTools.e(s.substring(4), 16) & 0xFFFFFF));
            }
            else if (s.equals("/col")) {
                F342.z = ((F342.z & 0xFF000000) | (F342.u & 0xFFFFFF));
            }
            if (s.startsWith("argb=")) {
                F342.z = StringTools.e(s.substring(5), 16);
            }
            else if (s.equals("/argb")) {
                F342.z = F342.u;
            }
            else if (s.startsWith("str=")) {
                F342.p = ((F342.z & 0xFF000000) | StringTools.e(s.substring(4), 16));
            }
            else if (s.equals("str")) {
                F342.p = ((F342.z & 0xFF000000) | 0x800000);
            }
            else if (s.equals("/str")) {
                F342.p = -1;
            }
            else if (s.startsWith("u=")) {
                F342.x = ((F342.z & 0xFF000000) | StringTools.e(s.substring(2), 16));
            }
            else if (s.equals("u")) {
                F342.x = (F342.z & 0xFF000000);
            }
            else if (s.equals("/u")) {
                F342.x = -1;
            }
            else if (s.equalsIgnoreCase("shad=-1")) {
                F342.m = 0;
            }
            else if (s.startsWith("shad=")) {
                F342.m = ((F342.z & 0xFF000000) | StringTools.e(s.substring(5), 16));
            }
            else if (s.equals("shad")) {
                F342.m = (F342.z & 0xFF000000);
            }
            else if (s.equals("/shad")) {
                F342.m = F342.t;
            }
            else if (s.equals("br")) {
                q(f342, F342.u, F342.t);
            }
        }
        catch (Exception ex) {}
    }
    
    public F342(final Kj334 e, final Fj373[] array, final boolean b) {
        this.d = 0L;
        this.q = 0;
        this.o = new byte[512];
        this.e = e;
        int n = 0;
        for (int i = 0; i < 256; ++i) {
            final Fj373 fj373 = array[i];
            if (fj373.d > n) {
                n = fj373.d;
            }
            if (fj373.g > n) {
                n = fj373.g;
            }
        }
        final long j = H149.j;
        this.q = n * 16;
        if (b) {
            final byte[] array2 = new byte[this.q * this.q];
            for (int k = 0; k < 256; ++k) {
                final Fj373 fj374 = array[k];
                final int d = fj374.d;
                final int g = fj374.g;
                int n2 = k / 16 * n * this.q + k % 16 * n;
                int n3 = 0;
                if (fj374.l == null) {
                    final byte[] b2 = fj374.b;
                    for (int l = 0; l < d; ++l) {
                        for (int n4 = 0; n4 < g; ++n4) {
                            array2[n2++] = (byte)((b2[n3++] == 0) ? 0 : -1);
                        }
                        n2 += this.q - g;
                    }
                }
                else {
                    final byte[] m = fj374.l;
                    for (int n5 = 0; n5 < d; ++n5) {
                        for (int n6 = 0; n6 < g; ++n6) {
                            array2[n2++] = m[n3++];
                        }
                        n2 += this.q - g;
                    }
                }
            }
            for (int n7 = 0; n7 < array2.length; ++n7) {
                Kc180.r(j + n7 * 4, array2[n7] << 24 | array2[n7] << 16 | array2[n7] << 8 | array2[n7]);
            }
        }
        else {
            for (int n8 = 0; n8 < 256; ++n8) {
                final Fj373 fj375 = array[n8];
                final int[] s = fj375.s;
                final byte[] l2 = fj375.l;
                final byte[] b3 = fj375.b;
                final int d2 = fj375.d;
                final int g2 = fj375.g;
                int n9 = n8 / 16 * n * this.q + n8 % 16 * n;
                int n10 = 0;
                if (l2 != null) {
                    for (int n11 = 0; n11 < d2; ++n11) {
                        for (int n12 = 0; n12 < g2; ++n12) {
                            Kc180.r(j + n9 * 4, l2[n10] << 24 | s[b3[n10] & 0xFF]);
                            ++n9;
                            ++n10;
                        }
                        n9 += this.q - g2;
                    }
                }
                else {
                    for (int n13 = 0; n13 < d2; ++n13) {
                        for (int n14 = 0; n14 < g2; ++n14) {
                            final byte b4;
                            if ((b4 = b3[n10++]) != 0) {
                                Kc180.r(j + n9 * 4, 0xFF000000 | s[b4 & 0xFF]);
                                ++n9;
                            }
                        }
                        n9 += this.q - g2;
                    }
                }
            }
        }
        this.d = Graphics.createTexture2D(21, this.q, this.q, 1, 0, j, 1);
        for (int n15 = 0; n15 < 256; ++n15) {
            final Fj373 fj376 = array[n15];
            this.o[n15 * 2] = (byte)fj376.q;
            this.o[n15 * 2 + 1] = (byte)fj376.e;
        }
    }
}
