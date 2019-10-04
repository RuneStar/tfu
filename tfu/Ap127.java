// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Ap127
{
    public static final boolean b = false;
    public static boolean d;
    public static boolean e;
    public static boolean g;
    public static int h;
    public static float j;
    public static int q;
    public static final boolean s = false;
    
    public static void g(final long n, final String s) {
        if (Ap127.d) {
            final float n2 = (int)(n * 1.0E-6f * 10.0f) / 10.0f;
            int n3 = (int)n2;
            if (n3 > 100) {
                n3 = 100;
            }
            for (int i = 1; i < n3; ++i) {
                System.out.print(" ");
            }
            if (n2 > 10.0f) {
                System.out.println("!!! " + s);
            }
            else {
                System.out.println(s);
            }
        }
    }
    
    static {
        Ap127.g = false;
        Ap127.d = false;
        Ap127.q = 50;
        Ap127.j = 2.0f;
        Ap127.e = false;
        Ap127.h = 0;
    }
}
