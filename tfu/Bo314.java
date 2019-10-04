/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Comparator;
import java.util.Random;
import tfu.Ad562;
import tfu.Aj540;
import tfu.Ak315;
import tfu.Ar552;
import tfu.Au658;
import tfu.Ax659;
import tfu.Bq656;
import tfu.Jz233;

public class Bo314 {
    public static Ak315 g(Object[] arrobject) {
        return Bo314.j(null, arrobject, 0, arrobject.length);
    }

    private static int[] e(int n) {
        int[] arrn = new int[n];
        for (int i = 0; i < n; ++i) {
            arrn[i] = i;
        }
        return arrn;
    }

    public static Ak315 q(Random random, short[] arrs, int n, int n2) {
        int[] arrn = Bo314.e(n2);
        for (int i = 0; i < n2; ++i) {
            int n3 = i + Jz233.r(random, n2 - i);
            short s = arrs[n + i];
            arrs[n + i] = arrs[n + n3];
            arrs[n + n3] = s;
            int n4 = arrn[i];
            arrn[i] = arrn[n3];
            arrn[n3] = n4;
        }
        return new Ak315(arrs.length, n, arrn);
    }

    public static Ak315 j(Random random, Object[] arrobject, int n, int n2) {
        int[] arrn = Bo314.e(n2);
        for (int i = 0; i < n2; ++i) {
            int n3 = i + Jz233.r(random, n2 - i);
            Object object = arrobject[n + i];
            arrobject[n + i] = arrobject[n + n3];
            arrobject[n + n3] = object;
            int n4 = arrn[i];
            arrn[i] = arrn[n3];
            arrn[n3] = n4;
        }
        return new Ak315(arrobject.length, n, arrn);
    }

    private static void u(boolean[] arrbl, int n, int[] arrn, int n2, int n3, Aj540 aj540, boolean bl) {
        int n4;
        int n5;
        if (n3 - n2 <= 1) {
            return;
        }
        int n6 = n2;
        int n7 = n3 - 1;
        int n8 = n6 + n7 >>> 1;
        if (n3 - n2 >= 5) {
            n5 = aj540.g(arrbl[n + n6], arrbl[n + n7]);
            if (n5 > 0 || n5 == 0 && arrn[n6] > arrn[n7]) {
                n4 = n6;
                n6 = n7;
                n7 = n4;
            }
            if ((n5 = aj540.g(arrbl[n + n8], arrbl[n + n6])) < 0 || n5 == 0 && arrn[n8] < arrn[n6]) {
                n8 = n6;
            } else {
                n5 = aj540.g(arrbl[n + n8], arrbl[n + n7]);
                if (n5 > 0 || n5 == 0 && arrn[n8] > arrn[n7]) {
                    n8 = n7;
                }
            }
        }
        n5 = arrbl[n + n8];
        n4 = arrn[n8];
        int n9 = n3 - 1;
        arrbl[n + n8] = arrbl[n + n9];
        arrn[n8] = arrn[n9];
        n8 = n9;
        n9 = n2;
        while (n9 < n8) {
            int n10 = aj540.g(arrbl[n + n9], n5 != 0);
            if ((n10 > 0 || n10 == 0 && arrn[n9] > n4) != bl) {
                arrbl[n + n8] = arrbl[n + n9];
                arrn[n8] = arrn[n9];
                arrbl[n + n9] = arrbl[n + --n8];
                arrn[n9] = arrn[n8];
                continue;
            }
            ++n9;
        }
        arrbl[n + n8] = n5;
        arrn[n8] = n4;
        Bo314.u(arrbl, n, arrn, n2, n8, aj540, bl);
        Bo314.u(arrbl, n, arrn, n8 + 1, n3, aj540, bl);
    }

