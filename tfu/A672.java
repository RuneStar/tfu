/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.jnibindings.runetek6.Graphics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Fb341;
import tfu.Fj373;
import tfu.Fy467;
import tfu.H149;
import tfu.Kc180;
import tfu.Km535;

public class A672
implements Km535 {
    private static final Logger logger = LoggerFactory.getLogger(A672.class);
    private int b = 0;
    long d = 0L;
    private boolean e = false;
    private int h = 0;
    private int j;
    private int l = 0;
    private int q;
    private int s = 0;

    public static final void g(A672 a672, float f, float f2, float f3, float f4, float f5, float f6, Fy467 fy467, int n, Fb341 fb341) {
        H149.b((int)f, (int)f2, (int)f3, (int)f4, (int)f5, (int)f6, (int)(f3 + f5 - f), (int)(f4 + f6 - f2), 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, a672.d, n);
    }

    public A672(int n, int n2, int[] arrn, int n3, int n4) {
        A672.d(this, n, n2, arrn, n3, n4);
    }

    public static void h(A672 a672, float f, float f2, float f3, float f4, Fy467 fy467, int n, Fb341 fb341) {
        if (a672.e) {
            f3 = f3 * (float)a672.q / (float)a672.q();
            f4 = f4 * (float)a672.j / (float)a672.j();
            f += (float)a672.s * f3 / (float)a672.q;
            f2 += (float)a672.h * f4 / (float)a672.j;
        }
        H149.s(f, f2, f + f3, f2 + f4, 0.0f, 0.0f, 1.0f, 1.0f, a672.d, n);
    }

    private static void d(A672 a672, int n, int n2, int[] arrn, int n3, int n4) {
        long l;
        a672.q = n;
        a672.j = n2;
        long l2 = l = H149.j;
        for (int i = 0; i < arrn.length; ++i) {
            Kc180.r(l2, arrn[i]);
            l2 += 4L;
        }
        a672.d = Graphics.createTexture2D(21, n, n2, 0, 0, l, 1);
    }

    public A672(Fj373 fj373) {
        if (fj373.g != 0 && fj373.d != 0) {
            int[] arrn = new int[fj373.g * fj373.d];
            int n = 0;
            int n2 = 0;
            if (fj373.l != null) {
                for (int i = 0; i < fj373.d; ++i) {
                    for (int j = 0; j < fj373.g; ++j) {
                        arrn[n2++] = fj373.l[n] << 24 | fj373.s[fj373.b[n] & 0xFF];
                        ++n;
                    }
                }
            } else {
                for (int i = 0; i < fj373.d; ++i) {
                    for (int j = 0; j < fj373.g; ++j) {
                        int n3 = fj373.s[fj373.b[n++] & 0xFF];
                        arrn[n2++] = n3 != 0 ? 0xFF000000 | n3 : 0;
                    }
                }
            }
            A672.d(this, fj373.g, fj373.d, arrn, 0, fj373.g);
        } else {
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

    public static void e(A672 a672, int n, int n2, Fy467 fy467, int n3, Fb341 fb341) {
        H149.s(n += a672.s, n2 += a672.h, n + a672.q, n2 + a672.j, 0.0f, 0.0f, 1.0f, 1.0f, a672.d, n3);
    }

    public A672(int n, int n2, boolean bl) {
        this.q = n;
        this.j = n2;
        this.d = 0L;
    }
}

