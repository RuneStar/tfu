// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.event;

public abstract class EventHandler
{
    public boolean staticallyConfigured;
    
    public abstract void trigger(final Object p0, final Object p1);
    
    public EventHandler() {
        this.staticallyConfigured = false;
    }
}
