// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.scenegraph;

import java.util.Iterator;

class G484 implements Iterator
{
    private SceneGraphNode d;
    private SceneGraphNode g;
    final /* synthetic */ Q255 q;
    
    @Override
    public boolean hasNext() {
        return this.d != null;
    }
    
    public static SceneGraphNode g(final G484 g484) {
        g484.g = g484.d;
        g484.d = g484.d.b;
        return g484.g;
    }
    
    @Override
    public void remove() {
        this.g.ag(null, null);
        final Scene scene = this.g.getScene();
        if (scene != null) {
            Scene.w(scene, this.g);
        }
        this.g = null;
    }
    
    G484(final Q255 q) {
        this.q = q;
        this.d = this.q.g.s;
    }
}
