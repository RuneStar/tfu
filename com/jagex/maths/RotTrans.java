package com.jagex.maths;

import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
@Bs1
@Be2
public final class RotTrans implements B164 {
   public static final RotTrans g;
   public final Quaternion rot;
   public final Vector3 trans;

   public static boolean q(RotTrans var0, RotTrans var1, float var2) {
      if (!Vector3.p(var0.trans, var1.trans, var2)) {
         return false;
      } else {
         return Quaternion.t(var0.rot, var1.rot, var2);
      }
   }

   public int hashCode() {
      return this.rot.hashCode() + this.trans.hashCode();
   }

   public boolean equals(Object var1) {
      return var1 instanceof Z165 ? d(this, (Z165)var1) : g(this, (RotTrans)var1);
   }

   public RotTrans v(float var1, float var2, float var3) {
      Vector3 var4 = Vector3.i(this.trans, var1, var2, var3);
      return new RotTrans(this.rot, var4);
   }

   public RotTrans j() {
      Quaternion var1 = this.rot.s();
      Vector3 var2 = Vector3.al(Vector3.x(this.trans), var1);
      return new RotTrans(var1, var2);
   }

   public RotTrans h(RotTrans var1) {
      Vector3 var2 = Vector3.al(var1.trans, this.rot);
      Vector3 var3 = Vector3.z(this.trans, var2);
      Quaternion var4 = this.rot.v(var1.rot);
      return new RotTrans(var4, var3);
   }

   public RotTrans s(Quaternion var1) {
      Quaternion var2 = this.rot.v(var1);
      return new RotTrans(var2, this.trans);
   }

   public RotTrans l(I48 var1) {
      Vector3 var2 = Vector3.t(this.trans, var1);
      return new RotTrans(this.rot, var2);
   }

   public RotTrans w(float var1, float var2, float var3) {
      Vector3 var4 = Vector3.m(this.trans, var1, var2, var3);
      return new RotTrans(this.rot, var4);
   }

   public RotTrans e(RotTrans var1) {
      Quaternion var2 = this.rot.r(var1.rot);
      Vector3 var3 = Vector3.z(Vector3.al(this.trans, var1.rot), var1.trans);
      return new RotTrans(var2, var3);
   }

   public RotTrans r(Vector3 var1, float var2) {
      Vector3 var3 = Vector3.n(this.trans, var1, var2);
      return new RotTrans(this.rot, var3);
   }

   public RotTrans p(RotTrans var1, float var2) {
      return new RotTrans(this.rot.p(var1.rot, var2), Vector3.av(this.trans, var1.trans, var2));
   }

   public String toString() {
      return String.format("{ ScaleRotTrans: rot=%.3f,%.3f,%.3f,%.3f | trans=%.3f,%.3f,%.3f }", this.rot.x, this.rot.y, this.rot.z, this.rot.w, this.trans.x, this.trans.y, this.trans.z);
   }

   static {
      g = new RotTrans(Quaternion.g, Vector3.g);
   }

   public static boolean g(RotTrans var0, RotTrans var1) {
      return var1 != null && Quaternion.u(var0.rot, var1.rot) && Vector3.v(var0.trans, var1.trans);
   }

   @Bs1
   @Be2
   public RotTrans(Quaternion var1, Vector3 var2) {
      this.rot = var1;
      this.trans = var2;
   }

   public RotTrans y(float var1) {
      Vector3 var2 = Vector3.ai(this.trans, var1);
      return new RotTrans(this.rot, var2);
   }

   public static boolean d(RotTrans var0, Z165 var1) {
      return var1 != null && Quaternion.z(var0.rot, var1.g) && Vector3.y(var0.trans, var1.d);
   }

   public RotTrans b(Vector3 var1) {
      Vector3 var2 = Vector3.z(this.trans, var1);
      return new RotTrans(this.rot, var2);
   }
}
