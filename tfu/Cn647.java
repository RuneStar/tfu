// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Cn647
{
    private int d;
    private float[][] e;
    int g;
    private int[] h;
    private int[] j;
    private int[] q;
    
    private static int g(final int n, final int n2) {
        int n3;
        for (n3 = (int)Math.pow(n, 1.0 / n2) + 1; Jz233.g(n3, n2) > n; --n3) {}
        return n3;
    }
    
    private static void d(final Cn647 cn647) {
        final int[] array = new int[cn647.d];
        final int[] array2 = new int[33];
        for (int i = 0; i < cn647.d; ++i) {
            final int n = cn647.q[i];
            if (n != 0) {
                final int n2 = 1 << 32 - n;
                final int n3 = array2[n];
                array[i] = n3;
                int n4;
                if ((n3 & n2) != 0x0) {
                    n4 = array2[n - 1];
                }
                else {
                    n4 = (n3 | n2);
                    for (int j = n - 1; j >= 1; --j) {
                        final int n5 = array2[j];
                        if (n5 != n3) {
                            break;
                        }
                        final int n6 = 1 << 32 - j;
                        if ((n5 & n6) != 0x0) {
                            array2[j] = array2[j - 1];
                            break;
                        }
                        array2[j] = (n5 | n6);
                    }
                }
                array2[n] = n4;
                for (int k = n + 1; k <= 32; ++k) {
                    if (array2[k] == n3) {
                        array2[k] = n4;
                    }
                }
            }
        }
        cn647.h = new int[8];
        int n7 = 0;
        for (int l = 0; l < cn647.d; ++l) {
            final int n8 = cn647.q[l];
            if (n8 != 0) {
                final int n9 = array[l];
                int n10 = 0;
                for (int n11 = 0; n11 < n8; ++n11) {
                    if ((n9 & Integer.MIN_VALUE >>> n11) != 0x0) {
                        if (cn647.h[n10] == 0) {
                            cn647.h[n10] = n7;
                        }
                        n10 = cn647.h[n10];
                    }
                    else {
                        ++n10;
                    }
                    if (n10 >= cn647.h.length) {
                        final int[] h = new int[cn647.h.length * 2];
                        for (int n12 = 0; n12 < cn647.h.length; ++n12) {
                            h[n12] = cn647.h[n12];
                        }
                        cn647.h = h;
                    }
                }
                cn647.h[n10] = ~l;
                if (n10 >= n7) {
                    n7 = n10 + 1;
                }
            }
        }
    }
    
    Cn647() {
        Cg550.j(24);
        this.g = Cg550.j(16);
        this.d = Cg550.j(24);
        this.q = new int[this.d];
        if (Cg550.q() != 0) {
            int i = 0;
            int n = Cg550.j(5) + 1;
            while (i < this.d) {
                for (int j = Cg550.j(Jz233.s(this.d - i)), k = 0; k < j; ++k) {
                    this.q[i++] = n;
                }
                ++n;
            }
        }
        else {
            final boolean b = Cg550.q() != 0;
            for (int l = 0; l < this.d; ++l) {
                if (b && Cg550.q() == 0) {
                    this.q[l] = 0;
                }
                else {
                    this.q[l] = Cg550.j(5) + 1;
                }
            }
        }
        d(this);
        final int m = Cg550.j(4);
        if (m > 0) {
            final float g = Cg550.g(Cg550.j(32));
            final float g2 = Cg550.g(Cg550.j(32));
            final int n2 = Cg550.j(4) + 1;
            final boolean b2 = Cg550.q() != 0;
            int g3;
            if (m == 1) {
                g3 = g(this.d, this.g);
            }
            else {
                g3 = this.d * this.g;
            }
            this.j = new int[g3];
            for (int n3 = 0; n3 < g3; ++n3) {
                this.j[n3] = Cg550.j(n2);
            }
            this.e = new float[this.d][this.g];
            if (m == 1) {
                for (int n4 = 0; n4 < this.d; ++n4) {
                    float n5 = 0.0f;
                    int n6 = 1;
                    for (int n7 = 0; n7 < this.g; ++n7) {
                        final float n8 = this.j[n4 / n6 % g3] * g2 + g + n5;
                        this.e[n4][n7] = n8;
                        if (b2) {
                            n5 = n8;
                        }
                        n6 *= g3;
                    }
                }
            }
            else {
                for (int n9 = 0; n9 < this.d; ++n9) {
                    float n10 = 0.0f;
                    int n11 = n9 * this.g;
                    for (int n12 = 0; n12 < this.g; ++n12) {
                        final float n13 = this.j[n11] * g2 + g + n10;
                        this.e[n9][n12] = n13;
                        if (b2) {
                            n10 = n13;
                        }
                        ++n11;
                    }
                }
            }
        }
    }
}
