// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.jnibindings.runetek6.Mesh;
import java.util.UUID;

public class N105 implements Hp62, S671
{
    public final boolean d;
    private Aq544[] e;
    public final Hi86 g;
    public int h;
    private long j;
    public final long[] q;
    public int[] s;
    
    public static void e(final N105 n105, final int n106, final int n107) {
        n105.s[n106] = n107;
    }
    
    public static void h(final N105 n105, final int n106, final Aq544 aq544) {
        n105.e[n106] = aq544;
    }
    
    public static void s(final N105 n105, final UUID uuid) {
        n105.h = uuid.hashCode();
    }
    
    @Override
    public void g() {
        if (this.j == 0L) {
            return;
        }
        for (int i = 0; i < this.e.length; ++i) {
            final Aq544 aq544 = this.e[i];
            this.q[i] = Mesh.create(aq544.g, aq544.d, aq544.j.getId());
        }
        Kc180.d(this.j);
        this.j = 0L;
    }
    
    public static long j(final N105 n105) {
        return n105.j;
    }
    
    @Override
    public void onAllRefsReleased() {
        if (this.j != 0L) {
            Kc180.d(this.j);
            this.j = 0L;
        }
        for (int i = 0; i < this.q.length; ++i) {
            if (this.q[i] != 0L) {
                Mesh.destroy(this.q[i]);
                this.q[i] = 0L;
            }
        }
    }
    
    public N105(final Hi86 g, final int n, final boolean d, final int n2) {
        this.g = g;
        this.q = new long[n];
        this.d = d;
        this.e = new Aq544[n];
        this.s = new int[n];
        this.j = Kc180.g(n2);
    }
}
