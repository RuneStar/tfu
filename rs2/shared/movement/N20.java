package rs2.shared.movement;

import tfu.Ie21;

// $FF: synthetic class
class N20 {
   // $FF: synthetic field
   static final int[] g = new int[Ie21.values().length];

   static {
      try {
         g[Ie21.BOX.ordinal()] = 1;
      } catch (NoSuchFieldError var6) {
      }

      try {
         g[Ie21.CAPSULE.ordinal()] = 2;
      } catch (NoSuchFieldError var5) {
      }

      try {
         g[Ie21.CONVEX_HULL.ordinal()] = 3;
      } catch (NoSuchFieldError var4) {
      }

      try {
         g[Ie21.CONVEX_2D_POLYGON.ordinal()] = 4;
      } catch (NoSuchFieldError var3) {
      }

      try {
         g[Ie21.GENERIC_STATIC_MESH.ordinal()] = 5;
      } catch (NoSuchFieldError var2) {
      }

      try {
         g[Ie21.SPHERE.ordinal()] = 6;
      } catch (NoSuchFieldError var1) {
      }

   }
}
