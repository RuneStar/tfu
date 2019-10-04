/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

public enum Af81 {
    TERRAIN(1, -1),
    NAVMESH_REF_CHUNK(2, -1),
    ENVSETTINGS_CHUNK(3, -1),
    GROUND_COVER_CHUNK(4, -1),
    SOURCE_PATH(5, -1),
    IRRADIANCE_VOLUMES_CHUNK(6, -1),
    UMBRA_SCENE_CHUNK(7, -1),
    PROPERTY_NAME_TABLE(253, -1),
    SUPER_TYPE_PROPERTIES(254, -1),
    LEGACY_CHUNK(255, -1),
    UNKNOWN(Integer.MAX_VALUE, -1);
    
    public final int v;
    public final int y;

    private Af81(int n2, int n3) {
        this.v = n2;
        this.y = n3;
    }

    public static Af81 g(int n) {
        for (Af81 af81 : Af81.values()) {
            if (af81.v != n) continue;
            return af81;
        }
        return UNKNOWN;
    }
}

