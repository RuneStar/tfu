/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.PrintStream;
import java.util.Arrays;
import tfu.Cb633;
import tfu.Cq640;
import tfu.Cx556;
import tfu.Gz143;

public class Cd585 {
    private static final int ag = 8;
    public static boolean ah = true;
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
    private long a = 0L;
    private int af = 0;
    private Cx556[] av;
    private Cx556[] az;
    private boolean e = false;
    private boolean f = true;
    private int i = 0;
    private int k = 0;
    private int m;
    private long n = 0L;
    private int o = 0;
    private Cx556 p;
    private int t;
    private long u = Gz143.g();
    int[] v;
    public int x = 32;
    boolean y = false;
    private int z;

    static void w(Cd585 cd585) throws Exception {
    }

    private static final void j(Cd585 cd585, int n) {
        cd585.af -= n;
        if (cd585.af < 0) {
            cd585.af = 0;
        }
        if (cd585.p != null) {
            cd585.p.e(n);
        }
    }

    private final void e(int[] arrn, int n) {
        int n2 = n;
        if (s) {
            n2 <<= 1;
        }
        Arrays.fill(arrn, 0, n2, 0);
        this.af -= n;
        if (this.p != null && this.af <= 0) {
            this.af += h >> 4;
            Cd585.h(this.p);
            Cd585.s(this, this.p, this.p.cd());
            int n3 = 0;
            int n4 = 255;
            int n5 = 7;
            block0 : while (n4 != 0) {
                int n6;
                int n7;
                if (n5 < 0) {
                    n6 = n5 & 3;
                    n7 = -(n5 >> 2);
                } else {
                    n6 = n5;
                    n7 = 0;
                }
                for (int i = n4 >>> n6 & 286331153; i != 0; i >>>= 4) {
                    if ((i & 1) != 0) {
                        n4 &= ~(1 << n6);
                        Cx556 cx556 = null;
                        Cx556 cx5562 = this.av[n6];
                        while (cx5562 != null) {
                            Cb633 cb633 = cx5562.bm;
                            if (cb633 != null && cb633.h > n7) {
                                n4 |= 1 << n6;
                                cx556 = cx5562;
                                cx5562 = cx5562.ae;
                                continue;
                            }
                            cx5562.w = true;
                            int n8 = cx5562.q();
                            n3 += n8;
                            if (cb633 != null) {
                                cb633.h += n8;
                            }
                            if (n3 >= this.x) break block0;
                            Cx556 cx5563 = cx5562.g();
                            if (cx5563 != null) {
                                if (ap && cb633 != null && cx5562.g() != null) {
                                    System.out.println("Warning: a pcm_stream with substreams has set its 'w' - this can cause");
                                    System.out.println("         parent duplicate demotion, and high-pri substreams will be lost!");
                                    System.out.println("         Guilty class name: " + cx5562.getClass().getName());
                                    ap = true;
                                }
                                int n9 = cx5562.bd;
                                while (cx5563 != null) {
                                    Cd585.s(this, cx5563, n9 * cx5563.cd() >> 8);
                                    cx5563 = cx5562.d();
                                }
                            }
                            Cx556 cx5564 = cx5562.ae;
                            cx5562.ae = null;
                            if (cx556 == null) {
                                this.av[n6] = cx5564;
                            } else {
                                cx556.ae = cx5564;
                            }
                            if (cx5564 == null) {
                                this.az[n6] = cx556;
                            }
                            cx5562 = cx5564;
                        }
                    }
                    n6 += 4;
                    ++n7;
                }
                --n5;
            }
            for (n5 = 0; n5 < 8; ++n5) {
                Cx556 cx556 = this.av[n5];
                this.az[n5] = null;
                this.av[n5] = null;
                while (cx556 != null) {
                    Cx556 cx5565 = cx556.ae;
                    cx556.ae = null;
                    cx556 = cx5565;
                }
            }
        }
        if (this.af < 0) {
            this.af = 0;
        }
        if (this.p != null) {
            this.p.j(arrn, 0, n);
        }
        this.u = Gz143.g();
    }

    private static final void h(Cx556 cx556) {
        cx556.w = false;
        if (cx556.bm != null) {
            cx556.bm.h = 0;
        }
        Cx556 cx5562 = cx556.g();
        while (cx5562 != null) {
            Cd585.h(cx5562);
            cx5562 = cx556.d();
        }
    }

    private static final void s(Cd585 cd585, Cx556 cx556, int n) {
        int n2 = n >> 5;
        Cx556 cx5562 = cd585.az[n2];
        if (cx5562 == null) {
            cd585.av[n2] = cx556;
        } else {
            cx5562.ae = cx556;
        }
        cd585.az[n2] = cx556;
        cx556.bd = n;
    }

    static void b(Cd585 cd585, int n) throws Exception {
    }

    static int l(Cd585 cd585) throws Exception {
        return cd585.z;
    }

    public Cd585() {
        this.av = new Cx556[8];
        this.az = new Cx556[8];
    }

    static void r(Cd585 cd585) {
    }

    static void v(Cd585 cd585) throws Exception {
    }

    public static final synchronized void g(Cd585 cd585, Cx556 cx556) {
        cd585.p = cx556;
    }

    public final synchronized void q() {
        this.f = true;
        try {
            Cd585.v(this);
        }
        catch (Exception exception) {
            System.out.println("pcm_player - discardbuffer error: " + exception.getMessage());
            exception.printStackTrace();
            Cd585.r(this);
            this.n = Gz143.g() + 2000L;
        }
    }
}

