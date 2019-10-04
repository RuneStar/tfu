/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Cd585;
import tfu.Cs635;
import tfu.Cw634;
import tfu.Cx556;
import tfu.Dn555;
import tfu.Gx298;
import tfu.M688;
import tfu.U691;
import tfu.Y692;

class T690
extends Cx556 {
    private static final boolean g = false;
    private long d;
    Dn555 e;
    Gx298 j = new Gx298();
    private M688 q;

    private static void h(T690 t690, U691 u691, int[] arrn, int n, int n2, int n3) {
        if ((t690.q.m[u691.g] & 4) != 0 && u691.u < 0) {
            int n4;
            int n5 = t690.q.a[u691.g] / Cd585.h;
            while ((n4 = (1048575 + n5 - u691.o) / n5) <= n2) {
                u691.n.j(arrn, n, n4);
                n += n4;
                n2 -= n4;
                u691.o += n5 * n4 - 1048576;
                int n6 = Cd585.h / 100;
                int n7 = 262144 / n5;
                if (n7 < n6) {
                    n6 = n7;
                }
                Cs635 cs635 = u691.n;
                if (t690.q.i[u691.g] == 0) {
                    u691.n = u691.q.d(Cs635.bn(cs635), Cs635.bw(cs635), Cs635.bj(cs635));
                } else {
                    u691.n = u691.q.d(Cs635.bn(cs635), 0, Cs635.bj(cs635));
                    M688.f(t690.q, u691, u691.d.q[u691.h] < 0);
                    Cs635.by(u691.n, n6, Cs635.bw(cs635));
                }
                if (u691.d.q[u691.h] < 0) {
                    Cs635.bq(u691.n, -1);
                }
                Cs635.bv(cs635, n6);
                cs635.j(arrn, n, n3 - n);
                if (!Cs635.bm(cs635)) continue;
                t690.e.h(cs635);
            }
            u691.o += n5 * n2;
        }
        u691.n.j(arrn, n, n2);
    }

    @Override
    protected Cx556 d() {
        U691 u691;
        do {
            if ((u691 = (U691)Gx298.c(this.j)) != null) continue;
            return null;
        } while (u691.n == null);
        return u691.n;
    }

    @Override
    protected int q() {
        return 0;
    }

    @Override
    public void e(int n) {
        this.e.e(n);
        U691 u691 = (U691)Gx298.i(this.j);
        while (u691 != null) {
            block3 : {
                if (!M688.ax(this.q, u691)) {
                    int n2 = n;
                    while (n2 > u691.k) {
                        T690.s(this, u691, u691.k);
                        if (!M688.au(this.q, u691, null, 0, n2 -= u691.k)) continue;
                        break block3;
                    }
                    T690.s(this, u691, n2);
                    u691.k -= n2;
                }
            }
            u691 = (U691)Gx298.c(this.j);
        }
    }

    private static void s(T690 t690, U691 u691, int n) {
        if ((t690.q.m[u691.g] & 4) != 0 && u691.u < 0) {
            int n2 = t690.q.a[u691.g] / Cd585.h;
            int n3 = (1048575 + n2 - u691.o) / n2;
            u691.o = u691.o + n2 * n & 0xFFFFF;
            if (n3 <= n) {
                Cs635 cs635 = u691.n;
                if (t690.q.i[u691.g] == 0) {
                    u691.n = u691.q.d(Cs635.bn(cs635), Cs635.bw(cs635), Cs635.bj(cs635));
                } else {
                    u691.n = u691.q.d(Cs635.bn(cs635), 0, Cs635.bj(cs635));
                    M688.f(t690.q, u691, u691.d.q[u691.h] < 0);
                }
                if (u691.d.q[u691.h] < 0) {
                    Cs635.bq(u691.n, -1);
                }
                n = u691.o / n2;
            }
        }
        u691.n.e(n);
    }

    T690(M688 m688) {
        this.e = new Dn555();
        this.q = m688;
    }

    @Override
    public void j(int[] arrn, int n, int n2) {
        this.e.j(arrn, n, n2);
        U691 u691 = (U691)Gx298.i(this.j);
        while (u691 != null) {
            block3 : {
                if (!M688.ax(this.q, u691)) {
                    int n3 = n;
                    int n4 = n2;
                    while (n4 > u691.k) {
                        T690.h(this, u691, arrn, n3, u691.k, n3 + n4);
                        if (!M688.au(this.q, u691, arrn, n3 += u691.k, n4 -= u691.k)) continue;
                        break block3;
                    }
                    T690.h(this, u691, arrn, n3, n4, n3 + n4);
                    u691.k -= n4;
                }
            }
            u691 = (U691)Gx298.c(this.j);
        }
    }

    @Override
    protected Cx556 g() {
        U691 u691 = (U691)Gx298.i(this.j);
        if (u691 == null) {
            return null;
        }
        if (u691.n != null) {
            return u691.n;
        }
        return this.d();
    }
}

