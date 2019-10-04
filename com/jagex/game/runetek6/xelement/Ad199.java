package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import tfu.Mz200;

class Ad199 implements Mz200 {
   // $FF: synthetic field
   final XElementLibrary d;
   // $FF: synthetic field
   final GameEntity g;

   public int g() {
      return this.d.h.g(this.g.getWorldTransform().trans);
   }

   Ad199(XElementLibrary var1, GameEntity var2) {
      this.g = var2;
      this.d = var1;
   }
}
