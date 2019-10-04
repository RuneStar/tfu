package com.jagex.maths;

public final class S318 {
   public final X309 d;
   public final X309 e;
   public final X309 g;
   public final X309 h;
   public final X309 j;
   public final X309 q;

   public S318(U316 var1) {
      this.g = (new X309(var1.g[3] + var1.g[0], var1.g[7] + var1.g[4], var1.g[11] + var1.g[8], var1.g[15] + var1.g[12])).g();
      this.d = (new X309(var1.g[3] - var1.g[0], var1.g[7] - var1.g[4], var1.g[11] - var1.g[8], var1.g[15] - var1.g[12])).g();
      this.q = (new X309(var1.g[3] + var1.g[1], var1.g[7] + var1.g[5], var1.g[11] + var1.g[9], var1.g[15] + var1.g[13])).g();
      this.j = (new X309(var1.g[3] - var1.g[1], var1.g[7] - var1.g[5], var1.g[11] - var1.g[9], var1.g[15] - var1.g[13])).g();
      this.e = (new X309(var1.g[3] + var1.g[2], var1.g[7] + var1.g[6], var1.g[11] + var1.g[10], var1.g[15] + var1.g[14])).g();
      this.h = (new X309(var1.g[3] - var1.g[2], var1.g[7] - var1.g[6], var1.g[11] - var1.g[10], var1.g[15] - var1.g[14])).g();
   }

   public static boolean g(S318 var0, Q10 var1) {
      if (d(var0.g, var1)) {
         return false;
      } else if (d(var0.d, var1)) {
         return false;
      } else if (d(var0.j, var1)) {
         return false;
      } else if (d(var0.q, var1)) {
         return false;
      } else if (d(var0.e, var1)) {
         return false;
      } else {
         return !d(var0.h, var1);
      }
   }

   private static boolean d(X309 var0, Q10 var1) {
      Matrix4 var2 = var1.g;
      X309 var3 = new X309(var0.d.x * var2.f00 + var0.d.y * var2.f01 + var0.d.z * var2.f02 + var0.g * var2.f03, var0.d.x * var2.f10 + var0.d.y * var2.f11 + var0.d.z * var2.f12 + var0.g * var2.f13, var0.d.x * var2.f20 + var0.d.y * var2.f21 + var0.d.z * var2.f22 + var0.g * var2.f23, var0.d.x * var2.f30 + var0.d.y * var2.f31 + var0.d.z * var2.f32 + var0.g * var2.f33);
      if (X309.d(var3, -1.0F, -1.0F, -1.0F) >= 0.0F) {
         return false;
      } else if (X309.d(var3, 1.0F, -1.0F, -1.0F) >= 0.0F) {
         return false;
      } else if (X309.d(var3, -1.0F, 1.0F, -1.0F) >= 0.0F) {
         return false;
      } else if (X309.d(var3, 1.0F, 1.0F, -1.0F) >= 0.0F) {
         return false;
      } else if (X309.d(var3, -1.0F, -1.0F, 1.0F) >= 0.0F) {
         return false;
      } else if (X309.d(var3, 1.0F, -1.0F, 1.0F) >= 0.0F) {
         return false;
      } else if (X309.d(var3, -1.0F, 1.0F, 1.0F) >= 0.0F) {
         return false;
      } else {
         return X309.d(var3, 1.0F, 1.0F, 1.0F) < 0.0F;
      }
   }
}
