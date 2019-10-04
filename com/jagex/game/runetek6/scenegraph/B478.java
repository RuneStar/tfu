// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.Component;
import java.util.NoSuchElementException;
import java.util.Iterator;

class B478 implements Iterator
{
    private int g;
    final /* synthetic */ S368 d;
    
    @Override
    public Object next() {
        final Component g = g(this);
        if (g == null) {
            throw new NoSuchElementException();
        }
        ++this.g;
        return g;
    }
    
    @Override
    public boolean hasNext() {
        return g(this) != null;
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    private static Component g(final B478 b478) {
        while (b478.g < b478.d.g.length) {
            final Component component = b478.d.g[b478.g];
            if (component != null) {
                final GameEntity entity = component.getEntity();
                if (entity != null && entity.getScene() == b478.d.d) {
                    return component;
                }
            }
            ++b478.g;
        }
        return null;
    }
    
    B478(final S368 d) {
        this.d = d;
        this.g = 0;
    }
}
