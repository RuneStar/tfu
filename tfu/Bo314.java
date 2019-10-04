// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Comparator;
import java.util.Random;

public class Bo314
{
    public static Ak315 g(final Object[] array) {
        return j(null, array, 0, array.length);
    }
    
    private static int[] e(final int n) {
        final int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = i;
        }
        return array;
    }
    
    public static Ak315 q(final Random random, final short[] array, final int n, final int n2) {
        final int[] e = e(n2);
        for (int i = 0; i < n2; ++i) {
            final int n3 = i + Jz233.r(random, n2 - i);
            final short n4 = array[n + i];
            array[n + i] = array[n + n3];
            array[n + n3] = n4;
            final int n5 = e[i];
            e[i] = e[n3];
            e[n3] = n5;
        }
        return new Ak315(array.length, n, e);
    }
    
    public static Ak315 j(final Random random, final Object[] array, final int n, final int n2) {
        final int[] e = e(n2);
        for (int i = 0; i < n2; ++i) {
            final int n3 = i + Jz233.r(random, n2 - i);
            final Object o = array[n + i];
            array[n + i] = array[n + n3];
            array[n + n3] = o;
            final int n4 = e[i];
            e[i] = e[n3];
            e[n3] = n4;
        }
        return new Ak315(array.length, n, e);
    }
    
    private static void u(final boolean[] array, final int n, final int[] array2, final int n2, final int n3, final Aj540 aj540, final boolean b) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            final int g = aj540.g(array[n + n4], array[n + n5]);
            if (g > 0 || (g == 0 && array2[n4] > array2[n5])) {
                final int n7 = n4;
                n4 = n5;
                n5 = n7;
            }
            final int g2 = aj540.g(array[n + n6], array[n + n4]);
            if (g2 < 0 || (g2 == 0 && array2[n6] < array2[n4])) {
                n6 = n4;
            }
            else {
                final int g3 = aj540.g(array[n + n6], array[n + n5]);
                if (g3 > 0 || (g3 == 0 && array2[n6] > array2[n5])) {
                    n6 = n5;
                }
            }
        }
        final boolean b2 = array[n + n6];
        final int n8 = array2[n6];
        final int n9 = n3 - 1;
        array[n + n6] = array[n + n9];
        array2[n6] = array2[n9];
        int n10 = n9;
        int i = n2;
        while (i < n10) {
            final int g4 = aj540.g(array[n + i], b2);
            if ((g4 > 0 || (g4 == 0 && array2[i] > n8)) != b) {
                array[n + n10] = array[n + i];
                array2[n10] = array2[i];
                --n10;
                array[n + i] = array[n + n10];
                array2[i] = array2[n10];
            }
            else {
                ++i;
            }
        }
        array[n + n10] = b2;
        array2[n10] = n8;
        u(array, n, array2, n2, n10, aj540, b);
        u(array, n, array2, n10 + 1, n3, aj540, b);
    }
    
    private static void b(final byte[] array, final int n, final int[] array2, final int n2, final int n3, final Bq656 bq656, final boolean b) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            final int g = bq656.g(array[n + n4] & 0xFF, array[n + n5] & 0xFF);
            if (g > 0 || (g == 0 && array2[n4] > array2[n5])) {
                final int n7 = n4;
                n4 = n5;
                n5 = n7;
            }
            final int g2 = bq656.g(array[n + n6] & 0xFF, array[n + n4] & 0xFF);
            if (g2 < 0 || (g2 == 0 && array2[n6] < array2[n4])) {
                n6 = n4;
            }
            else {
                final int g3 = bq656.g(array[n + n6] & 0xFF, array[n + n5] & 0xFF);
                if (g3 > 0 || (g3 == 0 && array2[n6] > array2[n5])) {
                    n6 = n5;
                }
            }
        }
        final int n8 = array[n + n6] & 0xFF;
        final int n9 = array2[n6];
        final int n10 = n3 - 1;
        array[n + n6] = array[n + n10];
        array2[n6] = array2[n10];
        int n11 = n10;
        int i = n2;
        while (i < n11) {
            final int g4 = bq656.g(array[n + i] & 0xFF, n8);
            if ((g4 > 0 || (g4 == 0 && array2[i] > n9)) != b) {
                array[n + n11] = array[n + i];
                array2[n11] = array2[i];
                --n11;
                array[n + i] = array[n + n11];
                array2[i] = array2[n11];
            }
            else {
                ++i;
            }
        }
        array[n + n11] = (byte)n8;
        array2[n11] = n9;
        b(array, n, array2, n2, n11, bq656, b);
        b(array, n, array2, n11 + 1, n3, bq656, b);
    }
    
    private static void l(final short[] array, final int n, final int[] array2, final int n2, final int n3, final Bq656 bq656, final boolean b) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            final int g = bq656.g(array[n + n4], array[n + n5]);
            if (g > 0 || (g == 0 && array2[n4] > array2[n5])) {
                final int n7 = n4;
                n4 = n5;
                n5 = n7;
            }
            final int g2 = bq656.g(array[n + n6], array[n + n4]);
            if (g2 < 0 || (g2 == 0 && array2[n6] < array2[n4])) {
                n6 = n4;
            }
            else {
                final int g3 = bq656.g(array[n + n6], array[n + n5]);
                if (g3 > 0 || (g3 == 0 && array2[n6] > array2[n5])) {
                    n6 = n5;
                }
            }
        }
        final short n8 = array[n + n6];
        final int n9 = array2[n6];
        final int n10 = n3 - 1;
        array[n + n6] = array[n + n10];
        array2[n6] = array2[n10];
        int n11 = n10;
        int i = n2;
        while (i < n11) {
            final int g4 = bq656.g(array[n + i], n8);
            if ((g4 > 0 || (g4 == 0 && array2[i] > n9)) != b) {
                array[n + n11] = array[n + i];
                array2[n11] = array2[i];
                --n11;
                array[n + i] = array[n + n11];
                array2[i] = array2[n11];
            }
            else {
                ++i;
            }
        }
        array[n + n11] = n8;
        array2[n11] = n9;
        l(array, n, array2, n2, n11, bq656, b);
        l(array, n, array2, n11 + 1, n3, bq656, b);
    }
    
    private static void w(final short[] array, final int n, final int[] array2, final int n2, final int n3, final Bq656 bq656, final boolean b) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            final int g = bq656.g(array[n + n4] & 0xFFFF, array[n + n5] & 0xFFFF);
            if (g > 0 || (g == 0 && array2[n4] > array2[n5])) {
                final int n7 = n4;
                n4 = n5;
                n5 = n7;
            }
            final int g2 = bq656.g(array[n + n6] & 0xFFFF, array[n + n4] & 0xFFFF);
            if (g2 < 0 || (g2 == 0 && array2[n6] < array2[n4])) {
                n6 = n4;
            }
            else {
                final int g3 = bq656.g(array[n + n6] & 0xFFFF, array[n + n5] & 0xFFFF);
                if (g3 > 0 || (g3 == 0 && array2[n6] > array2[n5])) {
                    n6 = n5;
                }
            }
        }
        final int n8 = array[n + n6] & 0xFFFF;
        final int n9 = array2[n6];
        final int n10 = n3 - 1;
        array[n + n6] = array[n + n10];
        array2[n6] = array2[n10];
        int n11 = n10;
        int i = n2;
        while (i < n11) {
            final int g4 = bq656.g(array[n + i] & 0xFFFF, n8);
            if ((g4 > 0 || (g4 == 0 && array2[i] > n9)) != b) {
                array[n + n11] = array[n + i];
                array2[n11] = array2[i];
                --n11;
                array[n + i] = array[n + n11];
                array2[i] = array2[n11];
            }
            else {
                ++i;
            }
        }
        array[n + n11] = (short)n8;
        array2[n11] = n9;
        w(array, n, array2, n2, n11, bq656, b);
        w(array, n, array2, n11 + 1, n3, bq656, b);
    }
    
    private static void r(final char[] array, final int n, final int[] array2, final int n2, final int n3, final Ad562 ad562, final boolean b) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            final int g = ad562.g(array[n + n4], array[n + n5]);
            if (g > 0 || (g == 0 && array2[n4] > array2[n5])) {
                final int n7 = n4;
                n4 = n5;
                n5 = n7;
            }
            final int g2 = ad562.g(array[n + n6], array[n + n4]);
            if (g2 < 0 || (g2 == 0 && array2[n6] < array2[n4])) {
                n6 = n4;
            }
            else {
                final int g3 = ad562.g(array[n + n6], array[n + n5]);
                if (g3 > 0 || (g3 == 0 && array2[n6] > array2[n5])) {
                    n6 = n5;
                }
            }
        }
        final char c = array[n + n6];
        final int n8 = array2[n6];
        final int n9 = n3 - 1;
        array[n + n6] = array[n + n9];
        array2[n6] = array2[n9];
        int n10 = n9;
        int i = n2;
        while (i < n10) {
            final int g4 = ad562.g(array[n + i], c);
            if ((g4 > 0 || (g4 == 0 && array2[i] > n8)) != b) {
                array[n + n10] = array[n + i];
                array2[n10] = array2[i];
                --n10;
                array[n + i] = array[n + n10];
                array2[i] = array2[n10];
            }
            else {
                ++i;
            }
        }
        array[n + n10] = c;
        array2[n10] = n8;
        r(array, n, array2, n2, n10, ad562, b);
        r(array, n, array2, n10 + 1, n3, ad562, b);
    }
    
    private static void v(final int[] array, final int n, final int[] array2, final int n2, final int n3, final Bq656 bq656, final boolean b) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            final int g = bq656.g(array[n + n4], array[n + n5]);
            if (g > 0 || (g == 0 && array2[n4] > array2[n5])) {
                final int n7 = n4;
                n4 = n5;
                n5 = n7;
            }
            final int g2 = bq656.g(array[n + n6], array[n + n4]);
            if (g2 < 0 || (g2 == 0 && array2[n6] < array2[n4])) {
                n6 = n4;
            }
            else {
                final int g3 = bq656.g(array[n + n6], array[n + n5]);
                if (g3 > 0 || (g3 == 0 && array2[n6] > array2[n5])) {
                    n6 = n5;
                }
            }
        }
        final int n8 = array[n + n6];
        final int n9 = array2[n6];
        final int n10 = n3 - 1;
        array[n + n6] = array[n + n10];
        array2[n6] = array2[n10];
        int n11 = n10;
        int i = n2;
        while (i < n11) {
            final int g4 = bq656.g(array[n + i], n8);
            if ((g4 > 0 || (g4 == 0 && array2[i] > n9)) != b) {
                array[n + n11] = array[n + i];
                array2[n11] = array2[i];
                --n11;
                array[n + i] = array[n + n11];
                array2[i] = array2[n11];
            }
            else {
                ++i;
            }
        }
        array[n + n11] = n8;
        array2[n11] = n9;
        v(array, n, array2, n2, n11, bq656, b);
        v(array, n, array2, n11 + 1, n3, bq656, b);
    }
    
    private static void p(final float[] array, final int n, final int[] array2, final int n2, final int n3, final Au658 au658, final boolean b) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            final int g = au658.g(array[n + n4], array[n + n5]);
            if (g > 0 || (g == 0 && array2[n4] > array2[n5])) {
                final int n7 = n4;
                n4 = n5;
                n5 = n7;
            }
            final int g2 = au658.g(array[n + n6], array[n + n4]);
            if (g2 < 0 || (g2 == 0 && array2[n6] < array2[n4])) {
                n6 = n4;
            }
            else {
                final int g3 = au658.g(array[n + n6], array[n + n5]);
                if (g3 > 0 || (g3 == 0 && array2[n6] > array2[n5])) {
                    n6 = n5;
                }
            }
        }
        final float n8 = array[n + n6];
        final int n9 = array2[n6];
        final int n10 = n3 - 1;
        array[n + n6] = array[n + n10];
        array2[n6] = array2[n10];
        int n11 = n10;
        int i = n2;
        while (i < n11) {
            final int g4 = au658.g(array[n + i], n8);
            if ((g4 > 0 || (g4 == 0 && array2[i] > n9)) != b) {
                array[n + n11] = array[n + i];
                array2[n11] = array2[i];
                --n11;
                array[n + i] = array[n + n11];
                array2[i] = array2[n11];
            }
            else {
                ++i;
            }
        }
        array[n + n11] = n8;
        array2[n11] = n9;
        p(array, n, array2, n2, n11, au658, b);
        p(array, n, array2, n11 + 1, n3, au658, b);
    }
    
    private static void x(final double[] array, final int n, final int[] array2, final int n2, final int n3, final Ar552 ar552, final boolean b) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            final int g = ar552.g(array[n + n4], array[n + n5]);
            if (g > 0 || (g == 0 && array2[n4] > array2[n5])) {
                final int n7 = n4;
                n4 = n5;
                n5 = n7;
            }
            final int g2 = ar552.g(array[n + n6], array[n + n4]);
            if (g2 < 0 || (g2 == 0 && array2[n6] < array2[n4])) {
                n6 = n4;
            }
            else {
                final int g3 = ar552.g(array[n + n6], array[n + n5]);
                if (g3 > 0 || (g3 == 0 && array2[n6] > array2[n5])) {
                    n6 = n5;
                }
            }
        }
        final double n8 = array[n + n6];
        final int n9 = array2[n6];
        final int n10 = n3 - 1;
        array[n + n6] = array[n + n10];
        array2[n6] = array2[n10];
        int n11 = n10;
        int i = n2;
        while (i < n11) {
            final int g4 = ar552.g(array[n + i], n8);
            if ((g4 > 0 || (g4 == 0 && array2[i] > n9)) != b) {
                array[n + n11] = array[n + i];
                array2[n11] = array2[i];
                --n11;
                array[n + i] = array[n + n11];
                array2[i] = array2[n11];
            }
            else {
                ++i;
            }
        }
        array[n + n11] = n8;
        array2[n11] = n9;
        x(array, n, array2, n2, n11, ar552, b);
        x(array, n, array2, n11 + 1, n3, ar552, b);
    }
    
    private static void y(final long[] array, final int n, final int[] array2, final int n2, final int n3, final Ax659 ax659, final boolean b) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            final int g = ax659.g(array[n + n4], array[n + n5]);
            if (g > 0 || (g == 0 && array2[n4] > array2[n5])) {
                final int n7 = n4;
                n4 = n5;
                n5 = n7;
            }
            final int g2 = ax659.g(array[n + n6], array[n + n4]);
            if (g2 < 0 || (g2 == 0 && array2[n6] < array2[n4])) {
                n6 = n4;
            }
            else {
                final int g3 = ax659.g(array[n + n6], array[n + n5]);
                if (g3 > 0 || (g3 == 0 && array2[n6] > array2[n5])) {
                    n6 = n5;
                }
            }
        }
        final long n8 = array[n + n6];
        final int n9 = array2[n6];
        final int n10 = n3 - 1;
        array[n + n6] = array[n + n10];
        array2[n6] = array2[n10];
        int n11 = n10;
        int i = n2;
        while (i < n11) {
            final int g4 = ax659.g(array[n + i], n8);
            if ((g4 > 0 || (g4 == 0 && array2[i] > n9)) != b) {
                array[n + n11] = array[n + i];
                array2[n11] = array2[i];
                --n11;
                array[n + i] = array[n + n11];
                array2[i] = array2[n11];
            }
            else {
                ++i;
            }
        }
        array[n + n11] = n8;
        array2[n11] = n9;
        y(array, n, array2, n2, n11, ax659, b);
        y(array, n, array2, n11 + 1, n3, ax659, b);
    }
    
    private static void h(final Object[] array, final int n, final int[] array2, final int n2, final int n3, final Comparator comparator, final boolean b) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            final int compare = comparator.compare(array[n + n4], array[n + n5]);
            if (compare > 0 || (compare == 0 && array2[n4] > array2[n5])) {
                final int n7 = n4;
                n4 = n5;
                n5 = n7;
            }
            final int compare2 = comparator.compare(array[n + n6], array[n + n4]);
            if (compare2 < 0 || (compare2 == 0 && array2[n6] < array2[n4])) {
                n6 = n4;
            }
            else {
                final int compare3 = comparator.compare(array[n + n6], array[n + n5]);
                if (compare3 > 0 || (compare3 == 0 && array2[n6] > array2[n5])) {
                    n6 = n5;
                }
            }
        }
        final Object o = array[n + n6];
        final int n8 = array2[n6];
        final int n9 = n3 - 1;
        array[n + n6] = array[n + n9];
        array2[n6] = array2[n9];
        int n10 = n9;
        int i = n2;
        while (i < n10) {
            final int compare4 = comparator.compare(array[n + i], o);
            if ((compare4 > 0 || (compare4 == 0 && array2[i] > n8)) != b) {
                array[n + n10] = array[n + i];
                array2[n10] = array2[i];
                --n10;
                array[n + i] = array[n + n10];
                array2[i] = array2[n10];
            }
            else {
                ++i;
            }
        }
        array[n + n10] = o;
        array2[n10] = n8;
        h(array, n, array2, n2, n10, comparator, b);
        h(array, n, array2, n10 + 1, n3, comparator, b);
    }
    
    private static void s(final byte[] array, final int n, final int[] array2, final int n2, final int n3, final Bq656 bq656, final boolean b) {
        if (n3 - n2 <= 1) {
            return;
        }
        int n4 = n2;
        int n5 = n3 - 1;
        int n6 = n4 + n5 >>> 1;
        if (n3 - n2 >= 5) {
            final int g = bq656.g(array[n + n4], array[n + n5]);
            if (g > 0 || (g == 0 && array2[n4] > array2[n5])) {
                final int n7 = n4;
                n4 = n5;
                n5 = n7;
            }
            final int g2 = bq656.g(array[n + n6], array[n + n4]);
            if (g2 < 0 || (g2 == 0 && array2[n6] < array2[n4])) {
                n6 = n4;
            }
            else {
                final int g3 = bq656.g(array[n + n6], array[n + n5]);
                if (g3 > 0 || (g3 == 0 && array2[n6] > array2[n5])) {
                    n6 = n5;
                }
            }
        }
        final byte b2 = array[n + n6];
        final int n8 = array2[n6];
        final int n9 = n3 - 1;
        array[n + n6] = array[n + n9];
        array2[n6] = array2[n9];
        int n10 = n9;
        int i = n2;
        while (i < n10) {
            final int g4 = bq656.g(array[n + i], b2);
            if ((g4 > 0 || (g4 == 0 && array2[i] > n8)) != b) {
                array[n + n10] = array[n + i];
                array2[n10] = array2[i];
                --n10;
                array[n + i] = array[n + n10];
                array2[i] = array2[n10];
            }
            else {
                ++i;
            }
        }
        array[n + n10] = b2;
        array2[n10] = n8;
        s(array, n, array2, n2, n10, bq656, b);
        s(array, n, array2, n10 + 1, n3, bq656, b);
    }
    
    public static Ak315 d(final Random random, final short[] array) {
        return q(random, array, 0, array.length);
    }
}