    private static void b(byte[] arrby, int n, int[] arrn, int n2, int n3, Bq656 bq656, boolean bl) {
        int n4;
        int n5;
        if (n3 - n2 <= 1) {
            return;
        }
        int n6 = n2;
        int n7 = n3 - 1;
        int n8 = n6 + n7 >>> 1;
        if (n3 - n2 >= 5) {
            n5 = bq656.g(arrby[n + n6] & 0xFF, arrby[n + n7] & 0xFF);
            if (n5 > 0 || n5 == 0 && arrn[n6] > arrn[n7]) {
                n4 = n6;
                n6 = n7;
                n7 = n4;
            }
            if ((n5 = bq656.g(arrby[n + n8] & 0xFF, arrby[n + n6] & 0xFF)) < 0 || n5 == 0 && arrn[n8] < arrn[n6]) {
                n8 = n6;
            } else {
                n5 = bq656.g(arrby[n + n8] & 0xFF, arrby[n + n7] & 0xFF);
                if (n5 > 0 || n5 == 0 && arrn[n8] > arrn[n7]) {
                    n8 = n7;
                }
            }
        }
        n5 = arrby[n + n8] & 0xFF;
        n4 = arrn[n8];
        int n9 = n3 - 1;
        arrby[n + n8] = arrby[n + n9];
        arrn[n8] = arrn[n9];
        n8 = n9;
        n9 = n2;
        while (n9 < n8) {
            int n10 = bq656.g(arrby[n + n9] & 0xFF, n5);
            if ((n10 > 0 || n10 == 0 && arrn[n9] > n4) != bl) {
                arrby[n + n8] = arrby[n + n9];
                arrn[n8] = arrn[n9];
                arrby[n + n9] = arrby[n + --n8];
                arrn[n9] = arrn[n8];
                continue;
            }
            ++n9;
        }
        arrby[n + n8] = (byte)n5;
        arrn[n8] = n4;
        Bo314.b(arrby, n, arrn, n2, n8, bq656, bl);
        Bo314.b(arrby, n, arrn, n8 + 1, n3, bq656, bl);
    }

    private static void l(short[] arrs, int n, int[] arrn, int n2, int n3, Bq656 bq656, boolean bl) {
        int n4;
        int n5;
        if (n3 - n2 <= 1) {
            return;
        }
        int n6 = n2;
        int n7 = n3 - 1;
        int n8 = n6 + n7 >>> 1;
        if (n3 - n2 >= 5) {
            n5 = bq656.g(arrs[n + n6], arrs[n + n7]);
            if (n5 > 0 || n5 == 0 && arrn[n6] > arrn[n7]) {
                n4 = n6;
                n6 = n7;
                n7 = n4;
            }
            if ((n5 = bq656.g(arrs[n + n8], arrs[n + n6])) < 0 || n5 == 0 && arrn[n8] < arrn[n6]) {
                n8 = n6;
            } else {
                n5 = bq656.g(arrs[n + n8], arrs[n + n7]);
                if (n5 > 0 || n5 == 0 && arrn[n8] > arrn[n7]) {
                    n8 = n7;
                }
            }
        }
        n5 = arrs[n + n8];
        n4 = arrn[n8];
        int n9 = n3 - 1;
        arrs[n + n8] = arrs[n + n9];
        arrn[n8] = arrn[n9];
        n8 = n9;
        n9 = n2;
        while (n9 < n8) {
            int n10 = bq656.g(arrs[n + n9], n5);
            if ((n10 > 0 || n10 == 0 && arrn[n9] > n4) != bl) {
                arrs[n + n8] = arrs[n + n9];
                arrn[n8] = arrn[n9];
                arrs[n + n9] = arrs[n + --n8];
                arrn[n9] = arrn[n8];
                continue;
            }
            ++n9;
        }
        arrs[n + n8] = n5;
        arrn[n8] = n4;
        Bo314.l(arrs, n, arrn, n2, n8, bq656, bl);
        Bo314.l(arrs, n, arrn, n8 + 1, n3, bq656, bl);
    }

