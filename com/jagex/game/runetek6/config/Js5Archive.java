package com.jagex.game.runetek6.config;

public enum Js5Archive {
   ANIMCLIPS(41, "client.animclips"),
   BINARY(10, "client.binary"),
   CLIENT_LUA(48, "lua"),
   CONFIG(2, "client.config"),
   CONFIG_OBJ(19, "client.obj.config"),
   DDSTEXTURES(42, "client.dds"),
   DEFAULTS(28, "client.defaults"),
   DLLS(30),
   FONTMETRICS(13, "client.fontmetrics"),
   GFX_CONFIG(37, "client.gfxconfigs"),
   MATERIALS(38, "client.materials"),
   MESHES(39, "client.meshes"),
   PHYSICAL_GEOMETRY(44, "geom"),
   SCALEFORM(3, "client.scaleform"),
   SCALEFORMDDS(50, "client.scaleform.dds"),
   SHADERS(31, "client.hlsl"),
   SKELETONS(40, "client.skeletons"),
   SPRITES(8, "client.sprites"),
   STATES(49, "states"),
   VORBIS(14, "client.vorbis"),
   XAREAS(47, "xareas"),
   XELEMENTS(46, "xelements"),
   XMAPS(45, "xmaps");

   public static final Js5Archive[] VALUES = values();
   private static int requiredArrayLength = -1;
   private final int archiveId;
   private final String defaultName;

   private Js5Archive(int var3, String var4) {
      this.archiveId = var3;
      this.defaultName = var4;
   }

   private Js5Archive(int var3) {
      this.archiveId = var3;
      this.defaultName = null;
   }

   public int getArchiveId() {
      return this.archiveId;
   }

   public String getDefaultName() {
      return this.defaultName;
   }

   public static int getRequiredArrayLength() {
      if (requiredArrayLength == -1) {
         Js5Archive[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            Js5Archive var3 = var0[var2];
            if (var3.archiveId > requiredArrayLength) {
               requiredArrayLength = var3.archiveId;
            }
         }

         ++requiredArrayLength;
      }

      return requiredArrayLength;
   }
}
