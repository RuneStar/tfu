/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.worldelement;

import com.jagex.maths.E41;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import rs2.client.client;
import rs2.client.worldelement.Npc;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.Q40;
import tfu.Jt38;
import tfu.Ll42;

class J44
implements Q40 {
    final /* synthetic */ Npc g;

    J44(Npc npc) {
        this.g = npc;
    }

    @Override
    public int d() {
        throw new IllegalStateException("This is a server-only command!");
    }

    @Override
    public void q(Vector3 vector3) {
        throw new IllegalStateException("This is a server-only command at present!");
    }

    @Override
    public E41 j() {
        if (this.g.aq != null) {
            return Jt38.af(this.g.aq);
        }
        Vector3 vector3 = this.g.getWorldTransform().trans;
        return new E41(vector3.x, vector3.y, vector3.z, vector3.x, vector3.y, vector3.z);
    }

    @Override
    public PhysicsWorldWrapper g() {
        return client.gz.d;
    }

    @Override
    public Vector3 h() {
        return Npc.bs(this.g);
    }

    @Override
    public Vector3 e() {
        return Npc.be(this.g);
    }
}

