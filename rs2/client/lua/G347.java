/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.Q344;
import java.util.List;
import rs2.client.lua.ClientScriptAPI;

final class G347
implements Q344 {
    @Override
    public void g(GameEntity gameEntity) {
        ClientScriptAPI.g.remove(gameEntity);
    }

    G347() {
    }
}

