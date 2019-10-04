package com.jagex.maths;

import tfu.Lp301;

public final class E41 implements Lp301 {
   public final float d;
   public final float e;
   public final float g;
   public final float h;
   public final float j;
   public final float q;

   public Vector3 j() {
      return Vector3.g(this.g, this.d, this.q);
   }

   public Vector3 e() {
      return Vector3.g(this.j, this.e, this.h);
   }

   public E41(float var1, float var2, float var3, float var4, float var5, float var6) {
      this.g = var1;
      this.d = var2;
      this.q = var3;
      this.j = var4;
      this.e = var5;
      this.h = var6;
   }

   public String toString() {
      return "[Aabb: (" + this.g + "," + this.d + "," + this.q + ")->(" + this.j + "," + this.e + "," + this.h + ")]";
   }
}
