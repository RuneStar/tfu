/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.Decals;
import com.jagex.jnibindings.runetek6.jagbullet.B45;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.jagbullet.CharacterController;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.shared.movement.Av190;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.I187;
import rs2.shared.movement.J93;
import rs2.shared.movement.P185;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerAvatarDescriptor;
import rs2.shared.movement.S15;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gn5;
import tfu.Lq191;

public class PlayerPhysicsAvatar {
    private static final Logger logger = LoggerFactory.getLogger(PlayerPhysicsAvatar.class);
    public BulletVehicle b = null;
    public PhysicsWorldWrapper d = null;
    public CollisionObject e = null;
    Vector3 h = Vector3.g;
    public CharacterController j = null;
    private Vector3 l;
    boolean m = false;
    public Vector3 p;
    public RigidBody q = null;
    E6 r = null;
    Vector3 s = Vector3.g;
    final I48 t;
    Av190 u = null;
    private I187 v = null;
    public final P185 w;
    public int x = -1;
    public Vector3 y;
    final I48 z;

    public PlayerPhysicsAvatar() {
        this.l = Vector3.g;
        this.w = new P185();
        this.y = new Vector3(0.0f, 0.0f, 0.0f);
        this.p = new Vector3(0.0f, 0.0f, 0.0f);
        this.z = new I48(0.0f, 0.0f, 0.0f);
        this.t = new I48(0.0f, 0.0f, 0.0f);
    }

