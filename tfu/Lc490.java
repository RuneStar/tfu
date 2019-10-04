package tfu;

import com.jagex.maths.Vector3;

public class Lc490 {
   public static int g(Vector3 var0, Vector3 var1) {
      double var2 = (double)(var1.x - var0.x);
      double var4 = (double)(var1.y - var0.y);
      double var6 = (double)(var1.z - var0.z);
      return (int)Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
   }

   public static int j(Lp301 var0, Lp301 var1) {
      Vector3[] var2 = d(var0, var1);
      return var2 == null ? -1 : g(var2[0], var2[1]);
   }

   public static Vector3[] d(Lp301 var0, Lp301 var1) {
      return q(var0.j(), var0.e(), var1);
   }

   public static Vector3[] q(Vector3 var0, Vector3 var1, Lp301 var2) {
      Vector3 var3 = var2.j();
      Vector3 var4 = var2.e();
      boolean var7 = false;
      float var5;
      float var6;
      if (var3.x > var1.x) {
         var5 = var1.x;
         var6 = var3.x;
      } else if (var4.x < var0.x) {
         var5 = var0.x;
         var6 = var4.x;
      } else {
         if (var0.x >= var3.x && var0.x <= var4.x) {
            var5 = var6 = var0.x;
         } else if (var1.x >= var3.x && var1.x <= var4.x) {
            var5 = var6 = var1.x;
         } else if (var3.x >= var0.x && var3.x <= var1.x) {
            var5 = var6 = var3.x;
         } else {
            var5 = var6 = var4.x;
         }

         var7 = true;
      }

      boolean var10 = false;
      float var8;
      float var9;
      if (var3.y > var1.y) {
         var8 = var1.y;
         var9 = var3.y;
      } else if (var4.y < var0.y) {
         var8 = var0.y;
         var9 = var4.y;
      } else {
         if (var0.y >= var3.y && var0.y <= var4.y) {
            var8 = var9 = var0.y;
         } else if (var1.y >= var3.y && var1.y <= var4.y) {
            var8 = var9 = var1.y;
         } else if (var3.y >= var0.y && var3.y <= var1.y) {
            var8 = var9 = var3.y;
         } else {
            var8 = var9 = var4.y;
         }

         var10 = true;
      }

      boolean var13 = false;
      float var11;
      float var12;
      if (var3.z > var1.z) {
         var11 = var1.z;
         var12 = var3.z;
      } else if (var4.z < var0.z) {
         var11 = var0.z;
         var12 = var4.z;
      } else {
         if (var0.z >= var3.z && var0.z <= var4.z) {
            var11 = var12 = var0.z;
         } else if (var1.z >= var3.z && var1.z <= var4.z) {
            var11 = var12 = var1.z;
         } else if (var3.z >= var0.z && var3.z <= var1.z) {
            var11 = var12 = var3.z;
         } else {
            var11 = var12 = var4.z;
         }

         var13 = true;
      }

      return var7 && var10 && var13 ? null : new Vector3[]{Vector3.g(var5, var8, var11), Vector3.g(var6, var9, var12)};
   }
}
