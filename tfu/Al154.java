/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Al154 {
    private static final boolean g = true;
    private int[] d;
    private int[] j;
    private byte[] q;

    public int d(byte[] arrby, int n, int n2, byte[] arrby2, int n3) {
        int n4 = 0;
        int n5 = n3 << 3;
        n2 += n;
        while (n < n2) {
            int n6 = arrby[n] & 0xFF;
            int n7 = this.d[n6];
            byte by = this.q[n6];
            if (by == 0) {
                throw new RuntimeException("No codeword for data value " + n6);
            }
            int n8 = n5 >> 3;
            int n9 = n5 & 7;
            n4 &= -n9 >> 31;
            int n10 = n8 + (n9 + by - 1 >> 3);
            arrby2[n8] = (byte)(n4 |= n7 >>> (n9 += 24));
            if (n8 < n10) {
                n4 = n7 >>> (n9 -= 8);
                arrby2[++n8] = (byte)n4;
                if (n8 < n10) {
                    n4 = n7 >>> (n9 -= 8);
                    arrby2[++n8] = (byte)n4;
                    if (n8 < n10) {
                        n4 = n7 >>> (n9 -= 8);
                        arrby2[++n8] = (byte)n4;
                        if (n8 < n10) {
                            n4 = n7 << -(n9 -= 8);
                            arrby2[++n8] = (byte)n4;
                        }
                    }
                }
            }
            n5 += by;
            ++n;
        }
        return (n5 + 7 >> 3) - n3;
    }

    public static int q(Al154 al154, byte[] arrby, int n, byte[] arrby2, int n2, int n3) {
        if (n3 == 0) {
            return 0;
        }
        int n4 = 0;
        n3 += n2;
        int n5 = n;
        do {
            byte by;
            n4 = (by = arrby[n5]) < 0 ? al154.j[n4] : ++n4;
            int n6 = al154.j[n4];
            if (n6 < 0) {
                arrby2[n2++] = (byte)(~n6);
                if (n2 >= n3) break;
                n4 = 0;
            }
            n4 = (by & 0x40) != 0 ? al154.j[n4] : ++n4;
            n6 = al154.j[n4];
            if (n6 < 0) {
                arrby2[n2++] = (byte)(~n6);
                if (n2 >= n3) break;
                n4 = 0;
            }
            n4 = (by & 0x20) != 0 ? al154.j[n4] : ++n4;
            n6 = al154.j[n4];
            if (n6 < 0) {
                arrby2[n2++] = (byte)(~n6);
                if (n2 >= n3) break;
                n4 = 0;
            }
            n4 = (by & 0x10) != 0 ? al154.j[n4] : ++n4;
            n6 = al154.j[n4];
            if (n6 < 0) {
                arrby2[n2++] = (byte)(~n6);
                if (n2 >= n3) break;
                n4 = 0;
            }
            n4 = (by & 8) != 0 ? al154.j[n4] : ++n4;
            n6 = al154.j[n4];
            if (n6 < 0) {
                arrby2[n2++] = (byte)(~n6);
                if (n2 >= n3) break;
                n4 = 0;
            }
            n4 = (by & 4) != 0 ? al154.j[n4] : ++n4;
            n6 = al154.j[n4];
            if (n6 < 0) {
                arrby2[n2++] = (byte)(~n6);
                if (n2 >= n3) break;
                n4 = 0;
            }
            n4 = (by & 2) != 0 ? al154.j[n4] : ++n4;
            n6 = al154.j[n4];
            if (n6 < 0) {
                arrby2[n2++] = (byte)(~n6);
                if (n2 >= n3) break;
                n4 = 0;
            }
            n4 = (by & 1) != 0 ? al154.j[n4] : ++n4;
            n6 = al154.j[n4];
            if (n6 < 0) {
                arrby2[n2++] = (byte)(~n6);
                if (n2 >= n3) break;
                n4 = 0;
            }
            ++n5;
        } while (true);
        return n5 + 1 - n;
    }

    private static void g(byte[] arrby, int n, int n2, int[] arrn) {
        if (n2 >= 0) {
            arrby[n2] = (byte)n;
        } else {
            Al154.g(arrby, n + 1, arrn[~n2], arrn);
            Al154.g(arrby, n + 1, arrn[~n2 + 1], arrn);
        }
    }

    public Al154(byte[] arrby) {
        int n = arrby.length;
        this.d = new int[n];
        this.q = arrby;
        int[] arrn = new int[33];
        this.j = new int[8];
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8 = arrby[i];
            if (n8 == 0) continue;
            int n9 = 1 << 32 - n8;
            this.d[i] = n6 = arrn[n8];
            if ((n6 & n9) != 0) {
                n3 = arrn[n8 - 1];
            } else {
                n3 = n6 | n9;
                for (n5 = n8 - 1; n5 >= 1 && (n4 = arrn[n5]) == n6; --n5) {
                    n7 = 1 << 32 - n5;
                    if ((n4 & n7) != 0) {
                        arrn[n5] = arrn[n5 - 1];
                        break;
                    }
                    arrn[n5] = n4 | n7;
                }
            }
            arrn[n8] = n3;
            for (n5 = n8 + 1; n5 <= 32; ++n5) {
                if (arrn[n5] != n6) continue;
                arrn[n5] = n3;
            }
            n5 = 0;
            for (n4 = 0; n4 < n8; ++n4) {
                n7 = Integer.MIN_VALUE >>> n4;
                if ((n6 & n7) != 0) {
                    if (this.j[n5] == 0) {
                        this.j[n5] = n2;
                    }
                    n5 = this.j[n5];
                } else {
                    ++n5;
                }
                if (n5 >= this.j.length) {
                    int[] arrn2 = new int[this.j.length * 2];
                    for (int j = 0; j < this.j.length; ++j) {
                        arrn2[j] = this.j[j];
                    }
                    this.j = arrn2;
                }
                n7 >>>= 1;
            }
            this.j[n5] = ~i;
            if (n5 < n2) continue;
            n2 = n5 + 1;
        }
    }
}

