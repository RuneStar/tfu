package com.jagex.jnibindings.runetek6;

import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
public class LuaFunctionRef extends LuaRef {
   private final String functionName;

   @Bs1
   @Be2
   public LuaFunctionRef(int var1, String var2) {
      super(var1);
      this.functionName = var2;
   }

   @Bs1
   @Be2
   public LuaFunctionRef(int var1) {
      super(var1);
      this.functionName = "";
   }

   public String toString() {
      return "{ LuaFunctionRef " + g(this) + " }";
   }

   public static String j(LuaFunctionRef var0) {
      return var0.functionName == null ? "" : var0.functionName;
   }
}
