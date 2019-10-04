// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import tfu.Lz409;
import rs2.shared.movement.PhysicsWorldWrapper;
import com.jagex.maths.Vector3;
import rs2.shared.movement.I187;

final class G408 implements I187
{
    @Override
    public PhysicsWorldWrapper g(final Vector3 vector3) {
        return client.gz.d;
    }
    
    @Override
    public boolean q() {
        return client.do_;
    }
    
    @Override
    public int e() {
        final int p = Lz409.p(Lz409.d);
        if (p >= 0 && LossyStateStream.TIMESTAMP_WIDTH.diffIDs(client.df, p) > 0) {
            return p;
        }
        return LossyStateStream.TIMESTAMP_WIDTH.sumIDs(client.df, -client.dz);
    }
    
    @Override
    public int j() {
        return client.df;
    }
    
    @Override
    public boolean d() {
        return true;
    }
}
