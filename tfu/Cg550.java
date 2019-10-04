/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import java.io.IOException;
import tfu.Ci646;
import tfu.Ck642;
import tfu.Cn647;
import tfu.Cr641;
import tfu.Ct636;
import tfu.Cy632;
import tfu.Dl463;
import tfu.Gg3;
import tfu.Jz233;
import tfu.Ln265;

public class Cg550
extends Ln265 {
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
    private int aa = 0;
    private int ah;
    private int am = 0;
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

    private void e(byte[] arrby) throws IOException {
        int n;
        Gg3 gg3 = new Gg3(arrby);
        this.q = Gg3.bd(gg3);
        this.j = Gg3.bd(gg3);
        this.e = Gg3.bd(gg3);
        this.h = Gg3.bd(gg3);
        if (this.h < 0) {
            this.h ^= 0xFFFFFFFF;
            this.s = true;
        }
        if ((n = Gg3.bd(gg3)) < 0) {
            throw new IOException();
        }
        this.d = new byte[n][];
        for (int i = 0; i < n; ++i) {
            int n2;
            int n3 = 0;
            do {
                n2 = Gg3.ar(gg3);
                n3 += n2;
            } while (n2 >= 255);
            byte[] arrby2 = new byte[n3];
            Gg3.bx(gg3, arrby2, 0, n3);
            this.d[i] = arrby2;
        }
    }

    static void d(byte[] arrby, int n) {
        b = arrby;
        l = n;
        w = 0;
    }

    static int q() {
        int n = b[l] >> w & 1;
        l += ++w >> 3;
        w &= 7;
        return n;
    }

    static int j(int n) {
        int n2;
        int n3 = 0;
        int n4 = 0;
        while (n >= 8 - w) {
            n2 = 8 - w;
            int n5 = (1 << n2) - 1;
            n3 += (b[l] >> w & n5) << n4;
            w = 0;
            ++l;
            n4 += n2;
            n -= n2;
        }
        if (n > 0) {
            n2 = (1 << n) - 1;
            n3 += (b[l] >> w & n2) << n4;
            w += n;
        }
        return n3;
    }

    public Cg550(byte[] arrby) throws IOException {
        this.e(arrby);
    }

    public static void h(byte[] arrby) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        Cg550.d(arrby, 0);
        r = 1 << Cg550.j(4);
        v = 1 << Cg550.j(4);
        a = new float[v];
        for (n = 0; n < 2; ++n) {
            n4 = n != 0 ? v : r;
            n5 = n4 >> 1;
            n2 = n4 >> 2;
            n3 = n4 >> 3;
            float[] arrf = new float[n5];
            for (int i = 0; i < n2; ++i) {
                arrf[2 * i] = (float)Math.cos((double)(4 * i) * 3.141592653589793 / (double)n4);
                arrf[2 * i + 1] = -((float)Math.sin((double)(4 * i) * 3.141592653589793 / (double)n4));
            }
            float[] arrf2 = new float[n5];
            for (int i = 0; i < n2; ++i) {
                arrf2[2 * i] = (float)Math.cos((double)(2 * i + 1) * 3.141592653589793 / (double)(2 * n4));
                arrf2[2 * i + 1] = (float)Math.sin((double)(2 * i + 1) * 3.141592653589793 / (double)(2 * n4));
            }
            float[] arrf3 = new float[n2];
            for (int i = 0; i < n3; ++i) {
                arrf3[2 * i] = (float)Math.cos((double)(4 * i + 2) * 3.141592653589793 / (double)n4);
                arrf3[2 * i + 1] = -((float)Math.sin((double)(4 * i + 2) * 3.141592653589793 / (double)n4));
            }
            int[] arrn = new int[n3];
            int n6 = Jz233.s(n3 - 1);
            for (int i = 0; i < n3; ++i) {
                arrn[i] = Jz233.b(i, n6);
            }
            if (n != 0) {
                aq = arrf;
                ai = arrf2;
                al = arrf3;
                av = arrn;
                continue;
            }
            f = arrf;
            c = arrf2;
            ag = arrf3;
            af = arrn;
        }
        n = Cg550.j(8) + 1;
        y = new Cn647[n];
        for (n4 = 0; n4 < n; ++n4) {
            Cg550.y[n4] = new Cn647();
        }
        n4 = Cg550.j(6) + 1;
        for (n5 = 0; n5 < n4; ++n5) {
            Cg550.j(16);
        }
        n4 = Cg550.j(6) + 1;
        p = new Cy632[n4];
        for (n5 = 0; n5 < n4; ++n5) {
            Cg550.p[n5] = new Cy632();
        }
        n5 = Cg550.j(6) + 1;
        x = new Ct636[n5];
        for (n2 = 0; n2 < n5; ++n2) {
            Cg550.x[n2] = new Ct636();
        }
        n2 = Cg550.j(6) + 1;
        u = new Ck642[n2];
        for (n3 = 0; n3 < n2; ++n3) {
            Cg550.u[n3] = new Ck642();
        }
        n3 = Cg550.j(6) + 1;
        z = new boolean[n3];
        t = new int[n3];
        for (int i = 0; i < n3; ++i) {
            Cg550.z[i] = Cg550.q() != 0;
            Cg550.j(16);
            Cg550.j(16);
            Cg550.t[i] = Cg550.j(8);
        }
        m = true;
    }

    private static boolean s(js5 js52) {
        if (!m) {
            byte[] arrby = js52.getfile(0, 0);
            if (arrby == null) {
                return false;
            }
            Cg550.h(arrby);
        }
        return true;
    }

    public static Cg550 b(js5 js52, int n, int n2) {
        if (!Cg550.s(js52)) {
            js52.requestdownload(n, n2);
            return null;
        }
        byte[] arrby = js52.getfile(n, n2);
        if (arrby == null) {
            return null;
        }
        Cg550 cg550 = null;
        try {
            cg550 = new Cg550(arrby);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return cg550;
    }

    public static int w(Cg550 cg550) {
        return cg550.aa;
    }

    public static boolean r(Cg550 cg550) {
        return cg550.aa < cg550.j - 1;
    }

    static {
        m = false;
    }

    public Ci646 l() {
        Cr641.g(this);
        if (!Cg550.r(this) || this.aa > this.q && this.am > this.q / Dl463.x()) {
            return new Ci646(this.q, this, this.ao, this.e, this.h, this.s);
        }
        return null;
    }

    static float g(int n) {
        int n2 = n & 0x1FFFFF;
        int n3 = n & Integer.MIN_VALUE;
        int n4 = (n & 0x7FE00000) >> 21;
        if (n3 != 0) {
            n2 = -n2;
        }
        return (float)((double)n2 * Math.pow(2.0, n4 - 788));
    }
}

