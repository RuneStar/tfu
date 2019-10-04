package com.jagex.jnibindings.runetek6;

import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
public class LuaRef {
   private final int ref;

   @Bs1
   @Be2
   public LuaRef(int var1) {
      this.ref = var1;
      Scripting.j(this, this.ref);
   }

   public static int g(LuaRef var0) {
      return var0.ref;
   }
}
