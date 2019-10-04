/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.scenegraph.Q255;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.util.Iterator;

class G484
implements Iterator {
    private SceneGraphNode d;
    private SceneGraphNode g;
    final /* synthetic */ Q255 q;

    @Override
    public boolean hasNext() {
        return this.d != null;
    }

    public static SceneGraphNode g(G484 g484) {
        g484.g = g484.d;
        g484.d = g484.d.b;
        return g484.g;
    }

    @Override
    public void remove() {
        this.g.ag(null, null);
        Scene scene = this.g.getScene();
        if (scene != null) {
            Scene.w(scene, this.g);
        }
        this.g = null;
    }

    G484(Q255 q255) {
        this.q = q255;
        this.d = this.q.g.s;
    }
}

