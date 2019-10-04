package com.jagex.maths;

import tfu.Gg3;

public final class O166 implements G300 {
   private static int d;
   private static O166[] g = new O166[0];
   private static int q;
   public float e;
   public float h;
   public float j;
   public float s;

   public O166(Gg3 var1) {
      this.j = Gg3.bl(var1);
      this.e = Gg3.bl(var1);
      this.h = Gg3.bl(var1);
      this.s = Gg3.bl(var1);
   }

   public static O166 d() {
      O166[] var0 = g;
      synchronized(var0) {
         if (q == 0) {
            return new O166();
         } else {
            v(g[--q]);
            return g[q];
         }
      }
   }

   public static O166 q(float var0, float var1, float var2, float var3) {
      O166[] var4 = g;
      synchronized(var4) {
         if (q == 0) {
            return new O166(var0, var1, var2, var3);
         } else {
            b(g[--q], var0, var1, var2, var3);
            return g[q];
         }
      }
   }

   public static O166 j(Quaternion var0) {
      O166[] var1 = g;
      synchronized(var1) {
         if (q == 0) {
            return new O166(var0);
         } else {
            h(g[--q], var0);
            return g[q];
         }
      }
   }

   public static void e(O166 var0) {
      O166[] var1 = g;
      synchronized(var1) {
         if (q < d - 1) {
            g[q++] = var0;
         }

      }
   }

   public O166 c() {
      return new O166(this);
   }

   public static final O166 k(O166 var0, Quaternion var1) {
      b(var0, var1.w * var0.j + var1.x * var0.s + var1.y * var0.h - var1.z * var0.e, var1.w * var0.e - var1.x * var0.h + var1.y * var0.s + var1.z * var0.j, var1.w * var0.h + var1.x * var0.e - var1.y * var0.j + var1.z * var0.s, var1.w * var0.s - var1.x * var0.j - var1.y * var0.e - var1.z * var0.h);
      return var0;
   }

   public O166(O166 var1) {
      s(this, var1);
   }

   public O166(Quaternion var1) {
      h(this, var1);
   }

   public static O166 s(O166 var0, O166 var1) {
      var0.j = var1.j;
      var0.e = var1.e;
      var0.h = var1.h;
      var0.s = var1.s;
      return var0;
   }

   public static O166 l(O166 var0, Vector3 var1, float var2) {
      w(var0, var1.x, var1.y, var1.z, var2);
      return var0;
   }

   public static O166 w(O166 var0, float var1, float var2, float var3, float var4) {
      float var5 = (float)Math.sin((double)(var4 * 0.5F));
      float var6 = (float)Math.cos((double)(var4 * 0.5F));
      var0.j = var1 * var5;
      var0.e = var2 * var5;
      var0.h = var3 * var5;
      var0.s = var6;
      return var0;
   }

   public static O166 r(O166 var0, float var1, float var2, float var3) {
      l(var0, Vector3.g(0.0F, 1.0F, 0.0F), var1);
      O166 var4 = d();
      l(var4, Vector3.g(1.0F, 0.0F, 0.0F), var2);
      i(var0, var4);
      l(var4, Vector3.g(0.0F, 0.0F, 1.0F), var3);
      i(var0, var4);
      e(var4);
      return var0;
   }

   public static final O166 v(O166 var0) {
      var0.j = var0.e = var0.h = 0.0F;
      var0.s = 1.0F;
      return var0;
   }

   public static final O166 y(O166 var0) {
      var0.j = -var0.j;
      var0.e = -var0.e;
      var0.h = -var0.h;
      var0.s = -var0.s;
      return var0;
   }

   public O166() {
      v(this);
   }

   public static final O166 x(O166 var0) {
      float var1 = 1.0F / n(var0);
      var0.j *= var1;
      var0.e *= var1;
      var0.h *= var1;
      var0.s *= var1;
      return var0;
   }

   public static final O166 i(O166 var0, O166 var1) {
      b(var0, var1.s * var0.j + var1.j * var0.s + var1.e * var0.h - var1.h * var0.e, var1.s * var0.e - var1.j * var0.h + var1.e * var0.s + var1.h * var0.j, var1.s * var0.h + var1.j * var0.e - var1.e * var0.j + var1.h * var0.s, var1.s * var0.s - var1.j * var0.j - var1.e * var0.e - var1.h * var0.h);
      return var0;
   }

   public static final O166 u(O166 var0, Quaternion var1) {
      var0.j += var1.x;
      var0.e += var1.y;
      var0.h += var1.z;
      var0.s += var1.w;
      return var0;
   }

   public static final float t(O166 var0, Quaternion var1) {
      return var0.j * var1.x + var0.e * var1.y + var0.h * var1.z + var0.s * var1.w;
   }

   public static final float m(O166 var0, O166 var1) {
      return var0.j * var1.j + var0.e * var1.e + var0.h * var1.h + var0.s * var1.s;
   }

   public static final float n(O166 var0) {
      return (float)Math.sqrt((double)m(var0, var0));
   }

   public static final O166 o(O166 var0, Quaternion var1) {
      b(var0, var0.s * var1.x + var0.j * var1.w + var0.e * var1.z - var0.h * var1.y, var0.s * var1.y - var0.j * var1.z + var0.e * var1.w + var0.h * var1.x, var0.s * var1.z + var0.j * var1.y - var0.e * var1.x + var0.h * var1.w, var0.s * var1.w - var0.j * var1.x - var0.e * var1.y - var0.h * var1.z);
      return var0;
   }

   public static final O166 a(O166 var0, float var1) {
      var0.j *= var1;
      var0.e *= var1;
      var0.h *= var1;
      var0.s *= var1;
      return var0;
   }

   public static final O166 z(O166 var0, Quaternion var1, float var2) {
      var0.j += var1.x * var2;
      var0.e += var1.y * var2;
      var0.h += var1.z * var2;
      var0.s += var1.w * var2;
      return var0;
   }

   public String toString() {
      return this.j + "," + this.e + "," + this.h + "," + this.s;
   }

   public static O166 b(O166 var0, float var1, float var2, float var3, float var4) {
      var0.j = var1;
      var0.e = var2;
      var0.h = var3;
      var0.s = var4;
      return var0;
   }

   public Quaternion ag() {
      return new Quaternion(this.j, this.e, this.h, this.s);
   }

   public static O166 h(O166 var0, Quaternion var1) {
      var0.j = var1.x;
      var0.e = var1.y;
      var0.h = var1.z;
      var0.s = var1.w;
      return var0;
   }

   public static void g(int var0) {
      d = var0;
      g = new O166[var0];
      q = 0;
   }

   public O166(float var1, float var2, float var3, float var4) {
      b(this, var1, var2, var3, var4);
   }

   public static final O166 p(O166 var0) {
      var0.j = -var0.j;
      var0.e = -var0.e;
      var0.h = -var0.h;
      return var0;
   }

   public O166(float var1, float var2, float var3) {
      r(this, var1, var2, var3);
   }

   public static final O166 f(O166 var0, Quaternion var1, float var2) {
      if (t(var0, var1) < 0.0F) {
         y(var0);
      }

      a(var0, 1.0F - var2);
      Quaternion var3 = var1.y(var2);
      u(var0, var3);
      x(var0);
      return var0;
   }
}
