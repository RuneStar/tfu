package com.jagex.maths;

public final class Z165 implements G300 {
   public I48 d;
   public O166 g;

   public static Z165 j(Z165 var0, RotTrans var1) {
      O166.k(var0.g, var1.rot);
      I48.al(var0.d, var1.rot);
      I48.n(var0.d, var1.trans);
      return var0;
   }

   public Z165(RotTrans var1) {
      this.g = new O166();
      this.d = new I48();
      g(this, var1);
   }

   public static Z165 d(Z165 var0, Z165 var1) {
      O166.s(var0.g, var1.g);
      I48.u(var0.d, var1.d);
      return var0;
   }

   public static Z165 s(Z165 var0, RotTrans var1, float var2) {
      O166.f(var0.g, var1.rot, var2);
      I48.av(var0.d, var1.trans, var2);
      return var0;
   }

   public Z165(Quaternion var1, I48 var2) {
      this.g = new O166(var1);
      this.d = new I48(var2);
   }

   public Z165(Z165 var1) {
      this.g = new O166();
      this.d = new I48();
      d(this, var1);
   }

   public Z165(O166 var1, I48 var2) {
      this.g = new O166(var1);
      this.d = new I48(var2);
   }

   public static Z165 g(Z165 var0, RotTrans var1) {
      O166.h(var0.g, var1.rot);
      I48.x(var0.d, var1.trans);
      return var0;
   }

   public Z165(O166 var1, Vector3 var2) {
      this.g = new O166(var1);
      this.d = new I48(var2);
   }

   public static Z165 q(Z165 var0) {
      O166.v(var0.g);
      I48.z(var0.d);
      return var0;
   }

   public String toString() {
      return "[" + this.g.toString() + "|" + this.d.toString() + "]";
   }

   public static Z165 e(Z165 var0, RotTrans var1) {
      I48 var2 = I48.r(var1.trans);
      I48.af(var2, var0.g);
      I48.k(var0.d, var2);
      I48.y(var2);
      O166.o(var0.g, var1.rot);
      return var0;
   }

   public static Z165 h(Z165 var0, Quaternion var1) {
      O166.o(var0.g, var1);
      return var0;
   }

   public Z165() {
      this.g = new O166();
      this.d = new I48();
   }

   public RotTrans b() {
      return new RotTrans(this.g.ag(), this.d.ao());
   }

   public Z165(Quaternion var1, Vector3 var2) {
      this.g = new O166(var1);
      this.d = new I48(var2);
   }
}
