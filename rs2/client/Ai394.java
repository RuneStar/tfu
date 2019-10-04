// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Ll42;
import com.jagex.game.runetek6.xelement.G104;

class Ai394 implements H393
{
    final /* synthetic */ Z392 d;
    final /* synthetic */ G104 g;
    
    @Override
    public void d() {
        Ap73.v(this.g);
    }
    
    Ai394(final Z392 d, final G104 g) {
        this.g = g;
        this.d = d;
    }
    
    @Override
    public void g() {
        try {
            final GameEntity j = this.g.j();
            if (j == null) {
                return;
            }
            Ll42.q(client.gz, j);
            client.gz.d(j, (float)client.gn, (float)client.gj, client.ds, this.d.g.collisionMask);
            client.logger.trace("Done adding " + j.bg);
            this.d.j.run();
            j.setProperty("spawnyMcSpawnins_AsynchronousTask", null);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
