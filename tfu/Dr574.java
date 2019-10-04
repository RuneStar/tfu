// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.BitSet;

public class Dr574 extends Ln265
{
    public static final int b = 4;
    public static final boolean d = false;
    public static final int e = 1;
    private static final BitSet f;
    public static boolean g;
    public static final int h = 2;
    public static final int j = 1;
    public static final int l = 5;
    public static final int p = 3600000;
    public static final int q = 3;
    public static final int r = 7;
    public static final int s = 3;
    public static final int v = 8;
    public static final int w = 6;
    public static final int y = 100;
    public byte a;
    public boolean i;
    public String k;
    private int[] m;
    public long n;
    public byte o;
    public int t;
    boolean u;
    boolean x;
    public Dt575[] z;
    
    protected static void q(final Dr574 dr574, final int n) {
        --dr574.t;
        if (dr574.t == 0) {
            dr574.z = null;
        }
        else {
            System.arraycopy(dr574.z, n + 1, dr574.z, n, dr574.t - n);
        }
        dr574.m = null;
    }
    
    static {
        Dr574.g = false;
        f = new BitSet(65536);
    }
    
    public Dr574(final Gg3 gg3) {
        this.u = true;
        this.t = 0;
        this.k = null;
        this.j(gg3);
    }
    
    public Dr574(final long bq, final boolean x, final boolean u) {
        this.u = true;
        this.t = 0;
        this.k = null;
        super.bq = bq;
        this.x = x;
        this.u = u;
    }
    
    public void j(final Gg3 gg3) {
        final int ar = Gg3.ar(gg3);
        if ((ar & 0x1) != 0x0) {
            this.x = true;
        }
        if ((ar & 0x2) != 0x0) {
            this.u = true;
        }
        int ar2 = 2;
        if ((ar & 0x4) != 0x0) {
            ar2 = Gg3.ar(gg3);
        }
        super.bq = Gg3.bq(gg3);
        this.n = Gg3.bq(gg3);
        this.k = Gg3.bk(gg3);
        this.i = (Gg3.ar(gg3) == 1);
        this.a = Gg3.ax(gg3);
        this.o = Gg3.ax(gg3);
        this.t = Gg3.au(gg3);
        if (this.t > 0) {
            this.z = new Dt575[this.t];
            for (int i = 0; i < this.t; ++i) {
                final Dt575 dt575 = new Dt575();
                if (this.x) {
                    dt575.g = Gg3.bq(gg3);
                }
                if (this.u) {
                    dt575.j = Gg3.bk(gg3);
                }
                dt575.d = Gg3.ax(gg3);
                dt575.q = Gg3.au(gg3);
                if (ar2 >= 3) {
                    dt575.h = (Gg3.ar(gg3) == 1);
                }
                else {
                    dt575.h = false;
                }
                this.z[i] = dt575;
            }
        }
    }
    
    public String e() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Clan Name: ").append(this.k).append("\nRank Kick: ").append(this.a).append(",  Talk: ").append(this.o).append("\nUsers:");
        for (int i = 0; i < this.t; ++i) {
            sb.append("\n").append(this.z[i].j);
        }
        return sb.toString();
    }
    
    static void d(final Dr574 dr574, final Dt575 dt575) {
        if (dr574.z == null || dr574.t >= dr574.z.length) {
            g(dr574, dr574.t + 5);
        }
        dr574.z[dr574.t++] = dt575;
        dr574.m = null;
    }
    
    private static void g(final Dr574 dr574, final int n) {
        if (dr574.z != null) {
            System.arraycopy(dr574.z, 0, dr574.z = new Dt575[n], 0, dr574.t);
        }
        else {
            dr574.z = new Dt575[n];
        }
    }
}
