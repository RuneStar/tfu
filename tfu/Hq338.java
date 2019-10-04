// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.awt.Frame;

public final class Hq338
{
    public static boolean g;
    
    public static Hd425[] g(final Hw321 hw321) {
        final int[] g = Hw321.g(hw321);
        final Hd425[] array = new Hd425[g.length >> 2];
        for (int i = 0; i < array.length; ++i) {
            final Hd425 hd425 = new Hd425();
            array[i] = hd425;
            hd425.g = g[i << 2];
            hd425.d = g[(i << 2) + 1];
            hd425.q = g[(i << 2) + 2];
            hd425.j = g[(i << 2) + 3];
        }
        return array;
    }
    
    public static Frame d(final Hw321 hw321, final int n, final int n2, int q, final int n3) {
        if (q == 0) {
            final Hd425[] g = g(hw321);
            if (g == null) {
                return null;
            }
            int n4 = 0;
            for (int i = 0; i < g.length; ++i) {
                if (g[i].g == n && g[i].d == n2 && (n3 == 0 || n3 == g[i].j) && (n4 == 0 || g[i].q > q)) {
                    q = g[i].q;
                    n4 = 1;
                }
            }
            if (n4 == 0) {
                return null;
            }
        }
        final Frame frame = new Frame("Jagex Full Screen");
        frame.setResizable(false);
        hw321.d(frame, n, n2, q, n3);
        return frame;
    }
    
    static {
        Hq338.g = true;
    }
    
    private Hq338() {
    }
    
    public static void q(final Hw321 hw321, final Frame frame) {
        Hw321.q(hw321);
        frame.setVisible(false);
        frame.dispose();
    }
}
