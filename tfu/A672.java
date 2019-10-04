// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.jnibindings.runetek6.Graphics;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class A672 implements Km535
{
    private static final Logger logger;
    private int b;
    long d;
    private boolean e;
    private int h;
    private int j;
    private int l;
    private int q;
    private int s;
    
    static {
        logger = LoggerFactory.getLogger(A672.class);
    }
    
    public static final void g(final A672 a672, final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final Fy467 fy467, final int n7, final Fb341 fb341) {
        H149.b((float)(int)n, (float)(int)n2, (float)(int)n3, (float)(int)n4, (float)(int)n5, (float)(int)n6, (float)(int)(n3 + n5 - n), (float)(int)(n4 + n6 - n2), 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, a672.d, n7);
    }
    
    public A672(final int n, final int n2, final int[] array, final int n3, final int n4) {
        this.d = 0L;
        this.e = false;
        this.h = 0;
        this.s = 0;
        this.b = 0;
        this.l = 0;
        d(this, n, n2, array, n3, n4);
    }
    
    public static void h(final A672 a672, float n, float n2, float n3, float n4, final Fy467 fy467, final int n5, final Fb341 fb341) {
        if (a672.e) {
            n3 = n3 * a672.q / a672.q();
            n4 = n4 * a672.j / a672.j();
            n += a672.s * n3 / a672.q;
            n2 += a672.h * n4 / a672.j;
        }
        H149.s(n, n2, n + n3, n2 + n4, 0.0f, 0.0f, 1.0f, 1.0f, a672.d, n5);
    }
    
    private static void d(final A672 a672, final int q, final int j, final int[] array, final int n, final int n2) {
        a672.q = q;
        a672.j = j;
        long i;
        final long n3 = i = H149.j;
        for (int k = 0; k < array.length; ++k) {
            Kc180.r(i, array[k]);
            i += 4L;
        }
        a672.d = Graphics.createTexture2D(21, q, j, 0, 0, n3, 1);
    }
    
    public A672(final Fj373 fj373) {
        this.d = 0L;
        this.e = false;
        this.h = 0;
        this.s = 0;
        this.b = 0;
        this.l = 0;
        if (fj373.g != 0 && fj373.d != 0) {
            final int[] array = new int[fj373.g * fj373.d];
            int n = 0;
            int n2 = 0;
            if (fj373.l != null) {
                for (int i = 0; i < fj373.d; ++i) {
                    for (int j = 0; j < fj373.g; ++j) {
                        array[n2++] = (fj373.l[n] << 24 | fj373.s[fj373.b[n] & 0xFF]);
                        ++n;
                    }
                }
            }
            else {
                for (int k = 0; k < fj373.d; ++k) {
                    for (int l = 0; l < fj373.g; ++l) {
                        final int n3 = fj373.s[fj373.b[n++] & 0xFF];
                        array[n2++] = ((n3 != 0) ? (0xFF000000 | n3) : 0);
                    }
                }
            }
            d(this, fj373.g, fj373.d, array, 0, fj373.g);
        }
        else {
            this.q = 0;
            this.j = 0;
            this.d = 0L;
        }
    }
    
    @Override
    public int j() {
        return this.j + this.h + this.b;
    }
    
    @Override
    public int q() {
        return this.q + this.s + this.l;
    }
    
    public static void e(final A672 a672, int n, int n2, final Fy467 fy467, final int n3, final Fb341 fb341) {
        n += a672.s;
        n2 += a672.h;
        H149.s((float)n, (float)n2, (float)(n + a672.q), (float)(n2 + a672.j), 0.0f, 0.0f, 1.0f, 1.0f, a672.d, n3);
    }
    
    public A672(final int q, final int j, final boolean b) {
        this.d = 0L;
        this.e = false;
        this.h = 0;
        this.s = 0;
        this.b = 0;
        this.l = 0;
        this.q = q;
        this.j = j;
        this.d = 0L;
    }
}
