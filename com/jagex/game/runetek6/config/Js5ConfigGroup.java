/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config;

public enum Js5ConfigGroup {
    INVTYPE(5, ".inv"),
    ENUMTYPE(8, ".enum", 8),
    OBJTYPE(10, ".obj", 8),
    PARAMTYPE(11, ".param"),
    SPOTTYPE(13, ".spotanim", 8),
    AREATYPE(18, ".area"),
    STRUCTTYPE(26, ".struct"),
    CHATPHRASETYPE(27, ".chatphrase"),
    CHATCATTYPE(28, ".chatcat"),
    CURSORTYPE(33, ".cursor"),
    DBTABLETYPE(40, ".dbtable"),
    DBROWTYPE(41, ".dbrow"),
    HITMARKTYPE(46, ".hitmark"),
    ITEMCODETYPE(48, ".itemcode"),
    CATEGORYTYPE(49, ".category"),
    VAR_PLAYER(60, ".var_player"),
    VAR_NPC(61, ".var_npc"),
    VAR_CLIENT(62, ".var_client"),
    VAR_WORLD(63, ".var_world"),
    VAR_REGION(64, ".var_region"),
    VAR_OBJECT(65, ".var_object"),
    VAR_CLAN(66, ".var_clan"),
    VAR_CLAN_SETTING(67, ".var_clan_setting"),
    VAR_BIT(69, ".var_bit"),
    GAMELOGEVENT(70, ".gamelogevent"),
    CAMPAIGN(100, ".campaign"),
    CAMPAIGN_TEAM(101, ".team"),
    VAR_CAMPAIGN(102, ".campaignvar"),
    CAMPAIGN_CHECKPOINT(103, ".checkpoint");
    
    public final String groupName;
    private final int groupSizeInBits;
    public final int id;

    public int getGroupSize() {
        return 1 << this.groupSizeInBits;
    }

    private Js5ConfigGroup(int n2, String string2) {
        this(n2, string2, 0);
    }

    private Js5ConfigGroup(int n2, String string2, int n3) {
        this.id = n2;
        this.groupName = string2;
        this.groupSizeInBits = n3;
    }

    public int getClientFileId(int n) {
        return n & (1 << this.groupSizeInBits) - 1;
    }

    public int getClientGroupId(int n) {
        return n >>> this.groupSizeInBits;
    }
}

