// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.maths.Quaternion;
import org.slf4j.LoggerFactory;
import com.jagex.maths.E41;
import rs2.shared.movement.E181;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.S15;
import com.jagex.maths.Q10;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.maths.Vector3;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.maths.RotTrans;
import com.jagex.jnibindings.runetek6.jagbullet.CharacterController;
import rs2.shared.movement.PhysicsWorldWrapper;
import com.jagex.game.runetek6.gameentity.GameEntity;
import org.slf4j.Logger;
import rs2.shared.movement.Ai37;

public class Jt38 implements Ai37
{
    private static final Logger logger;
    private static final boolean[] y;
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
    
    private static Vector3 ai(final Jt38 jt38, Vector3 vector3) {
        if (jt38.s > 0.0f) {
            vector3 = Vector3.i(vector3, 0.0f, jt38.s / 2.0f, 0.0f);
        }
        else {
            final Q10 i = SceneGraphNode.i(jt38.d);
            if (i != null) {
                vector3 = Vector3.i(vector3, 0.0f, (Q10.q(i) - Q10.j(i)) / 2.0f, 0.0f);
            }
        }
        vector3 = Vector3.i(vector3, (float)jt38.j, 0.0f, (float)jt38.e);
        return vector3;
    }
    
    private RotTrans c(final RotTrans rotTrans) {
        return new RotTrans(rotTrans.rot.v(Gh19.g), ag(this, rotTrans.trans));
    }
    
    private void n(final RotTrans rotTrans) {
        Q10 k = null;
        if (!t(this.h, this.s)) {
            k = SceneGraphNode.k(this.d);
        }
        this.w = PhysicsWorldWrapper.s(this.q, k, this.h, this.s);
        final CollisionObjectData collisionObjectData = new CollisionObjectData(S15.NPC);
        collisionObjectData.d = this.d;
        this.r = this.q.d.u(this.w, Q7.g(rotTrans), 0.0f, true, this.b, this.l, collisionObjectData);
        this.d.ba = this.r;
        this.r.s(1.553343f);
    }
    
    private static void k(final Jt38 jt38) {
        jt38.q.d.n(jt38.r);
        jt38.q.d.t(jt38.w);
    }
    
    public static void i(final Jt38 jt38) {
        jt38.v = Q7.d(jt38.r.ao());
        k(jt38);
    }
    
    public static void o(final Jt38 jt38, final int j, final int e) {
        jt38.n(jt38.v);
        jt38.j = j;
        jt38.e = e;
    }
    
    public static int a(final Jt38 jt38) {
        return jt38.l;
    }
    
    private RotTrans aq(final RotTrans rotTrans) {
        return new RotTrans(rotTrans.rot.v(Gh19.g), ai(this, rotTrans.trans));
    }
    
    public static void al(final Jt38 jt38) {
        k(jt38);
    }
    
    @Override
    public void d(final Vector3 vector3, final float v, final boolean b) {
        this.r.e(vector3);
        if (!Float.isNaN(v)) {
            this.r.ac(Lr302.d(v).m());
        }
        this.r.w(!b);
    }
    
    @Override
    public RotTrans q() {
        return this.aq(Q7.d(this.r.ao()));
    }
    
    @Override
    public E181 j() {
        final E181 e181 = new E181();
        e181.g = this.r.ao();
        e181.d = this.r.h();
        return e181;
    }
    
    @Override
    public void e(final E181 e181) {
        this.r.aa(e181.g);
        this.r.e(e181.d);
    }
    
    @Override
    public void h(final Q7 q7) {
        this.r.aa(q7);
    }
    
    public static E41 af(final Jt38 jt38) {
        return jt38.r.at();
    }
    
    static {
        logger = LoggerFactory.getLogger(Jt38.class);
        (y = new boolean[Gn5.values().length])[Gn5.NPC_FULLCOLLIDE.ordinal()] = true;
        Jt38.y[Gn5.NPC_NODRIVECOLLIDE.ordinal()] = true;
        Jt38.y[Gn5.NPC_NOPLAYERCOLLIDE.ordinal()] = true;
        Jt38.y[Gn5.NPC_NOCOLLIDE.ordinal()] = true;
    }
    
    public static boolean t(final float n, final float n2) {
        return n > 0.0f && n2 > 0.0f;
    }
    
    private int m(final int i) {
        if (i < 0) {
            return Gn5.NPC_NODRIVECOLLIDE.ordinal();
        }
        if (i >= Jt38.y.length) {
            final Gn5 npc_NODRIVECOLLIDE = Gn5.NPC_NODRIVECOLLIDE;
            Jt38.logger.warn("Invalid collision group " + i + " for NPC - reverting to " + npc_NODRIVECOLLIDE);
            return npc_NODRIVECOLLIDE.ordinal();
        }
        if (!Jt38.y[i]) {
            final Gn5 npc_NODRIVECOLLIDE2 = Gn5.NPC_NODRIVECOLLIDE;
            Jt38.logger.warn("Invalid collision group " + Gn5.values()[i] + " for NPC - reverting to " + npc_NODRIVECOLLIDE2);
            return npc_NODRIVECOLLIDE2.ordinal();
        }
        return i;
    }
    
    private static Vector3 ag(final Jt38 jt38, Vector3 vector3) {
        vector3 = Vector3.m(vector3, (float)jt38.j, 0.0f, (float)jt38.e);
        if (jt38.s > 0.0f) {
            vector3 = Vector3.m(vector3, 0.0f, jt38.s / 2.0f, 0.0f);
        }
        else {
            final Q10 i = SceneGraphNode.i(jt38.d);
            if (i != null) {
                vector3 = Vector3.m(vector3, 0.0f, (Q10.q(i) - Q10.j(i)) / 2.0f, 0.0f);
            }
        }
        return vector3;
    }
    
    public Jt38(final GameEntity d, final PhysicsWorldWrapper q, final int j, final int e, final float h, final float s, final int n, final int l, final Vector3 vector3, final Quaternion quaternion) {
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
        this.h = h;
        this.s = s;
        this.b = this.m(n);
        this.l = l;
        this.n(this.c(new RotTrans(quaternion, vector3)));
    }
    
    @Override
    public Vector3 g() {
        return this.r.h();
    }
    
    public static void f(final Jt38 jt38, final float h, final float s, final int n, final int l) {
        i(jt38);
        jt38.h = h;
        jt38.s = s;
        jt38.b = jt38.m(n);
        jt38.l = l;
        o(jt38, jt38.j, jt38.e);
    }
}
