// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Al154
{
    private static final boolean g = true;
    private int[] d;
    private int[] j;
    private byte[] q;
    
    public int d(final byte[] array, int i, int n, final byte[] array2, final int n2) {
        int n3 = 0;
        int n4 = n2 << 3;
        int j;
        int n5;
        byte b;
        int n6;
        int n7;
        int n8;
        int n9;
        for (n += i; i < n; ++i) {
            j = (array[i] & 0xFF);
            n5 = this.d[j];
            b = this.q[j];
            if (b == 0) {
                throw new RuntimeException("No codeword for data value " + j);
            }
            n6 = n4 >> 3;
            n7 = (n4 & 0x7);
            n8 = (n3 & -n7 >> 31);
            n9 = n6 + (n7 + b - 1 >> 3);
            n7 += 24;
            array2[n6] = (byte)(n3 = (n8 | n5 >>> n7));
            if (n6 < n9) {
                ++n6;
                n7 -= 8;
                array2[n6] = (byte)(n3 = n5 >>> n7);
                if (n6 < n9) {
                    ++n6;
                    n7 -= 8;
                    array2[n6] = (byte)(n3 = n5 >>> n7);
                    if (n6 < n9) {
                        ++n6;
                        n7 -= 8;
                        array2[n6] = (byte)(n3 = n5 >>> n7);
                        if (n6 < n9) {
                            ++n6;
                            n7 -= 8;
                            array2[n6] = (byte)(n3 = n5 << -n7);
                        }
                    }
                }
            }
            n4 += b;
        }
        return (n4 + 7 >> 3) - n2;
    }
    
    public static int q(final Al154 al154, final byte[] array, final int n, final byte[] array2, int n2, int n3) {
        if (n3 == 0) {
            return 0;
        }
        int n4 = 0;
        n3 += n2;
        int n5 = n;
        while (true) {
            final byte b = array[n5];
            if (b < 0) {
                n4 = al154.j[n4];
            }
            else {
                ++n4;
            }
            final int n6;
            if ((n6 = al154.j[n4]) < 0) {
                array2[n2++] = (byte)~n6;
                if (n2 >= n3) {
                    break;
                }
                n4 = 0;
            }
            if ((b & 0x40) != 0x0) {
                n4 = al154.j[n4];
            }
            else {
                ++n4;
            }
            final int n7;
            if ((n7 = al154.j[n4]) < 0) {
                array2[n2++] = (byte)~n7;
                if (n2 >= n3) {
                    break;
                }
                n4 = 0;
            }
            if ((b & 0x20) != 0x0) {
                n4 = al154.j[n4];
            }
            else {
                ++n4;
            }
            final int n8;
            if ((n8 = al154.j[n4]) < 0) {
                array2[n2++] = (byte)~n8;
                if (n2 >= n3) {
                    break;
                }
                n4 = 0;
            }
            if ((b & 0x10) != 0x0) {
                n4 = al154.j[n4];
            }
            else {
                ++n4;
            }
            final int n9;
            if ((n9 = al154.j[n4]) < 0) {
                array2[n2++] = (byte)~n9;
                if (n2 >= n3) {
                    break;
                }
                n4 = 0;
            }
            if ((b & 0x8) != 0x0) {
                n4 = al154.j[n4];
            }
            else {
                ++n4;
            }
            final int n10;
            if ((n10 = al154.j[n4]) < 0) {
                array2[n2++] = (byte)~n10;
                if (n2 >= n3) {
                    break;
                }
                n4 = 0;
            }
            if ((b & 0x4) != 0x0) {
                n4 = al154.j[n4];
            }
            else {
                ++n4;
            }
            final int n11;
            if ((n11 = al154.j[n4]) < 0) {
                array2[n2++] = (byte)~n11;
                if (n2 >= n3) {
                    break;
                }
                n4 = 0;
            }
            if ((b & 0x2) != 0x0) {
                n4 = al154.j[n4];
            }
            else {
                ++n4;
            }
            final int n12;
            if ((n12 = al154.j[n4]) < 0) {
                array2[n2++] = (byte)~n12;
                if (n2 >= n3) {
                    break;
                }
                n4 = 0;
            }
            if ((b & 0x1) != 0x0) {
                n4 = al154.j[n4];
            }
            else {
                ++n4;
            }
            final int n13;
            if ((n13 = al154.j[n4]) < 0) {
                array2[n2++] = (byte)~n13;
                if (n2 >= n3) {
                    break;
                }
                n4 = 0;
            }
            ++n5;
        }
        return n5 + 1 - n;
    }
    
    private static void g(final byte[] array, final int n, final int n2, final int[] array2) {
        if (n2 >= 0) {
            array[n2] = (byte)n;
        }
        else {
            g(array, n + 1, array2[~n2], array2);
            g(array, n + 1, array2[~n2 + 1], array2);
        }
    }
    
    public Al154(final byte[] q) {
        final int length = q.length;
        this.d = new int[length];
        this.q = q;
        final int[] array = new int[33];
        this.j = new int[8];
        int n = 0;
        for (int i = 0; i < length; ++i) {
            final byte b = q[i];
            if (b != 0) {
                final int n2 = 1 << 32 - b;
                final int n3 = array[b];
                this.d[i] = n3;
                int n4;
                if ((n3 & n2) != 0x0) {
                    n4 = array[b - 1];
                }
                else {
                    n4 = (n3 | n2);
                    for (int j = b - 1; j >= 1; --j) {
                        final int n5 = array[j];
                        if (n5 != n3) {
                            break;
                        }
                        final int n6 = 1 << 32 - j;
                        if ((n5 & n6) != 0x0) {
                            array[j] = array[j - 1];
                            break;
                        }
                        array[j] = (n5 | n6);
                    }
                }
                array[b] = n4;
                for (int k = b + 1; k <= 32; ++k) {
                    if (array[k] == n3) {
                        array[k] = n4;
                    }
                }
                int n7 = 0;
                for (byte b2 = 0; b2 < b; ++b2) {
                    if ((n3 & Integer.MIN_VALUE >>> b2) != 0x0) {
                        if (this.j[n7] == 0) {
                            this.j[n7] = n;
                        }
                        n7 = this.j[n7];
                    }
                    else {
                        ++n7;
                    }
                    if (n7 >= this.j.length) {
                        final int[] l = new int[this.j.length * 2];
                        for (int n8 = 0; n8 < this.j.length; ++n8) {
                            l[n8] = this.j[n8];
                        }
                        this.j = l;
                    }
                }
                this.j[n7] = ~i;
                if (n7 >= n) {
                    n = n7 + 1;
                }
            }
        }
    }
}
