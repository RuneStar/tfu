package com.jagex.maths;

import java.util.Arrays;

public final class U316 {
   public float[] g = new float[16];

   public static U316 g(U316 var0) {
      var0.g[0] = 1.0F;
      var0.g[1] = 0.0F;
      var0.g[2] = 0.0F;
      var0.g[3] = 0.0F;
      var0.g[4] = 0.0F;
      var0.g[5] = 1.0F;
      var0.g[6] = 0.0F;
      var0.g[7] = 0.0F;
      var0.g[8] = 0.0F;
      var0.g[9] = 0.0F;
      var0.g[10] = 1.0F;
      var0.g[11] = 0.0F;
      var0.g[12] = 0.0F;
      var0.g[13] = 0.0F;
      var0.g[14] = 0.0F;
      var0.g[15] = 1.0F;
      return var0;
   }

   public U316(Matrix4 var1) {
      d(this, var1);
   }

   public U316(U316 var1) {
      q(this, var1);
   }

   public U316(float[] var1) {
      System.arraycopy(var1, 0, this.g, 0, 16);
   }

   public U316(K299 var1) {
      K299.g(var1, this.g, 0);
   }

   public U316(H303 var1) {
      H303.r(var1, this.g, 0);
   }

   public U316() {
      g(this);
   }

   public static U316 q(U316 var0, U316 var1) {
      System.arraycopy(var1.g, 0, var0.g, 0, 16);
      return var0;
   }

   public static U316 j(U316 var0, Matrix4 var1) {
      float var2 = var0.g[0] * var1.f00 + var0.g[1] * var1.f10 + var0.g[2] * var1.f20 + var0.g[3] * var1.f30;
      float var3 = var0.g[0] * var1.f01 + var0.g[1] * var1.f11 + var0.g[2] * var1.f21 + var0.g[3] * var1.f31;
      float var4 = var0.g[0] * var1.f02 + var0.g[1] * var1.f12 + var0.g[2] * var1.f22 + var0.g[3] * var1.f32;
      float var5 = var0.g[0] * var1.f03 + var0.g[1] * var1.f13 + var0.g[2] * var1.f23 + var0.g[3] * var1.f33;
      float var6 = var0.g[4] * var1.f00 + var0.g[5] * var1.f10 + var0.g[6] * var1.f20 + var0.g[7] * var1.f30;
      float var7 = var0.g[4] * var1.f01 + var0.g[5] * var1.f11 + var0.g[6] * var1.f21 + var0.g[7] * var1.f31;
      float var8 = var0.g[4] * var1.f02 + var0.g[5] * var1.f12 + var0.g[6] * var1.f22 + var0.g[7] * var1.f32;
      float var9 = var0.g[4] * var1.f03 + var0.g[5] * var1.f13 + var0.g[6] * var1.f23 + var0.g[7] * var1.f33;
      float var10 = var0.g[8] * var1.f00 + var0.g[9] * var1.f10 + var0.g[10] * var1.f20 + var0.g[11] * var1.f30;
      float var11 = var0.g[8] * var1.f01 + var0.g[9] * var1.f11 + var0.g[10] * var1.f21 + var0.g[11] * var1.f31;
      float var12 = var0.g[8] * var1.f02 + var0.g[9] * var1.f12 + var0.g[10] * var1.f22 + var0.g[11] * var1.f32;
      float var13 = var0.g[8] * var1.f03 + var0.g[9] * var1.f13 + var0.g[10] * var1.f23 + var0.g[11] * var1.f33;
      float var14 = var0.g[12] * var1.f00 + var0.g[13] * var1.f10 + var0.g[14] * var1.f20 + var0.g[15] * var1.f30;
      float var15 = var0.g[12] * var1.f01 + var0.g[13] * var1.f11 + var0.g[14] * var1.f21 + var0.g[15] * var1.f31;
      float var16 = var0.g[12] * var1.f02 + var0.g[13] * var1.f12 + var0.g[14] * var1.f22 + var0.g[15] * var1.f32;
      float var17 = var0.g[12] * var1.f03 + var0.g[13] * var1.f13 + var0.g[14] * var1.f23 + var0.g[15] * var1.f33;
      var0.g[0] = var2;
      var0.g[1] = var3;
      var0.g[2] = var4;
      var0.g[3] = var5;
      var0.g[4] = var6;
      var0.g[5] = var7;
      var0.g[6] = var8;
      var0.g[7] = var9;
      var0.g[8] = var10;
      var0.g[9] = var11;
      var0.g[10] = var12;
      var0.g[11] = var13;
      var0.g[12] = var14;
      var0.g[13] = var15;
      var0.g[14] = var16;
      var0.g[15] = var17;
      return var0;
   }

   public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      int var3 = 31 * var2 + Arrays.hashCode(this.g);
      return var3;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof U316)) {
         return false;
      } else {
         U316 var2 = (U316)var1;

         for(int var3 = 0; var3 < 16; ++var3) {
            if (this.g[var3] != var2.g[var3]) {
               return false;
            }
         }

         return true;
      }
   }

   public static U316 e(U316 var0, H303 var1) {
      var0.g[0] = var1.g;
      var0.g[1] = var1.d;
      var0.g[2] = var1.q;
      var0.g[3] = 0.0F;
      var0.g[4] = var1.j;
      var0.g[5] = var1.e;
      var0.g[6] = var1.h;
      var0.g[7] = 0.0F;
      var0.g[8] = var1.s;
      var0.g[9] = var1.b;
      var0.g[10] = var1.l;
      var0.g[11] = 0.0F;
      var0.g[12] = var1.w;
      var0.g[13] = var1.r;
      var0.g[14] = var1.v;
      var0.g[15] = 1.0F;
      return var0;
   }

   public static U316 d(U316 var0, Matrix4 var1) {
      var0.g[0] = var1.f00;
      var0.g[1] = var1.f01;
      var0.g[2] = var1.f02;
      var0.g[3] = var1.f03;
      var0.g[4] = var1.f10;
      var0.g[5] = var1.f11;
      var0.g[6] = var1.f12;
      var0.g[7] = var1.f13;
      var0.g[8] = var1.f20;
      var0.g[9] = var1.f21;
      var0.g[10] = var1.f22;
      var0.g[11] = var1.f23;
      var0.g[12] = var1.f30;
      var0.g[13] = var1.f31;
      var0.g[14] = var1.f32;
      var0.g[15] = var1.f33;
      return var0;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();

      for(int var2 = 0; var2 < 4; ++var2) {
         for(int var3 = 0; var3 < 4; ++var3) {
            if (var3 > 0) {
               var1.append("\t");
            }

            var1.append(this.g[var2 * 4 + var3]);
         }

         var1.append("\n");
      }

      return var1.toString();
   }
}
