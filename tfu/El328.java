/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Eu326;
import tfu.Gs329;
import tfu.Ic327;
import tfu.Ln265;

public class El328
extends Ln265 {
    private static El328[] e = new El328[300];
    private static int h = 0;
    public int d;
    public Eu326 g;
    public int j;
    public Gs329 q;

    private static El328 g() {
        if (h == 0) {
            return new El328();
        }
        return e[--h];
    }

    public static El328 d(Eu326 eu326, Ic327 ic327) {
        El328 el328 = El328.g();
        el328.g = eu326;
        el328.d = eu326.ax;
        el328.q = el328.d == -1 ? new Gs329(260) : (el328.d == -2 ? new Gs329(10000) : (el328.d <= 18 ? new Gs329(20) : (el328.d <= 98 ? new Gs329(100) : new Gs329(260))));
        Gs329.g(el328.q, ic327);
        Gs329.d(el328.q, el328.g.ordinal());
        el328.j = 0;
        return el328;
    }

    public static El328 q() {
        El328 el328 = El328.g();
        el328.g = null;
        el328.d = 0;
        el328.q = new Gs329(5000);
        return el328;
    }

    public static void j(El328 el328) {
        if (h >= e.length) {
            return;
        }
        El328.e[El328.h++] = el328;
    }

    private El328() {
    }
}

