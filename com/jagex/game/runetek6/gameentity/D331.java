/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.gameentity;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.J332;

final class D331
extends EventHandler {
    D331() {
    }

    public static void g(D331 d331, GameEntity gameEntity, Object object) {
        if (GameEntity.cw != null) {
            GameEntity.cw.g(gameEntity, (String)object);
        }
    }
}