    private static void w(short[] arrs, int n, int[] arrn, int n2, int n3, Bq656 bq656, boolean bl) {
        int n4;
        int n5;
        if (n3 - n2 <= 1) {
            return;
        }
        int n6 = n2;
        int n7 = n3 - 1;
        int n8 = n6 + n7 >>> 1;
        if (n3 - n2 >= 5) {
            n5 = bq656.g(arrs[n + n6] & 0xFFFF, arrs[n + n7] & 0xFFFF);
            if (n5 > 0 || n5 == 0 && arrn[n6] > arrn[n7]) {
                n4 = n6;
                n6 = n7;
                n7 = n4;
            }
            if ((n5 = bq656.g(arrs[n + n8] & 0xFFFF, arrs[n + n6] & 0xFFFF)) < 0 || n5 == 0 && arrn[n8] < arrn[n6]) {
                n8 = n6;
            } else {
                n5 = bq656.g(arrs[n + n8] & 0xFFFF, arrs[n + n7] & 0xFFFF);
                if (n5 > 0 || n5 == 0 && arrn[n8] > arrn[n7]) {
                    n8 = n7;
                }
            }
        }
        n5 = arrs[n + n8] & 0xFFFF;
        n4 = arrn[n8];
        int n9 = n3 - 1;
        arrs[n + n8] = arrs[n + n9];
        arrn[n8] = arrn[n9];
        n8 = n9;
        n9 = n2;
        while (n9 < n8) {
            int n10 = bq656.g(arrs[n + n9] & 0xFFFF, n5);
            if ((n10 > 0 || n10 == 0 && arrn[n9] > n4) != bl) {
                arrs[n + n8] = arrs[n + n9];
                arrn[n8] = arrn[n9];
                arrs[n + n9] = arrs[n + --n8];
                arrn[n9] = arrn[n8];
                continue;
            }
            ++n9;
        }
        arrs[n + n8] = (short)n5;
        arrn[n8] = n4;
        Bo314.w(arrs, n, arrn, n2, n8, bq656, bl);
        Bo314.w(arrs, n, arrn, n8 + 1, n3, bq656, bl);
    }

    private static void r(char[] arrc, int n, int[] arrn, int n2, int n3, Ad562 ad562, boolean bl) {
        int n4;
        int n5;
        if (n3 - n2 <= 1) {
            return;
        }
        int n6 = n2;
        int n7 = n3 - 1;
        int n8 = n6 + n7 >>> 1;
        if (n3 - n2 >= 5) {
            n5 = ad562.g(arrc[n + n6], arrc[n + n7]);
            if (n5 > 0 || n5 == 0 && arrn[n6] > arrn[n7]) {
                n4 = n6;
                n6 = n7;
                n7 = n4;
            }
            if ((n5 = ad562.g(arrc[n + n8], arrc[n + n6])) < 0 || n5 == 0 && arrn[n8] < arrn[n6]) {
                n8 = n6;
            } else {
                n5 = ad562.g(arrc[n + n8], arrc[n + n7]);
                if (n5 > 0 || n5 == 0 && arrn[n8] > arrn[n7]) {
                    n8 = n7;
                }
            }
        }
        n5 = arrc[n + n8];
        n4 = arrn[n8];
        int n9 = n3 - 1;
        arrc[n + n8] = arrc[n + n9];
        arrn[n8] = arrn[n9];
        n8 = n9;
        n9 = n2;
        while (n9 < n8) {
            int n10 = ad562.g(arrc[n + n9], (char)n5);
            if ((n10 > 0 || n10 == 0 && arrn[n9] > n4) != bl) {
                arrc[n + n8] = arrc[n + n9];
                arrn[n8] = arrn[n9];
                arrc[n + n9] = arrc[n + --n8];
                arrn[n9] = arrn[n8];
                continue;
            }
            ++n9;
        }
        arrc[n + n8] = n5;
        arrn[n8] = n4;
        Bo314.r(arrc, n, arrn, n2, n8, ad562, bl);
        Bo314.r(arrc, n, arrn, n8 + 1, n3, ad562, bl);
    }

