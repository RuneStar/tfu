package rs2.client;

import java.awt.Color;
import rs2.client.loading.Q162;

class S401 implements Runnable {
   // $FF: synthetic field
   final B402 g;

   S401(B402 var1) {
      this.g = var1;
   }

   public void run() {
      while(true) {
         if (!this.g.q) {
            Q162 var1 = this.g.h;
            this.g.h(var1.d, var1.g, Av403.g, Av403.q, Av403.d, Color.WHITE);

            try {
               Thread.sleep(20L);
               continue;
            } catch (InterruptedException var3) {
            }
         }

         B402.e(this.g);
         this.g.q = false;
         this.g.l = null;
         this.g.s = null;
         this.g.d = null;
         return;
      }
   }
}
