// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.net.UnknownHostException;
import rs2.client.Al161;
import java.net.InetAddress;
import com.jagex.core.constants.D123;
import rs2.client.client;

public class Lf336
{
    public static String d;
    public static Lx337 e;
    public static final boolean g = true;
    public static boolean h;
    public static Lx337 j;
    public static Lx337 q;
    
    public static void d(final int g, final String d) {
        Lf336.q = new Lx337();
        Lf336.q.g = g;
        if (Lf336.d != null) {
            Lf336.q.d = Lf336.d;
        }
        else {
            Lf336.q.d = d;
        }
        if (client.t != D123.LIVE) {
            Lf336.q.q = 40000 + Lf336.q.g;
            Lf336.q.j = 50000 + Lf336.q.g;
        }
        try {
            Al161.d(InetAddress.getByName(Lf336.q.d));
        }
        catch (UnknownHostException ex) {}
        System.out.println("Now trying to connect to " + Lf336.q.d + ":" + Lf336.q.g);
    }
    
    public static void g(final int n, final String s) {
        Lf336.e = Lf336.q;
        Lf336.h = true;
        d(n, s);
    }
}
