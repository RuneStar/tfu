package com.jagex.maths;

import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;

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
public class M47 {
   static ThreadLocal d = new ThreadLocal();
   public static final M47 g = new M47(1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
   public final float f00;
   public final float f01;
   public final float f02;
   public final float f10;
   public final float f11;
   public final float f12;
   public final float f20;
   public final float f21;
   public final float f22;

   public M47 e(M47 var1) {
      float var2 = var1.f00 * this.f00 + var1.f10 * this.f01 + var1.f20 * this.f02;
      float var3 = var1.f01 * this.f00 + var1.f11 * this.f01 + var1.f21 * this.f02;
      float var4 = var1.f02 * this.f00 + var1.f12 * this.f01 + var1.f22 * this.f02;
      float var5 = var1.f00 * this.f10 + var1.f10 * this.f11 + var1.f20 * this.f12;
      float var6 = var1.f01 * this.f10 + var1.f11 * this.f11 + var1.f21 * this.f12;
      float var7 = var1.f02 * this.f10 + var1.f12 * this.f11 + var1.f22 * this.f12;
      float var8 = var1.f00 * this.f20 + var1.f10 * this.f21 + var1.f20 * this.f22;
      float var9 = var1.f01 * this.f20 + var1.f11 * this.f21 + var1.f21 * this.f22;
      float var10 = var1.f02 * this.f20 + var1.f12 * this.f21 + var1.f22 * this.f22;
      M47 var11 = new M47(var2, var3, var4, var5, var6, var7, var8, var9, var10);
      return var11;
   }

   public M47(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      this.f00 = var1;
      this.f01 = var2;
      this.f02 = var3;
      this.f10 = var4;
      this.f11 = var5;
      this.f12 = var6;
      this.f20 = var7;
      this.f21 = var8;
      this.f22 = var9;
   }

   public static M47 g(Vector3 var0, float var1) {
      return Quaternion.j(var0, var1).m();
   }

   public static M47 d(float var0, float var1, float var2, float var3) {
      return Quaternion.e(var0, var1, var2, var3).m();
   }

   public Quaternion q() {
      float var1 = this.f00 + this.f11 + this.f22;
      float[] var2 = (float[])d.get();
      if (var2 == null) {
         var2 = new float[4];
         d.set(var2);
      }

      if (var1 > 0.0F) {
         float var3 = (float)Math.sqrt((double)(var1 + 1.0F));
         var2[3] = var3 * 0.5F;
         var3 = 0.5F / var3;
         var2[0] = (this.f12 - this.f21) * var3;
         var2[1] = (this.f20 - this.f02) * var3;
         var2[2] = (this.f01 - this.f10) * var3;
      } else {
         int var7 = this.f00 < this.f11 ? (this.f11 < this.f22 ? 2 : 1) : (this.f00 < this.f22 ? 2 : 0);
         int var4 = (var7 + 1) % 3;
         int var5 = (var7 + 2) % 3;
         float var6 = (float)Math.sqrt((double)(this.j(var7, var7) - this.j(var4, var4) - this.j(var5, var5) + 1.0F));
         var2[var7] = var6 * 0.5F;
         var6 = 0.5F / var6;
         var2[3] = (this.j(var4, var5) - this.j(var5, var4)) * var6;
         var2[var4] = (this.j(var7, var4) + this.j(var4, var7)) * var6;
         var2[var5] = (this.j(var7, var5) + this.j(var5, var7)) * var6;
      }

      return new Quaternion(var2[0], var2[1], var2[2], var2[3]);
   }

   private float j(int var1, int var2) {
      switch(var1) {
      case 0:
         switch(var2) {
         case 0:
            return this.f00;
         case 1:
            return this.f01;
         case 2:
            return this.f02;
         default:
            throw new IllegalArgumentException();
         }
      case 1:
         switch(var2) {
         case 0:
            return this.f10;
         case 1:
            return this.f11;
         case 2:
            return this.f12;
         default:
            throw new IllegalArgumentException();
         }
      case 2:
         switch(var2) {
         case 0:
            return this.f20;
         case 1:
            return this.f21;
         case 2:
            return this.f22;
         }
      }

      throw new IllegalArgumentException();
   }

   public M47(Vector3 var1, Vector3 var2, Vector3 var3) {
      this.f00 = var1.x;
      this.f01 = var2.x;
      this.f02 = var3.x;
      this.f10 = var1.y;
      this.f11 = var2.y;
      this.f12 = var3.y;
      this.f20 = var1.z;
      this.f21 = var2.z;
      this.f22 = var3.z;
   }

   public String toString() {
      return this.f00 + "," + this.f01 + "," + this.f02 + "\n" + this.f10 + "," + this.f11 + "," + this.f12 + "\n" + this.f20 + "," + this.f21 + "," + this.f22;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof M47)) {
         return false;
      } else {
         M47 var2 = (M47)var1;
         return this.f00 == var2.f00 && this.f01 == var2.f01 && this.f02 == var2.f02 && this.f10 == var2.f10 && this.f11 == var2.f11 && this.f12 == var2.f12 && this.f20 == var2.f20 && this.f21 == var2.f21 && this.f22 == var2.f22;
      }
   }

   public M47 h(M47 var1) {
      float var2 = this.f00 * var1.f00 + this.f10 * var1.f01 + this.f20 * var1.f02;
      float var3 = this.f01 * var1.f00 + this.f11 * var1.f01 + this.f21 * var1.f02;
      float var4 = this.f02 * var1.f00 + this.f12 * var1.f01 + this.f22 * var1.f02;
      float var5 = this.f00 * var1.f10 + this.f10 * var1.f11 + this.f20 * var1.f12;
      float var6 = this.f01 * var1.f10 + this.f11 * var1.f11 + this.f21 * var1.f12;
      float var7 = this.f02 * var1.f10 + this.f12 * var1.f11 + this.f22 * var1.f12;
      float var8 = this.f00 * var1.f20 + this.f10 * var1.f21 + this.f20 * var1.f22;
      float var9 = this.f01 * var1.f20 + this.f11 * var1.f21 + this.f21 * var1.f22;
      float var10 = this.f02 * var1.f20 + this.f12 * var1.f21 + this.f22 * var1.f22;
      M47 var11 = new M47(var2, var3, var4, var5, var6, var7, var8, var9, var10);
      return var11;
   }

   public static M47 s(M47 var0, I48 var1) {
      float var2 = var1.j;
      float var3 = var1.e;
      float var4 = var1.h;
      var1.j = var0.f00 * var2 + var0.f10 * var3 + var0.f20 * var4;
      var1.e = var0.f01 * var2 + var0.f11 * var3 + var0.f21 * var4;
      var1.h = var0.f02 * var2 + var0.f12 * var3 + var0.f22 * var4;
      return var0;
   }

   public static M47 b(M47 var0, Gg3 var1) {
      Gg3.aq(var1, var0.f00);
      Gg3.aq(var1, var0.f01);
      Gg3.aq(var1, var0.f02);
      Gg3.aq(var1, var0.f10);
      Gg3.aq(var1, var0.f11);
      Gg3.aq(var1, var0.f12);
      Gg3.aq(var1, var0.f20);
      Gg3.aq(var1, var0.f21);
      Gg3.aq(var1, var0.f22);
      return var0;
   }
}
