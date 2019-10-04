// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import tfu.Bc288;
import tfu.Ej287;
import com.jagex.game.runetek6.scenegraph.Scene;
import rs2.client.worldelement.player;
import tfu.Gc330;
import com.jagex.maths.Quaternion;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import rs2.shared.movement.PhysicsWorldWrapper;
import tfu.Gj16;
import tfu.Gn5;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.S15;
import com.jagex.maths.H303;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import rs2.client.lua.ClientScriptAPI;
import rs2.shared.movement.PlayerPhysicsComponent;
import com.jagex.maths.RotTrans;
import com.jagex.maths.F304;
import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptManager;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.CameraController;
import com.jagex.maths.Matrix4;
import tfu.Ba115;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.gameentity.GameEntity;

@ScriptEntryClass("Camera")
public class ScriptCamera extends GameEntity
{
    private static ScriptCamera k;
    public static Ba115 m;
    float a;
    float ag;
    Matrix4 ai;
    Matrix4 al;
    Matrix4 aq;
    float c;
    float f;
    float i;
    CameraController n;
    float o;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setPerspectiveProjection(final float i, final float o, final float n, final float n2) {
        this.ai = Matrix4.l(i, o, n, n2);
        this.a = (float)(Math.tan(n / 2.0f) * i);
        this.f = (float)(Math.tan(n2 / 2.0f) * i);
        this.c = -this.a;
        this.ag = -this.f;
        this.i = i;
        this.o = o;
    }
    
    ScriptCamera(final ScriptManager scriptManager) {
        super(ScriptCamera.m.h(), scriptManager);
        this.n = null;
        this.i = 0.0f;
        this.o = 0.0f;
        this.aq = Matrix4.g;
        this.ai = Matrix4.g;
        this.al = Matrix4.g;
    }
    
    @Deprecated
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 worldPosToScreenPos(final float n, final float n2, final float n3, final float n4, final float n5, @ScriptDefaults(defaultNumber = 2.0) final float d) {
        final F304 f304 = new F304(n, n2, n3, 1.0f);
        F304.h(f304, this.getViewProjMatrix());
        final float abs = Math.abs(f304.g / d);
        final float abs2 = Math.abs(f304.d / d);
        if (f304.j < abs) {
            f304.j = abs;
        }
        if (f304.j < abs2) {
            f304.j = abs2;
        }
        if (f304.j == 0.0f) {
            f304.j = 1.0f;
            f304.d = d;
        }
        final float n6 = 1.0f / f304.j;
        final F304 f305 = f304;
        f305.g *= n6;
        final F304 f306 = f304;
        f306.d *= n6;
        final F304 f307 = f304;
        f307.q *= n6;
        final F304 f308 = f304;
        f308.j *= n6;
        return new Vector3((f304.g + 1.0f) * 0.5f * n4, (-f304.d + 1.0f) * 0.5f * n5, f304.q);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean setDesiredTransform(final RotTrans rotTrans) {
        if (this.n == null) {
            this.bv(this.getWorldTransform().q());
        }
        this.setLocalOrientation(rotTrans.rot);
        final PlayerPhysicsComponent playerPhysicsComponent = (PlayerPhysicsComponent)GameEntity.eb(ClientScriptAPI.GetSelfGameEntity(), PlayerPhysicsComponent.class);
        final boolean e = this.n.e(playerPhysicsComponent.entityRotTransToPhysicsSpace(rotTrans).trans);
        SceneGraphNode.w(this, playerPhysicsComponent.physicsRotTransToEntitySpace(Q7.d(this.n.ao())).trans);
        return e;
    }
    
    public static void br() {
        if (ScriptCamera.k != null) {
            ScriptCamera.k.n = null;
        }
    }
    
    @Deprecated
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Matrix4 getViewMatrix() {
        final RotTrans q = SceneGraphNode.v(this).q();
        final H303 h303 = new H303();
        H303.q(h303, q);
        return this.aq = new Matrix4(h303);
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
        return this.al = this.getViewMatrix().g(this.ai);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setTransform(final RotTrans worldTransform) {
        this.setWorldTransform(worldTransform);
        if (this.n != null) {
            this.n.aa(Q7.g(worldTransform));
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setOrthographicProjection(final float i, final float o, final float n) {
        this.ai = Matrix4.w(i, o, n);
        this.i = i;
        this.o = o;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static ScriptCamera create(final ScriptManager scriptManager, final RotTrans transform, final float n, final float n2, final float n3, final float n4) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        final ScriptCamera scriptCamera = new ScriptCamera(scriptManager);
        scriptCamera.setTransform(transform);
        scriptCamera.setPerspectiveProjection(n, n2, n3, n4);
        scriptCamera.bv(transform);
        return scriptCamera;
    }
    
    private void bv(final RotTrans rotTrans) {
        final PhysicsWorldWrapper d = client.gz.d;
        final E6 q = d.d.q(3.0f);
        final CollisionObjectData collisionObjectData = new CollisionObjectData(S15.CAMERA);
        collisionObjectData.d = this;
        this.n = d.d.x(q, Q7.g(rotTrans), true, Gn5.CAMERA_SIGHT.ordinal(), Gj16.NONE.az, collisionObjectData);
        super.ba = this.n;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setRadius(final float n) {
        if (this.n != null) {
            this.n.h(n);
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
    public void setLocalOrientation(final Quaternion objectRotation) {
        this.setObjectRotation(objectRotation);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static ScriptCamera getActiveCamera() {
        return ScriptCamera.k;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void setActiveCamera(final ScriptCamera scriptCamera) {
        final player j = Gc330.j();
        if (j != null) {
            final Scene scene = j.getScene();
            if (scene != null) {
                scene.setActiveCamera(scriptCamera);
            }
        }
        ScriptCamera.k = scriptCamera;
    }
    
    static {
        ScriptCamera.m = Ba115.d(Ej287.CAMERA);
    }
}
