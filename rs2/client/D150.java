// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.js5.js5;
import tfu.Aw157;
import tfu.Kj334;
import tfu.F342;

public class D150
{
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
        return new int[] { D150.g, D150.d, D150.q };
    }
    
    public static void q() {
        D150.s = (F342)Aw157.e(client.eq, client.ew, D150.g, true, true);
        D150.j = Aw157.h(client.eq, client.ew, D150.g);
        D150.b = (F342)Aw157.e(client.eq, client.ew, D150.d, true, true);
        D150.e = Aw157.h(client.eq, client.ew, D150.d);
        D150.l = (F342)Aw157.e(client.eq, client.ew, D150.q, true, true);
        D150.h = Aw157.h(client.eq, client.ew, D150.q);
    }
    
    public static void g(final js5 js5) {
        D150.g = js5.getgroupid("p11_full");
        D150.d = js5.getgroupid("p12_full");
        D150.q = js5.getgroupid("b12_full");
    }
}
