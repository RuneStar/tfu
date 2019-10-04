package tfu;

import com.jagex.jnibindings.runetek6.Graphics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class A672 implements Km535 {
   private static final Logger logger = LoggerFactory.getLogger(A672.class);
   private int b = 0;
   long d = 0L;
   private boolean e = false;
   private int h = 0;
   private int j;
   private int l = 0;
   private int q;
   private int s = 0;

   public static final void g(A672 var0, float var1, float var2, float var3, float var4, float var5, float var6, Fy467 var7, int var8, Fb341 var9) {
      H149.b((float)((int)var1), (float)((int)var2), (float)((int)var3), (float)((int)var4), (float)((int)var5), (float)((int)var6), (float)((int)(var3 + var5 - var1)), (float)((int)(var4 + var6 - var2)), 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, var0.d, var8);
   }

   public A672(int var1, int var2, int[] var3, int var4, int var5) {
      d(this, var1, var2, var3, var4, var5);
   }

   public static void h(A672 var0, float var1, float var2, float var3, float var4, Fy467 var5, int var6, Fb341 var7) {
      if (var0.e) {
         var3 = var3 * (float)var0.q / (float)var0.q();
         var4 = var4 * (float)var0.j / (float)var0.j();
         var1 += (float)var0.s * var3 / (float)var0.q;
         var2 += (float)var0.h * var4 / (float)var0.j;
      }

      H149.s(var1, var2, var1 + var3, var2 + var4, 0.0F, 0.0F, 1.0F, 1.0F, var0.d, var6);
   }

   private static void d(A672 var0, int var1, int var2, int[] var3, int var4, int var5) {
      var0.q = var1;
      var0.j = var2;
      long var6 = H149.j;
      long var8 = var6;

      for(int var10 = 0; var10 < var3.length; ++var10) {
         Kc180.r(var8, var3[var10]);
         var8 += 4L;
      }

      var0.d = Graphics.createTexture2D(21, var1, var2, 0, 0, var6, 1);
   }

   public A672(Fj373 var1) {
      if (var1.g != 0 && var1.d != 0) {
         int[] var2 = new int[var1.g * var1.d];
         int var3 = 0;
         int var4 = 0;
         int var5;
         int var6;
         if (var1.l != null) {
            for(var5 = 0; var5 < var1.d; ++var5) {
               for(var6 = 0; var6 < var1.g; ++var6) {
                  var2[var4++] = var1.l[var3] << 24 | var1.s[var1.b[var3] & 255];
                  ++var3;
               }
            }
         } else {
            for(var5 = 0; var5 < var1.d; ++var5) {
               for(var6 = 0; var6 < var1.g; ++var6) {
                  int var7 = var1.s[var1.b[var3++] & 255];
                  var2[var4++] = var7 != 0 ? -16777216 | var7 : 0;
               }
            }
         }

         d(this, var1.g, var1.d, var2, 0, var1.g);
      } else {
         this.q = 0;
         this.j = 0;
         this.d = 0L;
      }

   }

   public int j() {
      return this.j + this.h + this.b;
   }

   public int q() {
      return this.q + this.s + this.l;
   }

   public static void e(A672 var0, int var1, int var2, Fy467 var3, int var4, Fb341 var5) {
      var1 += var0.s;
      var2 += var0.h;
      H149.s((float)var1, (float)var2, (float)(var1 + var0.q), (float)(var2 + var0.j), 0.0F, 0.0F, 1.0F, 1.0F, var0.d, var4);
   }

   public A672(int var1, int var2, boolean var3) {
      this.q = var1;
      this.j = var2;
      this.d = 0L;
   }
}
