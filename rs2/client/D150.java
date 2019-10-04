/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.js5.js5;
import rs2.client.client;
import tfu.Ab158;
import tfu.Aw157;
import tfu.F342;
import tfu.Kj334;

public class D150 {
    public static F342 b;
    public static int d;
    public static Kj334 e;
    public static int g;
    public static Kj334 h;
    public static Kj334 j;
    public static F342 l;
    public static int q;
    public static F342 s;

    public static int[] d() {
        return new int[]{g, d, q};
    }

    public static void q() {
        s = (F342)Aw157.e(client.eq, client.ew, g, true, true);
        j = Aw157.h(client.eq, client.ew, g);
        b = (F342)Aw157.e(client.eq, client.ew, d, true, true);
        e = Aw157.h(client.eq, client.ew, d);
        l = (F342)Aw157.e(client.eq, client.ew, q, true, true);
        h = Aw157.h(client.eq, client.ew, q);
    }

    public static void g(js5 js52) {
        g = js52.getgroupid("p11_full");
        d = js52.getgroupid("p12_full");
        q = js52.getgroupid("b12_full");
    }
}