    public static void v(PlayerPhysicsAvatar playerPhysicsAvatar, Av190 av190, int n, int n2, boolean bl) {
        if (av190 != null) {
            if (!Av190.g(av190, playerPhysicsAvatar.u)) {
                playerPhysicsAvatar.u = av190;
            }
        } else {
            playerPhysicsAvatar.u = null;
            I48.z(playerPhysicsAvatar.z);
            I48.z(playerPhysicsAvatar.t);
            playerPhysicsAvatar.m = true;
        }
        if (playerPhysicsAvatar.u != null) {
            int n3 = LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n, av190.j);
            float f = Vector3.f(playerPhysicsAvatar.u.g);
            if (playerPhysicsAvatar.u.d >= 0.0f) {
                float f2;
                float f3 = Lq191.d();
                float f4 = playerPhysicsAvatar.u.q / f3;
                if (playerPhysicsAvatar.u.d > 0.0f && (f2 = f / (playerPhysicsAvatar.u.d * f3)) < f4) {
                    f4 = f2;
                }
                if ((float)n3 > f4 || n3 < 0) {
                    if ((float)n3 == f4 + 1.0f && playerPhysicsAvatar.j != null && Vector3.f(playerPhysicsAvatar.h) == 0.0f) {
                        playerPhysicsAvatar.j.e(Vector3.g(0.0f, 0.0f, 0.0f));
                    }
                    I48.z(playerPhysicsAvatar.z);
                    I48.z(playerPhysicsAvatar.t);
                    playerPhysicsAvatar.m = true;
                } else {
                    I48 i48 = I48.r(playerPhysicsAvatar.u.g);
                    I48.ai(i48, f);
                    I48.aq(i48, playerPhysicsAvatar.u.d * f3 * (float)n3);
                    I48.x(playerPhysicsAvatar.z, playerPhysicsAvatar.u.g);
                    I48.a(playerPhysicsAvatar.z, i48);
                    I48.y(i48);
                }
            } else {
                I48.z(playerPhysicsAvatar.z);
                I48.z(playerPhysicsAvatar.t);
                playerPhysicsAvatar.m = true;
            }
        } else {
            I48.z(playerPhysicsAvatar.z);
            I48.z(playerPhysicsAvatar.t);
            playerPhysicsAvatar.m = true;
        }
    }

    static boolean d(PlayerPhysicsAvatar playerPhysicsAvatar) {
        return playerPhysicsAvatar.e != null;
    }

    static void q(PlayerPhysicsAvatar playerPhysicsAvatar) {
        if (playerPhysicsAvatar.d != null) {
            if (playerPhysicsAvatar.b != null) {
                playerPhysicsAvatar.d.d.k(playerPhysicsAvatar.b);
                playerPhysicsAvatar.b = null;
                if (playerPhysicsAvatar.v != null && playerPhysicsAvatar.v.d()) {
                    Decals.freeVehicleTyreTrackDecalSlot(playerPhysicsAvatar.x);
                }
            }
            if (playerPhysicsAvatar.q != null) {
                playerPhysicsAvatar.d.d.m(playerPhysicsAvatar.q);
                playerPhysicsAvatar.q = null;
            }
            if (playerPhysicsAvatar.j != null) {
                playerPhysicsAvatar.d.d.n(playerPhysicsAvatar.j);
                playerPhysicsAvatar.j = null;
            }
            if (playerPhysicsAvatar.r != null) {
                playerPhysicsAvatar.d.d.t(playerPhysicsAvatar.r);
                playerPhysicsAvatar.r = null;
            }
            playerPhysicsAvatar.e = null;
        }
    }

    public void j(GameEntity gameEntity, PlayerAvatarDescriptor playerAvatarDescriptor, Q7 q7, Vector3 vector3, Vector3 vector32, int n, int n2) {
        PlayerPhysicsAvatar.q(this);
        if (this.d != null && playerAvatarDescriptor != null) {
            CollisionObjectData collisionObjectData = new CollisionObjectData(S15.PLAYER);
            collisionObjectData.q = this;
            collisionObjectData.d = gameEntity;
            this.r = playerAvatarDescriptor.e(this.d.d);
            boolean bl = false;
            boolean bl2 = true;
            MappedEventComponent mappedEventComponent = (MappedEventComponent)GameEntity.eb(gameEntity, MappedEventComponent.class);
            if (mappedEventComponent != null) {
                bl = MappedEventComponent.q(mappedEventComponent);
                bl2 = MappedEventComponent.j(mappedEventComponent);
            }
            switch (playerAvatarDescriptor.d) {
                case BODY: {
                    this.q = this.d.d.y(playerAvatarDescriptor.l, this.r, q7, playerAvatarDescriptor.v, playerAvatarDescriptor.y, Gn5.PLAYER_AS_BODY.ordinal(), n2, bl, bl2, collisionObjectData);
                    RigidBody.s(this.q, vector3);
                    RigidBody.b(this.q, vector32);
                    this.e = this.q;
                    break;
                }
                case CHARACTERCONTROLLER: {
                    boolean bl3 = true;
                    I48 i48 = I48.r(Vector3.af(Vector3.g(0.0f, 0.0f, 1.0f), q7.d));
                    i48.e = 0.0f;
                    I48.m(i48);
                    float f = (float)Math.atan2(i48.j, i48.h);
                    M47 m47 = M47.g(Vector3.g(0.0f, 1.0f, 0.0f), f);
                    q7 = new Q7(m47, q7.g);
                    this.j = this.d.d.u(this.r, q7, playerAvatarDescriptor.x, bl3, Gn5.PLAYER_AS_ROBOT.ordinal(), n2, collisionObjectData);
                    this.j.s(playerAvatarDescriptor.u);
                    this.j.b(playerAvatarDescriptor.z);
                    this.j.l(playerAvatarDescriptor.t);
                    this.j.z(playerAvatarDescriptor.w);
                    this.h = vector3;
                    float f2 = DiscreteDynamicsWorld.av(this.d.d);
                    Vector3 vector33 = this.h;
                    vector33 = Vector3.ai(vector33, f2);
                    this.j.e(vector33);
                    this.j.v(this.h.y);
                    this.e = this.j;
                    break;
                }
                case VEHICLE: {
                    playerAvatarDescriptor.j.g = Float.isNaN(playerAvatarDescriptor.j.bf) ? 4 : 2;
                    this.q = this.d.d.p(playerAvatarDescriptor.l, this.r, q7, playerAvatarDescriptor.p, playerAvatarDescriptor.v, playerAvatarDescriptor.y, Gn5.PLAYER_AS_CAR.ordinal(), n2, bl, bl2, collisionObjectData, playerAvatarDescriptor.j.ay, playerAvatarDescriptor.j.bx, playerAvatarDescriptor.j.by, playerAvatarDescriptor.j.br, playerAvatarDescriptor.j.bv);
                    RigidBody.s(this.q, vector3);
                    RigidBody.b(this.q, vector32);
                    this.b = this.d.d.z(this.q, playerAvatarDescriptor.j, Gn5.CAR_WHEELS.ordinal(), n2);
                    this.b.w(playerAvatarDescriptor.j.bn, playerAvatarDescriptor.j.bb, playerAvatarDescriptor.j.ba);
                    this.b.r(playerAvatarDescriptor.j.bi, playerAvatarDescriptor.j.bg, playerAvatarDescriptor.j.bt, playerAvatarDescriptor.j.bu);
                    this.b.p(playerAvatarDescriptor.w);
                    this.b.x(playerAvatarDescriptor.r);
                    if (this.b != null && this.v != null && this.v.d()) {
                        String string = (String)gameEntity.getProperty("TyreTrackDecal", "CarTyreTrack");
                        this.x = Decals.allocVehicleTyreTrackDecalSlot(string);
                    }
                    this.b.n(playerAvatarDescriptor.j.bh, playerAvatarDescriptor.j.bp);
                    P185.g(this.w, playerAvatarDescriptor.j);
                    this.e = this.q;
                }
            }
            this.e.x = n;
            gameEntity.ba = this.e;
        }
    }

    public static void e(PlayerPhysicsAvatar playerPhysicsAvatar, Q7 q7) {
        if (playerPhysicsAvatar.e != null) {
            playerPhysicsAvatar.e.aa(q7);
        }
    }

    public static void h(PlayerPhysicsAvatar playerPhysicsAvatar, Vector3 vector3) {
        if (playerPhysicsAvatar.e != null) {
            playerPhysicsAvatar.e.am(vector3);
        }
    }

    public static void s(PlayerPhysicsAvatar playerPhysicsAvatar, M47 m47) {
        if (playerPhysicsAvatar.e != null) {
            playerPhysicsAvatar.e.ac(m47);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Q7 getCurrentTransform() {
        if (this.e != null) {
            return this.e.ao();
        }
        return null;
    }

    public static Q7 b(PlayerPhysicsAvatar playerPhysicsAvatar, int n) {
        if (playerPhysicsAvatar.b == null) {
            return null;
        }
        return playerPhysicsAvatar.b.q(n);
    }

    public static Vector3 r(PlayerPhysicsAvatar playerPhysicsAvatar) {
        return playerPhysicsAvatar.l;
    }

    public void w(float f, float f2, float f3) {
        if (this.b == null) {
            return;
        }
        this.l = new Vector3(f, f2, f3);
        this.b.y(f, f2, f3);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public CollisionObject getPhysicsCollisionObject() {
        if (this.e != null) {
            return this.e;
        }
        return null;
    }

    static void g(PlayerPhysicsAvatar playerPhysicsAvatar, I187 i187) {
        playerPhysicsAvatar.v = i187;
    }

    public static Q7 l(PlayerPhysicsAvatar playerPhysicsAvatar, int n) {
        if (playerPhysicsAvatar.b == null) {
            return null;
        }
        return playerPhysicsAvatar.b.j(n);
    }
}

