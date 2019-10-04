// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.maths.M47;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.I48;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.maths.Vector3;

class Ag183
{
    public float b;
    public float d;
    public boolean e;
    public boolean g;
    public boolean h;
    public float j;
    public float q;
    public Vector3 s;
    
    public static void g(final Ag183 ag183) {
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
        g(this);
    }
    
    public void d(final PlayerPhysicsAvatar playerPhysicsAvatar, final int n, final boolean b, final C184 c184) {
        if (playerPhysicsAvatar.b != null) {
            playerPhysicsAvatar.w.d(playerPhysicsAvatar.b, Vector3.f(playerPhysicsAvatar.q.l()), DiscreteDynamicsWorld.av(playerPhysicsAvatar.d.d), this.g ? this.d : 0.0f, this.g ? this.q : 0.0f, this.g ? this.j : 0.0f, this.g && this.e, c184);
            if (I48.c(playerPhysicsAvatar.z) > 0.0f) {
                if (false) {
                    final Vector3 l = playerPhysicsAvatar.q.l();
                    final I48 v = I48.v(playerPhysicsAvatar.z);
                    final I48 v2 = I48.v(playerPhysicsAvatar.t);
                    I48.aq(v2, 0.95f);
                    I48.a(v, v2);
                    I48.u(playerPhysicsAvatar.t, playerPhysicsAvatar.z);
                    PlayerPhysicsComponent.logger.debug("shunt on car {}", v);
                    RigidBody.s(playerPhysicsAvatar.q, Vector3.t(l, v));
                    I48.y(v);
                }
                else {
                    playerPhysicsAvatar.q.am(Vector3.n(playerPhysicsAvatar.q.an(), playerPhysicsAvatar.z.ao(), DiscreteDynamicsWorld.av(playerPhysicsAvatar.d.d)));
                }
            }
        }
        if (playerPhysicsAvatar.j != null && (this.h || I48.c(playerPhysicsAvatar.z) > 0.0f || playerPhysicsAvatar.m)) {
            playerPhysicsAvatar.h = Vector3.af(this.s, playerPhysicsAvatar.j.as());
            final Vector3 h = playerPhysicsAvatar.h;
            playerPhysicsAvatar.m = false;
            final Vector3 t = Vector3.t(h, playerPhysicsAvatar.z);
            final float av = DiscreteDynamicsWorld.av(playerPhysicsAvatar.d.d);
            playerPhysicsAvatar.j.e(Vector3.ai(t, av));
            playerPhysicsAvatar.j.ac(playerPhysicsAvatar.j.as().e(M47.d(0.0f, 1.0f, 0.0f, this.b * av)));
            playerPhysicsAvatar.s = new Vector3(0.0f, this.b, 0.0f);
        }
    }
}
