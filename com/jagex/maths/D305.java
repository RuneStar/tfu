package com.jagex.maths;

public final class D305 implements G300 {
   public O166 d;
   public float g;
   public I48 q;

   public D305(Z165 var1, float var2) {
      this.d = new O166();
      this.q = new I48();
      this.g = 1.0F;
      h(this, var1, var2);
   }

   public D305(D305 var1) {
      this.d = new O166();
      this.q = new I48();
      this.g = 1.0F;
      d(this, var1);
   }

   public D305(RotTrans var1) {
      this.d = new O166();
      this.q = new I48();
      this.g = 1.0F;
      q(this, var1, true);
   }

   public D305(ScaleRotTrans var1) {
      this.d = new O166();
      this.q = new I48();
      this.g = 1.0F;
      g(this, var1);
   }

   public D305(float var1, O166 var2, I48 var3) {
      this.g = var1;
      this.d = new O166(var2);
      this.q = new I48(var3);
   }

   public String toString() {
      return "[" + this.g + "|" + this.d.toString() + "|" + this.q.toString() + "]";
   }

   public D305(float var1, Quaternion var2, Vector3 var3) {
      this.g = var1;
      this.d = new O166(var2);
      this.q = new I48(var3);
   }

   public D305(float var1, Quaternion var2, I48 var3) {
      this.g = var1;
      this.d = new O166(var2);
      this.q = new I48(var3);
   }

   public D305(float var1, O166 var2, Vector3 var3) {
      this.g = var1;
      this.d = new O166(var2);
      this.q = new I48(var3);
   }

   public D305(Z165 var1) {
      this.d = new O166();
      this.q = new I48();
      this.g = 1.0F;
      j(this, var1, true);
   }

   public static D305 g(D305 var0, ScaleRotTrans var1) {
      var0.g = var1.scale;
      O166.h(var0.d, var1.rot);
      I48.x(var0.q, var1.trans);
      return var0;
   }

   public static D305 d(D305 var0, D305 var1) {
      var0.g = var1.g;
      O166.s(var0.d, var1.d);
      I48.u(var0.q, var1.q);
      return var0;
   }

   public static D305 q(D305 var0, RotTrans var1, boolean var2) {
      O166.h(var0.d, var1.rot);
      I48.x(var0.q, var1.trans);
      if (var2) {
         var0.g = 1.0F;
      }

      return var0;
   }

   public static D305 j(D305 var0, Z165 var1, boolean var2) {
      O166.s(var0.d, var1.g);
      I48.u(var0.q, var1.d);
      if (var2) {
         var0.g = 1.0F;
      }

      return var0;
   }

   public static D305 e(D305 var0, RotTrans var1, float var2) {
      O166.h(var0.d, var1.rot);
      I48.x(var0.q, var1.trans);
      var0.g = var2;
      return var0;
   }

   public D305(RotTrans var1, float var2) {
      this.d = new O166();
      this.q = new I48();
      this.g = 1.0F;
      e(this, var1, var2);
   }

   public D305() {
      this.g = 1.0F;
      this.d = new O166();
      this.q = new I48();
   }

   public static D305 h(D305 var0, Z165 var1, float var2) {
      O166.s(var0.d, var1.g);
      I48.u(var0.q, var1.d);
      var0.g = var2;
      return var0;
   }
}
