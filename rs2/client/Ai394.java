/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.comms.broadcast.SceneryConfig;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.xelement.G104;
import org.slf4j.Logger;
import rs2.client.H393;
import rs2.client.Z392;
import rs2.client.client;
import rs2.shared.movement.Q40;
import tfu.Bb4;
import tfu.Ll42;

class Ai394
implements H393 {
    final /* synthetic */ Z392 d;
    final /* synthetic */ G104 g;

    @Override
    public void d() {
        G104.v(this.g);
    }

    Ai394(Z392 z392, G104 g104) {
        this.g = g104;
        this.d = z392;
    }

    @Override
    public void g() {
        try {
            GameEntity gameEntity = this.g.j();
            if (gameEntity == null) {
                return;
            }
            Ll42.q(client.gz, gameEntity);
            client.gz.d(gameEntity, client.gn, client.gj, client.ds, this.d.g.collisionMask);
            client.logger.trace("Done adding " + gameEntity.bg);
            this.d.j.run();
            gameEntity.setProperty("spawnyMcSpawnins_AsynchronousTask", null);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

