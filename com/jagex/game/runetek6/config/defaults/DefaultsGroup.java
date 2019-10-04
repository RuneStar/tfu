package com.jagex.game.runetek6.config.defaults;

public enum DefaultsGroup {
   AUDIO(4),
   ERROR(10),
   GRAPHICS(3),
   MAP(1),
   MICROTRANSACTION(5);

   public final int js5GroupId;

   private DefaultsGroup(int var3) {
      this.js5GroupId = var3;
   }
}
