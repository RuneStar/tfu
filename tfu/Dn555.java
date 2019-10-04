package tfu;

public class Dn555 extends Cx556 {
   private static boolean d;
   private static final boolean g = true;
   private Gx298 e = new Gx298();
   private int h = 0;
   private Gx298 j = new Gx298();
   private long q;
   private int s = -1;

   public static final synchronized void s(Dn555 var0, Cx556 var1) {
      Cx556.ef(var1);
   }

   public final synchronized void h(Cx556 var1) {
      if (!d && Cx556.ek(var1)) {
         d = true;
         (new Throwable("Warning: if you were calling playstream in an attempt to get the stream reprioritised, it doesn't work that way any more - you should set wantmix instead")).printStackTrace();
      }

      Gx298.m(this.j, var1);
   }

   private static void u(Dn555 var0, Cp628 var1) {
      Cp628.ef(var1);
      var1.g();
      var1.g = null;
      Ln265 var2 = var0.e.g.bo;
      if (var2 == var0.e.g) {
         var0.s = -1;
      } else {
         var0.s = ((Cp628)var2).d;
      }

   }

   private static void v(Dn555 var0, Ln265 var1, Cp628 var2) {
      while(var1 != var0.e.g && ((Cp628)var1).d <= var2.d) {
         var1 = var1.bo;
      }

      Gx298.n(var2, var1);
      var0.s = ((Cp628)var0.e.g.bo).d;
   }

   protected Cx556 g() {
      return (Cx556)Gx298.i(this.j);
   }

   protected Cx556 d() {
      return (Cx556)Gx298.c(this.j);
   }

   protected int q() {
      return 0;
   }

   private static void z(Dn555 var0, int[] var1, int var2, int var3) {
      for(Cx556 var4 = (Cx556)Gx298.i(var0.j); var4 != null; var4 = (Cx556)Gx298.c(var0.j)) {
         Cx556.ck(var4, var1, var2, var3);
      }

   }

   public final synchronized void e(int var1) {
      do {
         if (this.s < 0) {
            t(this, var1);
            return;
         }

         if (this.h + var1 < this.s) {
            this.h += var1;
            t(this, var1);
            return;
         }

         int var2 = this.s - this.h;
         t(this, var2);
         var1 -= var2;
         this.h += var2;
         r(this);
         Cp628 var3 = (Cp628)Gx298.i(this.e);
         synchronized(var3) {
            int var5 = var3.d(this);
            if (var5 < 0) {
               var3.d = 0;
               u(this, var3);
            } else {
               var3.d = var5;
               v(this, var3.bo, var3);
            }
         }
      } while(var1 != 0);

   }

   private static void t(Dn555 var0, int var1) {
      for(Cx556 var2 = (Cx556)Gx298.i(var0.j); var2 != null; var2 = (Cx556)Gx298.c(var0.j)) {
         var2.e(var1);
      }

   }

   private static void r(Dn555 var0) {
      if (var0.h > 0) {
         for(Cp628 var1 = (Cp628)Gx298.i(var0.e); var1 != null; var1 = (Cp628)Gx298.c(var0.e)) {
            var1.d -= var0.h;
         }

         var0.s -= var0.h;
         var0.h = 0;
      }

   }

   public final synchronized void j(int[] var1, int var2, int var3) {
      long var4 = Gz143.g();
      if (var4 >= this.q + 1000L) {
         this.q = var4;
         if (Gx298.aq(this.j) > 500) {
            System.out.println("MIXER: streams=" + Gx298.aq(this.j) + " - if this is growing uncontrollably, you are leaking streams!");
         }
      }

      do {
         if (this.s < 0) {
            z(this, var1, var2, var3);
            return;
         }

         if (this.h + var3 < this.s) {
            this.h += var3;
            z(this, var1, var2, var3);
            return;
         }

         int var10 = this.s - this.h;
         z(this, var1, var2, var10);
         var2 += var10;
         var3 -= var10;
         this.h += var10;
         r(this);
         Cp628 var5 = (Cp628)Gx298.i(this.e);
         synchronized(var5) {
            int var7 = var5.d(this);
            if (var7 < 0) {
               var5.d = 0;
               u(this, var5);
            } else {
               var5.d = var7;
               v(this, var5.bo, var5);
            }
         }
      } while(var3 != 0);

   }
}
