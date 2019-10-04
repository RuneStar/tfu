package tfu;

class De623 extends Ds621 {
   private long d = 0L;
   private int e = 0;
   private long g = 0L;
   private int h = 1;
   private long[] j = new long[10];
   private long q = 0L;

   public long g() {
      this.g += q(this);
      return this.d > this.g ? (this.d - this.g) / 1000000L : 0L;
   }

   De623() {
      this.g = System.nanoTime();
      this.d = System.nanoTime();
   }

   public int d(long var1) {
      if (this.d > this.g) {
         this.q += this.d - this.g;
         this.g += this.d - this.g;
         this.d += var1;
         return 1;
      } else {
         int var3 = 0;

         do {
            ++var3;
            this.d += var1;
         } while(var3 < 10 && this.d < this.g);

         if (this.d < this.g) {
            this.d = this.g;
         }

         return var3;
      }
   }

   private static long q(De623 var0) {
      long var1 = System.nanoTime();
      long var3 = var1 - var0.q;
      var0.q = var1;
      if (var3 > -5000000000L && var3 < 5000000000L) {
         var0.j[var0.e] = var3;
         var0.e = (var0.e + 1) % 10;
         if (var0.h < 1) {
            ++var0.h;
         }
      }

      long var5 = 0L;

      for(int var7 = 1; var7 <= var0.h; ++var7) {
         var5 += var0.j[(var0.e - var7 + 10) % 10];
      }

      return var5 / (long)var0.h;
   }
}
