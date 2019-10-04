// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

public enum Af81
{
    PROPERTY_NAME_TABLE("PROPERTY_NAME_TABLE", 7, 253, -1), 
    NAVMESH_REF_CHUNK("NAVMESH_REF_CHUNK", 1, 2, -1), 
    SOURCE_PATH("SOURCE_PATH", 4, 5, -1), 
    TERRAIN("TERRAIN", 0, 1, -1), 
    IRRADIANCE_VOLUMES_CHUNK("IRRADIANCE_VOLUMES_CHUNK", 5, 6, -1), 
    GROUND_COVER_CHUNK("GROUND_COVER_CHUNK", 3, 4, -1), 
    SUPER_TYPE_PROPERTIES("SUPER_TYPE_PROPERTIES", 8, 254, -1), 
    ENVSETTINGS_CHUNK("ENVSETTINGS_CHUNK", 2, 3, -1), 
    UNKNOWN("UNKNOWN", 10, Integer.MAX_VALUE, -1), 
    UMBRA_SCENE_CHUNK("UMBRA_SCENE_CHUNK", 6, 7, -1), 
    LEGACY_CHUNK("LEGACY_CHUNK", 9, 255, -1);
    
    public final int v;
    public final int y;
    
    private Af81(final String name, final int ordinal, final int v, final int y) {
        this.v = v;
        this.y = y;
    }
    
    public static Af81 g(final int n) {
        for (final Af81 af81 : values()) {
            if (af81.v == n) {
                return af81;
            }
        }
        return Af81.UNKNOWN;
    }
}
