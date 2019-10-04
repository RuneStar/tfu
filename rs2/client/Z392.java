// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.game.runetek6.xelement.G104;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.maths.Vector3;
import com.jagex.game.runetek6.comms.broadcast.SceneryConfig;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Br121;

class Z392 implements Br121
{
    final /* synthetic */ GameEntity d;
    final /* synthetic */ SceneryConfig g;
    final /* synthetic */ Runnable j;
    final /* synthetic */ Vector3 q;
    
    @Override
    public boolean d() {
        return this.d.getScene() != null;
    }
    
    public static void j(final Z392 z392, final H393 h393) {
        if (h393 != null) {
            h393.d();
        }
    }
    
    public H393 g() throws Exception {
        final XElementLibrary ai = XElement.ai;
        final XElement[] array = new XElement[this.g.originalElementAddresses.length];
        for (int i = 0; i < this.g.originalElementAddresses.length; ++i) {
            client.logger.trace("Getting element with address " + this.g.originalElementAddresses[i]);
            array[i] = XElementLibrary.w(ai, this.g.originalElementAddresses[i]);
        }
        final G104 bj = XElement.bj(this.d, array, this.q, client.lh, true);
        client.logger.trace("Entity constructed.");
        return new Ai394(this, bj);
    }
    
    Z392(final SceneryConfig g, final GameEntity d, final Vector3 q, final Runnable j) {
        this.d = d;
        this.q = q;
        this.j = j;
        this.g = g;
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
