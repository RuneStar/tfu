package com.jagex.jnibindings.runetek6;

import java.lang.ref.PhantomReference;

class Q291 extends PhantomReference {
   private final int g;

   public Q291(LuaRef var1, int var2) {
      super(var1, Scripting.s());
      this.g = var2;
   }

   public static int g(Q291 var0) {
      return var0.g;
   }
}
