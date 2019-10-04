package com.jagex.game.runetek6.config.vartype.bit;

import com.jagex.game.runetek6.config.vartype.VarType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;
import tfu.Gp293;

public class VarBitType implements Gp293 {
   private static final boolean debug = true;
   private static final Logger logger = LoggerFactory.getLogger(VarBitType.class);
   private static int[] masklookup = new int[32];
   public VarType baseVar;
   public String debugName;
   public int debugNameHash32;
   public int endBit;
   public int id;
   public VarBitTypeListClient myList;
   public int startBit;

   protected void decode(Gg3 var1, int var2, boolean var3) {
      // $FF: Couldn't be decompiled
   }

   protected void decode(Gg3 var1, boolean var2) {
      while(true) {
         int var3 = Gg3.ar(var1);
         if (var3 == 0) {
            return;
         }

         this.decode(var1, var3, var2);
      }
   }

   public int getVarbitValue(int var1) {
      int var2 = masklookup[this.endBit - this.startBit];
      return var1 >> this.startBit & var2;
   }

   public int setVarbitValue(int var1, int var2) throws VarBitOverflowException {
      int var3 = masklookup[this.endBit - this.startBit];
      if (var2 >= 0 && var2 <= var3) {
         var3 <<= this.startBit;
         return var1 & ~var3 | var2 << this.startBit & var3;
      } else {
         throw new VarBitOverflowException(this.debugName, var2, var3);
      }
   }

   public boolean isValidDefinition() {
      return this.myList != null && this.baseVar != null;
   }

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         masklookup[var1] = var0 - 1;
         var0 += var0;
      }

   }
}
