/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.gameentity.components;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.Q344;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import java.util.Set;

class D387
implements Q344 {
    final /* synthetic */ MappedEventComponent g;

    @Override
    public void g(GameEntity gameEntity) {
        if (this.g.q != null) {
            this.g.q.remove(gameEntity);
        }
        if (this.g.j != null) {
            this.g.j.remove(gameEntity);
        }
        MappedEventComponent.s(this.g, gameEntity);
    }

    D387(MappedEventComponent mappedEventComponent) {
        this.g = mappedEventComponent;
    }
}

