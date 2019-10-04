/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.gameentity;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptManager;

class E333
extends EventHandler {
    final /* synthetic */ GameEntity g;

    E333(GameEntity gameEntity) {
        this.g = gameEntity;
    }

    public static void g(E333 e333, GameEntity gameEntity, Object object) {
        e333.g.bz.runScriptEvent("footPlacedDecalEvent", gameEntity, object);
    }
}

