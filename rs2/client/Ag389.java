/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.gameentity.GameEntity;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.slf4j.Logger;
import rs2.client.client;
import tfu.Gc330;
import tfu.Me312;

public abstract class Ag389 {
    protected Me312 q;

    static final void s(Ag389 ag389) {
        try {
            ag389.d();
        }
        catch (Exception exception) {
            client.logger.error("", exception);
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
            catch (Exception exception) {
                client.logger.error("", exception);
            }
        }
        Iterator iterator = this.q.iterator();
        while (iterator.hasNext()) {
            GameEntity gameEntity = (GameEntity)iterator.next();
            if (client.ca.containsKey(gameEntity)) {
                return true;
            }
            iterator.remove();
        }
        return false;
    }

    protected abstract void d();

    protected abstract void g();

    public abstract String toString();
}

