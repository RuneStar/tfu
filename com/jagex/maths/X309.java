package com.jagex.maths;

public final class X309 {
   public final Vector3 d;
   public final float g;

   public static float d(X309 var0, float var1, float var2, float var3) {
      return var0.d.x * var1 + var0.d.y * var2 + var0.d.z * var3 + var0.g;
   }

   public X309(Vector3 var1, float var2) {
      this.d = var1;
      this.g = var2;
   }

   public X309(float var1, float var2, float var3, float var4) {
      this.d = new Vector3(var1, var2, var3);
      this.g = var4;
   }

   public X309 g() {
      float var1 = 1.0F / Vector3.f(this.d);
      return new X309(Vector3.ai(this.d, var1), this.g * var1);
   }

   public X309() {
      this.d = Vector3.g;
      this.g = 0.0F;
   }
}