    private static void v(int[] arrn, int n, int[] arrn2, int n2, int n3, Bq656 bq656, boolean bl) {
        int n4;
        int n5;
        if (n3 - n2 <= 1) {
            return;
        }
        int n6 = n2;
        int n7 = n3 - 1;
        int n8 = n6 + n7 >>> 1;
        if (n3 - n2 >= 5) {
            n5 = bq656.g(arrn[n + n6], arrn[n + n7]);
            if (n5 > 0 || n5 == 0 && arrn2[n6] > arrn2[n7]) {
                n4 = n6;
                n6 = n7;
                n7 = n4;
            }
            if ((n5 = bq656.g(arrn[n + n8], arrn[n + n6])) < 0 || n5 == 0 && arrn2[n8] < arrn2[n6]) {
                n8 = n6;
            } else {
                n5 = bq656.g(arrn[n + n8], arrn[n + n7]);
                if (n5 > 0 || n5 == 0 && arrn2[n8] > arrn2[n7]) {
                    n8 = n7;
                }
            }
        }
        n5 = arrn[n + n8];
        n4 = arrn2[n8];
        int n9 = n3 - 1;
        arrn[n + n8] = arrn[n + n9];
        arrn2[n8] = arrn2[n9];
        n8 = n9;
        n9 = n2;
        while (n9 < n8) {
            int n10 = bq656.g(arrn[n + n9], n5);
            if ((n10 > 0 || n10 == 0 && arrn2[n9] > n4) != bl) {
                arrn[n + n8] = arrn[n + n9];
                arrn2[n8] = arrn2[n9];
                arrn[n + n9] = arrn[n + --n8];
                arrn2[n9] = arrn2[n8];
                continue;
            }
            ++n9;
        }
        arrn[n + n8] = n5;
        arrn2[n8] = n4;
        Bo314.v(arrn, n, arrn2, n2, n8, bq656, bl);
        Bo314.v(arrn, n, arrn2, n8 + 1, n3, bq656, bl);
    }

    private static void p(float[] arrf, int n, int[] arrn, int n2, int n3, Au658 au658, boolean bl) {
        int n4;
        if (n3 - n2 <= 1) {
            return;
        }
        int n5 = n2;
        int n6 = n3 - 1;
        int n7 = n5 + n6 >>> 1;
        if (n3 - n2 >= 5) {
            int n8 = au658.g(arrf[n + n5], arrf[n + n6]);
            if (n8 > 0 || n8 == 0 && arrn[n5] > arrn[n6]) {
                n4 = n5;
                n5 = n6;
                n6 = n4;
            }
            if ((n8 = au658.g(arrf[n + n7], arrf[n + n5])) < 0 || n8 == 0 && arrn[n7] < arrn[n5]) {
                n7 = n5;
            } else {
                n8 = au658.g(arrf[n + n7], arrf[n + n6]);
                if (n8 > 0 || n8 == 0 && arrn[n7] > arrn[n6]) {
                    n7 = n6;
                }
            }
        }
        float f = arrf[n + n7];
        n4 = arrn[n7];
        int n9 = n3 - 1;
        arrf[n + n7] = arrf[n + n9];
        arrn[n7] = arrn[n9];
        n7 = n9;
        n9 = n2;
        while (n9 < n7) {
            int n10 = au658.g(arrf[n + n9], f);
            if ((n10 > 0 || n10 == 0 && arrn[n9] > n4) != bl) {
                arrf[n + n7] = arrf[n + n9];
                arrn[n7] = arrn[n9];
                arrf[n + n9] = arrf[n + --n7];
                arrn[n9] = arrn[n7];
                continue;
            }
            ++n9;
        }
        arrf[n + n7] = f;
        arrn[n7] = n4;
        Bo314.p(arrf, n, arrn, n2, n7, au658, bl);
        Bo314.p(arrf, n, arrn, n7 + 1, n3, au658, bl);
    }

