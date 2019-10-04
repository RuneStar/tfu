/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.comms.broadcast.SceneryConfig;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.xelement.G104;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import rs2.client.Ai394;
import rs2.client.H393;
import rs2.client.client;
import tfu.Br121;
import tfu.Hi86;

class Z392
implements Br121 {
    final /* synthetic */ GameEntity d;
    final /* synthetic */ SceneryConfig g;
    final /* synthetic */ Runnable j;
    final /* synthetic */ Vector3 q;

    @Override
    public boolean d() {
        return this.d.getScene() != null;
    }

    public static void j(Z392 z392, H393 h393) {
        if (h393 != null) {
            h393.d();
        }
    }

    public H393 g() throws Exception {
        XElementLibrary xElementLibrary = XElement.ai;
        XElement[] arrxElement = new XElement[this.g.originalElementAddresses.length];
        for (int i = 0; i < this.g.originalElementAddresses.length; ++i) {
            client.logger.trace("Getting element with address " + this.g.originalElementAddresses[i]);
            arrxElement[i] = XElementLibrary.w(xElementLibrary, this.g.originalElementAddresses[i]);
        }
        G104 g104 = XElement.bj(this.d, arrxElement, this.q, client.lh, true);
        client.logger.trace("Entity constructed.");
        return new Ai394(this, g104);
    }

    Z392(SceneryConfig sceneryConfig, GameEntity gameEntity, Vector3 vector3, Runnable runnable) {
        this.d = gameEntity;
        this.q = vector3;
        this.j = runnable;
        this.g = sceneryConfig;
    }

    @Override
    public int e() {
        return client.aa(Vector3.z(this.d.getWorldTransform().trans, this.q));
    }

    @Override
    public boolean q() {
        return true;
    }
}

