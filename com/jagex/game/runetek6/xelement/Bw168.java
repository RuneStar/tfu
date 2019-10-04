package com.jagex.game.runetek6.xelement;

public enum Bw168 {
   STRING_PROPERTIES(12, -1),
   NAME(2, 4),
   MESHES(8, -1),
   ID(1, -1),
   OBB(10, 64),
   SUPER_TYPE_PROPERTIES(255, -1),
   SKELETON(7, 4),
   ANIMATION_SETS(25, -1),
   NUMERIC_PROPERTIES(13, -1),
   BOOLEAN_PROPERTIES(23, -1),
   ANIMATION_GRAPH(24, -1),
   UNKNOWN(Integer.MAX_VALUE, -1),
   EVENT_HANDLERS(18, -1),
   INHERITS(3, 4),
   VECTOR4_PROPERTIES(15, -1),
   ANIMATIONS(11, -1),
   RENDER_FLAGS(22, 4),
   PHYSICS_EVENT_MODE(20, 1),
   NAMED_MESHES(16, -1),
   VECTOR3_PROPERTIES(14, -1),
   EVENT_MAPPINGS(19, -1),
   SKELETON_MASKS(17, -1),
   PHYSICS_COLLISION_GEOMETRY(21, 4);

   public final int a;
   public final int f;

   public static Bw168 g(int var0) {
      Bw168[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Bw168 var4 = var1[var3];
         if (var4.a == var0) {
            return var4;
         }
      }

      return UNKNOWN;
   }

   private Bw168(int var3, int var4) {
      this.a = var3;
      this.f = var4;
   }
}
