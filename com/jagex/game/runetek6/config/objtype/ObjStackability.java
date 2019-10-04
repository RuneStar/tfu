package com.jagex.game.runetek6.config.objtype;

import com.jagex.core.constants.J204;

public enum ObjStackability implements J204 {
   ALWAYS(1),
   NEVER(2),
   SOMETIMES(0);

   private final int id;

   private ObjStackability(int var3) {
      this.id = var3;
   }

   public int getId() {
      return this.id;
   }
}
