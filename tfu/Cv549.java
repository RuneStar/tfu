// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Cv549 extends Cs635
{
    protected Cv549(final Cj551 bm, final int e, final int h, final int s) {
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
    
    private static int h(final Cv549 cv549, final int[] array, int n, final int n2, final int n3, final int n4) {
        while (cv549.m > 0) {
            int n5 = n + cv549.m;
            if (n5 > n3) {
                n5 = n3;
            }
            cv549.m += n;
            if (cv549.e == 256 && (cv549.j & 0xFF) == 0x0) {
                if (Cd585.s) {
                    n = o(0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.l, cv549.r, cv549.y, cv549.p, 0, n5, n2, cv549);
                }
                else {
                    n = i(((Cj551)cv549.bm).e, array, cv549.j, n, cv549.b, cv549.v, 0, n5, n2, cv549);
                }
            }
            else if (Cd585.s) {
                n = ag(0, 0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.l, cv549.r, cv549.y, cv549.p, 0, n5, n2, cv549, cv549.e, n4);
            }
            else {
                n = c(0, 0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.b, cv549.v, 0, n5, n2, cv549, cv549.e, n4);
            }
            cv549.m -= n;
            if (cv549.m != 0) {
                return n;
            }
            if (Cs635.bg(cv549)) {
                return n3;
            }
        }
        if (cv549.e == 256 && (cv549.j & 0xFF) == 0x0) {
            if (Cd585.s) {
                return v(0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.l, cv549.r, 0, n3, n2, cv549);
            }
            return r(((Cj551)cv549.bm).e, array, cv549.j, n, cv549.b, 0, n3, n2, cv549);
        }
        else {
            if (Cd585.s) {
                return m(0, 0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.l, cv549.r, 0, n3, n2, cv549, cv549.e, n4);
            }
            return t(0, 0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.b, 0, n3, n2, cv549, cv549.e, n4);
        }
    }
    
    private static int s(final Cv549 cv549, final int[] array, int n, final int n2, final int n3, final int n4) {
        while (cv549.m > 0) {
            int n5 = n + cv549.m;
            if (n5 > n3) {
                n5 = n3;
            }
            cv549.m += n;
            if (cv549.e == -256 && (cv549.j & 0xFF) == 0x0) {
                if (Cd585.s) {
                    n = f(0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.l, cv549.r, cv549.y, cv549.p, 0, n5, n2, cv549);
                }
                else {
                    n = a(((Cj551)cv549.bm).e, array, cv549.j, n, cv549.b, cv549.v, 0, n5, n2, cv549);
                }
            }
            else if (Cd585.s) {
                n = ai(0, 0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.l, cv549.r, cv549.y, cv549.p, 0, n5, n2, cv549, cv549.e, n4);
            }
            else {
                n = aq(0, 0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.b, cv549.v, 0, n5, n2, cv549, cv549.e, n4);
            }
            cv549.m -= n;
            if (cv549.m != 0) {
                return n;
            }
            if (Cs635.bg(cv549)) {
                return n3;
            }
        }
        if (cv549.e == -256 && (cv549.j & 0xFF) == 0x0) {
            if (Cd585.s) {
                return z(0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.l, cv549.r, 0, n3, n2, cv549);
            }
            return u(((Cj551)cv549.bm).e, array, cv549.j, n, cv549.b, 0, n3, n2, cv549);
        }
        else {
            if (Cd585.s) {
                return k(0, 0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.l, cv549.r, 0, n3, n2, cv549, cv549.e, n4);
            }
            return n(0, 0, ((Cj551)cv549.bm).e, array, cv549.j, n, cv549.b, 0, n3, n2, cv549, cv549.e, n4);
        }
    }
    
    protected Cv549(final Cj551 bm, final int e, final int h) {
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
    
    private static int k(int n, int n2, final byte[] array, final int[] array2, int j, int i, final int n3, final int n4, int n5, final int n6, final int n7, final Cv549 cv549, final int n8, final int n9) {
        if (n8 == 0 || (n5 = i + (n7 + 256 - j + n8) / n8) > n6) {
            n5 = n6;
        }
        int n10;
        int n11;
        for (i <<= 1, n5 <<= 1; i < n5; n10 = i++, array2[n10] += n * n3 >> 6, n11 = i++, array2[n11] += n * n4 >> 6, j += n8) {
            n2 = j >> 8;
            n = array[n2 - 1];
            n = (n << 8) + (array[n2] - n) * (j & 0xFF);
        }
        if (n8 == 0 || (n5 = (i >> 1) + (n7 - j + n8) / n8) > n6) {
            n5 = n6;
        }
        n5 <<= 1;
        n2 = n9;
        while (i < n5) {
            n = (n2 << 8) + (array[j >> 8] - n2) * (j & 0xFF);
            final int n12 = i++;
            array2[n12] += n * n3 >> 6;
            final int n13 = i++;
            array2[n13] += n * n4 >> 6;
            j += n8;
        }
        cv549.j = j;
        return i >> 1;
    }
    
    private static int u(final byte[] array, final int[] array2, int n, int i, int n2, int n3, final int n4, int n5, final Cv549 cv549) {
        n >>= 8;
        n5 >>= 8;
        n2 <<= 2;
        if ((n3 = i + n - (n5 - 1)) > n4) {
            n3 = n4;
        }
        int n6;
        int n7;
        int n8;
        int n9;
        for (n3 -= 3; i < n3; n6 = i++, array2[n6] += array[n--] * n2, n7 = i++, array2[n7] += array[n--] * n2, n8 = i++, array2[n8] += array[n--] * n2, n9 = i++, array2[n9] += array[n--] * n2) {}
        int n10;
        for (n3 += 3; i < n3; n10 = i++, array2[n10] += array[n--] * n2) {}
        cv549.j = n << 8;
        return i;
    }
    
    private static int z(int n, final byte[] array, final int[] array2, int n2, int i, int n3, int n4, int n5, final int n6, int n7, final Cv549 cv549) {
        n2 >>= 8;
        n7 >>= 8;
        n3 <<= 2;
        n4 <<= 2;
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
        for (i <<= 1, n5 <<= 1, n5 -= 6; i < n5; n8 = i++, array2[n8] += n * n3, n9 = i++, array2[n9] += n * n4, n = array[n2--], n10 = i++, array2[n10] += n * n3, n11 = i++, array2[n11] += n * n4, n = array[n2--], n12 = i++, array2[n12] += n * n3, n13 = i++, array2[n13] += n * n4, n = array[n2--], n14 = i++, array2[n14] += n * n3, n15 = i++, array2[n15] += n * n4) {
            n = array[n2--];
        }
        int n16;
        int n17;
        for (n5 += 6; i < n5; n16 = i++, array2[n16] += n * n3, n17 = i++, array2[n17] += n * n4) {
            n = array[n2--];
        }
        cv549.j = n2 << 8;
        return i >> 1;
    }
    
    private static int a(final byte[] array, final int[] array2, int n, int i, int n2, int n3, int n4, final int n5, int n6, final Cv549 cv549) {
        n >>= 8;
        n6 >>= 8;
        n2 <<= 2;
        n3 <<= 2;
        if ((n4 = i + n - (n6 - 1)) > n5) {
            n4 = n5;
        }
        cv549.l += cv549.y * (n4 - i);
        cv549.r += cv549.p * (n4 - i);
        int n7;
        int n8;
        int n9;
        int n10;
        for (n4 -= 3; i < n4; n7 = i++, array2[n7] += array[n--] * n2, n2 += n3, n8 = i++, array2[n8] += array[n--] * n2, n2 += n3, n9 = i++, array2[n9] += array[n--] * n2, n2 += n3, n10 = i++, array2[n10] += array[n--] * n2, n2 += n3) {}
        int n11;
        for (n4 += 3; i < n4; n11 = i++, array2[n11] += array[n--] * n2, n2 += n3) {}
        cv549.b = n2 >> 2;
        cv549.j = n << 8;
        return i;
    }
    
    private static int m(int n, int n2, final byte[] array, final int[] array2, int j, int i, final int n3, final int n4, int n5, final int n6, final int n7, final Cv549 cv549, final int n8, final int n9) {
        if (n8 == 0 || (n5 = i + (n7 - j + n8 - 257) / n8) > n6) {
            n5 = n6;
        }
        int n10;
        int n11;
        for (i <<= 1, n5 <<= 1; i < n5; n10 = i++, array2[n10] += n * n3 >> 6, n11 = i++, array2[n11] += n * n4 >> 6, j += n8) {
            n2 = j >> 8;
            n = array[n2];
            n = (n << 8) + (array[n2 + 1] - n) * (j & 0xFF);
        }
        if (n8 == 0 || (n5 = (i >> 1) + (n7 - j + n8 - 1) / n8) > n6) {
            n5 = n6;
        }
        n5 <<= 1;
        n2 = n9;
        while (i < n5) {
            n = array[j >> 8];
            n = (n << 8) + (n2 - n) * (j & 0xFF);
            final int n12 = i++;
            array2[n12] += n * n3 >> 6;
            final int n13 = i++;
            array2[n13] += n * n4 >> 6;
            j += n8;
        }
        cv549.j = j;
        return i >> 1;
    }
    
    @Override
    public synchronized void j(final int[] array, final int n, int n2) {
        if (super.h == 0 && super.m == 0) {
            this.e(n2);
            return;
        }
        final int n3 = super.u << 8;
        final int n4 = super.z << 8;
        final int j = ((Cj551)super.bm).e.length << 8;
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
            Label_0975: {
                if (super.x > 0) {
                    if (super.t) {
                        if (super.e < 0) {
                            n6 = s(this, array, n6, n3, n2, ((Cj551)super.bm).e[super.u]);
                            if (super.j >= n3) {
                                return;
                            }
                            super.j = n3 + n3 - 1 - super.j;
                            super.e = -super.e;
                            if (--super.x == 0) {
                                break Label_0975;
                            }
                        }
                        do {
                            n6 = h(this, array, n6, n4, n2, ((Cj551)super.bm).e[super.z - 1]);
                            if (super.j < n4) {
                                return;
                            }
                            super.j = n4 + n4 - 1 - super.j;
                            super.e = -super.e;
                            if (--super.x == 0) {
                                break;
                            }
                            n6 = s(this, array, n6, n3, n2, ((Cj551)super.bm).e[super.u]);
                            if (super.j >= n3) {
                                return;
                            }
                            super.j = n3 + n3 - 1 - super.j;
                            super.e = -super.e;
                        } while (--super.x != 0);
                    }
                    else if (super.e < 0) {
                        while (true) {
                            n6 = s(this, array, n6, n3, n2, ((Cj551)super.bm).e[super.z - 1]);
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
                            n6 = h(this, array, n6, n4, n2, ((Cj551)super.bm).e[super.u]);
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
                s(this, array, n6, 0, n2, 0);
                if (super.j < 0) {
                    super.j = -1;
                    Cs635.bx(this);
                    Ln265.ef(this);
                }
            }
            else {
                h(this, array, n6, j, n2, 0);
                if (super.j >= j) {
                    super.j = j;
                    Cs635.bx(this);
                    Ln265.ef(this);
                }
            }
            return;
        }
        if (super.t) {
            if (super.e < 0) {
                n6 = s(this, array, n6, n3, n2, ((Cj551)super.bm).e[super.u]);
                if (super.j >= n3) {
                    return;
                }
                super.j = n3 + n3 - 1 - super.j;
                super.e = -super.e;
            }
            while (true) {
                final int h = h(this, array, n6, n4, n2, ((Cj551)super.bm).e[super.z - 1]);
                if (super.j < n4) {
                    return;
                }
                super.j = n4 + n4 - 1 - super.j;
                super.e = -super.e;
                n6 = s(this, array, h, n3, n2, ((Cj551)super.bm).e[super.u]);
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
                    n6 = s(this, array, n6, n3, n2, ((Cj551)super.bm).e[super.z - 1]);
                    if (super.j >= n3) {
                        break;
                    }
                    super.j = n4 - 1 - (n4 - 1 - super.j) % n5;
                }
                return;
            }
            while (true) {
                n6 = h(this, array, n6, n4, n2, ((Cj551)super.bm).e[super.u]);
                if (super.j < n4) {
                    break;
                }
                super.j = n3 + (super.j - n3) % n5;
            }
        }
    }
    
    private static int v(int n, final byte[] array, final int[] array2, int n2, int i, int n3, int n4, int n5, final int n6, int n7, final Cv549 cv549) {
        n2 >>= 8;
        n7 >>= 8;
        n3 <<= 2;
        n4 <<= 2;
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
        for (i <<= 1, n5 <<= 1, n5 -= 6; i < n5; n8 = i++, array2[n8] += n * n3, n9 = i++, array2[n9] += n * n4, n = array[n2++], n10 = i++, array2[n10] += n * n3, n11 = i++, array2[n11] += n * n4, n = array[n2++], n12 = i++, array2[n12] += n * n3, n13 = i++, array2[n13] += n * n4, n = array[n2++], n14 = i++, array2[n14] += n * n3, n15 = i++, array2[n15] += n * n4) {
            n = array[n2++];
        }
        int n16;
        int n17;
        for (n5 += 6; i < n5; n16 = i++, array2[n16] += n * n3, n17 = i++, array2[n17] += n * n4) {
            n = array[n2++];
        }
        cv549.j = n2 << 8;
        return i >> 1;
    }
    
    private static int i(final byte[] array, final int[] array2, int n, int i, int n2, int n3, int n4, final int n5, int n6, final Cv549 cv549) {
        n >>= 8;
        n6 >>= 8;
        n2 <<= 2;
        n3 <<= 2;
        if ((n4 = i + n6 - n) > n5) {
            n4 = n5;
        }
        cv549.l += cv549.y * (n4 - i);
        cv549.r += cv549.p * (n4 - i);
        int n7;
        int n8;
        int n9;
        int n10;
        for (n4 -= 3; i < n4; n7 = i++, array2[n7] += array[n++] * n2, n2 += n3, n8 = i++, array2[n8] += array[n++] * n2, n2 += n3, n9 = i++, array2[n9] += array[n++] * n2, n2 += n3, n10 = i++, array2[n10] += array[n++] * n2, n2 += n3) {}
        int n11;
        for (n4 += 3; i < n4; n11 = i++, array2[n11] += array[n++] * n2, n2 += n3) {}
        cv549.b = n2 >> 2;
        cv549.j = n << 8;
        return i;
    }
    
    private static int o(int n, final byte[] array, final int[] array2, int n2, int i, int n3, int n4, int n5, int n6, int n7, final int n8, int n9, final Cv549 cv549) {
        n2 >>= 8;
        n9 >>= 8;
        n3 <<= 2;
        n4 <<= 2;
        n5 <<= 2;
        n6 <<= 2;
        if ((n7 = i + n9 - n2) > n8) {
            n7 = n8;
        }
        cv549.b += cv549.v * (n7 - i);
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        for (i <<= 1, n7 <<= 1, n7 -= 6; i < n7; n10 = i++, array2[n10] += n * n3, n3 += n5, n11 = i++, array2[n11] += n * n4, n4 += n6, n = array[n2++], n12 = i++, array2[n12] += n * n3, n3 += n5, n13 = i++, array2[n13] += n * n4, n4 += n6, n = array[n2++], n14 = i++, array2[n14] += n * n3, n3 += n5, n15 = i++, array2[n15] += n * n4, n4 += n6, n = array[n2++], n16 = i++, array2[n16] += n * n3, n3 += n5, n17 = i++, array2[n17] += n * n4, n4 += n6) {
            n = array[n2++];
        }
        int n18;
        int n19;
        for (n7 += 6; i < n7; n18 = i++, array2[n18] += n * n3, n3 += n5, n19 = i++, array2[n19] += n * n4, n4 += n6) {
            n = array[n2++];
        }
        cv549.l = n3 >> 2;
        cv549.r = n4 >> 2;
        cv549.j = n2 << 8;
        return i >> 1;
    }
    
    private static int f(int n, final byte[] array, final int[] array2, int n2, int i, int n3, int n4, int n5, int n6, int n7, final int n8, int n9, final Cv549 cv549) {
        n2 >>= 8;
        n9 >>= 8;
        n3 <<= 2;
        n4 <<= 2;
        n5 <<= 2;
        n6 <<= 2;
        if ((n7 = i + n2 - (n9 - 1)) > n8) {
            n7 = n8;
        }
        cv549.b += cv549.v * (n7 - i);
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        for (i <<= 1, n7 <<= 1, n7 -= 6; i < n7; n10 = i++, array2[n10] += n * n3, n3 += n5, n11 = i++, array2[n11] += n * n4, n4 += n6, n = array[n2--], n12 = i++, array2[n12] += n * n3, n3 += n5, n13 = i++, array2[n13] += n * n4, n4 += n6, n = array[n2--], n14 = i++, array2[n14] += n * n3, n3 += n5, n15 = i++, array2[n15] += n * n4, n4 += n6, n = array[n2--], n16 = i++, array2[n16] += n * n3, n3 += n5, n17 = i++, array2[n17] += n * n4, n4 += n6) {
            n = array[n2--];
        }
        int n18;
        int n19;
        for (n7 += 6; i < n7; n18 = i++, array2[n18] += n * n3, n3 += n5, n19 = i++, array2[n19] += n * n4, n4 += n6) {
            n = array[n2--];
        }
        cv549.l = n3 >> 2;
        cv549.r = n4 >> 2;
        cv549.j = n2 << 8;
        return i >> 1;
    }
    
    private static int c(int n, int n2, final byte[] array, final int[] array2, int j, int i, int b, final int n3, int n4, final int n5, final int n6, final Cv549 cv549, final int n7, final int n8) {
        cv549.l -= cv549.y * i;
        cv549.r -= cv549.p * i;
        if (n7 == 0 || (n4 = i + (n6 - j + n7 - 257) / n7) > n5) {
            n4 = n5;
        }
        while (i < n4) {
            n2 = j >> 8;
            n = array[n2];
            final int n9 = i++;
            array2[n9] += ((n << 8) + (array[n2 + 1] - n) * (j & 0xFF)) * b >> 6;
            b += n3;
            j += n7;
        }
        if (n7 == 0 || (n4 = i + (n6 - j + n7 - 1) / n7) > n5) {
            n4 = n5;
        }
        int n10;
        for (n2 = n8; i < n4; n10 = i++, array2[n10] += ((n << 8) + (n2 - n) * (j & 0xFF)) * b >> 6, b += n3, j += n7) {
            n = array[j >> 8];
        }
        cv549.l += cv549.y * i;
        cv549.r += cv549.p * i;
        cv549.b = b;
        cv549.j = j;
        return i;
    }
    
    private static int ag(int n, int n2, final byte[] array, final int[] array2, int j, int i, int l, int r, final int n3, final int n4, int n5, final int n6, final int n7, final Cv549 cv549, final int n8, final int n9) {
        cv549.b -= cv549.v * i;
        if (n8 == 0 || (n5 = i + (n7 - j + n8 - 257) / n8) > n6) {
            n5 = n6;
        }
        int n10;
        int n11;
        for (i <<= 1, n5 <<= 1; i < n5; n10 = i++, array2[n10] += n * l >> 6, l += n3, n11 = i++, array2[n11] += n * r >> 6, r += n4, j += n8) {
            n2 = j >> 8;
            n = array[n2];
            n = (n << 8) + (array[n2 + 1] - n) * (j & 0xFF);
        }
        if (n8 == 0 || (n5 = (i >> 1) + (n7 - j + n8 - 1) / n8) > n6) {
            n5 = n6;
        }
        n5 <<= 1;
        n2 = n9;
        while (i < n5) {
            n = array[j >> 8];
            n = (n << 8) + (n2 - n) * (j & 0xFF);
            final int n12 = i++;
            array2[n12] += n * l >> 6;
            l += n3;
            final int n13 = i++;
            array2[n13] += n * r >> 6;
            r += n4;
            j += n8;
        }
        i >>= 1;
        cv549.b += cv549.v * i;
        cv549.l = l;
        cv549.r = r;
        cv549.j = j;
        return i;
    }
    
    private static int aq(int n, int n2, final byte[] array, final int[] array2, int j, int i, int b, final int n3, int n4, final int n5, final int n6, final Cv549 cv549, final int n7, final int n8) {
        cv549.l -= cv549.y * i;
        cv549.r -= cv549.p * i;
        if (n7 == 0 || (n4 = i + (n6 + 256 - j + n7) / n7) > n5) {
            n4 = n5;
        }
        while (i < n4) {
            n2 = j >> 8;
            n = array[n2 - 1];
            final int n9 = i++;
            array2[n9] += ((n << 8) + (array[n2] - n) * (j & 0xFF)) * b >> 6;
            b += n3;
            j += n7;
        }
        if (n7 == 0 || (n4 = i + (n6 - j + n7) / n7) > n5) {
            n4 = n5;
        }
        int n10;
        for (n = n8, n2 = n7; i < n4; n10 = i++, array2[n10] += ((n << 8) + (array[j >> 8] - n) * (j & 0xFF)) * b >> 6, b += n3, j += n2) {}
        cv549.l += cv549.y * i;
        cv549.r += cv549.p * i;
        cv549.b = b;
        cv549.j = j;
        return i;
    }
    
    private static int ai(int n, int n2, final byte[] array, final int[] array2, int j, int i, int l, int r, final int n3, final int n4, int n5, final int n6, final int n7, final Cv549 cv549, final int n8, final int n9) {
        cv549.b -= cv549.v * i;
        if (n8 == 0 || (n5 = i + (n7 + 256 - j + n8) / n8) > n6) {
            n5 = n6;
        }
        int n10;
        int n11;
        for (i <<= 1, n5 <<= 1; i < n5; n10 = i++, array2[n10] += n * l >> 6, l += n3, n11 = i++, array2[n11] += n * r >> 6, r += n4, j += n8) {
            n2 = j >> 8;
            n = array[n2 - 1];
            n = (n << 8) + (array[n2] - n) * (j & 0xFF);
        }
        if (n8 == 0 || (n5 = (i >> 1) + (n7 - j + n8) / n8) > n6) {
            n5 = n6;
        }
        n5 <<= 1;
        n2 = n9;
        while (i < n5) {
            n = (n2 << 8) + (array[j >> 8] - n2) * (j & 0xFF);
            final int n12 = i++;
            array2[n12] += n * l >> 6;
            l += n3;
            final int n13 = i++;
            array2[n13] += n * r >> 6;
            r += n4;
            j += n8;
        }
        i >>= 1;
        cv549.b += cv549.v * i;
        cv549.l = l;
        cv549.r = r;
        cv549.j = j;
        return i;
    }
    
    private static int t(int n, int n2, final byte[] array, final int[] array2, int j, int i, final int n3, int n4, final int n5, final int n6, final Cv549 cv549, final int n7, final int n8) {
        if (n7 == 0 || (n4 = i + (n6 - j + n7 - 257) / n7) > n5) {
            n4 = n5;
        }
        while (i < n4) {
            n2 = j >> 8;
            n = array[n2];
            final int n9 = i++;
            array2[n9] += ((n << 8) + (array[n2 + 1] - n) * (j & 0xFF)) * n3 >> 6;
            j += n7;
        }
        if (n7 == 0 || (n4 = i + (n6 - j + n7 - 1) / n7) > n5) {
            n4 = n5;
        }
        int n10;
        for (n2 = n8; i < n4; n10 = i++, array2[n10] += ((n << 8) + (n2 - n) * (j & 0xFF)) * n3 >> 6, j += n7) {
            n = array[j >> 8];
        }
        cv549.j = j;
        return i;
    }
    
    private static int r(final byte[] array, final int[] array2, int n, int i, int n2, int n3, final int n4, int n5, final Cv549 cv549) {
        n >>= 8;
        n5 >>= 8;
        n2 <<= 2;
        if ((n3 = i + n5 - n) > n4) {
            n3 = n4;
        }
        int n6;
        int n7;
        int n8;
        int n9;
        for (n3 -= 3; i < n3; n6 = i++, array2[n6] += array[n++] * n2, n7 = i++, array2[n7] += array[n++] * n2, n8 = i++, array2[n8] += array[n++] * n2, n9 = i++, array2[n9] += array[n++] * n2) {}
        int n10;
        for (n3 += 3; i < n3; n10 = i++, array2[n10] += array[n++] * n2) {}
        cv549.j = n << 8;
        return i;
    }
    
    private static int n(int n, int n2, final byte[] array, final int[] array2, int j, int i, final int n3, int n4, final int n5, final int n6, final Cv549 cv549, final int n7, final int n8) {
        if (n7 == 0 || (n4 = i + (n6 + 256 - j + n7) / n7) > n5) {
            n4 = n5;
        }
        while (i < n4) {
            n2 = j >> 8;
            n = array[n2 - 1];
            final int n9 = i++;
            array2[n9] += ((n << 8) + (array[n2] - n) * (j & 0xFF)) * n3 >> 6;
            j += n7;
        }
        if (n7 == 0 || (n4 = i + (n6 - j + n7) / n7) > n5) {
            n4 = n5;
        }
        int n10;
        for (n = n8, n2 = n7; i < n4; n10 = i++, array2[n10] += ((n << 8) + (array[j >> 8] - n) * (j & 0xFF)) * n3 >> 6, j += n2) {}
        cv549.j = j;
        return i;
    }
}
