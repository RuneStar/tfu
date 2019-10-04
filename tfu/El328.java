// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class El328 extends Ln265
{
    private static El328[] e;
    private static int h;
    public int d;
    public Eu326 g;
    public int j;
    public Gs329 q;
    
    static {
        El328.e = new El328[300];
        El328.h = 0;
    }
    
    private static El328 g() {
        if (El328.h == 0) {
            return new El328();
        }
        return El328.e[--El328.h];
    }
    
    public static El328 d(final Eu326 g, final Ic327 ic327) {
        final El328 g2 = g();
        g2.g = g;
        g2.d = g.ax;
        if (g2.d == -1) {
            g2.q = new Gs329(260);
        }
        else if (g2.d == -2) {
            g2.q = new Gs329(10000);
        }
        else if (g2.d <= 18) {
            g2.q = new Gs329(20);
        }
        else if (g2.d <= 98) {
            g2.q = new Gs329(100);
        }
        else {
            g2.q = new Gs329(260);
        }
        Gs329.g(g2.q, ic327);
        Gs329.d(g2.q, g2.g.ordinal());
        g2.j = 0;
        return g2;
    }
    
    public static El328 q() {
        final El328 g = g();
        g.g = null;
        g.d = 0;
        g.q = new Gs329(5000);
        return g;
    }
    
    public static void j(final El328 el328) {
        if (El328.h >= El328.e.length) {
            return;
        }
        El328.e[El328.h++] = el328;
    }
    
    private El328() {
    }
}
