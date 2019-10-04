package rs2.client.sound;

import fmod.E245;
import fmod.X243;
import java.util.Hashtable;
import tfu.Gg3;

class Av695 {
   private float[] b = new float[]{1.0F, 1.0F};
   X675 d;
   String e = "";
   X243 g = null;
   Hashtable h = new Hashtable();
   float j = 0.0F;
   int q;
   private long[] s = new long[]{0L, 0L};

   public static long g(Av695 var0) {
      return var0.g == null ? 0L : X243.an(var0.g);
   }

   public static void h(Av695 var0, int var1) {
      if (X243.y(var0.g)) {
         X243.c(var0.g);
      }

      var0.g = E245.v(SoundManager.c, var0.e);
      if (X243.h(var0.g)) {
         if (var1 > 20) {
            X243.av(var0.g, 36, 250);
         }

         X243.n(var0.g, true);
         var0.g.a();
         X243.am(var0.g, var1);
         X243.i(var0.g, var0.j * var0.d.b);
      }

   }

   public static int d(Av695 var0) {
      return var0.g == null ? 0 : X243.as(var0.g);
   }

   public static boolean q(Av695 var0) {
      return X243.y(var0.g);
   }

   public static void j(Av695 var0, String var1, boolean var2) {
      if (var0.h.containsKey(var1)) {
         if (!var2) {
            l(var0, (Float)var0.h.get(var1), (long)var0.d.p);
         } else {
            X243.i(var0.g, (Float)var0.h.get(var1));
            var0.j = (Float)var0.h.get(var1);
         }
      } else {
         var0.j = 1.0F;
      }

   }

   public static void e(Av695 var0) {
      if (X243.y(var0.g)) {
         X243.c(var0.g);
      }

      var0.g = E245.v(SoundManager.c, var0.e);
      X243.n(var0.g, true);
      var0.g.a();
      X243.i(var0.g, var0.j * var0.d.b);
   }

   public Av695(String var1, X675 var2) {
      this.d = var2;
      this.e = var1;
      this.g = SoundManager.c.r(this.e, 0);
   }

   public static void b(Av695 var0) {
      long var1 = K589.g();
      if (var0.s[0] != 0L) {
         if (var1 > var0.s[1]) {
            X243.i(var0.g, var0.b[1]);
            var0.s[0] = 0L;
         }
      } else if (var1 >= var0.s[0] && var1 <= var0.s[1]) {
         float var3 = (float)(var1 - var0.s[0]) / (float)(var0.s[1] - var0.s[0]);
         float var4 = var0.b[0] + var3 * (var0.b[1] - var0.b[0]);
         var0.j = var4;
         X243.i(var0.g, var4 * var0.d.b);
      } else {
         X243.i(var0.g, var0.d.b);
      }

   }

   public static void l(Av695 var0, float var1, long var2) {
      long var4 = K589.g();
      var0.s[0] = var4;
      var0.s[1] = var4 + var2;
      var0.b[0] = var0.j;
      var0.b[1] = var1;
   }

   public static void w(Av695 var0, Gg3 var1) {
      var0.e = Gg3.bk(var1);
      int var2 = Gg3.ar(var1);

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = Gg3.bk(var1);
         float var5 = (float)Gg3.ar(var1) / 100.0F;
         var0.h.put(var4, var5);
      }

   }

   public static void s(Av695 var0) {
      if (X243.y(var0.g)) {
         X243.c(var0.g);
      }

   }
}
