/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;

class J367
implements Runnable {
    final /* synthetic */ boolean d;
    final /* synthetic */ SceneGraphNode g;
    final /* synthetic */ Scene j;
    final /* synthetic */ boolean q;

    @Override
    public void run() {
        this.j.remove(this.g, this.d, this.q);
    }

    J367(Scene scene, SceneGraphNode sceneGraphNode, boolean bl, boolean bl2) {
        this.g = sceneGraphNode;
        this.d = bl;
        this.q = bl2;
        this.j = scene;
    }
}

