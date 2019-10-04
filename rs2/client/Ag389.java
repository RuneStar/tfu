// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import java.util.Iterator;
import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Gc330;
import tfu.Me312;

public abstract class Ag389
{
    protected Me312 q;
    
    static final void s(final Ag389 ag389) {
        try {
            ag389.d();
        }
        catch (Exception ex) {
            client.logger.error("", ex);
        }
    }
    
    final boolean h() {
        if (client.y(client.ac)) {
            return true;
        }
        if (Gc330.j() == null) {
            return true;
        }
        if (this.q == null) {
            this.q = new Me312();
            try {
                this.g();
            }
            catch (Exception ex) {
                client.logger.error("", ex);
            }
        }
        final Iterator iterator = this.q.iterator();
        while (iterator.hasNext()) {
            if (client.ca.containsKey(iterator.next())) {
                return true;
            }
            iterator.remove();
        }
        return false;
    }
    
    protected abstract void d();
    
    protected abstract void g();
    
    @Override
    public abstract String toString();
}
