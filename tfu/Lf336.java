/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.core.constants.D123;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import rs2.client.Al161;
import rs2.client.client;
import tfu.Lx337;

public class Lf336 {
    public static String d;
    public static Lx337 e;
    public static final boolean g = true;
    public static boolean h;
    public static Lx337 j;
    public static Lx337 q;

    public static void d(int n, String string) {
        q = new Lx337();
        Lf336.q.g = n;
        Lf336.q.d = d != null ? d : string;
        if (client.t != D123.LIVE) {
            Lf336.q.q = 40000 + Lf336.q.g;
            Lf336.q.j = 50000 + Lf336.q.g;
        }
        try {
            Al161.d(InetAddress.getByName(Lf336.q.d));
        }
        catch (UnknownHostException unknownHostException) {
            // empty catch block
        }
        System.out.println("Now trying to connect to " + Lf336.q.d + ":" + Lf336.q.g);
    }

    public static void g(int n, String string) {
        e = q;
        h = true;
        Lf336.d(n, string);
    }
}

