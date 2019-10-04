/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.J297;
import com.jagex.maths.Vector3;
import java.util.List;
import tfu.Gx298;
import tfu.Jz233;
import tfu.Ln265;

public final class L296 {
    public J297[] g;

    private static J297[] h(J297[] arrj297, int n) {
        int n2;
        J297[] arrj2972 = new J297[arrj297.length];
        for (n2 = 0; n2 < arrj297.length; ++n2) {
            arrj2972[n2] = new J297(arrj297[n2]);
        }
        n2 = arrj297.length;
        block1 : while (n2 > 3) {
            for (int i = 0; i < n2; ++i) {
                if (L296.s(arrj2972, i, (i + 2) % n2, n2, n) == -1) {
                    continue;
                }
                int n3 = (i + 2) % n2;
                while (i != n3) {
                    if (L296.s(arrj2972, i = Jz233.w(i - 1, n2), n3, n2, n) != -1) continue;
                    i = (i + 1) % n2;
                    while (i != n3) {
                        if (L296.s(arrj2972, i, n3 = (n3 + 1) % n2, n2, n) != -1) continue;
                        if ((n3 = Jz233.w(n3 - 1, n2)) > i) {
                            System.arraycopy(arrj2972, n3, arrj2972, i + 1, n2 - n3);
                            n2 -= n3 - i - 1;
                            continue block1;
                        }
                        n2 = i + 1;
                        System.arraycopy(arrj2972, n3, arrj2972, 0, n2 - n3);
                        n2 -= n3;
                        continue block1;
                    }
                    break block1;
                }
                break block1;
            }
        }
        J297[] arrj2973 = new J297[n2];
        System.arraycopy(arrj2972, 0, arrj2973, 0, n2);
        return arrj2973;
    }

    public L296(List list, int n) {
        if (list.size() < 3) {
            throw new IllegalArgumentException("Must supply at least 3 points to generate a convex hull");
        }
        J297[] arrj297 = new J297[list.size()];
        int n2 = 0;
        for (Vector3 vector3 : list) {
            arrj297[n2++] = new J297(vector3.x, vector3.z);
        }
        this.g = L296.g(arrj297);
        if (n != 0) {
            this.g = L296.h(this.g, n);
        }
    }

    public L296(float[] arrf, float[] arrf2, int n, int n2) {
        J297[] arrj297 = new J297[n];
        for (int i = 0; i < arrj297.length; ++i) {
            arrj297[i] = new J297(arrf[i], arrf2[i]);
        }
        if (arrj297.length < 3) {
            throw new IllegalArgumentException();
        }
        this.g = L296.g(arrj297);
        if (n2 == 0) {
            return;
        }
        this.g = L296.h(this.g, n2);
    }