    private static void x(double[] arrd, int n, int[] arrn, int n2, int n3, Ar552 ar552, boolean bl) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            int n7 = ar552.g(arrd[n + n4], arrd[n + n5]);
            if (n7 > 0 || n7 == 0 && arrn[n4] > arrn[n5]) {
                int n8 = n4;
                n4 = n5;
                n5 = n8;
            }
            if ((n7 = ar552.g(arrd[n + n6], arrd[n + n4])) < 0 || n7 == 0 && arrn[n6] < arrn[n4]) {
                n6 = n4;
            } else {
                n7 = ar552.g(arrd[n + n6], arrd[n + n5]);
                if (n7 > 0 || n7 == 0 && arrn[n6] > arrn[n5]) {
                    n6 = n5;
                }
            }
        }
        double d = arrd[n + n6];
        int n9 = arrn[n6];
        int n10 = n3 - 1;
        arrd[n + n6] = arrd[n + n10];
        arrn[n6] = arrn[n10];
        n6 = n10;
        n10 = n2;
        while (n10 < n6) {
            int n11 = ar552.g(arrd[n + n10], d);
            if ((n11 > 0 || n11 == 0 && arrn[n10] > n9) != bl) {
                arrd[n + n6] = arrd[n + n10];
                arrn[n6] = arrn[n10];
                arrd[n + n10] = arrd[n + --n6];
                arrn[n10] = arrn[n6];
                continue;
            }
            ++n10;
        }
        arrd[n + n6] = d;
        arrn[n6] = n9;
        Bo314.x(arrd, n, arrn, n2, n6, ar552, bl);
        Bo314.x(arrd, n, arrn, n6 + 1, n3, ar552, bl);
    }

    private static void y(long[] arrl, int n, int[] arrn, int n2, int n3, Ax659 ax659, boolean bl) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            int n7 = ax659.g(arrl[n + n4], arrl[n + n5]);
            if (n7 > 0 || n7 == 0 && arrn[n4] > arrn[n5]) {
                int n8 = n4;
                n4 = n5;
                n5 = n8;
            }
            if ((n7 = ax659.g(arrl[n + n6], arrl[n + n4])) < 0 || n7 == 0 && arrn[n6] < arrn[n4]) {
                n6 = n4;
            } else {
                n7 = ax659.g(arrl[n + n6], arrl[n + n5]);
                if (n7 > 0 || n7 == 0 && arrn[n6] > arrn[n5]) {
                    n6 = n5;
                }
            }
        }
        long l = arrl[n + n6];
        int n9 = arrn[n6];
        int n10 = n3 - 1;
        arrl[n + n6] = arrl[n + n10];
        arrn[n6] = arrn[n10];
        n6 = n10;
        n10 = n2;
        while (n10 < n6) {
            int n11 = ax659.g(arrl[n + n10], l);
            if ((n11 > 0 || n11 == 0 && arrn[n10] > n9) != bl) {
                arrl[n + n6] = arrl[n + n10];
                arrn[n6] = arrn[n10];
                arrl[n + n10] = arrl[n + --n6];
                arrn[n10] = arrn[n6];
                continue;
            }
            ++n10;
        }
        arrl[n + n6] = l;
        arrn[n6] = n9;
        Bo314.y(arrl, n, arrn, n2, n6, ax659, bl);
        Bo314.y(arrl, n, arrn, n6 + 1, n3, ax659, bl);
    }

    private static void h(Object[] arrobject, int n, int[] arrn, int n2, int n3, Comparator comparator, boolean bl) {
        int n4;
        if (n3 - n2 <= 1) {
            return;
        }
        int n5 = n2;
        int n6 = n3 - 1;
        int n7 = n5 + n6 >>> 1;
        if (n3 - n2 >= 5) {
            int n8 = comparator.compare(arrobject[n + n5], arrobject[n + n6]);
            if (n8 > 0 || n8 == 0 && arrn[n5] > arrn[n6]) {
                n4 = n5;
                n5 = n6;
                n6 = n4;
            }
            if ((n8 = comparator.compare(arrobject[n + n7], arrobject[n + n5])) < 0 || n8 == 0 && arrn[n7] < arrn[n5]) {
                n7 = n5;
            } else {
                n8 = comparator.compare(arrobject[n + n7], arrobject[n + n6]);
                if (n8 > 0 || n8 == 0 && arrn[n7] > arrn[n6]) {
                    n7 = n6;
                }
            }
        }
        Object object = arrobject[n + n7];
        n4 = arrn[n7];
        int n9 = n3 - 1;
        arrobject[n + n7] = arrobject[n + n9];
        arrn[n7] = arrn[n9];
        n7 = n9;
        n9 = n2;
        while (n9 < n7) {
            int n10 = comparator.compare(arrobject[n + n9], object);
            if ((n10 > 0 || n10 == 0 && arrn[n9] > n4) != bl) {
                arrobject[n + n7] = arrobject[n + n9];
                arrn[n7] = arrn[n9];
                arrobject[n + n9] = arrobject[n + --n7];
                arrn[n9] = arrn[n7];
                continue;
            }
            ++n9;
        }
        arrobject[n + n7] = object;
        arrn[n7] = n4;
        Bo314.h(arrobject, n, arrn, n2, n7, comparator, bl);
        Bo314.h(arrobject, n, arrn, n7 + 1, n3, comparator, bl);
    }

    private static void s(byte[] arrby, int n, int[] arrn, int n2, int n3, Bq656 bq656, boolean bl) {
        int n4;
        int n5;
        if (n3 - n2 <= 1) {
            return;
        }
        int n6 = n2;
        int n7 = n3 - 1;
        int n8 = n6 + n7 >>> 1;
        if (n3 - n2 >= 5) {
            n5 = bq656.g(arrby[n + n6], arrby[n + n7]);
            if (n5 > 0 || n5 == 0 && arrn[n6] > arrn[n7]) {
                n4 = n6;
                n6 = n7;
                n7 = n4;
            }
            if ((n5 = bq656.g(arrby[n + n8], arrby[n + n6])) < 0 || n5 == 0 && arrn[n8] < arrn[n6]) {
                n8 = n6;
            } else {
                n5 = bq656.g(arrby[n + n8], arrby[n + n7]);
                if (n5 > 0 || n5 == 0 && arrn[n8] > arrn[n7]) {
                    n8 = n7;
                }
            }
        }
        n5 = arrby[n + n8];
        n4 = arrn[n8];
        int n9 = n3 - 1;
        arrby[n + n8] = arrby[n + n9];
        arrn[n8] = arrn[n9];
        n8 = n9;
        n9 = n2;
        while (n9 < n8) {
            int n10 = bq656.g(arrby[n + n9], n5);
            if ((n10 > 0 || n10 == 0 && arrn[n9] > n4) != bl) {
                arrby[n + n8] = arrby[n + n9];
                arrn[n8] = arrn[n9];
                arrby[n + n9] = arrby[n + --n8];
                arrn[n9] = arrn[n8];
                continue;
            }
            ++n9;
        }
        arrby[n + n8] = n5;
        arrn[n8] = n4;
        Bo314.s(arrby, n, arrn, n2, n8, bq656, bl);
        Bo314.s(arrby, n, arrn, n8 + 1, n3, bq656, bl);
    }

    public static Ak315 d(Random random, short[] arrs) {
        return Bo314.q(random, arrs, 0, arrs.length);
    }
}

