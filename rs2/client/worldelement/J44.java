// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.worldelement;

import rs2.client.client;
import rs2.shared.movement.PhysicsWorldWrapper;
import tfu.Jt38;
import com.jagex.maths.E41;
import com.jagex.maths.Vector3;
import rs2.shared.movement.Q40;

class J44 implements Q40
{
    final /* synthetic */ Npc g;
    
    J44(final Npc g) {
        this.g = g;
    }
    
    @Override
    public int d() {
        throw new IllegalStateException("This is a server-only command!");
    }
    
    @Override
    public void q(final Vector3 vector3) {
        throw new IllegalStateException("This is a server-only command at present!");
    }
    
    @Override
    public E41 j() {
        if (this.g.aq != null) {
            return Jt38.af(this.g.aq);
        }
        final Vector3 trans = this.g.getWorldTransform().trans;
        return new E41(trans.x, trans.y, trans.z, trans.x, trans.y, trans.z);
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
