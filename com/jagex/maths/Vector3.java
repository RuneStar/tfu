package com.jagex.maths;

import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;
import tfu.Kl267;
import tfu.Lp301;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class Vector3 implements B164, Lp301, Kl267 {
   public static final Vector3 d = new Vector3(1.0F, 0.0F, 0.0F);
   public static final Vector3 e = new Vector3(Float.NaN, Float.NaN, Float.NaN);
   public static final Vector3 g = new Vector3(0.0F, 0.0F, 0.0F);
   public static final Vector3 j = new Vector3(0.0F, 0.0F, 1.0F);
   public static final Vector3 q = new Vector3(0.0F, 1.0F, 0.0F);
   public final float x;
   public final float y;
   public final float z;

   public static Vector3 d(Gg3 var0) {
      return new Vector3(var0);
   }

   @Bs1
   @Be2
   public Vector3(float var1, float var2, float var3) {
      this.x = var1;
      this.y = var2;
      this.z = var3;
   }

   public Vector3(Gg3 var1) {
      this.x = Gg3.bl(var1);
      this.y = Gg3.bl(var1);
      this.z = Gg3.bl(var1);
   }

   public static Vector3 g(float var0, float var1, float var2) {
      return new Vector3(var0, var1, var2);
   }

   public static int r(Vector3 var0) {
      return 12;
   }

   public int hashCode() {
      return Float.floatToIntBits(this.x) + Float.floatToIntBits(this.y) + Float.floatToIntBits(this.z);
   }

   public static void w(Vector3 var0, Gg3 var1) {
      Gg3.aq(var1, var0.x);
      Gg3.aq(var1, var0.y);
      Gg3.aq(var1, var0.z);
   }

   public static boolean v(Vector3 var0, Vector3 var1) {
      return var1 != null && Float.floatToIntBits(var0.x) == Float.floatToIntBits(var1.x) && Float.floatToIntBits(var0.y) == Float.floatToIntBits(var1.y) && Float.floatToIntBits(var0.z) == Float.floatToIntBits(var1.z);
   }

   public static final Vector3 k(Vector3 var0, Vector3 var1) {
      return g(var0.x - var1.x, var0.y - var1.y, var0.z - var1.z);
   }

   public static boolean p(Vector3 var0, Vector3 var1, float var2) {
      return Math.abs(var1.x - var0.x) <= var2 && Math.abs(var1.y - var0.y) <= var2 && Math.abs(var1.z - var0.z) <= var2;
   }

   public static final Vector3 u(Vector3 var0) {
      float var1 = 1.0F / f(var0);
      return g(var0.x * var1, var0.y * var1, var0.z * var1);
   }

   public static final Vector3 z(Vector3 var0, Vector3 var1) {
      return g(var0.x + var1.x, var0.y + var1.y, var0.z + var1.z);
   }

   public static final Vector3 m(Vector3 var0, float var1, float var2, float var3) {
      return g(var0.x + var1, var0.y + var2, var0.z + var3);
   }

   public static final Vector3 n(Vector3 var0, Vector3 var1, float var2) {
      return g(var0.x + var1.x * var2, var0.y + var1.y * var2, var0.z + var1.z * var2);
   }

   public Vector3 ao() {
      return new Vector3(-this.x, this.y, -this.z);
   }

   public static final Vector3 i(Vector3 var0, float var1, float var2, float var3) {
      return g(var0.x - var1, var0.y - var2, var0.z - var3);
   }

   public static final float o(Vector3 var0, Vector3 var1) {
      return var0.x * var1.x + var0.y * var1.y + var0.z * var1.z;
   }

   public static Vector3 ap(Vector3 var0) {
      return var0;
   }

   public Vector3 an(float var1) {
      return new Vector3(this.x, var1, this.z);
   }

   public static final float c(Vector3 var0) {
      return var0.x * var0.x + var0.y * var0.y + var0.z * var0.z;
   }

   public static float ag(Vector3 var0, Vector3 var1) {
      float var2 = var1.x - var0.x;
      float var3 = var1.y - var0.y;
      float var4 = var1.z - var0.z;
      return (float)Math.sqrt((double)(var2 * var2 + var3 * var3 + var4 * var4));
   }

   public static final Vector3 ai(Vector3 var0, float var1) {
      return g(var0.x * var1, var0.y * var1, var0.z * var1);
   }

   public static final Vector3 al(Vector3 var0, Quaternion var1) {
      Quaternion var2 = Quaternion.g(var0.x, var0.y, var0.z, 0.0F);
      Quaternion var3 = var1.s();
      O166 var4 = O166.j(var3);
      O166.k(var4, var2);
      O166.k(var4, var1);
      return g(var4.j, var4.e, var4.h);
   }

   public static final Vector3 af(Vector3 var0, M47 var1) {
      return g(var1.f00 * var0.x + var1.f10 * var0.y + var1.f20 * var0.z, var1.f01 * var0.x + var1.f11 * var0.y + var1.f21 * var0.z, var1.f02 * var0.x + var1.f12 * var0.y + var1.f22 * var0.z);
   }

   public static final Vector3 av(Vector3 var0, Vector3 var1, float var2) {
      return g(var0.x + (var1.x - var0.x) * var2, var0.y + (var1.y - var0.y) * var2, var0.z + (var1.z - var0.z) * var2);
   }

   public String toString() {
      return String.format("{ Vector3: %.3f,%.3f,%.3f }", this.x, this.y, this.z);
   }

   public Vector3 e() {
      return this;
   }

   public Vector3 j() {
      return this;
   }

   public boolean equals(Object var1) {
      return var1 instanceof I48 ? y(this, (I48)var1) : v(this, (Vector3)var1);
   }

   public Vector3(Gg3 var1, int var2) {
      float var3 = (float)Math.pow(10.0D, (double)var2);
      this.x = (float)Gg3.by(var1) / var3;
      this.y = (float)Gg3.by(var1) / var3;
      this.z = (float)Gg3.by(var1) / var3;
   }

   public static final Vector3 t(Vector3 var0, I48 var1) {
      return g(var0.x + var1.j, var0.y + var1.e, var0.z + var1.h);
   }

   public static float aq(Vector3 var0, Vector3 var1) {
      float var2 = var1.x - var0.x;
      float var3 = var1.y - var0.y;
      float var4 = var1.z - var0.z;
      return var2 * var2 + var3 * var3 + var4 * var4;
   }

   public static final Vector3 a(Vector3 var0, Vector3 var1) {
      return g(var0.y * var1.z - var0.z * var1.y, var0.z * var1.x - var0.x * var1.z, var0.x * var1.y - var0.y * var1.x);
   }

   public Vector3 aa(float var1) {
      return new Vector3(var1, this.y, this.z);
   }

   public static boolean y(Vector3 var0, I48 var1) {
      return var1 != null && Float.floatToIntBits(var0.x) == Float.floatToIntBits(var1.j) && Float.floatToIntBits(var0.y) == Float.floatToIntBits(var1.e) && Float.floatToIntBits(var0.z) == Float.floatToIntBits(var1.h);
   }

   public static final Vector3 x(Vector3 var0) {
      return g(-var0.x, -var0.y, -var0.z);
   }

   public static final float f(Vector3 var0) {
      return (float)Math.sqrt((double)c(var0));
   }
}
