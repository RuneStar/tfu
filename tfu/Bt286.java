/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.AbstractList;
import tfu.Bb4;
import tfu.Bc288;
import tfu.Bz650;
import tfu.Gg3;

public final class Bt286
extends AbstractList {
    private final int d;
    private final Bb4[] g;

    public static Bb4 z(Bt286 bt286, int n) {
        return bt286.g[n];
    }

    @Override
    public int size() {
        return this.g.length;
    }

    public static Bb4[] t(Bt286 bt286) {
        return (Bb4[])bt286.g.clone();
    }

    public static Bt286 m(Gg3 gg3, Bc288 bc288) {
        if (!Bz650.b(bc288)) {
            throw new IllegalArgumentException("Client-side GameEntityId of type " + bc288.name() + " cannot be sent to server");
        }
        Bb4[] arrbb4 = new Bb4[Gg3.bn(gg3)];
        int n = 0;
        if (arrbb4.length != 0) {
            n = Bt286.i(gg3, bc288, arrbb4);
        }
        return new Bt286(arrbb4, n);
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return (Object[])this.g.clone();
    }

    Bt286(Bb4[] arrbb4, int n) {
        this.g = arrbb4;
        this.d = this.n(n);
        for (Bb4 bb4 : this.g) {
            if (bb4.g == this.g[0].g) continue;
            throw new IllegalArgumentException();
        }
    }

    private static int i(Gg3 gg3, Bc288 bc288, Bb4[] arrbb4) {
        int n = 0;
        int n2 = 0;
        int n3 = -1;
        while (n2 < arrbb4.length) {
            int n4 = n2 + Gg3.bn(gg3);
            if (n4 == n2) {
                ++n;
                continue;
            }
            int n5 = n3 == -1 ? Gg3.au(gg3) : n3 + Gg3.bn(gg3);
            for (int i = n2; i < n4; ++i) {
                arrbb4[i] = new Bb4(bc288, n5++);
            }
            n3 = n5;
            n2 = n4;
        }
        return n;
    }

    private static void k(Bt286 bt286, Gg3 gg3) {
        int n = 0;
        int n2 = -1;
        while (n < bt286.g.length) {
            int n3;
            int n4 = bt286.g[n].d;
            int n5 = n4 + 1 & 0xFFFF;
            for (n3 = n + 1; n3 < bt286.g.length && bt286.g[n3].d == n5; ++n3) {
                n5 = n5 + 1 & 0xFFFF;
            }
            if (n2 == -1) {
                for (int i = 0; i < bt286.d; ++i) {
                    Gg3.ab(gg3, 0);
                }
            }
            Gg3.ab(gg3, n3 - n);
            if (n2 == -1) {
                Gg3.i(gg3, n4);
            } else {
                Gg3.ab(gg3, n4 - n2);
            }
            n2 = n5;
            n = n3;
        }
    }

    private int n(int n) {
        if (Bz650.d) {
            int n2 = this.g.length;
            if (n2 > n) {
                n2 = n;
            }
            int n3 = 0;
            if (n2 > 0) {
                n3 = 2;
                n3 += 3 * (n2 - 1);
                n3 += 3 * n2;
            }
            Gg3 gg3 = new Gg3(n3);
            Bt286.k(this, gg3);
            return n3 - gg3.v;
        }
        return 0;
    }
}

