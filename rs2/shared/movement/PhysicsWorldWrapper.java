/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.xelement.W14;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.J13;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.Matrix4;
import com.jagex.maths.Q10;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.D18;
import rs2.shared.movement.L9;
import rs2.shared.movement.PhysicsQueryResultList;
import rs2.shared.movement.S15;
import rs2.shared.movement.V17;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gh19;
import tfu.Gj16;
import tfu.Gn5;
import tfu.Ie21;
import tfu.It12;
import tfu.Iz11;
import tfu.Ka25;
import tfu.Kb24;
import tfu.Kk26;
import tfu.Kw23;
import tfu.Kx22;

@ScriptEntryClass(value="PhysicsWorld")
public class PhysicsWorldWrapper {
    private static final Logger logger = LoggerFactory.getLogger(PhysicsWorldWrapper.class);
    public final DiscreteDynamicsWorld d;
    public Vector3 e = null;
    private Set h;
    public Vector3 j = null;
    public final Stack q = new Stack();

    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsQueryResultList cylinderSectorVolumeListQuery(float f, float f2, float f3, float f4, RotTrans rotTrans, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2, @ScriptDefaults(defaultInteger=50) int n3) {
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        E6 e6 = this.d.s(f, f2, f3, f4);
        ArrayList arrayList = new ArrayList();
        this.d.al(e6, Q7.g(rotTrans), n, n2, arrayList, n3);
        this.d.t(e6);
        return new PhysicsQueryResultList(this.d, arrayList);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean rayIntersectsAny(Vector3 vector3, Vector3 vector32, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2) {
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        return this.d.c(vector3, vector32, n, n2);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean sphereVolumeQuery(Vector3 vector3, float f, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2) {
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        E6 e6 = this.d.q(f);
        RotTrans rotTrans = new RotTrans(Quaternion.g, vector3);
        boolean bl = this.d.ag(e6, Q7.g(rotTrans), n, n2);
        this.d.t(e6);
        return bl;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsQueryResultList sphereVolumeListQuery(Vector3 vector3, float f, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2, @ScriptDefaults(defaultInteger=50) int n3) {
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        E6 e6 = this.d.q(f);
        RotTrans rotTrans = new RotTrans(Quaternion.g, vector3);
        ArrayList arrayList = new ArrayList();
        this.d.al(e6, Q7.g(rotTrans), n, n2, arrayList, n3);
        this.d.t(e6);
        return new PhysicsQueryResultList(this.d, arrayList);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean boxVolumeQuery(float f, float f2, float f3, RotTrans rotTrans, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2) {
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        E6 e6 = DiscreteDynamicsWorld.h(this.d, f, f2, f3);
        boolean bl = this.d.ag(e6, Q7.g(rotTrans), n, n2);
        this.d.t(e6);
        return bl;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getHeightfieldNormalAt(Vector3 vector3) {
        Vector3 vector32 = this.d.aa(vector3.x, vector3.z);
        return vector32;
    }

    public static void b(PhysicsWorldWrapper physicsWorldWrapper) {
        for (MappedEventComponent mappedEventComponent : physicsWorldWrapper.h) {
            MappedEventComponent.l(mappedEventComponent);
        }
        physicsWorldWrapper.h.clear();
        physicsWorldWrapper.d.i();
        physicsWorldWrapper.q.clear();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsQueryResultList capsuleVolumeListQuery(float f, float f2, RotTrans rotTrans, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2, @ScriptDefaults(defaultInteger=50) int n3) {
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        E6 e6 = this.d.j(1, f, f2);
        ArrayList arrayList = new ArrayList();
        this.d.al(e6, Q7.g(rotTrans), n, n2, arrayList, n3);
        this.d.t(e6);
        return new PhysicsQueryResultList(this.d, arrayList);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean cylinderSectorVolumeQuery(float f, float f2, float f3, float f4, RotTrans rotTrans, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2) {
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        E6 e6 = this.d.s(f, f2, f3, f4);
        boolean bl = this.d.ag(e6, Q7.g(rotTrans), n, n2);
        this.d.t(e6);
        return bl;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean capsuleVolumeQuery(float f, float f2, RotTrans rotTrans, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2) {
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        E6 e6 = this.d.j(1, f, f2);
        boolean bl = this.d.ag(e6, Q7.g(rotTrans), n, n2);
        this.d.t(e6);
        return bl;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsQueryResultList raycast(Vector3 vector3, Vector3 vector32, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2, @ScriptDefaults(defaultBoolean=false) boolean bl, @ScriptDefaults(defaultBoolean=true) boolean bl2) {
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        this.j = vector3;
        this.e = vector32;
        ArrayList arrayList = new ArrayList();
        this.d.ai(vector3, vector32, n, n2, bl, bl2, arrayList, 1000);
        return new PhysicsQueryResultList(this.d, arrayList);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity[] getEntitiesInCuboid(Vector3 vector3, Vector3 vector32, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2, @ScriptDefaults(defaultInteger=1000) int n3) {
        CollisionObjectData collisionObjectData;
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        GameEntity[] arrgameEntity = null;
        E6 e6 = DiscreteDynamicsWorld.h(this.d, vector32.x, vector32.y, vector32.z);
        ArrayList arrayList = new ArrayList();
        RotTrans rotTrans = new RotTrans(Quaternion.g, vector3);
        this.d.al(e6, Q7.g(rotTrans), n, n2, arrayList, n3);
        this.d.t(e6);
        int n4 = 0;
        for (L8 l8 : arrayList) {
            collisionObjectData = (CollisionObjectData)this.d.ap(l8.g);
            if (collisionObjectData.d == null) continue;
            ++n4;
        }
        if (n4 > 0) {
            arrgameEntity = new GameEntity[n4];
            n4 = 0;
            for (L8 l8 : arrayList) {
                collisionObjectData = (CollisionObjectData)this.d.ap(l8.g);
                if (collisionObjectData.d == null) continue;
                arrgameEntity[n4++] = collisionObjectData.d;
            }
            L9 l9 = new L9(this, vector3);
            Arrays.sort(arrgameEntity, l9);
        } else {
            arrgameEntity = new GameEntity[]{};
        }
        return arrgameEntity;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity[] getEntitiesInSphere(Vector3 vector3, float f, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2, @ScriptDefaults(defaultInteger=1000) int n3) {
        CollisionObjectData collisionObjectData;
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        GameEntity[] arrgameEntity = null;
        E6 e6 = this.d.q(f);
        ArrayList arrayList = new ArrayList();
        RotTrans rotTrans = new RotTrans(Quaternion.g, vector3);
        this.d.al(e6, Q7.g(rotTrans), n, n2, arrayList, n3);
        this.d.t(e6);
        int n4 = 0;
        for (L8 l8 : arrayList) {
            collisionObjectData = (CollisionObjectData)this.d.ap(l8.g);
            if (collisionObjectData.d == null) continue;
            ++n4;
        }
        if (n4 > 0) {
            arrgameEntity = new GameEntity[n4];
            n4 = 0;
            for (L8 l8 : arrayList) {
                collisionObjectData = (CollisionObjectData)this.d.ap(l8.g);
                if (collisionObjectData.d == null) continue;
                arrgameEntity[n4++] = collisionObjectData.d;
            }
            L9 l9 = new L9(this, vector3);
            Arrays.sort(arrgameEntity, l9);
        } else {
            arrgameEntity = new GameEntity[]{};
        }
        return arrgameEntity;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getHeightfieldHeightAt(Vector3 vector3) {
        float f = this.d.ao(vector3.x, vector3.z);
        if (f == Float.NaN) {
            return null;
        }
        Vector3 vector32 = new Vector3(vector3.x, f, vector3.z);
        return vector32;
    }

    public static E6 s(PhysicsWorldWrapper physicsWorldWrapper, Q10 q10, float f, float f2) {
        float f3 = 2.0f;
        float f4 = f3 * 2.0f;
        if (q10 != null) {
            float f5 = q10.g.f00;
            float f6 = q10.g.f10;
            float f7 = q10.g.f20;
            float f8 = q10.g.f01;
            float f9 = q10.g.f11;
            float f10 = q10.g.f21;
            float f11 = q10.g.f02;
            float f12 = q10.g.f12;
            float f13 = q10.g.f22;
            float f14 = f5 * f5 + f11 * f11;
            float f15 = f6 * f6 + f12 * f12;
            float f16 = f7 * f7 + f13 * f13;
            f3 = (float)Math.sqrt(f14 + f15 + f16);
            f4 = (float)Math.sqrt(f8 * f8 + f9 * f9 + f10 * f10) * 2.0f;
        }
        if (f > 0.0f) {
            f3 = f;
        }
        if (f2 > 0.0f) {
            f4 = f2;
        }
        if (f4 < f3 * 2.0f) {
            f3 = f4 / 2.0f;
        }
        return physicsWorldWrapper.d.j(1, f3, f4 - f3 * 2.0f);
    }

    public RigidBody g(Iz11 iz11, RotTrans rotTrans, float f, int n, int n2, float f2, float f3, boolean bl, boolean bl2, CollisionObjectData collisionObjectData) {
        if (iz11.q.length < 1) {
            return null;
        }
        if (iz11.q.length == 1) {
            RotTrans rotTrans2 = new RotTrans(iz11.j[0].rot, Vector3.ai(iz11.j[0].trans, f));
            RotTrans rotTrans3 = rotTrans2.e(rotTrans);
            E6 e6 = PhysicsWorldWrapper.q(this, iz11.q[0], f);
            return this.d.v(e6, Q7.g(rotTrans3), f2, f3, n, n2, bl, bl2, collisionObjectData);
        }
        E6 e6 = PhysicsWorldWrapper.d(this, iz11, f);
        return this.d.v(e6, Q7.g(rotTrans), f2, f3, n, n2, bl, bl2, collisionObjectData);
    }

    public static E6 d(PhysicsWorldWrapper physicsWorldWrapper, Iz11 iz11, float f) {
        E6[] arre6 = new E6[iz11.q.length];
        Q7[] arrq7 = new Q7[iz11.q.length];
        for (int i = 0; i < iz11.q.length; ++i) {
            arre6[i] = PhysicsWorldWrapper.q(physicsWorldWrapper, iz11.q[i], f);
            arrq7[i] = Q7.g(iz11.j[i].y(f));
        }
        return physicsWorldWrapper.d.r(arre6, arrq7);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean getGroupsCollide(int n, int n2) {
        return this.d.an(n, n2);
    }

    public void j(ArrayList arrayList) {
        HashSet<MappedEventComponent> hashSet = new HashSet<MappedEventComponent>();
        for (Object object : arrayList) {
            GameEntity gameEntity = ((CollisionObjectData)object.g.w).d;
            GameEntity gameEntity2 = ((CollisionObjectData)object.d.w).d;
            if (gameEntity == null || gameEntity2 == null) continue;
            MappedEventComponent mappedEventComponent = (MappedEventComponent)GameEntity.eb(gameEntity, MappedEventComponent.class);
            MappedEventComponent mappedEventComponent2 = (MappedEventComponent)GameEntity.eb(gameEntity2, MappedEventComponent.class);
            if (mappedEventComponent != null && MappedEventComponent.e(mappedEventComponent)) {
                if (mappedEventComponent2 != null && MappedEventComponent.e(mappedEventComponent2)) continue;
                mappedEventComponent.b(gameEntity2);
                hashSet.add(mappedEventComponent);
                continue;
            }
            if (mappedEventComponent2 != null && MappedEventComponent.e(mappedEventComponent2)) {
                mappedEventComponent2.b(gameEntity);
                hashSet.add(mappedEventComponent2);
                continue;
            }
            if (mappedEventComponent != null) {
                MappedEventComponent.g(mappedEventComponent, gameEntity2);
            }
            if (mappedEventComponent2 == null) continue;
            MappedEventComponent.g(mappedEventComponent2, gameEntity);
        }
        for (Object object : this.h) {
            MappedEventComponent.l((MappedEventComponent)object);
        }
        this.h = hashSet;
    }

    public void e(W14 w14, float f, float f2) {
        if (w14 != null) {
            CollisionObjectData collisionObjectData = new CollisionObjectData(S15.GROUND);
            D18 d18 = V17.g(this.d, w14, f, f2, 0.2f, 0.0f, Gn5.HEIGHTFIELD.ordinal(), Gj16.NONE.az, collisionObjectData);
            this.q.add(d18);
        }
    }

    public RigidBody h(GameEntity gameEntity, float f, float f2, Integer n) {
        Object object;
        Iz11 iz11 = gameEntity.cj;
        if (iz11 == null) {
            object = GameEntity.k(gameEntity);
            if (object != null) {
                iz11 = Iz11.d((Q10)object);
                gameEntity.z = false;
            } else {
                gameEntity.z = true;
            }
        }
        if (iz11 != null) {
            object = gameEntity.getWorldTransform();
            RotTrans rotTrans = ((ScaleRotTrans)object).q();
            rotTrans = rotTrans.w(f, 0.0f, f2);
            CollisionObjectData collisionObjectData = new CollisionObjectData(S15.SCENERY);
            collisionObjectData.d = gameEntity;
            boolean bl = false;
            boolean bl2 = true;
            MappedEventComponent mappedEventComponent = (MappedEventComponent)GameEntity.eb(gameEntity, MappedEventComponent.class);
            if (mappedEventComponent != null) {
                bl = MappedEventComponent.q(mappedEventComponent);
                bl2 = MappedEventComponent.j(mappedEventComponent);
            }
            int n2 = bl && !bl2 ? Gn5.TRIGGER_VOLUME.ordinal() : Gn5.SCENERY.ordinal();
            int n3 = Gj16.NONE.az;
            if (n == null) {
                n3 = GameEntity.ev(gameEntity, "CollisionMask", Gj16.NONE.az);
                if (n3 != Gj16.NONE.az) {
                    n3 <<= 2;
                    try {
                        Gj16.g(n3);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        logger.warn("A CollisionMask was specified as an entity propery but was invalid - set to CollisionMask.NONE.mask (0).\n{}\n(Specified mask was: '{}'.)", (Object)illegalArgumentException.getMessage(), (Object)n3);
                        n3 = Gj16.NONE.az;
                    }
                }
            } else {
                n3 = n;
            }
            gameEntity.u = bl2;
            RigidBody rigidBody = this.g(iz11, rotTrans, ((ScaleRotTrans)object).scale, n2, n3, Gh19.y, Gh19.x, bl, bl2, collisionObjectData);
            return rigidBody;
        }
        return null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setGroupsCollide(int n, int n2, boolean bl) {
        DiscreteDynamicsWorld.as(this.d, n, n2, bl);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity[] getEntitiesInSwingArea(Vector3 vector3, float f, float f2, float f3, float f4, @ScriptDefaults(defaultNumber=0.0) float f5, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2, @ScriptDefaults(defaultInteger=1000) int n3) {
        float f6;
        if (vector3 == null) {
            return null;
        }
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        GameEntity[] arrgameEntity = null;
        for (f6 = 1.5707964f - f3; f6 >= 6.2831855f; f6 -= 6.2831855f) {
        }
        while (f6 <= 0.0f) {
            f6 += 6.2831855f;
        }
        if (f4 < 0.0f) {
            f4 = 1.0E-4f;
        }
        if (f4 >= 6.2831855f) {
            f4 = 6.2830853f;
        }
        float f7 = f6 - f4 / 2.0f;
        float f8 = f6 + f4 / 2.0f;
        if (f7 < 0.0f) {
            f7 = (float)((double)f7 + 6.283185307179586);
            f8 = (float)((double)f8 + 6.283185307179586);
        }
        E6 e6 = this.d.s(f, f2, f7, f8);
        ArrayList arrayList = new ArrayList();
        Vector3 vector32 = Vector3.g((float)Math.cos(f3), 0.0f, -((float)Math.sin(f3)));
        RotTrans rotTrans = new RotTrans(Quaternion.j(vector32, f5), vector3);
        this.d.al(e6, Q7.g(rotTrans), n, n2, arrayList, n3);
        this.d.t(e6);
        int n4 = 0;
        for (Object object : arrayList) {
            Object object2 = (CollisionObjectData)this.d.ap(((L8)object).g);
            if (((CollisionObjectData)object2).d == null) continue;
            ++n4;
        }
        if (n4 > 0) {
            Object object;
            arrgameEntity = new GameEntity[n4];
            n4 = 0;
            int n5 = 0;
            for (Object object2 : arrayList) {
                CollisionObjectData collisionObjectData = (CollisionObjectData)this.d.ap(((L8)object2).g);
                if (collisionObjectData.d == null) continue;
                ++n5;
                arrgameEntity[n4++] = collisionObjectData.d;
            }
            if (n5 == 0) {
                arrgameEntity = null;
            }
            object = new L9(this, vector3);
            Arrays.sort(arrgameEntity, object);
        } else {
            arrgameEntity = null;
        }
        return arrgameEntity;
    }

    public static void l(PhysicsWorldWrapper physicsWorldWrapper) {
        physicsWorldWrapper.d.i();
        physicsWorldWrapper.d.ab();
    }

    public PhysicsWorldWrapper(DiscreteDynamicsWorld discreteDynamicsWorld) {
        this.h = Collections.emptySet();
        this.d = discreteDynamicsWorld;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsQueryResultList boxVolumeListQuery(float f, float f2, float f3, RotTrans rotTrans, @ScriptDefaults(defaultInteger=0) int n, @ScriptDefaults(defaultInteger=0) int n2, @ScriptDefaults(defaultInteger=50) int n3) {
        if (n == 0) {
            n = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        E6 e6 = DiscreteDynamicsWorld.h(this.d, f, f2, f3);
        ArrayList arrayList = new ArrayList();
        this.d.al(e6, Q7.g(rotTrans), n, n2, arrayList, n3);
        this.d.t(e6);
        return new PhysicsQueryResultList(this.d, arrayList);
    }

    public static E6 q(PhysicsWorldWrapper physicsWorldWrapper, It12 it12, float f) {
        switch (it12.g()) {
            case BOX: {
                Kx22 kx22 = (Kx22)it12;
                return DiscreteDynamicsWorld.h(physicsWorldWrapper.d, f * kx22.d, f * kx22.q, f * kx22.j);
            }
            case CAPSULE: {
                Kw23 kw23 = (Kw23)it12;
                return physicsWorldWrapper.d.j(1, f * kw23.g, f * kw23.d);
            }
            case CONVEX_HULL: {
                Kb24 kb24 = (Kb24)it12;
                Vector3[] arrvector3 = new Vector3[kb24.d.length];
                for (int i = 0; i < kb24.d.length; ++i) {
                    arrvector3[i] = Vector3.ai(kb24.d[i], f);
                }
                return physicsWorldWrapper.d.b(arrvector3);
            }
            case CONVEX_2D_POLYGON: {
                return null;
            }
            case GENERIC_STATIC_MESH: {
                Ka25 ka25 = (Ka25)it12;
                Vector3[] arrvector3 = new Vector3[ka25.d.length];
                for (int i = 0; i < ka25.d.length; ++i) {
                    arrvector3[i] = Vector3.ai(ka25.d[i], f);
                }
                return physicsWorldWrapper.d.l(arrvector3, ka25.q);
            }
            case SPHERE: {
                Kk26 kk26 = (Kk26)it12;
                return physicsWorldWrapper.d.q(f * kk26.g);
            }
        }
        return null;
    }
}

