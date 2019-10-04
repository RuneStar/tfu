package tfu;

import com.jagex.js5.js5;

public class Gu487 implements Ib29 {
   public static final int g = 16777216;
   private final js5 d;
   private int e = -1;
   private final String j;
   private final int q;

   public String getIdentifier() {
      return this.j;
   }

   public byte[] h(Integer var1) throws Hs30 {
      if (!this.d.q(this.q)) {
         throw new Hs30("Unrecognised " + this.j + ": " + var1);
      } else {
         while(!this.d.requestgroupdownload(this.q)) {
            Thread.yield();
         }

         byte[] var2 = this.d.getfile(this.q, var1);
         return var2;
      }
   }

   public static Integer s(Gu487 var0, String var1) {
      int var2 = var0.d.getfileid(var0.q, var1);
      return var2 >= 0 ? var2 : null;
   }

   public Gu487(js5 var1, String var2, String var3) {
      if (var1 == null) {
         throw new IllegalArgumentException();
      } else {
         this.d = var1;
         this.j = var3;
         this.q = this.d.getgroupid(var2);
      }
   }
}
