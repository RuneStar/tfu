/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import tfu.Bb4;

public class BroadcastStateAndEventsTypes$MessagePayload {
    public int areaID;
    public Bb4 broadcasterID;
    public String wranglerID;

    protected BroadcastStateAndEventsTypes$MessagePayload() {
    }

    public BroadcastStateAndEventsTypes$MessagePayload(Bb4 bb4, String string, int n) {
        this.broadcasterID = bb4;
        this.wranglerID = string;
        this.areaID = n;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "[brd=" + this.broadcasterID + "/trk=" + this.wranglerID + "/area=" + this.areaID + "]@" + Integer.toHexString(this.hashCode());
    }

    public BroadcastStateAndEventsTypes$MessagePayload(Bb4 bb4) {
        this.broadcasterID = bb4;
        this.wranglerID = null;
        this.areaID = -1;
    }
}

