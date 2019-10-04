/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.jagbullet.CharacterController;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import rs2.shared.movement.C184;
import rs2.shared.movement.P185;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerPhysicsAvatar;
import rs2.shared.movement.PlayerPhysicsComponent;

class Ag183 {
    public float b;
    public float d;
    public boolean e;
    public boolean g;
    public boolean h;
    public float j;
    public float q;
    public Vector3 s;

    public static void g(Ag183 ag183) {
        ag183.g = false;
        ag183.d = 0.0f;
        ag183.q = 0.0f;
        ag183.j = 0.0f;
        ag183.e = false;
        ag183.h = false;
        ag183.s = Vector3.g;
        ag183.b = 0.0f;
    }

    public Ag183() {
        Ag183.g(this);
    }

    public void d(PlayerPhysicsAvatar playerPhysicsAvatar, int n, boolean bl, C184 c184) {
        Object object;
        Object object2;
        if (playerPhysicsAvatar.b != null) {
            playerPhysicsAvatar.w.d(playerPhysicsAvatar.b, Vector3.f(playerPhysicsAvatar.q.l()), DiscreteDynamicsWorld.av(playerPhysicsAvatar.d.d), this.g ? this.d : 0.0f, this.g ? this.q : 0.0f, this.g ? this.j : 0.0f, this.g ? this.e : false, c184);
            if (I48.c(playerPhysicsAvatar.z) > 0.0f) {
                Vector3 vector3;
                boolean bl2 = false;
                if (bl2) {
                    vector3 = playerPhysicsAvatar.q.l();
                    object2 = I48.v(playerPhysicsAvatar.z);
                    object = I48.v(playerPhysicsAvatar.t);
                    I48.aq((I48)object, 0.95f);
                    I48.a((I48)object2, (I48)object);
                    I48.u(playerPhysicsAvatar.t, playerPhysicsAvatar.z);
                    PlayerPhysicsComponent.a().debug("shunt on car {}", object2);
                    vector3 = Vector3.t(vector3, (I48)object2);
                    RigidBody.s(playerPhysicsAvatar.q, vector3);
                    I48.y((I48)object2);
                } else {
                    vector3 = playerPhysicsAvatar.q.an();
                    object2 = playerPhysicsAvatar.z.ao();
                    vector3 = Vector3.n(vector3, (Vector3)object2, DiscreteDynamicsWorld.av(playerPhysicsAvatar.d.d));
                    playerPhysicsAvatar.q.am(vector3);
                }
            }
        }
        if (playerPhysicsAvatar.j != null && (this.h || I48.c(playerPhysicsAvatar.z) > 0.0f || playerPhysicsAvatar.m)) {
            Vector3 vector3 = playerPhysicsAvatar.h = Vector3.af(this.s, playerPhysicsAvatar.j.as());
            playerPhysicsAvatar.m = false;
            vector3 = Vector3.t(vector3, playerPhysicsAvatar.z);
            float f = DiscreteDynamicsWorld.av(playerPhysicsAvatar.d.d);
            vector3 = Vector3.ai(vector3, f);
            playerPhysicsAvatar.j.e(vector3);
            object2 = playerPhysicsAvatar.j.as();
            object = M47.d(0.0f, 1.0f, 0.0f, this.b * f);
            object2 = ((M47)object2).e((M47)object);
            playerPhysicsAvatar.j.ac((M47)object2);
            playerPhysicsAvatar.s = new Vector3(0.0f, this.b, 0.0f);
        }
    }
}

