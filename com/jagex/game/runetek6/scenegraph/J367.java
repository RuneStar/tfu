// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.scenegraph;

class J367 implements Runnable
{
    final /* synthetic */ boolean d;
    final /* synthetic */ SceneGraphNode g;
    final /* synthetic */ Scene j;
    final /* synthetic */ boolean q;
    
    @Override
    public void run() {
        this.j.remove(this.g, this.d, this.q);
    }
    
    J367(final Scene j, final SceneGraphNode g, final boolean d, final boolean q) {
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
    }
}
