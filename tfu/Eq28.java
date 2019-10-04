package tfu;

public final class Eq28 {
   private static final boolean g = false;
   private int d;
   private Hn359 e;
   private Ha262 j;
   private int q;

   public Eq28(int var1, int var2) {
      this.e = new Hn359();
      this.d = var1;
      this.q = var1;

      int var3;
      for(var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
      }

      this.j = new Ha262(var3);
   }

   public Object g(long var1) {
      Fv466 var3 = (Fv466)Ha262.d(this.j, var1);
      if (var3 == null) {
         return null;
      } else {
         Object var4 = var3.g();
         if (var4 == null) {
            Fv466.ef(var3);
            Fv466.t(var3);
            this.q += var3.d;
            return null;
         } else {
            if (var3.d()) {
               En568 var5 = new En568(var4, var3.d);
               Ha262.q(this.j, var5, var3.bq);
               Hn359.q(this.e, var5);
               var5.p = 0L;
               Fv466.ef(var3);
               Fv466.t(var3);
            } else {
               Hn359.q(this.e, var3);
               var3.p = 0L;
            }

            return var4;
         }
      }
   }

   public static void s(Eq28 var0) {
      Hn359.d(var0.e);
      Ha262.j(var0.j);
      var0.q = var0.d;
   }

   private static void q(Eq28 var0, Fv466 var1) {
      if (var1 != null) {
         Fv466.ef(var1);
         Fv466.t(var1);
         var0.q += var1.d;
      }

   }

   public static void j(Eq28 var0, Object var1, long var2) {
      var0.e(var1, var2, 1);
   }

   public static void d(Eq28 var0, long var1) {
      Fv466 var3 = (Fv466)Ha262.d(var0.j, var1);
      q(var0, var3);
   }

   public void h(int var1) {
      for(Fv466 var2 = (Fv466)Hn359.h(this.e); var2 != null; var2 = (Fv466)Hn359.b(this.e)) {
         if (var2.d()) {
            if (var2.g() == null) {
               Fv466.ef(var2);
               Fv466.t(var2);
               this.q += var2.d;
            }
         } else if (++var2.p > (long)var1) {
            Ew569 var3 = new Ew569(var2.g(), var2.d);
            Ha262.q(this.j, var3, var2.bq);
            Hn359.j(var3, var2);
            Fv466.ef(var2);
            Fv466.t(var2);
         }
      }

   }

   public static void b(Eq28 var0) {
      for(Fv466 var1 = (Fv466)Hn359.h(var0.e); var1 != null; var1 = (Fv466)Hn359.b(var0.e)) {
         if (var1.d()) {
            Fv466.ef(var1);
            Fv466.t(var1);
            var0.q += var1.d;
         }
      }

   }

   public Eq28(int var1) {
      this(var1, var1);
   }

   public void e(Object var1, long var2, int var4) {
      if (var4 > this.d) {
         throw new IllegalStateException();
      } else {
         d(this, var2);
         this.q -= var4;

         while(this.q < 0) {
            Fv466 var5 = (Fv466)Hn359.e(this.e);
            q(this, var5);
         }

         En568 var6 = new En568(var1, var4);
         Ha262.q(this.j, var6, var2);
         Hn359.q(this.e, var6);
         var6.p = 0L;
      }
   }
}
