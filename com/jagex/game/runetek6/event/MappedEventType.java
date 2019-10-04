// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.event;

import com.jagex.core.constants.J204;

public enum MappedEventType implements J204
{
    ON_COLLIDE("ON_COLLIDE", 2, 2), 
    ON_ENTER("ON_ENTER", 0, 0), 
    ON_EXIT("ON_EXIT", 1, 1);
    
    private static MappedEventType[] byId;
    private final int id;
    
    private MappedEventType(final String name, final int ordinal, final int id) {
        this.id = id;
    }
    
    @Override
    public int getId() {
        return this.id;
    }
    
    public static MappedEventType byId(final int n) {
        if (n >= 0 && n < MappedEventType.byId.length) {
            return MappedEventType.byId[n];
        }
        return null;
    }
    
    static {
        final MappedEventType[] values = values();
        int id = -1;
        for (final MappedEventType mappedEventType : values) {
            if (mappedEventType.id > id) {
                id = mappedEventType.id;
            }
        }
        MappedEventType.byId = new MappedEventType[id + 1];
        for (final MappedEventType mappedEventType2 : values) {
            if (MappedEventType.byId[mappedEventType2.id] != null) {
                throw new IllegalStateException();
            }
            MappedEventType.byId[mappedEventType2.id] = mappedEventType2;
        }
    }
}
