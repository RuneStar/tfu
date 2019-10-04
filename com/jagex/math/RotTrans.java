package com.jagex.math;

import tfu.Be2;
import tfu.Bs1;

/** @deprecated */
@Deprecated
@Bs1
@Be2
@Bs1
@Be2
public final class RotTrans implements D99 {
   protected static final float d = 0.01F;
   public static final RotTrans g = new RotTrans();
   public Quaternion rot;
   public Vector3 trans;

   public RotTrans(RotTrans var1) {
      this.rot = new Quaternion();
      this.trans = new Vector3();
      g(this, var1);
   }

   public RotTrans() {
      this.rot = new Quaternion();
      this.trans = new Vector3();
   }

   public static void g(RotTrans var0, RotTrans var1) {
      Quaternion.q(var0.rot, var1.rot);
      Vector3.e(var0.trans, var1.trans);
   }

   public String toString() {
      return "[" + this.rot.toString() + "|" + this.trans.toString() + "]";
   }

   @Bs1
   @Be2
   public RotTrans(Quaternion var1, Vector3 var2) {
      this.rot = new Quaternion(var1);
      this.trans = new Vector3(var2);
   }
}
