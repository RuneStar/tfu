/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.scenegraph.G484;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import java.util.Iterator;

class Q255
implements Iterable {
    final /* synthetic */ SceneGraphNode g;

    Q255(SceneGraphNode sceneGraphNode) {
        this.g = sceneGraphNode;
    }

    public Iterator iterator() {
        return new G484(this);
    }
}

