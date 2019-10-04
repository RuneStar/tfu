/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.BitSet;
import tfu.Dt575;
import tfu.Gg3;
import tfu.Ln265;

public class Dr574
extends Ln265 {
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
    public String k = null;
    private int[] m;
    public long n;
    public byte o;
    public int t = 0;
    boolean u = true;
    boolean x;
    public Dt575[] z;

    protected static void q(Dr574 dr574, int n) {
        --dr574.t;
        if (dr574.t == 0) {
            dr574.z = null;
        } else {
            System.arraycopy(dr574.z, n + 1, dr574.z, n, dr574.t - n);
        }
        dr574.m = null;
    }

    static {
        g = false;
        f = new BitSet(65536);
    }

    public Dr574(Gg3 gg3) {
        this.j(gg3);
    }

    public Dr574(long l, boolean bl, boolean bl2) {
        this.bq = l;
        this.x = bl;
        this.u = bl2;
    }

    public void j(Gg3 gg3) {
        int n = Gg3.ar(gg3);
        if ((n & 1) != 0) {
            this.x = true;
        }
        if ((n & 2) != 0) {
            this.u = true;
        }
        int n2 = 2;
        if ((n & 4) != 0) {
            n2 = Gg3.ar(gg3);
        }
        this.bq = Gg3.bq(gg3);
        this.n = Gg3.bq(gg3);
        this.k = Gg3.bk(gg3);
        this.i = Gg3.ar(gg3) == 1;
        this.a = Gg3.ax(gg3);
        this.o = Gg3.ax(gg3);
        this.t = Gg3.au(gg3);
        if (this.t > 0) {
            this.z = new Dt575[this.t];
            for (int i = 0; i < this.t; ++i) {
                Dt575 dt575 = new Dt575();
                if (this.x) {
                    dt575.g = Gg3.bq(gg3);
                }
                if (this.u) {
                    dt575.j = Gg3.bk(gg3);
                }
                dt575.d = Gg3.ax(gg3);
                dt575.q = Gg3.au(gg3);
                dt575.h = n2 >= 3 ? Gg3.ar(gg3) == 1 : false;
                this.z[i] = dt575;
            }
        }
    }

    public String e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Clan Name: ").append(this.k).append("\nRank Kick: ").append(this.a).append(",  Talk: ").append(this.o).append("\nUsers:");
        for (int i = 0; i < this.t; ++i) {
            Dt575 dt575 = this.z[i];
            stringBuilder.append("\n").append(dt575.j);
        }
        return stringBuilder.toString();
    }

    static void d(Dr574 dr574, Dt575 dt575) {
        if (dr574.z == null || dr574.t >= dr574.z.length) {
            Dr574.g(dr574, dr574.t + 5);
        }
        dr574.z[dr574.t++] = dt575;
        dr574.m = null;
    }

    private static void g(Dr574 dr574, int n) {
        if (dr574.z != null) {
            dr574.z = new Dt575[n];
            System.arraycopy(dr574.z, 0, dr574.z, 0, dr574.t);
        } else {
            dr574.z = new Dt575[n];
        }
    }
}

