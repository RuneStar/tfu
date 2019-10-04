// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

public enum Bw168
{
    STRING_PROPERTIES("STRING_PROPERTIES", 7, 12, -1), 
    NAME("NAME", 1, 2, 4), 
    MESHES("MESHES", 4, 8, -1), 
    ID("ID", 0, 1, -1), 
    OBB("OBB", 5, 10, 64), 
    SUPER_TYPE_PROPERTIES("SUPER_TYPE_PROPERTIES", 21, 255, -1), 
    SKELETON("SKELETON", 3, 7, 4), 
    ANIMATION_SETS("ANIMATION_SETS", 20, 25, -1), 
    NUMERIC_PROPERTIES("NUMERIC_PROPERTIES", 8, 13, -1), 
    BOOLEAN_PROPERTIES("BOOLEAN_PROPERTIES", 18, 23, -1), 
    ANIMATION_GRAPH("ANIMATION_GRAPH", 19, 24, -1), 
    UNKNOWN("UNKNOWN", 22, Integer.MAX_VALUE, -1), 
    EVENT_HANDLERS("EVENT_HANDLERS", 13, 18, -1), 
    INHERITS("INHERITS", 2, 3, 4), 
    VECTOR4_PROPERTIES("VECTOR4_PROPERTIES", 10, 15, -1), 
    ANIMATIONS("ANIMATIONS", 6, 11, -1), 
    RENDER_FLAGS("RENDER_FLAGS", 17, 22, 4), 
    PHYSICS_EVENT_MODE("PHYSICS_EVENT_MODE", 15, 20, 1), 
    NAMED_MESHES("NAMED_MESHES", 11, 16, -1), 
    VECTOR3_PROPERTIES("VECTOR3_PROPERTIES", 9, 14, -1), 
    EVENT_MAPPINGS("EVENT_MAPPINGS", 14, 19, -1), 
    SKELETON_MASKS("SKELETON_MASKS", 12, 17, -1), 
    PHYSICS_COLLISION_GEOMETRY("PHYSICS_COLLISION_GEOMETRY", 16, 21, 4);
    
    public final int a;
    public final int f;
    
    public static Bw168 g(final int n) {
        for (final Bw168 bw168 : values()) {
            if (bw168.a == n) {
                return bw168;
            }
        }
        return Bw168.UNKNOWN;
    }
    
    private Bw168(final String name, final int ordinal, final int a, final int f) {
        this.a = a;
        this.f = f;
    }
}
