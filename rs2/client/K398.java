/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.jnibindings.runetek6.LuaRef;
import rs2.client.Ag389;
import rs2.client.P397;
import rs2.client.worldelement.player;
import tfu.Az399;
import tfu.Gc330;
import tfu.Me312;

final class K398
extends Ag389 {
    LuaRef g;
    final /* synthetic */ Az399 d;

    @Override
    protected void g() {
        GameEntity.em(this.q, new P397(this));
    }

    @Override
    protected void d() {
        player player2 = Gc330.j();
        player2.triggerEvent(this.d.j, this.g);
    }

    @Override
    public String toString() {
        return "script message " + this.d.e + ":" + this.d.h;
    }

    K398(Az399 az399) {
        this.d = az399;
    }
}

