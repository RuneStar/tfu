package com.jagex.maths;

import tfu.Gg3;

public final class Ag566 {
   private static int d;
   private static Ag566[] g = new Ag566[0];
   private static int q;
   public float[] j = new float[9];

   public Ag566(Vector3 var1, Vector3 var2, Vector3 var3) {
      this.j[0] = var1.x;
      this.j[1] = var2.x;
      this.j[2] = var3.x;
      this.j[3] = var1.y;
      this.j[4] = var2.y;
      this.j[5] = var3.y;
      this.j[6] = var1.z;
      this.j[7] = var2.z;
      this.j[8] = var3.z;
   }

   public Ag566() {
      d(this);
   }

   public Ag566(Ag566 var1) {
      System.arraycopy(var1.j, 0, this.j, 0, 9);
   }

   public Ag566(Gg3 var1) {
      this.j[0] = Gg3.bl(var1);
      this.j[1] = Gg3.bl(var1);
      this.j[2] = Gg3.bl(var1);
      this.j[3] = Gg3.bl(var1);
      this.j[4] = Gg3.bl(var1);
      this.j[5] = Gg3.bl(var1);
      this.j[6] = Gg3.bl(var1);
      this.j[7] = Gg3.bl(var1);
      this.j[8] = Gg3.bl(var1);
   }

   public static Ag566 d(Ag566 var0) {
      var0.j[0] = 1.0F;
      var0.j[1] = 0.0F;
      var0.j[2] = 0.0F;
      var0.j[3] = 0.0F;
      var0.j[4] = 1.0F;
      var0.j[5] = 0.0F;
      var0.j[6] = 0.0F;
      var0.j[7] = 0.0F;
      var0.j[8] = 1.0F;
      return var0;
   }

   public String toString() {
      return this.j[0] + "," + this.j[1] + "," + this.j[2] + "\n" + this.j[3] + "," + this.j[4] + "," + this.j[5] + "\n" + this.j[6] + "," + this.j[7] + "," + this.j[8];
   }

   public static void g(int var0) {
      d = var0;
      g = new Ag566[var0];
      q = 0;
   }
}
