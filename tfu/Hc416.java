/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Ao128;
import tfu.Br121;
import tfu.Hi86;
import tfu.Hm417;
import tfu.Hp62;
import tfu.Hz419;
import tfu.Ia63;
import tfu.Ib29;
import tfu.In418;
import tfu.Mz200;

class Hc416
implements Br121 {
    private final Object d;
    private final Mz200 e;
    private Ao128 g;
    private final int j;
    private final Class q;
    final /* synthetic */ Hi86 h;

    @Override
    public boolean q() {
        Ia63 ia63 = Hi86.x(this.h, this.q);
        return ia63.resourceNeedsRefCounting();
    }

    public Hp62 g() throws Exception {
        Hi86.z().trace("{}:{} -> Asynchronous loading...", (Object)this.q.getSimpleName(), this.d);
        Hm417 hm417 = new Hm417(this.q, this.d);
        try {
            Hp62 hp62 = this.h.e.j(hm417, this.g);
            if (hp62 != null) {
                Hi86.z().trace("{}:{} -> Cache hit", (Object)this.q.getSimpleName(), this.d);
                return hp62;
            }
            Hi86.z().trace("{}:{} -> Cache miss", (Object)this.q.getSimpleName(), this.d);
            Ib29 ib29 = Hi86.y(this.h, this.q);
            Ia63 ia63 = Hi86.x(this.h, this.q);
            byte[] arrby = ib29.getData(this.d);
            hp62 = ia63.constructResource(arrby, this.d, this.h);
            this.h.e.e(hm417, hp62, ia63);
            Hi86.z().trace("{}:{} -> Asynchronously loaded", (Object)this.q.getSimpleName(), this.d);
            return hp62;
        }
        catch (Throwable throwable) {
            this.h.e.h(hm417, throwable);
            Object v = Hi86.t(this.h).get(this.q);
            if (v == null || v.equals(this.d)) {
                if (throwable instanceof Exception) {
                    throw (Exception)throwable;
                }
                if (throwable instanceof Error) {
                    throw (Error)throwable;
                }
                throw new RuntimeException(throwable);
            }
            return this.h.j(this.q, v);
        }
    }

    @Override
    public boolean d() {
        return true;
    }

    public static void j(Hc416 hc416, Hp62 hp62) {
        Ia63 ia63;
        if (hp62 != null && (ia63 = Hi86.x(hc416.h, hc416.q)).resourceNeedsRefCounting()) {
            Hi86.l(hc416.h, hp62);
        }
    }

    Hc416(Hi86 hi86, Class class_, Object object, int n, Mz200 mz200) {
        this.h = hi86;
        this.q = class_;
        this.d = object;
        this.j = n;
        this.e = mz200;
    }

    @Override
    public int e() {
        if (this.e != null) {
            return this.e.g();
        }
        return this.j;
    }
}

