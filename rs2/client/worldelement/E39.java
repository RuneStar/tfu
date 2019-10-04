/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.worldelement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.E41;
import com.jagex.maths.Vector3;
import rs2.client.client;
import rs2.client.worldelement.player;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.movement.Q40;
import tfu.Ll42;

class E39
implements Q40 {
    final /* synthetic */ player g;

    @Override
    public Vector3 h() {
        return ((PlayerPhysicsComponent)player.eb((GameEntity)this.g, PlayerPhysicsComponent.class)).h;
    }

    @Override
    public int d() {
        throw new IllegalStateException("This is a server-only command!");
    }

    @Override
    public E41 j() {
        return PlayerPhysicsComponent.b((PlayerPhysicsComponent)player.eb(this.g, PlayerPhysicsComponent.class));
    }

    @Override
    public PhysicsWorldWrapper g() {
        return client.gz.d;
    }

    @Override
    public void q(Vector3 vector3) {
        throw new IllegalStateException("This is a server-only command at present!");
    }

    E39(player player2) {
        this.g = player2;
    }

    @Override
    public Vector3 e() {
        return ((PlayerPhysicsComponent)player.eb((GameEntity)this.g, PlayerPhysicsComponent.class)).e;
    }
}

