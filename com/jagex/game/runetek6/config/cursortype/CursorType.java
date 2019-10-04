package com.jagex.game.runetek6.config.cursortype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Eq28;
import tfu.Fj373;
import tfu.Gg3;

public class CursorType {
   private static final boolean debug = true;
   private static final Logger logger = LoggerFactory.getLogger(CursorType.class);
   public int graphic;
   public int hash32 = 0;
   public int hotspotx;
   public int hotspoty;
   protected CursorTypeList myList;

   protected void decode(Gg3 var1, int var2) {
      if (var2 == 1) {
         this.graphic = Gg3.bf(var1);
      } else if (var2 == 2) {
         this.hotspotx = Gg3.ar(var1);
         this.hotspoty = Gg3.ar(var1);
      } else if (var2 == 127) {
         this.hash32 = Gg3.bd(var1);
      } else {
         logger.info("Error unrecognised .cursor config code: {}", var2);
      }

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

   public synchronized Fj373 getCursor() {
      Fj373 var1 = (Fj373)this.myList.cursorCache.g((long)this.graphic);
      if (var1 != null) {
         return var1;
      } else {
         var1 = Fj373.g(this.myList.sprites, this.graphic, 0);
         if (var1 != null) {
            Eq28.j(this.myList.cursorCache, var1, (long)this.graphic);
         }

         return var1;
      }
   }
}
