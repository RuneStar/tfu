/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.event;

import com.jagex.core.constants.J204;

public enum PhysicsEventMode implements J204
{
    OFF(0),
    COLLISION(1),
    VOLUME(2);
    
    private static PhysicsEventMode[] byId;
    private final int id;

    private PhysicsEventMode(int n2) {
        this.id = n2;
    }

    @Override
    public int getId() {
        return this.id;
    }

    static {
        PhysicsEventMode[] arrphysicsEventMode = PhysicsEventMode.values();
        int n = -1;
        for (PhysicsEventMode physicsEventMode : arrphysicsEventMode) {
            if (physicsEventMode.id <= n) continue;
            n = physicsEventMode.id;
        }
        byId = new PhysicsEventMode[n + 1];
        for (PhysicsEventMode physicsEventMode : arrphysicsEventMode) {
            if (byId[physicsEventMode.id] != null) {
                throw new IllegalStateException();
            }
            PhysicsEventMode.byId[physicsEventMode.id] = physicsEventMode;
        }
    }

    public static PhysicsEventMode byId(int n) {
        if (n >= 0 && n < byId.length) {
            return byId[n];
        }
        return null;
    }
}

