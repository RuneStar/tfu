/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.awt.Frame;
import tfu.Hd425;
import tfu.Hw321;

public final class Hq338 {
    public static boolean g = true;

    public static Hd425[] g(Hw321 hw321) {
        int[] arrn = Hw321.g(hw321);
        Hd425[] arrhd425 = new Hd425[arrn.length >> 2];
        for (int i = 0; i < arrhd425.length; ++i) {
            Hd425 hd425;
            arrhd425[i] = hd425 = new Hd425();
            hd425.g = arrn[i << 2];
            hd425.d = arrn[(i << 2) + 1];
            hd425.q = arrn[(i << 2) + 2];
            hd425.j = arrn[(i << 2) + 3];
        }
        return arrhd425;
    }

    public static Frame d(Hw321 hw321, int n, int n2, int n3, int n4) {
        Object object;
        if (n3 == 0) {
            object = Hq338.g(hw321);
            if (object == null) {
                return null;
            }
            boolean bl = false;
            for (int i = 0; i < ((Object)object).length; ++i) {
                if (((Hd425)object[i]).g != n || ((Hd425)object[i]).d != n2 || n4 != 0 && n4 != ((Hd425)object[i]).j || bl && ((Hd425)object[i]).q <= n3) continue;
                n3 = ((Hd425)object[i]).q;
                bl = true;
            }
            if (!bl) {
                return null;
            }
        }
        object = new Frame("Jagex Full Screen");
        ((Frame)object).setResizable(false);
        hw321.d((Frame)object, n, n2, n3, n4);
        return object;
    }

    private Hq338() {
    }

    public static void q(Hw321 hw321, Frame frame) {
        Hw321.q(hw321);
        frame.setVisible(false);
        frame.dispose();
    }
}

