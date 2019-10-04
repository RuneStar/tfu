// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.maths.Vector3;
import rs2.client.client;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lk495
{
    private static Lk495 j;
    private List d;
    private boolean e;
    private List g;
    private List q;
    
    public static void q(final Lk495 lk495) {
        if (h(lk495)) {
            final Iterator<Lu496> iterator = lk495.g.iterator();
            while (iterator.hasNext()) {
                Lu496.d(iterator.next());
            }
            final Iterator<Lu496> iterator2 = lk495.q.iterator();
            while (iterator2.hasNext()) {
                Lu496.d(iterator2.next());
            }
        }
    }
    
    public static Lk495 g() {
        if (Lk495.j == null) {
            Lk495.j = new Lk495();
        }
        return Lk495.j;
    }
    
    private Lk495() {
        this.g = new ArrayList();
        this.d = new ArrayList();
        this.q = new ArrayList();
    }
    
    public void e(final Gs329 gs329) {
        this.g.clear();
        for (int au = Gg3.au(gs329), i = 0; i < au; ++i) {
            final int au2 = Gg3.au(gs329);
            final Lu496 lu496 = new Lu496();
            this.g.add(lu496);
            for (int j = 0; j < au2; ++j) {
                Lu496.g(lu496).add(new Vector3((float)(Gg3.bd(gs329) - client.gn), Gg3.bl(gs329), (float)(Gg3.bd(gs329) - client.gj)));
            }
        }
    }
    
    public static void d(final int n, final int n2) {
        Lu496.b(n, n2);
    }
    
    public void j(final Gs329 gs329) {
        this.q.clear();
        final Lu496 lu496 = new Lu496();
        Lu496.s(lu496, false);
        Lu496.e(lu496, -16776961);
        this.q.add(lu496);
        for (int au = Gg3.au(gs329), i = 0; i < au; ++i) {
            Lu496.g(lu496).add(new Vector3((float)(Gg3.bd(gs329) - client.gn), Gg3.bl(gs329), (float)(Gg3.bd(gs329) - client.gj)));
        }
    }
    
    public static boolean h(final Lk495 lk495) {
        return lk495.e;
    }
}
