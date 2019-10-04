/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Cg550;
import tfu.Jz233;

class Cn647 {
    private int d;
    private float[][] e;
    int g;
    private int[] h;
    private int[] j;
    private int[] q;

    private static int g(int n, int n2) {
        int n3 = (int)Math.pow(n, 1.0 / (double)n2) + 1;
        while (Jz233.g(n3, n2) > n) {
            --n3;
        }
        return n3;
    }

    private static void d(Cn647 cn647) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int[] arrn = new int[cn647.d];
        int[] arrn2 = new int[33];
        for (n = 0; n < cn647.d; ++n) {
            int n8;
            n5 = cn647.q[n];
            if (n5 == 0) continue;
            n6 = 1 << 32 - n5;
            arrn[n] = n2 = arrn2[n5];
            if ((n2 & n6) != 0) {
                n7 = arrn2[n5 - 1];
            } else {
                n7 = n2 | n6;
                for (n4 = n5 - 1; n4 >= 1 && (n8 = arrn2[n4]) == n2; --n4) {
                    n3 = 1 << 32 - n4;
                    if ((n8 & n3) != 0) {
                        arrn2[n4] = arrn2[n4 - 1];
                        break;
                    }
                    arrn2[n4] = n8 | n3;
                }
            }
            arrn2[n5] = n7;
            for (n4 = n5 + 1; n4 <= 32; ++n4) {
                n8 = arrn2[n4];
                if (n8 != n2) continue;
                arrn2[n4] = n7;
            }
        }
        cn647.h = new int[8];
        int n9 = 0;
        for (n = 0; n < cn647.d; ++n) {
            n5 = cn647.q[n];
            if (n5 == 0) continue;
            n6 = arrn[n];
            n2 = 0;
            for (n7 = 0; n7 < n5; ++n7) {
                n4 = Integer.MIN_VALUE >>> n7;
                if ((n6 & n4) != 0) {
                    if (cn647.h[n2] == 0) {
                        cn647.h[n2] = n9;
                    }
                    n2 = cn647.h[n2];
                } else {
                    ++n2;
                }
                if (n2 >= cn647.h.length) {
                    int[] arrn3 = new int[cn647.h.length * 2];
                    for (n3 = 0; n3 < cn647.h.length; ++n3) {
                        arrn3[n3] = cn647.h[n3];
                    }
                    cn647.h = arrn3;
                }
                n4 >>>= 1;
            }
            cn647.h[n2] = ~n;
            if (n2 < n9) continue;
            n9 = n2 + 1;
        }
    }

    Cn647() {
        block14 : {
            int n;
            int n2;
            int n3;
            boolean bl;
            int n4;
            Cg550.j(24);
            this.g = Cg550.j(16);
            this.d = Cg550.j(24);
            this.q = new int[this.d];
            boolean bl2 = bl = Cg550.q() != 0;
            if (bl) {
                n2 = 0;
                n3 = Cg550.j(5) + 1;
                while (n2 < this.d) {
                    int n5 = Cg550.j(Jz233.s(this.d - n2));
                    for (n = 0; n < n5; ++n) {
                        this.q[n2++] = n3;
                    }
                    ++n3;
                }
            } else {
                n2 = Cg550.q() != 0 ? 1 : 0;
                for (n3 = 0; n3 < this.d; ++n3) {
                    this.q[n3] = n2 != 0 && Cg550.q() == 0 ? 0 : Cg550.j(5) + 1;
                }
            }
            Cn647.d(this);
            n2 = Cg550.j(4);
            if (n2 <= 0) break block14;
            float f = Cg550.g(Cg550.j(32));
            float f2 = Cg550.g(Cg550.j(32));
            n = Cg550.j(4) + 1;
            boolean bl3 = Cg550.q() != 0;
            int n6 = n2 == 1 ? Cn647.g(this.d, this.g) : this.d * this.g;
            this.j = new int[n6];
            for (n4 = 0; n4 < n6; ++n4) {
                this.j[n4] = Cg550.j(n);
            }
            this.e = new float[this.d][this.g];
            if (n2 == 1) {
                for (n4 = 0; n4 < this.d; ++n4) {
                    float f3 = 0.0f;
                    int n7 = 1;
                    for (int i = 0; i < this.g; ++i) {
                        float f4;
                        int n8 = n4 / n7 % n6;
                        this.e[n4][i] = f4 = (float)this.j[n8] * f2 + f + f3;
                        if (bl3) {
                            f3 = f4;
                        }
                        n7 *= n6;
                    }
                }
            } else {
                for (n4 = 0; n4 < this.d; ++n4) {
                    float f5 = 0.0f;
                    int n9 = n4 * this.g;
                    for (int i = 0; i < this.g; ++i) {
                        float f6;
                        this.e[n4][i] = f6 = (float)this.j[n9] * f2 + f + f5;
                        if (bl3) {
                            f5 = f6;
                        }
                        ++n9;
                    }
                }
            }
        }
    }
}

