package tfu;

import com.jagex.js5.js5;

public class Co638 {
   static final int g = 22050;
   private Cl639[] d = new Cl639[10];
   private int j;
   private int q;

   public static Co638 g(js5 var0, int var1, int var2) {
      byte[] var3 = var0.getfile(var1, var2);
      return var3 == null ? null : new Co638(new Gg3(var3));
   }

   private static final byte[] q(Co638 var0) {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if (var0.d[var2] != null && var0.d[var2].g && var0.d[var2].z + var0.d[var2].t > var1) {
            var1 = var0.d[var2].z + var0.d[var2].t;
         }
      }

      if (var1 == 0) {
         return new byte[0];
      } else {
         var2 = 22050 * var1 / 1000;
         byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if (var0.d[var4] != null && var0.d[var4].g) {
               int var5 = var0.d[var4].z * 22050 / 1000;
               int var6 = var0.d[var4].t * 22050 / 1000;
               int[] var7 = Cl639.g(var0.d[var4], var5, var0.d[var4].z);

               for(int var8 = 0; var8 < var5; ++var8) {
                  int var9 = var3[var8 + var6] + (var7[var8] >> 8);
                  if ((var9 + 128 & -256) != 0) {
                     var9 = var9 >> 31 ^ 127;
                  }

                  var3[var8 + var6] = (byte)var9;
               }
            }
         }

         return var3;
      }
   }

   private Co638() {
   }

   public Cj551 d() {
      byte[] var1 = q(this);
      return new Cj551(22050, var1, 22050 * this.q / 1000, 22050 * this.j / 1000);
   }

   public Co638(Gg3 var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = Gg3.ar(var1);
         if (var3 != 0) {
            --var1.v;
            this.d[var2] = new Cl639();
            this.d[var2].q(var1);
         }
      }

      this.q = Gg3.au(var1);
      this.j = Gg3.au(var1);
   }
}
