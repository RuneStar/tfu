// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.maths.ScaleRotTrans;
import java.util.HashMap;
import org.slf4j.LoggerFactory;
import com.jagex.maths.E41;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import java.util.List;
import com.jagex.jnibindings.runetek6.jagbullet.D194;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.jnibindings.runetek6.StaticModel;
import java.util.Iterator;
import tfu.Lq191;
import com.jagex.maths.Z165;
import com.jagex.maths.I48;
import tfu.Gj16;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import tfu.Lb33;
import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.SourceLossyStateStream;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.maths.Quaternion;
import tfu.Gh19;
import com.jagex.jnibindings.runetek6.Scripting$ScriptIDMap;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import tfu.Gn5;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import tfu.Ao128;
import com.jagex.maths.M47;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.maths.Vector3;
import com.jagex.maths.RotTrans;
import com.jagex.game.runetek6.script.ScriptManager;
import org.slf4j.Logger;
import java.util.Map;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.gameentity.Component;

@ScriptEntryClass
public class PlayerPhysicsComponent extends Component
{
    private static final int a = 10;
    static final Map ab;
    private static final int ag = 13;
    private static final int ai = 15;
    private static final String[] al;
    private static final int aq = 14;
    static float ar;
    public static boolean as;
    public static final int at;
    static int aw;
    private static final int c = 12;
    public static boolean d;
    private static final int f = 11;
    private static final int i = 8;
    private static final int k = 7;
    private static final Logger logger;
    private static final int m = 5;
    private static final int n = 6;
    private static final int o = 9;
    private static final int p = 0;
    private static final int t = 4;
    private static final int u = 2;
    private static final int x = 1;
    private static final int z = 3;
    private final Ag183 aa;
    private final ScriptManager ac;
    private final RotTrans[] af;
    private final PlayerPhysicsAvatar ah;
    public boolean am;
    public float an;
    private boolean ao;
    private C184 ap;
    private Map av;
    private Map az;
    U186 b;
    public Vector3 e;
    public Vector3 h;
    private RotTrans j;
    private I187 l;
    public final M188 q;
    private int r;
    final boolean s = true;
    private Vector3 v;
    private Integer w;
    private Vector3 y;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float GetVehicleCurveReverseAccelerationMultiplier() {
        if (this.ah.b != null && this.ah.w != null) {
            return this.ah.w.v;
        }
        return 0.0f;
    }
    
