// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class Bg653 extends FutureTask implements Comparable
{
    final Br121 d;
    final Bn279 g;
    int j;
    final int q;
    
    Bg653(final Callable callable, final Bn279 g, final Br121 d, final int q) {
        super(callable);
        this.g = g;
        this.d = d;
        this.q = q;
        q(this);
    }
    
    public static int x(final Bg653 bg653, final Runnable runnable) {
        final Bg653 bg654 = (Bg653)runnable;
        if (bg653.j > bg654.j) {
            return -1;
        }
        if (bg653.j < bg654.j) {
            return 1;
        }
        return bg653.q - bg654.q;
    }
    
    static void q(final Bg653 bg653) {
        bg653.j = bg653.d.e();
    }
}
