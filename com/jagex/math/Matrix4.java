package com.jagex.math;

import java.util.Arrays;
import tfu.Be2;
import tfu.Bs1;

/** @deprecated */
@Deprecated
@Bs1
@Be2
public final class Matrix4 {
   public static final Matrix4 g = new Matrix4();
   public float[] f = new float[16];

   public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      int var3 = 31 * var2 + Arrays.hashCode(this.f);
      return var3;
   }

   @Bs1
   @Be2
   public Matrix4(float[] var1) {
      System.arraycopy(var1, 0, this.f, 0, 16);
   }

   public static void g(Matrix4 var0) {
      var0.f[0] = 1.0F;
      var0.f[1] = 0.0F;
      var0.f[2] = 0.0F;
      var0.f[3] = 0.0F;
      var0.f[4] = 0.0F;
      var0.f[5] = 1.0F;
      var0.f[6] = 0.0F;
      var0.f[7] = 0.0F;
      var0.f[8] = 0.0F;
      var0.f[9] = 0.0F;
      var0.f[10] = 1.0F;
      var0.f[11] = 0.0F;
      var0.f[12] = 0.0F;
      var0.f[13] = 0.0F;
      var0.f[14] = 0.0F;
      var0.f[15] = 1.0F;
   }

   public static void d(Matrix4 var0, Matrix4 var1) {
      System.arraycopy(var1.f, 0, var0.f, 0, 16);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();

      for(int var2 = 0; var2 < 4; ++var2) {
         for(int var3 = 0; var3 < 4; ++var3) {
            if (var3 > 0) {
               var1.append("\t");
            }

            var1.append(this.f[var2 * 4 + var3]);
         }

         var1.append("\n");
      }

      return var1.toString();
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof Matrix4)) {
         return false;
      } else {
         Matrix4 var2 = (Matrix4)var1;

         for(int var3 = 0; var3 < 16; ++var3) {
            if (this.f[var3] != var2.f[var3]) {
               return false;
            }
         }

         return true;
      }
   }

   public Matrix4() {
      g(this);
   }

   public Matrix4(G283 var1) {
      G283.j(var1, this.f, 0);
   }

   public Matrix4(Matrix4 var1) {
      d(this, var1);
   }
}
