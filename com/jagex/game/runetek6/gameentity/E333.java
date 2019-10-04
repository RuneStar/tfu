// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.gameentity;

import com.jagex.game.runetek6.event.EventHandler;

class E333 extends EventHandler
{
    final /* synthetic */ GameEntity g;
    
    E333(final GameEntity g) {
        this.g = g;
    }
    
    public static void g(final E333 e333, final GameEntity gameEntity, final Object o) {
        e333.g.bz.runScriptEvent("footPlacedDecalEvent", gameEntity, o);
    }
}
