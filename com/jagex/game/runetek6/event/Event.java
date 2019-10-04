// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.event;

import java.util.ArrayList;

public class Event extends ArrayList
{
    public void removeStaticallyConfiguredHandlers() {
        for (int i = this.size() - 1; i >= 0; --i) {
            final EventHandler eventHandler = this.get(i);
            assert eventHandler != null;
            if (eventHandler != null) {
                if (eventHandler.staticallyConfigured) {
                    this.remove(i);
                }
            }
            else {
                System.err.println("XXXXX null handler found in Event<> list when removing statically configured handlers");
            }
        }
    }
    
    public void trigger(final Object o, final Object o2) {
        for (int i = 0; i < this.size(); ++i) {
            final EventHandler eventHandler = this.get(i);
            if (eventHandler != null) {
                eventHandler.trigger(o, o2);
            }
            else {
                System.err.println("XXXXX null handler found in Event<> list when triggering");
            }
        }
    }
    
    public void add(final int index, final EventHandler element) {
        if (element == null) {
            throw new IllegalArgumentException("XXXXX added handler mustn't be null");
        }
        super.add(index, element);
    }
    
    public boolean add(final EventHandler e) {
        if (e == null) {
            throw new IllegalArgumentException("XXXXX added handler mustn't be null");
        }
        return super.add(e);
    }
}
