/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.jnibindings.runetek6.jagbullet.CharacterController;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.E41;
import com.jagex.maths.M47;
import com.jagex.maths.Q10;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.shared.movement.Ai37;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.E181;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.S15;
import tfu.Gh19;
import tfu.Gn5;
import tfu.Lr302;

public class Jt38
implements Ai37 {
    private static final Logger logger = LoggerFactory.getLogger(Jt38.class);
    private static final boolean[] y = new boolean[Gn5.values().length];
    private int b;
    private final GameEntity d;
    private int e;
    private float h;
    private int j;
    private int l;
    private final PhysicsWorldWrapper q;
    private CharacterController r;
    private float s;
    private RotTrans v;
    private E6 w;

    private static Vector3 ai(Jt38 jt38, Vector3 vector3) {
        if (jt38.s > 0.0f) {
            vector3 = Vector3.i(vector3, 0.0f, jt38.s / 2.0f, 0.0f);
        } else {
            Q10 q10 = GameEntity.i(jt38.d);
            if (q10 != null) {
                vector3 = Vector3.i(vector3, 0.0f, (Q10.q(q10) - Q10.j(q10)) / 2.0f, 0.0f);
            }
        }
        vector3 = Vector3.i(vector3, jt38.j, 0.0f, jt38.e);
        return vector3;
    }

    private RotTrans c(RotTrans rotTrans) {
        return new RotTrans(rotTrans.rot.v(Gh19.g), Jt38.ag(this, rotTrans.trans));
    }

    private void n(RotTrans rotTrans) {
        Q10 q10 = null;
        if (!Jt38.t(this.h, this.s)) {
            q10 = GameEntity.k(this.d);
        }
        this.w = PhysicsWorldWrapper.s(this.q, q10, this.h, this.s);
        CollisionObjectData collisionObjectData = new CollisionObjectData(S15.NPC);
        collisionObjectData.d = this.d;
        float f = 0.0f;
        this.r = this.q.d.u(this.w, Q7.g(rotTrans), f, true, this.b, this.l, collisionObjectData);
        this.d.ba = this.r;
        this.r.s(1.553343f);
    }

    private static void k(Jt38 jt38) {
        jt38.q.d.n(jt38.r);
        jt38.q.d.t(jt38.w);
    }

    public static void i(Jt38 jt38) {
        jt38.v = Q7.d(jt38.r.ao());
        Jt38.k(jt38);
    }

    public static void o(Jt38 jt38, int n, int n2) {
        jt38.n(jt38.v);
        jt38.j = n;
        jt38.e = n2;
    }

    public static int a(Jt38 jt38) {
        return jt38.l;
    }

    private RotTrans aq(RotTrans rotTrans) {
        return new RotTrans(rotTrans.rot.v(Gh19.g), Jt38.ai(this, rotTrans.trans));
    }

    public static void al(Jt38 jt38) {
        Jt38.k(jt38);
    }

    @Override
    public void d(Vector3 vector3, float f, boolean bl) {
        this.r.e(vector3);
        if (!Float.isNaN(f)) {
            this.r.ac(Lr302.d(f).m());
        }
        this.r.w(!bl);
    }

    @Override
    public RotTrans q() {
        RotTrans rotTrans = Q7.d(this.r.ao());
        rotTrans = this.aq(rotTrans);
        return rotTrans;
    }

    @Override
    public E181 j() {
        E181 e181 = new E181();
        e181.g = this.r.ao();
        e181.d = this.r.h();
        return e181;
    }

    @Override
    public void e(E181 e181) {
        this.r.aa(e181.g);
        this.r.e(e181.d);
    }

    @Override
    public void h(Q7 q7) {
        this.r.aa(q7);
    }

    public static E41 af(Jt38 jt38) {
        return jt38.r.at();
    }

    static {
        Jt38.y[Gn5.NPC_FULLCOLLIDE.ordinal()] = true;
        Jt38.y[Gn5.NPC_NODRIVECOLLIDE.ordinal()] = true;
        Jt38.y[Gn5.NPC_NOPLAYERCOLLIDE.ordinal()] = true;
        Jt38.y[Gn5.NPC_NOCOLLIDE.ordinal()] = true;
    }

    public static boolean t(float f, float f2) {
        return f > 0.0f && f2 > 0.0f;
    }

    private int m(int n) {
        if (n < 0) {
            return Gn5.NPC_NODRIVECOLLIDE.ordinal();
        }
        if (n >= y.length) {
            Gn5 gn5 = Gn5.NPC_NODRIVECOLLIDE;
            logger.warn("Invalid collision group " + n + " for NPC - reverting to " + (Object)((Object)gn5));
            return gn5.ordinal();
        }
        if (!y[n]) {
            Gn5 gn5 = Gn5.NPC_NODRIVECOLLIDE;
            logger.warn("Invalid collision group " + (Object)((Object)Gn5.values()[n]) + " for NPC - reverting to " + (Object)((Object)gn5));
            return gn5.ordinal();
        }
        return n;
    }

    private static Vector3 ag(Jt38 jt38, Vector3 vector3) {
        vector3 = Vector3.m(vector3, jt38.j, 0.0f, jt38.e);
        if (jt38.s > 0.0f) {
            vector3 = Vector3.m(vector3, 0.0f, jt38.s / 2.0f, 0.0f);
        } else {
            Q10 q10 = GameEntity.i(jt38.d);
            if (q10 != null) {
                vector3 = Vector3.m(vector3, 0.0f, (Q10.q(q10) - Q10.j(q10)) / 2.0f, 0.0f);
            }
        }
        return vector3;
    }

    public Jt38(GameEntity gameEntity, PhysicsWorldWrapper physicsWorldWrapper, int n, int n2, float f, float f2, int n3, int n4, Vector3 vector3, Quaternion quaternion) {
        this.d = gameEntity;
        this.q = physicsWorldWrapper;
        this.j = n;
        this.e = n2;
        this.h = f;
        this.s = f2;
        this.b = this.m(n3);
        this.l = n4;
        RotTrans rotTrans = new RotTrans(quaternion, vector3);
        rotTrans = this.c(rotTrans);
        this.n(rotTrans);
    }

    @Override
    public Vector3 g() {
        return this.r.h();
    }

    public static void f(Jt38 jt38, float f, float f2, int n, int n2) {
        Jt38.i(jt38);
        jt38.h = f;
        jt38.s = f2;
        jt38.b = jt38.m(n);
        jt38.l = n2;
        Jt38.o(jt38, jt38.j, jt38.e);
    }
}

