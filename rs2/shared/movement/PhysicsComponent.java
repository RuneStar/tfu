// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.maths.RotTrans;
import com.jagex.maths.E41;
import com.jagex.maths.Vector3;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Lr302;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.gameentity.Component;

@ScriptEntryClass
public class PhysicsComponent extends Component
{
    public static final int j;
    public RigidBody d;
    private final Q40 g;
    public RigidBody q;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getHeading() {
        return (Lr302.g(this.getEntity().getWorldTransform().rot) + 3.1415927f) % 6.2831855f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return PhysicsComponent.j;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getAabbMaxCorner() {
        if (this.g == null) {
            return null;
        }
        final E41 j = this.g.j();
        if (j == null) {
            return null;
        }
        return j.e();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans entityRotTransToPhysicsSpace(final RotTrans rotTrans) {
        return rotTrans;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeCollisionGeometryFromWorld() {
        if (this.q != null) {
            this.q.b.t(this.q.d);
            this.q.b.m(this.q);
            this.q = null;
        }
        if (this.d != null) {
            this.d.b.t(this.d.d);
            this.d.b.m(this.d);
            this.d = null;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsWorldWrapper getPhysicsWorld() {
        if (this.g == null) {
            return null;
        }
        return this.g.g();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 physicsVectorToEntitySpace(final Vector3 vector3) {
        return vector3;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getCurrentOrBestNavLayer() {
        if (this.g == null) {
            return 0;
        }
        return this.g.d();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void kick(final Vector3 vector3) {
        if (this.g != null) {
            this.g.q(vector3);
        }
    }
    
    public PhysicsComponent(final Q40 g, final RigidBody d, final RigidBody q) {
        this.g = g;
        this.d = d;
        this.q = q;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getFacingLinearVelocity() {
        return Vector3.al(this.g.e(), SceneGraphNode.v(this.getEntity()).rot).ao();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setCollisionGeometryEnabled(final boolean b) {
        if (this.q != null) {
            if (b) {
                RigidBody.y(this.q);
            }
            else {
                RigidBody.p(this.q);
            }
        }
        if (this.d != null) {
            if (b) {
                RigidBody.y(this.d);
            }
            else {
                RigidBody.p(this.d);
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isCollisionGeometryEnabled() {
        if (this.q != null && this.d != null && RigidBody.x(this.q) != RigidBody.x(this.d)) {
            throw new IllegalStateException("PhysicsComponent " + this + " has client master body and interpolated body with values for enabled that are not in sync");
        }
        if (this.q != null) {
            return RigidBody.x(this.q);
        }
        return this.d != null && RigidBody.x(this.d);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans physicsRotTransToEntitySpace(final RotTrans rotTrans) {
        return rotTrans;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getAabbMinCorner() {
        if (this.g == null) {
            return null;
        }
        final E41 j = this.g.j();
        if (j == null) {
            return null;
        }
        return j.j();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getWorldAngularVelocity() {
        return this.g.h();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getFacingAngularVelocity() {
        return Vector3.al(this.g.h(), SceneGraphNode.v(this.getEntity()).rot).ao();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getWorldLinearVelocity() {
        return this.g.e();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 entityVectorToPhysicsSpace(final Vector3 vector3) {
        return vector3;
    }
    
    static {
        j = StringTools.l(PhysicsComponent.class.getName());
    }
}
