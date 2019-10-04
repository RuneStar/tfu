/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.AbstractSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;

public class Me312
extends AbstractSet {
    private static final Object g = new Object();
    private IdentityHashMap d = new IdentityHashMap();

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
    public boolean contains(Object object) {
        return this.d.containsKey(object);
    }

    @Override
    public boolean remove(Object object) {
        return this.d.remove(object) != null;
    }

    @Override
    public void clear() {
        this.d.clear();
    }

    @Override
    public boolean add(Object object) {
        return this.d.put(object, g) == null;
    }
}

