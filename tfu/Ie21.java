package tfu;

public enum Ie21 {
   BOX(2),
   CONVEX_HULL(5),
   SPHERE(1),
   GENERIC_STATIC_MESH(6),
   CAPSULE(4),
   CONVEX_2D_POLYGON(3),
   GENERIC_STATIC_MESH_INTERNAL(7);

   public final int b;

   private Ie21(int var3) {
      this.b = var3;
   }

   public static Ie21 g(int var0) {
      Ie21[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Ie21 var4 = var1[var3];
         if (var4.b == var0) {
            return var4;
         }
      }

      return null;
   }
}
