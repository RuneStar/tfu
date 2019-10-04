// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.scenegraph;

import java.lang.reflect.Array;
import java.util.Iterator;
import com.jagex.game.runetek6.gameentity.Component;
import java.util.Collection;

class S368 implements Collection
{
    final /* synthetic */ Scene d;
    final /* synthetic */ Component[] g;
    
    @Override
    public Iterator iterator() {
        return new B478(this);
    }
    
    @Override
    public int size() {
        return this.g.length;
    }
    
    @Override
    public boolean isEmpty() {
        return this.g.length == 0;
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Object[] toArray(Object[] array) {
        if (array.length < this.g.length) {
            array = (Object[])Array.newInstance(array.getClass().getComponentType(), this.g.length);
        }
        System.arraycopy(this.g, 0, array, 0, this.g.length);
        if (array.length > this.g.length) {
            array[this.g.length] = null;
        }
        return array;
    }
    
    @Override
    public boolean add(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    S368(final Scene d, final Component[] g) {
        this.g = g;
        this.d = d;
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean contains(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Object[] toArray() {
        return this.g.clone();
    }
}
