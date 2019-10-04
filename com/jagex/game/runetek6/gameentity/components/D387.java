package com.jagex.game.runetek6.gameentity.components;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.Q344;

class D387 implements Q344 {
   // $FF: synthetic field
   final MappedEventComponent g;

   public void g(GameEntity var1) {
      if (this.g.q != null) {
         this.g.q.remove(var1);
      }

      if (this.g.j != null) {
         this.g.j.remove(var1);
      }

      MappedEventComponent.s(this.g, var1);
   }

   D387(MappedEventComponent var1) {
      this.g = var1;
   }
}
