package rs2.client.worldelement;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import tfu.Lb33;

class Q32 extends EventHandler {
   // $FF: synthetic field
   final Quaternion d;
   // $FF: synthetic field
   final Vector3 g;
   // $FF: synthetic field
   final Npc q;

   public void g(GameEntity var1, Object var2) {
      Lb33.g(Lb33.NPC_XElement_trigger);

      try {
         if (this.q.n) {
            throw new IllegalStateException();
         } else {
            this.q.bt(this.g, this.d);
            Lb33.d(Lb33.NPC_XElement_trigger);
         }
      } finally {
         Lb33.d(Lb33.NPC_XElement_trigger);
      }
   }

   Q32(Npc var1, Vector3 var2, Quaternion var3) {
      this.g = var2;
      this.d = var3;
      this.q = var1;
   }
}
