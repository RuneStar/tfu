// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("CollisionObject")
public class CollisionObjectData
{
    public GameEntity d;
    public final S15 g;
    public PlayerPhysicsAvatar q;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getType() {
        return this.g.h;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity getEntity() {
        return this.d;
    }
    
    public CollisionObjectData(final S15 g) {
        this.d = null;
        this.q = null;
        this.g = g;
    }
}
