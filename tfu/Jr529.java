// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;

final class Jr529 implements Iterable
{
    final /* synthetic */ Iterator d;
    final /* synthetic */ Iterator g;
    
    @Override
    public Iterator iterator() {
        return new Jc528(this);
    }
    
    Jr529(final Iterator g, final Iterator d) {
        this.d = d;
        this.g = g;
    }
}
