package com.jagex.maths;

import tfu.Gg3;
import tfu.Kl267;

public final class F304 implements Kl267 {
   public float d;
   public float g;
   public float j;
   public float q;

   public F304(V198 var1) {
      d(this, var1);
   }

   public static final F304 e(F304 var0) {
      var0.g = var0.d = var0.q = var0.j = 0.0F;
      return var0;
   }

   public F304(Gg3 var1) {
      this.g = Gg3.bl(var1);
      this.d = Gg3.bl(var1);
      this.q = Gg3.bl(var1);
      this.j = Gg3.bl(var1);
   }

   public static F304 g(F304 var0, float var1, float var2, float var3, float var4) {
      var0.g = var1;
      var0.d = var2;
      var0.q = var3;
      var0.j = var4;
      return var0;
   }

   public static F304 d(F304 var0, V198 var1) {
      g(var0, var1.d, var1.q, var1.j, var1.e);
      return var0;
   }

   public static F304 j(F304 var0, F304 var1) {
      g(var0, var1.g, var1.d, var1.q, var1.j);
      return var0;
   }

   public F304(float var1, float var2, float var3, float var4) {
      g(this, var1, var2, var3, var4);
   }

   public static final F304 h(F304 var0, Matrix4 var1) {
      float var2 = var0.g;
      float var3 = var0.d;
      float var4 = var0.q;
      float var5 = var0.j;
      var0.g = var1.f00 * var2 + var1.f10 * var3 + var1.f20 * var4 + var1.f30 * var5;
      var0.d = var1.f01 * var2 + var1.f11 * var3 + var1.f21 * var4 + var1.f31 * var5;
      var0.q = var1.f02 * var2 + var1.f12 * var3 + var1.f22 * var4 + var1.f32 * var5;
      var0.j = var1.f03 * var2 + var1.f13 * var3 + var1.f23 * var4 + var1.f33 * var5;
      return var0;
   }

   public String toString() {
      return this.g + "," + this.d + "," + this.q + "," + this.j;
   }

   public F304 s() {
      return new F304(this);
   }

   public F304() {
      e(this);
   }

   public F304(F304 var1) {
      j(this, var1);
   }
}
