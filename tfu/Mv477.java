// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Mv477
{
    private static int[] b;
    private static int d;
    private static byte[][] e;
    private static int g;
    private static byte[][] h;
    private static byte[][] j;
    private static byte[][][] l;
    private static int q;
    private static int[] s;
    
    public static synchronized void q(final byte[] array) {
        if (array.length == 100 && Mv477.g < 1000) {
            Mv477.j[Mv477.g++] = array;
            return;
        }
        if (array.length == 5000 && Mv477.d < 250) {
            Mv477.e[Mv477.d++] = array;
            return;
        }
        if (array.length == 30000 && Mv477.q < 50) {
            Mv477.h[Mv477.q++] = array;
            return;
        }
        if (Mv477.l != null) {
            for (int i = 0; i < Mv477.s.length; ++i) {
                if (array.length == Mv477.s[i] && Mv477.b[i] < Mv477.l[i].length) {
                    Mv477.l[i][Mv477.b[i]++] = array;
                    return;
                }
            }
        }
    }
    
    public static synchronized byte[] d(final int n) {
        if (n == 100 && Mv477.g > 0) {
            final byte[] array = Mv477.j[--Mv477.g];
            Mv477.j[Mv477.g] = null;
            return array;
        }
        if (n == 5000 && Mv477.d > 0) {
            final byte[] array2 = Mv477.e[--Mv477.d];
            Mv477.e[Mv477.d] = null;
            return array2;
        }
        if (n == 30000 && Mv477.q > 0) {
            final byte[] array3 = Mv477.h[--Mv477.q];
            Mv477.h[Mv477.q] = null;
            return array3;
        }
        if (Mv477.l != null) {
            for (int i = 0; i < Mv477.s.length; ++i) {
                if (n == Mv477.s[i] && Mv477.b[i] > 0) {
                    final byte[][] array4 = Mv477.l[i];
                    final int[] b = Mv477.b;
                    final int n2 = i;
                    final int n3 = b[n2] - 1;
                    b[n2] = n3;
                    final byte[] array5 = array4[n3];
                    Mv477.l[i][Mv477.b[i]] = null;
                    return array5;
                }
            }
        }
        return new byte[n];
    }
    
    public static void g(final int[] s, final int[] array) {
        if (s == null || array == null) {
            Mv477.s = null;
            Mv477.b = null;
            Mv477.l = null;
            return;
        }
        Mv477.s = s;
        Mv477.b = new int[s.length];
        Mv477.l = new byte[s.length][][];
        for (int i = 0; i < Mv477.s.length; ++i) {
            Mv477.l[i] = new byte[array[i]][];
        }
    }
    
    static {
        Mv477.g = 0;
        Mv477.d = 0;
        Mv477.q = 0;
        Mv477.j = new byte[1000][];
        Mv477.e = new byte[250][];
        Mv477.h = new byte[50][];
    }
}
