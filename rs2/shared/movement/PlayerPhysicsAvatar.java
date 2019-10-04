// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import org.slf4j.LoggerFactory;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.maths.M47;
import tfu.Gn5;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.jnibindings.runetek6.Decals;
import tfu.Lq191;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.maths.I48;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.jnibindings.runetek6.jagbullet.CharacterController;
import com.jagex.maths.Vector3;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import org.slf4j.Logger;

public class PlayerPhysicsAvatar
{
    private static final Logger logger;
    public BulletVehicle b;
    public PhysicsWorldWrapper d;
    public CollisionObject e;
    Vector3 h;
    public CharacterController j;
    private Vector3 l;
    boolean m;
    public Vector3 p;
    public RigidBody q;
    E6 r;
    Vector3 s;
    final I48 t;
    Av190 u;
    private I187 v;
    public final P185 w;
    public int x;
    public Vector3 y;
    final I48 z;
    
    public PlayerPhysicsAvatar() {
        this.d = null;
        this.q = null;
        this.j = null;
        this.e = null;
        this.h = Vector3.g;
        this.s = Vector3.g;
        this.b = null;
        this.l = Vector3.g;
        this.w = new P185();
        this.r = null;
        this.v = null;
        this.y = new Vector3(0.0f, 0.0f, 0.0f);
        this.p = new Vector3(0.0f, 0.0f, 0.0f);
        this.x = -1;
        this.u = null;
        this.z = new I48(0.0f, 0.0f, 0.0f);
        this.t = new I48(0.0f, 0.0f, 0.0f);
        this.m = false;
    }
    
