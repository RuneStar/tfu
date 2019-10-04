package com.jagex.math;

import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;
import tfu.Kl267;
import tfu.Kn266;

/** @deprecated */
@Deprecated
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public class Vector3 implements D99, Kn266, Kl267 {
   private static Vector3[] d = new Vector3[0];
   public static final Vector3 g = new Vector3(0.0F, 0.0F, 0.0F);
   private static int j;
   private static int q;
   public float x;
   public float y;
   public float z;

   public Vector3(Gg3 var1, int var2) {
      float var3 = (float)Math.pow(10.0D, (double)var2);
      this.x = (float)Gg3.by(var1) / var3;
      this.y = (float)Gg3.by(var1) / var3;
      this.z = (float)Gg3.by(var1) / var3;
   }

   public static Vector3 d(Vector3 var0) {
      Vector3[] var1 = d;
      synchronized(var1) {
         if (j == 0) {
            return new Vector3(var0);
         } else {
            e(d[--j], var0);
            return d[j];
         }
      }
   }

   @Bs1
   @Be2
   public Vector3(float var1, float var2, float var3) {
      this.x = var1;
      this.y = var2;
      this.z = var3;
   }

   public Vector3(Vector3 var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
   }

   public static void j(Vector3 var0, float var1, float var2, float var3) {
      var0.x = var1;
      var0.y = var2;
      var0.z = var3;
   }

   public static void e(Vector3 var0, Vector3 var1) {
      j(var0, var1.x, var1.y, var1.z);
   }

   public Vector3() {
   }

   public static Vector3 h(Vector3 var0) {
      return d(var0);
   }

   public static Vector3 g(float var0, float var1, float var2) {
      Vector3[] var3 = d;
      synchronized(var3) {
         if (j == 0) {
            return new Vector3(var0, var1, var2);
         } else {
            j(d[--j], var0, var1, var2);
            return d[j];
         }
      }
   }

   public Vector3(Gg3 var1) {
      this.x = Gg3.bl(var1);
      this.y = Gg3.bl(var1);
      this.z = Gg3.bl(var1);
   }

   public String toString() {
      return String.format("{Vector 3: %f,%f,%f}", this.x, this.y, this.z);
   }
}
