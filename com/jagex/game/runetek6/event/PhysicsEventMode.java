package com.jagex.game.runetek6.event;

import com.jagex.core.constants.J204;

public enum PhysicsEventMode implements J204 {
   COLLISION(1),
   OFF(0),
   VOLUME(2);

   private static PhysicsEventMode[] byId;
   private final int id;

   private PhysicsEventMode(int var3) {
      this.id = var3;
   }

   public int getId() {
      return this.id;
   }

   static {
      PhysicsEventMode[] var0 = values();
      int var1 = -1;
      PhysicsEventMode[] var2 = var0;
      int var3 = var0.length;

      int var4;
      PhysicsEventMode var5;
      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if (var5.id > var1) {
            var1 = var5.id;
         }
      }

      byId = new PhysicsEventMode[var1 + 1];
      var2 = var0;
      var3 = var0.length;

      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if (byId[var5.id] != null) {
            throw new IllegalStateException();
         }

         byId[var5.id] = var5;
      }

   }

   public static PhysicsEventMode byId(int var0) {
      return var0 >= 0 && var0 < byId.length ? byId[var0] : null;
   }
}
