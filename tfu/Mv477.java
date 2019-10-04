/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Mv477 {
    private static int[] b;
    private static int d;
    private static byte[][] e;
    private static int g;
    private static byte[][] h;
    private static byte[][] j;
    private static byte[][][] l;
    private static int q;
    private static int[] s;

    public static synchronized void q(byte[] arrby) {
        if (arrby.length == 100 && g < 1000) {
            Mv477.j[Mv477.g++] = arrby;
            return;
        }
        if (arrby.length == 5000 && d < 250) {
            Mv477.e[Mv477.d++] = arrby;
            return;
        }
        if (arrby.length == 30000 && q < 50) {
            Mv477.h[Mv477.q++] = arrby;
            return;
        }
        if (l != null) {
            for (int i = 0; i < s.length; ++i) {
                if (arrby.length != s[i] || b[i] >= l[i].length) continue;
                int[] arrn = b;
                int n = i;
                int n2 = arrn[n];
                arrn[n] = n2 + 1;
                Mv477.l[i][n2] = arrby;
                return;
            }
        }
    }

    public static synchronized byte[] d(int n) {
        if (n == 100 && g > 0) {
            byte[] arrby = j[--g];
            Mv477.j[Mv477.g] = null;
            return arrby;
        }
        if (n == 5000 && d > 0) {
            byte[] arrby = e[--d];
            Mv477.e[Mv477.d] = null;
            return arrby;
        }
        if (n == 30000 && q > 0) {
            byte[] arrby = h[--q];
            Mv477.h[Mv477.q] = null;
            return arrby;
        }
        if (l != null) {
            for (int i = 0; i < s.length; ++i) {
                if (n != s[i] || b[i] <= 0) continue;
                int[] arrn = b;
                int n2 = i;
                int n3 = arrn[n2] - 1;
                arrn[n2] = n3;
                byte[] arrby = l[i][n3];
                Mv477.l[i][Mv477.b[i]] = null;
                return arrby;
            }
        }
        return new byte[n];
    }

    public static void g(int[] arrn, int[] arrn2) {
        if (arrn == null || arrn2 == null) {
            s = null;
            b = null;
            l = null;
            return;
        }
        s = arrn;
        b = new int[arrn.length];
        l = new byte[arrn.length][][];
        for (int i = 0; i < s.length; ++i) {
            Mv477.l[i] = new byte[arrn2[i]][];
        }
    }

    static {
        g = 0;
        d = 0;
        q = 0;
        j = new byte[1000][];
        e = new byte[250][];
        h = new byte[50][];
    }
}

