package tfu;

public class Ch643 {
   private int b;
   private int d = 2;
   int e;
   boolean g = true;
   int h;
   private int[] j = new int[2];
   private int l;
   private int[] q = new int[2];
   private int r;
   int s;
   private int v;
   private int w;

   public static final void g(Ch643 var0, Gg3 var1) {
      var0.s = Gg3.ar(var1);
      var0.e = Gg3.bd(var1);
      var0.h = Gg3.bd(var1);
      d(var0, var1);
   }

   public Ch643() {
      this.q[0] = 0;
      this.q[1] = 65535;
      this.j[0] = 0;
      this.j[1] = 65535;
   }

   static final int j(Ch643 var0, int var1) {
      if (var0.v >= var0.b) {
         var0.r = var0.j[var0.l++] << 15;
         if (var0.l >= var0.d) {
            var0.l = var0.d - 1;
         }

         var0.b = (int)((double)var0.q[var0.l] / 65536.0D * (double)var1);
         if (var0.b > var0.v) {
            var0.w = ((var0.j[var0.l] << 15) - var0.r) / (var0.b - var0.v);
         }
      }

      var0.r += var0.w;
      ++var0.v;
      return var0.r - var0.w >> 15;
   }

   public static final void d(Ch643 var0, Gg3 var1) {
      var0.d = Gg3.ar(var1);
      var0.q = new int[var0.d];
      var0.j = new int[var0.d];

      for(int var2 = 0; var2 < var0.d; ++var2) {
         var0.q[var2] = Gg3.au(var1);
         var0.j[var2] = Gg3.au(var1);
      }

   }

   static final void q(Ch643 var0) {
      var0.b = 0;
      var0.l = 0;
      var0.w = 0;
      var0.r = 0;
      var0.v = 0;
   }
}
