// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.maths.Vector3;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import java.util.ArrayList;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass
public class PhysicsQueryResultList
{
    public final ArrayList d;
    public final DiscreteDynamicsWorld g;
    
    public PhysicsQueryResultList(final DiscreteDynamicsWorld g, final ArrayList d) {
        this.g = g;
        this.d = d;
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
    public CollisionObjectData getCollisionObject(final int index) {
        return (CollisionObjectData)this.g.ap(this.d.get(index).g);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getContactNormal(final int index) {
        return this.d.get(index).q;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getContactPoint(final int index) {
        return this.d.get(index).d;
    }
}
