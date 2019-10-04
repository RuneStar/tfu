// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Arrays;

public class Cd585
{
    private static final int ag = 8;
    public static boolean ah;
    private static final int ai = 4;
    private static final int al = 286331153;
    private static boolean ap;
    private static final int aq = 2;
    private static int b;
    private static final int c = 3;
    private static final boolean d = false;
    private static final boolean g = true;
    public static int h;
    private static final boolean j = true;
    private static Cq640 l;
    private static final boolean q = false;
    private static final int r = 16384;
    public static boolean s;
    public static final int w = 256;
    private long a;
    private int af;
    private Cx556[] av;
    private Cx556[] az;
    private boolean e;
    private boolean f;
    private int i;
    private int k;
    private int m;
    private long n;
    private int o;
    private Cx556 p;
    private int t;
    private long u;
    int[] v;
    public int x;
    boolean y;
    private int z;
    
    static void w(final Cd585 cd585) throws Exception {
    }
    
    private static final void j(final Cd585 cd585, final int n) {
        cd585.af -= n;
        if (cd585.af < 0) {
            cd585.af = 0;
        }
        if (cd585.p != null) {
            cd585.p.e(n);
        }
    }
    
    private final void e(final int[] a, final int n) {
        int toIndex = n;
        if (Cd585.s) {
            toIndex <<= 1;
        }
        Arrays.fill(a, 0, toIndex, 0);
        this.af -= n;
        if (this.p != null && this.af <= 0) {
            this.af += Cd585.h >> 4;
            h(this.p);
            s(this, this.p, this.p.cd());
            int n2 = 0;
            int i = 255;
            int n3 = 7;
        Label_0475:
            while (i != 0) {
                int n4;
                int n5;
                if (n3 < 0) {
                    n4 = (n3 & 0x3);
                    n5 = -(n3 >> 2);
                }
                else {
                    n4 = n3;
                    n5 = 0;
                }
                for (int j = i >>> n4 & 0x11111111; j != 0; j >>>= 4) {
                    if ((j & 0x1) != 0x0) {
                        i &= ~(1 << n4);
                        Cx556 cx556 = null;
                        Cx556 ae = this.av[n4];
                        while (ae != null) {
                            final Cb633 bm = ae.bm;
                            if (bm != null && bm.h > n5) {
                                i |= 1 << n4;
                                cx556 = ae;
                                ae = ae.ae;
                            }
                            else {
                                ae.w = true;
                                final int q = ae.q();
                                n2 += q;
                                if (bm != null) {
                                    final Cb633 cb633 = bm;
                                    cb633.h += q;
                                }
                                if (n2 >= this.x) {
                                    break Label_0475;
                                }
                                Cx556 cx557 = ae.g();
                                if (cx557 != null) {
                                    if (Cd585.ap && bm != null && ae.g() != null) {
                                        System.out.println("Warning: a pcm_stream with substreams has set its 'w' - this can cause");
                                        System.out.println("         parent duplicate demotion, and high-pri substreams will be lost!");
                                        System.out.println("         Guilty class name: " + ae.getClass().getName());
                                        Cd585.ap = true;
                                    }
                                    final int bd = ae.bd;
                                    while (cx557 != null) {
                                        s(this, cx557, bd * cx557.cd() >> 8);
                                        cx557 = ae.d();
                                    }
                                }
                                final Cx556 ae2 = ae.ae;
                                ae.ae = null;
                                if (cx556 == null) {
                                    this.av[n4] = ae2;
                                }
                                else {
                                    cx556.ae = ae2;
                                }
                                if (ae2 == null) {
                                    this.az[n4] = cx556;
                                }
                                ae = ae2;
                            }
                        }
                    }
                    n4 += 4;
                    ++n5;
                }
                --n3;
            }
            for (int k = 0; k < 8; ++k) {
                Cx556 cx558 = this.av[k];
                this.av[k] = (this.az[k] = null);
                while (cx558 != null) {
                    final Cx556 ae3 = cx558.ae;
                    cx558.ae = null;
                    cx558 = ae3;
                }
            }
        }
        if (this.af < 0) {
            this.af = 0;
        }
        if (this.p != null) {
            this.p.j(a, 0, n);
        }
        this.u = Gz143.g();
    }
    
    private static final void h(final Cx556 cx556) {
        cx556.w = false;
        if (cx556.bm != null) {
            cx556.bm.h = 0;
        }
        for (Cx556 cx557 = cx556.g(); cx557 != null; cx557 = cx556.d()) {
            h(cx557);
        }
    }
    
    private static final void s(final Cd585 cd585, final Cx556 ae, final int bd) {
        final int n = bd >> 5;
        final Cx556 cx556 = cd585.az[n];
        if (cx556 == null) {
            cd585.av[n] = ae;
        }
        else {
            cx556.ae = ae;
        }
        cd585.az[n] = ae;
        ae.bd = bd;
    }
    
    static void b(final Cd585 cd585, final int n) throws Exception {
    }
    
    static int l(final Cd585 cd585) throws Exception {
        return cd585.z;
    }
    
    public Cd585() {
        this.e = false;
        this.y = false;
        this.x = 32;
        this.u = Gz143.g();
        this.n = 0L;
        this.k = 0;
        this.i = 0;
        this.o = 0;
        this.a = 0L;
        this.f = true;
        this.af = 0;
        this.av = new Cx556[8];
        this.az = new Cx556[8];
    }
    
    static void r(final Cd585 cd585) {
    }
    
    static void v(final Cd585 cd585) throws Exception {
    }
    
    public static final synchronized void g(final Cd585 cd585, final Cx556 p2) {
        cd585.p = p2;
    }
    
    static {
        Cd585.ah = true;
    }
    
    public final synchronized void q() {
        this.f = true;
        try {
            v(this);
        }
        catch (Exception ex) {
            System.out.println("pcm_player - discardbuffer error: " + ex.getMessage());
            ex.printStackTrace();
            r(this);
            this.n = Gz143.g() + 2000L;
        }
    }
}
