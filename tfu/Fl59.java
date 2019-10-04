package tfu;

import java.lang.ref.ReferenceQueue;

public final class Fl59 {
   private Fh453[] d = new Fh453[16];
   private int g;
   private ReferenceQueue j = new ReferenceQueue();
   private ReferenceQueue q = new ReferenceQueue();

   public static Object d(Fl59 var0, Object var1) {
      if (var1 == null) {
         return null;
      } else {
         j(var0);
         int var2 = System.identityHashCode(var1);
         int var3 = var2 & var0.d.length - 1;

         for(Fh453 var4 = var0.d[var3]; var4 != null; var4 = var4.q) {
            if (var4.get() == var1) {
               return var4.d.get();
            }
         }

         return null;
      }
   }

   private static void q(Fl59 var0) {
      Fh453[] var1 = var0.d;
      var0.d = new Fh453[var1.length * 2];
      Fh453[] var2 = var1;
      int var3 = var1.length;

      Fh453 var6;
      for(int var4 = 0; var4 < var3; ++var4) {
         for(Fh453 var5 = var2[var4]; var5 != null; var5 = var6) {
            var6 = var5.q;
            int var7 = var5.g & var0.d.length - 1;
            var5.q = var0.d[var7];
            var0.d[var7] = var5;
         }
      }

   }

   private static void j(Fl59 var0) {
      while(true) {
         Fh453 var1 = (Fh453)var0.q.poll();
         if (var1 == null) {
            while(true) {
               while(true) {
                  Fa452 var5;
                  Fh453 var6;
                  do {
                     var5 = (Fa452)var0.j.poll();
                     if (var5 == null) {
                        return;
                     }

                     var6 = var5.g;
                  } while(var6.d != var5);

                  int var7 = var6.g & var0.d.length - 1;
                  Fh453 var4 = var0.d[var7];
                  if (var4 == var6) {
                     var0.d[var7] = var6.q;
                     --var0.g;
                  } else {
                     while(var4 != null && var4.q != var6) {
                        var4 = var4.q;
                     }

                     if (var4 != null) {
                        var4.q = var6.q;
                        --var0.g;
                     }
                  }
               }
            }
         }

         int var2 = var1.g & var0.d.length - 1;
         Fh453 var3 = var0.d[var2];
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

   public void g(Object var1, Object var2) {
      if (var1 == null) {
         throw new NullPointerException();
      } else if (var2 == null) {
         throw new NullPointerException();
      } else {
         j(this);
         int var3 = System.identityHashCode(var1);
         int var4 = var3 & this.d.length - 1;
         Fh453 var5 = this.d[var4];
         if (var5 == null) {
            this.d[var4] = new Fh453(var1, this.q, var3, var2, this.j);
            ++this.g;
            if (this.g >= this.d.length) {
               q(this);
            }
         } else {
            while(var5.get() != var1) {
               if (var5.q == null) {
                  var5.q = new Fh453(var1, this.q, var3, var2, this.j);
                  ++this.g;
                  if (this.g >= this.d.length) {
                     q(this);
                  }

                  return;
               }

               var5 = var5.q;
            }

            var5.g(var2, this.j);
         }

      }
   }
}
