package tfu;

import com.jagex.js5.js5;

public class W667 {
   private static Ca649 a;
   private static final int b = 1;
   static js5 d;
   private static Cd585 e;
   static X687 f = null;
   static js5 g;
   private static final boolean h = false;
   private static M688 i;
   private static M688 j;
   private static X687 k;
   private static final int l = 2;
   private static long m;
   private static boolean n;
   private static P689 o;
   private static int p;
   static js5 q;
   private static int r = 0;
   private static final int s = 0;
   private static int[] t;
   private static int u;
   private static js5 v;
   private static final int w = 3;
   private static int x;
   private static int y;
   private static int z;

   static void q() {
      r = 0;
      o = null;
      a = null;
      v = null;
      i = null;
   }

   public static boolean d() {
      try {
         if (r == 2) {
            if (o == null) {
               o = P689.g(v, y, p);
               if (o == null) {
                  return false;
               }
            }

            if (a == null) {
               a = new Ca649(q, d);
            }

            M688 var0 = j;
            if (i != null) {
               var0 = i;
            }

            if (M688.r(var0, o, g, a, 22050)) {
               j = var0;
               M688.v(j);
               int var1;
               if (z > 0) {
                  r = 3;
                  M688.h(j, z > x ? x : z);

                  for(var1 = 0; var1 < t.length; ++var1) {
                     M688.s(j, var1, t[var1]);
                     t[var1] = 255;
                  }
               } else {
                  r = 0;
                  M688.h(j, x);

                  for(var1 = 0; var1 < t.length; ++var1) {
                     M688.s(j, var1, t[var1]);
                     t[var1] = 255;
                  }
               }

               if (i == null) {
                  if (m > 0L) {
                     M688.t(j, o, n, true, m);
                  } else {
                     M688.u(j, o, n);
                  }

                  if (k != null) {
                     k.g();
                  }
               }

               if (e != null) {
                  Cd585.g(e, j);
               }

               o = null;
               a = null;
               v = null;
               m = 0L;
               i = null;
               k = null;
               return true;
            }
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         M688.m(j);
         q();
      }

      return false;
   }

   public static void g(int var0) {
      r = 1;
      v = null;
      y = -1;
      p = -1;
      i = null;
      x = 0;
      n = false;
      u = var0;
      k = null;
   }
}
