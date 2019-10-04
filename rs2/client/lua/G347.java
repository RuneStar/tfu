// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.Q344;

final class G347 implements Q344
{
    @Override
    public void g(final GameEntity gameEntity) {
        ClientScriptAPI.g.remove(gameEntity);
    }
}
