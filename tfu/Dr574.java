package tfu;

import java.util.BitSet;

public class Dr574 extends Ln265 {
   public static final int b = 4;
   public static final boolean d = false;
   public static final int e = 1;
   private static final BitSet f = new BitSet(65536);
   public static boolean g = false;
   public static final int h = 2;
   public static final int j = 1;
   public static final int l = 5;
   public static final int p = 3600000;
   public static final int q = 3;
   public static final int r = 7;
   public static final int s = 3;
   public static final int v = 8;
   public static final int w = 6;
   public static final int y = 100;
   public byte a;
   public boolean i;
   public String k = null;
   private int[] m;
   public long n;
   public byte o;
   public int t = 0;
   boolean u = true;
   boolean x;
   public Dt575[] z;

   protected static void q(Dr574 var0, int var1) {
      --var0.t;
      if (var0.t == 0) {
         var0.z = null;
      } else {
         System.arraycopy(var0.z, var1 + 1, var0.z, var1, var0.t - var1);
      }

      var0.m = null;
   }

   public Dr574(Gg3 var1) {
      this.j(var1);
   }

   public Dr574(long var1, boolean var3, boolean var4) {
      super.bq = var1;
      this.x = var3;
      this.u = var4;
   }

   public void j(Gg3 var1) {
      int var2 = Gg3.ar(var1);
      if ((var2 & 1) != 0) {
         this.x = true;
      }

      if ((var2 & 2) != 0) {
         this.u = true;
      }

      int var3 = 2;
      if ((var2 & 4) != 0) {
         var3 = Gg3.ar(var1);
      }

      super.bq = Gg3.bq(var1);
      this.n = Gg3.bq(var1);
      this.k = Gg3.bk(var1);
      this.i = Gg3.ar(var1) == 1;
      this.a = Gg3.ax(var1);
      this.o = Gg3.ax(var1);
      this.t = Gg3.au(var1);
      if (this.t > 0) {
         this.z = new Dt575[this.t];

         for(int var4 = 0; var4 < this.t; ++var4) {
            Dt575 var5 = new Dt575();
            if (this.x) {
               var5.g = Gg3.bq(var1);
            }

            if (this.u) {
               var5.j = Gg3.bk(var1);
            }

            var5.d = Gg3.ax(var1);
            var5.q = Gg3.au(var1);
            if (var3 >= 3) {
               var5.h = Gg3.ar(var1) == 1;
            } else {
               var5.h = false;
            }

            this.z[var4] = var5;
         }
      }

   }

   public String e() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Clan Name: ").append(this.k).append("\nRank Kick: ").append(this.a).append(",  Talk: ").append(this.o).append("\nUsers:");

      for(int var2 = 0; var2 < this.t; ++var2) {
         Dt575 var3 = this.z[var2];
         var1.append("\n").append(var3.j);
      }

      return var1.toString();
   }

   static void d(Dr574 var0, Dt575 var1) {
      if (var0.z == null || var0.t >= var0.z.length) {
         g(var0, var0.t + 5);
      }

      var0.z[var0.t++] = var1;
      var0.m = null;
   }

   private static void g(Dr574 var0, int var1) {
      if (var0.z != null) {
         System.arraycopy(var0.z, 0, var0.z = new Dt575[var1], 0, var0.t);
      } else {
         var0.z = new Dt575[var1];
      }

   }
}
