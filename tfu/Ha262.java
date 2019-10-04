package tfu;

import java.util.Iterator;

public final class Ha262 implements Iterable {
   Ln265[] d;
   private Ln265 e;
   int g;
   private int h = 0;
   private Ln265 j;
   private long q;

   public static Ln265 d(Ha262 var0, long var1) {
      var0.q = var1;
      Ln265 var3 = var0.d[(int)(var1 & (long)(var0.g - 1))];

      for(var0.j = var3.bo; var0.j != var3; var0.j = var0.j.bo) {
         if (var0.j.bq == var1) {
            Ln265 var4 = var0.j;
            var0.j = var0.j.bo;
            return var4;
         }
      }

      var0.j = null;
      return null;
   }

   public static void q(Ha262 var0, Ln265 var1, long var2) {
      if (var1.bl != null) {
         Ln265.ef(var1);
      }

      Ln265 var4 = var0.d[(int)(var2 & (long)(var0.g - 1))];
      var1.bl = var4.bl;
      var1.bo = var4;
      var1.bl.bo = var1;
      var1.bo.bl = var1;
      var1.bq = var2;
   }

   public static void j(Ha262 var0) {
      for(int var1 = 0; var1 < var0.g; ++var1) {
         Ln265 var2 = var0.d[var1];

         while(true) {
            Ln265 var3 = var2.bo;
            if (var3 == var2) {
               break;
            }

            Ln265.ef(var3);
         }
      }

      var0.j = null;
      var0.e = null;
   }

   public static Ln265 e(Ha262 var0) {
      var0.h = 0;
      return h(var0);
   }

   public static Ln265 h(Ha262 var0) {
      Ln265 var1;
      if (var0.h > 0 && var0.e != var0.d[var0.h - 1]) {
         var1 = var0.e;
         var0.e = var1.bo;
         return var1;
      } else {
         do {
            if (var0.h >= var0.g) {
               return null;
            }

            var1 = var0.d[var0.h++].bo;
         } while(var1 == var0.d[var0.h - 1]);

         var0.e = var1.bo;
         return var1;
      }
   }

   public Iterator iterator() {
      return new Hv415(this);
   }

   public Ha262(int var1) {
      this.g = var1;
      this.d = new Ln265[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Ln265 var3 = this.d[var2] = new Ln265();
         var3.bo = var3;
         var3.bl = var3;
      }

   }
}
