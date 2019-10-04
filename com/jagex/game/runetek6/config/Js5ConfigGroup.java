package com.jagex.game.runetek6.config;

public enum Js5ConfigGroup {
   AREATYPE(18, ".area"),
   CAMPAIGN(100, ".campaign"),
   CAMPAIGN_CHECKPOINT(103, ".checkpoint"),
   CAMPAIGN_TEAM(101, ".team"),
   CATEGORYTYPE(49, ".category"),
   CHATCATTYPE(28, ".chatcat"),
   CHATPHRASETYPE(27, ".chatphrase"),
   CURSORTYPE(33, ".cursor"),
   DBROWTYPE(41, ".dbrow"),
   DBTABLETYPE(40, ".dbtable"),
   ENUMTYPE(8, ".enum", 8),
   GAMELOGEVENT(70, ".gamelogevent"),
   HITMARKTYPE(46, ".hitmark"),
   INVTYPE(5, ".inv"),
   ITEMCODETYPE(48, ".itemcode"),
   OBJTYPE(10, ".obj", 8),
   PARAMTYPE(11, ".param"),
   SPOTTYPE(13, ".spotanim", 8),
   STRUCTTYPE(26, ".struct"),
   VAR_BIT(69, ".var_bit"),
   VAR_CAMPAIGN(102, ".campaignvar"),
   VAR_CLAN(66, ".var_clan"),
   VAR_CLAN_SETTING(67, ".var_clan_setting"),
   VAR_CLIENT(62, ".var_client"),
   VAR_NPC(61, ".var_npc"),
   VAR_OBJECT(65, ".var_object"),
   VAR_PLAYER(60, ".var_player"),
   VAR_REGION(64, ".var_region"),
   VAR_WORLD(63, ".var_world");

   public final String groupName;
   private final int groupSizeInBits;
   public final int id;

   public int getGroupSize() {
      return 1 << this.groupSizeInBits;
   }

   private Js5ConfigGroup(int var3, String var4) {
      this(var3, var4, 0);
   }

   private Js5ConfigGroup(int var3, String var4, int var5) {
      this.id = var3;
      this.groupName = var4;
      this.groupSizeInBits = var5;
   }

   public int getClientFileId(int var1) {
      return var1 & (1 << this.groupSizeInBits) - 1;
   }

   public int getClientGroupId(int var1) {
      return var1 >>> this.groupSizeInBits;
   }
}
