/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.event;

import com.jagex.core.constants.J204;

public enum MappedEventType implements J204
{
    ON_ENTER(0),
    ON_EXIT(1),
    ON_COLLIDE(2);
    
    private static MappedEventType[] byId;
    private final int id;

    private MappedEventType(int n2) {
        this.id = n2;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public static MappedEventType byId(int n) {
        if (n >= 0 && n < byId.length) {
            return byId[n];
        }
        return null;
    }

    static {
        MappedEventType[] arrmappedEventType = MappedEventType.values();
        int n = -1;
        for (MappedEventType mappedEventType : arrmappedEventType) {
            if (mappedEventType.id <= n) continue;
            n = mappedEventType.id;
        }
        byId = new MappedEventType[n + 1];
        for (MappedEventType mappedEventType : arrmappedEventType) {
            if (byId[mappedEventType.id] != null) {
                throw new IllegalStateException();
            }
            MappedEventType.byId[mappedEventType.id] = mappedEventType;
        }
    }
}

