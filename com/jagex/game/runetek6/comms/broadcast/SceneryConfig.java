package com.jagex.game.runetek6.comms.broadcast;

import tfu.Gg3;

public class SceneryConfig {
   public int collisionMask;
   public int[] originalElementAddresses;

   public static SceneryConfig DeserializeHelper(byte[] var0) {
      Gg3 var1 = new Gg3(var0);
      SceneryConfig var2 = new SceneryConfig();
      var2.collisionMask = Gg3.bv(var1);
      int var3 = Gg3.bn(var1);
      if (var3 > 0) {
         var2.originalElementAddresses = new int[var3];

         for(int var4 = 0; var4 < var3; ++var4) {
            var2.originalElementAddresses[var4] = Gg3.bn(var1);
         }
      }

      return var2;
   }
}
