// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Hc416 implements Br121
{
    private final Object d;
    private final Mz200 e;
    private Ao128 g;
    private final int j;
    private final Class q;
    final /* synthetic */ Hi86 h;
    
    @Override
    public boolean q() {
        return Hi86.x(this.h, this.q).resourceNeedsRefCounting();
    }
    
    public Hp62 g() throws Exception {
        Hi86.logger.trace("{}:{} -> Asynchronous loading...", this.q.getSimpleName(), this.d);
        final Hm417 hm417 = new Hm417(this.q, this.d);
        try {
            final Hp62 j = this.h.e.j(hm417, this.g);
            if (j != null) {
                Hi86.logger.trace("{}:{} -> Cache hit", this.q.getSimpleName(), this.d);
                return j;
            }
            Hi86.logger.trace("{}:{} -> Cache miss", this.q.getSimpleName(), this.d);
            final Ib29 y = Hi86.y(this.h, this.q);
            final Ia63 x = Hi86.x(this.h, this.q);
            final Hp62 constructResource = x.constructResource(y.getData(this.d), this.d, this.h);
            this.h.e.e(hm417, constructResource, x);
            Hi86.logger.trace("{}:{} -> Asynchronously loaded", this.q.getSimpleName(), this.d);
            return constructResource;
        }
        catch (Throwable cause) {
            this.h.e.h(hm417, cause);
            final Object value = this.h.g.get(this.q);
            if (value != null && !value.equals(this.d)) {
                return this.h.j(this.q, value);
            }
            if (cause instanceof Exception) {
                throw (Exception)cause;
            }
            if (cause instanceof Error) {
                throw (Error)cause;
            }
            throw new RuntimeException(cause);
        }
    }
    
    @Override
    public boolean d() {
        return true;
    }
    
    public static void j(final Hc416 hc416, final Hp62 hp62) {
        if (hp62 != null && Hi86.x(hc416.h, hc416.q).resourceNeedsRefCounting()) {
            Hi86.l(hc416.h, hp62);
        }
    }
    
    Hc416(final Hi86 h, final Class q, final Object d, final int j, final Mz200 e) {
        this.h = h;
        this.q = q;
        this.d = d;
        this.j = j;
        this.e = e;
    }
    
    @Override
    public int e() {
        if (this.e != null) {
            return this.e.g();
        }
        return this.j;
    }
}