    public static void g(final PlayerPhysicsComponent playerPhysicsComponent, final I187 l) {
        playerPhysicsComponent.l = l;
        PlayerPhysicsAvatar.g(playerPhysicsComponent.ah, l);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float vehicleGetFrictionDissipationReductionEffect() {
        if (this.ah.b != null) {
            return this.ah.b.p;
        }
        return 0.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public PlayerPhysicsAvatar getAvatar(final boolean b) {
        return this.ah;
    }
    
    public static void q(final PlayerPhysicsComponent playerPhysicsComponent, final M47 m47, final boolean b, final boolean b2) {
        if (b) {
            PlayerPhysicsAvatar.s(playerPhysicsComponent.ah, m47);
        }
    }
    
    public static void j(final PlayerPhysicsComponent playerPhysicsComponent, final Vector3 vector3, final boolean b, final boolean b2) {
        if (b) {
            PlayerPhysicsAvatar.h(playerPhysicsComponent.ah, vector3);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getVehicleLeanAngles(final boolean b) {
        return PlayerPhysicsAvatar.r(this.ah);
    }
    
    private static void r(final PlayerPhysicsComponent playerPhysicsComponent) {
        PlayerPhysicsAvatar.q(playerPhysicsComponent.ah);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setLinearVelocity(final Vector3 vector3, final boolean b, final boolean b2) {
        if (this.ap != null) {
            this.ap.d("setLinearVelocity", vector3);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        h(this, vector3, b, b2);
    }
    
    public static void h(final PlayerPhysicsComponent playerPhysicsComponent, final Vector3 h, final boolean b, final boolean b2) {
        if (b && playerPhysicsComponent.ah != null) {
            if (playerPhysicsComponent.ah.q != null) {
                RigidBody.s(playerPhysicsComponent.ah.q, h);
            }
            else if (playerPhysicsComponent.ah.j != null) {
                playerPhysicsComponent.ah.h = h;
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setAngularVelocity(final Vector3 vector3, final boolean b, final boolean b2) {
        if (this.ap != null) {
            this.ap.d("setAngularVelocity", vector3);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        s(this, vector3, b, b2);
    }
    
    public static void s(final PlayerPhysicsComponent playerPhysicsComponent, final Vector3 s, final boolean b, final boolean b2) {
        if (b && playerPhysicsComponent.ah != null) {
            if (playerPhysicsComponent.ah.q != null) {
                RigidBody.b(playerPhysicsComponent.ah.q, s);
            }
            else if (playerPhysicsComponent.ah.j != null) {
                playerPhysicsComponent.ah.s = s;
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float vehicleGetInducedDriftEffect() {
        if (this.ah.b != null) {
            return this.ah.b.v;
        }
        return 1.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans entityRotTransToPhysicsSpace(final RotTrans rotTrans) {
        return rotTrans;
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public String getJointTransformTarget(final int n) {
        return PlayerPhysicsComponent.al[n];
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
    public Vector3 physicsVectorToEntitySpace(final Vector3 vector3) {
        return vector3;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getLinearSpeed(final boolean b) {
        if (this.ah == null) {
            return 0.0f;
        }
        if (this.ah.q != null) {
            return Vector3.f(this.ah.q.l());
        }
        if (this.ah.j != null) {
            return Vector3.f(this.ah.h);
        }
        return 0.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getInclination(final boolean b) {
        final Vector3 al = Vector3.al(Vector3.g(0.0f, 0.0f, 1.0f), this.getOrientation(b));
        return (float)Math.atan2(al.y, (float)Math.sqrt(al.x * al.x + al.z * al.z));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getAngularSpeed(final boolean b) {
        if (this.ah == null) {
            return 0.0f;
        }
        if (this.ah.q != null) {
            return Vector3.f(this.ah.q.w());
        }
        if (this.ah.j != null) {
            return Vector3.f(this.ah.s);
        }
        return 0.0f;
    }
    
    public static void d(final PlayerPhysicsComponent playerPhysicsComponent, final Q7 q7, final boolean b, final boolean b2) {
        if (b) {
            PlayerPhysicsAvatar.e(playerPhysicsComponent.ah, q7);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getAABBMinCorner() {
        if (this.ah.e != null) {
            return this.ah.e.at().j();
        }
        return null;
    }
    
    public static void l(final PlayerPhysicsComponent playerPhysicsComponent) {
        playerPhysicsComponent.am = false;
        r(playerPhysicsComponent);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity[] getEntitiesInSwingArea(final boolean b, final float n, final float n2, final float n3, final float n4, final float n5, @ScriptDefaults(defaultInteger = 100) final int n6) {
        if (this.ah == null || this.ah.e == null) {
            return null;
        }
        return this.ah.d.getEntitiesInSwingArea(Vector3.m(this.ah.getCurrentTransform().g, 0.0f, n3, 0.0f), n, n2, n4, n5, 0.0f, Gn5.PLAYER_VOLUME_QUERY.ordinal(), CollisionObject.ab(this.ah.e), n6);
    }
    
    public PlayerPhysicsComponent(final I187 i187, final ScriptManager ac, final boolean b) {
        this.j = RotTrans.g;
        this.e = Vector3.g;
        this.h = Vector3.g;
        this.b = null;
        this.l = null;
        this.w = null;
        this.r = -1;
        this.v = Vector3.g;
        this.y = Vector3.g;
        this.af = new RotTrans[PlayerPhysicsComponent.al.length];
        this.av = new Scripting$ScriptIDMap();
        this.az = new Scripting$ScriptIDMap();
        this.ah = new PlayerPhysicsAvatar();
        this.ap = null;
        this.ao = false;
        this.aa = new Ag183();
        this.an = Float.NaN;
        this.am = true;
        if (ac == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        g(this, i187);
        this.ac = ac;
        if (this.l.d()) {
            this.q = new M188(b);
        }
        else {
            this.q = null;
        }
        for (int j = 0; j < this.af.length; ++j) {
            this.af[j] = RotTrans.g;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean canJump() {
        return this.ah.j != null && this.ah.j.x();
    }
    
    private static RotTrans x(final PlayerPhysicsComponent playerPhysicsComponent, RotTrans rotTrans, final boolean b) {
        if (rotTrans == null) {
            return null;
        }
        if (playerPhysicsComponent.w != null) {
            final PlayerAvatarDescriptor g = PlayerAvatarDescriptor.g(playerPhysicsComponent.w);
            if (b) {
                rotTrans = PlayerAvatarDescriptor.b(g, rotTrans);
                rotTrans = rotTrans.b(Vector3.al(Vector3.g(0.0f, -PlayerAvatarDescriptor.h(g) / 2.0f, 0.0f), rotTrans.rot));
            }
            final RotTrans r = PlayerAvatarDescriptor.r(g, playerPhysicsComponent.ah);
            if (r != null) {
                final RotTrans p3 = playerPhysicsComponent.j.p(r, 0.1f);
                playerPhysicsComponent.j = p3;
                rotTrans = p3.e(rotTrans);
            }
            else {
                playerPhysicsComponent.j = RotTrans.g;
            }
        }
        rotTrans = rotTrans.s(Gh19.g);
        return rotTrans;
    }
    
    public void u() {
        if (this.ah.d != null && this.q != null) {
            final Vector3 linearVelocity = this.getLinearVelocity(false);
            final Vector3 angularVelocity = this.getAngularVelocity(false);
            final float verticalVelocity = this.getVerticalVelocity();
            U186 u186 = (U186)M188.g(this.q);
            if (u186 == null) {
                u186 = new U186();
            }
            u186.p = linearVelocity;
            u186.x = angularVelocity;
            u186.u = verticalVelocity;
            final PlayerPhysicsAvatar ah = this.ah;
            final RotTrans d = Q7.d(ah.getCurrentTransform());
            u186.g = x(this, d, true);
            if (this.w != null) {
                final PlayerAvatarDescriptor g = PlayerAvatarDescriptor.g(this.w);
                if (g != null && g.d == J93.VEHICLE) {
                    RotTrans g2 = x(this, d.b(Vector3.k(Vector3.al(g.j.bm, u186.g.rot), Vector3.al(new Vector3(0.0f, PlayerAvatarDescriptor.h(g) / 2.0f, 0.0f), u186.g.rot))), true);
                    final Vector3 k = Vector3.k(ah.b.e.l(), ah.b.s);
                    if (g.j.t != 0.0) {
                        final float o = Vector3.o(k, Vector3.al(Vector3.g(1.0f, 0.0f, 0.0f), ah.b.e.ao().d.q()));
                        final float m = g.j.m;
                        final float b = m * o + (1.0f - m) * ah.b.b;
                        ah.b.b = b;
                        float n = g.j.t * b;
                        if (Math.abs(n) > g.j.n) {
                            n *= g.j.n / Math.abs(n);
                        }
                        g2 = g2.h(new RotTrans(Quaternion.j(Vector3.j, -n), Vector3.g));
                    }
                    if (g.j.k != 0.0) {
                        final float o2 = Vector3.o(k, Vector3.al(Vector3.g(0.0f, 0.0f, 1.0f), ah.b.e.ao().d.q()));
                        final float i = g.j.i;
                        final float l = i * o2 + (1.0f - i) * ah.b.l;
                        ah.b.l = l;
                        float n2 = g.j.k * l;
                        if (Math.abs(n2) > g.j.o) {
                            n2 *= g.j.o / Math.abs(n2);
                        }
                        g2 = g2.h(new RotTrans(Quaternion.j(Vector3.d, n2), Vector3.g));
                    }
                    u186.g = g2;
                    u186.e = x(this, Q7.d(PlayerPhysicsAvatar.l(ah, 0)), false);
                    u186.q = x(this, Q7.d(PlayerPhysicsAvatar.b(ah, 0)), false);
                    u186.l = x(this, Q7.d(PlayerPhysicsAvatar.l(ah, 1)), false);
                    u186.s = x(this, Q7.d(PlayerPhysicsAvatar.b(ah, 1)), false);
                    if (g.j.bd != 0.0f) {
                        final Vector3 al = Vector3.al(Vector3.g(0.0f, 0.0f, g.j.bd), u186.g.rot);
                        u186.y = x(this, Q7.d(PlayerPhysicsAvatar.l(ah, 1)), false).b(al);
                        u186.r = x(this, Q7.d(PlayerPhysicsAvatar.b(ah, 1)), false).b(al);
                    }
                    if (BulletVehicle.g(ah.b) > 2) {
                        u186.j = x(this, Q7.d(PlayerPhysicsAvatar.l(ah, 2)), false);
                        u186.d = x(this, Q7.d(PlayerPhysicsAvatar.b(ah, 2)), false);
                        u186.b = x(this, Q7.d(PlayerPhysicsAvatar.l(ah, 3)), false);
                        u186.h = x(this, Q7.d(PlayerPhysicsAvatar.b(ah, 3)), false);
                        if (g.j.bd != 0.0f) {
                            final Vector3 al2 = Vector3.al(Vector3.g(0.0f, 0.0f, g.j.bd), u186.g.rot);
                            u186.v = x(this, Q7.d(PlayerPhysicsAvatar.l(ah, 3)), false).b(al2);
                            u186.w = x(this, Q7.d(PlayerPhysicsAvatar.b(ah, 3)), false).b(al2);
                        }
                    }
                }
            }
            M188.d(this.q, u186);
            u186.z = System.nanoTime();
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setOrientation(final Quaternion quaternion, final boolean b, final boolean b2) {
        if (this.ap != null) {
            this.ap.d("setOrientation", quaternion);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        q(this, quaternion.m(), b, b2);
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public int getJointTransformCount() {
        return this.af.length;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void controlOnWithParameters(@ScriptID final Integer n, final int n2, final float... array) {
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsWorldWrapper getDisplayWorld() {
        return this.ah.d;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float vehicleGetWheelSuspensionCompression(final int n) {
        if (this.ah.b != null) {
            return this.ah.b.h(n);
        }
        return 0.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Integer GetCurrentDescriptor() {
        return m(this, false);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return PlayerPhysicsComponent.at;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVehicleCurveReverseSpeedMultiplier(final float y) {
        if (this.ah.b != null && this.ah.w != null) {
            this.ah.w.y = y;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void clearControl(final String s, @ScriptDefaults(defaultInteger = 0) final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("timestampOffset must be >=0!");
        }
        this.setControl(s, null, n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void clearAllControls(@ScriptDefaults(defaultInteger = 0) final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("timestampOffset must be >=0!");
        }
        if (!this.l.q()) {
            return;
        }
        final GameEntity entity = this.getEntity();
        if (entity == null) {
            throw new RuntimeException("entity is null for PlayerPhysicsComponent");
        }
        if (this.l.d() && GameEntity.ej(entity, "__clientControlStreamMaster") == Boolean.FALSE) {
            throw new IllegalStateException("Can't set client-side controls for other people!");
        }
        final SourceLossyStateStream sourceLossyStateStream = (SourceLossyStateStream)GameEntity.ej(entity, this.l.d() ? "__clientControlStream" : "__serverControlStream");
        if (sourceLossyStateStream != null) {
            final int sumIDs = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(this.l.j(), n);
            final K189 k189 = (K189)sourceLossyStateStream.factory.duplicateState(sourceLossyStateStream.getState(sumIDs));
            k189.g.clear();
            k189.d.clear();
            sourceLossyStateStream.putState(k189, sumIDs);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void flushControls() {
        Lb33.g(Lb33.FlushControls);
        this.getEntity().eh("__PHYSICSFLUSH", null);
        Lb33.d(Lb33.FlushControls);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void characterJumpByHeight(final float f) {
        if (this.ap != null) {
            this.ap.d("characterJumpByHeight", f);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        final PlayerAvatarDescriptor t = t(this, false);
        float n;
        if (t == null) {
            n = (float)Math.sqrt(2.0f * -DiscreteDynamicsWorld.af(this.ah.d.d).y * f);
        }
        else {
            n = (float)Math.sqrt(2.0f * t.w * f);
        }
        this.ah.j.r(n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getWheelEntitySpaceUp() {
        return Vector3.al(Vector3.g(0.0f, 1.0f, 0.0f), this.getOrientation(false));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void controlOff(@ScriptID final Integer n, @ScriptDefaults(defaultInteger = 0) final int n2) {
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void controlNeutral(@ScriptID final Integer n, @ScriptDefaults(defaultInteger = 0) final int n2) {
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void allControlsNeutral(@ScriptDefaults(defaultInteger = 0) final int n) {
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void ignoreControlRaw(@ScriptID final Integer n, final float n2) {
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setDescriptor(final String str) {
        Integer value = null;
        if (str != null) {
            value = StringTools.l(str);
        }
        if (value != null && PlayerAvatarDescriptor.g(value) == null) {
            PlayerPhysicsComponent.logger.error("Attempted to set non-existent player avatar descriptor " + str + " - ignoring", new Ao128());
            return;
        }
        if (!this.l.q()) {
            return;
        }
        PlayerPhysicsComponent.logger.debug("descriptor set to {}", value);
        final GameEntity entity = this.getEntity();
        if (this.l.d() && GameEntity.ej(entity, "__clientControlStreamMaster") == Boolean.FALSE) {
            throw new IllegalStateException("Can't set client-side controls for other people!");
        }
        final SourceLossyStateStream sourceLossyStateStream = (SourceLossyStateStream)GameEntity.ej(entity, this.l.d() ? "__clientControlStream" : "__serverControlStream");
        if (sourceLossyStateStream != null) {
            final int j = this.l.j();
            final K189 k189 = (K189)sourceLossyStateStream.factory.duplicateState(sourceLossyStateStream.getState(j));
            k189.q = value;
            sourceLossyStateStream.putState(k189, j);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void kick(final Vector3 vector3, final float n, @ScriptDefaults(defaultNumber = 1000.0) final float n2, @ScriptDefaults(defaultInteger = 0) final int n3) {
        if (!this.l.q()) {
            return;
        }
        final GameEntity entity = this.getEntity();
        if (n < 0.0f) {
            PlayerPhysicsComponent.logger.warn("Kick(): _decceleration must be >= 0.0f");
        }
        if (this.l.d() && GameEntity.ej(entity, "__clientControlStreamMaster") == Boolean.FALSE) {
            throw new IllegalStateException("Can't set client-side controls for other people!");
        }
        final SourceLossyStateStream sourceLossyStateStream = (SourceLossyStateStream)GameEntity.ej(entity, this.l.d() ? "__clientControlStream" : "__serverControlStream");
        if (sourceLossyStateStream != null) {
            final int sumIDs = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(this.l.j(), n3);
            final K189 k189 = (K189)sourceLossyStateStream.factory.duplicateState(sourceLossyStateStream.getState(sumIDs));
            k189.j = new Av190(vector3, n, sumIDs, n2);
            sourceLossyStateStream.putState(k189, sumIDs);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean IsDescriptorActive(@ScriptID final Integer n) {
        boolean equals;
        if (n == null) {
            equals = (this.w == null);
        }
        else {
            equals = n.equals(this.w);
        }
        return equals;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getPosition(final boolean b) {
        if (this.ah == null) {
            if (++PlayerPhysicsComponent.aw % (int)PlayerPhysicsComponent.ar == 0) {
                PlayerPhysicsComponent.ar *= (float)1.2;
                PlayerPhysicsComponent.logger.debug("GetPosition() returned zero position as there is no avatar. Or a lost lua reference used.");
            }
            return Vector3.g;
        }
        Vector3 an = null;
        if (this.ah.e != null) {
            an = this.ah.e.an();
        }
        if (an == null) {
            if (++PlayerPhysicsComponent.aw % (int)PlayerPhysicsComponent.ar == 0) {
                PlayerPhysicsComponent.ar *= (float)1.2;
                PlayerPhysicsComponent.logger.debug("GetPosition() returned zero position as there is no physics for player. Or a lost lua reference used.");
            }
            return Vector3.g;
        }
        return an;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void controlOn(@ScriptID final Integer n, @ScriptDefaults(defaultInteger = 0) final int n2) {
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setPosition(final Vector3 vector3, final boolean b, final boolean b2) {
        if (this.ap != null) {
            this.ap.d("setPosition", vector3);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        j(this, vector3, b, b2);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVehicleCurveSpeedMultiplier(final float r) {
        if (this.ah.b != null && this.ah.w != null) {
            this.ah.w.r = r;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Quaternion getOrientation(final boolean b) {
        if (this.ah == null) {
            return Quaternion.g;
        }
        Quaternion q = null;
        if (this.ah.e != null) {
            q = this.ah.e.as().q();
        }
        if (q == null) {
            return Quaternion.g;
        }
        return q;
    }
    
    public static void n(final PlayerPhysicsComponent playerPhysicsComponent, final Integer obj, final boolean b, final boolean b2, final int n) {
        if (b) {
            if (playerPhysicsComponent.w == null) {
                if (obj != null) {
                    k(playerPhysicsComponent, obj, false, n);
                }
            }
            else if (!playerPhysicsComponent.w.equals(obj) || playerPhysicsComponent.r != PlayerAvatarDescriptor.d(obj)) {
                k(playerPhysicsComponent, obj, false, n);
            }
        }
    }
    
    private static void k(final PlayerPhysicsComponent playerPhysicsComponent, final Integer w, final boolean b, final int n) {
        Q7 q7 = playerPhysicsComponent.ah.getCurrentTransform();
        if (q7 == null) {
            q7 = v(playerPhysicsComponent, playerPhysicsComponent.w);
        }
        final Vector3 linearVelocity = playerPhysicsComponent.getLinearVelocity(b);
        Vector3 vector3 = playerPhysicsComponent.getAngularVelocity(b);
        final int n2 = (playerPhysicsComponent.ah.e != null) ? CollisionObject.ab(playerPhysicsComponent.ah.e) : Gj16.PLAYER.az;
        PlayerAvatarDescriptor g = null;
        if (!b && playerPhysicsComponent.w != null) {
            g = PlayerAvatarDescriptor.g(playerPhysicsComponent.w);
        }
        PlayerAvatarDescriptor g2 = null;
        if (w != null) {
            g2 = PlayerAvatarDescriptor.g(w);
        }
        if (g != null && g2 != null) {
            final I48 w2 = I48.w(0.0f, (PlayerAvatarDescriptor.h(g2) - PlayerAvatarDescriptor.h(g)) / 2.0f, 0.0f);
            if (g.d == J93.VEHICLE) {
                final float n3 = g.j.x - g.j.f - PlayerAvatarDescriptor.h(g) / 2.0f - Vector3.f(DiscreteDynamicsWorld.af(playerPhysicsComponent.ah.d.d)) / (4.0f * g.j.d) - -g.j.ay.y;
                final I48 i48 = w2;
                i48.e -= n3;
                final I48 i49 = w2;
                i49.j += -g.j.ay.x;
                final I48 i50 = w2;
                i50.h += -g.j.ay.z;
            }
            if (g2.d == J93.VEHICLE) {
                vector3 = Vector3.z(vector3, Vector3.af(Vector3.g(g2.j.be, 0.0f, 0.0f), q7.d));
                final float n4 = g2.j.x - g2.j.f - PlayerAvatarDescriptor.h(g2) / 2.0f - Vector3.f(DiscreteDynamicsWorld.af(playerPhysicsComponent.ah.d.d)) / (4.0f * g2.j.d) - -g2.j.ay.y;
                final I48 i51 = w2;
                i51.e += n4;
                final I48 i52 = w2;
                i52.j -= -g2.j.ay.x;
                final I48 i53 = w2;
                i53.h -= -g2.j.ay.z;
            }
            M47.s(q7.d, w2);
            q7 = q7.h(w2);
            I48.y(w2);
        }
        PlayerPhysicsAvatar.q(playerPhysicsComponent.ah);
        playerPhysicsComponent.w = w;
        if (g2 != null) {
            playerPhysicsComponent.ah.j(playerPhysicsComponent.getEntity(), g2, q7, linearVelocity, vector3, n, n2);
            playerPhysicsComponent.r = PlayerAvatarDescriptor.d(w);
        }
        else {
            playerPhysicsComponent.r = -1;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setInterpolation(float an) {
        if (an > 1.0f) {
            an = 1.0f;
        }
        if (an <= 0.0f) {
            an = Float.NaN;
        }
        this.an = an;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isBike() {
        if (this.w != null) {
            final PlayerAvatarDescriptor g = PlayerAvatarDescriptor.g(this.w);
            if (g != null && !Float.isNaN(g.j.bf)) {
                return true;
            }
        }
        return false;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isVehicle() {
        return this.ah.b != null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVehicleTopSpeed(final float n) {
        if (this.ap != null) {
            this.ap.d("SetVehicleTopSpeed", n);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null && this.ah.w != null) {
            this.ah.w.b = n;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float GetVehicleTopSpeed() {
        if (this.ah.b != null && this.ah.w != null) {
            return this.ah.w.b;
        }
        return 0.0f;
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public RotTrans getJointTransform(final int n) {
        final Z165 z165 = new Z165(this.af[n]);
        if (this.getEntity().v != 0L) {}
        return z165.b();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float GetVehicleTopSpeedInReverse() {
        if (this.ah.b != null && this.ah.w != null) {
            return this.ah.w.l;
        }
        return 0.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setVehicleAccelerator(final float n) {
        if (this.ap != null) {
            this.ap.d("setVehicleAccelerator", n);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.d = n;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVehicleCurveAccelerationMultiplier(final float w) {
        if (this.ah.b != null && this.ah.w != null) {
            this.ah.w.w = w;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float GetVehicleCurveAccelerationMultiplier() {
        if (this.ah.b != null && this.ah.w != null) {
            return this.ah.w.w;
        }
        return 0.0f;
    }
    
    public E181 e(E181 e181, final boolean b) {
        if (this.ah.e == null) {
            return null;
        }
        if (e181 == null) {
            e181 = new E181();
        }
        e181.g = this.ah.e.ao();
        if (this.ah.q != null) {
            e181.d = this.ah.q.l();
            e181.q = this.ah.q.w();
            return e181;
        }
        if (this.ah.j != null) {
            e181.d = this.ah.h.an(this.ah.j.y());
            e181.q = this.ah.s;
            return e181;
        }
        return null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleStopFrictionDissipationReduction() {
        if (this.ap != null) {
            this.ap.d("vehicleStopFrictionDissipationReduction", new Object[0]);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null) {
            this.ah.b.p = 0.0f;
            this.ah.b.x = 0.0f;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float GetVehicleCurveSpeedMultiplier() {
        if (this.ah.b != null && this.ah.w != null) {
            return this.ah.w.r;
        }
        return 0.0f;
    }
    
    public static Integer m(final PlayerPhysicsComponent playerPhysicsComponent, final boolean b) {
        return playerPhysicsComponent.w;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float GetVehicleCurveReverseSpeedMultiplier() {
        if (this.ah.b != null && this.ah.w != null) {
            return this.ah.w.y;
        }
        return 0.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setVehicleSteering(final float n) {
        if (this.ap != null) {
            this.ap.d("setVehicleSteering", n);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.q = n;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getVehicleSteeringAngle() {
        return this.ah.w.j;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public RotTrans getCurrentTransform() {
        return Q7.d(this.ah.getCurrentTransform());
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleSteerRight() {
        if (this.ap != null) {
            this.ap.d("vehicleSteerRight", new Object[0]);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.q = 1.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleBrake(@ScriptDefaults(defaultNumber = 1.0) final double d) {
        if (this.ap != null) {
            this.ap.d("vehicleBrake", d);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.j = Math.abs((float)d);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleHandBrake(@ScriptDefaults(defaultBoolean = true) final boolean b) {
        if (this.ap != null) {
            this.ap.d("vehicleHandBrake", b);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.e = b;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean vehicleGetWheelIsTouchingGround(final int n) {
        return this.ah.b != null && this.ah.b.e(n % BulletVehicle.g(this.ah.b));
    }
    
    public static void p(final PlayerPhysicsComponent playerPhysicsComponent, final int i, final boolean b, final boolean b2, final String s) {
        final boolean b3 = b && !b2;
        final GameEntity entity = playerPhysicsComponent.getEntity();
        y(playerPhysicsComponent, b, b2, i);
        final LossyStateStream lossyStateStream = (LossyStateStream)GameEntity.ej(entity, "__clientControlStream");
        final LossyStateStream lossyStateStream2 = (LossyStateStream)GameEntity.ej(entity, "__serverControlStream");
        K189 k189 = null;
        K189 k190 = null;
        if (lossyStateStream != null) {
            k189 = (K189)lossyStateStream.getState(i);
        }
        if (lossyStateStream2 != null) {
            k190 = (K189)lossyStateStream2.getState(i);
        }
        Av190 av190 = null;
        int n = 0;
        if (playerPhysicsComponent.l.d()) {
            if (k189 != null && k189.j != null) {
                av190 = k189.j;
                n = i;
            }
            else if (k190 != null) {
                av190 = k190.j;
                n = i;
            }
        }
        else if (k190 != null && k190.j != null) {
            av190 = k190.j;
            n = i;
        }
        else if (k189 != null) {
            av190 = k189.j;
            n = i;
        }
        if (playerPhysicsComponent.ah != null && playerPhysicsComponent.ah.d != null) {
            PlayerPhysicsAvatar.v(playerPhysicsComponent.ah, av190, i, n, b3);
        }
        if (playerPhysicsComponent.ah != null && playerPhysicsComponent.ah.d != null) {
            final Q7 currentTransform = playerPhysicsComponent.ah.getCurrentTransform();
            if (currentTransform != null) {
                float ao = playerPhysicsComponent.ah.d.d.ao(currentTransform.g.x, currentTransform.g.z);
                PlayerAvatarDescriptor g = null;
                if (playerPhysicsComponent.w != null) {
                    g = PlayerAvatarDescriptor.g(playerPhysicsComponent.w);
                }
                float y = currentTransform.g.y;
                if (g != null && g.j != null) {
                    y -= g.j.ay.y;
                }
                if (y < ao) {
                    if (playerPhysicsComponent.w != null) {
                        ao += PlayerAvatarDescriptor.h(g);
                    }
                    PlayerPhysicsAvatar.e(playerPhysicsComponent.ah, currentTransform.j(ao + 5.0f));
                }
            }
        }
        if (playerPhysicsComponent.ah != null && playerPhysicsComponent.ah.d != null) {
            PlayerAvatarDescriptor g2 = null;
            if (playerPhysicsComponent.w != null) {
                g2 = PlayerAvatarDescriptor.g(playerPhysicsComponent.w);
            }
            if (g2 != null && playerPhysicsComponent.ah.b != null && g2.j != null) {
                if (!Float.isNaN(g2.j.bf)) {
                    playerPhysicsComponent.ah.w(0.0f, 0.0f, PlayerAvatarDescriptor.v(g2, playerPhysicsComponent.ah));
                    I48.p(playerPhysicsComponent.ah.w.p, 0.0f, 0.0f, 0.0f);
                    playerPhysicsComponent.ah.b.v(playerPhysicsComponent.ah.w.p);
                }
                else {
                    playerPhysicsComponent.ah.w(0.0f, 0.0f, 0.0f);
                }
            }
        }
        if (playerPhysicsComponent.ah != null && playerPhysicsComponent.ah.d != null && playerPhysicsComponent.ah.q != null) {
            playerPhysicsComponent.ah.y = playerPhysicsComponent.ah.q.l();
            playerPhysicsComponent.ah.p = playerPhysicsComponent.ah.q.w();
        }
        if (k189 != null || k190 != null) {
            playerPhysicsComponent.av.clear();
            playerPhysicsComponent.az.clear();
            playerPhysicsComponent.av.putAll(k189.g);
            for (final Map.Entry<Object, V> entry : k189.d.entrySet()) {
                playerPhysicsComponent.az.put(entry.getKey(), LossyStateStream.TIMESTAMP_WIDTH.diffIDs(i, (int)entry.getValue()) * Lq191.d() * 1.0);
            }
            playerPhysicsComponent.av.putAll(k190.g);
            for (final Map.Entry<Object, V> entry2 : k190.d.entrySet()) {
                playerPhysicsComponent.az.put(entry2.getKey(), LossyStateStream.TIMESTAMP_WIDTH.diffIDs(i, (int)entry2.getValue()) * Lq191.d() * 1.0);
            }
            for (int j = 0; j < 2; ++j) {
                final boolean b4 = j == 0;
                if (!b4 || b) {
                    if (b4 || b2) {
                        PlayerAvatarDescriptor g3 = null;
                        if (!b4 && playerPhysicsComponent.w != null) {
                            g3 = PlayerAvatarDescriptor.g(playerPhysicsComponent.w);
                        }
                        if (g3 != null) {
                            Ag183.g(playerPhysicsComponent.aa);
                            playerPhysicsComponent.ap = Y192.d(s, i, entity.bb, playerPhysicsComponent.ah, playerPhysicsComponent.av, PlayerPhysicsComponent.ab);
                            playerPhysicsComponent.ao = true;
                            if (g3.m != null) {
                                g3.m.trigger(entity, new Object[] { i, b4, playerPhysicsComponent.av, playerPhysicsComponent.az });
                            }
                            playerPhysicsComponent.aa.d(playerPhysicsComponent.ah, i, b3, playerPhysicsComponent.ap);
                            playerPhysicsComponent.ao = false;
                            playerPhysicsComponent.ap = null;
                        }
                    }
                }
            }
        }
        if (b2 && playerPhysicsComponent.ah.d != null) {
            if (playerPhysicsComponent.q == null) {
                final RotTrans x = x(playerPhysicsComponent, playerPhysicsComponent.getCurrentTransform(), true);
                if (x != null) {
                    playerPhysicsComponent.getEntity().setWorldTransform(x);
                }
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleStartInducedDrift(final float n, final float f) {
        if (this.ap != null) {
            this.ap.d("vehicleStartInducedDrift", n, f);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null) {
            this.ah.b.v = n;
            this.ah.b.y = (1.0f - n) * DiscreteDynamicsWorld.av(this.ah.b.e.b) / f;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void applyForceAtPoint(final Vector3 vector3, final Vector3 vector4, final boolean b, final boolean b2) {
        if (this.ap != null) {
            this.ap.d("applyForceAtPoint", vector3, vector4);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (b && this.ah.q != null) {
            final Vector3 a = Vector3.a(Vector3.k(vector4, this.ah.q.an()), vector3);
            this.ah.q.r(vector3);
            this.ah.q.v(a);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isControllable() {
        return !this.l.d() || (boolean)GameEntity.ej(this.getEntity(), "__clientControlStreamMaster");
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleStopInducedDrift() {
        if (this.ap != null) {
            this.ap.d("vehicleStopInducedDrift", new Object[0]);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null) {
            this.ah.b.v = 1.0f;
            this.ah.b.y = 0.0f;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleStartLateralFrictionMultiplier(final float n, final float f) {
        if (this.ap != null) {
            this.ap.d("vehicleStartLateralFrictionMultiplier", n, f);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null) {
            this.ah.b.w = n;
            this.ah.b.r = (1.0f - n) * DiscreteDynamicsWorld.av(this.ah.b.e.b) / f;
        }
    }
    
    private static Q7 v(final PlayerPhysicsComponent playerPhysicsComponent, final Integer n) {
        Q7 q7 = Q7.g(playerPhysicsComponent.getEntity().getWorldTransform().q()).s(Gh19.g.m());
        if (n != null) {
            final PlayerAvatarDescriptor g = PlayerAvatarDescriptor.g(n);
            if (g != null) {
                q7 = PlayerAvatarDescriptor.w(g, q7.e(Vector3.af(Vector3.g(0.0f, PlayerAvatarDescriptor.h(g) / 2.0f, 0.0f), q7.d)));
            }
        }
        return q7;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getLinearVelocity(final boolean b) {
        if (this.ah == null) {
            return Vector3.g;
        }
        if (this.ah.q != null) {
            return this.ah.q.l();
        }
        if (this.ah.j != null) {
            return this.ah.h.an(this.ah.j.y());
        }
        return Vector3.g;
    }
    
    public void z() {
        final U186 u186 = (U186)M188.q(this.q);
        if (u186 == null) {
            return;
        }
        U186 u187 = (U186)M188.j(this.q);
        final float l = M188.l(this.q);
        if (M188.s && u187 != null) {
            final long z = u186.z;
            final long z2 = u187.z;
            final long nanoTime = System.nanoTime();
            final long n = (long)(z * (1.0f - l) + z2 * l);
            final long n2 = z / 1000L;
            final long n3 = z2 / 1000L;
            final long n4 = nanoTime / 1000L;
            final long n5 = n / 1000L;
            final long n6 = n2 % 1000000L;
            final long n7 = n3 % 1000000L;
            final long n8 = n4 % 1000000L;
            final long n9 = n5 % 1000000L;
            long n10 = n8 - n9;
            if (n10 < 0L) {
                n10 += 1000000L;
            }
            PlayerPhysicsComponent.logger.debug("Tweening frames: {} ms and {} ms. tweenPos = {} This is eqivalent to {} ms.  Current time = {} ms.  Lag due to tweener = {} ms.", new Object[] { n6 / 1000.0f, n7 / 1000.0f, l, n9 / 1000.0f, n8 / 1000.0f, n10 / 1000.0f });
        }
        RotTrans worldTransform = u186.g;
        if (worldTransform == null) {
            return;
        }
        if (u187 != null) {
            if (u187.g == null) {
                u187 = null;
            }
            else {
                worldTransform = worldTransform.p(u187.g, l);
            }
        }
        else {
            PlayerPhysicsComponent.logger.trace("Ran out of frames");
        }
        this.getEntity().setWorldTransform(worldTransform);
        final RotTrans j = worldTransform.j();
        final float n11 = (this.getEntity().v != 0L) ? (1.0f / StaticModel.getAnimatedSgnScale(this.getEntity().v)) : 1.0f;
        if (this.w != null) {
            final PlayerAvatarDescriptor g = PlayerAvatarDescriptor.g(this.w);
            if (g != null && g.d == J93.VEHICLE && this.af != null) {
                final Quaternion e = Quaternion.e(0.0f, 0.0f, 1.0f, g.j.bq);
                Vector3 vector3 = Vector3.g;
                if (this.af[0] != null) {
                    vector3 = vector3.aa(g.j.u / 2.0f);
                }
                final RotTrans rotTrans = new RotTrans(e, vector3);
                final RotTrans rotTrans2 = new RotTrans(e, Vector3.g);
                final Quaternion e2 = Quaternion.e(0.0f, 0.0f, 1.0f, g.j.bo);
                Vector3 vector4 = Vector3.g;
                if (this.af[1] != null) {
                    vector4 = vector4.aa(-g.j.u / 2.0f);
                }
                final RotTrans rotTrans3 = new RotTrans(e2, vector4);
                final RotTrans rotTrans4 = new RotTrans(e2, Vector3.g);
                final Z165 z3 = new Z165();
                RotTrans i = null;
                if (this.af[0] != null && j != null) {
                    Z165.g(z3, u186.j);
                    if (u187 != null) {
                        Z165.s(z3, u187.j, l);
                    }
                    Z165.e(z3, rotTrans2);
                    final Quaternion e3 = Quaternion.e(1.0f, 0.0f, 0.0f, g.j.bl);
                    final Quaternion e4 = Quaternion.e(0.0f, 1.0f, 0.0f, -g.j.bw);
                    Z165.h(z3, e3);
                    Z165.h(z3, e4);
                    i = z3.b().j();
                    Z165.j(z3, j);
                    final I48 d = z3.d;
                    d.j *= n11;
                    final I48 d2 = z3.d;
                    d2.e *= n11;
                    final I48 d3 = z3.d;
                    d3.h *= n11;
                    this.af[0] = z3.b();
                }
                RotTrans rotTrans5 = null;
                if (this.af[1] != null && j != null) {
                    Z165.g(z3, u186.e);
                    if (u187 != null) {
                        Z165.s(z3, u187.e, l);
                    }
                    Z165.e(z3, rotTrans4);
                    final Quaternion e5 = Quaternion.e(1.0f, 0.0f, 0.0f, g.j.bl);
                    final Quaternion e6 = Quaternion.e(0.0f, 1.0f, 0.0f, g.j.bw);
                    Z165.h(z3, e5);
                    Z165.h(z3, e6);
                    rotTrans5 = z3.b().j();
                    Z165.j(z3, j);
                    final I48 d4 = z3.d;
                    d4.j *= n11;
                    final I48 d5 = z3.d;
                    d5.e *= n11;
                    final I48 d6 = z3.d;
                    d6.h *= n11;
                    this.af[1] = z3.b();
                }
                RotTrans k = null;
                if (this.af[4] != null && j != null) {
                    Z165.g(z3, u186.b);
                    if (u187 != null) {
                        Z165.s(z3, u187.b, l);
                    }
                    Z165.e(z3, rotTrans2);
                    final Quaternion e7 = Quaternion.e(1.0f, 0.0f, 0.0f, g.j.bj);
                    final Quaternion e8 = Quaternion.e(0.0f, 1.0f, 0.0f, -g.j.bk);
                    Z165.h(z3, e7);
                    Z165.h(z3, e8);
                    k = z3.b().j();
                    Z165.j(z3, j);
                    final I48 d7 = z3.d;
                    d7.j *= n11;
                    final I48 d8 = z3.d;
                    d8.e *= n11;
                    final I48 d9 = z3.d;
                    d9.h *= n11;
                    this.af[4] = z3.b();
                }
                RotTrans rotTrans6 = null;
                if (this.af[5] != null && j != null) {
                    Z165.g(z3, u186.l);
                    if (u187 != null) {
                        Z165.s(z3, u187.l, l);
                    }
                    Z165.e(z3, rotTrans4);
                    final Quaternion e9 = Quaternion.e(1.0f, 0.0f, 0.0f, g.j.bj);
                    final Quaternion e10 = Quaternion.e(0.0f, 1.0f, 0.0f, g.j.bk);
                    Z165.h(z3, e9);
                    Z165.h(z3, e10);
                    rotTrans6 = z3.b().j();
                    Z165.j(z3, j);
                    final I48 d10 = z3.d;
                    d10.j *= n11;
                    final I48 d11 = z3.d;
                    d11.e *= n11;
                    final I48 d12 = z3.d;
                    d12.h *= n11;
                    this.af[5] = z3.b();
                }
                RotTrans m = null;
                RotTrans j2 = null;
                if (g.j.bd != 0.0f) {
                    if (this.af[8] != null && j != null) {
                        Z165.g(z3, u186.v);
                        if (u187 != null) {
                            Z165.s(z3, u187.v, l);
                        }
                        Z165.e(z3, rotTrans2);
                        m = z3.b().j();
                        Z165.j(z3, j);
                        final I48 d13 = z3.d;
                        d13.j *= n11;
                        final I48 d14 = z3.d;
                        d14.e *= n11;
                        final I48 d15 = z3.d;
                        d15.h *= n11;
                        this.af[8] = z3.b();
                    }
                    if (this.af[9] != null && j != null) {
                        Z165.g(z3, u186.y);
                        if (u187 != null) {
                            Z165.s(z3, u187.y, l);
                        }
                        Z165.e(z3, rotTrans4);
                        j2 = z3.b().j();
                        Z165.j(z3, j);
                        final I48 d16 = z3.d;
                        d16.j *= n11;
                        final I48 d17 = z3.d;
                        d17.e *= n11;
                        final I48 d18 = z3.d;
                        d18.h *= n11;
                        this.af[9] = z3.b();
                    }
                }
                if (this.af[2] != null && i != null) {
                    Z165.g(z3, u186.d);
                    if (u187 != null) {
                        Z165.s(z3, u187.d, l);
                    }
                    Z165.e(z3, rotTrans);
                    Z165.j(z3, i);
                    final I48 d19 = z3.d;
                    d19.j *= n11;
                    final I48 d20 = z3.d;
                    d20.e *= n11;
                    final I48 d21 = z3.d;
                    d21.h *= n11;
                    this.af[2] = z3.b();
                }
                if (this.af[3] != null && rotTrans5 != null) {
                    Z165.g(z3, u186.q);
                    if (u187 != null) {
                        Z165.s(z3, u187.q, l);
                    }
                    Z165.e(z3, rotTrans3);
                    Z165.j(z3, rotTrans5);
                    final I48 d22 = z3.d;
                    d22.j *= n11;
                    final I48 d23 = z3.d;
                    d23.e *= n11;
                    final I48 d24 = z3.d;
                    d24.h *= n11;
                    this.af[3] = z3.b();
                }
                if (this.af[6] != null && k != null) {
                    Z165.g(z3, u186.h);
                    if (u187 != null) {
                        Z165.s(z3, u187.h, l);
                    }
                    Z165.e(z3, rotTrans);
                    Z165.j(z3, k);
                    final I48 d25 = z3.d;
                    d25.j *= n11;
                    final I48 d26 = z3.d;
                    d26.e *= n11;
                    final I48 d27 = z3.d;
                    d27.h *= n11;
                    this.af[6] = z3.b();
                }
                if (this.af[7] != null && rotTrans6 != null) {
                    Z165.g(z3, u186.s);
                    if (u187 != null) {
                        Z165.s(z3, u187.s, l);
                    }
                    Z165.e(z3, rotTrans3);
                    Z165.j(z3, rotTrans6);
                    final I48 d28 = z3.d;
                    d28.j *= n11;
                    final I48 d29 = z3.d;
                    d29.e *= n11;
                    final I48 d30 = z3.d;
                    d30.h *= n11;
                    this.af[7] = z3.b();
                }
                if (g.j.bd != 0.0f) {
                    if (this.af[10] != null && m != null) {
                        Z165.g(z3, u186.w);
                        if (u187 != null) {
                            Z165.s(z3, u187.w, l);
                        }
                        Z165.e(z3, rotTrans);
                        Z165.j(z3, m);
                        final I48 d31 = z3.d;
                        d31.j *= n11;
                        final I48 d32 = z3.d;
                        d32.e *= n11;
                        final I48 d33 = z3.d;
                        d33.h *= n11;
                        this.af[10] = z3.b();
                    }
                    if (this.af[11] != null && j2 != null) {
                        Z165.g(z3, u186.r);
                        if (u187 != null) {
                            Z165.s(z3, u187.r, l);
                        }
                        Z165.e(z3, rotTrans3);
                        Z165.j(z3, j2);
                        final I48 d34 = z3.d;
                        d34.j *= n11;
                        final I48 d35 = z3.d;
                        d35.e *= n11;
                        final I48 d36 = z3.d;
                        d36.h *= n11;
                        this.af[11] = z3.b();
                    }
                }
                if (this.af[12] != null && j != null) {
                    Z165.g(z3, u186.e);
                    if (u187 != null) {
                        Z165.s(z3, u187.e, l);
                    }
                    final Quaternion e11 = Quaternion.e(1.0f, 0.0f, 0.0f, g.j.bl);
                    final Quaternion e12 = Quaternion.e(0.0f, 1.0f, 0.0f, g.j.bw);
                    Z165.h(z3, e11);
                    Z165.h(z3, e12);
                    rotTrans5 = z3.b().j();
                    Z165.j(z3, j);
                    final I48 d37 = z3.d;
                    d37.j *= n11;
                    final I48 d38 = z3.d;
                    d38.e *= n11;
                    final I48 d39 = z3.d;
                    d39.h *= n11;
                    this.af[12] = z3.b();
                }
                if (this.af[13] != null && j != null) {
                    Z165.g(z3, u186.l);
                    if (u187 != null) {
                        Z165.s(z3, u187.l, l);
                    }
                    final Quaternion e13 = Quaternion.e(1.0f, 0.0f, 0.0f, g.j.bj);
                    final Quaternion e14 = Quaternion.e(0.0f, 1.0f, 0.0f, g.j.bk);
                    Z165.h(z3, e13);
                    Z165.h(z3, e14);
                    rotTrans6 = z3.b().j();
                    Z165.j(z3, j);
                    final I48 d40 = z3.d;
                    d40.j *= n11;
                    final I48 d41 = z3.d;
                    d41.e *= n11;
                    final I48 d42 = z3.d;
                    d42.h *= n11;
                    this.af[13] = z3.b();
                }
                if (this.af[14] != null && rotTrans5 != null) {
                    Z165.g(z3, u186.q);
                    if (u187 != null) {
                        Z165.s(z3, u187.q, l);
                    }
                    Z165.e(z3, rotTrans3);
                    Z165.j(z3, rotTrans5);
                    final I48 d43 = z3.d;
                    d43.j *= n11;
                    final I48 d44 = z3.d;
                    d44.e *= n11;
                    final I48 d45 = z3.d;
                    d45.h *= n11;
                    this.af[14] = z3.b();
                }
                if (this.af[15] != null && rotTrans6 != null) {
                    Z165.g(z3, u186.s);
                    if (u187 != null) {
                        Z165.s(z3, u187.s, l);
                    }
                    Z165.e(z3, rotTrans3);
                    Z165.j(z3, rotTrans6);
                    final I48 d46 = z3.d;
                    d46.j *= n11;
                    final I48 d47 = z3.d;
                    d47.e *= n11;
                    final I48 d48 = z3.d;
                    d48.h *= n11;
                    this.af[15] = z3.b();
                }
            }
        }
        Vector3 e15 = u186.p;
        if (u187 != null) {
            e15 = Vector3.av(e15, u187.p, l);
        }
        this.e = e15;
        Vector3 h = u186.x;
        if (u187 != null) {
            h = Vector3.av(h, u187.x, l);
        }
        this.h = h;
        final Vector3 ao = Vector3.al(e15, SceneGraphNode.v(this.getEntity()).rot).ao();
        float u188 = u186.u;
        if (u187 != null) {
            u188 += (u187.u - u188) * l;
        }
        this.getEntity().setProperty("LinearVelocity", ao);
        this.getEntity().setProperty("AngularVelocity", h);
        this.getEntity().setProperty("VerticalVelocity", u188);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float vehicleGetWheelSlipStatus(final int n) {
        if (this.ah.b != null) {
            return this.ah.b.s(n);
        }
        return 0.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getAABBMaxCorner() {
        if (this.ah.e != null) {
            return this.ah.e.at().e();
        }
        return null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 vehicleGetWheelContactPatchPosition(final int n) {
        if (this.ah.b != null) {
            return BulletVehicle.l(this.ah.b, n);
        }
        return new Vector3(0.0f, 0.0f, 0.0f);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void resetOrientation() {
        if (this.ap != null) {
            this.ap.d("resetOrientation", new Object[0]);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.e != null) {
            this.ah.e.ac(M47.g);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float characterGetContactPatchHeight() {
        float y = 0.0f;
        if (this.ah.j != null) {
            y = this.ah.j.at().j().y;
        }
        return y;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setCharacterTurnSpeed(final float n) {
        if (this.ap != null) {
            this.ap.d("setCharacterTurnSpeed", n);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.h = true;
        this.aa.b = n;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setCharacterSpeed(final float f, final float f2, final float f3) {
        if (this.ap != null) {
            this.ap.d("setCharacterSpeed", f, f2, f3);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.h = true;
        this.aa.s = new Vector3(f, f2, f3);
        this.ah.h = Vector3.af(this.aa.s, this.ah.j.as());
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void characterJump(final float f) {
        if (this.ap != null) {
            this.ap.d("characterJump", f);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.ah.j.r(f);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 entityVectorToPhysicsSpace(final Vector3 vector3) {
        return vector3;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Aq193 getLandingPrediction(final float n) {
        if (this.ah.j == null || !this.ah.j.p()) {
            return null;
        }
        final D194 d194 = new D194();
        if (this.ah.j.u(d194, n)) {
            final Aq193 aq193 = new Aq193();
            aq193.g = d194.g;
            aq193.d = d194.d;
            aq193.q = d194.q;
            aq193.j = d194.j;
            aq193.e = ((d194.e >= 0) ? ((CollisionObjectData)this.ah.j.b.ap(d194.e)).d : null);
            return aq193;
        }
        return null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getHeading(final boolean b) {
        final Vector3 al = Vector3.al(Vector3.g(0.0f, 0.0f, 1.0f), this.getOrientation(b));
        return (float)Math.atan2(al.x, al.z);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean canTransformTo(@ScriptID final Integer n, @ScriptDefaults(defaultNumber = -0.1) final float n2, @ScriptDefaults(defaultInteger = 0) int n3, @ScriptDefaults(defaultInteger = 0) final int n4) {
        final PlayerAvatarDescriptor g = PlayerAvatarDescriptor.g(n);
        if (g == null) {
            PlayerPhysicsComponent.logger.warn("canTransformTo(): could not find the descriptor in the library");
            return true;
        }
        final PlayerPhysicsAvatar avatar = this.getAvatar(false);
        if (avatar == null) {
            PlayerPhysicsComponent.logger.warn("canTransformTo(): could not find the avatar for the descriptor. The physics reperesentation hasn't been created yet.");
            return true;
        }
        if (n3 == 0) {
            if (PlayerAvatarDescriptor.IsCharacterController(n)) {
                n3 = Gn5.PLAYER_AS_ROBOT.ordinal();
            }
            else if (PlayerAvatarDescriptor.IsVehicle(n)) {
                n3 = Gn5.PLAYER_AS_CAR.ordinal();
            }
        }
        final E6 e = g.e(avatar.d.d);
        final List al = avatar.d.d.al(e, v(this, n), n3, n4, null, 20);
        if (al.size() == 20) {
            return false;
        }
        avatar.d.d.t(e);
        for (final L8 l8 : al) {
            final Iterator<L8> iterator2 = al.iterator();
            while (iterator2.hasNext()) {
                if (Vector3.o(l8.q, iterator2.next().q) < n2) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsWorldWrapper getPhysicsWorld(final boolean b) {
        if (this.ah == null) {
            return null;
        }
        return this.ah.d;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getAngularVelocity(final boolean b) {
        if (this.ah == null) {
            return Vector3.g;
        }
        if (this.ah.q != null) {
            return this.ah.q.w();
        }
        if (this.ah.j != null) {
            return this.ah.s;
        }
        return Vector3.g;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getVerticalVelocity() {
        if (this.ah.j != null) {
            return this.ah.j.y();
        }
        return 0.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isCharacter() {
        return this.ah.j != null;
    }
    
    public void i(final int n, final boolean b) {
        if (!this.l.d()) {
            throw new IllegalArgumentException("Only on client");
        }
        o(this, n, b);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getWheelEntitySpacePos(final int n) {
        return this.vehicleGetWheelContactPatchPosition(n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float vehicleGetLateralFrictionMultiplier() {
        if (this.ah.b != null) {
            return this.ah.b.w;
        }
        return 1.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getWheelEntitySpaceFront() {
        return Vector3.al(Vector3.g(0.0f, 0.0f, 1.0f), this.getOrientation(false));
    }
    
    private static void o(final PlayerPhysicsComponent playerPhysicsComponent, final int n, final boolean b) {
        if (playerPhysicsComponent.ah.x != -1) {
            playerPhysicsComponent.ac.runRaw("tyreTrackDecal", playerPhysicsComponent.getEntity(), b, playerPhysicsComponent.ah.x);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getCollisionMask(@ScriptDefaults(defaultBoolean = false) final boolean b) {
        if (this.ah == null || this.ah.e == null) {
            throw new RuntimeException(String.format("PlayerPhysicsComponent%s PlayerPhysicsAvatar%s was null.", b ? " master" : "", (this.ah != null) ? " CollisionObject" : ""));
        }
        return CollisionObject.ab(this.ah.e);
    }
    
    public static void w(final PlayerPhysicsComponent playerPhysicsComponent) {
        playerPhysicsComponent.am = true;
        r(playerPhysicsComponent);
    }
    
    public static E41 b(final PlayerPhysicsComponent playerPhysicsComponent) {
        if (playerPhysicsComponent.ah.e != null) {
            return playerPhysicsComponent.ah.e.at();
        }
        return null;
    }
    
    static {
        logger = LoggerFactory.getLogger(PlayerPhysicsComponent.class);
        PlayerPhysicsComponent.d = true;
        al = new String[] { "T_lFrontSuspensionJ", "T_rFrontSuspensionJ", "T_lFrontWheelJ", "T_rFrontWheelJ", "T_lRearSuspensionJ", "T_rRearSuspensionJ", "T_lRearWheelJ", "T_rRearWheelJ", "T_lMidSuspensionJ", "T_rMidSuspensionJ", "T_lMidWheelJ", "T_rMidWheelJ", "T_FrontSuspensionJ", "T_RearSuspensionJ", "T_FrontWheelJ", "T_RearWheelJ" };
        PlayerPhysicsComponent.as = false;
        at = StringTools.l(PlayerPhysicsComponent.class.getName());
        ab = new HashMap();
        PlayerPhysicsComponent.aw = 0;
        PlayerPhysicsComponent.ar = 1.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleStartFrictionDissipationReduction(final float n, final float f) {
        if (this.ap != null) {
            this.ap.d("vehicleStartFrictionDissipationReduction", n, f);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null) {
            this.ah.b.p = n;
            this.ah.b.x = -n * DiscreteDynamicsWorld.av(this.ah.b.e.b) / f;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float vehicleGetWheelSlipSpeed(final int n) {
        if (this.ah.b != null) {
            return this.ah.b.b(n);
        }
        return 0.0f;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVehicleTopSpeedInReverse(final float n) {
        if (this.ap != null) {
            this.ap.d("SetVehicleTopSpeedInReverse", n);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null && this.ah.w != null) {
            this.ah.w.l = n;
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isTouchingGround() {
        if (this.ah.j != null) {
            return this.ah.j.p();
        }
        if (this.ah.b == null) {
            return false;
        }
        if (BulletVehicle.g(this.ah.b) == 4) {
            return this.ah.b.e(0) || this.ah.b.e(1) || this.ah.b.e(2) || this.ah.b.e(3);
        }
        return BulletVehicle.g(this.ah.b) == 2 && (this.ah.b.e(0) || this.ah.b.e(1));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleSteerLeft() {
        if (this.ap != null) {
            this.ap.d("vehicleSteerLeft", new Object[0]);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.q = -1.0f;
    }
    
    public static PlayerAvatarDescriptor t(final PlayerPhysicsComponent playerPhysicsComponent, final boolean b) {
        final Integer m = m(playerPhysicsComponent, b);
        if (m == null) {
            return null;
        }
        return PlayerAvatarDescriptor.g(m);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleStopLateralFrictionMultiplier() {
        if (this.ap != null) {
            this.ap.d("vehicleStopLateralFrictionMultiplier", new Object[0]);
        }
        if (!this.ao) {
            PlayerPhysicsComponent.logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null) {
            this.ah.b.w = 1.0f;
            this.ah.b.r = 0.0f;
        }
    }
    
    public static void y(final PlayerPhysicsComponent playerPhysicsComponent, final boolean b, final boolean b2, final int n) {
        final GameEntity entity = playerPhysicsComponent.getEntity();
        if (!playerPhysicsComponent.am) {
            r(playerPhysicsComponent);
            return;
        }
        final ScaleRotTrans worldTransform = entity.getWorldTransform();
        if (b2) {
            final PhysicsWorldWrapper g = playerPhysicsComponent.l.g(worldTransform.trans);
            if (g != playerPhysicsComponent.ah.d || !PlayerPhysicsAvatar.d(playerPhysicsComponent.ah)) {
                final Q7 v = v(playerPhysicsComponent, playerPhysicsComponent.w);
                final Vector3 y = playerPhysicsComponent.ah.y;
                final Vector3 p4 = playerPhysicsComponent.ah.p;
                int n2 = Gj16.PLAYER.az;
                if (playerPhysicsComponent.ah.e != null) {
                    n2 = CollisionObject.ab(playerPhysicsComponent.ah.e);
                }
                PlayerPhysicsAvatar.q(playerPhysicsComponent.ah);
                playerPhysicsComponent.ah.d = g;
                if (playerPhysicsComponent.w != null && playerPhysicsComponent.ah.d != null) {
                    playerPhysicsComponent.ah.j(entity, PlayerAvatarDescriptor.g(playerPhysicsComponent.w), v, y, p4, n, n2);
                }
            }
        }
        final LossyStateStream lossyStateStream = (LossyStateStream)GameEntity.ej(entity, "__clientControlStream");
        final LossyStateStream lossyStateStream2 = (LossyStateStream)GameEntity.ej(entity, "__serverControlStream");
        K189 k189 = null;
        K189 k190 = null;
        if (lossyStateStream != null) {
            k189 = (K189)lossyStateStream.getState(n);
        }
        if (lossyStateStream2 != null) {
            k190 = (K189)lossyStateStream2.getState(n);
        }
        Integer n3 = null;
        if (playerPhysicsComponent.l.d()) {
            if (k189 != null && k189.q != null) {
                n3 = k189.q;
            }
            else if (k190 != null) {
                n3 = k190.q;
            }
        }
        else if (k190 != null && k190.q != null) {
            n3 = k190.q;
        }
        else if (k189 != null) {
            n3 = k189.q;
        }
        if (b2 && n3 != null && (!n3.equals(playerPhysicsComponent.w) || playerPhysicsComponent.r != PlayerAvatarDescriptor.d(playerPhysicsComponent.w))) {
            final PlayerAvatarDescriptor g2 = PlayerAvatarDescriptor.g(n3);
            if (g2 != null && g2.n != null) {
                g2.n.trigger(entity, null);
            }
        }
        n(playerPhysicsComponent, n3, b2, false, n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setControl(final String s, final Object obj, @ScriptDefaults(defaultInteger = 0) final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("timestampOffset must be >=0!");
        }
        final int l = StringTools.l(s);
        PlayerPhysicsComponent.ab.put(l, s);
        if (!this.l.q()) {
            return;
        }
        final GameEntity entity = this.getEntity();
        if (entity == null) {
            throw new RuntimeException("entity is null for PlayerPhysicsComponent");
        }
        if (this.l.d() && GameEntity.ej(entity, "__clientControlStreamMaster") == Boolean.FALSE) {
            throw new IllegalStateException("Can't set client-side controls for other people!");
        }
        final SourceLossyStateStream sourceLossyStateStream = (SourceLossyStateStream)GameEntity.ej(entity, this.l.d() ? "__clientControlStream" : "__serverControlStream");
        if (sourceLossyStateStream != null) {
            final int sumIDs = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(this.l.j(), n);
            final K189 k189 = (K189)sourceLossyStateStream.getState(sumIDs);
            final Object value = k189.g.get(l);
            if (value == null) {
                if (obj == null) {
                    return;
                }
            }
            else if (value.equals(obj)) {
                return;
            }
            final K189 k190 = (K189)sourceLossyStateStream.factory.duplicateState(k189);
            if (obj == null) {
                k190.g.remove(l);
                k190.d.remove(l);
            }
            else {
                k190.g.put(l, obj);
                k190.d.put(l, sumIDs);
            }
            sourceLossyStateStream.putState(k190, sumIDs);
        }
    }
}
