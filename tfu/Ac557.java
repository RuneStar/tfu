package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.sound.SoundManager;
import rs2.client.worldelement.Npc;

public class Ac557 extends Am548 {
   private static final Logger logger = LoggerFactory.getLogger(Ac557.class);
   int c;

   public Ac557(An52 var1) {
      super(var1);
   }

   void g() {
      int var1 = this.c;
      boolean var2 = super.k;
      if (super.j instanceof Npc) {
         int var3 = At476.h((Npc)super.j);
         if (var1 != var3) {
            this.c = var3;
         }
      }

      if ((this.c != var1 || super.k != var2) && super.a != null) {
         logger.trace("stopped bgsound stream due to multiloc/npc or player change");
         Dn555.s(SoundManager.t, super.a);
         super.a = null;
         super.o = null;
         super.i = null;
      }

   }
}
