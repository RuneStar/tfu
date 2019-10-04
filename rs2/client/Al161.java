// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import java.net.InetAddress;

public class Al161
{
    public static int d;
    private static final Runnable e;
    public static final int g = 1000;
    private static Thread h;
    private static boolean j;
    private static InetAddress q;
    
    public static void g() {
        (Al161.h = new Thread(Al161.e)).start();
    }
    
    public static void d(final InetAddress q) {
        synchronized (Al161.e) {
            Al161.q = q;
            Al161.d = -1;
        }
    }
    
    public static void q() {
        Al161.j = false;
        try {
            Al161.h.interrupt();
            Al161.h.join();
        }
        catch (InterruptedException ex) {}
    }
    
    static {
        Al161.d = -1;
        Al161.q = null;
        Al161.j = true;
        e = new Q400();
        Al161.h = null;
    }
}
