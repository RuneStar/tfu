// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.worldelement;

import tfu.Lb33;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.Vector3;
import com.jagex.maths.Quaternion;
import com.jagex.game.runetek6.event.EventHandler;

class Q32 extends EventHandler
{
    final /* synthetic */ Quaternion d;
    final /* synthetic */ Vector3 g;
    final /* synthetic */ Npc q;
    
    public void g(final GameEntity gameEntity, final Object o) {
        Lb33.g(Lb33.NPC_XElement_trigger);
        try {
            if (this.q.n) {
                throw new IllegalStateException();
            }
            this.q.bt(this.g, this.d);
        }
        finally {
            Lb33.d(Lb33.NPC_XElement_trigger);
        }
    }
    
    Q32(final Npc q, final Vector3 g, final Quaternion d) {
        this.g = g;
        this.d = d;
        this.q = q;
    }
}
