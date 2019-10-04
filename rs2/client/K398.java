package rs2.client;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.jnibindings.runetek6.LuaRef;
import rs2.client.worldelement.player;
import tfu.Az399;
import tfu.Gc330;

final class K398 extends Ag389 {
   LuaRef g;
   // $FF: synthetic field
   final Az399 d;

   protected void g() {
      GameEntity.em(super.q, new P397(this));
   }

   protected void d() {
      player var1 = Gc330.j();
      var1.triggerEvent(this.d.j, this.g);
   }

   public String toString() {
      return "script message " + this.d.e + ":" + this.d.h;
   }

   K398(Az399 var1) {
      this.d = var1;
   }
}
