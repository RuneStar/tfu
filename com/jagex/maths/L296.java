// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Ln265;
import tfu.Gx298;
import java.util.Iterator;
import java.util.List;
import tfu.Jz233;

public final class L296
{
    public J297[] g;
    
    private static J297[] h(final J297[] array, final int n) {
        final J297[] array2 = new J297[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = new J297(array[i]);
        }
        int j = array.length;
    Label_0036:
        while (true) {
            while (j > 3) {
                for (int k = 0; k < j; ++k) {
                    if (s(array2, k, (k + 2) % j, j, (float)n) != -1) {
                        int n2 = (k + 2) % j;
                        while (k != n2) {
                            k = Jz233.w(k - 1, j);
                            if (s(array2, k, n2, j, (float)n) == -1) {
                                final int l = (k + 1) % j;
                                while (l != n2) {
                                    n2 = (n2 + 1) % j;
                                    if (s(array2, l, n2, j, (float)n) == -1) {
                                        final int w = Jz233.w(n2 - 1, j);
                                        if (w > l) {
                                            System.arraycopy(array2, w, array2, l + 1, j - w);
                                            j -= w - l - 1;
                                        }
                                        else {
                                            final int n3 = l + 1;
                                            System.arraycopy(array2, w, array2, 0, n3 - w);
                                            j = n3 - w;
                                        }
                                        continue Label_0036;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                final J297[] array3 = new J297[j];
                System.arraycopy(array2, 0, array3, 0, j);
                return array3;
            }
            continue;
        }
    }
    
    public L296(final List list, final int n) {
        if (list.size() < 3) {
            throw new IllegalArgumentException("Must supply at least 3 points to generate a convex hull");
        }
        final J297[] array = new J297[list.size()];
        int n2 = 0;
        for (final Vector3 vector3 : list) {
            array[n2++] = new J297(vector3.x, vector3.z);
        }
        this.g = g(array);
        if (n != 0) {
            this.g = h(this.g, n);
        }
    }
    
    public L296(final float[] array, final float[] array2, final int n, final int n2) {
        final J297[] array3 = new J297[n];
        for (int i = 0; i < array3.length; ++i) {
            array3[i] = new J297(array[i], array2[i]);
        }
        if (array3.length < 3) {
            throw new IllegalArgumentException();
        }
        this.g = g(array3);
        if (n2 == 0) {
            return;
        }
        this.g = h(this.g, n2);
    }
    
    private static J297[] g(final J297[] array) {
        float n = Float.MAX_VALUE;
        float n2 = 0.0f;
        for (int i = 0; i < array.length; ++i) {
            final J297 j297 = array[i];
            if (j297.d < n) {
                n2 = j297.g;
                n = j297.d;
            }
            else if (j297.d == n && n2 < j297.g) {
                n2 = j297.g;
                n = j297.d;
            }
        }
        for (final J297 j298 : array) {
            final float n3 = j298.g - n2;
            final float n4 = j298.d - n;
            final double sqrt = Math.sqrt(n3 * n3 + n4 * n4);
            if (Math.abs(sqrt) < 0.01) {
                j298.q = 1.0;
            }
            else {
                j298.q = n3 / sqrt;
            }
        }
        q(array);
        for (int length2 = array.length, l = 0; l < length2 - 1; ++l) {
            final J297 j299 = array[l];
            final J297 j300 = array[l + 1];
            if (j299.q == j300.q) {
                if (Math.sqrt((j299.g - n2) * (j299.g - n2) + (j299.d - n) * (j299.d - n)) < Math.sqrt((j300.g - n2) * (j300.g - n2) + (j300.d - n) * (j300.d - n))) {
                    System.arraycopy(array, l + 1, array, l, length2 - l - 1);
                }
                else if (l + 2 < length2) {
                    System.arraycopy(array, l + 2, array, l + 1, length2 - l - 2);
                }
                --length2;
                --l;
            }
        }
        final Gx298 gx298 = new Gx298();
        Gx298.t(gx298, array[0]);
        Gx298.t(gx298, array[1]);
        for (int n5 = 2; n5 < array.length; ++n5) {
            for (J297 j301 = (J297)Gx298.a(gx298), j302 = (J297)Gx298.ag(gx298); Gx298.aq(gx298) >= 2 && !d(j302, j301, array[n5]); j301 = j302, j302 = (J297)Gx298.ag(gx298)) {
                Gx298.k(gx298);
            }
            Gx298.t(gx298, array[n5]);
        }
        final J297[] array2 = new J297[Gx298.aq(gx298)];
        Gx298.al(gx298, array2);
        return array2;
    }
    
    private static boolean d(final J297 j297, final J297 j298, final J297 j299) {
        return (j298.g - j297.g) * (j299.d - j298.d) + (j298.d - j297.d) * (j298.g - j299.g) >= 0.0f;
    }
    
    private static void q(final J297[] array) {
        j(array, array.length);
        for (int i = array.length - 1; i > 0; --i) {
            final J297 j297 = array[i];
            array[i] = array[0];
            array[0] = j297;
            e(array, 0, i - 1);
        }
    }
    
    private static void e(final J297[] array, final int n, final int n2) {
        int n5;
        for (int n3 = n; n3 * 2 + 1 <= n2; n3 = n5) {
            final int n4 = n3 * 2 + 1;
            n5 = n3;
            if (array[n5].q > array[n4].q) {
                n5 = n4;
            }
            if (n4 < n2 && array[n5].q > array[n4 + 1].q) {
                n5 = n4 + 1;
            }
            if (n5 == n3) {
                return;
            }
            final J297 j297 = array[n3];
            array[n3] = array[n5];
            array[n5] = j297;
        }
    }
    
    public L296(final int[] array, final int[] array2, final int n, final int n2) {
        final J297[] array3 = new J297[n];
        for (int i = 0; i < array3.length; ++i) {
            array3[i] = new J297((float)array[i], (float)array2[i]);
        }
        if (array3.length < 3) {
            throw new IllegalArgumentException();
        }
        this.g = g(array3);
        if (n2 == 0) {
            return;
        }
        this.g = h(this.g, n2);
    }
    
    private static int s(final J297[] array, final int n, final int n2, final int n3, final float n4) {
        final float n5 = array[n2].g - array[n].g;
        final float n6 = array[n2].d - array[n].d;
        float n7 = 0.0f;
        int n8 = -2;
        for (int i = (n + 1) % n3; i != n2; i = (i + 1) % n3) {
            final float n9 = (float)Math.abs(((array[i].d - array[n].d) * n5 - (array[i].g - array[n].g) * n6) / Math.sqrt(n5 * n5 + n6 * n6));
            if (n9 > n4) {
                return -1;
            }
            if (n9 > n7) {
                n7 = n9;
                n8 = i;
            }
        }
        return n8;
    }
    
    private static void j(final J297[] array, final int n) {
        for (int i = n / 2; i >= 0; --i) {
            e(array, i, n - 1);
        }
    }
}
