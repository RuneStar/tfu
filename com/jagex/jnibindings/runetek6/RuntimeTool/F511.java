package com.jagex.jnibindings.runetek6.RuntimeTool;

public class F511 {
   private int d;
   private I512 g;

   public static void g(F511 var0) {
      var0.g = I512.UNUSED;
      ++var0.d;
   }

   public F511() {
      this.g = I512.UNUSED;
      this.d = 0;
   }

   public static void q(F511 var0) {
      var0.g = I512.ENDED;
   }

   public static boolean j(F511 var0) {
      return var0.g.compareTo(I512.STARTED) >= 0;
   }

   public static int h(F511 var0) {
      return var0.d;
   }

   public static boolean e(F511 var0) {
      return var0.g.compareTo(I512.ENDED) >= 0;
   }

   public static void d(F511 var0) {
      var0.g = I512.STARTED;
   }
}
