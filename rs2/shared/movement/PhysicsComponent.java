/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.E41;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.Q40;
import tfu.Be2;
import tfu.Bs1;
import tfu.Lr302;

@ScriptEntryClass
public class PhysicsComponent
extends Component {
    public static final int j = StringTools.l(PhysicsComponent.class.getName());
    public RigidBody d;
    private final Q40 g;
    public RigidBody q;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getHeading() {
        Quaternion quaternion = this.getEntity().getWorldTransform().rot;
        return (Lr302.g(quaternion) + 3.1415927f) % 6.2831855f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return j;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getAabbMaxCorner() {
        if (this.g == null) {
            return null;
        }
        E41 e41 = this.g.j();
        if (e41 == null) {
            return null;
        }
        return e41.e();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans entityRotTransToPhysicsSpace(RotTrans rotTrans) {
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
    public Vector3 physicsVectorToEntitySpace(Vector3 vector3) {
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
    public void kick(Vector3 vector3) {
        if (this.g != null) {
            this.g.q(vector3);
        }
    }

    public PhysicsComponent(Q40 q40, RigidBody rigidBody, RigidBody rigidBody2) {
        this.g = q40;
        this.d = rigidBody;
        this.q = rigidBody2;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getFacingLinearVelocity() {
        Vector3 vector3 = this.g.e();
        ScaleRotTrans scaleRotTrans = GameEntity.v(this.getEntity());
        vector3 = Vector3.al(vector3, scaleRotTrans.rot);
        vector3 = vector3.ao();
        return vector3;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setCollisionGeometryEnabled(boolean bl) {
        if (this.q != null) {
            if (bl) {
                RigidBody.y(this.q);
            } else {
                RigidBody.p(this.q);
            }
        }
        if (this.d != null) {
            if (bl) {
                RigidBody.y(this.d);
            } else {
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
        if (this.d != null) {
            return RigidBody.x(this.d);
        }
        return false;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans physicsRotTransToEntitySpace(RotTrans rotTrans) {
        return rotTrans;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getAabbMinCorner() {
        if (this.g == null) {
            return null;
        }
        E41 e41 = this.g.j();
        if (e41 == null) {
            return null;
        }
        return e41.j();
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
        Vector3 vector3 = this.g.h();
        ScaleRotTrans scaleRotTrans = GameEntity.v(this.getEntity());
        vector3 = Vector3.al(vector3, scaleRotTrans.rot);
        vector3 = vector3.ao();
        return vector3;
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
    public Vector3 entityVectorToPhysicsSpace(Vector3 vector3) {
        return vector3;
    }
}

