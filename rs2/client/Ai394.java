package rs2.client;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.xelement.G104;
import tfu.Ll42;

class Ai394 implements H393 {
   // $FF: synthetic field
   final Z392 d;
   // $FF: synthetic field
   final G104 g;

   public void d() {
      G104.v(this.g);
   }

   Ai394(Z392 var1, G104 var2) {
      this.g = var2;
      this.d = var1;
   }

   public void g() {
      try {
         GameEntity var1 = this.g.j();
         if (var1 == null) {
            return;
         }

         Ll42.q(client.gz, var1);
         client.gz.d(var1, (float)client.gn, (float)client.gj, client.ds, this.d.g.collisionMask);
         client.logger.trace("Done adding " + var1.bg);
         this.d.j.run();
         var1.setProperty("spawnyMcSpawnins_AsynchronousTask", (Object)null);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }
}
