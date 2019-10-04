package tfu;

import com.jagex.js5.js5;

public final class Gt488 implements Ib29 {
   private final String d;
   private final js5 g;
   private int q = -1;

   public static Integer s(Gt488 var0, String var1) {
      int var2 = var0.g.getgroupid(var1);
      return var2 >= 0 ? var2 : null;
   }

   public byte[] h(Integer var1) throws Hs30 {
      if (!this.g.q(var1)) {
         String var2 = "Unrecognised " + this.d + ": " + var1;
         Object.logger.error(var2);
         if (this.q >= 0 && this.g.q(this.q)) {
            while(!this.g.requestgroupdownload(this.q)) {
               Thread.yield();
            }

            return this.g.getfile(this.q, 0);
         } else {
            throw new Hs30(var2);
         }
      } else {
         while(!this.g.requestgroupdownload(var1)) {
            Thread.yield();
         }

         return this.g.getfile(var1, 0);
      }
   }

   public String getIdentifier() {
      return this.d;
   }

   public Gt488(js5 var1, String var2) {
      if (var1 == null) {
         throw new IllegalArgumentException();
      } else {
         this.g = var1;
         this.d = var2;
      }
   }
}
