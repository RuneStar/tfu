package com.jagex.math;

/** @deprecated */
@Deprecated
public class G283 {
   public static final G283 g = new G283();
   public float b;
   public float d;
   public float e;
   public float h;
   public float j;
   public float l;
   public float q;
   public float r;
   public float s;
   public float v;
   public float w;
   public float y;

   public G283(G283 var1) {
      g(this, var1);
   }

   public String toString() {
      return this.d + "," + this.e + "," + this.b + "," + this.r + " - " + this.q + "," + this.h + "," + this.l + "," + this.v + " - " + this.j + "," + this.s + "," + this.w + "," + this.y;
   }

   public G283(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12) {
      d(this, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   public static void d(G283 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12) {
      var0.d = var1;
      var0.q = var5;
      var0.j = var9;
      var0.e = var2;
      var0.h = var6;
      var0.s = var10;
      var0.b = var3;
      var0.l = var7;
      var0.w = var11;
      var0.r = var4;
      var0.v = var8;
      var0.y = var12;
   }

   public static void q(G283 var0) {
      var0.q = var0.j = var0.e = var0.s = var0.b = var0.l = var0.r = var0.v = var0.y = 0.0F;
      var0.d = var0.h = var0.w = 1.0F;
   }

   public static float[] j(G283 var0, float[] var1, int var2) {
      var1[0 + var2] = var0.d;
      var1[1 + var2] = var0.q;
      var1[2 + var2] = var0.j;
      var1[3 + var2] = 0.0F;
      var1[4 + var2] = var0.e;
      var1[5 + var2] = var0.h;
      var1[6 + var2] = var0.s;
      var1[7 + var2] = 0.0F;
      var1[8 + var2] = var0.b;
      var1[9 + var2] = var0.l;
      var1[10 + var2] = var0.w;
      var1[11 + var2] = 0.0F;
      var1[12 + var2] = var0.r;
      var1[13 + var2] = var0.v;
      var1[14 + var2] = var0.y;
      var1[15 + var2] = 1.0F;
      return var1;
   }

   public G283() {
      q(this);
   }

   public static void g(G283 var0, G283 var1) {
      var0.d = var1.d;
      var0.e = var1.e;
      var0.b = var1.b;
      var0.r = var1.r;
      var0.q = var1.q;
      var0.h = var1.h;
      var0.l = var1.l;
      var0.v = var1.v;
      var0.j = var1.j;
      var0.s = var1.s;
      var0.w = var1.w;
      var0.y = var1.y;
   }
}
