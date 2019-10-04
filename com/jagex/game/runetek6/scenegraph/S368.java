/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.scenegraph.B478;
import com.jagex.game.runetek6.scenegraph.Scene;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

class S368
implements Collection {
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

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray(Object[] arrobject) {
        if (arrobject.length < this.g.length) {
            arrobject = (Object[])Array.newInstance(arrobject.getClass().getComponentType(), this.g.length);
        }
        System.arraycopy(this.g, 0, arrobject, 0, this.g.length);
        if (arrobject.length > this.g.length) {
            arrobject[this.g.length] = null;
        }
        return arrobject;
    }

    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    S368(Scene scene, Component[] arrcomponent) {
        this.g = arrcomponent;
        this.d = scene;
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return (Object[])this.g.clone();
    }
}

