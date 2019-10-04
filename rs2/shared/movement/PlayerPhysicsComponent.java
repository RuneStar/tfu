/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.SourceLossyStateStream;
import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.Scripting$ScriptIDMap;
import com.jagex.jnibindings.runetek6.StaticModel;
import com.jagex.jnibindings.runetek6.jagbullet.B45;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.jagbullet.CharacterController;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.D194;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.B164;
import com.jagex.maths.E41;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import com.jagex.maths.Z165;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.shared.movement.Ag183;
import rs2.shared.movement.Aq193;
import rs2.shared.movement.Av190;
import rs2.shared.movement.C184;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.E181;
import rs2.shared.movement.I187;
import rs2.shared.movement.J93;
import rs2.shared.movement.K189;
import rs2.shared.movement.M188;
import rs2.shared.movement.P185;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerAvatarDescriptor;
import rs2.shared.movement.PlayerPhysicsAvatar;
import rs2.shared.movement.U186;
import rs2.shared.movement.Y192;
import tfu.Ao128;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gh19;
import tfu.Gj16;
import tfu.Gn5;
import tfu.Lb33;
import tfu.Lq191;

@ScriptEntryClass
public class PlayerPhysicsComponent
extends Component {
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
    public boolean am = true;
    public float an = Float.NaN;
    private boolean ao = false;
    private C184 ap = null;
    private Map av;
    private Map az;
    U186 b = null;
    public Vector3 e;
    public Vector3 h;
    private RotTrans j = RotTrans.g;
    private I187 l = null;
    public final M188 q;
    private int r = -1;
    final boolean s = true;
    private Vector3 v;
    private Integer w = null;
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

    public static void g(PlayerPhysicsComponent playerPhysicsComponent, I187 i187) {
        playerPhysicsComponent.l = i187;
        PlayerPhysicsAvatar.g(playerPhysicsComponent.ah, i187);
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
    public PlayerPhysicsAvatar getAvatar(boolean bl) {
        return this.ah;
    }

    public static void q(PlayerPhysicsComponent playerPhysicsComponent, M47 m47, boolean bl, boolean bl2) {
        if (bl) {
            PlayerPhysicsAvatar.s(playerPhysicsComponent.ah, m47);
        }
    }

    public static void j(PlayerPhysicsComponent playerPhysicsComponent, Vector3 vector3, boolean bl, boolean bl2) {
        if (bl) {
            PlayerPhysicsAvatar.h(playerPhysicsComponent.ah, vector3);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getVehicleLeanAngles(boolean bl) {
        return PlayerPhysicsAvatar.r(this.ah);
    }

    private static void r(PlayerPhysicsComponent playerPhysicsComponent) {
        PlayerPhysicsAvatar.q(playerPhysicsComponent.ah);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setLinearVelocity(Vector3 vector3, boolean bl, boolean bl2) {
        if (this.ap != null) {
            this.ap.d("setLinearVelocity", vector3);
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        PlayerPhysicsComponent.h(this, vector3, bl, bl2);
    }

    public static void h(PlayerPhysicsComponent playerPhysicsComponent, Vector3 vector3, boolean bl, boolean bl2) {
        if (bl && playerPhysicsComponent.ah != null) {
            if (playerPhysicsComponent.ah.q != null) {
                RigidBody.s(playerPhysicsComponent.ah.q, vector3);
            } else if (playerPhysicsComponent.ah.j != null) {
                playerPhysicsComponent.ah.h = vector3;
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setAngularVelocity(Vector3 vector3, boolean bl, boolean bl2) {
        if (this.ap != null) {
            this.ap.d("setAngularVelocity", vector3);
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        PlayerPhysicsComponent.s(this, vector3, bl, bl2);
    }

    public static void s(PlayerPhysicsComponent playerPhysicsComponent, Vector3 vector3, boolean bl, boolean bl2) {
        if (bl && playerPhysicsComponent.ah != null) {
            if (playerPhysicsComponent.ah.q != null) {
                RigidBody.b(playerPhysicsComponent.ah.q, vector3);
            } else if (playerPhysicsComponent.ah.j != null) {
                playerPhysicsComponent.ah.s = vector3;
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
    public RotTrans entityRotTransToPhysicsSpace(RotTrans rotTrans) {
        return rotTrans;
    }

    @ScriptEntryPoint
    @Bs1
    @Be2
    public String getJointTransformTarget(int n) {
        return al[n];
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
    public Vector3 physicsVectorToEntitySpace(Vector3 vector3) {
        return vector3;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getLinearSpeed(boolean bl) {
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
    public float getInclination(boolean bl) {
        Quaternion quaternion = this.getOrientation(bl);
        Vector3 vector3 = Vector3.al(Vector3.g(0.0f, 0.0f, 1.0f), quaternion);
        return (float)Math.atan2(vector3.y, (float)Math.sqrt(vector3.x * vector3.x + vector3.z * vector3.z));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getAngularSpeed(boolean bl) {
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

    public static void d(PlayerPhysicsComponent playerPhysicsComponent, Q7 q7, boolean bl, boolean bl2) {
        if (bl) {
            PlayerPhysicsAvatar.e(playerPhysicsComponent.ah, q7);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getAABBMinCorner() {
        if (this.ah.e != null) {
            E41 e41 = this.ah.e.at();
            return e41.j();
        }
        return null;
    }

    public static void l(PlayerPhysicsComponent playerPhysicsComponent) {
        playerPhysicsComponent.am = false;
        PlayerPhysicsComponent.r(playerPhysicsComponent);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public GameEntity[] getEntitiesInSwingArea(boolean bl, float f, float f2, float f3, float f4, float f5, @ScriptDefaults(defaultInteger=100) int n) {
        if (this.ah == null || this.ah.e == null) {
            return null;
        }
        Q7 q7 = this.ah.getCurrentTransform();
        return this.ah.d.getEntitiesInSwingArea(Vector3.m(q7.g, 0.0f, f3, 0.0f), f, f2, f4, f5, 0.0f, Gn5.PLAYER_VOLUME_QUERY.ordinal(), CollisionObject.ab(this.ah.e), n);
    }

    public PlayerPhysicsComponent(I187 i187, ScriptManager scriptManager, boolean bl) {
        this.e = Vector3.g;
        this.h = Vector3.g;
        this.v = Vector3.g;
        this.y = Vector3.g;
        this.af = new RotTrans[al.length];
        this.av = new Scripting$ScriptIDMap();
        this.az = new Scripting$ScriptIDMap();
        this.ah = new PlayerPhysicsAvatar();
        this.aa = new Ag183();
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        PlayerPhysicsComponent.g(this, i187);
        this.ac = scriptManager;
        this.q = this.l.d() ? new M188(bl) : null;
        for (int i = 0; i < this.af.length; ++i) {
            this.af[i] = RotTrans.g;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean canJump() {
        if (this.ah.j != null) {
            return this.ah.j.x();
        }
        return false;
    }

    private static RotTrans x(PlayerPhysicsComponent playerPhysicsComponent, RotTrans rotTrans, boolean bl) {
        if (rotTrans == null) {
            return null;
        }
        if (playerPhysicsComponent.w != null) {
            B164 b164;
            PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.g(playerPhysicsComponent.w);
            if (bl) {
                rotTrans = PlayerAvatarDescriptor.b(playerAvatarDescriptor, rotTrans);
                b164 = Vector3.al(Vector3.g(0.0f, -PlayerAvatarDescriptor.h(playerAvatarDescriptor) / 2.0f, 0.0f), rotTrans.rot);
                rotTrans = rotTrans.b((Vector3)b164);
            }
            if ((b164 = PlayerAvatarDescriptor.r(playerAvatarDescriptor, playerPhysicsComponent.ah)) != null) {
                b164 = playerPhysicsComponent.j.p((RotTrans)b164, 0.1f);
                playerPhysicsComponent.j = b164;
                rotTrans = ((RotTrans)b164).e(rotTrans);
            } else {
                playerPhysicsComponent.j = RotTrans.g;
            }
        }
        rotTrans = rotTrans.s(Gh19.g);
        return rotTrans;
    }

    public void u() {
        if (this.ah.d != null && this.q != null) {
            PlayerAvatarDescriptor playerAvatarDescriptor;
            Vector3 vector3 = this.getLinearVelocity(false);
            Vector3 vector32 = this.getAngularVelocity(false);
            float f = this.getVerticalVelocity();
            U186 u186 = (U186)M188.g(this.q);
            if (u186 == null) {
                u186 = new U186();
            }
            u186.p = vector3;
            u186.x = vector32;
            u186.u = f;
            PlayerPhysicsAvatar playerPhysicsAvatar = this.ah;
            RotTrans rotTrans = Q7.d(playerPhysicsAvatar.getCurrentTransform());
            u186.g = PlayerPhysicsComponent.x(this, rotTrans, true);
            if (this.w != null && (playerAvatarDescriptor = PlayerAvatarDescriptor.g(this.w)) != null && playerAvatarDescriptor.d == J93.VEHICLE) {
                float f2;
                float f3;
                Quaternion quaternion;
                Vector3 vector33;
                float f4;
                RotTrans rotTrans2;
                B164 b164;
                Vector3 vector34 = Vector3.al(playerAvatarDescriptor.j.bm, u186.g.rot);
                vector34 = Vector3.k(vector34, Vector3.al(new Vector3(0.0f, PlayerAvatarDescriptor.h(playerAvatarDescriptor) / 2.0f, 0.0f), u186.g.rot));
                RotTrans rotTrans3 = PlayerPhysicsComponent.x(this, rotTrans.b(vector34), true);
                Vector3 vector35 = Vector3.k(playerPhysicsAvatar.b.e.l(), playerPhysicsAvatar.b.s);
                if ((double)playerAvatarDescriptor.j.t != 0.0) {
                    b164 = playerPhysicsAvatar.b.e.ao().d.q();
                    vector33 = Vector3.al(Vector3.g(1.0f, 0.0f, 0.0f), b164);
                    f4 = Vector3.o(vector35, vector33);
                    f3 = playerAvatarDescriptor.j.m;
                    playerPhysicsAvatar.b.b = f4 = f3 * f4 + (1.0f - f3) * playerPhysicsAvatar.b.b;
                    f2 = playerAvatarDescriptor.j.t * f4;
                    if (Math.abs(f2) > playerAvatarDescriptor.j.n) {
                        f2 *= playerAvatarDescriptor.j.n / Math.abs(f2);
                    }
                    quaternion = Quaternion.j(Vector3.j, -f2);
                    rotTrans2 = new RotTrans(quaternion, Vector3.g);
                    rotTrans3 = rotTrans3.h(rotTrans2);
                }
                if ((double)playerAvatarDescriptor.j.k != 0.0) {
                    b164 = playerPhysicsAvatar.b.e.ao().d.q();
                    vector33 = Vector3.al(Vector3.g(0.0f, 0.0f, 1.0f), b164);
                    f4 = Vector3.o(vector35, vector33);
                    f3 = playerAvatarDescriptor.j.i;
                    playerPhysicsAvatar.b.l = f4 = f3 * f4 + (1.0f - f3) * playerPhysicsAvatar.b.l;
                    f2 = playerAvatarDescriptor.j.k * f4;
                    if (Math.abs(f2) > playerAvatarDescriptor.j.o) {
                        f2 *= playerAvatarDescriptor.j.o / Math.abs(f2);
                    }
                    quaternion = Quaternion.j(Vector3.d, f2);
                    rotTrans2 = new RotTrans(quaternion, Vector3.g);
                    rotTrans3 = rotTrans3.h(rotTrans2);
                }
                u186.g = rotTrans3;
                u186.e = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.l(playerPhysicsAvatar, 0)), false);
                u186.q = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.b(playerPhysicsAvatar, 0)), false);
                u186.l = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.l(playerPhysicsAvatar, 1)), false);
                u186.s = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.b(playerPhysicsAvatar, 1)), false);
                if (playerAvatarDescriptor.j.bd != 0.0f) {
                    b164 = Vector3.g(0.0f, 0.0f, playerAvatarDescriptor.j.bd);
                    vector33 = Vector3.al((Vector3)b164, u186.g.rot);
                    u186.y = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.l(playerPhysicsAvatar, 1)), false).b(vector33);
                    u186.r = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.b(playerPhysicsAvatar, 1)), false).b(vector33);
                }
                if (BulletVehicle.g(playerPhysicsAvatar.b) > 2) {
                    u186.j = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.l(playerPhysicsAvatar, 2)), false);
                    u186.d = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.b(playerPhysicsAvatar, 2)), false);
                    u186.b = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.l(playerPhysicsAvatar, 3)), false);
                    u186.h = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.b(playerPhysicsAvatar, 3)), false);
                    if (playerAvatarDescriptor.j.bd != 0.0f) {
                        b164 = Vector3.g(0.0f, 0.0f, playerAvatarDescriptor.j.bd);
                        vector33 = Vector3.al((Vector3)b164, u186.g.rot);
                        u186.v = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.l(playerPhysicsAvatar, 3)), false).b(vector33);
                        u186.w = PlayerPhysicsComponent.x(this, Q7.d(PlayerPhysicsAvatar.b(playerPhysicsAvatar, 3)), false).b(vector33);
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
    public void setOrientation(Quaternion quaternion, boolean bl, boolean bl2) {
        if (this.ap != null) {
            this.ap.d("setOrientation", quaternion);
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        PlayerPhysicsComponent.q(this, quaternion.m(), bl, bl2);
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
    public void controlOnWithParameters(@ScriptID Integer n, int n2, float ... arrf) {
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
    public float vehicleGetWheelSuspensionCompression(int n) {
        if (this.ah.b != null) {
            return this.ah.b.h(n);
        }
        return 0.0f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Integer GetCurrentDescriptor() {
        return PlayerPhysicsComponent.m(this, false);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return at;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVehicleCurveReverseSpeedMultiplier(float f) {
        if (this.ah.b != null && this.ah.w != null) {
            this.ah.w.y = f;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void clearControl(String string, @ScriptDefaults(defaultInteger=0) int n) {
        if (n < 0) {
            throw new IllegalArgumentException("timestampOffset must be >=0!");
        }
        this.setControl(string, null, n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void clearAllControls(@ScriptDefaults(defaultInteger=0) int n) {
        if (n < 0) {
            throw new IllegalArgumentException("timestampOffset must be >=0!");
        }
        if (!this.l.q()) {
            return;
        }
        GameEntity gameEntity = this.getEntity();
        if (gameEntity == null) {
            throw new RuntimeException("entity is null for PlayerPhysicsComponent");
        }
        if (this.l.d() && GameEntity.ej(gameEntity, "__clientControlStreamMaster") == Boolean.FALSE) {
            throw new IllegalStateException("Can't set client-side controls for other people!");
        }
        SourceLossyStateStream sourceLossyStateStream = (SourceLossyStateStream)GameEntity.ej(gameEntity, this.l.d() ? "__clientControlStream" : "__serverControlStream");
        if (sourceLossyStateStream != null) {
            int n2 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(this.l.j(), n);
            K189 k189 = (K189)sourceLossyStateStream.getState(n2);
            K189 k1892 = (K189)sourceLossyStateStream.factory.duplicateState(k189);
            k1892.g.clear();
            k1892.d.clear();
            sourceLossyStateStream.putState(k1892, n2);
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
    public void characterJumpByHeight(float f) {
        PlayerAvatarDescriptor playerAvatarDescriptor;
        if (this.ap != null) {
            this.ap.d("characterJumpByHeight", Float.valueOf(f));
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        float f2 = (playerAvatarDescriptor = PlayerPhysicsComponent.t(this, false)) == null ? (float)Math.sqrt(2.0f * -DiscreteDynamicsWorld.af((DiscreteDynamicsWorld)this.ah.d.d).y * f) : (float)Math.sqrt(2.0f * playerAvatarDescriptor.w * f);
        this.ah.j.r(f2);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getWheelEntitySpaceUp() {
        Quaternion quaternion = this.getOrientation(false);
        Vector3 vector3 = Vector3.g(0.0f, 1.0f, 0.0f);
        return Vector3.al(vector3, quaternion);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void controlOff(@ScriptID Integer n, @ScriptDefaults(defaultInteger=0) int n2) {
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void controlNeutral(@ScriptID Integer n, @ScriptDefaults(defaultInteger=0) int n2) {
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void allControlsNeutral(@ScriptDefaults(defaultInteger=0) int n) {
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void ignoreControlRaw(@ScriptID Integer n, float f) {
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setDescriptor(String string) {
        Integer n = null;
        if (string != null) {
            n = StringTools.l(string);
        }
        if (n != null && PlayerAvatarDescriptor.g(n) == null) {
            logger.error("Attempted to set non-existent player avatar descriptor " + string + " - ignoring", new Ao128());
            return;
        }
        if (!this.l.q()) {
            return;
        }
        logger.debug("descriptor set to {}", n);
        GameEntity gameEntity = this.getEntity();
        if (this.l.d() && GameEntity.ej(gameEntity, "__clientControlStreamMaster") == Boolean.FALSE) {
            throw new IllegalStateException("Can't set client-side controls for other people!");
        }
        SourceLossyStateStream sourceLossyStateStream = (SourceLossyStateStream)GameEntity.ej(gameEntity, this.l.d() ? "__clientControlStream" : "__serverControlStream");
        if (sourceLossyStateStream != null) {
            int n2 = this.l.j();
            K189 k189 = (K189)sourceLossyStateStream.factory.duplicateState(sourceLossyStateStream.getState(n2));
            k189.q = n;
            sourceLossyStateStream.putState(k189, n2);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void kick(Vector3 vector3, float f, @ScriptDefaults(defaultNumber=1000.0) float f2, @ScriptDefaults(defaultInteger=0) int n) {
        if (!this.l.q()) {
            return;
        }
        GameEntity gameEntity = this.getEntity();
        if (f < 0.0f) {
            logger.warn("Kick(): _decceleration must be >= 0.0f");
        }
        if (this.l.d() && GameEntity.ej(gameEntity, "__clientControlStreamMaster") == Boolean.FALSE) {
            throw new IllegalStateException("Can't set client-side controls for other people!");
        }
        SourceLossyStateStream sourceLossyStateStream = (SourceLossyStateStream)GameEntity.ej(gameEntity, this.l.d() ? "__clientControlStream" : "__serverControlStream");
        if (sourceLossyStateStream != null) {
            int n2 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(this.l.j(), n);
            K189 k189 = (K189)sourceLossyStateStream.factory.duplicateState(sourceLossyStateStream.getState(n2));
            k189.j = new Av190(vector3, f, n2, f2);
            sourceLossyStateStream.putState(k189, n2);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean IsDescriptorActive(@ScriptID Integer n) {
        boolean bl = n == null ? this.w == null : n.equals(this.w);
        return bl;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getPosition(boolean bl) {
        if (this.ah == null) {
            if (++aw % (int)ar == 0) {
                ar = (float)((double)ar * 1.2);
                logger.debug("GetPosition() returned zero position as there is no avatar. Or a lost lua reference used.");
            }
            return Vector3.g;
        }
        Vector3 vector3 = null;
        if (this.ah.e != null) {
            vector3 = this.ah.e.an();
        }
        if (vector3 == null) {
            if (++aw % (int)ar == 0) {
                ar = (float)((double)ar * 1.2);
                logger.debug("GetPosition() returned zero position as there is no physics for player. Or a lost lua reference used.");
            }
            return Vector3.g;
        }
        return vector3;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void controlOn(@ScriptID Integer n, @ScriptDefaults(defaultInteger=0) int n2) {
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setPosition(Vector3 vector3, boolean bl, boolean bl2) {
        if (this.ap != null) {
            this.ap.d("setPosition", vector3);
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        PlayerPhysicsComponent.j(this, vector3, bl, bl2);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVehicleCurveSpeedMultiplier(float f) {
        if (this.ah.b != null && this.ah.w != null) {
            this.ah.w.r = f;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Quaternion getOrientation(boolean bl) {
        if (this.ah == null) {
            return Quaternion.g;
        }
        Quaternion quaternion = null;
        if (this.ah.e != null) {
            quaternion = this.ah.e.as().q();
        }
        if (quaternion == null) {
            return Quaternion.g;
        }
        return quaternion;
    }

    public static void n(PlayerPhysicsComponent playerPhysicsComponent, Integer n, boolean bl, boolean bl2, int n2) {
        if (bl) {
            if (playerPhysicsComponent.w == null) {
                if (n != null) {
                    PlayerPhysicsComponent.k(playerPhysicsComponent, n, false, n2);
                }
            } else if (!playerPhysicsComponent.w.equals(n) || playerPhysicsComponent.r != PlayerAvatarDescriptor.d(n)) {
                PlayerPhysicsComponent.k(playerPhysicsComponent, n, false, n2);
            }
        }
    }

    private static void k(PlayerPhysicsComponent playerPhysicsComponent, Integer n, boolean bl, int n2) {
        Q7 q7 = null;
        q7 = playerPhysicsComponent.ah.getCurrentTransform();
        if (q7 == null) {
            q7 = PlayerPhysicsComponent.v(playerPhysicsComponent, playerPhysicsComponent.w);
        }
        Vector3 vector3 = playerPhysicsComponent.getLinearVelocity(bl);
        Vector3 vector32 = playerPhysicsComponent.getAngularVelocity(bl);
        int n3 = playerPhysicsComponent.ah.e != null ? CollisionObject.ab(playerPhysicsComponent.ah.e) : Gj16.PLAYER.az;
        PlayerAvatarDescriptor playerAvatarDescriptor = null;
        if (!bl && playerPhysicsComponent.w != null) {
            playerAvatarDescriptor = PlayerAvatarDescriptor.g(playerPhysicsComponent.w);
        }
        PlayerAvatarDescriptor playerAvatarDescriptor2 = null;
        if (n != null) {
            playerAvatarDescriptor2 = PlayerAvatarDescriptor.g(n);
        }
        if (playerAvatarDescriptor != null && playerAvatarDescriptor2 != null) {
            I48 i48 = I48.w(0.0f, (PlayerAvatarDescriptor.h(playerAvatarDescriptor2) - PlayerAvatarDescriptor.h(playerAvatarDescriptor)) / 2.0f, 0.0f);
            if (playerAvatarDescriptor.d == J93.VEHICLE) {
                float f = playerAvatarDescriptor.j.x - playerAvatarDescriptor.j.f - PlayerAvatarDescriptor.h(playerAvatarDescriptor) / 2.0f;
                f -= Vector3.f(DiscreteDynamicsWorld.af(playerPhysicsComponent.ah.d.d)) / (4.0f * playerAvatarDescriptor.j.d);
                i48.e -= (f -= -playerAvatarDescriptor.j.ay.y);
                i48.j += -playerAvatarDescriptor.j.ay.x;
                i48.h += -playerAvatarDescriptor.j.ay.z;
            }
            if (playerAvatarDescriptor2.d == J93.VEHICLE) {
                Vector3 vector33 = Vector3.g(playerAvatarDescriptor2.j.be, 0.0f, 0.0f);
                vector33 = Vector3.af(vector33, q7.d);
                vector32 = Vector3.z(vector32, vector33);
                float f = playerAvatarDescriptor2.j.x - playerAvatarDescriptor2.j.f - PlayerAvatarDescriptor.h(playerAvatarDescriptor2) / 2.0f;
                f -= Vector3.f(DiscreteDynamicsWorld.af(playerPhysicsComponent.ah.d.d)) / (4.0f * playerAvatarDescriptor2.j.d);
                i48.e += (f -= -playerAvatarDescriptor2.j.ay.y);
                i48.j -= -playerAvatarDescriptor2.j.ay.x;
                i48.h -= -playerAvatarDescriptor2.j.ay.z;
            }
            M47.s(q7.d, i48);
            q7 = q7.h(i48);
            I48.y(i48);
        }
        PlayerPhysicsAvatar.q(playerPhysicsComponent.ah);
        playerPhysicsComponent.w = n;
        if (playerAvatarDescriptor2 != null) {
            playerPhysicsComponent.ah.j(playerPhysicsComponent.getEntity(), playerAvatarDescriptor2, q7, vector3, vector32, n2, n3);
            playerPhysicsComponent.r = PlayerAvatarDescriptor.d(n);
        } else {
            playerPhysicsComponent.r = -1;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setInterpolation(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f <= 0.0f) {
            f = Float.NaN;
        }
        this.an = f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isBike() {
        PlayerAvatarDescriptor playerAvatarDescriptor;
        return this.w != null && (playerAvatarDescriptor = PlayerAvatarDescriptor.g(this.w)) != null && !Float.isNaN(playerAvatarDescriptor.j.bf);
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
    public void SetVehicleTopSpeed(float f) {
        if (this.ap != null) {
            this.ap.d("SetVehicleTopSpeed", Float.valueOf(f));
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null && this.ah.w != null) {
            this.ah.w.b = f;
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
    public RotTrans getJointTransform(int n) {
        Z165 z165 = new Z165(this.af[n]);
        if (this.getEntity().v != 0L) {
            // empty if block
        }
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
    public void setVehicleAccelerator(float f) {
        if (this.ap != null) {
            this.ap.d("setVehicleAccelerator", Float.valueOf(f));
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.d = f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVehicleCurveAccelerationMultiplier(float f) {
        if (this.ah.b != null && this.ah.w != null) {
            this.ah.w.w = f;
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

    public E181 e(E181 e181, boolean bl) {
        if (this.ah.e != null) {
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
            logger.warn("Called physics function outside control handler", new Ao128());
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

    public static Integer m(PlayerPhysicsComponent playerPhysicsComponent, boolean bl) {
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
    public void setVehicleSteering(float f) {
        if (this.ap != null) {
            this.ap.d("setVehicleSteering", Float.valueOf(f));
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.q = f;
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
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.q = 1.0f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleBrake(@ScriptDefaults(defaultNumber=1.0) double d) {
        if (this.ap != null) {
            this.ap.d("vehicleBrake", d);
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.j = Math.abs((float)d);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleHandBrake(@ScriptDefaults(defaultBoolean=true) boolean bl) {
        if (this.ap != null) {
            this.ap.d("vehicleHandBrake", bl);
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.e = bl;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean vehicleGetWheelIsTouchingGround(int n) {
        if (this.ah.b != null) {
            return this.ah.b.e(n % BulletVehicle.g(this.ah.b));
        }
        return false;
    }

    public static void p(PlayerPhysicsComponent playerPhysicsComponent, int n, boolean bl, boolean bl2, String string) {
        Object object;
        float f;
        PlayerAvatarDescriptor playerAvatarDescriptor;
        boolean bl3 = bl && !bl2;
        GameEntity gameEntity = playerPhysicsComponent.getEntity();
        PlayerPhysicsComponent.y(playerPhysicsComponent, bl, bl2, n);
        LossyStateStream lossyStateStream = (LossyStateStream)GameEntity.ej(gameEntity, "__clientControlStream");
        LossyStateStream lossyStateStream2 = (LossyStateStream)GameEntity.ej(gameEntity, "__serverControlStream");
        K189 k189 = null;
        K189 k1892 = null;
        if (lossyStateStream != null) {
            k189 = (K189)lossyStateStream.getState(n);
        }
        if (lossyStateStream2 != null) {
            k1892 = (K189)lossyStateStream2.getState(n);
        }
        Av190 av190 = null;
        int n2 = 0;
        if (playerPhysicsComponent.l.d()) {
            if (k189 != null && k189.j != null) {
                av190 = k189.j;
                n2 = n;
            } else if (k1892 != null) {
                av190 = k1892.j;
                n2 = n;
            }
        } else if (k1892 != null && k1892.j != null) {
            av190 = k1892.j;
            n2 = n;
        } else if (k189 != null) {
            av190 = k189.j;
            n2 = n;
        }
        if (playerPhysicsComponent.ah != null && playerPhysicsComponent.ah.d != null) {
            PlayerPhysicsAvatar.v(playerPhysicsComponent.ah, av190, n, n2, bl3);
        }
        if (playerPhysicsComponent.ah != null && playerPhysicsComponent.ah.d != null && (object = playerPhysicsComponent.ah.getCurrentTransform()) != null) {
            f = playerPhysicsComponent.ah.d.d.ao(object.g.x, object.g.z);
            playerAvatarDescriptor = null;
            if (playerPhysicsComponent.w != null) {
                playerAvatarDescriptor = PlayerAvatarDescriptor.g(playerPhysicsComponent.w);
            }
            float f2 = object.g.y;
            if (playerAvatarDescriptor != null && playerAvatarDescriptor.j != null) {
                f2 -= playerAvatarDescriptor.j.ay.y;
            }
            if (f2 < f) {
                if (playerPhysicsComponent.w != null) {
                    f += PlayerAvatarDescriptor.h(playerAvatarDescriptor);
                }
                object = ((Q7)object).j(f + 5.0f);
                PlayerPhysicsAvatar.e(playerPhysicsComponent.ah, (Q7)object);
            }
        }
        if (playerPhysicsComponent.ah != null && playerPhysicsComponent.ah.d != null) {
            object = null;
            if (playerPhysicsComponent.w != null) {
                object = PlayerAvatarDescriptor.g(playerPhysicsComponent.w);
            }
            if (object != null && playerPhysicsComponent.ah.b != null && ((PlayerAvatarDescriptor)object).j != null) {
                if (!Float.isNaN(object.j.bf)) {
                    f = PlayerAvatarDescriptor.v((PlayerAvatarDescriptor)object, playerPhysicsComponent.ah);
                    playerPhysicsComponent.ah.w(0.0f, 0.0f, f);
                    I48.p(playerPhysicsComponent.ah.w.p, 0.0f, 0.0f, 0.0f);
                    playerPhysicsComponent.ah.b.v(playerPhysicsComponent.ah.w.p);
                } else {
                    playerPhysicsComponent.ah.w(0.0f, 0.0f, 0.0f);
                }
            }
        }
        if (playerPhysicsComponent.ah != null && playerPhysicsComponent.ah.d != null && playerPhysicsComponent.ah.q != null) {
            playerPhysicsComponent.ah.y = playerPhysicsComponent.ah.q.l();
            playerPhysicsComponent.ah.p = playerPhysicsComponent.ah.q.w();
        }
        if (k189 != null || k1892 != null) {
            playerPhysicsComponent.av.clear();
            playerPhysicsComponent.az.clear();
            playerPhysicsComponent.av.putAll(k189.g);
            for (Map.Entry entry : k189.d.entrySet()) {
                playerPhysicsComponent.az.put(entry.getKey(), (double)((float)LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n, (Integer)entry.getValue()) * Lq191.d()) * 1.0);
            }
            playerPhysicsComponent.av.putAll(k1892.g);
            object = k1892.d.entrySet().iterator();
            while (object.hasNext()) {
                Map.Entry entry = object.next();
                playerPhysicsComponent.az.put(entry.getKey(), (double)((float)LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n, (Integer)entry.getValue()) * Lq191.d()) * 1.0);
            }
            for (int i = 0; i < 2; ++i) {
                boolean bl4;
                boolean bl5 = bl4 = i == 0;
                if (bl4 && !bl || !bl4 && !bl2) continue;
                playerAvatarDescriptor = null;
                if (!bl4 && playerPhysicsComponent.w != null) {
                    playerAvatarDescriptor = PlayerAvatarDescriptor.g(playerPhysicsComponent.w);
                }
                if (playerAvatarDescriptor == null) continue;
                Ag183.g(playerPhysicsComponent.aa);
                playerPhysicsComponent.ap = Y192.d(string, n, gameEntity.bb, playerPhysicsComponent.ah, playerPhysicsComponent.av, ab);
                playerPhysicsComponent.ao = true;
                if (playerAvatarDescriptor.m != null) {
                    playerAvatarDescriptor.m.trigger(gameEntity, new Object[]{n, bl4, playerPhysicsComponent.av, playerPhysicsComponent.az});
                }
                playerPhysicsComponent.aa.d(playerPhysicsComponent.ah, n, bl3, playerPhysicsComponent.ap);
                playerPhysicsComponent.ao = false;
                playerPhysicsComponent.ap = null;
            }
        }
        if (bl2 && playerPhysicsComponent.ah.d != null && playerPhysicsComponent.q == null && (object = PlayerPhysicsComponent.x(playerPhysicsComponent, playerPhysicsComponent.getCurrentTransform(), true)) != null) {
            playerPhysicsComponent.getEntity().setWorldTransform((RotTrans)object);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleStartInducedDrift(float f, float f2) {
        if (this.ap != null) {
            this.ap.d("vehicleStartInducedDrift", Float.valueOf(f), Float.valueOf(f2));
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null) {
            this.ah.b.v = f;
            this.ah.b.y = (1.0f - f) * DiscreteDynamicsWorld.av(this.ah.b.e.b) / f2;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void applyForceAtPoint(Vector3 vector3, Vector3 vector32, boolean bl, boolean bl2) {
        if (this.ap != null) {
            this.ap.d("applyForceAtPoint", vector3, vector32);
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (bl && this.ah.q != null) {
            Vector3 vector33 = this.ah.q.an();
            Vector3 vector34 = Vector3.k(vector32, vector33);
            Vector3 vector35 = Vector3.a(vector34, vector3);
            this.ah.q.r(vector3);
            this.ah.q.v(vector35);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isControllable() {
        if (this.l.d()) {
            Boolean bl = (Boolean)GameEntity.ej(this.getEntity(), "__clientControlStreamMaster");
            return bl;
        }
        return true;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleStopInducedDrift() {
        if (this.ap != null) {
            this.ap.d("vehicleStopInducedDrift", new Object[0]);
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null) {
            this.ah.b.v = 1.0f;
            this.ah.b.y = 0.0f;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleStartLateralFrictionMultiplier(float f, float f2) {
        if (this.ap != null) {
            this.ap.d("vehicleStartLateralFrictionMultiplier", Float.valueOf(f), Float.valueOf(f2));
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null) {
            this.ah.b.w = f;
            this.ah.b.r = (1.0f - f) * DiscreteDynamicsWorld.av(this.ah.b.e.b) / f2;
        }
    }

    private static Q7 v(PlayerPhysicsComponent playerPhysicsComponent, Integer n) {
        PlayerAvatarDescriptor playerAvatarDescriptor;
        ScaleRotTrans scaleRotTrans = playerPhysicsComponent.getEntity().getWorldTransform();
        RotTrans rotTrans = scaleRotTrans.q();
        Q7 q7 = Q7.g(rotTrans);
        q7 = q7.s(Gh19.g.m());
        if (n != null && (playerAvatarDescriptor = PlayerAvatarDescriptor.g(n)) != null) {
            Vector3 vector3 = Vector3.g(0.0f, PlayerAvatarDescriptor.h(playerAvatarDescriptor) / 2.0f, 0.0f);
            vector3 = Vector3.af(vector3, q7.d);
            q7 = q7.e(vector3);
            q7 = PlayerAvatarDescriptor.w(playerAvatarDescriptor, q7);
        }
        return q7;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getLinearVelocity(boolean bl) {
        if (this.ah == null) {
            return Vector3.g;
        }
        if (this.ah.q != null) {
            return this.ah.q.l();
        }
        if (this.ah.j != null) {
            Vector3 vector3 = this.ah.h;
            return vector3.an(this.ah.j.y());
        }
        return Vector3.g;
    }

    public void z() {
        RotTrans rotTrans;
        B164 b164;
        float f;
        Object object;
        Object[] arrobject;
        U186 u186 = (U186)M188.q(this.q);
        if (u186 == null) {
            return;
        }
        U186 u1862 = (U186)M188.j(this.q);
        float f2 = M188.l(this.q);
        if (M188.s && u1862 != null) {
            long l = u186.z;
            long l2 = u1862.z;
            long l3 = System.nanoTime();
            long l4 = (long)((float)l * (1.0f - f2) + (float)l2 * f2);
            l /= 1000L;
            l2 /= 1000L;
            l3 /= 1000L;
            l4 /= 1000L;
            l %= 1000000L;
            l2 %= 1000000L;
            long l5 = (l3 %= 1000000L) - (l4 %= 1000000L);
            if (l5 < 0L) {
                l5 += 1000000L;
            }
            arrobject = new Object[]{Float.valueOf((float)l / 1000.0f), Float.valueOf((float)l2 / 1000.0f), Float.valueOf(f2), Float.valueOf((float)l4 / 1000.0f), Float.valueOf((float)l3 / 1000.0f), Float.valueOf((float)l5 / 1000.0f)};
            logger.debug("Tweening frames: {} ms and {} ms. tweenPos = {} This is eqivalent to {} ms.  Current time = {} ms.  Lag due to tweener = {} ms.", arrobject);
        }
        if ((rotTrans = u186.g) == null) {
            return;
        }
        if (u1862 != null) {
            if (u1862.g == null) {
                u1862 = null;
            } else {
                rotTrans = rotTrans.p(u1862.g, f2);
            }
        } else {
            logger.trace("Ran out of frames");
        }
        this.getEntity().setWorldTransform(rotTrans);
        RotTrans rotTrans2 = null;
        rotTrans2 = rotTrans.j();
        float f3 = f = this.getEntity().v != 0L ? 1.0f / StaticModel.getAnimatedSgnScale(this.getEntity().v) : 1.0f;
        if (this.w != null && (object = PlayerAvatarDescriptor.g(this.w)) != null && ((PlayerAvatarDescriptor)object).d == J93.VEHICLE && this.af != null) {
            B164 b1642;
            B164 b1643;
            B164 b1644;
            Quaternion quaternion;
            B164 b1645;
            Quaternion quaternion2;
            B164 b1646;
            Quaternion quaternion3 = Quaternion.e(0.0f, 0.0f, 1.0f, object.j.bq);
            b164 = Vector3.g;
            if (this.af[0] != null) {
                b164 = ((Vector3)b164).aa(object.j.u / 2.0f);
            }
            RotTrans rotTrans3 = new RotTrans(quaternion3, (Vector3)b164);
            RotTrans rotTrans4 = new RotTrans(quaternion3, Vector3.g);
            Quaternion quaternion4 = Quaternion.e(0.0f, 0.0f, 1.0f, object.j.bo);
            Vector3 vector3 = Vector3.g;
            if (this.af[1] != null) {
                vector3 = vector3.aa(-object.j.u / 2.0f);
            }
            arrobject = new RotTrans(quaternion4, vector3);
            RotTrans rotTrans5 = new RotTrans(quaternion4, Vector3.g);
            Z165 z165 = new Z165();
            RotTrans rotTrans6 = null;
            if (this.af[0] != null && rotTrans2 != null) {
                Z165.g(z165, u186.j);
                if (u1862 != null) {
                    Z165.s(z165, u1862.j, f2);
                }
                Z165.e(z165, rotTrans4);
                b1643 = Quaternion.e(1.0f, 0.0f, 0.0f, object.j.bl);
                b1642 = Quaternion.e(0.0f, 1.0f, 0.0f, -object.j.bw);
                Z165.h(z165, b1643);
                Z165.h(z165, b1642);
                rotTrans6 = z165.b().j();
                Z165.j(z165, rotTrans2);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[0] = z165.b();
            }
            b1643 = null;
            if (this.af[1] != null && rotTrans2 != null) {
                Z165.g(z165, u186.e);
                if (u1862 != null) {
                    Z165.s(z165, u1862.e, f2);
                }
                Z165.e(z165, rotTrans5);
                b1642 = Quaternion.e(1.0f, 0.0f, 0.0f, object.j.bl);
                b1645 = Quaternion.e(0.0f, 1.0f, 0.0f, object.j.bw);
                Z165.h(z165, b1642);
                Z165.h(z165, b1645);
                b1643 = z165.b().j();
                Z165.j(z165, rotTrans2);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[1] = z165.b();
            }
            b1642 = null;
            if (this.af[4] != null && rotTrans2 != null) {
                Z165.g(z165, u186.b);
                if (u1862 != null) {
                    Z165.s(z165, u1862.b, f2);
                }
                Z165.e(z165, rotTrans4);
                b1645 = Quaternion.e(1.0f, 0.0f, 0.0f, object.j.bj);
                b1644 = Quaternion.e(0.0f, 1.0f, 0.0f, -object.j.bk);
                Z165.h(z165, b1645);
                Z165.h(z165, b1644);
                b1642 = z165.b().j();
                Z165.j(z165, rotTrans2);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[4] = z165.b();
            }
            b1645 = null;
            if (this.af[5] != null && rotTrans2 != null) {
                Z165.g(z165, u186.l);
                if (u1862 != null) {
                    Z165.s(z165, u1862.l, f2);
                }
                Z165.e(z165, rotTrans5);
                b1644 = Quaternion.e(1.0f, 0.0f, 0.0f, object.j.bj);
                b1646 = Quaternion.e(0.0f, 1.0f, 0.0f, object.j.bk);
                Z165.h(z165, b1644);
                Z165.h(z165, b1646);
                b1645 = z165.b().j();
                Z165.j(z165, rotTrans2);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[5] = z165.b();
            }
            b1644 = null;
            b1646 = null;
            if (object.j.bd != 0.0f) {
                if (this.af[8] != null && rotTrans2 != null) {
                    Z165.g(z165, u186.v);
                    if (u1862 != null) {
                        Z165.s(z165, u1862.v, f2);
                    }
                    Z165.e(z165, rotTrans4);
                    b1644 = z165.b().j();
                    Z165.j(z165, rotTrans2);
                    z165.d.j *= f;
                    z165.d.e *= f;
                    z165.d.h *= f;
                    this.af[8] = z165.b();
                }
                if (this.af[9] != null && rotTrans2 != null) {
                    Z165.g(z165, u186.y);
                    if (u1862 != null) {
                        Z165.s(z165, u1862.y, f2);
                    }
                    Z165.e(z165, rotTrans5);
                    b1646 = z165.b().j();
                    Z165.j(z165, rotTrans2);
                    z165.d.j *= f;
                    z165.d.e *= f;
                    z165.d.h *= f;
                    this.af[9] = z165.b();
                }
            }
            if (this.af[2] != null && rotTrans6 != null) {
                Z165.g(z165, u186.d);
                if (u1862 != null) {
                    Z165.s(z165, u1862.d, f2);
                }
                Z165.e(z165, rotTrans3);
                Z165.j(z165, rotTrans6);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[2] = z165.b();
            }
            if (this.af[3] != null && b1643 != null) {
                Z165.g(z165, u186.q);
                if (u1862 != null) {
                    Z165.s(z165, u1862.q, f2);
                }
                Z165.e(z165, (RotTrans)arrobject);
                Z165.j(z165, (RotTrans)b1643);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[3] = z165.b();
            }
            if (this.af[6] != null && b1642 != null) {
                Z165.g(z165, u186.h);
                if (u1862 != null) {
                    Z165.s(z165, u1862.h, f2);
                }
                Z165.e(z165, rotTrans3);
                Z165.j(z165, (RotTrans)b1642);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[6] = z165.b();
            }
            if (this.af[7] != null && b1645 != null) {
                Z165.g(z165, u186.s);
                if (u1862 != null) {
                    Z165.s(z165, u1862.s, f2);
                }
                Z165.e(z165, (RotTrans)arrobject);
                Z165.j(z165, (RotTrans)b1645);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[7] = z165.b();
            }
            if (object.j.bd != 0.0f) {
                if (this.af[10] != null && b1644 != null) {
                    Z165.g(z165, u186.w);
                    if (u1862 != null) {
                        Z165.s(z165, u1862.w, f2);
                    }
                    Z165.e(z165, rotTrans3);
                    Z165.j(z165, (RotTrans)b1644);
                    z165.d.j *= f;
                    z165.d.e *= f;
                    z165.d.h *= f;
                    this.af[10] = z165.b();
                }
                if (this.af[11] != null && b1646 != null) {
                    Z165.g(z165, u186.r);
                    if (u1862 != null) {
                        Z165.s(z165, u1862.r, f2);
                    }
                    Z165.e(z165, (RotTrans)arrobject);
                    Z165.j(z165, (RotTrans)b1646);
                    z165.d.j *= f;
                    z165.d.e *= f;
                    z165.d.h *= f;
                    this.af[11] = z165.b();
                }
            }
            if (this.af[12] != null && rotTrans2 != null) {
                Z165.g(z165, u186.e);
                if (u1862 != null) {
                    Z165.s(z165, u1862.e, f2);
                }
                quaternion2 = Quaternion.e(1.0f, 0.0f, 0.0f, object.j.bl);
                quaternion = Quaternion.e(0.0f, 1.0f, 0.0f, object.j.bw);
                Z165.h(z165, quaternion2);
                Z165.h(z165, quaternion);
                b1643 = z165.b().j();
                Z165.j(z165, rotTrans2);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[12] = z165.b();
            }
            if (this.af[13] != null && rotTrans2 != null) {
                Z165.g(z165, u186.l);
                if (u1862 != null) {
                    Z165.s(z165, u1862.l, f2);
                }
                quaternion2 = Quaternion.e(1.0f, 0.0f, 0.0f, object.j.bj);
                quaternion = Quaternion.e(0.0f, 1.0f, 0.0f, object.j.bk);
                Z165.h(z165, quaternion2);
                Z165.h(z165, quaternion);
                b1645 = z165.b().j();
                Z165.j(z165, rotTrans2);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[13] = z165.b();
            }
            if (this.af[14] != null && b1643 != null) {
                Z165.g(z165, u186.q);
                if (u1862 != null) {
                    Z165.s(z165, u1862.q, f2);
                }
                Z165.e(z165, (RotTrans)arrobject);
                Z165.j(z165, (RotTrans)b1643);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[14] = z165.b();
            }
            if (this.af[15] != null && b1645 != null) {
                Z165.g(z165, u186.s);
                if (u1862 != null) {
                    Z165.s(z165, u1862.s, f2);
                }
                Z165.e(z165, (RotTrans)arrobject);
                Z165.j(z165, (RotTrans)b1645);
                z165.d.j *= f;
                z165.d.e *= f;
                z165.d.h *= f;
                this.af[15] = z165.b();
            }
        }
        object = u186.p;
        if (u1862 != null) {
            object = Vector3.av((Vector3)object, u1862.p, f2);
        }
        this.e = object;
        Vector3 vector3 = u186.x;
        if (u1862 != null) {
            vector3 = Vector3.av(vector3, u1862.x, f2);
        }
        this.h = vector3;
        b164 = GameEntity.v(this.getEntity());
        object = Vector3.al((Vector3)object, ((ScaleRotTrans)b164).rot);
        object = ((Vector3)object).ao();
        float f4 = u186.u;
        if (u1862 != null) {
            f4 += (u1862.u - f4) * f2;
        }
        this.getEntity().setProperty("LinearVelocity", object);
        this.getEntity().setProperty("AngularVelocity", vector3);
        this.getEntity().setProperty("VerticalVelocity", Float.valueOf(f4));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public float vehicleGetWheelSlipStatus(int n) {
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
            E41 e41 = this.ah.e.at();
            return e41.e();
        }
        return null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 vehicleGetWheelContactPatchPosition(int n) {
        if (this.ah.b != null) {
            Vector3 vector3 = BulletVehicle.l(this.ah.b, n);
            return vector3;
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
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.e != null) {
            this.ah.e.ac(M47.g);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public float characterGetContactPatchHeight() {
        float f = 0.0f;
        if (this.ah.j != null) {
            f = this.ah.j.at().j().y;
        }
        return f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setCharacterTurnSpeed(float f) {
        if (this.ap != null) {
            this.ap.d("setCharacterTurnSpeed", Float.valueOf(f));
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.h = true;
        this.aa.b = f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setCharacterSpeed(float f, float f2, float f3) {
        if (this.ap != null) {
            this.ap.d("setCharacterSpeed", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.h = true;
        this.aa.s = new Vector3(f, f2, f3);
        this.ah.h = Vector3.af(this.aa.s, this.ah.j.as());
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void characterJump(float f) {
        if (this.ap != null) {
            this.ap.d("characterJump", Float.valueOf(f));
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.ah.j.r(f);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 entityVectorToPhysicsSpace(Vector3 vector3) {
        return vector3;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Aq193 getLandingPrediction(float f) {
        if (this.ah.j == null || !this.ah.j.p()) {
            return null;
        }
        D194 d194 = new D194();
        if (this.ah.j.u(d194, f)) {
            Aq193 aq193 = new Aq193();
            aq193.g = d194.g;
            aq193.d = d194.d;
            aq193.q = d194.q;
            aq193.j = d194.j;
            aq193.e = d194.e >= 0 ? ((CollisionObjectData)this.ah.j.b.ap((long)((long)d194.e))).d : null;
            return aq193;
        }
        return null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getHeading(boolean bl) {
        Quaternion quaternion = this.getOrientation(bl);
        Vector3 vector3 = Vector3.al(Vector3.g(0.0f, 0.0f, 1.0f), quaternion);
        return (float)Math.atan2(vector3.x, vector3.z);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean canTransformTo(@ScriptID Integer n, @ScriptDefaults(defaultNumber=-0.1) float f, @ScriptDefaults(defaultInteger=0) int n2, @ScriptDefaults(defaultInteger=0) int n3) {
        E6 e6;
        Q7 q7;
        List list;
        PlayerAvatarDescriptor playerAvatarDescriptor = PlayerAvatarDescriptor.g(n);
        if (playerAvatarDescriptor == null) {
            logger.warn("canTransformTo(): could not find the descriptor in the library");
            return true;
        }
        PlayerPhysicsAvatar playerPhysicsAvatar = this.getAvatar(false);
        if (playerPhysicsAvatar == null) {
            logger.warn("canTransformTo(): could not find the avatar for the descriptor. The physics reperesentation hasn't been created yet.");
            return true;
        }
        if (n2 == 0) {
            if (PlayerAvatarDescriptor.IsCharacterController(n)) {
                n2 = Gn5.PLAYER_AS_ROBOT.ordinal();
            } else if (PlayerAvatarDescriptor.IsVehicle(n)) {
                n2 = Gn5.PLAYER_AS_CAR.ordinal();
            }
        }
        if ((list = playerPhysicsAvatar.d.d.al(e6 = playerAvatarDescriptor.e(playerPhysicsAvatar.d.d), q7 = PlayerPhysicsComponent.v(this, n), n2, n3, null, 20)).size() == 20) {
            return false;
        }
        playerPhysicsAvatar.d.d.t(e6);
        for (L8 l8 : list) {
            for (L8 l82 : list) {
                if (!(Vector3.o(l8.q, l82.q) < f)) continue;
                return false;
            }
        }
        return true;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public PhysicsWorldWrapper getPhysicsWorld(boolean bl) {
        if (this.ah == null) {
            return null;
        }
        return this.ah.d;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getAngularVelocity(boolean bl) {
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

    static /* synthetic */ Logger a() {
        return logger;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isCharacter() {
        return this.ah.j != null;
    }

    public void i(int n, boolean bl) {
        if (!this.l.d()) {
            throw new IllegalArgumentException("Only on client");
        }
        PlayerPhysicsComponent.o(this, n, bl);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getWheelEntitySpacePos(int n) {
        Vector3 vector3 = this.vehicleGetWheelContactPatchPosition(n);
        return vector3;
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
        Quaternion quaternion = this.getOrientation(false);
        Vector3 vector3 = Vector3.g(0.0f, 0.0f, 1.0f);
        return Vector3.al(vector3, quaternion);
    }

    private static void o(PlayerPhysicsComponent playerPhysicsComponent, int n, boolean bl) {
        if (playerPhysicsComponent.ah.x != -1) {
            playerPhysicsComponent.ac.runRaw("tyreTrackDecal", playerPhysicsComponent.getEntity(), bl, playerPhysicsComponent.ah.x);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getCollisionMask(@ScriptDefaults(defaultBoolean=false) boolean bl) {
        if (this.ah == null || this.ah.e == null) {
            throw new RuntimeException(String.format("PlayerPhysicsComponent%s PlayerPhysicsAvatar%s was null.", bl ? " master" : "", this.ah != null ? " CollisionObject" : ""));
        }
        return CollisionObject.ab(this.ah.e);
    }

    public static void w(PlayerPhysicsComponent playerPhysicsComponent) {
        playerPhysicsComponent.am = true;
        PlayerPhysicsComponent.r(playerPhysicsComponent);
    }

    public static E41 b(PlayerPhysicsComponent playerPhysicsComponent) {
        if (playerPhysicsComponent.ah.e != null) {
            return playerPhysicsComponent.ah.e.at();
        }
        return null;
    }

    static {
        logger = LoggerFactory.getLogger(PlayerPhysicsComponent.class);
        d = true;
        al = new String[]{"T_lFrontSuspensionJ", "T_rFrontSuspensionJ", "T_lFrontWheelJ", "T_rFrontWheelJ", "T_lRearSuspensionJ", "T_rRearSuspensionJ", "T_lRearWheelJ", "T_rRearWheelJ", "T_lMidSuspensionJ", "T_rMidSuspensionJ", "T_lMidWheelJ", "T_rMidWheelJ", "T_FrontSuspensionJ", "T_RearSuspensionJ", "T_FrontWheelJ", "T_RearWheelJ"};
        as = false;
        at = StringTools.l(PlayerPhysicsComponent.class.getName());
        ab = new HashMap();
        aw = 0;
        ar = 1.0f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleStartFrictionDissipationReduction(float f, float f2) {
        if (this.ap != null) {
            this.ap.d("vehicleStartFrictionDissipationReduction", Float.valueOf(f), Float.valueOf(f2));
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null) {
            this.ah.b.p = f;
            this.ah.b.x = -f * DiscreteDynamicsWorld.av(this.ah.b.e.b) / f2;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public float vehicleGetWheelSlipSpeed(int n) {
        if (this.ah.b != null) {
            return this.ah.b.b(n);
        }
        return 0.0f;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVehicleTopSpeedInReverse(float f) {
        if (this.ap != null) {
            this.ap.d("SetVehicleTopSpeedInReverse", Float.valueOf(f));
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null && this.ah.w != null) {
            this.ah.w.l = f;
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean isTouchingGround() {
        if (this.ah.j != null) {
            return this.ah.j.p();
        }
        if (this.ah.b != null) {
            if (BulletVehicle.g(this.ah.b) == 4) {
                return this.ah.b.e(0) || this.ah.b.e(1) || this.ah.b.e(2) || this.ah.b.e(3);
            }
            if (BulletVehicle.g(this.ah.b) == 2) {
                return this.ah.b.e(0) || this.ah.b.e(1);
            }
            return false;
        }
        return false;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleSteerLeft() {
        if (this.ap != null) {
            this.ap.d("vehicleSteerLeft", new Object[0]);
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        this.aa.g = true;
        this.aa.q = -1.0f;
    }

    public static PlayerAvatarDescriptor t(PlayerPhysicsComponent playerPhysicsComponent, boolean bl) {
        Integer n = PlayerPhysicsComponent.m(playerPhysicsComponent, bl);
        if (n == null) {
            return null;
        }
        return PlayerAvatarDescriptor.g(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void vehicleStopLateralFrictionMultiplier() {
        if (this.ap != null) {
            this.ap.d("vehicleStopLateralFrictionMultiplier", new Object[0]);
        }
        if (!this.ao) {
            logger.warn("Called physics function outside control handler", new Ao128());
        }
        if (this.ah.b != null) {
            this.ah.b.w = 1.0f;
            this.ah.b.r = 0.0f;
        }
    }

    public static void y(PlayerPhysicsComponent playerPhysicsComponent, boolean bl, boolean bl2, int n) {
        PlayerAvatarDescriptor playerAvatarDescriptor;
        Object object;
        Object object2;
        Object object3;
        GameEntity gameEntity = playerPhysicsComponent.getEntity();
        if (!playerPhysicsComponent.am) {
            PlayerPhysicsComponent.r(playerPhysicsComponent);
            return;
        }
        ScaleRotTrans scaleRotTrans = gameEntity.getWorldTransform();
        Q7 q7 = null;
        if (bl2 && ((object = playerPhysicsComponent.l.g(scaleRotTrans.trans)) != playerPhysicsComponent.ah.d || !PlayerPhysicsAvatar.d(playerPhysicsComponent.ah))) {
            q7 = PlayerPhysicsComponent.v(playerPhysicsComponent, playerPhysicsComponent.w);
            object3 = playerPhysicsComponent.ah.y;
            object2 = playerPhysicsComponent.ah.p;
            int n2 = Gj16.PLAYER.az;
            if (playerPhysicsComponent.ah.e != null) {
                n2 = CollisionObject.ab(playerPhysicsComponent.ah.e);
            }
            PlayerPhysicsAvatar.q(playerPhysicsComponent.ah);
            playerPhysicsComponent.ah.d = object;
            if (playerPhysicsComponent.w != null && playerPhysicsComponent.ah.d != null) {
                playerPhysicsComponent.ah.j(gameEntity, PlayerAvatarDescriptor.g(playerPhysicsComponent.w), q7, (Vector3)object3, (Vector3)object2, n, n2);
            }
        }
        object = (LossyStateStream)GameEntity.ej(gameEntity, "__clientControlStream");
        object3 = (LossyStateStream)GameEntity.ej(gameEntity, "__serverControlStream");
        object2 = null;
        K189 k189 = null;
        if (object != null) {
            object2 = (K189)((LossyStateStream)object).getState(n);
        }
        if (object3 != null) {
            k189 = (K189)((LossyStateStream)object3).getState(n);
        }
        Integer n3 = null;
        if (playerPhysicsComponent.l.d()) {
            if (object2 != null && ((K189)object2).q != null) {
                n3 = ((K189)object2).q;
            } else if (k189 != null) {
                n3 = k189.q;
            }
        } else if (k189 != null && k189.q != null) {
            n3 = k189.q;
        } else if (object2 != null) {
            n3 = ((K189)object2).q;
        }
        if (bl2 && n3 != null && (!n3.equals(playerPhysicsComponent.w) || playerPhysicsComponent.r != PlayerAvatarDescriptor.d(playerPhysicsComponent.w)) && (playerAvatarDescriptor = PlayerAvatarDescriptor.g(n3)) != null && playerAvatarDescriptor.n != null) {
            playerAvatarDescriptor.n.trigger(gameEntity, null);
        }
        PlayerPhysicsComponent.n(playerPhysicsComponent, n3, bl2, false, n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void setControl(String string, Object object, @ScriptDefaults(defaultInteger=0) int n) {
        if (n < 0) {
            throw new IllegalArgumentException("timestampOffset must be >=0!");
        }
        int n2 = StringTools.l(string);
        ab.put(n2, string);
        if (!this.l.q()) {
            return;
        }
        GameEntity gameEntity = this.getEntity();
        if (gameEntity == null) {
            throw new RuntimeException("entity is null for PlayerPhysicsComponent");
        }
        if (this.l.d() && GameEntity.ej(gameEntity, "__clientControlStreamMaster") == Boolean.FALSE) {
            throw new IllegalStateException("Can't set client-side controls for other people!");
        }
        SourceLossyStateStream sourceLossyStateStream = (SourceLossyStateStream)GameEntity.ej(gameEntity, this.l.d() ? "__clientControlStream" : "__serverControlStream");
        if (sourceLossyStateStream != null) {
            int n3 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(this.l.j(), n);
            K189 k189 = (K189)sourceLossyStateStream.getState(n3);
            Object v = k189.g.get(n2);
            if (v == null ? object == null : v.equals(object)) {
                return;
            }
            K189 k1892 = (K189)sourceLossyStateStream.factory.duplicateState(k189);
            if (object == null) {
                k1892.g.remove(n2);
                k1892.d.remove(n2);
            } else {
                k1892.g.put(n2, object);
                k1892.d.put(n2, n3);
            }
            sourceLossyStateStream.putState(k1892, n3);
        }
    }
}

