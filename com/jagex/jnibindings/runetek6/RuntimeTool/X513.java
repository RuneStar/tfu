package com.jagex.jnibindings.runetek6.RuntimeTool;

import tfu.Gz143;

class X513 {
   private static final long g = Gz143.g();
   private String d = "";
   private long j = 0L;
   private long q = 0L;

   static void d(X513 var0) {
      var0.q = g(var0);
   }

   static long b(X513 var0) {
      long var1 = 0L;
      if (j(var0)) {
         var1 = var0.j - var0.q;
      } else {
         var1 = g(var0) - var0.q;
      }

      return var1;
   }

   static boolean j(X513 var0) {
      return var0.j > 0L;
   }

   static void e(X513 var0, String var1) {
      var0.d = var1;
   }

   String h() {
      return (j(this) ? "ended,  " : "in progress,  ") + this.d;
   }

   static long s(X513 var0) {
      return var0.q - g;
   }

   static long g(X513 var0) {
      return Gz143.g();
   }

   static void q(X513 var0) {
      var0.j = g(var0);
   }
}
