package com.jagex.game.runetek6.xelement;

public enum Af81 {
   PROPERTY_NAME_TABLE(253, -1),
   NAVMESH_REF_CHUNK(2, -1),
   SOURCE_PATH(5, -1),
   TERRAIN(1, -1),
   IRRADIANCE_VOLUMES_CHUNK(6, -1),
   GROUND_COVER_CHUNK(4, -1),
   SUPER_TYPE_PROPERTIES(254, -1),
   ENVSETTINGS_CHUNK(3, -1),
   UNKNOWN(Integer.MAX_VALUE, -1),
   UMBRA_SCENE_CHUNK(7, -1),
   LEGACY_CHUNK(255, -1);

   public final int v;
   public final int y;

   private Af81(int var3, int var4) {
      this.v = var3;
      this.y = var4;
   }

   public static Af81 g(int var0) {
      Af81[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Af81 var4 = var1[var3];
         if (var4.v == var0) {
            return var4;
         }
      }

      return UNKNOWN;
   }
}
