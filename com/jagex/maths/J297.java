package com.jagex.maths;

import tfu.Ln265;

public class J297 extends Ln265 implements Comparable {
   public float d;
   public float g;
   public double q;

   public J297(J297 var1) {
      this.g = var1.g;
      this.d = var1.d;
      this.q = var1.q;
   }

   public String toString() {
      return this.g + "," + this.d;
   }

   public static int g(J297 var0, J297 var1) {
      return var0.q < var1.q ? -1 : 1;
   }

   public J297(float var1, float var2) {
      this.g = var1;
      this.d = var2;
   }
}
