/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Gg3;

public class Ch643 {
    private int b;
    private int d = 2;
    int e;
    boolean g = true;
    int h;
    private int[] j;
    private int l;
    private int[] q = new int[2];
    private int r;
    int s;
    private int v;
    private int w;

    public static final void g(Ch643 ch643, Gg3 gg3) {
        ch643.s = Gg3.ar(gg3);
        ch643.e = Gg3.bd(gg3);
        ch643.h = Gg3.bd(gg3);
        Ch643.d(ch643, gg3);
    }

    public Ch643() {
        this.j = new int[2];
        this.q[0] = 0;
        this.q[1] = 65535;
        this.j[0] = 0;
        this.j[1] = 65535;
    }

    static final int j(Ch643 ch643, int n) {
        if (ch643.v >= ch643.b) {
            ch643.r = ch643.j[ch643.l++] << 15;
            if (ch643.l >= ch643.d) {
                ch643.l = ch643.d - 1;
            }
            ch643.b = (int)((double)ch643.q[ch643.l] / 65536.0 * (double)n);
            if (ch643.b > ch643.v) {
                ch643.w = ((ch643.j[ch643.l] << 15) - ch643.r) / (ch643.b - ch643.v);
            }
        }
        ch643.r += ch643.w;
        ++ch643.v;
        return ch643.r - ch643.w >> 15;
    }

    public static final void d(Ch643 ch643, Gg3 gg3) {
        ch643.d = Gg3.ar(gg3);
        ch643.q = new int[ch643.d];
        ch643.j = new int[ch643.d];
        for (int i = 0; i < ch643.d; ++i) {
            ch643.q[i] = Gg3.au(gg3);
            ch643.j[i] = Gg3.au(gg3);
        }
    }

    static final void q(Ch643 ch643) {
        ch643.b = 0;
        ch643.l = 0;
        ch643.w = 0;
        ch643.r = 0;
        ch643.v = 0;
    }
}

