package com.jagex.game.runetek6.gameentity;

import com.jagex.game.runetek6.event.EventHandler;

class E333 extends EventHandler {
   // $FF: synthetic field
   final GameEntity g;

   E333(GameEntity var1) {
      this.g = var1;
   }

   public static void g(E333 var0, GameEntity var1, Object var2) {
      var0.g.bz.runScriptEvent("footPlacedDecalEvent", var1, var2);
   }
}
