// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;
import java.io.IOException;

public class Cg550 extends Ln265
{
    private static float[] a;
    private static int[] af;
    private static float[] ag;
    private static float[] ai;
    private static float[] al;
    private static float[] aq;
    private static int[] av;
    private static byte[] b;
    private static float[] c;
    private static float[] f;
    private static final boolean g = false;
    private static int l;
    private static boolean m;
    private static Cy632[] p;
    private static int r;
    private static int[] t;
    private static Ck642[] u;
    private static int v;
    private static int w;
    private static Ct636[] x;
    static Cn647[] y;
    private static boolean[] z;
    private int aa;
    private int ah;
    private int am;
    private int an;
    private float[] ao;
    private int ap;
    private byte[] az;
    private byte[][] d;
    private int e;
    private int h;
    private int i;
    public int j;
    private int k;
    private float[] n;
    private boolean o;
    private int q;
    private boolean s;
    
    private void e(final byte[] array) throws IOException {
        final Gg3 gg3 = new Gg3(array);
        this.q = Gg3.bd(gg3);
        this.j = Gg3.bd(gg3);
        this.e = Gg3.bd(gg3);
        this.h = Gg3.bd(gg3);
        if (this.h < 0) {
            this.h ^= -1;
            this.s = true;
        }
        final int bd = Gg3.bd(gg3);
        if (bd < 0) {
            throw new IOException();
        }
        this.d = new byte[bd][];
        for (int i = 0; i < bd; ++i) {
            int n = 0;
            int ar;
            do {
                ar = Gg3.ar(gg3);
                n += ar;
            } while (ar >= 255);
            final byte[] array2 = new byte[n];
            Gg3.bx(gg3, array2, 0, n);
            this.d[i] = array2;
        }
    }
    
    static void d(final byte[] b, final int l) {
        Cg550.b = b;
        Cg550.l = l;
        Cg550.w = 0;
    }
    
    static int q() {
        final int n = Cg550.b[Cg550.l] >> Cg550.w & 0x1;
        ++Cg550.w;
        Cg550.l += Cg550.w >> 3;
        Cg550.w &= 0x7;
        return n;
    }
    
    static int j(int i) {
        int n = 0;
        int n2 = 0;
        while (i >= 8 - Cg550.w) {
            final int n3 = 8 - Cg550.w;
            n += (Cg550.b[Cg550.l] >> Cg550.w & (1 << n3) - 1) << n2;
            Cg550.w = 0;
            ++Cg550.l;
            n2 += n3;
            i -= n3;
        }
        if (i > 0) {
            n += (Cg550.b[Cg550.l] >> Cg550.w & (1 << i) - 1) << n2;
            Cg550.w += i;
        }
        return n;
    }
    
    public Cg550(final byte[] array) throws IOException {
        this.aa = 0;
        this.am = 0;
        this.e(array);
    }
    
    public static void h(final byte[] array) {
        d(array, 0);
        Cg550.r = 1 << j(4);
        Cg550.v = 1 << j(4);
        Cg550.a = new float[Cg550.v];
        for (int i = 0; i < 2; ++i) {
            final int n = (i != 0) ? Cg550.v : Cg550.r;
            final int n2 = n >> 1;
            final int n3 = n >> 2;
            final int n4 = n >> 3;
            final float[] array2 = new float[n2];
            for (int j = 0; j < n3; ++j) {
                array2[2 * j] = (float)Math.cos(4 * j * 3.141592653589793 / n);
                array2[2 * j + 1] = -(float)Math.sin(4 * j * 3.141592653589793 / n);
            }
            final float[] array3 = new float[n2];
            for (int k = 0; k < n3; ++k) {
                array3[2 * k] = (float)Math.cos((2 * k + 1) * 3.141592653589793 / (2 * n));
                array3[2 * k + 1] = (float)Math.sin((2 * k + 1) * 3.141592653589793 / (2 * n));
            }
            final float[] array4 = new float[n3];
            for (int l = 0; l < n4; ++l) {
                array4[2 * l] = (float)Math.cos((4 * l + 2) * 3.141592653589793 / n);
                array4[2 * l + 1] = -(float)Math.sin((4 * l + 2) * 3.141592653589793 / n);
            }
            final int[] array5 = new int[n4];
            final int s = Jz233.s(n4 - 1);
            for (int n5 = 0; n5 < n4; ++n5) {
                array5[n5] = Jz233.b(n5, s);
            }
            if (i != 0) {
                Cg550.aq = array2;
                Cg550.ai = array3;
                Cg550.al = array4;
                Cg550.av = array5;
            }
            else {
                Cg550.f = array2;
                Cg550.c = array3;
                Cg550.ag = array4;
                Cg550.af = array5;
            }
        }
        final int n6 = j(8) + 1;
        Cg550.y = new Cn647[n6];
        for (int n7 = 0; n7 < n6; ++n7) {
            Cg550.y[n7] = new Cn647();
        }
        for (int n8 = j(6) + 1, n9 = 0; n9 < n8; ++n9) {
            j(16);
        }
        final int n10 = j(6) + 1;
        Cg550.p = new Cy632[n10];
        for (int n11 = 0; n11 < n10; ++n11) {
            Cg550.p[n11] = new Cy632();
        }
        final int n12 = j(6) + 1;
        Cg550.x = new Ct636[n12];
        for (int n13 = 0; n13 < n12; ++n13) {
            Cg550.x[n13] = new Ct636();
        }
        final int n14 = j(6) + 1;
        Cg550.u = new Ck642[n14];
        for (int n15 = 0; n15 < n14; ++n15) {
            Cg550.u[n15] = new Ck642();
        }
        final int n16 = j(6) + 1;
        Cg550.z = new boolean[n16];
        Cg550.t = new int[n16];
        for (int n17 = 0; n17 < n16; ++n17) {
            Cg550.z[n17] = (q() != 0);
            j(16);
            j(16);
            Cg550.t[n17] = j(8);
        }
        Cg550.m = true;
    }
    
    private static boolean s(final js5 js5) {
        if (!Cg550.m) {
            final byte[] getfile = js5.getfile(0, 0);
            if (getfile == null) {
                return false;
            }
            h(getfile);
        }
        return true;
    }
    
    public static Cg550 b(final js5 js5, final int n, final int n2) {
        if (!s(js5)) {
            js5.requestdownload(n, n2);
            return null;
        }
        final byte[] getfile = js5.getfile(n, n2);
        if (getfile == null) {
            return null;
        }
        Cg550 cg550 = null;
        try {
            cg550 = new Cg550(getfile);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return cg550;
    }
    
    public static int w(final Cg550 cg550) {
        return cg550.aa;
    }
    
    public static boolean r(final Cg550 cg550) {
        return cg550.aa < cg550.j - 1;
    }
    
    static {
        Cg550.m = false;
    }
    
    public Ci646 l() {
        Cr641.g(this);
        if (!r(this) || (this.aa > this.q && this.am > this.q / Dl463.x())) {
            return new Ci646(this.q, this, this.ao, this.e, this.h, this.s);
        }
        return null;
    }
    
    static float g(final int n) {
        int n2 = n & 0x1FFFFF;
        final int n3 = n & Integer.MIN_VALUE;
        final int n4 = (n & 0x7FE00000) >> 21;
        if (n3 != 0) {
            n2 = -n2;
        }
        return (float)(n2 * Math.pow(2.0, n4 - 788));
    }
}
