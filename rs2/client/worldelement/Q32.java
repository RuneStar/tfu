/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.worldelement;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import rs2.client.worldelement.Npc;
import tfu.Lb33;

class Q32
extends EventHandler {
    final /* synthetic */ Quaternion d;
    final /* synthetic */ Vector3 g;
    final /* synthetic */ Npc q;

    public void g(GameEntity gameEntity, Object object) {
        Lb33.g(Lb33.NPC_XElement_trigger);
        try {
            if (this.q.n) {
                throw new IllegalStateException();
            }
            this.q.bt(this.g, this.d);
            Lb33.d(Lb33.NPC_XElement_trigger);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.NPC_XElement_trigger);
            throw throwable;
        }
    }

    Q32(Npc npc, Vector3 vector3, Quaternion quaternion) {
        this.g = vector3;
        this.d = quaternion;
        this.q = npc;
    }
}

