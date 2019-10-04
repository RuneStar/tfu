/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.event;

import com.jagex.game.runetek6.event.EventHandler;
import java.io.PrintStream;
import java.util.ArrayList;

public class Event
extends ArrayList {
    public void removeStaticallyConfiguredHandlers() {
        for (int i = this.size() - 1; i >= 0; --i) {
            EventHandler eventHandler = (EventHandler)this.get(i);
            assert (eventHandler != null);
            if (eventHandler != null) {
                if (!eventHandler.staticallyConfigured) continue;
                this.remove(i);
                continue;
            }
            System.err.println("XXXXX null handler found in Event<> list when removing statically configured handlers");
        }
    }

    public void trigger(Object object, Object object2) {
        for (int i = 0; i < this.size(); ++i) {
            EventHandler eventHandler = (EventHandler)this.get(i);
            if (eventHandler != null) {
                eventHandler.trigger(object, object2);
                continue;
            }
            System.err.println("XXXXX null handler found in Event<> list when triggering");
        }
    }

    @Override
    public void add(int n, EventHandler eventHandler) {
        if (eventHandler == null) {
            throw new IllegalArgumentException("XXXXX added handler mustn't be null");
        }
        super.add(n, eventHandler);
    }

    @Override
    public boolean add(EventHandler eventHandler) {
        if (eventHandler == null) {
            throw new IllegalArgumentException("XXXXX added handler mustn't be null");
        }
        return super.add(eventHandler);
    }
}

