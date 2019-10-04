/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.PrintStream;

public class Ap127 {
    public static final boolean b = false;
    public static boolean d;
    public static boolean e;
    public static boolean g;
    public static int h;
    public static float j;
    public static int q;
    public static final boolean s = false;

    public static void g(long l, String string) {
        if (d) {
            float f = (float)l * 1.0E-6f;
            int n = (int)(f = (float)((int)(f * 10.0f)) / 10.0f);
            if (n > 100) {
                n = 100;
            }
            for (int i = 1; i < n; ++i) {
                System.out.print(" ");
            }
            if (f > 10.0f) {
                System.out.println("!!! " + string);
            } else {
                System.out.println(string);
            }
        }
    }

    static {
        g = false;
        d = false;
        q = 50;
        j = 2.0f;
        e = false;
        h = 0;
    }
}

