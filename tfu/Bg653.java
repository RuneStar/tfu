/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import tfu.Bn279;
import tfu.Br121;

class Bg653
extends FutureTask
implements Comparable {
    final Br121 d;
    final Bn279 g;
    int j;
    final int q;

    Bg653(Callable callable, Bn279 bn279, Br121 br121, int n) {
        super(callable);
        this.g = bn279;
        this.d = br121;
        this.q = n;
        Bg653.q(this);
    }

    public static int x(Bg653 bg653, Runnable runnable) {
        Bg653 bg6532 = (Bg653)runnable;
        if (bg653.j > bg6532.j) {
            return -1;
        }
        if (bg653.j < bg6532.j) {
            return 1;
        }
        return bg653.q - bg6532.q;
    }

    static void q(Bg653 bg653) {
        bg653.j = bg653.d.e();
    }
}

