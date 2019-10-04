package rs2.client;

import com.jagex.game.runetek6.comms.broadcast.SceneryConfig;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.xelement.G104;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import com.jagex.maths.Vector3;
import tfu.Br121;

class Z392 implements Br121 {
   // $FF: synthetic field
   final GameEntity d;
   // $FF: synthetic field
   final SceneryConfig g;
   // $FF: synthetic field
   final Runnable j;
   // $FF: synthetic field
   final Vector3 q;

   public boolean d() {
      return this.d.getScene() != null;
   }

   public static void j(Z392 var0, H393 var1) {
      if (var1 != null) {
         var1.d();
      }

   }

   public H393 g() throws Exception {
      XElementLibrary var1 = XElement.ai;
      XElement[] var2 = new XElement[this.g.originalElementAddresses.length];

      for(int var3 = 0; var3 < this.g.originalElementAddresses.length; ++var3) {
         client.logger.trace("Getting element with address " + this.g.originalElementAddresses[var3]);
         var2[var3] = XElementLibrary.w(var1, this.g.originalElementAddresses[var3]);
      }

      G104 var4 = XElement.bj(this.d, var2, this.q, client.lh, true);
      client.logger.trace("Entity constructed.");
      return new Ai394(this, var4);
   }

   Z392(SceneryConfig var1, GameEntity var2, Vector3 var3, Runnable var4) {
      this.d = var2;
      this.q = var3;
      this.j = var4;
      this.g = var1;
   }

   public int e() {
      return client.aa(Vector3.z(this.d.getWorldTransform().trans, this.q));
   }

   public boolean q() {
      return true;
   }
}
