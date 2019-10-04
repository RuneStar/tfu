// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Mz200;

class Ad199 implements Mz200
{
    final /* synthetic */ XElementLibrary d;
    final /* synthetic */ GameEntity g;
    
    @Override
    public int g() {
        return this.d.h.g(this.g.getWorldTransform().trans);
    }
    
    Ad199(final XElementLibrary d, final GameEntity g) {
        this.g = g;
        this.d = d;
    }
}
