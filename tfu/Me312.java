// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;
import java.util.IdentityHashMap;
import java.util.AbstractSet;

public class Me312 extends AbstractSet
{
    private static final Object g;
    private IdentityHashMap d;
    
    @Override
    public Iterator iterator() {
        return this.d.keySet().iterator();
    }
    
    @Override
    public int size() {
        return this.d.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.d.isEmpty();
    }
    
    @Override
    public boolean contains(final Object key) {
        return this.d.containsKey(key);
    }
    
    @Override
    public boolean remove(final Object key) {
        return this.d.remove(key) != null;
    }
    
    static {
        g = new Object();
    }
    
    @Override
    public void clear() {
        this.d.clear();
    }
    
    public Me312() {
        this.d = new IdentityHashMap();
    }
    
    @Override
    public boolean add(final Object key) {
        return this.d.put(key, Me312.g) == null;
    }
}
