/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.S368;
import com.jagex.game.runetek6.scenegraph.Scene;
import java.util.Iterator;
import java.util.NoSuchElementException;

class B478
implements Iterator {
    private int g = 0;
    final /* synthetic */ S368 d;

    public Object next() {
        Component component = B478.g(this);
        if (component == null) {
            throw new NoSuchElementException();
        }
        ++this.g;
        return component;
    }

    @Override
    public boolean hasNext() {
        return B478.g(this) != null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private static Component g(B478 b478) {
        while (b478.g < b478.d.g.length) {
            GameEntity gameEntity;
            Component component = b478.d.g[b478.g];
            if (component != null && (gameEntity = component.getEntity()) != null && gameEntity.getScene() == b478.d.d) {
                return component;
            }
            ++b478.g;
        }
        return null;
    }

    B478(S368 s368) {
        this.d = s368;
    }
}

