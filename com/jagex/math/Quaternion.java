package com.jagex.math;

import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;

/** @deprecated */
@Deprecated
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class Quaternion implements D99 {
   private static int d;
   private static Quaternion[] g = new Quaternion[0];
   public static final Quaternion j = new Quaternion();
   private static int q;
   public float w;
   public float x;
   public float y;
   public float z;

   public static Quaternion g() {
      Quaternion[] var0 = g;
      synchronized(var0) {
         if (q == 0) {
            return new Quaternion();
         } else {
            b(g[--q]);
            return g[q];
         }
      }
   }

   public static void d(Quaternion var0) {
      Quaternion[] var1 = g;
      synchronized(var1) {
         if (q < d - 1) {
            g[q++] = var0;
         }

      }
   }

   public Quaternion(Quaternion var1) {
      q(this, var1);
   }

   public static void s(Quaternion var0, float var1, float var2, float var3) {
      e(var0, Vector3.g(0.0F, 1.0F, 0.0F), var1);
      Quaternion var4 = g();
      e(var4, Vector3.g(1.0F, 0.0F, 0.0F), var2);
      l(var0, var4);
      e(var4, Vector3.g(0.0F, 0.0F, 1.0F), var3);
      l(var0, var4);
      d(var4);
   }

   public Quaternion(Gg3 var1) {
      this.x = Gg3.bl(var1);
      this.y = Gg3.bl(var1);
      this.z = Gg3.bl(var1);
      this.w = Gg3.bl(var1);
   }

   public static void q(Quaternion var0, Quaternion var1) {
      var0.x = var1.x;
      var0.y = var1.y;
      var0.z = var1.z;
      var0.w = var1.w;
   }

   public static void j(Quaternion var0, float var1, float var2, float var3, float var4) {
      var0.x = var1;
      var0.y = var2;
      var0.z = var3;
      var0.w = var4;
   }

   public static void h(Quaternion var0, float var1, float var2, float var3, float var4) {
      float var5 = (float)Math.sin((double)(var4 * 0.5F));
      float var6 = (float)Math.cos((double)(var4 * 0.5F));
      var0.x = var1 * var5;
      var0.y = var2 * var5;
      var0.z = var3 * var5;
      var0.w = var6;
   }

   public static final void b(Quaternion var0) {
      var0.x = var0.y = var0.z = 0.0F;
      var0.w = 1.0F;
   }

   public static final void l(Quaternion var0, Quaternion var1) {
      j(var0, var1.w * var0.x + var1.x * var0.w + var1.y * var0.z - var1.z * var0.y, var1.w * var0.y - var1.x * var0.z + var1.y * var0.w + var1.z * var0.x, var1.w * var0.z + var1.x * var0.y - var1.y * var0.x + var1.z * var0.w, var1.w * var0.w - var1.x * var0.x - var1.y * var0.y - var1.z * var0.z);
   }

   public String toString() {
      return this.x + "," + this.y + "," + this.z + "," + this.w;
   }

   public Quaternion(float var1, float var2, float var3) {
      s(this, var1, var2, var3);
   }

   @Bs1
   @Be2
   public Quaternion(float var1, float var2, float var3, float var4) {
      j(this, var1, var2, var3, var4);
   }

   public static void e(Quaternion var0, Vector3 var1, float var2) {
      h(var0, var1.x, var1.y, var1.z, var2);
   }

   public Quaternion() {
      b(this);
   }
}
