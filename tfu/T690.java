// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class T690 extends Cx556
{
    private static final boolean g = false;
    private long d;
    Dn555 e;
    Gx298 j;
    private M688 q;
    
    private static void h(final T690 t690, final U691 u691, final int[] array, int n, int n2, final int n3) {
        if ((t690.q.m[u691.g] & 0x4) != 0x0 && u691.u < 0) {
            final int n4 = t690.q.a[u691.g] / Cd585.h;
            while (true) {
                final int n5 = (1048575 + n4 - u691.o) / n4;
                if (n5 > n2) {
                    break;
                }
                u691.n.j(array, n, n5);
                n += n5;
                n2 -= n5;
                u691.o += n4 * n5 - 1048576;
                int n6 = Cd585.h / 100;
                final int n7 = 262144 / n4;
                if (n7 < n6) {
                    n6 = n7;
                }
                final Cs635 n8 = u691.n;
                if (t690.q.i[u691.g] == 0) {
                    u691.n = u691.q.d(Cs635.bn(n8), Cs635.bw(n8), Cs635.bj(n8));
                }
                else {
                    u691.n = u691.q.d(Cs635.bn(n8), 0, Cs635.bj(n8));
                    M688.f(t690.q, u691, u691.d.q[u691.h] < 0);
                    Cs635.by(u691.n, n6, Cs635.bw(n8));
                }
                if (u691.d.q[u691.h] < 0) {
                    Cs635.bq(u691.n, -1);
                }
                Cs635.bv(n8, n6);
                n8.j(array, n, n3 - n);
                if (!Cs635.bm(n8)) {
                    continue;
                }
                t690.e.h(n8);
            }
            u691.o += n4 * n2;
        }
        u691.n.j(array, n, n2);
    }
    
    @Override
    protected Cx556 d() {
        while (true) {
            final U691 u691 = (U691)Gx298.c(this.j);
            if (u691 == null) {
                return null;
            }
            if (u691.n != null) {
                return u691.n;
            }
        }
    }
    
    @Override
    protected int q() {
        return 0;
    }
    
    @Override
    public void e(final int n) {
        this.e.e(n);
    Label_0096:
        for (U691 u691 = (U691)Gx298.i(this.j); u691 != null; u691 = (U691)Gx298.c(this.j)) {
            if (!M688.ax(this.q, u691)) {
                int i = n;
                while (i > u691.k) {
                    s(this, u691, u691.k);
                    i -= u691.k;
                    if (M688.au(this.q, u691, null, 0, i)) {
                        continue Label_0096;
                    }
                }
                s(this, u691, i);
                final U691 u692 = u691;
                u692.k -= i;
            }
        }
    }
    
    private static void s(final T690 t690, final U691 u691, int n) {
        if ((t690.q.m[u691.g] & 0x4) != 0x0 && u691.u < 0) {
            final int n2 = t690.q.a[u691.g] / Cd585.h;
            final int n3 = (1048575 + n2 - u691.o) / n2;
            u691.o = (u691.o + n2 * n & 0xFFFFF);
            if (n3 <= n) {
                final Cs635 n4 = u691.n;
                if (t690.q.i[u691.g] == 0) {
                    u691.n = u691.q.d(Cs635.bn(n4), Cs635.bw(n4), Cs635.bj(n4));
                }
                else {
                    u691.n = u691.q.d(Cs635.bn(n4), 0, Cs635.bj(n4));
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
    
    T690(final M688 q) {
        this.j = new Gx298();
        this.e = new Dn555();
        this.q = q;
    }
    
    @Override
    public void j(final int[] array, final int n, final int n2) {
        this.e.j(array, n, n2);
    Label_0145:
        for (U691 u691 = (U691)Gx298.i(this.j); u691 != null; u691 = (U691)Gx298.c(this.j)) {
            if (!M688.ax(this.q, u691)) {
                int n3 = n;
                int i = n2;
                while (i > u691.k) {
                    h(this, u691, array, n3, u691.k, n3 + i);
                    n3 += u691.k;
                    i -= u691.k;
                    if (M688.au(this.q, u691, array, n3, i)) {
                        continue Label_0145;
                    }
                }
                h(this, u691, array, n3, i, n3 + i);
                final U691 u692 = u691;
                u692.k -= i;
            }
        }
    }
    
    @Override
    protected Cx556 g() {
        final U691 u691 = (U691)Gx298.i(this.j);
        if (u691 == null) {
            return null;
        }
        if (u691.n != null) {
            return u691.n;
        }
        return this.d();
    }
}
