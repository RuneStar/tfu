package tfu;

import com.jagex.js5.js5;

public class Ca649 {
   private static final boolean g = true;
   private js5 d;
   private Ha262 e = new Ha262(256);
   private Ha262 h = new Ha262(256);
   private Ha262 j = new Ha262(256);
   private js5 q;

   public static Cj551 g(Ca649 var0, int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      Cj551 var7 = (Cj551)Ha262.d(var0.h, var5);
      if (var7 != null) {
         return var7;
      } else if (var3 != null && var3[0] <= 0) {
         return null;
      } else {
         Co638 var8 = Co638.g(var0.d, var1, var2);
         if (var8 == null) {
            return null;
         } else {
            var7 = var8.d();
            Ha262.q(var0.h, var7, var5);
            if (var3 != null) {
               var3[0] -= var7.e.length;
            }

            return var7;
         }
      }
   }

   public Ca649(js5 var1, js5 var2) {
      this.d = var1;
      this.q = var2;
   }

   public Cj551 q(int var1, int[] var2) {
      if (js5.t(this.d) == 1) {
         return g(this, 0, var1, var2);
      } else if (js5.z(this.d, var1) == 1) {
         return g(this, var1, 0, var2);
      } else {
         throw new RuntimeException("Unable to determine if id is groupid or fileid");
      }
   }

   public Ci646 j(int var1, int[] var2) {
      if (js5.t(this.q) == 1) {
         return d(this, 0, var1, var2);
      } else if (js5.z(this.q, var1) == 1) {
         return d(this, var1, 0, var2);
      } else {
         throw new RuntimeException("Unable to determine if id is groupid or fileid");
      }
   }

   public static Ci646 d(Ca649 var0, int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      Ci646 var7 = (Ci646)Ha262.d(var0.e, var5);
      if (var7 != null) {
         return var7;
      } else if (var3 != null && var3[0] <= 0) {
         return null;
      } else {
         Cg550 var8 = (Cg550)Ha262.d(var0.j, var5);
         if (var8 == null) {
            var8 = Cg550.b(var0.q, var1, var2);
            if (var8 == null) {
               return null;
            }

            Ha262.q(var0.j, var8, var5);
         }

         var7 = var8.l();
         if (var7 == null) {
            return null;
         } else {
            Cg550.ef(var8);
            Ha262.q(var0.e, var7, var5);
            return var7;
         }
      }
   }
}
