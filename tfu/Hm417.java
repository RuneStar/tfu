// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Hm417
{
    final Class d;
    private final int g;
    private final Set q;
    
    @Override
    public int hashCode() {
        return this.g;
    }
    
    Hm417(final Class d, final Object[] elements) {
        this.q = new HashSet();
        this.d = d;
        Collections.addAll(this.q, elements);
        int hashCode = this.d.hashCode();
        for (int length = elements.length, i = 0; i < length; ++i) {
            hashCode ^= elements[i].hashCode();
        }
        this.g = hashCode;
    }
    
    @Override
    public boolean equals(final Object o) {
        final Hm417 hm417 = (Hm417)o;
        return this.d.equals(hm417.d) && this.q.equals(hm417.q);
    }
    
    Hm417(final Class d, final Object o) {
        this.q = new HashSet();
        this.d = d;
        this.q.add(o);
        this.g = (this.d.hashCode() ^ o.hashCode());
    }
}
