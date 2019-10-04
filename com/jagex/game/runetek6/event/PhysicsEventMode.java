// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.event;

import com.jagex.core.constants.J204;

public enum PhysicsEventMode implements J204
{
    COLLISION("COLLISION", 1, 1), 
    OFF("OFF", 0, 0), 
    VOLUME("VOLUME", 2, 2);
    
    private static PhysicsEventMode[] byId;
    private final int id;
    
    private PhysicsEventMode(final String name, final int ordinal, final int id) {
        this.id = id;
    }
    
    @Override
    public int getId() {
        return this.id;
    }
    
    static {
        final PhysicsEventMode[] values = values();
        int id = -1;
        for (final PhysicsEventMode physicsEventMode : values) {
            if (physicsEventMode.id > id) {
                id = physicsEventMode.id;
            }
        }
        PhysicsEventMode.byId = new PhysicsEventMode[id + 1];
        for (final PhysicsEventMode physicsEventMode2 : values) {
            if (PhysicsEventMode.byId[physicsEventMode2.id] != null) {
                throw new IllegalStateException();
            }
            PhysicsEventMode.byId[physicsEventMode2.id] = physicsEventMode2;
        }
    }
    
    public static PhysicsEventMode byId(final int n) {
        if (n >= 0 && n < PhysicsEventMode.byId.length) {
            return PhysicsEventMode.byId[n];
        }
        return null;
    }
}
