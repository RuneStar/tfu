package rs2.client;

import com.jagex.game.runetek6.gameentity.GameEntity;
import java.util.Iterator;
import tfu.Gc330;
import tfu.Me312;

public abstract class Ag389 {
   protected Me312 q;

   static final void s(Ag389 var0) {
      try {
         var0.d();
      } catch (Exception var2) {
         client.logger.error("", var2);
      }

   }

   final boolean h() {
      if (client.y(client.ac)) {
         return true;
      } else if (Gc330.j() == null) {
         return true;
      } else {
         if (this.q == null) {
            this.q = new Me312();

            try {
               this.g();
            } catch (Exception var3) {
               client.logger.error("", var3);
            }
         }

         Iterator var1 = this.q.iterator();

         while(var1.hasNext()) {
            GameEntity var2 = (GameEntity)var1.next();
            if (client.ca.containsKey(var2)) {
               return true;
            }

            var1.remove();
         }

         return false;
      }
   }

   protected abstract void d();

   protected abstract void g();

   public abstract String toString();
}
