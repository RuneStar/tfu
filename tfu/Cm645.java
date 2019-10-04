// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Cm645 extends Cs635
{
    private static final int d = 128;
    private static final boolean g = true;
    
    private static int h(final Cm645 cm645, final int[] array, int n, final int n2, final int n3, final float n4) {
        while (cm645.m > 0) {
            int n5 = n + cm645.m;
            if (n5 > n3) {
                n5 = n3;
            }
            cm645.m += n;
            if (cm645.e == 256 && (cm645.j & 0xFF) == 0x0) {
                if (Cd585.s) {
                    n = o(0.0f, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.l, cm645.r, cm645.y, cm645.p, 0, n5, n2, cm645);
                }
                else {
                    n = i(Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.b, cm645.v, 0, n5, n2, cm645);
                }
            }
            else if (Cd585.s) {
                n = ag(0.0f, 0, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.l, cm645.r, cm645.y, cm645.p, 0, n5, n2, cm645, cm645.e, n4);
            }
            else {
                n = c(0.0f, 0, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.b, cm645.v, 0, n5, n2, cm645, cm645.e, n4);
            }
            cm645.m -= n;
            if (cm645.m != 0) {
                return n;
            }
            if (Cs635.bg(cm645)) {
                return n3;
            }
        }
        if (cm645.e == 256 && (cm645.j & 0xFF) == 0x0) {
            if (Cd585.s) {
                return v(0.0f, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.l, cm645.r, 0, n3, n2, cm645);
            }
            return r(Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.b, 0, n3, n2, cm645);
        }
        else {
            if (Cd585.s) {
                return m(0.0f, 0, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.l, cm645.r, 0, n3, n2, cm645, cm645.e, n4);
            }
            return t(0.0f, 0, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.b, 0, n3, n2, cm645, cm645.e, n4);
        }
    }
    
    protected Cm645(final Ci646 bm, final int e, final int h, final int s) {
        super.bm = bm;
        super.u = bm.d;
        super.z = bm.q;
        super.t = bm.j;
        super.e = e;
        super.h = h;
        super.s = s;
        super.j = 0;
        Cs635.bd(this);
    }
    
    private static int ag(float n, int n2, final float[] array, final int[] array2, int j, int i, int n3, int n4, int n5, int n6, int n7, final int n8, final int n9, final Cm645 cm645, final int n10, final float n11) {
        n3 *= 128;
        n5 *= 128;
        n4 *= 128;
        n6 *= 128;
        cm645.b -= cm645.v * i;
        if (n10 == 0 || (n7 = i + (n9 - j + n10 - 257) / n10) > n8) {
            n7 = n8;
        }
        int n12;
        int n13;
        for (i <<= 1, n7 <<= 1; i < n7; n12 = i++, array2[n12] += (int)(n * n3) >> 6, n3 += n5, n13 = i++, array2[n13] += (int)(n * n4) >> 6, n4 += n6, j += n10) {
            n2 = j >> 8;
            n = array[n2];
            n = n * 256.0f + (array[n2 + 1] - n) * (j & 0xFF);
        }
        if (n10 == 0 || (n7 = (i >> 1) + (n9 - j + n10 - 1) / n10) > n8) {
            n7 = n8;
        }
        int n14;
        int n15;
        for (n7 <<= 1; i < n7; n14 = i++, array2[n14] += (int)(n * n3) >> 6, n3 += n5, n15 = i++, array2[n15] += (int)(n * n4) >> 6, n4 += n6, j += n10) {
            n = array[j >> 8];
            n = n * 256.0f + (n11 - n) * (j & 0xFF);
        }
        i >>= 1;
        cm645.b += cm645.v * i;
        cm645.l = n3 / 128;
        cm645.r = n4 / 128;
        cm645.j = j;
        return i;
    }
    
    private static int s(final Cm645 cm645, final int[] array, int n, final int n2, final int n3, final float n4) {
        while (cm645.m > 0) {
            int n5 = n + cm645.m;
            if (n5 > n3) {
                n5 = n3;
            }
            cm645.m += n;
            if (cm645.e == -256 && (cm645.j & 0xFF) == 0x0) {
                if (Cd585.s) {
                    n = f(0.0f, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.l, cm645.r, cm645.y, cm645.p, 0, n5, n2, cm645);
                }
                else {
                    n = a(Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.b, cm645.v, 0, n5, n2, cm645);
                }
            }
            else if (Cd585.s) {
                n = ai(0.0f, 0, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.l, cm645.r, cm645.y, cm645.p, 0, n5, n2, cm645, cm645.e, n4);
            }
            else {
                n = aq(0.0f, 0, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.b, cm645.v, 0, n5, n2, cm645, cm645.e, n4);
            }
            cm645.m -= n;
            if (cm645.m != 0) {
                return n;
            }
            if (Cs635.bg(cm645)) {
                return n3;
            }
        }
        if (cm645.e == -256 && (cm645.j & 0xFF) == 0x0) {
            if (Cd585.s) {
                return z(0.0f, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.l, cm645.r, 0, n3, n2, cm645);
            }
            return u(Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.b, 0, n3, n2, cm645);
        }
        else {
            if (Cd585.s) {
                return k(0.0f, 0, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.l, cm645.r, 0, n3, n2, cm645, cm645.e, n4);
            }
            return n(0.0f, 0, Ci646.l((Ci646)cm645.bm), array, cm645.j, n, cm645.b, 0, n3, n2, cm645, cm645.e, n4);
        }
    }
    
    private static int r(final float[] array, final int[] array2, int n, int i, int n2, int n3, final int n4, int n5, final Cm645 cm645) {
        n >>= 8;
        n5 >>= 8;
        n2 <<= 2;
        n2 *= 128;
        if ((n3 = i + n5 - n) > n4) {
            n3 = n4;
        }
        int n6;
        int n7;
        int n8;
        int n9;
        for (n3 -= 3; i < n3; n6 = i++, array2[n6] += (int)(array[n++] * n2), n7 = i++, array2[n7] += (int)(array[n++] * n2), n8 = i++, array2[n8] += (int)(array[n++] * n2), n9 = i++, array2[n9] += (int)(array[n++] * n2)) {}
        int n10;
        for (n3 += 3; i < n3; n10 = i++, array2[n10] += (int)(array[n++] * n2)) {}
        cm645.j = n << 8;
        return i;
    }
    
    private static int v(float n, final float[] array, final int[] array2, int n2, int i, int n3, int n4, int n5, final int n6, int n7, final Cm645 cm645) {
        n2 >>= 8;
        n7 >>= 8;
        n3 <<= 2;
        n4 <<= 2;
        n3 *= 128;
        n4 *= 128;
        if ((n5 = i + n7 - n2) > n6) {
            n5 = n6;
        }
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        for (i <<= 1, n5 <<= 1, n5 -= 6; i < n5; n8 = i++, array2[n8] += (int)(n * n3), n9 = i++, array2[n9] += (int)(n * n4), n = array[n2++], n10 = i++, array2[n10] += (int)(n * n3), n11 = i++, array2[n11] += (int)(n * n4), n = array[n2++], n12 = i++, array2[n12] += (int)(n * n3), n13 = i++, array2[n13] += (int)(n * n4), n = array[n2++], n14 = i++, array2[n14] += (int)(n * n3), n15 = i++, array2[n15] += (int)(n * n4)) {
            n = array[n2++];
        }
        int n16;
        int n17;
        for (n5 += 6; i < n5; n16 = i++, array2[n16] += (int)(n * n3), n17 = i++, array2[n17] += (int)(n * n4)) {
            n = array[n2++];
        }
        cm645.j = n2 << 8;
        return i >> 1;
    }
    
    private static int u(final float[] array, final int[] array2, int n, int i, int n2, int n3, final int n4, int n5, final Cm645 cm645) {
        n >>= 8;
        n5 >>= 8;
        n2 <<= 2;
        n2 *= 128;
        if ((n3 = i + n - (n5 - 1)) > n4) {
            n3 = n4;
        }
        int n6;
        int n7;
        int n8;
        int n9;
        for (n3 -= 3; i < n3; n6 = i++, array2[n6] += (int)(array[n--] * n2), n7 = i++, array2[n7] += (int)(array[n--] * n2), n8 = i++, array2[n8] += (int)(array[n--] * n2), n9 = i++, array2[n9] += (int)(array[n--] * n2)) {}
        int n10;
        for (n3 += 3; i < n3; n10 = i++, array2[n10] += (int)(array[n--] * n2)) {}
        cm645.j = n << 8;
        return i;
    }
    
    private static int t(float n, int n2, final float[] array, final int[] array2, int j, int i, int n3, int n4, final int n5, final int n6, final Cm645 cm645, final int n7, final float n8) {
        n3 *= 128;
        if (n7 == 0 || (n4 = i + (n6 - j + n7 - 257) / n7) > n5) {
            n4 = n5;
        }
        while (i < n4) {
            n2 = j >> 8;
            n = array[n2];
            final int n9 = i++;
            array2[n9] += (int)((n * 256.0f + (array[n2 + 1] - n) * (j & 0xFF)) * n3) >> 6;
            j += n7;
        }
        if (n7 == 0 || (n4 = i + (n6 - j + n7 - 1) / n7) > n5) {
            n4 = n5;
        }
        while (i < n4) {
            n = array[j >> 8];
            final int n10 = i++;
            array2[n10] += (int)((n * 256.0f + (n8 - n) * (j & 0xFF)) * n3) >> 6;
            j += n7;
        }
        cm645.j = j;
        return i;
    }
    
    private static int n(float n, int n2, final float[] array, final int[] array2, int j, int i, int n3, int n4, final int n5, final int n6, final Cm645 cm645, final int n7, final float n8) {
        n3 *= 128;
        if (n7 == 0 || (n4 = i + (n6 + 256 - j + n7) / n7) > n5) {
            n4 = n5;
        }
        while (i < n4) {
            n2 = j >> 8;
            n = array[n2 - 1];
            final int n9 = i++;
            array2[n9] += (int)((n * 256.0f + (array[n2] - n) * (j & 0xFF)) * n3) >> 6;
            j += n7;
        }
        if (n7 == 0 || (n4 = i + (n6 - j + n7) / n7) > n5) {
            n4 = n5;
        }
        int n10;
        for (n = n8; i < n4; n10 = i++, array2[n10] += (int)((n * 256.0f + (array[j >> 8] - n) * (j & 0xFF)) * n3) >> 6, j += n7) {}
        cm645.j = j;
        return i;
    }
    
    private static int i(final float[] array, final int[] array2, int n, int i, int n2, int n3, int n4, final int n5, int n6, final Cm645 cm645) {
        n >>= 8;
        n6 >>= 8;
        n2 <<= 2;
        n3 <<= 2;
        n2 *= 128;
        n3 *= 128;
        if ((n4 = i + n6 - n) > n5) {
            n4 = n5;
        }
        cm645.l += cm645.y * (n4 - i);
        cm645.r += cm645.p * (n4 - i);
        int n7;
        int n8;
        int n9;
        int n10;
        for (n4 -= 3; i < n4; n7 = i++, array2[n7] += (int)(array[n++] * n2), n2 += n3, n8 = i++, array2[n8] += (int)(array[n++] * n2), n2 += n3, n9 = i++, array2[n9] += (int)(array[n++] * n2), n2 += n3, n10 = i++, array2[n10] += (int)(array[n++] * n2), n2 += n3) {}
        int n11;
        for (n4 += 3; i < n4; n11 = i++, array2[n11] += (int)(array[n++] * n2), n2 += n3) {}
        cm645.b = n2 / 128 >> 2;
        cm645.j = n << 8;
        return i;
    }
    
    private static int o(float n, final float[] array, final int[] array2, int n2, int i, int n3, int n4, int n5, int n6, int n7, final int n8, int n9, final Cm645 cm645) {
        n2 >>= 8;
        n9 >>= 8;
        n3 <<= 2;
        n4 <<= 2;
        n5 <<= 2;
        n6 <<= 2;
        n3 *= 128;
        n5 *= 128;
        n4 *= 128;
        n6 *= 128;
        if ((n7 = i + n9 - n2) > n8) {
            n7 = n8;
        }
        cm645.b += cm645.v * (n7 - i);
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        for (i <<= 1, n7 <<= 1, n7 -= 6; i < n7; n10 = i++, array2[n10] += (int)(n * n3), n3 += n5, n11 = i++, array2[n11] += (int)(n * n4), n4 += n6, n = array[n2++], n12 = i++, array2[n12] += (int)(n * n3), n3 += n5, n13 = i++, array2[n13] += (int)(n * n4), n4 += n6, n = array[n2++], n14 = i++, array2[n14] += (int)(n * n3), n3 += n5, n15 = i++, array2[n15] += (int)(n * n4), n4 += n6, n = array[n2++], n16 = i++, array2[n16] += (int)(n * n3), n3 += n5, n17 = i++, array2[n17] += (int)(n * n4), n4 += n6) {
            n = array[n2++];
        }
        int n18;
        int n19;
        for (n7 += 6; i < n7; n18 = i++, array2[n18] += (int)(n * n3), n3 += n5, n19 = i++, array2[n19] += (int)(n * n4), n4 += n6) {
            n = array[n2++];
        }
        cm645.l = n3 / 128 >> 2;
        cm645.r = n4 / 128 >> 2;
        cm645.j = n2 << 8;
        return i >> 1;
    }
    
    private static int a(final float[] array, final int[] array2, int n, int i, int n2, int n3, int n4, final int n5, int n6, final Cm645 cm645) {
        n >>= 8;
        n6 >>= 8;
        n2 <<= 2;
        n3 <<= 2;
        n2 *= 128;
        n3 *= 128;
        if ((n4 = i + n - (n6 - 1)) > n5) {
            n4 = n5;
        }
        cm645.l += cm645.y * (n4 - i);
        cm645.r += cm645.p * (n4 - i);
        int n7;
        int n8;
        int n9;
        int n10;
        for (n4 -= 3; i < n4; n7 = i++, array2[n7] += (int)(array[n--] * n2), n2 += n3, n8 = i++, array2[n8] += (int)(array[n--] * n2), n2 += n3, n9 = i++, array2[n9] += (int)(array[n--] * n2), n2 += n3, n10 = i++, array2[n10] += (int)(array[n--] * n2), n2 += n3) {}
        int n11;
        for (n4 += 3; i < n4; n11 = i++, array2[n11] += (int)(array[n--] * n2), n2 += n3) {}
        cm645.b = n2 / 128 >> 2;
        cm645.j = n << 8;
        return i;
    }
    
    private static int f(float n, final float[] array, final int[] array2, int n2, int i, int n3, int n4, int n5, int n6, int n7, final int n8, int n9, final Cm645 cm645) {
        n2 >>= 8;
        n9 >>= 8;
        n3 <<= 2;
        n4 <<= 2;
        n5 <<= 2;
        n6 <<= 2;
        n3 *= 128;
        n5 *= 128;
        n4 *= 128;
        n6 *= 128;
        if ((n7 = i + n2 - (n9 - 1)) > n8) {
            n7 = n8;
        }
        cm645.b += cm645.v * (n7 - i);
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        for (i <<= 1, n7 <<= 1, n7 -= 6; i < n7; n10 = i++, array2[n10] += (int)(n * n3), n3 += n5, n11 = i++, array2[n11] += (int)(n * n4), n4 += n6, n = array[n2--], n12 = i++, array2[n12] += (int)(n * n3), n3 += n5, n13 = i++, array2[n13] += (int)(n * n4), n4 += n6, n = array[n2--], n14 = i++, array2[n14] += (int)(n * n3), n3 += n5, n15 = i++, array2[n15] += (int)(n * n4), n4 += n6, n = array[n2--], n16 = i++, array2[n16] += (int)(n * n3), n3 += n5, n17 = i++, array2[n17] += (int)(n * n4), n4 += n6) {
            n = array[n2--];
        }
        int n18;
        int n19;
        for (n7 += 6; i < n7; n18 = i++, array2[n18] += (int)(n * n3), n3 += n5, n19 = i++, array2[n19] += (int)(n * n4), n4 += n6) {
            n = array[n2--];
        }
        cm645.l = n3 / 128 >> 2;
        cm645.r = n4 / 128 >> 2;
        cm645.j = n2 << 8;
        return i >> 1;
    }
    
    private static int m(float n, int n2, final float[] array, final int[] array2, int j, int i, int n3, int n4, int n5, final int n6, final int n7, final Cm645 cm645, final int n8, final float n9) {
        n3 *= 128;
        n4 *= 128;
        if (n8 == 0 || (n5 = i + (n7 - j + n8 - 257) / n8) > n6) {
            n5 = n6;
        }
        int n10;
        int n11;
        for (i <<= 1, n5 <<= 1; i < n5; n10 = i++, array2[n10] += (int)(n * n3) >> 6, n11 = i++, array2[n11] += (int)(n * n4) >> 6, j += n8) {
            n2 = j >> 8;
            n = array[n2];
            n = n * 256.0f + (array[n2 + 1] - n) * (j & 0xFF);
        }
        if (n8 == 0 || (n5 = (i >> 1) + (n7 - j + n8 - 1) / n8) > n6) {
            n5 = n6;
        }
        int n12;
        int n13;
        for (n5 <<= 1; i < n5; n12 = i++, array2[n12] += (int)(n * n3) >> 6, n13 = i++, array2[n13] += (int)(n * n4) >> 6, j += n8) {
            n = array[j >> 8];
            n = n * 256.0f + (n9 - n) * (j & 0xFF);
        }
        cm645.j = j;
        return i >> 1;
    }
    
    private static int aq(float n, int n2, final float[] array, final int[] array2, int j, int i, int n3, int n4, int n5, final int n6, final int n7, final Cm645 cm645, final int n8, final float n9) {
        n3 *= 128;
        n4 *= 128;
        cm645.l -= cm645.y * i;
        cm645.r -= cm645.p * i;
        if (n8 == 0 || (n5 = i + (n7 + 256 - j + n8) / n8) > n6) {
            n5 = n6;
        }
        while (i < n5) {
            n2 = j >> 8;
            n = array[n2 - 1];
            final int n10 = i++;
            array2[n10] += (int)((n * 256.0f + (array[n2] - n) * (j & 0xFF)) * n3) >> 6;
            n3 += n4;
            j += n8;
        }
        if (n8 == 0 || (n5 = i + (n7 - j + n8) / n8) > n6) {
            n5 = n6;
        }
        int n11;
        for (n = n9; i < n5; n11 = i++, array2[n11] += (int)((n * 256.0f + (array[j >> 8] - n) * (j & 0xFF)) * n3) >> 6, n3 += n4, j += n8) {}
        cm645.l += cm645.y * i;
        cm645.r += cm645.p * i;
        cm645.b = n3 / 128;
        cm645.j = j;
        return i;
    }
    
    private static int ai(float n, int n2, final float[] array, final int[] array2, int j, int i, int n3, int n4, int n5, int n6, int n7, final int n8, final int n9, final Cm645 cm645, final int n10, final float n11) {
        n3 *= 128;
        n5 *= 128;
        n4 *= 128;
        n6 *= 128;
        cm645.b -= cm645.v * i;
        if (n10 == 0 || (n7 = i + (n9 + 256 - j + n10) / n10) > n8) {
            n7 = n8;
        }
        int n12;
        int n13;
        for (i <<= 1, n7 <<= 1; i < n7; n12 = i++, array2[n12] += (int)(n * n3) >> 6, n3 += n5, n13 = i++, array2[n13] += (int)(n * n4) >> 6, n4 += n6, j += n10) {
            n2 = j >> 8;
            n = array[n2 - 1];
            n = n * 256.0f + (array[n2] - n) * (j & 0xFF);
        }
        if (n10 == 0 || (n7 = (i >> 1) + (n9 - j + n10) / n10) > n8) {
            n7 = n8;
        }
        int n14;
        int n15;
        for (n7 <<= 1; i < n7; n14 = i++, array2[n14] += (int)(n * n3) >> 6, n3 += n5, n15 = i++, array2[n15] += (int)(n * n4) >> 6, n4 += n6, j += n10) {
            n = n11 * 256.0f + (array[j >> 8] - n11) * (j & 0xFF);
        }
        i >>= 1;
        cm645.b += cm645.v * i;
        cm645.l = n3 / 128;
        cm645.r = n4 / 128;
        cm645.j = j;
        return i;
    }
    
    protected Cm645(final Ci646 bm, final int e, final int h) {
        super.bm = bm;
        super.u = bm.d;
        super.z = bm.q;
        super.t = bm.j;
        super.e = e;
        super.h = h;
        super.s = 8192;
        super.j = 0;
        Cs635.bd(this);
    }
    
    private static int k(float n, int n2, final float[] array, final int[] array2, int j, int i, int n3, int n4, int n5, final int n6, final int n7, final Cm645 cm645, final int n8, final float n9) {
        n3 *= 128;
        n4 *= 128;
        if (n8 == 0 || (n5 = i + (n7 + 256 - j + n8) / n8) > n6) {
            n5 = n6;
        }
        int n10;
        int n11;
        for (i <<= 1, n5 <<= 1; i < n5; n10 = i++, array2[n10] += (int)(n * n3) >> 6, n11 = i++, array2[n11] += (int)(n * n4) >> 6, j += n8) {
            n2 = j >> 8;
            n = array[n2 - 1];
            n = n * 256.0f + (array[n2] - n) * (j & 0xFF);
        }
        if (n8 == 0 || (n5 = (i >> 1) + (n7 - j + n8) / n8) > n6) {
            n5 = n6;
        }
        int n12;
        int n13;
        for (n5 <<= 1; i < n5; n12 = i++, array2[n12] += (int)(n * n3) >> 6, n13 = i++, array2[n13] += (int)(n * n4) >> 6, j += n8) {
            n = n9 * 256.0f + (array[j >> 8] - n9) * (j & 0xFF);
        }
        cm645.j = j;
        return i >> 1;
    }
    
    @Override
    public synchronized void j(final int[] array, final int n, int n2) throws IllegalStateException {
        if (super.h == 0 && super.m == 0) {
            this.e(n2);
            return;
        }
        final int n3 = super.u << 8;
        final int n4 = super.z << 8;
        final int j = ((Ci646)super.bm).g() << 8;
        final int n5 = n4 - n3;
        if (n5 <= 0) {
            super.x = 0;
        }
        int n6 = n;
        n2 += n;
        if (super.j < 0) {
            if (super.e <= 0) {
                Cs635.bx(this);
                Ln265.ef(this);
                return;
            }
            super.j = 0;
        }
        if (super.j >= j) {
            if (super.e >= 0) {
                Cs635.bx(this);
                Ln265.ef(this);
                return;
            }
            super.j = j - 1;
        }
        if (super.x >= 0) {
            Label_0974: {
                if (super.x > 0) {
                    if (super.t) {
                        if (super.e < 0) {
                            n6 = s(this, array, n6, n3, n2, Ci646.l((Ci646)super.bm)[super.u]);
                            if (super.j >= n3) {
                                return;
                            }
                            super.j = n3 + n3 - 1 - super.j;
                            super.e = -super.e;
                            if (--super.x == 0) {
                                break Label_0974;
                            }
                        }
                        do {
                            n6 = h(this, array, n6, n4, n2, Ci646.l((Ci646)super.bm)[super.z - 1]);
                            if (super.j < n4) {
                                return;
                            }
                            super.j = n4 + n4 - 1 - super.j;
                            super.e = -super.e;
                            if (--super.x == 0) {
                                break;
                            }
                            n6 = s(this, array, n6, n3, n2, Ci646.l((Ci646)super.bm)[super.u]);
                            if (super.j >= n3) {
                                return;
                            }
                            super.j = n3 + n3 - 1 - super.j;
                            super.e = -super.e;
                        } while (--super.x != 0);
                    }
                    else if (super.e < 0) {
                        while (true) {
                            n6 = s(this, array, n6, n3, n2, Ci646.l((Ci646)super.bm)[super.z - 1]);
                            if (super.j >= n3) {
                                return;
                            }
                            final int n7 = (n4 - 1 - super.j) / n5;
                            if (n7 >= super.x) {
                                super.j += n5 * super.x;
                                super.x = 0;
                                break;
                            }
                            super.j += n5 * n7;
                            super.x -= n7;
                        }
                    }
                    else {
                        while (true) {
                            n6 = h(this, array, n6, n4, n2, Ci646.l((Ci646)super.bm)[super.u]);
                            if (super.j < n4) {
                                return;
                            }
                            final int n8 = (super.j - n3) / n5;
                            if (n8 >= super.x) {
                                super.j -= n5 * super.x;
                                super.x = 0;
                                break;
                            }
                            super.j -= n5 * n8;
                            super.x -= n8;
                        }
                    }
                }
            }
            if (super.e < 0) {
                s(this, array, n6, 0, n2, 0.0f);
                if (super.j < 0) {
                    super.j = -1;
                    Cs635.bx(this);
                    Ln265.ef(this);
                }
            }
            else {
                h(this, array, n6, j, n2, 0.0f);
                if (super.j >= j) {
                    super.j = j;
                    Cs635.bx(this);
                    Ln265.ef(this);
                }
            }
            if (Ci646.w((Ci646)super.bm)) {
                int i = super.j >> 8;
                if ((super.j & 0xFF) != 0x0) {
                    ++i;
                }
                if (i >= Ci646.l((Ci646)super.bm).length) {
                    i = Ci646.l((Ci646)super.bm).length - 1;
                }
                if (i > Ci646.r((Ci646)super.bm)) {
                    System.out.println("WaveStreamFP - attempted to play sound beyond streaming decode progress. Position accessed: " + i + ", streaming progress: " + Ci646.r((Ci646)super.bm));
                }
            }
            return;
        }
        if (super.t) {
            if (super.e < 0) {
                n6 = s(this, array, n6, n3, n2, Ci646.l((Ci646)super.bm)[super.u]);
                if (super.j >= n3) {
                    return;
                }
                super.j = n3 + n3 - 1 - super.j;
                super.e = -super.e;
            }
            while (true) {
                final int h = h(this, array, n6, n4, n2, Ci646.l((Ci646)super.bm)[super.z - 1]);
                if (super.j < n4) {
                    return;
                }
                super.j = n4 + n4 - 1 - super.j;
                super.e = -super.e;
                n6 = s(this, array, h, n3, n2, Ci646.l((Ci646)super.bm)[super.u]);
                if (super.j >= n3) {
                    return;
                }
                super.j = n3 + n3 - 1 - super.j;
                super.e = -super.e;
            }
        }
        else {
            if (super.e < 0) {
                while (true) {
                    n6 = s(this, array, n6, n3, n2, Ci646.l((Ci646)super.bm)[super.z - 1]);
                    if (super.j >= n3) {
                        break;
                    }
                    super.j = n4 - 1 - (n4 - 1 - super.j) % n5;
                }
                return;
            }
            while (true) {
                n6 = h(this, array, n6, n4, n2, Ci646.l((Ci646)super.bm)[super.u]);
                if (super.j < n4) {
                    break;
                }
                super.j = n3 + (super.j - n3) % n5;
            }
        }
    }
    
    private static int c(float n, int n2, final float[] array, final int[] array2, int j, int i, int n3, int n4, int n5, final int n6, final int n7, final Cm645 cm645, final int n8, final float n9) {
        n3 *= 128;
        n4 *= 128;
        cm645.l -= cm645.y * i;
        cm645.r -= cm645.p * i;
        if (n8 == 0 || (n5 = i + (n7 - j + n8 - 257) / n8) > n6) {
            n5 = n6;
        }
        while (i < n5) {
            n2 = j >> 8;
            n = array[n2];
            final int n10 = i++;
            array2[n10] += (int)((n * 256.0f + (array[n2 + 1] - n) * (j & 0xFF)) * n3) >> 6;
            n3 += n4;
            j += n8;
        }
        if (n8 == 0 || (n5 = i + (n7 - j + n8 - 1) / n8) > n6) {
            n5 = n6;
        }
        while (i < n5) {
            n = array[j >> 8];
            final int n11 = i++;
            array2[n11] += (int)((n * 256.0f + (n9 - n) * (j & 0xFF)) * n3) >> 6;
            n3 += n4;
            j += n8;
        }
        cm645.l += cm645.y * i;
        cm645.r += cm645.p * i;
        cm645.b = n3 / 128;
        cm645.j = j;
        return i;
    }
    
    private static int z(float n, final float[] array, final int[] array2, int n2, int i, int n3, int n4, int n5, final int n6, int n7, final Cm645 cm645) {
        n2 >>= 8;
        n7 >>= 8;
        n3 <<= 2;
        n4 <<= 2;
        n3 *= 128;
        n4 *= 128;
        if ((n5 = i + n2 - (n7 - 1)) > n6) {
            n5 = n6;
        }
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        for (i <<= 1, n5 <<= 1, n5 -= 6; i < n5; n8 = i++, array2[n8] += (int)(n * n3), n9 = i++, array2[n9] += (int)(n * n4), n = array[n2--], n10 = i++, array2[n10] += (int)(n * n3), n11 = i++, array2[n11] += (int)(n * n4), n = array[n2--], n12 = i++, array2[n12] += (int)(n * n3), n13 = i++, array2[n13] += (int)(n * n4), n = array[n2--], n14 = i++, array2[n14] += (int)(n * n3), n15 = i++, array2[n15] += (int)(n * n4)) {
            n = array[n2--];
        }
        int n16;
        int n17;
        for (n5 += 6; i < n5; n16 = i++, array2[n16] += (int)(n * n3), n17 = i++, array2[n17] += (int)(n * n4)) {
            n = array[n2--];
        }
        cm645.j = n2 << 8;
        return i >> 1;
    }
}
