/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import rs2.shared.movement.PlayerPhysicsAvatar;
import rs2.shared.movement.S15;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="CollisionObject")
public class CollisionObjectData {
    public GameEntity d = null;
    public final S15 g;
    public PlayerPhysicsAvatar q = null;

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

    public CollisionObjectData(S15 s15) {
        this.g = s15;
    }
}

