package com.jagex.maths;

public final class K299 {
   public static final K299 g = new K299(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
   public final float b;
   public final float d;
   public final float e;
   public final float h;
   public final float j;
   public final float l;
   public final float q;
   public final float r;
   public final float s;
   public final float v;
   public final float w;
   public final float y;

   public static float[] g(K299 var0, float[] var1, int var2) {
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

   public String toString() {
      return this.d + "," + this.e + "," + this.b + "," + this.r + " - " + this.q + "," + this.h + "," + this.l + "," + this.v + " - " + this.j + "," + this.s + "," + this.w + "," + this.y;
   }

   public K299(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12) {
      this.d = var1;
      this.q = var5;
      this.j = var9;
      this.e = var2;
      this.h = var6;
      this.s = var10;
      this.b = var3;
      this.l = var7;
      this.w = var11;
      this.r = var4;
      this.v = var8;
      this.y = var12;
   }
}
