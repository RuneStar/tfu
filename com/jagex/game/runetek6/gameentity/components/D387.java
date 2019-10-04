// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.gameentity.components;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.Q344;

class D387 implements Q344
{
    final /* synthetic */ MappedEventComponent g;
    
    @Override
    public void g(final GameEntity gameEntity) {
        if (this.g.q != null) {
            this.g.q.remove(gameEntity);
        }
        if (this.g.j != null) {
            this.g.j.remove(gameEntity);
        }
        MappedEventComponent.s(this.g, gameEntity);
    }
    
    D387(final MappedEventComponent g) {
        this.g = g;
    }
}
