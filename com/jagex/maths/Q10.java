package com.jagex.maths;

public final class Q10 {
   public final Matrix4 g;

   public static float g(Q10 var0) {
      return var0.g.f30 + Math.abs(var0.g.f00) + Math.abs(var0.g.f10) + Math.abs(var0.g.f20);
   }

   public static float q(Q10 var0) {
      return var0.g.f31 + Math.abs(var0.g.f01) + Math.abs(var0.g.f11) + Math.abs(var0.g.f21);
   }

   public static float j(Q10 var0) {
      return var0.g.f31 - (Math.abs(var0.g.f01) + Math.abs(var0.g.f11) + Math.abs(var0.g.f21));
   }

   public Vector3 l() {
      float var1 = this.g.f30;
      float var2 = this.g.f31;
      float var3 = this.g.f32;
      return new Vector3(var1, var2, var3);
   }

   public Q10(float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = (var4 - var1) * 0.5F;
      float var8 = (var5 - var2) * 0.5F;
      float var9 = (var6 - var3) * 0.5F;
      this.g = Matrix4.e(var7, var8, var9, 1.0F).v(var1 + var7, var2 + var8, var3 + var9);
   }

   public Q10 s(ScaleRotTrans var1) {
      return new Q10(this.g.d(var1));
   }

   public boolean b(E41 var1) {
      X309[] var2 = new X309[]{new X309(-1.0F, 0.0F, 0.0F, var1.g), new X309(1.0F, 0.0F, 0.0F, var1.j), new X309(0.0F, -1.0F, 0.0F, var1.d), new X309(0.0F, 1.0F, 0.0F, var1.e), new X309(0.0F, 0.0F, -1.0F, var1.q), new X309(0.0F, 0.0F, 1.0F, var1.h)};

      for(int var3 = 0; var3 < 6; ++var3) {
         X309 var4 = var2[var3];
         X309 var5 = new X309(var4.d.x * this.g.f00 + var4.d.y * this.g.f01 + var4.d.z * this.g.f02 + var4.g * this.g.f03, var4.d.x * this.g.f10 + var4.d.y * this.g.f11 + var4.d.z * this.g.f12 + var4.g * this.g.f13, var4.d.x * this.g.f20 + var4.d.y * this.g.f21 + var4.d.z * this.g.f22 + var4.g * this.g.f23, var4.d.x * this.g.f30 + var4.d.y * this.g.f31 + var4.d.z * this.g.f32 + var4.g * this.g.f33);
         if (X309.d(var5, -1.0F, -1.0F, -1.0F) < 0.0F && X309.d(var5, 1.0F, -1.0F, -1.0F) < 0.0F && X309.d(var5, -1.0F, 1.0F, -1.0F) < 0.0F && X309.d(var5, 1.0F, 1.0F, -1.0F) < 0.0F && X309.d(var5, -1.0F, -1.0F, 1.0F) < 0.0F && X309.d(var5, 1.0F, -1.0F, 1.0F) < 0.0F && X309.d(var5, -1.0F, 1.0F, 1.0F) < 0.0F && X309.d(var5, 1.0F, 1.0F, 1.0F) < 0.0F) {
            return false;
         }
      }

      return true;
   }

   public Q10(Matrix4 var1) {
      this.g = var1;
   }

   public static float e(Q10 var0) {
      return var0.g.f32 + Math.abs(var0.g.f02) + Math.abs(var0.g.f12) + Math.abs(var0.g.f22);
   }

   public static float h(Q10 var0) {
      return var0.g.f32 - (Math.abs(var0.g.f02) + Math.abs(var0.g.f12) + Math.abs(var0.g.f22));
   }

   public static float d(Q10 var0) {
      return var0.g.f30 - (Math.abs(var0.g.f00) + Math.abs(var0.g.f10) + Math.abs(var0.g.f20));
   }
}
