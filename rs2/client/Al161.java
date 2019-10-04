/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import java.net.InetAddress;
import rs2.client.Q400;

public class Al161 {
    public static int d = -1;
    private static final Runnable e;
    public static final int g = 1000;
    private static Thread h;
    private static boolean j;
    private static InetAddress q;

    public static void g() {
        h = new Thread(e);
        h.start();
    }

    public static void d(InetAddress inetAddress) {
        Runnable runnable = e;
        synchronized (runnable) {
            q = inetAddress;
            d = -1;
        }
    }

    public static void q() {
        j = false;
        try {
            h.interrupt();
            h.join();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    static /* synthetic */ boolean j() {
        return j;
    }

    static /* synthetic */ InetAddress e() {
        return q;
    }

    static {
        q = null;
        j = true;
        e = new Q400();
        h = null;
    }
}

