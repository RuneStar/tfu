package com.jagex.maths;

public final class H303 {
   public float b;
   public float d;
   public float e;
   public float g;
   public float h;
   public float j;
   public float l;
   public float q;
   public float r;
   public float s;
   public float v;
   public float w;

   public H303(H303 var1) {
      d(this, var1);
   }

   public static H303 d(H303 var0, H303 var1) {
      var0.g = var1.g;
      var0.j = var1.j;
      var0.s = var1.s;
      var0.w = var1.w;
      var0.d = var1.d;
      var0.e = var1.e;
      var0.b = var1.b;
      var0.r = var1.r;
      var0.q = var1.q;
      var0.h = var1.h;
      var0.l = var1.l;
      var0.v = var1.v;
      return var0;
   }

   public H303() {
      e(this);
   }

   public static H303 e(H303 var0) {
      var0.d = var0.q = var0.j = var0.h = var0.s = var0.b = var0.w = var0.r = var0.v = 0.0F;
      var0.g = var0.e = var0.l = 1.0F;
      return var0;
   }

   public static H303 h(H303 var0, Quaternion var1) {
      s(var0, var1.x, var1.y, var1.z, var1.w);
      return var0;
   }

   public static H303 b(H303 var0, Vector3 var1) {
      l(var0, var1.x, var1.y, var1.z);
      return var0;
   }

   public static H303 l(H303 var0, float var1, float var2, float var3) {
      var0.w += var1;
      var0.r += var2;
      var0.v += var3;
      return var0;
   }

   public static H303 w(H303 var0, float[] var1) {
      float var2 = var1[0] - var0.w;
      float var3 = var1[1] - var0.r;
      float var4 = var1[2] - var0.v;
      var1[0] = (float)((int)(var0.g * var2 + var0.d * var3 + var0.q * var4));
      var1[1] = (float)((int)(var0.j * var2 + var0.e * var3 + var0.h * var4));
      var1[2] = (float)((int)(var0.s * var2 + var0.b * var3 + var0.l * var4));
      return var0;
   }

   public static float[] r(H303 var0, float[] var1, int var2) {
      var1[0 + var2] = var0.g;
      var1[1 + var2] = var0.d;
      var1[2 + var2] = var0.q;
      var1[3 + var2] = 0.0F;
      var1[4 + var2] = var0.j;
      var1[5 + var2] = var0.e;
      var1[6 + var2] = var0.h;
      var1[7 + var2] = 0.0F;
      var1[8 + var2] = var0.s;
      var1[9 + var2] = var0.b;
      var1[10 + var2] = var0.l;
      var1[11 + var2] = 0.0F;
      var1[12 + var2] = var0.w;
      var1[13 + var2] = var0.r;
      var1[14 + var2] = var0.v;
      var1[15 + var2] = 1.0F;
      return var1;
   }

   public String toString() {
      return this.g + "," + this.j + "," + this.s + "," + this.w + " - " + this.d + "," + this.e + "," + this.b + "," + this.r + " - " + this.q + "," + this.h + "," + this.l + "," + this.v;
   }

   public static H303 s(H303 var0, float var1, float var2, float var3, float var4) {
      float var5 = var1 * var1;
      float var6 = var1 * var2;
      float var7 = var1 * var3;
      float var8 = var1 * var4;
      float var9 = var2 * var2;
      float var10 = var2 * var3;
      float var11 = var2 * var4;
      float var12 = var3 * var3;
      float var13 = var3 * var4;
      var0.g = 1.0F - 2.0F * (var9 + var12);
      var0.j = 2.0F * (var6 - var13);
      var0.s = 2.0F * (var7 + var11);
      var0.d = 2.0F * (var6 + var13);
      var0.e = 1.0F - 2.0F * (var5 + var12);
      var0.b = 2.0F * (var10 - var8);
      var0.q = 2.0F * (var7 - var11);
      var0.h = 2.0F * (var10 + var8);
      var0.l = 1.0F - 2.0F * (var5 + var9);
      var0.w = var0.r = var0.v = 0.0F;
      return var0;
   }

   public H303(K299 var1) {
      g(this, var1);
   }

   public static H303 g(H303 var0, K299 var1) {
      var0.g = var1.d;
      var0.j = var1.e;
      var0.s = var1.b;
      var0.w = var1.r;
      var0.d = var1.q;
      var0.e = var1.h;
      var0.b = var1.l;
      var0.r = var1.v;
      var0.q = var1.j;
      var0.h = var1.s;
      var0.l = var1.w;
      var0.v = var1.y;
      return var0;
   }

   public static H303 j(H303 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12) {
      var0.g = var1;
      var0.d = var5;
      var0.q = var9;
      var0.j = var2;
      var0.e = var6;
      var0.h = var10;
      var0.s = var3;
      var0.b = var7;
      var0.l = var11;
      var0.w = var4;
      var0.r = var8;
      var0.v = var12;
      return var0;
   }

   public H303(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12) {
      j(this, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   public static H303 q(H303 var0, RotTrans var1) {
      h(var0, var1.rot);
      b(var0, var1.trans);
      return var0;
   }
}
