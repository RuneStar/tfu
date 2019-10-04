// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.concurrent.Future;

final class K547 implements Ir421
{
    @Override
    public boolean resourceNeedsRefCounting() {
        return true;
    }
    
    public N105 g(final Fk353[] array, final Hi86 hi86) throws Hh420 {
        final Future d = B665.g().d(Ai354.d(array, hi86));
        try {
            return d.get();
        }
        catch (Exception ex) {
            throw new Hh420(ex);
        }
    }
}
