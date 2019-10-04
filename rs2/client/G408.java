/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.maths.Vector3;
import rs2.client.client;
import rs2.shared.movement.I187;
import rs2.shared.movement.PhysicsWorldWrapper;
import tfu.Ll42;
import tfu.Lz409;

final class G408
implements I187 {
    @Override
    public PhysicsWorldWrapper g(Vector3 vector3) {
        return client.gz.d;
    }

    G408() {
    }

    @Override
    public boolean q() {
        return client.do_;
    }

    @Override
    public int e() {
        int n = Lz409.p(Lz409.d);
        if (n >= 0 && LossyStateStream.TIMESTAMP_WIDTH.diffIDs(client.df, n) > 0) {
            return n;
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