    public static void v(final PlayerPhysicsAvatar playerPhysicsAvatar, final Av190 u, final int n, final int n2, final boolean b) {
        if (u != null) {
            if (!Av190.g(u, playerPhysicsAvatar.u)) {
                playerPhysicsAvatar.u = u;
            }
        }
        else {
            playerPhysicsAvatar.u = null;
            I48.z(playerPhysicsAvatar.z);
            I48.z(playerPhysicsAvatar.t);
            playerPhysicsAvatar.m = true;
        }
        if (playerPhysicsAvatar.u != null) {
            final int diffIDs = LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n, u.j);
            final float f = Vector3.f(playerPhysicsAvatar.u.g);
            if (playerPhysicsAvatar.u.d >= 0.0f) {
                final float d = Lq191.d();
                float n3 = playerPhysicsAvatar.u.q / d;
                if (playerPhysicsAvatar.u.d > 0.0f) {
                    final float n4 = f / (playerPhysicsAvatar.u.d * d);
                    if (n4 < n3) {
                        n3 = n4;
                    }
                }
                if (diffIDs > n3 || diffIDs < 0) {
                    if (diffIDs == n3 + 1.0f && playerPhysicsAvatar.j != null && Vector3.f(playerPhysicsAvatar.h) == 0.0f) {
                        playerPhysicsAvatar.j.e(Vector3.g(0.0f, 0.0f, 0.0f));
                    }
                    I48.z(playerPhysicsAvatar.z);
                    I48.z(playerPhysicsAvatar.t);
                    playerPhysicsAvatar.m = true;
                }
                else {
                    final I48 r = I48.r(playerPhysicsAvatar.u.g);
                    I48.ai(r, f);
                    I48.aq(r, playerPhysicsAvatar.u.d * d * diffIDs);
                    I48.x(playerPhysicsAvatar.z, playerPhysicsAvatar.u.g);
                    I48.a(playerPhysicsAvatar.z, r);
                    I48.y(r);
                }
            }
            else {
                I48.z(playerPhysicsAvatar.z);
                I48.z(playerPhysicsAvatar.t);
                playerPhysicsAvatar.m = true;
            }
        }
        else {
            I48.z(playerPhysicsAvatar.z);
            I48.z(playerPhysicsAvatar.t);
            playerPhysicsAvatar.m = true;
        }
    }
    
    static boolean d(final PlayerPhysicsAvatar playerPhysicsAvatar) {
        return playerPhysicsAvatar.e != null;
    }
    
    static void q(final PlayerPhysicsAvatar playerPhysicsAvatar) {
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
    
    public void j(final GameEntity d, final PlayerAvatarDescriptor playerAvatarDescriptor, final Q7 q7, final Vector3 h, final Vector3 vector3, final int x, final int n) {
        q(this);
        if (this.d != null && playerAvatarDescriptor != null) {
            final CollisionObjectData collisionObjectData = new CollisionObjectData(S15.PLAYER);
            collisionObjectData.q = this;
            collisionObjectData.d = d;
            this.r = playerAvatarDescriptor.e(this.d.d);
            boolean q8 = false;
            boolean j = true;
            final MappedEventComponent mappedEventComponent = (MappedEventComponent)GameEntity.eb(d, MappedEventComponent.class);
            if (mappedEventComponent != null) {
                q8 = MappedEventComponent.q(mappedEventComponent);
                j = MappedEventComponent.j(mappedEventComponent);
            }
            switch (H379.g[playerAvatarDescriptor.d.ordinal()]) {
                case 1: {
                    RigidBody.s(this.q = this.d.d.y(playerAvatarDescriptor.l, this.r, q7, playerAvatarDescriptor.v, playerAvatarDescriptor.y, Gn5.PLAYER_AS_BODY.ordinal(), n, q8, j, collisionObjectData), h);
                    RigidBody.b(this.q, vector3);
                    this.e = this.q;
                    break;
                }
                case 2: {
                    final boolean b = true;
                    final I48 r = I48.r(Vector3.af(Vector3.g(0.0f, 0.0f, 1.0f), q7.d));
                    r.e = 0.0f;
                    I48.m(r);
                    (this.j = this.d.d.u(this.r, new Q7(M47.g(Vector3.g(0.0f, 1.0f, 0.0f), (float)Math.atan2(r.j, r.h)), q7.g), playerAvatarDescriptor.x, b, Gn5.PLAYER_AS_ROBOT.ordinal(), n, collisionObjectData)).s(playerAvatarDescriptor.u);
                    this.j.b(playerAvatarDescriptor.z);
                    this.j.l(playerAvatarDescriptor.t);
                    this.j.z(playerAvatarDescriptor.w);
                    this.h = h;
                    this.j.e(Vector3.ai(this.h, DiscreteDynamicsWorld.av(this.d.d)));
                    this.j.v(this.h.y);
                    this.e = this.j;
                    break;
                }
                case 3: {
                    if (Float.isNaN(playerAvatarDescriptor.j.bf)) {
                        playerAvatarDescriptor.j.g = 4;
                    }
                    else {
                        playerAvatarDescriptor.j.g = 2;
                    }
                    RigidBody.s(this.q = this.d.d.p(playerAvatarDescriptor.l, this.r, q7, playerAvatarDescriptor.p, playerAvatarDescriptor.v, playerAvatarDescriptor.y, Gn5.PLAYER_AS_CAR.ordinal(), n, q8, j, collisionObjectData, playerAvatarDescriptor.j.ay, playerAvatarDescriptor.j.bx, playerAvatarDescriptor.j.by, playerAvatarDescriptor.j.br, playerAvatarDescriptor.j.bv), h);
                    RigidBody.b(this.q, vector3);
                    (this.b = this.d.d.z(this.q, playerAvatarDescriptor.j, Gn5.CAR_WHEELS.ordinal(), n)).w(playerAvatarDescriptor.j.bn, playerAvatarDescriptor.j.bb, playerAvatarDescriptor.j.ba);
                    this.b.r(playerAvatarDescriptor.j.bi, playerAvatarDescriptor.j.bg, playerAvatarDescriptor.j.bt, playerAvatarDescriptor.j.bu);
                    this.b.p(playerAvatarDescriptor.w);
                    this.b.x(playerAvatarDescriptor.r);
                    if (this.b != null && this.v != null && this.v.d()) {
                        this.x = Decals.allocVehicleTyreTrackDecalSlot((String)d.getProperty("TyreTrackDecal", "CarTyreTrack"));
                    }
                    this.b.n(playerAvatarDescriptor.j.bh, playerAvatarDescriptor.j.bp);
                    P185.g(this.w, playerAvatarDescriptor.j);
                    this.e = this.q;
                    break;
                }
            }
            this.e.x = x;
            d.ba = this.e;
        }
    }
    
    public static void e(final PlayerPhysicsAvatar playerPhysicsAvatar, final Q7 q7) {
        if (playerPhysicsAvatar.e != null) {
            playerPhysicsAvatar.e.aa(q7);
        }
    }
    
    public static void h(final PlayerPhysicsAvatar playerPhysicsAvatar, final Vector3 vector3) {
        if (playerPhysicsAvatar.e != null) {
            playerPhysicsAvatar.e.am(vector3);
        }
    }
    
    public static void s(final PlayerPhysicsAvatar playerPhysicsAvatar, final M47 m47) {
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
    
    public static Q7 b(final PlayerPhysicsAvatar playerPhysicsAvatar, final int n) {
        if (playerPhysicsAvatar.b == null) {
            return null;
        }
        return playerPhysicsAvatar.b.q(n);
    }
    
    public static Vector3 r(final PlayerPhysicsAvatar playerPhysicsAvatar) {
        return playerPhysicsAvatar.l;
    }
    
    public void w(final float n, final float n2, final float n3) {
        if (this.b == null) {
            return;
        }
        this.l = new Vector3(n, n2, n3);
        this.b.y(n, n2, n3);
    }
    
    static {
        logger = LoggerFactory.getLogger(PlayerPhysicsAvatar.class);
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
    
    static void g(final PlayerPhysicsAvatar playerPhysicsAvatar, final I187 v) {
        playerPhysicsAvatar.v = v;
    }
    
    public static Q7 l(final PlayerPhysicsAvatar playerPhysicsAvatar, final int n) {
        if (playerPhysicsAvatar.b == null) {
            return null;
        }
        return playerPhysicsAvatar.b.j(n);
    }
}
