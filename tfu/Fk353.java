// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Fk353 implements Hp62
{
    public static final int d = 6;
    public static final int e = 2047;
    public static final float h = 2048.0f;
    public static final int j = 2048;
    public static final Ia63 k;
    private static final Logger logger;
    public static final int q = 11;
    public int[] b;
    public int[] l;
    public int m;
    public float n;
    public byte[] p;
    public short[] r;
    public int s;
    public int t;
    public int u;
    public short[] v;
    public int[] w;
    public byte[] x;
    public byte[] y;
    public Fp460[] z;
    
    public Fk353(final byte[] array) {
        this.n = 1.0f;
        final Gg3 gg3 = new Gg3(array);
        final Gg3 gg4 = new Gg3(array);
        final Gg3 gg5 = new Gg3(array);
        final Gg3 gg6 = new Gg3(array);
        final Gg3 gg7 = new Gg3(array);
        final Gg3 gg8 = new Gg3(array);
        final Gg3 gg9 = new Gg3(array);
        final Gg3 gg10 = new Gg3(array);
        final Gg3 gg11 = new Gg3(array);
        final int ar = Gg3.ar(gg3);
        if (ar > 6) {
            throw new RuntimeException();
        }
        this.s = Gg3.au(gg3);
        this.u = Gg3.au(gg3);
        Gg3.au(gg3);
        final int ay = Gg3.ay(gg3);
        final int ay2 = Gg3.ay(gg3);
        this.t = Gg3.ay(gg3);
        final int ay3 = Gg3.ay(gg3);
        final int ay4 = Gg3.ay(gg3);
        final int ay5 = Gg3.ay(gg3);
        final int ay6 = Gg3.ay(gg3);
        final int ay7 = Gg3.ay(gg3);
        final int ay8 = Gg3.ay(gg3);
        final int ay9 = Gg3.ay(gg3);
        final int ay10 = Gg3.ay(gg3);
        if (ar >= 6) {
            this.n = Gg3.bl(gg3);
        }
        gg4.v = gg3.v + this.u * ((ar >= 4) ? 6 : 4);
        gg5.v = gg4.v + ay;
        gg6.v = gg5.v + ay * 2;
        gg7.v = gg6.v + ay;
        gg8.v = gg7.v + ay;
        this.z = new Fp460[this.u];
        for (int i = 0; i < this.u; ++i) {
            final int au = Gg3.au(gg3);
            final Fp460[] z = this.z;
            final int n = i;
            final Fp460 fp460 = new Fp460(au);
            z[n] = fp460;
            final Fp460 fp461 = fp460;
            final short[] e = fp461.e;
            final short[] h = fp461.h;
            final short[] s = fp461.s;
            fp461.b = Gg3.au(gg3);
            if (fp461.b == 65535) {
                fp461.b = -1;
            }
            if (ar >= 4) {
                fp461.l = Gg3.au(gg3);
                if (fp461.l == 65535) {
                    fp461.l = -1;
                }
            }
            short n2 = 0;
            short n3 = 0;
            short n4 = 0;
            int n5 = 0;
            for (int j = 0; j < fp461.g; ++j) {
                final int ar2 = Gg3.ar(gg7);
                if (ar2 == 1) {
                    final int n6 = (ar >= 5) ? Gg3.bg(gg8) : Gg3.by(gg8);
                    final int n7 = (ar >= 5) ? Gg3.bg(gg8) : Gg3.by(gg8);
                    final int n8 = (ar >= 5) ? Gg3.bg(gg8) : Gg3.by(gg8);
                    n2 = (short)(n6 + n5);
                    n3 = (short)(n7 + n2);
                    n4 = (short)(n5 = (short)(n8 + n3));
                    e[j] = n2;
                    h[j] = n3;
                    s[j] = n4;
                }
                if (ar2 == 2) {
                    final int n9 = (ar >= 5) ? Gg3.bg(gg8) : Gg3.by(gg8);
                    n3 = n4;
                    n4 = (short)(n5 = (short)(n9 + n5));
                    e[j] = n2;
                    h[j] = n3;
                    s[j] = n4;
                }
                if (ar2 == 3) {
                    final int n10 = (ar >= 5) ? Gg3.bg(gg8) : Gg3.by(gg8);
                    n2 = n4;
                    n4 = (short)(n5 = (short)(n10 + n5));
                    e[j] = n2;
                    h[j] = n3;
                    s[j] = n4;
                }
                if (ar2 == 4) {
                    final int n11 = (ar >= 5) ? Gg3.bg(gg8) : Gg3.by(gg8);
                    final short n12 = n2;
                    n2 = n3;
                    n3 = n12;
                    n4 = (short)(n5 = (short)(n11 + n5));
                    e[j] = n2;
                    h[j] = n3;
                    s[j] = n4;
                }
                fp461.j[j] = Gg3.ax(gg4);
                fp461.d[j] = (short)((ar > 1) ? ((short)Gg3.au(gg5)) : 127);
                fp461.q[j] = (byte)((ar > 1) ? Gg3.ax(gg6) : -1);
                this.m += 3;
            }
        }
        gg3.v = gg8.v;
        gg4.v = gg3.v + this.s;
        gg6.v = gg4.v + ay3;
        gg7.v = gg6.v + ay4;
        gg8.v = gg7.v + ay5;
        gg9.v = gg8.v + ay6;
        this.r = new short[this.s];
        this.v = new short[this.s];
        this.b = new int[this.s];
        this.l = new int[this.s];
        this.w = new int[this.s];
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        if (ar > 1) {
            for (int k = 0; k < this.s; ++k) {
                final int ar3 = Gg3.ar(gg3);
                int bg = 0;
                if ((ar3 & 0x1) != 0x0) {
                    bg = Gg3.bg(gg4);
                }
                int bg2 = 0;
                if ((ar3 & 0x2) != 0x0) {
                    bg2 = Gg3.bg(gg6);
                }
                int bg3 = 0;
                if ((ar3 & 0x4) != 0x0) {
                    bg3 = Gg3.bg(gg7);
                }
                int bg4 = 0;
                if ((ar3 & 0x8) != 0x0) {
                    bg4 = Gg3.bg(gg8);
                }
                int bg5 = 0;
                if ((ar3 & 0x10) != 0x0) {
                    bg5 = Gg3.bg(gg9);
                }
                this.r[k] = (short)(n16 + bg4);
                n16 = this.r[k];
                this.v[k] = (short)(n17 + bg5);
                n17 = this.v[k];
                this.b[k] = n13 + bg;
                n13 = this.b[k];
                this.l[k] = n14 + bg2;
                n14 = this.l[k];
                this.w[k] = n15 + bg3;
                n15 = this.w[k];
            }
        }
        else {
            for (int l = 0; l < this.s; ++l) {
                final int ar4 = Gg3.ar(gg3);
                int by = 0;
                if ((ar4 & 0x1) != 0x0) {
                    by = Gg3.by(gg4);
                }
                int by2 = 0;
                if ((ar4 & 0x2) != 0x0) {
                    by2 = Gg3.by(gg6);
                }
                int by3 = 0;
                if ((ar4 & 0x4) != 0x0) {
                    by3 = Gg3.by(gg7);
                }
                int by4 = 0;
                if ((ar4 & 0x8) != 0x0) {
                    by4 = Gg3.by(gg8);
                }
                int by5 = 0;
                if ((ar4 & 0x10) != 0x0) {
                    by5 = Gg3.by(gg9);
                }
                this.r[l] = (short)(n16 + by4);
                n16 = this.r[l];
                this.v[l] = (short)(n17 + by5);
                n17 = this.v[l];
                this.b[l] = n13 + by;
                n13 = this.b[l];
                this.l[l] = n14 + by2;
                n14 = this.l[l];
                this.w[l] = n15 + by3;
                n15 = this.w[l];
            }
        }
        if (ay2 > 0) {
            this.p = new byte[ay2];
            this.x = new byte[ay2];
            this.y = new byte[this.s];
            gg3.v = gg9.v;
            gg4.v = gg3.v + this.s;
            gg5.v = gg4.v + ay7;
            gg6.v = gg5.v + ay8;
            gg7.v = gg6.v + ay9;
            gg8.v = gg7.v + ay10;
            gg9.v = gg8.v + ay7;
            gg10.v = gg9.v + ay8;
            gg11.v = gg10.v + ay9;
            int n18 = 0;
            for (int n19 = 0; n19 < this.s; ++n19) {
                final byte[] y = this.y;
                final int n20 = n19;
                final byte ax = Gg3.ax(gg3);
                y[n20] = ax;
                final byte b = ax;
                if (b > 0) {
                    this.p[n18] = Gg3.ax(gg4);
                    this.x[n18] = Gg3.ax(gg8);
                    ++n18;
                }
                if (b > 1) {
                    this.p[n18] = Gg3.ax(gg5);
                    this.x[n18] = Gg3.ax(gg9);
                    ++n18;
                }
                if (b > 2) {
                    this.p[n18] = Gg3.ax(gg6);
                    this.x[n18] = Gg3.ax(gg10);
                    ++n18;
                }
                if (b > 3) {
                    this.p[n18] = Gg3.ax(gg7);
                    this.x[n18] = Gg3.ax(gg11);
                    ++n18;
                }
            }
        }
    }
    
    @Override
    public void onAllRefsReleased() {
    }
    
    static {
        i = !Fk353.class.desiredAssertionStatus();
        logger = LoggerFactory.getLogger(Fk353.class);
        k = new Fu461();
    }
    
    public Fk353() {
        this.n = 1.0f;
    }
}
