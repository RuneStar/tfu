/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.reflect.Array;
import java.util.Arrays;
import tfu.Ao128;
import tfu.Bn279;
import tfu.Br121;
import tfu.Bv351;
import tfu.Hi86;
import tfu.Hm417;
import tfu.Hp62;
import tfu.Hz419;
import tfu.In418;
import tfu.Ir421;
import tfu.Mz200;

class Iq422
implements Br121 {
    private final Object[] d;
    private final Ir421 e;
    private Ao128 g;
    private final int h;
    private final Class j;
    private final Class q;
    private final Mz200 s;
    final /* synthetic */ Hi86 b;

    Iq422(Hi86 hi86, Class class_, Class class_2, Object[] arrobject, Ir421 ir421, int n, Mz200 mz200) {
        this.b = hi86;
        this.q = class_;
        this.j = class_2;
        this.d = arrobject;
        this.e = ir421;
        this.h = n;
        this.s = mz200;
    }

    public static void j(Iq422 iq422, Hp62 hp62) {
        if (hp62 != null && iq422.e.resourceNeedsRefCounting()) {
            Hi86.l(iq422.b, hp62);
        }
    }

    @Override
    public int e() {
        if (this.s != null) {
            return this.s.g();
        }
        return this.h;
    }

    @Override
    public boolean d() {
        return true;
    }

    @Override
    public boolean q() {
        return this.e.resourceNeedsRefCounting();
    }

    public Hp62 g() throws Exception {
        Hm417 hm417 = new Hm417(this.q, this.d);
        try {
            Hi86.z().trace("{}:{}-> Asynchronous load+combine...", (Object)this.q.getSimpleName(), (Object)Arrays.deepToString(this.d));
            Hp62 hp62 = this.b.e.j(hm417, this.g);
            if (hp62 != null) {
                Hi86.z().trace("{}:{}-> Cache hit", (Object)this.q.getSimpleName(), (Object)Arrays.deepToString(this.d));
                return hp62;
            }
            Hi86.z().trace("{}:{}-> Cache miss", (Object)this.q.getSimpleName(), (Object)Arrays.deepToString(this.d));
            Bn279[] arrbn279 = new Bn279[this.d.length];
            for (int i = 0; i < this.d.length; ++i) {
                arrbn279[i] = this.b.e(this.j, this.d[i], Integer.MAX_VALUE, null, null);
            }
            Hp62[] arrhp62 = (Hp62[])Array.newInstance(this.j, this.d.length);
            for (int i = 0; i < this.d.length; ++i) {
                arrhp62[i] = (Hp62)arrbn279[i].d();
            }
            hp62 = this.e.d(arrhp62, this.b);
            this.b.e.e(hm417, hp62, this.e);
            Hi86.z().trace("{}:{}-> Asynchronously loaded+combined", (Object)this.q.getSimpleName(), (Object)Arrays.deepToString(this.d));
            return hp62;
        }
        catch (Throwable throwable) {
            this.b.e.h(hm417, throwable);
            if (throwable instanceof Exception) {
                throw (Exception)throwable;
            }
            if (throwable instanceof Error) {
                throw (Error)throwable;
            }
            throw new RuntimeException(throwable);
        }
    }
}

