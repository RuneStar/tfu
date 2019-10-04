package com.jagex.maths;

import tfu.Gg3;
import tfu.Kl267;
import tfu.Lp301;

public final class I48 implements G300, Lp301, Kl267 {
   private static int d;
   private static I48[] g = new I48[0];
   private static int q;
   public float e;
   public float h;
   public float j;

   public static I48 d() {
      I48[] var0 = g;
      synchronized(var0) {
         if (q == 0) {
            return new I48();
         } else {
            z(g[--q]);
            return g[q];
         }
      }
   }

   public static I48 w(float var0, float var1, float var2) {
      I48[] var3 = g;
      synchronized(var3) {
         if (q == 0) {
            return new I48(var0, var1, var2);
         } else {
            p(g[--q], var0, var1, var2);
            return g[q];
         }
      }
   }

   public static I48 u(I48 var0, I48 var1) {
      p(var0, var1.j, var1.e, var1.h);
      return var0;
   }

   public static I48 v(I48 var0) {
      I48[] var1 = g;
      synchronized(var1) {
         if (q == 0) {
            return new I48(var0);
         } else {
            u(g[--q], var0);
            return g[q];
         }
      }
   }

   public static void y(I48 var0) {
      I48[] var1 = g;
      synchronized(var1) {
         if (q < d - 1) {
            g[q++] = var0;
         }

      }
   }

   public I48(float var1, float var2, float var3) {
      this.j = var1;
      this.e = var2;
      this.h = var3;
   }

   public I48(Vector3 var1) {
      this.j = var1.x;
      this.e = var1.y;
      this.h = var1.z;
   }

   public I48(Gg3 var1, int var2) {
      float var3 = (float)Math.pow(10.0D, (double)var2);
      this.j = (float)Gg3.by(var1) / var3;
      this.e = (float)Gg3.by(var1) / var3;
      this.h = (float)Gg3.by(var1) / var3;
   }

   public static I48 p(I48 var0, float var1, float var2, float var3) {
      var0.j = var1;
      var0.e = var2;
      var0.h = var3;
      return var0;
   }

   public static I48 x(I48 var0, Vector3 var1) {
      p(var0, var1.x, var1.y, var1.z);
      return var0;
   }

   public static final float ag(I48 var0) {
      return var0.j * var0.j + var0.e * var0.e + var0.h * var0.h;
   }

   public static final I48 z(I48 var0) {
      var0.j = var0.e = var0.h = 0.0F;
      return var0;
   }

   public static final I48 k(I48 var0, I48 var1) {
      var0.j += var1.j;
      var0.e += var1.e;
      var0.h += var1.h;
      return var0;
   }

   public static final I48 i(I48 var0, float var1, float var2, float var3) {
      var0.j += var1;
      var0.e += var2;
      var0.h += var3;
      return var0;
   }

   public String toString() {
      return String.format("{Vector 3: %f,%f,%f}", this.j, this.e, this.h);
   }

   public static final I48 a(I48 var0, I48 var1) {
      var0.j -= var1.j;
      var0.e -= var1.e;
      var0.h -= var1.h;
      return var0;
   }

   public static I48 r(Vector3 var0) {
      I48[] var1 = g;
      synchronized(var1) {
         if (q == 0) {
            return new I48(var0);
         } else {
            x(g[--q], var0);
            return g[q];
         }
      }
   }

   public static void g(int var0) {
      d = var0;
      g = new I48[var0];
      q = 0;
   }

   public static final I48 aq(I48 var0, float var1) {
      var0.j *= var1;
      var0.e *= var1;
      var0.h *= var1;
      return var0;
   }

   public static final I48 al(I48 var0, Quaternion var1) {
      Quaternion var2 = Quaternion.g(var0.j, var0.e, var0.h, 0.0F);
      Quaternion var3 = var1.s();
      O166 var4 = O166.j(var3);
      O166.k(var4, var2);
      O166.k(var4, var1);
      p(var0, var4.j, var4.e, var4.h);
      O166.e(var4);
      return var0;
   }

   public static final I48 af(I48 var0, O166 var1) {
      O166 var2 = O166.q(var0.j, var0.e, var0.h, 0.0F);
      O166 var3 = O166.i(O166.p(var1.c()), var2);
      O166.i(var3, var1);
      p(var0, var3.j, var3.e, var3.h);
      O166.e(var2);
      O166.e(var3);
      return var0;
   }

   public static final I48 av(I48 var0, Vector3 var1, float var2) {
      aq(var0, 1.0F - var2);
      n(var0, Vector3.ai(var1, var2));
      return var0;
   }

   public I48(Gg3 var1) {
      this.j = Gg3.bl(var1);
      this.e = Gg3.bl(var1);
      this.h = Gg3.bl(var1);
   }

   public Vector3 j() {
      return this.ao();
   }

   public static I48 ap(I48 var0) {
      return v(var0);
   }

   public Vector3 ao() {
      return new Vector3(this.j, this.e, this.h);
   }

   public static final float c(I48 var0) {
      return (float)Math.sqrt((double)ag(var0));
   }

   public static final I48 o(I48 var0, Vector3 var1) {
      var0.j -= var1.x;
      var0.e -= var1.y;
      var0.h -= var1.z;
      return var0;
   }

   public static final I48 m(I48 var0) {
      float var1 = 1.0F / c(var0);
      var0.j *= var1;
      var0.e *= var1;
      var0.h *= var1;
      return var0;
   }

   public static final I48 ai(I48 var0, float var1) {
      var0.j /= var1;
      var0.e /= var1;
      var0.h /= var1;
      return var0;
   }

   public Vector3 e() {
      return this.ao();
   }

   public I48(I48 var1) {
      this.j = var1.j;
      this.e = var1.e;
      this.h = var1.h;
   }

   public static final I48 n(I48 var0, Vector3 var1) {
      var0.j += var1.x;
      var0.e += var1.y;
      var0.h += var1.z;
      return var0;
   }

   public I48() {
   }

   public static final I48 t(I48 var0) {
      var0.j = -var0.j;
      var0.e = -var0.e;
      var0.h = -var0.h;
      return var0;
   }

   public static final I48 f(I48 var0, Vector3 var1, float var2) {
      var0.j -= var1.x * var2;
      var0.e -= var1.y * var2;
      var0.h -= var1.z * var2;
      return var0;
   }
}
