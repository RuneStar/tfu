package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

public enum CircularIDWidth {
   ONE_BYTE(255, 1),
   TWO_BYTES(65535, 2);

   public final int bytes;
   public final int mask;

   public int diffIDs(int var1, int var2) {
      var2 &= this.mask;
      var1 &= this.mask;
      if (Math.abs(var1 - var2) > this.mask >>> 1) {
         if (var1 < var2) {
            var1 += this.mask + 1;
         } else {
            var2 += this.mask + 1;
         }
      }

      return var1 - var2;
   }

   public void putID(int var1, ByteBuffer var2) {
      // $FF: Couldn't be decompiled
   }

   public int getID(ByteBuffer var1) {
      // $FF: Couldn't be decompiled
   }

   public int sumIDs(int var1, int var2) {
      return var1 + var2 & this.mask;
   }

   private CircularIDWidth(int var3, int var4) {
      this.mask = var3;
      this.bytes = var4;
   }
}
