package tfu;

import java.lang.ref.ReferenceQueue;

public final class Fo439 {
   private Fd458[] d = new Fd458[16];
   private int g;
   private ReferenceQueue q = new ReferenceQueue();

   public void g(Object var1, Object var2) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         e(this);
         int var3 = System.identityHashCode(var1);
         int var4 = var3 & this.d.length - 1;
         Fd458 var5 = this.d[var4];
         if (var5 == null) {
            this.d[var4] = new Fd458(var1, this.q, var3, var2);
            ++this.g;
            if (this.g >= this.d.length) {
               j(this);
            }
         } else {
            while(var5.get() != var1) {
               if (var5.q == null) {
                  var5.q = new Fd458(var1, this.q, var3, var2);
                  ++this.g;
                  if (this.g >= this.d.length) {
                     j(this);
                  }

                  return;
               }

               var5 = var5.q;
            }

            var5.d = var2;
         }

      }
   }

   public static Object d(Fo439 var0, Object var1) {
      if (var1 == null) {
         return null;
      } else {
         e(var0);
         int var2 = System.identityHashCode(var1);
         int var3 = var2 & var0.d.length - 1;

         for(Fd458 var4 = var0.d[var3]; var4 != null; var4 = var4.q) {
            if (var4.get() == var1) {
               return var4.d;
            }
         }

         return null;
      }
   }

   private static void j(Fo439 var0) {
      Fd458[] var1 = var0.d;
      var0.d = new Fd458[var1.length * 2];
      Fd458[] var2 = var1;
      int var3 = var1.length;

      Fd458 var6;
      for(int var4 = 0; var4 < var3; ++var4) {
         for(Fd458 var5 = var2[var4]; var5 != null; var5 = var6) {
            var6 = var5.q;
            int var7 = var5.g & var0.d.length - 1;
            var5.q = var0.d[var7];
            var0.d[var7] = var5;
         }
      }

   }

   private static void e(Fo439 var0) {
      while(true) {
         Fd458 var1 = (Fd458)var0.q.poll();
         if (var1 == null) {
            return;
         }

         int var2 = var1.g & var0.d.length - 1;
         Fd458 var3 = var0.d[var2];
         if (var3 == var1) {
            var0.d[var2] = var1.q;
            --var0.g;
         } else {
            while(var3 != null && var3.q != var1) {
               var3 = var3.q;
            }

            if (var3 != null) {
               var3.q = var1.q;
               --var0.g;
            }
         }
      }
   }

   public static void q(Fo439 var0, Object var1) {
      if (var1 != null) {
         e(var0);
         int var2 = System.identityHashCode(var1);
         int var3 = var2 & var0.d.length - 1;
         Fd458 var4 = var0.d[var3];
         if (var4 != null) {
            if (var4.get() == var1) {
               var0.d[var3] = var4.q;
               --var0.g;
            } else {
               while(true) {
                  Fd458 var5 = var4.q;
                  if (var5 == null) {
                     break;
                  }

                  if (var5.get() == var1) {
                     var4.q = var5.q;
                     --var0.g;
                     break;
                  }

                  var4 = var5;
               }
            }

         }
      }
   }
}