    private static J297[] g(J297[] arrj297) {
        J297 j297;
        int n;
        double d;
        float f = Float.MAX_VALUE;
        float f2 = 0.0f;
        for (int i = 0; i < arrj297.length; ++i) {
            J297 j2972 = arrj297[i];
            if (j2972.d < f) {
                f2 = j2972.g;
                f = j2972.d;
                continue;
            }
            if (j2972.d != f || !(f2 < j2972.g)) continue;
            f2 = j2972.g;
            f = j2972.d;
        }
        J297[] arrj2972 = arrj297;
        int n2 = arrj2972.length;
        for (n = 0; n < n2; ++n) {
            j297 = arrj2972[n];
            float f3 = j297.g - f2;
            float f4 = j297.d - f;
            d = Math.sqrt(f3 * f3 + f4 * f4);
            j297.q = Math.abs(d) < 0.01 ? 1.0 : (double)f3 / d;
        }
        L296.q(arrj297);
        int n3 = arrj297.length;
        for (n2 = 0; n2 < n3 - 1; ++n2) {
            J297 j2973 = arrj297[n2];
            j297 = arrj297[n2 + 1];
            if (j2973.q != j297.q) continue;
            double d2 = Math.sqrt((j2973.g - f2) * (j2973.g - f2) + (j2973.d - f) * (j2973.d - f));
            if (d2 < (d = Math.sqrt((j297.g - f2) * (j297.g - f2) + (j297.d - f) * (j297.d - f)))) {
                System.arraycopy(arrj297, n2 + 1, arrj297, n2, n3 - n2 - 1);
            } else if (n2 + 2 < n3) {
                System.arraycopy(arrj297, n2 + 2, arrj297, n2 + 1, n3 - n2 - 2);
            }
            --n3;
            --n2;
        }
        Gx298 gx298 = new Gx298();
        Gx298.t(gx298, arrj297[0]);
        Gx298.t(gx298, arrj297[1]);
        for (n = 2; n < arrj297.length; ++n) {
            j297 = (J297)Gx298.a(gx298);
            J297 j2974 = (J297)Gx298.ag(gx298);
            while (Gx298.aq(gx298) >= 2 && !L296.d(j2974, j297, arrj297[n])) {
                Gx298.k(gx298);
                j297 = j2974;
                j2974 = (J297)Gx298.ag(gx298);
            }
            Gx298.t(gx298, arrj297[n]);
        }
        Ln265[] arrln265 = new J297[Gx298.aq(gx298)];
        Gx298.al(gx298, arrln265);
        return arrln265;
    }

    private static boolean d(J297 j297, J297 j2972, J297 j2973) {
        return (j2972.g - j297.g) * (j2973.d - j2972.d) + (j2972.d - j297.d) * (j2972.g - j2973.g) >= 0.0f;
    }

    private static void q(J297[] arrj297) {
        L296.j(arrj297, arrj297.length);
        for (int i = arrj297.length - 1; i > 0; --i) {
            J297 j297 = arrj297[i];
            arrj297[i] = arrj297[0];
            arrj297[0] = j297;
            L296.e(arrj297, 0, i - 1);
        }
    }

    private static void e(J297[] arrj297, int n, int n2) {
        int n3 = n;
        while (n3 * 2 + 1 <= n2) {
            int n4 = n3 * 2 + 1;
            int n5 = n3;
            if (arrj297[n5].q > arrj297[n4].q) {
                n5 = n4;
            }
            if (n4 < n2 && arrj297[n5].q > arrj297[n4 + 1].q) {
                n5 = n4 + 1;
            }
            if (n5 != n3) {
                J297 j297 = arrj297[n3];
                arrj297[n3] = arrj297[n5];
                arrj297[n5] = j297;
                n3 = n5;
                continue;
            }
            return;
        }
    }

    public L296(int[] arrn, int[] arrn2, int n, int n2) {
        J297[] arrj297 = new J297[n];
        for (int i = 0; i < arrj297.length; ++i) {
            arrj297[i] = new J297(arrn[i], arrn2[i]);
        }
        if (arrj297.length < 3) {
            throw new IllegalArgumentException();
        }
        this.g = L296.g(arrj297);
        if (n2 == 0) {
            return;
        }
        this.g = L296.h(this.g, n2);
    }

    private static int s(J297[] arrj297, int n, int n2, int n3, float f) {
        float f2 = arrj297[n2].g - arrj297[n].g;
        float f3 = arrj297[n2].d - arrj297[n].d;
        float f4 = 0.0f;
        int n4 = -2;
        int n5 = (n + 1) % n3;
        while (n5 != n2) {
            float f5 = (float)Math.abs((double)((arrj297[n5].d - arrj297[n].d) * f2 - (arrj297[n5].g - arrj297[n].g) * f3) / Math.sqrt(f2 * f2 + f3 * f3));
            if (f5 > f) {
                return -1;
            }
            if (f5 > f4) {
                f4 = f5;
                n4 = n5;
            }
            n5 = (n5 + 1) % n3;
        }
        return n4;
    }

    private static void j(J297[] arrj297, int n) {
        for (int i = n / 2; i >= 0; --i) {
            L296.e(arrj297, i, n - 1);
        }
    }
}

