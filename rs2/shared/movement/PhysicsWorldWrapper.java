// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import tfu.Kk26;
import tfu.Ka25;
import tfu.Kb24;
import tfu.Kw23;
import tfu.Kx22;
import tfu.It12;
import java.util.Collections;
import org.slf4j.LoggerFactory;
import com.jagex.maths.ScaleRotTrans;
import tfu.Gh19;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import tfu.Gj16;
import com.jagex.game.runetek6.xelement.W14;
import com.jagex.jnibindings.runetek6.jagbullet.J13;
import java.util.HashSet;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import tfu.Iz11;
import com.jagex.maths.Q10;
import java.util.Comparator;
import java.util.Arrays;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import com.jagex.game.runetek6.gameentity.GameEntity;
import java.util.Iterator;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.maths.Quaternion;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import java.util.List;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import java.util.ArrayList;
import tfu.Gn5;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.maths.RotTrans;
import java.util.Stack;
import java.util.Set;
import com.jagex.maths.Vector3;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import org.slf4j.Logger;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("PhysicsWorld")
public class PhysicsWorldWrapper
{
    private static final Logger logger;
    public final DiscreteDynamicsWorld d;
    public Vector3 e;
    private Set h;
    public Vector3 j;
    public final Stack q;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsQueryResultList cylinderSectorVolumeListQuery(final float n, final float n2, final float n3, final float n4, final RotTrans rotTrans, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n5, @ScriptDefaults(defaultInteger = 50) final int n6) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        final E6 s = this.d.s(n, n2, n3, n4);
        final ArrayList list = new ArrayList();
        this.d.al(s, Q7.g(rotTrans), ordinal, n5, list, n6);
        this.d.t(s);
        return new PhysicsQueryResultList(this.d, list);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean rayIntersectsAny(final Vector3 vector3, final Vector3 vector4, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        return this.d.c(vector3, vector4, ordinal, n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean sphereVolumeQuery(final Vector3 vector3, final float n, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n2) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        final E6 q = this.d.q(n);
        final boolean ag = this.d.ag(q, Q7.g(new RotTrans(Quaternion.g, vector3)), ordinal, n2);
        this.d.t(q);
        return ag;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsQueryResultList sphereVolumeListQuery(final Vector3 vector3, final float n, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n2, @ScriptDefaults(defaultInteger = 50) final int n3) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        final E6 q = this.d.q(n);
        final RotTrans rotTrans = new RotTrans(Quaternion.g, vector3);
        final ArrayList list = new ArrayList();
        this.d.al(q, Q7.g(rotTrans), ordinal, n2, list, n3);
        this.d.t(q);
        return new PhysicsQueryResultList(this.d, list);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean boxVolumeQuery(final float n, final float n2, final float n3, final RotTrans rotTrans, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n4) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        final E6 h = DiscreteDynamicsWorld.h(this.d, n, n2, n3);
        final boolean ag = this.d.ag(h, Q7.g(rotTrans), ordinal, n4);
        this.d.t(h);
        return ag;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getHeightfieldNormalAt(final Vector3 vector3) {
        return this.d.aa(vector3.x, vector3.z);
    }
    
    public static void b(final PhysicsWorldWrapper physicsWorldWrapper) {
        final Iterator<MappedEventComponent> iterator = physicsWorldWrapper.h.iterator();
        while (iterator.hasNext()) {
            MappedEventComponent.l(iterator.next());
        }
        physicsWorldWrapper.h.clear();
        physicsWorldWrapper.d.i();
        physicsWorldWrapper.q.clear();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsQueryResultList capsuleVolumeListQuery(final float n, final float n2, final RotTrans rotTrans, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n3, @ScriptDefaults(defaultInteger = 50) final int n4) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        final E6 j = this.d.j(1, n, n2);
        final ArrayList list = new ArrayList();
        this.d.al(j, Q7.g(rotTrans), ordinal, n3, list, n4);
        this.d.t(j);
        return new PhysicsQueryResultList(this.d, list);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean cylinderSectorVolumeQuery(final float n, final float n2, final float n3, final float n4, final RotTrans rotTrans, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n5) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        final E6 s = this.d.s(n, n2, n3, n4);
        final boolean ag = this.d.ag(s, Q7.g(rotTrans), ordinal, n5);
        this.d.t(s);
        return ag;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean capsuleVolumeQuery(final float n, final float n2, final RotTrans rotTrans, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n3) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        final E6 j = this.d.j(1, n, n2);
        final boolean ag = this.d.ag(j, Q7.g(rotTrans), ordinal, n3);
        this.d.t(j);
        return ag;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsQueryResultList raycast(final Vector3 j, final Vector3 e, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n, @ScriptDefaults(defaultBoolean = false) final boolean b, @ScriptDefaults(defaultBoolean = true) final boolean b2) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        this.j = j;
        this.e = e;
        final ArrayList list = new ArrayList();
        this.d.ai(j, e, ordinal, n, b, b2, list, 1000);
        return new PhysicsQueryResultList(this.d, list);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity[] getEntitiesInCuboid(final Vector3 vector3, final Vector3 vector4, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n, @ScriptDefaults(defaultInteger = 1000) final int n2) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        final E6 h = DiscreteDynamicsWorld.h(this.d, vector4.x, vector4.y, vector4.z);
        final ArrayList<L8> list = new ArrayList<L8>();
        this.d.al(h, Q7.g(new RotTrans(Quaternion.g, vector3)), ordinal, n, list, n2);
        this.d.t(h);
        int n3 = 0;
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (((CollisionObjectData)this.d.ap(iterator.next().g)).d != null) {
                ++n3;
            }
        }
        GameEntity[] a;
        if (n3 > 0) {
            a = new GameEntity[n3];
            int n4 = 0;
            final Iterator<Object> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                final CollisionObjectData collisionObjectData = (CollisionObjectData)this.d.ap(iterator2.next().g);
                if (collisionObjectData.d != null) {
                    a[n4++] = collisionObjectData.d;
                }
            }
            Arrays.sort(a, new L9(this, vector3));
        }
        else {
            a = new GameEntity[0];
        }
        return a;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity[] getEntitiesInSphere(final Vector3 vector3, final float n, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n2, @ScriptDefaults(defaultInteger = 1000) final int n3) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        final E6 q = this.d.q(n);
        final ArrayList<L8> list = new ArrayList<L8>();
        this.d.al(q, Q7.g(new RotTrans(Quaternion.g, vector3)), ordinal, n2, list, n3);
        this.d.t(q);
        int n4 = 0;
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (((CollisionObjectData)this.d.ap(iterator.next().g)).d != null) {
                ++n4;
            }
        }
        GameEntity[] a;
        if (n4 > 0) {
            a = new GameEntity[n4];
            int n5 = 0;
            final Iterator<Object> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                final CollisionObjectData collisionObjectData = (CollisionObjectData)this.d.ap(iterator2.next().g);
                if (collisionObjectData.d != null) {
                    a[n5++] = collisionObjectData.d;
                }
            }
            Arrays.sort(a, new L9(this, vector3));
        }
        else {
            a = new GameEntity[0];
        }
        return a;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getHeightfieldHeightAt(final Vector3 vector3) {
        final float ao = this.d.ao(vector3.x, vector3.z);
        if (ao == Float.NaN) {
            return null;
        }
        return new Vector3(vector3.x, ao, vector3.z);
    }
    
    public static E6 s(final PhysicsWorldWrapper physicsWorldWrapper, final Q10 q10, final float n, final float n2) {
        float n3 = 2.0f;
        float n4 = n3 * 2.0f;
        if (q10 != null) {
            final float f00 = q10.g.f00;
            final float f2 = q10.g.f10;
            final float f3 = q10.g.f20;
            final float f4 = q10.g.f01;
            final float f5 = q10.g.f11;
            final float f6 = q10.g.f21;
            final float f7 = q10.g.f02;
            final float f8 = q10.g.f12;
            final float f9 = q10.g.f22;
            n3 = (float)Math.sqrt(f00 * f00 + f7 * f7 + (f2 * f2 + f8 * f8) + (f3 * f3 + f9 * f9));
            n4 = (float)Math.sqrt(f4 * f4 + f5 * f5 + f6 * f6) * 2.0f;
        }
        if (n > 0.0f) {
            n3 = n;
        }
        if (n2 > 0.0f) {
            n4 = n2;
        }
        if (n4 < n3 * 2.0f) {
            n3 = n4 / 2.0f;
        }
        return physicsWorldWrapper.d.j(1, n3, n4 - n3 * 2.0f);
    }
    
    public RigidBody g(final Iz11 iz11, final RotTrans rotTrans, final float n, final int n2, final int n3, final float n4, final float n5, final boolean b, final boolean b2, final CollisionObjectData collisionObjectData) {
        if (iz11.q.length < 1) {
            return null;
        }
        if (iz11.q.length == 1) {
            return this.d.v(q(this, iz11.q[0], n), Q7.g(new RotTrans(iz11.j[0].rot, Vector3.ai(iz11.j[0].trans, n)).e(rotTrans)), n4, n5, n2, n3, b, b2, collisionObjectData);
        }
        return this.d.v(d(this, iz11, n), Q7.g(rotTrans), n4, n5, n2, n3, b, b2, collisionObjectData);
    }
    
    public static E6 d(final PhysicsWorldWrapper physicsWorldWrapper, final Iz11 iz11, final float n) {
        final E6[] array = new E6[iz11.q.length];
        final Q7[] array2 = new Q7[iz11.q.length];
        for (int i = 0; i < iz11.q.length; ++i) {
            array[i] = q(physicsWorldWrapper, iz11.q[i], n);
            array2[i] = Q7.g(iz11.j[i].y(n));
        }
        return physicsWorldWrapper.d.r(array, array2);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean getGroupsCollide(final int n, final int n2) {
        return this.d.an(n, n2);
    }
    
    public void j(final ArrayList list) {
        final HashSet<MappedEventComponent> h = new HashSet<MappedEventComponent>();
        for (final J13 j13 : list) {
            final GameEntity d = ((CollisionObjectData)j13.g.w).d;
            final GameEntity d2 = ((CollisionObjectData)j13.d.w).d;
            if (d != null) {
                if (d2 == null) {
                    continue;
                }
                final MappedEventComponent mappedEventComponent = (MappedEventComponent)GameEntity.eb(d, MappedEventComponent.class);
                final MappedEventComponent mappedEventComponent2 = (MappedEventComponent)GameEntity.eb(d2, MappedEventComponent.class);
                if (mappedEventComponent != null && MappedEventComponent.e(mappedEventComponent)) {
                    if (mappedEventComponent2 != null && MappedEventComponent.e(mappedEventComponent2)) {
                        continue;
                    }
                    mappedEventComponent.b(d2);
                    h.add(mappedEventComponent);
                }
                else if (mappedEventComponent2 != null && MappedEventComponent.e(mappedEventComponent2)) {
                    mappedEventComponent2.b(d);
                    h.add(mappedEventComponent2);
                }
                else {
                    if (mappedEventComponent != null) {
                        MappedEventComponent.g(mappedEventComponent, d2);
                    }
                    if (mappedEventComponent2 == null) {
                        continue;
                    }
                    MappedEventComponent.g(mappedEventComponent2, d);
                }
            }
        }
        final Iterator<MappedEventComponent> iterator2 = this.h.iterator();
        while (iterator2.hasNext()) {
            MappedEventComponent.l(iterator2.next());
        }
        this.h = h;
    }
    
    public void e(final W14 w14, final float n, final float n2) {
        if (w14 != null) {
            this.q.add(V17.g(this.d, w14, n, n2, 0.2f, 0.0f, Gn5.HEIGHTFIELD.ordinal(), Gj16.NONE.az, new CollisionObjectData(S15.GROUND)));
        }
    }
    
    public RigidBody h(final GameEntity d, final float n, final float n2, final Integer n3) {
        Iz11 iz11 = d.cj;
        if (iz11 == null) {
            final Q10 k = SceneGraphNode.k(d);
            if (k != null) {
                iz11 = Iz11.d(k);
                d.z = false;
            }
            else {
                d.z = true;
            }
        }
        if (iz11 != null) {
            final ScaleRotTrans worldTransform = d.getWorldTransform();
            final RotTrans w = worldTransform.q().w(n, 0.0f, n2);
            final CollisionObjectData collisionObjectData = new CollisionObjectData(S15.SCENERY);
            collisionObjectData.d = d;
            boolean q = false;
            boolean j = true;
            final MappedEventComponent mappedEventComponent = (MappedEventComponent)GameEntity.eb(d, MappedEventComponent.class);
            if (mappedEventComponent != null) {
                q = MappedEventComponent.q(mappedEventComponent);
                j = MappedEventComponent.j(mappedEventComponent);
            }
            int n4;
            if (q && !j) {
                n4 = Gn5.TRIGGER_VOLUME.ordinal();
            }
            else {
                n4 = Gn5.SCENERY.ordinal();
            }
            final int az = Gj16.NONE.az;
            int i;
            if (n3 == null) {
                i = GameEntity.ev(d, "CollisionMask", Gj16.NONE.az);
                if (i != Gj16.NONE.az) {
                    i <<= 2;
                    try {
                        Gj16.g(i);
                    }
                    catch (IllegalArgumentException ex) {
                        PhysicsWorldWrapper.logger.warn("A CollisionMask was specified as an entity propery but was invalid - set to CollisionMask.NONE.mask (0).\n{}\n(Specified mask was: '{}'.)", ex.getMessage(), i);
                        i = Gj16.NONE.az;
                    }
                }
            }
            else {
                i = n3;
            }
            d.u = j;
            return this.g(iz11, w, worldTransform.scale, n4, i, Gh19.y, Gh19.x, q, j, collisionObjectData);
        }
        return null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setGroupsCollide(final int n, final int n2, final boolean b) {
        DiscreteDynamicsWorld.as(this.d, n, n2, b);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity[] getEntitiesInSwingArea(final Vector3 vector3, final float n, final float n2, final float n3, float n4, @ScriptDefaults(defaultNumber = 0.0) final float n5, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n6, @ScriptDefaults(defaultInteger = 1000) final int n7) {
        if (vector3 == null) {
            return null;
        }
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        float n8;
        for (n8 = 1.5707964f - n3; n8 >= 6.2831855f; n8 -= 6.2831855f) {}
        while (n8 <= 0.0f) {
            n8 += 6.2831855f;
        }
        if (n4 < 0.0f) {
            n4 = 1.0E-4f;
        }
        if (n4 >= 6.2831855f) {
            n4 = 6.2830853f;
        }
        float n9 = n8 - n4 / 2.0f;
        float n10 = n8 + n4 / 2.0f;
        if (n9 < 0.0f) {
            n9 += (float)6.283185307179586;
            n10 += (float)6.283185307179586;
        }
        final E6 s = this.d.s(n, n2, n9, n10);
        final ArrayList<L8> list = new ArrayList<L8>();
        this.d.al(s, Q7.g(new RotTrans(Quaternion.j(Vector3.g((float)Math.cos(n3), 0.0f, -(float)Math.sin(n3)), n5), vector3)), ordinal, n6, list, n7);
        this.d.t(s);
        int n11 = 0;
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (((CollisionObjectData)this.d.ap(iterator.next().g)).d != null) {
                ++n11;
            }
        }
        GameEntity[] a;
        if (n11 > 0) {
            a = new GameEntity[n11];
            int n12 = 0;
            int n13 = 0;
            final Iterator<Object> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                final CollisionObjectData collisionObjectData = (CollisionObjectData)this.d.ap(iterator2.next().g);
                if (collisionObjectData.d != null) {
                    ++n13;
                    a[n12++] = collisionObjectData.d;
                }
            }
            if (n13 == 0) {
                a = null;
            }
            Arrays.sort(a, new L9(this, vector3));
        }
        else {
            a = null;
        }
        return a;
    }
    
    public static void l(final PhysicsWorldWrapper physicsWorldWrapper) {
        physicsWorldWrapper.d.i();
        physicsWorldWrapper.d.ab();
    }
    
    static {
        logger = LoggerFactory.getLogger(PhysicsWorldWrapper.class);
    }
    
    public PhysicsWorldWrapper(final DiscreteDynamicsWorld d) {
        this.q = new Stack();
        this.j = null;
        this.e = null;
        this.h = Collections.emptySet();
        this.d = d;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsQueryResultList boxVolumeListQuery(final float n, final float n2, final float n3, final RotTrans rotTrans, @ScriptDefaults(defaultInteger = 0) int ordinal, @ScriptDefaults(defaultInteger = 0) final int n4, @ScriptDefaults(defaultInteger = 50) final int n5) {
        if (ordinal == 0) {
            ordinal = Gn5.PLAYER_VOLUME_QUERY.ordinal();
        }
        final E6 h = DiscreteDynamicsWorld.h(this.d, n, n2, n3);
        final ArrayList list = new ArrayList();
        this.d.al(h, Q7.g(rotTrans), ordinal, n4, list, n5);
        this.d.t(h);
        return new PhysicsQueryResultList(this.d, list);
    }
    
    public static E6 q(final PhysicsWorldWrapper physicsWorldWrapper, final It12 it12, final float n) {
        switch (N20.g[it12.g().ordinal()]) {
            case 1: {
                final Kx22 kx22 = (Kx22)it12;
                return DiscreteDynamicsWorld.h(physicsWorldWrapper.d, n * kx22.d, n * kx22.q, n * kx22.j);
            }
            case 2: {
                final Kw23 kw23 = (Kw23)it12;
                return physicsWorldWrapper.d.j(1, n * kw23.g, n * kw23.d);
            }
            case 3: {
                final Kb24 kb24 = (Kb24)it12;
                final Vector3[] array = new Vector3[kb24.d.length];
                for (int i = 0; i < kb24.d.length; ++i) {
                    array[i] = Vector3.ai(kb24.d[i], n);
                }
                return physicsWorldWrapper.d.b(array);
            }
            case 4: {
                return null;
            }
            case 5: {
                final Ka25 ka25 = (Ka25)it12;
                final Vector3[] array2 = new Vector3[ka25.d.length];
                for (int j = 0; j < ka25.d.length; ++j) {
                    array2[j] = Vector3.ai(ka25.d[j], n);
                }
                return physicsWorldWrapper.d.l(array2, ka25.q);
            }
            case 6: {
                return physicsWorldWrapper.d.q(n * ((Kk26)it12).g);
            }
            default: {
                return null;
            }
        }
    }
}
