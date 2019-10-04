package com.jagex.game.runetek6.config.vartype.bit;

public final class VarBitOverflowException extends Exception {
   public VarBitOverflowException(int var1, int var2, int var3) {
      super("Varbit oveflow on varbit " + var1 + " Value " + var2 + " is outside the range 0-" + var3);
   }

   public VarBitOverflowException(String var1, int var2, int var3) {
      super("Varbit oveflow on varbit '" + var1 + "' Value " + var2 + " is outside the range 0-" + var3);
   }
}
