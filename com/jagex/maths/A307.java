package com.jagex.maths;

final class A307 {
   private float d;
   private final Vector3[] g = new Vector3[4];
   private P308 j;
   private float[] q;

   static void d(A307 var0, int var1, Vector3 var2) {
      var0.g[var1] = var2;
      g(var0);
   }

   private static void g(A307 var0) {
      var0.d = -1.0F;
      var0.q = null;
      var0.j = null;
   }

   A307() {
      g(this);
   }

   static Vector3 q(A307 var0, int var1) {
      return var0.g[var1];
   }
}
