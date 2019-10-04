// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.scenegraph;

import java.util.Iterator;

class Q255 implements Iterable
{
    final /* synthetic */ SceneGraphNode g;
    
    Q255(final SceneGraphNode g) {
        this.g = g;
    }
    
    @Override
    public Iterator iterator() {
        return new G484(this);
    }
}
