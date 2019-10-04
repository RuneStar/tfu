package tfu;

class T690 extends Cx556 {
   private static final boolean g = false;
   private long d;
   Dn555 e = new Dn555();
   Gx298 j = new Gx298();
   private M688 q;

   private static void h(T690 var0, U691 var1, int[] var2, int var3, int var4, int var5) {
      if ((var0.q.m[var1.g] & 4) != 0 && var1.u < 0) {
         int var6 = var0.q.a[var1.g] / Cd585.h;

         while(true) {
            int var7 = (1048575 + var6 - var1.o) / var6;
            if (var7 > var4) {
               var1.o += var6 * var4;
               break;
            }

            var1.n.j(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.o += var6 * var7 - 1048576;
            int var8 = Cd585.h / 100;
            int var9 = 262144 / var6;
            if (var9 < var8) {
               var8 = var9;
            }

            Cs635 var10 = var1.n;
            if (var0.q.i[var1.g] == 0) {
               var1.n = var1.q.d(Cs635.bn(var10), Cs635.bw(var10), Cs635.bj(var10));
            } else {
               var1.n = var1.q.d(Cs635.bn(var10), 0, Cs635.bj(var10));
               M688.f(var0.q, var1, var1.d.q[var1.h] < 0);
               Cs635.by(var1.n, var8, Cs635.bw(var10));
            }

            if (var1.d.q[var1.h] < 0) {
               Cs635.bq(var1.n, -1);
            }

            Cs635.bv(var10, var8);
            var10.j(var2, var3, var5 - var3);
            if (Cs635.bm(var10)) {
               var0.e.h(var10);
            }
         }
      }

      var1.n.j(var2, var3, var4);
   }

   protected Cx556 d() {
      U691 var1;
      do {
         var1 = (U691)Gx298.c(this.j);
         if (var1 == null) {
            return null;
         }
      } while(var1.n == null);

      return var1.n;
   }

   protected int q() {
      return 0;
   }

   public void e(int var1) {
      this.e.e(var1);

      for(U691 var3 = (U691)Gx298.i(this.j); var3 != null; var3 = (U691)Gx298.c(this.j)) {
         if (!M688.ax(this.q, var3)) {
            int var2 = var1;

            do {
               if (var2 <= var3.k) {
                  s(this, var3, var2);
                  var3.k -= var2;
                  break;
               }

               s(this, var3, var3.k);
               var2 -= var3.k;
            } while(!M688.au(this.q, var3, (int[])null, 0, var2));
         }
      }

   }

   private static void s(T690 var0, U691 var1, int var2) {
      if ((var0.q.m[var1.g] & 4) != 0 && var1.u < 0) {
         int var3 = var0.q.a[var1.g] / Cd585.h;
         int var4 = (1048575 + var3 - var1.o) / var3;
         var1.o = var1.o + var3 * var2 & 1048575;
         if (var4 <= var2) {
            Cs635 var5 = var1.n;
            if (var0.q.i[var1.g] == 0) {
               var1.n = var1.q.d(Cs635.bn(var5), Cs635.bw(var5), Cs635.bj(var5));
            } else {
               var1.n = var1.q.d(Cs635.bn(var5), 0, Cs635.bj(var5));
               M688.f(var0.q, var1, var1.d.q[var1.h] < 0);
            }

            if (var1.d.q[var1.h] < 0) {
               Cs635.bq(var1.n, -1);
            }

            var2 = var1.o / var3;
         }
      }

      var1.n.e(var2);
   }

   T690(M688 var1) {
      this.q = var1;
   }

   public void j(int[] var1, int var2, int var3) {
      this.e.j(var1, var2, var3);

      for(U691 var6 = (U691)Gx298.i(this.j); var6 != null; var6 = (U691)Gx298.c(this.j)) {
         if (!M688.ax(this.q, var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if (var5 <= var6.k) {
                  h(this, var6, var1, var4, var5, var4 + var5);
                  var6.k -= var5;
                  break;
               }

               h(this, var6, var1, var4, var6.k, var4 + var5);
               var4 += var6.k;
               var5 -= var6.k;
            } while(!M688.au(this.q, var6, var1, var4, var5));
         }
      }

   }

   protected Cx556 g() {
      U691 var1 = (U691)Gx298.i(this.j);
      if (var1 == null) {
         return null;
      } else {
         return (Cx556)(var1.n != null ? var1.n : this.d());
      }
   }
}
