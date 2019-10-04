// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.reflect.Array;
import java.util.Arrays;

class Iq422 implements Br121
{
    private final Object[] d;
    private final Ir421 e;
    private Ao128 g;
    private final int h;
    private final Class j;
    private final Class q;
    private final Mz200 s;
    final /* synthetic */ Hi86 b;
    
    Iq422(final Hi86 b, final Class q, final Class j, final Object[] d, final Ir421 e, final int h, final Mz200 s) {
        this.b = b;
        this.q = q;
        this.j = j;
        this.d = d;
        this.e = e;
        this.h = h;
        this.s = s;
    }
    
    public static void j(final Iq422 iq422, final Hp62 hp62) {
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
        final Hm417 hm417 = new Hm417(this.q, this.d);
        try {
            Hi86.logger.trace("{}:{}-> Asynchronous load+combine...", this.q.getSimpleName(), Arrays.deepToString(this.d));
            final Hp62 j = this.b.e.j(hm417, this.g);
            if (j != null) {
                Hi86.logger.trace("{}:{}-> Cache hit", this.q.getSimpleName(), Arrays.deepToString(this.d));
                return j;
            }
            Hi86.logger.trace("{}:{}-> Cache miss", this.q.getSimpleName(), Arrays.deepToString(this.d));
            final Bn279[] array = new Bn279[this.d.length];
            for (int i = 0; i < this.d.length; ++i) {
                array[i] = this.b.e(this.j, this.d[i], Integer.MAX_VALUE, null, null);
            }
            final Hp62[] array2 = (Hp62[])Array.newInstance(this.j, this.d.length);
            for (int k = 0; k < this.d.length; ++k) {
                array2[k] = (Hp62)array[k].d();
            }
            final Hp62 d = this.e.d(array2, this.b);
            this.b.e.e(hm417, d, this.e);
            Hi86.logger.trace("{}:{}-> Asynchronously loaded+combined", this.q.getSimpleName(), Arrays.deepToString(this.d));
            return d;
        }
        catch (Throwable cause) {
            this.b.e.h(hm417, cause);
            if (cause instanceof Exception) {
                throw (Exception)cause;
            }
            if (cause instanceof Error) {
                throw (Error)cause;
            }
            throw new RuntimeException(cause);
        }
    }
}
