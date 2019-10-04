/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.jagbullet.CameraController;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.F304;
import com.jagex.maths.H303;
import com.jagex.maths.Matrix4;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import rs2.client.client;
import rs2.client.lua.ClientScriptAPI;
import rs2.client.worldelement.player;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.movement.S15;
import tfu.Ba115;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.Ej287;
import tfu.Gc330;
import tfu.Gj16;
import tfu.Gn5;
import tfu.Ll42;

@ScriptEntryClass(value="Camera")
public class ScriptCamera
extends GameEntity {
    private static ScriptCamera k;
    public static Ba115 m;
    float a;
    float ag;
    Matrix4 ai;
    Matrix4 al;
    Matrix4 aq = Matrix4.g;
    float c;
    float f;
    float i = 0.0f;
    CameraController n = null;
    float o = 0.0f;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setPerspectiveProjection(float f, float f2, float f3, float f4) {
        this.ai = Matrix4.l(f, f2, f3, f4);
        this.a = (float)(Math.tan(f3 / 2.0f) * (double)f);
        this.f = (float)(Math.tan(f4 / 2.0f) * (double)f);
        this.c = -this.a;
        this.ag = -this.f;
        this.i = f;
        this.o = f2;
    }

    ScriptCamera(ScriptManager scriptManager) {
        super(m.h(), scriptManager);
        this.ai = Matrix4.g;
        this.al = Matrix4.g;
    }

    @Deprecated
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 worldPosToScreenPos(float f, float f2, float f3, float f4, float f5, @ScriptDefaults(defaultNumber=2.0) float f6) {
        F304 f304 = new F304(f, f2, f3, 1.0f);
        Matrix4 matrix4 = this.getViewProjMatrix();
        F304.h(f304, matrix4);
        float f7 = Math.abs(f304.g / f6);
        float f8 = Math.abs(f304.d / f6);
        if (f304.j < f7) {
            f304.j = f7;
        }
        if (f304.j < f8) {
            f304.j = f8;
        }
        if (f304.j == 0.0f) {
            f304.j = 1.0f;
            f304.d = f6;
        }
        float f9 = 1.0f / f304.j;
        f304.g *= f9;
        f304.d *= f9;
        f304.q *= f9;
        f304.j *= f9;
        Vector3 vector3 = new Vector3((f304.g + 1.0f) * 0.5f * f4, (-f304.d + 1.0f) * 0.5f * f5, f304.q);
        return vector3;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean setDesiredTransform(RotTrans rotTrans) {
        if (this.n == null) {
            this.bv(this.getWorldTransform().q());
        }
        RotTrans rotTrans2 = rotTrans;
        this.setLocalOrientation(rotTrans2.rot);
        GameEntity gameEntity = ClientScriptAPI.GetSelfGameEntity();
        PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)GameEntity.eb(gameEntity, PlayerPhysicsComponent.class);
        RotTrans rotTrans3 = playerPhysicsComponent.entityRotTransToPhysicsSpace(rotTrans);
        boolean bl = this.n.e(rotTrans3.trans);
        RotTrans rotTrans4 = Q7.d(this.n.ao());
        RotTrans rotTrans5 = playerPhysicsComponent.physicsRotTransToEntitySpace(rotTrans4);
        ScriptCamera.w(this, rotTrans5.trans);
        return bl;
    }

    public static void br() {
        if (k != null) {
            ScriptCamera.k.n = null;
        }
    }

    @Deprecated
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Matrix4 getViewMatrix() {
        RotTrans rotTrans = ScriptCamera.v(this).q();
        H303 h303 = new H303();
        H303.q(h303, rotTrans);
        this.aq = new Matrix4(h303);
        return this.aq;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Matrix4 getProjMatrix() {
        return this.ai;
    }

    @Deprecated
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Matrix4 getViewProjMatrix() {
        this.al = this.getViewMatrix().g(this.ai);
        return this.al;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setTransform(RotTrans rotTrans) {
        this.setWorldTransform(rotTrans);
        if (this.n != null) {
            this.n.aa(Q7.g(rotTrans));
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setOrthographicProjection(float f, float f2, float f3) {
        this.ai = Matrix4.w(f, f2, f3);
        this.i = f;
        this.o = f2;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static ScriptCamera create(ScriptManager scriptManager, RotTrans rotTrans, float f, float f2, float f3, float f4) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        ScriptCamera scriptCamera = new ScriptCamera(scriptManager);
        scriptCamera.setTransform(rotTrans);
        scriptCamera.setPerspectiveProjection(f, f2, f3, f4);
        scriptCamera.bv(rotTrans);
        return scriptCamera;
    }

    private void bv(RotTrans rotTrans) {
        PhysicsWorldWrapper physicsWorldWrapper = client.gz.d;
        E6 e6 = physicsWorldWrapper.d.q(3.0f);
        CollisionObjectData collisionObjectData = new CollisionObjectData(S15.CAMERA);
        collisionObjectData.d = this;
        this.n = physicsWorldWrapper.d.x(e6, Q7.g(rotTrans), true, Gn5.CAMERA_SIGHT.ordinal(), Gj16.NONE.az, collisionObjectData);
        this.ba = this.n;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setRadius(float f) {
        if (this.n != null) {
            this.n.h(f);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans getPhysicsTransform() {
        if (this.n != null) {
            return Q7.d(this.n.ao());
        }
        return RotTrans.g;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans getTransform() {
        return Q7.d(this.n.ao());
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setLocalOrientation(Quaternion quaternion) {
        this.setObjectRotation(quaternion);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static ScriptCamera getActiveCamera() {
        return k;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setActiveCamera(ScriptCamera scriptCamera) {
        Scene scene;
        player player2 = Gc330.j();
        if (player2 != null && (scene = player2.getScene()) != null) {
            scene.setActiveCamera(scriptCamera);
        }
        k = scriptCamera;
    }

    static {
        m = Ba115.d(Ej287.CAMERA);
    }
}

