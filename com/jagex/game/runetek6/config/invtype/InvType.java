package com.jagex.game.runetek6.config.invtype;

import com.jagex.game.runetek6.script.ScriptEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;
import tfu.Kp349;

public class InvType extends Kp349 {
   private static final boolean debug = true;
   private static final Logger logger = LoggerFactory.getLogger(InvType.class);
   public int myId;
   public int size = 0;

   public String toString() {
      return "{ InvType : " + this.myId + " (size=" + this.size + ") }";
   }

   protected void decode(Gg3 var1) {
      while(true) {
         int var2 = Gg3.ar(var1);
         if (var2 == 0) {
            return;
         }

         this.decode(var1, var2);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetSize() {
      return this.size;
   }

   protected void decode(Gg3 var1, int var2) {
      if (var2 == 2) {
         this.size = Gg3.au(var1);
      } else {
         logger.info("Error unrecognised .inv config code: {}", var2);
      }

   }
}
