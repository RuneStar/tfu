/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

public enum Bw168 {
    ID(1, -1),
    NAME(2, 4),
    INHERITS(3, 4),
    SKELETON(7, 4),
    MESHES(8, -1),
    OBB(10, 64),
    ANIMATIONS(11, -1),
    STRING_PROPERTIES(12, -1),
    NUMERIC_PROPERTIES(13, -1),
    VECTOR3_PROPERTIES(14, -1),
    VECTOR4_PROPERTIES(15, -1),
    NAMED_MESHES(16, -1),
    SKELETON_MASKS(17, -1),
    EVENT_HANDLERS(18, -1),
    EVENT_MAPPINGS(19, -1),
    PHYSICS_EVENT_MODE(20, 1),
    PHYSICS_COLLISION_GEOMETRY(21, 4),
    RENDER_FLAGS(22, 4),
    BOOLEAN_PROPERTIES(23, -1),
    ANIMATION_GRAPH(24, -1),
    ANIMATION_SETS(25, -1),
    SUPER_TYPE_PROPERTIES(255, -1),
    UNKNOWN(Integer.MAX_VALUE, -1);
    
    public final int a;
    public final int f;

    public static Bw168 g(int n) {
        for (Bw168 bw168 : Bw168.values()) {
            if (bw168.a != n) continue;
            return bw168;
        }
        return UNKNOWN;
    }

    private Bw168(int n2, int n3) {
        this.a = n2;
        this.f = n3;
    }
}

