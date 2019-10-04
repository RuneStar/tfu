package com.jagex.maths;

import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class ScaleRotTrans implements B164 {
   public static final ScaleRotTrans g;
   public final Quaternion rot;
   public final float scale;
   public final Vector3 trans;

   public ScaleRotTrans l(float var1, float var2, float var3) {
      Vector3 var4 = new Vector3(var1, var2, var3);
      return new ScaleRotTrans(this.scale, this.rot, var4);
   }

   public String toString() {
      return String.format("{ ScaleRotTrans: %.3f | rot=%.3f,%.3f,%.3f,%.3f | trans=%.3f,%.3f,%.3f }", this.scale, this.rot.x, this.rot.y, this.rot.z, this.rot.w, this.trans.x, this.trans.y, this.trans.z);
   }

   public static boolean d(ScaleRotTrans var0, D305 var1) {
      return var1 != null && Float.floatToIntBits(var0.scale) == Float.floatToIntBits(var1.g) && Quaternion.z(var0.rot, var1.d) && Vector3.y(var0.trans, var1.q);
   }

   public ScaleRotTrans(RotTrans var1, float var2) {
      this.rot = var1.rot;
      this.trans = var1.trans;
      this.scale = var2;
   }

   @Bs1
   @Be2
   public ScaleRotTrans(float var1, Quaternion var2, Vector3 var3) {
      this.scale = var1;
      this.rot = var2;
      this.trans = var3;
   }

   public RotTrans q() {
      return new RotTrans(this.rot, this.trans);
   }

   public ScaleRotTrans e(ScaleRotTrans var1) {
      float var2 = this.scale * var1.scale;
      Quaternion var3 = this.rot.r(var1.rot);
      Vector3 var4 = Vector3.z(Vector3.al(Vector3.ai(this.trans, var1.scale), var1.rot), var1.trans);
      return new ScaleRotTrans(var2, var3, var4);
   }

   public ScaleRotTrans j() {
      float var1 = 1.0F / this.scale;
      Quaternion var2 = this.rot.s();
      Vector3 var3 = Vector3.ai(Vector3.al(Vector3.x(this.trans), var2), var1);
      return new ScaleRotTrans(var1, var2, var3);
   }

   public ScaleRotTrans s(float var1) {
      return new ScaleRotTrans(var1, this.rot, this.trans);
   }

   public ScaleRotTrans b(Quaternion var1) {
      return new ScaleRotTrans(this.scale, var1, this.trans);
   }

   public ScaleRotTrans w(Vector3 var1) {
      return new ScaleRotTrans(this.scale, this.rot, var1);
   }

   static {
      g = new ScaleRotTrans(1.0F, Quaternion.g, Vector3.g);
   }

   public ScaleRotTrans h(Vector3 var1) {
      Vector3 var2 = Vector3.z(this.trans, var1);
      return new ScaleRotTrans(this.scale, this.rot, var2);
   }

   public boolean equals(Object var1) {
      return var1 instanceof D305 ? d(this, (D305)var1) : g(this, (ScaleRotTrans)var1);
   }

   public static boolean g(ScaleRotTrans var0, ScaleRotTrans var1) {
      return var1 != null && Float.floatToIntBits(var0.scale) == Float.floatToIntBits(var1.scale) && Quaternion.u(var0.rot, var1.rot) && Vector3.v(var0.trans, var1.trans);
   }

   public int hashCode() {
      return Float.floatToIntBits(this.scale) + this.rot.hashCode() + this.trans.hashCode();
   }

   public ScaleRotTrans(RotTrans var1) {
      this.rot = var1.rot;
      this.trans = var1.trans;
      this.scale = 1.0F;
   }
}
