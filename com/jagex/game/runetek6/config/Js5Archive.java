// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config;

public enum Js5Archive
{
    ANIMCLIPS("ANIMCLIPS", 14, 41, "client.animclips"), 
    BINARY("BINARY", 3, 10, "client.binary"), 
    CLIENT_LUA("CLIENT_LUA", 20, 48, "lua"), 
    CONFIG("CONFIG", 0, 2, "client.config"), 
    CONFIG_OBJ("CONFIG_OBJ", 6, 19, "client.obj.config"), 
    DDSTEXTURES("DDSTEXTURES", 15, 42, "client.dds"), 
    DEFAULTS("DEFAULTS", 7, 28, "client.defaults"), 
    DLLS("DLLS", 8, 30), 
    FONTMETRICS("FONTMETRICS", 4, 13, "client.fontmetrics"), 
    GFX_CONFIG("GFX_CONFIG", 10, 37, "client.gfxconfigs"), 
    MATERIALS("MATERIALS", 11, 38, "client.materials"), 
    MESHES("MESHES", 12, 39, "client.meshes"), 
    PHYSICAL_GEOMETRY("PHYSICAL_GEOMETRY", 16, 44, "geom"), 
    SCALEFORM("SCALEFORM", 1, 3, "client.scaleform"), 
    SCALEFORMDDS("SCALEFORMDDS", 22, 50, "client.scaleform.dds"), 
    SHADERS("SHADERS", 9, 31, "client.hlsl"), 
    SKELETONS("SKELETONS", 13, 40, "client.skeletons"), 
    SPRITES("SPRITES", 2, 8, "client.sprites"), 
    STATES("STATES", 21, 49, "states"), 
    VORBIS("VORBIS", 5, 14, "client.vorbis"), 
    XAREAS("XAREAS", 19, 47, "xareas"), 
    XELEMENTS("XELEMENTS", 18, 46, "xelements"), 
    XMAPS("XMAPS", 17, 45, "xmaps");
    
    public static final Js5Archive[] VALUES;
    private static int requiredArrayLength;
    private final int archiveId;
    private final String defaultName;
    
    private Js5Archive(final String name, final int ordinal, final int archiveId, final String defaultName) {
        this.archiveId = archiveId;
        this.defaultName = defaultName;
    }
    
    private Js5Archive(final String name, final int ordinal, final int archiveId) {
        this.archiveId = archiveId;
        this.defaultName = null;
    }
    
    public int getArchiveId() {
        return this.archiveId;
    }
    
    public String getDefaultName() {
        return this.defaultName;
    }
    
    public static int getRequiredArrayLength() {
        if (Js5Archive.requiredArrayLength == -1) {
            for (final Js5Archive js5Archive : values()) {
                if (js5Archive.archiveId > Js5Archive.requiredArrayLength) {
                    Js5Archive.requiredArrayLength = js5Archive.archiveId;
                }
            }
            ++Js5Archive.requiredArrayLength;
        }
        return Js5Archive.requiredArrayLength;
    }
    
    static {
        Js5Archive.requiredArrayLength = -1;
        VALUES = values();
    }
}
