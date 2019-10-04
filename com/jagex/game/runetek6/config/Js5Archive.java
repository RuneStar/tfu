/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config;

public enum Js5Archive {
    CONFIG(2, "client.config"),
    SCALEFORM(3, "client.scaleform"),
    SPRITES(8, "client.sprites"),
    BINARY(10, "client.binary"),
    FONTMETRICS(13, "client.fontmetrics"),
    VORBIS(14, "client.vorbis"),
    CONFIG_OBJ(19, "client.obj.config"),
    DEFAULTS(28, "client.defaults"),
    DLLS(30),
    SHADERS(31, "client.hlsl"),
    GFX_CONFIG(37, "client.gfxconfigs"),
    MATERIALS(38, "client.materials"),
    MESHES(39, "client.meshes"),
    SKELETONS(40, "client.skeletons"),
    ANIMCLIPS(41, "client.animclips"),
    DDSTEXTURES(42, "client.dds"),
    PHYSICAL_GEOMETRY(44, "geom"),
    XMAPS(45, "xmaps"),
    XELEMENTS(46, "xelements"),
    XAREAS(47, "xareas"),
    CLIENT_LUA(48, "lua"),
    STATES(49, "states"),
    SCALEFORMDDS(50, "client.scaleform.dds");
    
    public static final Js5Archive[] VALUES;
    private static int requiredArrayLength;
    private final int archiveId;
    private final String defaultName;

    private Js5Archive(int n2, String string2) {
        this.archiveId = n2;
        this.defaultName = string2;
    }

    private Js5Archive(int n2) {
        this.archiveId = n2;
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
            for (Js5Archive js5Archive : Js5Archive.values()) {
                if (js5Archive.archiveId <= requiredArrayLength) continue;
                requiredArrayLength = js5Archive.archiveId;
            }
        }
        return ++requiredArrayLength;
    }

    static {
        requiredArrayLength = -1;
        VALUES = Js5Archive.values();
    }
}

