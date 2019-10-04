// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class Ma57 implements Mn54
{
    protected final Kf58 d;
    protected Map g;
    
    @Override
    public int d(final int i) {
        if (this.g != null) {
            final Kr260 kr260 = this.g.get(i);
            if (kr260 != null) {
                return (int)kr260.d;
            }
        }
        return (int)this.d.getDefaultValue(i);
    }
    
    @Override
    public void q(final int i, final int j) {
        if (this.g == null) {
            (this.g = new HashMap()).put(i, new Kr260(i, j));
        }
        else {
            final Kr260 kr260 = this.g.get(i);
            if (kr260 == null) {
                this.g.put(i, new Kr260(i, j));
            }
            else {
                kr260.d = j;
            }
        }
    }
    
    @Override
    public long j(final int i) {
        if (this.g != null) {
            final Kr260 kr260 = this.g.get(i);
            if (kr260 != null) {
                return (long)kr260.d;
            }
        }
        return (long)this.d.getDefaultValue(i);
    }
    
    @Override
    public void b() {
        if (this.g != null) {
            this.g.clear();
        }
    }
    
    @Override
    public Object h(final int i) {
        if (this.g != null) {
            final Kr260 kr260 = this.g.get(i);
            if (kr260 != null) {
                return kr260.d;
            }
        }
        return this.d.getDefaultValue(i);
    }
    
    @Override
    public void s(final int i, final Object d) {
        if (this.g == null) {
            (this.g = new HashMap()).put(i, new Kr260(i, d));
        }
        else {
            final Kr260 kr260 = this.g.get(i);
            if (kr260 == null) {
                this.g.put(i, new Kr260(i, d));
            }
            else {
                kr260.d = d;
            }
        }
    }
    
    public Ma57(final Kf58 d) {
        this.d = d;
    }
    
    @Override
    public void l(final int i) {
        if (this.g != null) {
            this.g.remove(i);
        }
    }
    
    @Override
    public Iterator iterator() {
        if (this.g == null) {
            return Collections.emptyList().iterator();
        }
        return this.g.values().iterator();
    }
    
    @Override
    public void e(final int i, final long l) {
        if (this.g == null) {
            (this.g = new HashMap()).put(i, new Kr260(i, l));
        }
        else {
            final Kr260 kr260 = this.g.get(i);
            if (kr260 == null) {
                this.g.put(i, new Kr260(i, l));
            }
            else {
                kr260.d = l;
            }
        }
    }
}
