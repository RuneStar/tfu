// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config;

public enum Js5ConfigGroup
{
    AREATYPE("AREATYPE", 5, 18, ".area"), 
    CAMPAIGN("CAMPAIGN", 25, 100, ".campaign"), 
    CAMPAIGN_CHECKPOINT("CAMPAIGN_CHECKPOINT", 28, 103, ".checkpoint"), 
    CAMPAIGN_TEAM("CAMPAIGN_TEAM", 26, 101, ".team"), 
    CATEGORYTYPE("CATEGORYTYPE", 14, 49, ".category"), 
    CHATCATTYPE("CHATCATTYPE", 8, 28, ".chatcat"), 
    CHATPHRASETYPE("CHATPHRASETYPE", 7, 27, ".chatphrase"), 
    CURSORTYPE("CURSORTYPE", 9, 33, ".cursor"), 
    DBROWTYPE("DBROWTYPE", 11, 41, ".dbrow"), 
    DBTABLETYPE("DBTABLETYPE", 10, 40, ".dbtable"), 
    ENUMTYPE("ENUMTYPE", 1, 8, ".enum", 8), 
    GAMELOGEVENT("GAMELOGEVENT", 24, 70, ".gamelogevent"), 
    HITMARKTYPE("HITMARKTYPE", 12, 46, ".hitmark"), 
    INVTYPE("INVTYPE", 0, 5, ".inv"), 
    ITEMCODETYPE("ITEMCODETYPE", 13, 48, ".itemcode"), 
    OBJTYPE("OBJTYPE", 2, 10, ".obj", 8), 
    PARAMTYPE("PARAMTYPE", 3, 11, ".param"), 
    SPOTTYPE("SPOTTYPE", 4, 13, ".spotanim", 8), 
    STRUCTTYPE("STRUCTTYPE", 6, 26, ".struct"), 
    VAR_BIT("VAR_BIT", 23, 69, ".var_bit"), 
    VAR_CAMPAIGN("VAR_CAMPAIGN", 27, 102, ".campaignvar"), 
    VAR_CLAN("VAR_CLAN", 21, 66, ".var_clan"), 
    VAR_CLAN_SETTING("VAR_CLAN_SETTING", 22, 67, ".var_clan_setting"), 
    VAR_CLIENT("VAR_CLIENT", 17, 62, ".var_client"), 
    VAR_NPC("VAR_NPC", 16, 61, ".var_npc"), 
    VAR_OBJECT("VAR_OBJECT", 20, 65, ".var_object"), 
    VAR_PLAYER("VAR_PLAYER", 15, 60, ".var_player"), 
    VAR_REGION("VAR_REGION", 19, 64, ".var_region"), 
    VAR_WORLD("VAR_WORLD", 18, 63, ".var_world");
    
    public final String groupName;
    private final int groupSizeInBits;
    public final int id;
    
    public int getGroupSize() {
        return 1 << this.groupSizeInBits;
    }
    
    private Js5ConfigGroup(final String s, final int n, final int n2, final String s2) {
        this(s, n, n2, s2, 0);
    }
    
    private Js5ConfigGroup(final String name, final int ordinal, final int id, final String groupName, final int groupSizeInBits) {
        this.id = id;
        this.groupName = groupName;
        this.groupSizeInBits = groupSizeInBits;
    }
    
    public int getClientFileId(final int n) {
        return n & (1 << this.groupSizeInBits) - 1;
    }
    
    public int getClientGroupId(final int n) {
        return n >>> this.groupSizeInBits;
    }
}
