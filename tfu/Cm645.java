/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Cb633;
import tfu.Cd585;
import tfu.Ci646;
import tfu.Cs635;
import tfu.Cw634;
import tfu.Cx556;

public class Cm645
extends Cs635 {
    private static final int d = 128;
    private static final boolean g = true;

    private static int h(Cm645 cm645, int[] arrn, int n, int n2, int n3, float f) {
        while (cm645.m > 0) {
            int n4 = n + cm645.m;
            if (n4 > n3) {
                n4 = n3;
            }
            cm645.m += n;
            n = cm645.e == 256 && (cm645.j & 0xFF) == 0 ? (Cd585.s ? Cm645.o(0.0f, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.l, cm645.r, cm645.y, cm645.p, 0, n4, n2, cm645) : Cm645.i(Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.b, cm645.v, 0, n4, n2, cm645)) : (Cd585.s ? Cm645.ag(0.0f, 0, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.l, cm645.r, cm645.y, cm645.p, 0, n4, n2, cm645, cm645.e, f) : Cm645.c(0.0f, 0, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.b, cm645.v, 0, n4, n2, cm645, cm645.e, f));
            cm645.m -= n;
            if (cm645.m != 0) {
                return n;
            }
            if (!Cm645.bg(cm645)) continue;
            return n3;
        }
        if (cm645.e == 256 && (cm645.j & 0xFF) == 0) {
            if (Cd585.s) {
                return Cm645.v(0.0f, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.l, cm645.r, 0, n3, n2, cm645);
            }
            return Cm645.r(Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.b, 0, n3, n2, cm645);
        }
        if (Cd585.s) {
            return Cm645.m(0.0f, 0, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.l, cm645.r, 0, n3, n2, cm645, cm645.e, f);
        }
        return Cm645.t(0.0f, 0, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.b, 0, n3, n2, cm645, cm645.e, f);
    }

    protected Cm645(Ci646 ci646, int n, int n2, int n3) {
        this.bm = ci646;
        this.u = ci646.d;
        this.z = ci646.q;
        this.t = ci646.j;
        this.e = n;
        this.h = n2;
        this.s = n3;
        this.j = 0;
        Cm645.bd(this);
    }

    private static int ag(float f, int n, float[] arrf, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, Cm645 cm645, int n11, float f2) {
        n4 *= 128;
        n6 *= 128;
        n5 *= 128;
        n7 *= 128;
        cm645.b -= cm645.v * n3;
        if (n11 == 0 || (n8 = n3 + (n10 - n2 + n11 - 257) / n11) > n9) {
            n8 = n9;
        }
        n3 <<= 1;
        while (n3 < (n8 <<= 1)) {
            n = n2 >> 8;
            f = arrf[n];
            f = f * 256.0f + (arrf[n + 1] - f) * (float)(n2 & 0xFF);
            int[] arrn2 = arrn;
            int n12 = n3++;
            arrn2[n12] = arrn2[n12] + ((int)(f * (float)n4) >> 6);
            n4 += n6;
            int[] arrn3 = arrn;
            int n13 = n3++;
            arrn3[n13] = arrn3[n13] + ((int)(f * (float)n5) >> 6);
            n5 += n7;
            n2 += n11;
        }
        if (n11 == 0 || (n8 = (n3 >> 1) + (n10 - n2 + n11 - 1) / n11) > n9) {
            n8 = n9;
        }
        while (n3 < (n8 <<= 1)) {
            f = arrf[n2 >> 8];
            f = f * 256.0f + (f2 - f) * (float)(n2 & 0xFF);
            int[] arrn4 = arrn;
            int n14 = n3++;
            arrn4[n14] = arrn4[n14] + ((int)(f * (float)n4) >> 6);
            n4 += n6;
            int[] arrn5 = arrn;
            int n15 = n3++;
            arrn5[n15] = arrn5[n15] + ((int)(f * (float)n5) >> 6);
            n5 += n7;
            n2 += n11;
        }
        cm645.b += cm645.v * (n3 >>= 1);
        cm645.l = n4 / 128;
        cm645.r = n5 / 128;
        cm645.j = n2;
        return n3;
    }

    private static int s(Cm645 cm645, int[] arrn, int n, int n2, int n3, float f) {
        while (cm645.m > 0) {
            int n4 = n + cm645.m;
            if (n4 > n3) {
                n4 = n3;
            }
            cm645.m += n;
            n = cm645.e == -256 && (cm645.j & 0xFF) == 0 ? (Cd585.s ? Cm645.f(0.0f, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.l, cm645.r, cm645.y, cm645.p, 0, n4, n2, cm645) : Cm645.a(Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.b, cm645.v, 0, n4, n2, cm645)) : (Cd585.s ? Cm645.ai(0.0f, 0, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.l, cm645.r, cm645.y, cm645.p, 0, n4, n2, cm645, cm645.e, f) : Cm645.aq(0.0f, 0, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.b, cm645.v, 0, n4, n2, cm645, cm645.e, f));
            cm645.m -= n;
            if (cm645.m != 0) {
                return n;
            }
            if (!Cm645.bg(cm645)) continue;
            return n3;
        }
        if (cm645.e == -256 && (cm645.j & 0xFF) == 0) {
            if (Cd585.s) {
                return Cm645.z(0.0f, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.l, cm645.r, 0, n3, n2, cm645);
            }
            return Cm645.u(Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.b, 0, n3, n2, cm645);
        }
        if (Cd585.s) {
            return Cm645.k(0.0f, 0, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.l, cm645.r, 0, n3, n2, cm645, cm645.e, f);
        }
        return Cm645.n(0.0f, 0, Ci646.l((Ci646)cm645.bm), arrn, cm645.j, n, cm645.b, 0, n3, n2, cm645, cm645.e, f);
    }

    private static int r(float[] arrf, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, Cm645 cm645) {
        n3 <<= 2;
        n3 *= 128;
        n4 = n2 + (n6 >>= 8) - (n >>= 8);
        if (n4 > n5) {
            n4 = n5;
        }
        while (n2 < (n4 -= 3)) {
            int[] arrn2 = arrn;
            int n7 = n2++;
            arrn2[n7] = (int)((float)arrn2[n7] + arrf[n++] * (float)n3);
            int[] arrn3 = arrn;
            int n8 = n2++;
            arrn3[n8] = (int)((float)arrn3[n8] + arrf[n++] * (float)n3);
            int[] arrn4 = arrn;
            int n9 = n2++;
            arrn4[n9] = (int)((float)arrn4[n9] + arrf[n++] * (float)n3);
            int[] arrn5 = arrn;
            int n10 = n2++;
            arrn5[n10] = (int)((float)arrn5[n10] + arrf[n++] * (float)n3);
        }
        while (n2 < (n4 += 3)) {
            int[] arrn6 = arrn;
            int n11 = n2++;
            arrn6[n11] = (int)((float)arrn6[n11] + arrf[n++] * (float)n3);
        }
        cm645.j = n << 8;
        return n2;
    }

    private static int v(float f, float[] arrf, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, int n7, Cm645 cm645) {
        n3 <<= 2;
        n4 <<= 2;
        n3 *= 128;
        n4 *= 128;
        n5 = n2 + (n7 >>= 8) - (n >>= 8);
        if (n5 > n6) {
            n5 = n6;
        }
        n2 <<= 1;
        n5 <<= 1;
        while (n2 < (n5 -= 6)) {
            f = arrf[n++];
            int[] arrn2 = arrn;
            int n8 = n2++;
            arrn2[n8] = (int)((float)arrn2[n8] + f * (float)n3);
            int[] arrn3 = arrn;
            int n9 = n2++;
            arrn3[n9] = (int)((float)arrn3[n9] + f * (float)n4);
            f = arrf[n++];
            int[] arrn4 = arrn;
            int n10 = n2++;
            arrn4[n10] = (int)((float)arrn4[n10] + f * (float)n3);
            int[] arrn5 = arrn;
            int n11 = n2++;
            arrn5[n11] = (int)((float)arrn5[n11] + f * (float)n4);
            f = arrf[n++];
            int[] arrn6 = arrn;
            int n12 = n2++;
            arrn6[n12] = (int)((float)arrn6[n12] + f * (float)n3);
            int[] arrn7 = arrn;
            int n13 = n2++;
            arrn7[n13] = (int)((float)arrn7[n13] + f * (float)n4);
            f = arrf[n++];
            int[] arrn8 = arrn;
            int n14 = n2++;
            arrn8[n14] = (int)((float)arrn8[n14] + f * (float)n3);
            int[] arrn9 = arrn;
            int n15 = n2++;
            arrn9[n15] = (int)((float)arrn9[n15] + f * (float)n4);
        }
        while (n2 < (n5 += 6)) {
            f = arrf[n++];
            int[] arrn10 = arrn;
            int n16 = n2++;
            arrn10[n16] = (int)((float)arrn10[n16] + f * (float)n3);
            int[] arrn11 = arrn;
            int n17 = n2++;
            arrn11[n17] = (int)((float)arrn11[n17] + f * (float)n4);
        }
        cm645.j = n << 8;
        return n2 >> 1;
    }

    private static int u(float[] arrf, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, Cm645 cm645) {
        n3 <<= 2;
        n3 *= 128;
        n4 = n2 + (n >>= 8) - ((n6 >>= 8) - 1);
        if (n4 > n5) {
            n4 = n5;
        }
        while (n2 < (n4 -= 3)) {
            int[] arrn2 = arrn;
            int n7 = n2++;
            arrn2[n7] = (int)((float)arrn2[n7] + arrf[n--] * (float)n3);
            int[] arrn3 = arrn;
            int n8 = n2++;
            arrn3[n8] = (int)((float)arrn3[n8] + arrf[n--] * (float)n3);
            int[] arrn4 = arrn;
            int n9 = n2++;
            arrn4[n9] = (int)((float)arrn4[n9] + arrf[n--] * (float)n3);
            int[] arrn5 = arrn;
            int n10 = n2++;
            arrn5[n10] = (int)((float)arrn5[n10] + arrf[n--] * (float)n3);
        }
        while (n2 < (n4 += 3)) {
            int[] arrn6 = arrn;
            int n11 = n2++;
            arrn6[n11] = (int)((float)arrn6[n11] + arrf[n--] * (float)n3);
        }
        cm645.j = n << 8;
        return n2;
    }

    private static int t(float f, int n, float[] arrf, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, Cm645 cm645, int n8, float f2) {
        n4 *= 128;
        if (n8 == 0 || (n5 = n3 + (n7 - n2 + n8 - 257) / n8) > n6) {
            n5 = n6;
        }
        while (n3 < n5) {
            n = n2 >> 8;
            f = arrf[n];
            int[] arrn2 = arrn;
            int n9 = n3++;
            arrn2[n9] = arrn2[n9] + ((int)((f * 256.0f + (arrf[n + 1] - f) * (float)(n2 & 0xFF)) * (float)n4) >> 6);
            n2 += n8;
        }
        if (n8 == 0 || (n5 = n3 + (n7 - n2 + n8 - 1) / n8) > n6) {
            n5 = n6;
        }
        while (n3 < n5) {
            f = arrf[n2 >> 8];
            int[] arrn3 = arrn;
            int n10 = n3++;
            arrn3[n10] = arrn3[n10] + ((int)((f * 256.0f + (f2 - f) * (float)(n2 & 0xFF)) * (float)n4) >> 6);
            n2 += n8;
        }
        cm645.j = n2;
        return n3;
    }

    private static int n(float f, int n, float[] arrf, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, Cm645 cm645, int n8, float f2) {
        n4 *= 128;
        if (n8 == 0 || (n5 = n3 + (n7 + 256 - n2 + n8) / n8) > n6) {
            n5 = n6;
        }
        while (n3 < n5) {
            n = n2 >> 8;
            f = arrf[n - 1];
            int[] arrn2 = arrn;
            int n9 = n3++;
            arrn2[n9] = arrn2[n9] + ((int)((f * 256.0f + (arrf[n] - f) * (float)(n2 & 0xFF)) * (float)n4) >> 6);
            n2 += n8;
        }
        if (n8 == 0 || (n5 = n3 + (n7 - n2 + n8) / n8) > n6) {
            n5 = n6;
        }
        f = f2;
        while (n3 < n5) {
            int[] arrn3 = arrn;
            int n10 = n3++;
            arrn3[n10] = arrn3[n10] + ((int)((f * 256.0f + (arrf[n2 >> 8] - f) * (float)(n2 & 0xFF)) * (float)n4) >> 6);
            n2 += n8;
        }
        cm645.j = n2;
        return n3;
    }

    private static int i(float[] arrf, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, int n7, Cm645 cm645) {
        n3 <<= 2;
        n4 <<= 2;
        n3 *= 128;
        n4 *= 128;
        n5 = n2 + (n7 >>= 8) - (n >>= 8);
        if (n5 > n6) {
            n5 = n6;
        }
        cm645.l += cm645.y * (n5 - n2);
        cm645.r += cm645.p * (n5 - n2);
        while (n2 < (n5 -= 3)) {
            int[] arrn2 = arrn;
            int n8 = n2++;
            arrn2[n8] = (int)((float)arrn2[n8] + arrf[n++] * (float)n3);
            int[] arrn3 = arrn;
            int n9 = n2++;
            arrn3[n9] = (int)((float)arrn3[n9] + arrf[n++] * (float)(n3 += n4));
            int[] arrn4 = arrn;
            int n10 = n2++;
            arrn4[n10] = (int)((float)arrn4[n10] + arrf[n++] * (float)(n3 += n4));
            int[] arrn5 = arrn;
            int n11 = n2++;
            arrn5[n11] = (int)((float)arrn5[n11] + arrf[n++] * (float)(n3 += n4));
            n3 += n4;
        }
        while (n2 < (n5 += 3)) {
            int[] arrn6 = arrn;
            int n12 = n2++;
            arrn6[n12] = (int)((float)arrn6[n12] + arrf[n++] * (float)n3);
            n3 += n4;
        }
        cm645.b = n3 / 128 >> 2;
        cm645.j = n << 8;
        return n2;
    }

    private static int o(float f, float[] arrf, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Cm645 cm645) {
        n3 <<= 2;
        n4 <<= 2;
        n5 <<= 2;
        n6 <<= 2;
        n3 *= 128;
        n5 *= 128;
        n4 *= 128;
        n6 *= 128;
        n7 = n2 + (n9 >>= 8) - (n >>= 8);
        if (n7 > n8) {
            n7 = n8;
        }
        cm645.b += cm645.v * (n7 - n2);
        n2 <<= 1;
        n7 <<= 1;
        while (n2 < (n7 -= 6)) {
            f = arrf[n++];
            int[] arrn2 = arrn;
            int n10 = n2++;
            arrn2[n10] = (int)((float)arrn2[n10] + f * (float)n3);
            int[] arrn3 = arrn;
            int n11 = n2++;
            arrn3[n11] = (int)((float)arrn3[n11] + f * (float)n4);
            f = arrf[n++];
            int[] arrn4 = arrn;
            int n12 = n2++;
            arrn4[n12] = (int)((float)arrn4[n12] + f * (float)(n3 += n5));
            int[] arrn5 = arrn;
            int n13 = n2++;
            arrn5[n13] = (int)((float)arrn5[n13] + f * (float)(n4 += n6));
            f = arrf[n++];
            int[] arrn6 = arrn;
            int n14 = n2++;
            arrn6[n14] = (int)((float)arrn6[n14] + f * (float)(n3 += n5));
            int[] arrn7 = arrn;
            int n15 = n2++;
            arrn7[n15] = (int)((float)arrn7[n15] + f * (float)(n4 += n6));
            f = arrf[n++];
            int[] arrn8 = arrn;
            int n16 = n2++;
            arrn8[n16] = (int)((float)arrn8[n16] + f * (float)(n3 += n5));
            n3 += n5;
            int[] arrn9 = arrn;
            int n17 = n2++;
            arrn9[n17] = (int)((float)arrn9[n17] + f * (float)(n4 += n6));
            n4 += n6;
        }
        while (n2 < (n7 += 6)) {
            f = arrf[n++];
            int[] arrn10 = arrn;
            int n18 = n2++;
            arrn10[n18] = (int)((float)arrn10[n18] + f * (float)n3);
            n3 += n5;
            int[] arrn11 = arrn;
            int n19 = n2++;
            arrn11[n19] = (int)((float)arrn11[n19] + f * (float)n4);
            n4 += n6;
        }
        cm645.l = n3 / 128 >> 2;
        cm645.r = n4 / 128 >> 2;
        cm645.j = n << 8;
        return n2 >> 1;
    }

    private static int a(float[] arrf, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, int n7, Cm645 cm645) {
        n3 <<= 2;
        n4 <<= 2;
        n3 *= 128;
        n4 *= 128;
        n5 = n2 + (n >>= 8) - ((n7 >>= 8) - 1);
        if (n5 > n6) {
            n5 = n6;
        }
        cm645.l += cm645.y * (n5 - n2);
        cm645.r += cm645.p * (n5 - n2);
        while (n2 < (n5 -= 3)) {
            int[] arrn2 = arrn;
            int n8 = n2++;
            arrn2[n8] = (int)((float)arrn2[n8] + arrf[n--] * (float)n3);
            int[] arrn3 = arrn;
            int n9 = n2++;
            arrn3[n9] = (int)((float)arrn3[n9] + arrf[n--] * (float)(n3 += n4));
            int[] arrn4 = arrn;
            int n10 = n2++;
            arrn4[n10] = (int)((float)arrn4[n10] + arrf[n--] * (float)(n3 += n4));
            int[] arrn5 = arrn;
            int n11 = n2++;
            arrn5[n11] = (int)((float)arrn5[n11] + arrf[n--] * (float)(n3 += n4));
            n3 += n4;
        }
        while (n2 < (n5 += 3)) {
            int[] arrn6 = arrn;
            int n12 = n2++;
            arrn6[n12] = (int)((float)arrn6[n12] + arrf[n--] * (float)n3);
            n3 += n4;
        }
        cm645.b = n3 / 128 >> 2;
        cm645.j = n << 8;
        return n2;
    }

    private static int f(float f, float[] arrf, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, Cm645 cm645) {
        n3 <<= 2;
        n4 <<= 2;
        n5 <<= 2;
        n6 <<= 2;
        n3 *= 128;
        n5 *= 128;
        n4 *= 128;
        n6 *= 128;
        n7 = n2 + (n >>= 8) - ((n9 >>= 8) - 1);
        if (n7 > n8) {
            n7 = n8;
        }
        cm645.b += cm645.v * (n7 - n2);
        n2 <<= 1;
        n7 <<= 1;
        while (n2 < (n7 -= 6)) {
            f = arrf[n--];
            int[] arrn2 = arrn;
            int n10 = n2++;
            arrn2[n10] = (int)((float)arrn2[n10] + f * (float)n3);
            int[] arrn3 = arrn;
            int n11 = n2++;
            arrn3[n11] = (int)((float)arrn3[n11] + f * (float)n4);
            f = arrf[n--];
            int[] arrn4 = arrn;
            int n12 = n2++;
            arrn4[n12] = (int)((float)arrn4[n12] + f * (float)(n3 += n5));
            int[] arrn5 = arrn;
            int n13 = n2++;
            arrn5[n13] = (int)((float)arrn5[n13] + f * (float)(n4 += n6));
            f = arrf[n--];
            int[] arrn6 = arrn;
            int n14 = n2++;
            arrn6[n14] = (int)((float)arrn6[n14] + f * (float)(n3 += n5));
            int[] arrn7 = arrn;
            int n15 = n2++;
            arrn7[n15] = (int)((float)arrn7[n15] + f * (float)(n4 += n6));
            f = arrf[n--];
            int[] arrn8 = arrn;
            int n16 = n2++;
            arrn8[n16] = (int)((float)arrn8[n16] + f * (float)(n3 += n5));
            n3 += n5;
            int[] arrn9 = arrn;
            int n17 = n2++;
            arrn9[n17] = (int)((float)arrn9[n17] + f * (float)(n4 += n6));
            n4 += n6;
        }
        while (n2 < (n7 += 6)) {
            f = arrf[n--];
            int[] arrn10 = arrn;
            int n18 = n2++;
            arrn10[n18] = (int)((float)arrn10[n18] + f * (float)n3);
            n3 += n5;
            int[] arrn11 = arrn;
            int n19 = n2++;
            arrn11[n19] = (int)((float)arrn11[n19] + f * (float)n4);
            n4 += n6;
        }
        cm645.l = n3 / 128 >> 2;
        cm645.r = n4 / 128 >> 2;
        cm645.j = n << 8;
        return n2 >> 1;
    }

    private static int m(float f, int n, float[] arrf, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Cm645 cm645, int n9, float f2) {
        n4 *= 128;
        n5 *= 128;
        if (n9 == 0 || (n6 = n3 + (n8 - n2 + n9 - 257) / n9) > n7) {
            n6 = n7;
        }
        n3 <<= 1;
        while (n3 < (n6 <<= 1)) {
            n = n2 >> 8;
            f = arrf[n];
            f = f * 256.0f + (arrf[n + 1] - f) * (float)(n2 & 0xFF);
            int[] arrn2 = arrn;
            int n10 = n3++;
            arrn2[n10] = arrn2[n10] + ((int)(f * (float)n4) >> 6);
            int[] arrn3 = arrn;
            int n11 = n3++;
            arrn3[n11] = arrn3[n11] + ((int)(f * (float)n5) >> 6);
            n2 += n9;
        }
        if (n9 == 0 || (n6 = (n3 >> 1) + (n8 - n2 + n9 - 1) / n9) > n7) {
            n6 = n7;
        }
        while (n3 < (n6 <<= 1)) {
            f = arrf[n2 >> 8];
            f = f * 256.0f + (f2 - f) * (float)(n2 & 0xFF);
            int[] arrn4 = arrn;
            int n12 = n3++;
            arrn4[n12] = arrn4[n12] + ((int)(f * (float)n4) >> 6);
            int[] arrn5 = arrn;
            int n13 = n3++;
            arrn5[n13] = arrn5[n13] + ((int)(f * (float)n5) >> 6);
            n2 += n9;
        }
        cm645.j = n2;
        return n3 >> 1;
    }

    private static int aq(float f, int n, float[] arrf, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Cm645 cm645, int n9, float f2) {
        n4 *= 128;
        n5 *= 128;
        cm645.l -= cm645.y * n3;
        cm645.r -= cm645.p * n3;
        if (n9 == 0 || (n6 = n3 + (n8 + 256 - n2 + n9) / n9) > n7) {
            n6 = n7;
        }
        while (n3 < n6) {
            n = n2 >> 8;
            f = arrf[n - 1];
            int[] arrn2 = arrn;
            int n10 = n3++;
            arrn2[n10] = arrn2[n10] + ((int)((f * 256.0f + (arrf[n] - f) * (float)(n2 & 0xFF)) * (float)n4) >> 6);
            n4 += n5;
            n2 += n9;
        }
        if (n9 == 0 || (n6 = n3 + (n8 - n2 + n9) / n9) > n7) {
            n6 = n7;
        }
        f = f2;
        while (n3 < n6) {
            int[] arrn3 = arrn;
            int n11 = n3++;
            arrn3[n11] = arrn3[n11] + ((int)((f * 256.0f + (arrf[n2 >> 8] - f) * (float)(n2 & 0xFF)) * (float)n4) >> 6);
            n4 += n5;
            n2 += n9;
        }
        cm645.l += cm645.y * n3;
        cm645.r += cm645.p * n3;
        cm645.b = n4 / 128;
        cm645.j = n2;
        return n3;
    }

    private static int ai(float f, int n, float[] arrf, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, Cm645 cm645, int n11, float f2) {
        n4 *= 128;
        n6 *= 128;
        n5 *= 128;
        n7 *= 128;
        cm645.b -= cm645.v * n3;
        if (n11 == 0 || (n8 = n3 + (n10 + 256 - n2 + n11) / n11) > n9) {
            n8 = n9;
        }
        n3 <<= 1;
        while (n3 < (n8 <<= 1)) {
            n = n2 >> 8;
            f = arrf[n - 1];
            f = f * 256.0f + (arrf[n] - f) * (float)(n2 & 0xFF);
            int[] arrn2 = arrn;
            int n12 = n3++;
            arrn2[n12] = arrn2[n12] + ((int)(f * (float)n4) >> 6);
            n4 += n6;
            int[] arrn3 = arrn;
            int n13 = n3++;
            arrn3[n13] = arrn3[n13] + ((int)(f * (float)n5) >> 6);
            n5 += n7;
            n2 += n11;
        }
        if (n11 == 0 || (n8 = (n3 >> 1) + (n10 - n2 + n11) / n11) > n9) {
            n8 = n9;
        }
        while (n3 < (n8 <<= 1)) {
            f = f2 * 256.0f + (arrf[n2 >> 8] - f2) * (float)(n2 & 0xFF);
            int[] arrn4 = arrn;
            int n14 = n3++;
            arrn4[n14] = arrn4[n14] + ((int)(f * (float)n4) >> 6);
            n4 += n6;
            int[] arrn5 = arrn;
            int n15 = n3++;
            arrn5[n15] = arrn5[n15] + ((int)(f * (float)n5) >> 6);
            n5 += n7;
            n2 += n11;
        }
        cm645.b += cm645.v * (n3 >>= 1);
        cm645.l = n4 / 128;
        cm645.r = n5 / 128;
        cm645.j = n2;
        return n3;
    }

    protected Cm645(Ci646 ci646, int n, int n2) {
        this.bm = ci646;
        this.u = ci646.d;
        this.z = ci646.q;
        this.t = ci646.j;
        this.e = n;
        this.h = n2;
        this.s = 8192;
        this.j = 0;
        Cm645.bd(this);
    }

    private static int k(float f, int n, float[] arrf, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Cm645 cm645, int n9, float f2) {
        n4 *= 128;
        n5 *= 128;
        if (n9 == 0 || (n6 = n3 + (n8 + 256 - n2 + n9) / n9) > n7) {
            n6 = n7;
        }
        n3 <<= 1;
        while (n3 < (n6 <<= 1)) {
            n = n2 >> 8;
            f = arrf[n - 1];
            f = f * 256.0f + (arrf[n] - f) * (float)(n2 & 0xFF);
            int[] arrn2 = arrn;
            int n10 = n3++;
            arrn2[n10] = arrn2[n10] + ((int)(f * (float)n4) >> 6);
            int[] arrn3 = arrn;
            int n11 = n3++;
            arrn3[n11] = arrn3[n11] + ((int)(f * (float)n5) >> 6);
            n2 += n9;
        }
        if (n9 == 0 || (n6 = (n3 >> 1) + (n8 - n2 + n9) / n9) > n7) {
            n6 = n7;
        }
        while (n3 < (n6 <<= 1)) {
            f = f2 * 256.0f + (arrf[n2 >> 8] - f2) * (float)(n2 & 0xFF);
            int[] arrn4 = arrn;
            int n12 = n3++;
            arrn4[n12] = arrn4[n12] + ((int)(f * (float)n4) >> 6);
            int[] arrn5 = arrn;
            int n13 = n3++;
            arrn5[n13] = arrn5[n13] + ((int)(f * (float)n5) >> 6);
            n2 += n9;
        }
        cm645.j = n2;
        return n3 >> 1;
    }

    /*
     * Exception decompiling
     */
    @Override
    public synchronized void j(int[] var1_1, int var2_2, int var3_3) throws IllegalStateException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[DOLOOP]], but top level block is 29[SIMPLE_IF_TAKEN]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:619)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:699)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:188)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:133)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:225)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:109)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        // org.runestar.tfudeob.MainKt.decompileCfr(Main.kt:49)
        // org.runestar.tfudeob.MainKt.deob(Main.kt:37)
        // org.runestar.tfudeob.MainKt.main(Main.kt:11)
        // org.runestar.tfudeob.MainKt.main(Main.kt)
        throw new IllegalStateException("Decompilation failed");
    }

    private static int c(float f, int n, float[] arrf, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, int n8, Cm645 cm645, int n9, float f2) {
        n4 *= 128;
        n5 *= 128;
        cm645.l -= cm645.y * n3;
        cm645.r -= cm645.p * n3;
        if (n9 == 0 || (n6 = n3 + (n8 - n2 + n9 - 257) / n9) > n7) {
            n6 = n7;
        }
        while (n3 < n6) {
            n = n2 >> 8;
            f = arrf[n];
            int[] arrn2 = arrn;
            int n10 = n3++;
            arrn2[n10] = arrn2[n10] + ((int)((f * 256.0f + (arrf[n + 1] - f) * (float)(n2 & 0xFF)) * (float)n4) >> 6);
            n4 += n5;
            n2 += n9;
        }
        if (n9 == 0 || (n6 = n3 + (n8 - n2 + n9 - 1) / n9) > n7) {
            n6 = n7;
        }
        while (n3 < n6) {
            f = arrf[n2 >> 8];
            int[] arrn3 = arrn;
            int n11 = n3++;
            arrn3[n11] = arrn3[n11] + ((int)((f * 256.0f + (f2 - f) * (float)(n2 & 0xFF)) * (float)n4) >> 6);
            n4 += n5;
            n2 += n9;
        }
        cm645.l += cm645.y * n3;
        cm645.r += cm645.p * n3;
        cm645.b = n4 / 128;
        cm645.j = n2;
        return n3;
    }

    private static int z(float f, float[] arrf, int[] arrn, int n, int n2, int n3, int n4, int n5, int n6, int n7, Cm645 cm645) {
        n3 <<= 2;
        n4 <<= 2;
        n3 *= 128;
        n4 *= 128;
        n5 = n2 + (n >>= 8) - ((n7 >>= 8) - 1);
        if (n5 > n6) {
            n5 = n6;
        }
        n2 <<= 1;
        n5 <<= 1;
        while (n2 < (n5 -= 6)) {
            f = arrf[n--];
            int[] arrn2 = arrn;
            int n8 = n2++;
            arrn2[n8] = (int)((float)arrn2[n8] + f * (float)n3);
            int[] arrn3 = arrn;
            int n9 = n2++;
            arrn3[n9] = (int)((float)arrn3[n9] + f * (float)n4);
            f = arrf[n--];
            int[] arrn4 = arrn;
            int n10 = n2++;
            arrn4[n10] = (int)((float)arrn4[n10] + f * (float)n3);
            int[] arrn5 = arrn;
            int n11 = n2++;
            arrn5[n11] = (int)((float)arrn5[n11] + f * (float)n4);
            f = arrf[n--];
            int[] arrn6 = arrn;
            int n12 = n2++;
            arrn6[n12] = (int)((float)arrn6[n12] + f * (float)n3);
            int[] arrn7 = arrn;
            int n13 = n2++;
            arrn7[n13] = (int)((float)arrn7[n13] + f * (float)n4);
            f = arrf[n--];
            int[] arrn8 = arrn;
            int n14 = n2++;
            arrn8[n14] = (int)((float)arrn8[n14] + f * (float)n3);
            int[] arrn9 = arrn;
            int n15 = n2++;
            arrn9[n15] = (int)((float)arrn9[n15] + f * (float)n4);
        }
        while (n2 < (n5 += 6)) {
            f = arrf[n--];
            int[] arrn10 = arrn;
            int n16 = n2++;
            arrn10[n16] = (int)((float)arrn10[n16] + f * (float)n3);
            int[] arrn11 = arrn;
            int n17 = n2++;
            arrn11[n17] = (int)((float)arrn11[n17] + f * (float)n4);
        }
        cm645.j = n << 8;
        return n2 >> 1;
    }
}

