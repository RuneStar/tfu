/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import rs2.shared.movement.CollisionObjectData;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class PhysicsQueryResultList {
    public final ArrayList d;
    public final DiscreteDynamicsWorld g;

    public PhysicsQueryResultList(DiscreteDynamicsWorld discreteDynamicsWorld, ArrayList arrayList) {
        this.g = discreteDynamicsWorld;
        this.d = arrayList;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getResultCount() {
        return this.d.size();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public CollisionObjectData getCollisionObject(int n) {
        return (CollisionObjectData)this.g.ap(((L8)this.d.get((int)n)).g);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getContactNormal(int n) {
        return ((L8)this.d.get((int)n)).q;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getContactPoint(int n) {
        return ((L8)this.d.get((int)n)).d;
    }
}

