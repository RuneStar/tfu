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
public final class Quaternion implements B164 {
   public static final Quaternion g = new Quaternion(0.0F, 0.0F, 0.0F, 1.0F);
   public final float w;
   public final float x;
   public final float y;
   public final float z;

   public boolean equals(Object var1) {
      return var1 instanceof O166 ? z(this, (O166)var1) : u(this, (Quaternion)var1);
   }

   public static Quaternion d(Gg3 var0) {
      return new Quaternion(var0);
   }

   public static Quaternion e(float var0, float var1, float var2, float var3) {
      float var4 = (float)Math.sin((double)(var3 * 0.5F));
      float var5 = (float)Math.cos((double)(var3 * 0.5F));
      return new Quaternion(var0 * var4, var1 * var4, var2 * var4, var5);
   }

   public static boolean z(Quaternion var0, O166 var1) {
      return var1 != null && Float.floatToIntBits(var0.x) == Float.floatToIntBits(var1.j) && Float.floatToIntBits(var0.y) == Float.floatToIntBits(var1.e) && Float.floatToIntBits(var0.z) == Float.floatToIntBits(var1.h) && Float.floatToIntBits(var0.w) == Float.floatToIntBits(var1.s);
   }

   public static void q(Quaternion var0, Gg3 var1) {
      Gg3.aq(var1, var0.x);
      Gg3.aq(var1, var0.y);
      Gg3.aq(var1, var0.z);
      Gg3.aq(var1, var0.w);
   }

   public static Quaternion j(Vector3 var0, float var1) {
      return e(var0.x, var0.y, var0.z, var1);
   }

   public static Quaternion g(float var0, float var1, float var2, float var3) {
      return new Quaternion(var0, var1, var2, var3);
   }

   public static Quaternion h(float var0, float var1, float var2) {
      O166 var3 = new O166();
      O166.l(var3, Vector3.g(0.0F, 1.0F, 0.0F), var0);
      O166 var4 = O166.d();
      O166.l(var4, Vector3.g(1.0F, 0.0F, 0.0F), var1);
      O166.i(var3, var4);
      O166.l(var4, Vector3.g(0.0F, 0.0F, 1.0F), var2);
      O166.i(var3, var4);
      O166.e(var4);
      return var3.ag();
   }

   public final Quaternion b() {
      float var1 = 1.0F / w(this);
      return new Quaternion(this.x * var1, this.y * var1, this.z * var1, this.w * var1);
   }

   public final Quaternion s() {
      return new Quaternion(-this.x, -this.y, -this.z, this.w);
   }

   public static final float w(Quaternion var0) {
      return (float)Math.sqrt((double)l(var0, var0));
   }

   public final Quaternion r(Quaternion var1) {
      return new Quaternion(var1.w * this.x + var1.x * this.w + var1.y * this.z - var1.z * this.y, var1.w * this.y - var1.x * this.z + var1.y * this.w + var1.z * this.x, var1.w * this.z + var1.x * this.y - var1.y * this.x + var1.z * this.w, var1.w * this.w - var1.x * this.x - var1.y * this.y - var1.z * this.z);
   }

   public final Quaternion p(Quaternion var1, float var2) {
      O166 var3 = new O166(this);
      if (O166.t(var3, var1) < 0.0F) {
         O166.y(var3);
      }

      O166.a(var3, 1.0F - var2);
      O166.z(var3, var1, var2);
      O166.x(var3);
      return var3.ag();
   }

   public Vector3 x() {
      float var1 = this.w;
      if (var1 > 1.0F) {
         var1 = 1.0F;
      } else if (var1 < -1.0F) {
         var1 = -1.0F;
      }

      float var2 = (float)(Math.acos((double)var1) * 2.0D);
      if (var2 == 0.0F) {
         return Vector3.g;
      } else {
         I48 var3 = new I48(this.x, this.y, this.z);
         if (this.x != 0.0F || this.y != 0.0F || this.z != 0.0F) {
            I48.m(var3);
            I48.aq(var3, var2);
         }

         return var3.ao();
      }
   }

   public int hashCode() {
      return Float.floatToIntBits(this.x) + Float.floatToIntBits(this.y) + Float.floatToIntBits(this.z) + Float.floatToIntBits(this.w);
   }

   public M47 m() {
      float var1 = this.w * this.w;
      float var2 = this.w * this.x;
      float var3 = this.w * this.y;
      float var4 = this.w * this.z;
      float var5 = this.x * this.x;
      float var6 = this.x * this.y;
      float var7 = this.x * this.z;
      float var8 = this.y * this.y;
      float var9 = this.y * this.z;
      float var10 = this.z * this.z;
      M47 var11 = new M47(var5 + var1 - var10 - var8, var6 + var4 + var6 + var4, var7 - var3 - var3 + var7, var6 - var4 - var4 + var6, var8 + var1 - var5 - var10, var9 + var2 + var9 + var2, var7 + var3 + var7 + var3, var9 - var2 - var2 + var9, var10 + var1 - var8 - var5);
      return var11;
   }

   public static boolean u(Quaternion var0, Quaternion var1) {
      return var1 != null && Float.floatToIntBits(var0.x) == Float.floatToIntBits(var1.x) && Float.floatToIntBits(var0.y) == Float.floatToIntBits(var1.y) && Float.floatToIntBits(var0.z) == Float.floatToIntBits(var1.z) && Float.floatToIntBits(var0.w) == Float.floatToIntBits(var1.w);
   }

   public Quaternion(Gg3 var1) {
      this.x = Gg3.bl(var1);
      this.y = Gg3.bl(var1);
      this.z = Gg3.bl(var1);
      this.w = Gg3.bl(var1);
   }

   public String toString() {
      return String.format("{ Quaternion: %.3f,%.3f,%.3f,%.3f }", this.x, this.y, this.z, this.w);
   }

   public final Quaternion y(float var1) {
      return new Quaternion(this.x * var1, this.y * var1, this.z * var1, this.w * var1);
   }

   @Bs1
   @Be2
   public Quaternion(float var1, float var2, float var3, float var4) {
      this.x = var1;
      this.y = var2;
      this.z = var3;
      this.w = var4;
   }

   public static final float l(Quaternion var0, Quaternion var1) {
      return var0.x * var1.x + var0.y * var1.y + var0.z * var1.z + var0.w * var1.w;
   }

   public final Quaternion v(Quaternion var1) {
      return new Quaternion(this.w * var1.x + this.x * var1.w + this.y * var1.z - this.z * var1.y, this.w * var1.y - this.x * var1.z + this.y * var1.w + this.z * var1.x, this.w * var1.z + this.x * var1.y - this.y * var1.x + this.z * var1.w, this.w * var1.w - this.x * var1.x - this.y * var1.y - this.z * var1.z);
   }

   public static boolean t(Quaternion var0, Quaternion var1, float var2) {
      if (var1.x - var0.x <= var2 && var1.x - var0.x >= -var2) {
         if (var1.y - var0.y <= var2 && var1.y - var0.y >= -var2) {
            if (var1.z - var0.z <= var2 && var1.z - var0.z >= -var2) {
               return var1.w - var0.w <= var2 && var1.w - var0.w >= -var2;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
