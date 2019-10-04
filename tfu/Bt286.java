// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.AbstractList;

public final class Bt286 extends AbstractList
{
    private final int d;
    private final Bb4[] g;
    
    public static Bb4 z(final Bt286 bt286, final int n) {
        return bt286.g[n];
    }
    
    @Override
    public int size() {
        return this.g.length;
    }
    
    public static Bb4[] t(final Bt286 bt286) {
        return bt286.g.clone();
    }
    
    public static Bt286 m(final Gg3 gg3, final Bc288 bc288) {
        if (!Bz650.b(bc288)) {
            throw new IllegalArgumentException("Client-side GameEntityId of type " + bc288.name() + " cannot be sent to server");
        }
        final Bb4[] array = new Bb4[Gg3.bn(gg3)];
        int i = 0;
        if (array.length != 0) {
            i = i(gg3, bc288, array);
        }
        return new Bt286(array, i);
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return this.g.clone();
    }
    
    Bt286(final Bb4[] g, final int n) {
        this.g = g;
        this.d = this.n(n);
        final Bb4[] g2 = this.g;
        for (int length = g2.length, i = 0; i < length; ++i) {
            if (g2[i].g != this.g[0].g) {
                throw new IllegalArgumentException();
            }
        }
    }
    
    private static int i(final Gg3 gg3, final Bc288 bc288, final Bb4[] array) {
        int n = 0;
        int i = 0;
        int n2 = -1;
        while (i < array.length) {
            final int n3 = i + Gg3.bn(gg3);
            if (n3 == i) {
                ++n;
            }
            else {
                int au;
                if (n2 == -1) {
                    au = Gg3.au(gg3);
                }
                else {
                    au = n2 + Gg3.bn(gg3);
                }
                for (int j = i; j < n3; ++j) {
                    array[j] = new Bb4(bc288, au++);
                }
                n2 = au;
                i = n3;
            }
        }
        return n;
    }
    
    private static void k(final Bt286 bt286, final Gg3 gg3) {
        int i = 0;
        int n = -1;
        while (i < bt286.g.length) {
            final int d = bt286.g[i].d;
            int n2;
            int n3;
            for (n2 = i + 1, n3 = (d + 1 & 0xFFFF); n2 < bt286.g.length && bt286.g[n2].d == n3; ++n2, n3 = (n3 + 1 & 0xFFFF)) {}
            if (n == -1) {
                for (int j = 0; j < bt286.d; ++j) {
                    Gg3.ab(gg3, 0);
                }
            }
            Gg3.ab(gg3, n2 - i);
            if (n == -1) {
                Gg3.i(gg3, d);
            }
            else {
                Gg3.ab(gg3, d - n);
            }
            n = n3;
            i = n2;
        }
    }
    
    private int n(final int n) {
        if (Bz650.d) {
            int length = this.g.length;
            if (length > n) {
                length = n;
            }
            int n2 = 0;
            if (length > 0) {
                n2 = 2 + 3 * (length - 1) + 3 * length;
            }
            final Gg3 gg3 = new Gg3(n2);
            k(this, gg3);
            return n2 - gg3.v;
        }
        return 0;
    }
}
