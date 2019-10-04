package com.jagex.math;

import tfu.Be2;
import tfu.Bs1;

/** @deprecated */
@Deprecated
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class ScaleRotTrans implements D99 {
   public static final ScaleRotTrans g = new ScaleRotTrans();
   public Quaternion rot;
   public float scale;
   public Vector3 trans;

   public ScaleRotTrans(RotTrans var1, float var2) {
      this.rot = new Quaternion();
      this.trans = new Vector3();
      this.scale = 1.0F;
      q(this, var1, var2);
   }

   public static void d(ScaleRotTrans var0, RotTrans var1, boolean var2) {
      Quaternion.q(var0.rot, var1.rot);
      Vector3.e(var0.trans, var1.trans);
      if (var2) {
         var0.scale = 1.0F;
      }

   }

   public ScaleRotTrans(RotTrans var1) {
      this.rot = new Quaternion();
      this.trans = new Vector3();
      this.scale = 1.0F;
      d(this, var1, true);
   }

   public ScaleRotTrans(ScaleRotTrans var1) {
      this.rot = new Quaternion();
      this.trans = new Vector3();
      this.scale = 1.0F;
      g(this, var1);
   }

   public static void g(ScaleRotTrans var0, ScaleRotTrans var1) {
      var0.scale = var1.scale;
      Quaternion.q(var0.rot, var1.rot);
      Vector3.e(var0.trans, var1.trans);
   }

   @Bs1
   @Be2
   public ScaleRotTrans(float var1, Quaternion var2, Vector3 var3) {
      this.scale = var1;
      this.rot = new Quaternion(var2);
      this.trans = new Vector3(var3);
   }

   public static void q(ScaleRotTrans var0, RotTrans var1, float var2) {
      Quaternion.q(var0.rot, var1.rot);
      Vector3.e(var0.trans, var1.trans);
      var0.scale = var2;
   }

   public String toString() {
      return "[" + this.scale + "|" + this.rot.toString() + "|" + this.trans.toString() + "]";
   }

   public ScaleRotTrans() {
      this.scale = 1.0F;
      this.rot = new Quaternion();
      this.trans = new Vector3();
   }
}
