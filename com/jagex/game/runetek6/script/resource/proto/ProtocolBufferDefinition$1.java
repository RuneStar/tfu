package com.jagex.game.runetek6.script.resource.proto;

import java.util.LinkedList;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Ia63;
import tfu.Js343;
import tfu.Mj383;

final class ProtocolBufferDefinition$1 implements Ia63 {
   public ProtocolBufferDefinition constructResource(byte[] var1, String var2, Hi86 var3) {
      Gg3 var4 = new Gg3(var1);
      String var5 = var4.bh();
      int var6 = Gg3.au(var4);
      LinkedList var7 = new LinkedList();

      for(int var8 = 0; var8 < var6; ++var8) {
         int var9 = Gg3.bd(var4);
         String var10 = var4.bh();
         var7.add(new Js343(var10, var9));
      }

      byte[] var11 = new byte[var4.r.length - var4.v];
      Gg3.bx(var4, var11, 0, var11.length);
      return new ProtocolBufferDefinition(var5.replace('/', '.'), var7, Mj383.q(var11));
   }

   public boolean resourceNeedsRefCounting() {
      return false;
   }
}
