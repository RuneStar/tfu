package com.jagex.jnibindings.runetek6;

import tfu.Hi86;
import tfu.Ia63;
import tfu.Id102;

final class J372 implements Ia63 {
   public Skeleton g(byte[] var1, Integer var2, Hi86 var3) throws Id102 {
      Skeleton var4 = new Skeleton(var3);
      if (Skeleton.q(var4, var1, 0.015625F) == 0) {
         throw new Id102("Error loading skeleton");
      } else {
         return var4;
      }
   }

   public boolean resourceNeedsRefCounting() {
      return true;
   }
}
