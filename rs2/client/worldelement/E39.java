// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.worldelement;

import rs2.client.client;
import rs2.shared.movement.PhysicsWorldWrapper;
import com.jagex.maths.E41;
import com.jagex.game.runetek6.gameentity.GameEntity;
import rs2.shared.movement.PlayerPhysicsComponent;
import com.jagex.maths.Vector3;
import rs2.shared.movement.Q40;

class E39 implements Q40
{
    final /* synthetic */ player g;
    
    @Override
    public Vector3 h() {
        return ((PlayerPhysicsComponent)GameEntity.eb(this.g, PlayerPhysicsComponent.class)).h;
    }
    
    @Override
    public int d() {
        throw new IllegalStateException("This is a server-only command!");
    }
    
    @Override
    public E41 j() {
        return PlayerPhysicsComponent.b((PlayerPhysicsComponent)GameEntity.eb(this.g, PlayerPhysicsComponent.class));
    }
    
    @Override
    public PhysicsWorldWrapper g() {
        return client.gz.d;
    }
    
    @Override
    public void q(final Vector3 vector3) {
        throw new IllegalStateException("This is a server-only command at present!");
    }
    
    E39(final player g) {
        this.g = g;
    }
    
    @Override
    public Vector3 e() {
        return ((PlayerPhysicsComponent)GameEntity.eb(this.g, PlayerPhysicsComponent.class)).e;
    }
}
