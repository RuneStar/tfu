// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;

final class Jw531 implements Iterable
{
    final /* synthetic */ Iterator d;
    final /* synthetic */ Iterator g;
    
    Jw531(final Iterator g, final Iterator d) {
        this.d = d;
        this.g = g;
    }
    
    @Override
    public Iterator iterator() {
        return new Je530(this);
    }
}
