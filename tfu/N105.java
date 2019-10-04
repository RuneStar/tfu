/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.jnibindings.runetek6.Mesh;
import java.util.UUID;
import tfu.Aq544;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ig436;
import tfu.Kc180;
import tfu.S671;

public class N105
implements Hp62,
S671 {
    public final boolean d;
    private Aq544[] e;
    public final Hi86 g;
    public int h;
    private long j;
    public final long[] q;
    public int[] s;

    public static void e(N105 n105, int n, int n2) {
        n105.s[n] = n2;
    }

    public static void h(N105 n105, int n, Aq544 aq544) {
        n105.e[n] = aq544;
    }

    public static void s(N105 n105, UUID uUID) {
        n105.h = uUID.hashCode();
    }

    @Override
    public void g() {
        if (this.j == 0L) {
            return;
        }
        for (int i = 0; i < this.e.length; ++i) {
            Aq544 aq544 = this.e[i];
            this.q[i] = Mesh.create(aq544.g, aq544.d, aq544.j.getId());
        }
        Kc180.d(this.j);
        this.j = 0L;
    }

    public static long j(N105 n105) {
        return n105.j;
    }

    @Override
    public void onAllRefsReleased() {
        if (this.j != 0L) {
            Kc180.d(this.j);
            this.j = 0L;
        }
        for (int i = 0; i < this.q.length; ++i) {
            if (this.q[i] == 0L) continue;
            Mesh.destroy(this.q[i]);
            this.q[i] = 0L;
        }
    }

    public N105(Hi86 hi86, int n, boolean bl, int n2) {
        this.g = hi86;
        this.q = new long[n];
        this.d = bl;
        this.e = new Aq544[n];
        this.s = new int[n];
        this.j = Kc180.g(n2);
    }
}

