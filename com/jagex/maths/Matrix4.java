package com.jagex.maths;

import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class Matrix4 {
   public static final Matrix4 g = new Matrix4(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F);
   public final float f00;
   public final float f01;
   public final float f02;
   public final float f03;
   public final float f10;
   public final float f11;
   public final float f12;
   public final float f13;
   public final float f20;
   public final float f21;
   public final float f22;
   public final float f23;
   public final float f30;
   public final float f31;
   public final float f32;
   public final float f33;

   public Matrix4(RotTrans var1) {
      float var2 = var1.rot.w * var1.rot.w;
      float var3 = var1.rot.w * var1.rot.x;
      float var4 = var1.rot.w * var1.rot.y;
      float var5 = var1.rot.w * var1.rot.z;
      float var6 = var1.rot.x * var1.rot.x;
      float var7 = var1.rot.x * var1.rot.y;
      float var8 = var1.rot.x * var1.rot.z;
      float var9 = var1.rot.y * var1.rot.y;
      float var10 = var1.rot.y * var1.rot.z;
      float var11 = var1.rot.z * var1.rot.z;
      this.f00 = var6 + var2 - var11 - var9;
      this.f01 = var7 + var5 + var7 + var5;
      this.f02 = var8 - var4 - var4 + var8;
      this.f10 = var7 - var5 - var5 + var7;
      this.f11 = var9 + var2 - var6 - var11;
      this.f12 = var10 + var3 + var10 + var3;
      this.f20 = var8 + var4 + var8 + var4;
      this.f21 = var10 - var3 - var3 + var10;
      this.f22 = var11 + var2 - var9 - var6;
      this.f03 = 0.0F;
      this.f13 = 0.0F;
      this.f23 = 0.0F;
      this.f30 = var1.trans.x;
      this.f31 = var1.trans.y;
      this.f32 = var1.trans.z;
      this.f33 = 1.0F;
   }

   public Matrix4(float[] var1) {
      this.f00 = var1[0];
      this.f01 = var1[1];
      this.f02 = var1[2];
      this.f03 = var1[3];
      this.f10 = var1[4];
      this.f11 = var1[5];
      this.f12 = var1[6];
      this.f13 = var1[7];
      this.f20 = var1[8];
      this.f21 = var1[9];
      this.f22 = var1[10];
      this.f23 = var1[11];
      this.f30 = var1[12];
      this.f31 = var1[13];
      this.f32 = var1[14];
      this.f33 = var1[15];
   }

   public Matrix4 d(ScaleRotTrans var1) {
      Quaternion var2 = var1.rot;
      float var3 = var2.x * var2.x;
      float var4 = var2.x * var2.y;
      float var5 = var2.x * var2.z;
      float var6 = var2.x * var2.w;
      float var7 = var2.y * var2.y;
      float var8 = var2.y * var2.z;
      float var9 = var2.y * var2.w;
      float var10 = var2.z * var2.z;
      float var11 = var2.z * var2.w;
      float var12 = 1.0F - 2.0F * (var7 + var10);
      float var13 = 2.0F * (var4 - var11);
      float var14 = 2.0F * (var5 + var9);
      float var15 = 2.0F * (var4 + var11);
      float var16 = 1.0F - 2.0F * (var3 + var10);
      float var17 = 2.0F * (var8 - var6);
      float var18 = 2.0F * (var5 - var9);
      float var19 = 2.0F * (var8 + var6);
      float var20 = 1.0F - 2.0F * (var3 + var7);
      float var21 = var1.scale;
      return new Matrix4((this.f00 * var12 + this.f01 * var13 + this.f02 * var14) * var21, (this.f00 * var15 + this.f01 * var16 + this.f02 * var17) * var21, (this.f00 * var18 + this.f01 * var19 + this.f02 * var20) * var21, this.f03 * var21, (this.f10 * var12 + this.f11 * var13 + this.f12 * var14) * var21, (this.f10 * var15 + this.f11 * var16 + this.f12 * var17) * var21, (this.f10 * var18 + this.f11 * var19 + this.f12 * var20) * var21, this.f13 * var21, (this.f20 * var12 + this.f21 * var13 + this.f22 * var14) * var21, (this.f20 * var15 + this.f21 * var16 + this.f22 * var17) * var21, (this.f20 * var18 + this.f21 * var19 + this.f22 * var20) * var21, this.f23 * var21, this.f30 * var12 + this.f31 * var13 + this.f32 * var14 + var1.trans.x, this.f30 * var15 + this.f31 * var16 + this.f32 * var17 + var1.trans.y, this.f30 * var18 + this.f31 * var19 + this.f32 * var20 + var1.trans.z, this.f33);
   }

   public Matrix4 g(Matrix4 var1) {
      float var2 = this.f00 * var1.f00 + this.f01 * var1.f10 + this.f02 * var1.f20 + this.f03 * var1.f30;
      float var3 = this.f00 * var1.f01 + this.f01 * var1.f11 + this.f02 * var1.f21 + this.f03 * var1.f31;
      float var4 = this.f00 * var1.f02 + this.f01 * var1.f12 + this.f02 * var1.f22 + this.f03 * var1.f32;
      float var5 = this.f00 * var1.f03 + this.f01 * var1.f13 + this.f02 * var1.f23 + this.f03 * var1.f33;
      float var6 = this.f10 * var1.f00 + this.f11 * var1.f10 + this.f12 * var1.f20 + this.f13 * var1.f30;
      float var7 = this.f10 * var1.f01 + this.f11 * var1.f11 + this.f12 * var1.f21 + this.f13 * var1.f31;
      float var8 = this.f10 * var1.f02 + this.f11 * var1.f12 + this.f12 * var1.f22 + this.f13 * var1.f32;
      float var9 = this.f10 * var1.f03 + this.f11 * var1.f13 + this.f12 * var1.f23 + this.f13 * var1.f33;
      float var10 = this.f20 * var1.f00 + this.f21 * var1.f10 + this.f22 * var1.f20 + this.f23 * var1.f30;
      float var11 = this.f20 * var1.f01 + this.f21 * var1.f11 + this.f22 * var1.f21 + this.f23 * var1.f31;
      float var12 = this.f20 * var1.f02 + this.f21 * var1.f12 + this.f22 * var1.f22 + this.f23 * var1.f32;
      float var13 = this.f20 * var1.f03 + this.f21 * var1.f13 + this.f22 * var1.f23 + this.f23 * var1.f33;
      float var14 = this.f30 * var1.f00 + this.f31 * var1.f10 + this.f32 * var1.f20 + this.f33 * var1.f30;
      float var15 = this.f30 * var1.f01 + this.f31 * var1.f11 + this.f32 * var1.f21 + this.f33 * var1.f31;
      float var16 = this.f30 * var1.f02 + this.f31 * var1.f12 + this.f32 * var1.f22 + this.f33 * var1.f32;
      float var17 = this.f30 * var1.f03 + this.f31 * var1.f13 + this.f32 * var1.f23 + this.f33 * var1.f33;
      return new Matrix4(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
   }

   public Matrix4 j() {
      float var1 = 1.0F / q(this);
      float var2 = (this.f11 * this.f22 * this.f33 - this.f11 * this.f23 * this.f32 - this.f12 * this.f21 * this.f33 + this.f12 * this.f23 * this.f31 + this.f13 * this.f21 * this.f32 - this.f13 * this.f22 * this.f31) * var1;
      float var3 = (-this.f01 * this.f22 * this.f33 + this.f01 * this.f23 * this.f32 + this.f02 * this.f21 * this.f33 - this.f02 * this.f23 * this.f31 - this.f03 * this.f21 * this.f32 + this.f03 * this.f22 * this.f31) * var1;
      float var4 = (this.f01 * this.f12 * this.f33 - this.f01 * this.f13 * this.f32 - this.f02 * this.f11 * this.f33 + this.f02 * this.f13 * this.f31 + this.f03 * this.f11 * this.f32 - this.f03 * this.f12 * this.f31) * var1;
      float var5 = (-this.f01 * this.f12 * this.f23 + this.f01 * this.f13 * this.f22 + this.f02 * this.f11 * this.f23 - this.f02 * this.f13 * this.f21 - this.f03 * this.f11 * this.f22 + this.f03 * this.f12 * this.f21) * var1;
      float var6 = (-this.f10 * this.f22 * this.f33 + this.f10 * this.f23 * this.f32 + this.f12 * this.f20 * this.f33 - this.f12 * this.f23 * this.f30 - this.f13 * this.f20 * this.f32 + this.f13 * this.f22 * this.f30) * var1;
      float var7 = (this.f00 * this.f22 * this.f33 - this.f00 * this.f23 * this.f32 - this.f02 * this.f20 * this.f33 + this.f02 * this.f23 * this.f30 + this.f03 * this.f20 * this.f32 - this.f03 * this.f22 * this.f30) * var1;
      float var8 = (-this.f00 * this.f12 * this.f33 + this.f00 * this.f13 * this.f32 + this.f02 * this.f10 * this.f33 - this.f02 * this.f13 * this.f30 - this.f03 * this.f10 * this.f32 + this.f03 * this.f12 * this.f30) * var1;
      float var9 = (this.f00 * this.f12 * this.f23 - this.f00 * this.f13 * this.f22 - this.f02 * this.f10 * this.f23 + this.f02 * this.f13 * this.f20 + this.f03 * this.f10 * this.f22 - this.f03 * this.f12 * this.f20) * var1;
      float var10 = (this.f10 * this.f21 * this.f33 - this.f10 * this.f23 * this.f31 - this.f11 * this.f20 * this.f33 + this.f11 * this.f23 * this.f30 + this.f13 * this.f20 * this.f31 - this.f13 * this.f21 * this.f30) * var1;
      float var11 = (-this.f00 * this.f21 * this.f33 + this.f00 * this.f23 * this.f31 + this.f01 * this.f20 * this.f33 - this.f01 * this.f23 * this.f30 - this.f03 * this.f20 * this.f31 + this.f03 * this.f21 * this.f30) * var1;
      float var12 = (this.f00 * this.f11 * this.f33 - this.f00 * this.f13 * this.f31 - this.f01 * this.f10 * this.f33 + this.f01 * this.f13 * this.f30 + this.f03 * this.f10 * this.f31 - this.f03 * this.f11 * this.f30) * var1;
      float var13 = (-this.f00 * this.f11 * this.f23 + this.f00 * this.f13 * this.f21 + this.f01 * this.f10 * this.f23 - this.f01 * this.f13 * this.f20 - this.f03 * this.f10 * this.f21 + this.f03 * this.f11 * this.f20) * var1;
      float var14 = (-this.f10 * this.f21 * this.f32 + this.f10 * this.f22 * this.f31 + this.f11 * this.f20 * this.f32 - this.f11 * this.f22 * this.f30 - this.f12 * this.f20 * this.f31 + this.f12 * this.f21 * this.f30) * var1;
      float var15 = (this.f00 * this.f21 * this.f32 - this.f00 * this.f22 * this.f31 - this.f01 * this.f20 * this.f32 + this.f01 * this.f22 * this.f30 + this.f02 * this.f20 * this.f31 - this.f02 * this.f21 * this.f30) * var1;
      float var16 = (-this.f00 * this.f11 * this.f32 + this.f00 * this.f12 * this.f31 + this.f01 * this.f10 * this.f32 - this.f01 * this.f12 * this.f30 - this.f02 * this.f10 * this.f31 + this.f02 * this.f11 * this.f30) * var1;
      float var17 = (this.f00 * this.f11 * this.f22 - this.f00 * this.f12 * this.f21 - this.f01 * this.f10 * this.f22 + this.f01 * this.f12 * this.f20 + this.f02 * this.f10 * this.f21 - this.f02 * this.f11 * this.f20) * var1;
      return new Matrix4(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
   }

   public static Matrix4 w(float var0, float var1, float var2) {
      return b(-10000.0F / var2, 10000.0F / var2, -10000.0F / var2, 10000.0F / var2, var0, var1);
   }

   public Matrix4(Quaternion var1) {
      float var2 = var1.w * var1.w;
      float var3 = var1.w * var1.x;
      float var4 = var1.w * var1.y;
      float var5 = var1.w * var1.z;
      float var6 = var1.x * var1.x;
      float var7 = var1.x * var1.y;
      float var8 = var1.x * var1.z;
      float var9 = var1.y * var1.y;
      float var10 = var1.y * var1.z;
      float var11 = var1.z * var1.z;
      this.f00 = var6 + var2 - var11 - var9;
      this.f01 = var7 + var5 + var7 + var5;
      this.f02 = var8 - var4 - var4 + var8;
      this.f03 = 0.0F;
      this.f10 = var7 - var5 - var5 + var7;
      this.f11 = var9 + var2 - var6 - var11;
      this.f12 = var10 + var3 + var10 + var3;
      this.f13 = 0.0F;
      this.f20 = var8 + var4 + var8 + var4;
      this.f21 = var10 - var3 - var3 + var10;
      this.f22 = var11 + var2 - var9 - var6;
      this.f23 = 0.0F;
      this.f30 = 0.0F;
      this.f31 = 0.0F;
      this.f32 = 0.0F;
      this.f33 = 1.0F;
   }

   public static float q(Matrix4 var0) {
      return var0.f00 * var0.f11 * var0.f22 * var0.f33 - var0.f00 * var0.f11 * var0.f23 * var0.f32 - var0.f00 * var0.f12 * var0.f21 * var0.f33 + var0.f00 * var0.f12 * var0.f23 * var0.f31 + var0.f00 * var0.f13 * var0.f21 * var0.f32 - var0.f00 * var0.f13 * var0.f22 * var0.f31 - var0.f01 * var0.f10 * var0.f22 * var0.f33 + var0.f01 * var0.f10 * var0.f23 * var0.f32 + var0.f01 * var0.f12 * var0.f20 * var0.f33 - var0.f01 * var0.f12 * var0.f23 * var0.f30 - var0.f01 * var0.f13 * var0.f20 * var0.f32 + var0.f01 * var0.f13 * var0.f22 * var0.f30 + var0.f02 * var0.f10 * var0.f21 * var0.f33 - var0.f02 * var0.f10 * var0.f23 * var0.f31 - var0.f02 * var0.f11 * var0.f20 * var0.f33 + var0.f02 * var0.f11 * var0.f23 * var0.f30 + var0.f02 * var0.f13 * var0.f20 * var0.f31 - var0.f02 * var0.f13 * var0.f21 * var0.f30 - var0.f03 * var0.f10 * var0.f21 * var0.f32 + var0.f03 * var0.f10 * var0.f22 * var0.f31 + var0.f03 * var0.f11 * var0.f20 * var0.f32 - var0.f03 * var0.f11 * var0.f22 * var0.f30 - var0.f03 * var0.f12 * var0.f20 * var0.f31 + var0.f03 * var0.f12 * var0.f21 * var0.f30;
   }

   public static Matrix4 l(float var0, float var1, float var2, float var3) {
      float var4 = (float)(Math.tan((double)(var2 / 2.0F)) * (double)var0);
      float var5 = (float)(Math.tan((double)(var3 / 2.0F)) * (double)var0);
      return r(-var4, var4, -var5, var5, var0, var1);
   }

   public static void h(Matrix4 var0, float[] var1) {
      float var2 = var1[0];
      float var3 = var1[1];
      float var4 = var1[2];
      var1[0] = var0.f00 * var2 + var0.f10 * var3 + var0.f20 * var4 + var0.f30;
      var1[1] = var0.f01 * var2 + var0.f11 * var3 + var0.f21 * var4 + var0.f31;
      var1[2] = var0.f02 * var2 + var0.f12 * var3 + var0.f22 * var4 + var0.f32;
   }

   public static Matrix4 b(float var0, float var1, float var2, float var3, float var4, float var5) {
      return new Matrix4(2.0F / (var1 - var0), 0.0F, 0.0F, 0.0F, 0.0F, 2.0F / (var3 - var2), 0.0F, 0.0F, 0.0F, 0.0F, 2.0F / (var5 - var4), 0.0F, -(var1 + var0) / (var1 - var0), -(var3 + var2) / (var3 - var2), -(var5 + var4) / (var5 - var4), 1.0F);
   }

   public Matrix4(H303 var1) {
      this.f00 = var1.g;
      this.f01 = var1.d;
      this.f02 = var1.q;
      this.f03 = 0.0F;
      this.f10 = var1.j;
      this.f11 = var1.e;
      this.f12 = var1.h;
      this.f13 = 0.0F;
      this.f20 = var1.s;
      this.f21 = var1.b;
      this.f22 = var1.l;
      this.f23 = 0.0F;
      this.f30 = var1.w;
      this.f31 = var1.r;
      this.f32 = var1.v;
      this.f33 = 1.0F;
   }

   public static Matrix4 r(float var0, float var1, float var2, float var3, float var4, float var5) {
      return new Matrix4(2.0F * var4 / (var1 - var0), 0.0F, 0.0F, 0.0F, 0.0F, 2.0F * var4 / (var3 - var2), 0.0F, 0.0F, (var1 + var0) / (var1 - var0), (var3 + var2) / (var3 - var2), (var5 + var4) / (var5 - var4), 1.0F, 0.0F, 0.0F, -(2.0F * var5 * var4) / (var5 - var4), 0.0F);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 == null) {
         return false;
      } else if (this.getClass() != var1.getClass()) {
         return false;
      } else {
         Matrix4 var2 = (Matrix4)var1;
         if (Float.floatToIntBits(this.f00) != Float.floatToIntBits(var2.f00)) {
            return false;
         } else if (Float.floatToIntBits(this.f01) != Float.floatToIntBits(var2.f01)) {
            return false;
         } else if (Float.floatToIntBits(this.f02) != Float.floatToIntBits(var2.f02)) {
            return false;
         } else if (Float.floatToIntBits(this.f03) != Float.floatToIntBits(var2.f03)) {
            return false;
         } else if (Float.floatToIntBits(this.f10) != Float.floatToIntBits(var2.f10)) {
            return false;
         } else if (Float.floatToIntBits(this.f11) != Float.floatToIntBits(var2.f11)) {
            return false;
         } else if (Float.floatToIntBits(this.f12) != Float.floatToIntBits(var2.f12)) {
            return false;
         } else if (Float.floatToIntBits(this.f13) != Float.floatToIntBits(var2.f13)) {
            return false;
         } else if (Float.floatToIntBits(this.f20) != Float.floatToIntBits(var2.f20)) {
            return false;
         } else if (Float.floatToIntBits(this.f21) != Float.floatToIntBits(var2.f21)) {
            return false;
         } else if (Float.floatToIntBits(this.f22) != Float.floatToIntBits(var2.f22)) {
            return false;
         } else if (Float.floatToIntBits(this.f23) != Float.floatToIntBits(var2.f23)) {
            return false;
         } else if (Float.floatToIntBits(this.f30) != Float.floatToIntBits(var2.f30)) {
            return false;
         } else if (Float.floatToIntBits(this.f31) != Float.floatToIntBits(var2.f31)) {
            return false;
         } else if (Float.floatToIntBits(this.f32) != Float.floatToIntBits(var2.f32)) {
            return false;
         } else {
            return Float.floatToIntBits(this.f33) == Float.floatToIntBits(var2.f33);
         }
      }
   }

   public Matrix4 v(float var1, float var2, float var3) {
      return new Matrix4(this.f00, this.f01, this.f02, this.f03, this.f10, this.f11, this.f12, this.f13, this.f20, this.f21, this.f22, this.f23, this.f30 + var1, this.f31 + var2, this.f32 + var3, this.f33);
   }

   @Bs1
   @Be2
   public Matrix4(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14, float var15, float var16) {
      this.f00 = var1;
      this.f01 = var2;
      this.f02 = var3;
      this.f03 = var4;
      this.f10 = var5;
      this.f11 = var6;
      this.f12 = var7;
      this.f13 = var8;
      this.f20 = var9;
      this.f21 = var10;
      this.f22 = var11;
      this.f23 = var12;
      this.f30 = var13;
      this.f31 = var14;
      this.f32 = var15;
      this.f33 = var16;
   }

   public Matrix4(K299 var1) {
      this.f00 = var1.d;
      this.f01 = var1.q;
      this.f02 = var1.j;
      this.f03 = 0.0F;
      this.f10 = var1.e;
      this.f11 = var1.h;
      this.f12 = var1.s;
      this.f13 = 0.0F;
      this.f20 = var1.b;
      this.f21 = var1.l;
      this.f22 = var1.w;
      this.f23 = 0.0F;
      this.f30 = var1.r;
      this.f31 = var1.v;
      this.f32 = var1.y;
      this.f33 = 1.0F;
   }

   public static Matrix4 e(float var0, float var1, float var2, float var3) {
      return new Matrix4(var0, 0.0F, 0.0F, 0.0F, 0.0F, var1, 0.0F, 0.0F, 0.0F, 0.0F, var2, 0.0F, 0.0F, 0.0F, 0.0F, var3);
   }

   public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      int var3 = 31 * var2 + Float.floatToIntBits(this.f00);
      var3 = 31 * var3 + Float.floatToIntBits(this.f01);
      var3 = 31 * var3 + Float.floatToIntBits(this.f02);
      var3 = 31 * var3 + Float.floatToIntBits(this.f03);
      var3 = 31 * var3 + Float.floatToIntBits(this.f10);
      var3 = 31 * var3 + Float.floatToIntBits(this.f11);
      var3 = 31 * var3 + Float.floatToIntBits(this.f12);
      var3 = 31 * var3 + Float.floatToIntBits(this.f13);
      var3 = 31 * var3 + Float.floatToIntBits(this.f20);
      var3 = 31 * var3 + Float.floatToIntBits(this.f21);
      var3 = 31 * var3 + Float.floatToIntBits(this.f22);
      var3 = 31 * var3 + Float.floatToIntBits(this.f23);
      var3 = 31 * var3 + Float.floatToIntBits(this.f30);
      var3 = 31 * var3 + Float.floatToIntBits(this.f31);
      var3 = 31 * var3 + Float.floatToIntBits(this.f32);
      var3 = 31 * var3 + Float.floatToIntBits(this.f33);
      return var3;
   }

   public String toString() {
      return this.f00 + "\t" + this.f01 + "\t" + this.f02 + "\t" + this.f03 + "\n" + this.f10 + "\t" + this.f11 + "\t" + this.f12 + "\t" + this.f13 + "\n" + this.f20 + "\t" + this.f21 + "\t" + this.f22 + "\t" + this.f23 + "\n" + this.f30 + "\t" + this.f31 + "\t" + this.f32 + "\t" + this.f33 + "\n";
   }

   public static float s(Matrix4 var0, float var1, float var2, float var3) {
      return var0.f03 * var1 + var0.f13 * var2 + var0.f23 * var3 + var0.f33;
   }
}
