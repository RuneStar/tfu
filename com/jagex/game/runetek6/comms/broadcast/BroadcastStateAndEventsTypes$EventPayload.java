/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$DataMessagePayload;
import tfu.Bb4;

public class BroadcastStateAndEventsTypes$EventPayload
extends BroadcastStateAndEventsTypes$DataMessagePayload {
    protected BroadcastStateAndEventsTypes$EventPayload(byte[] arrby, Bb4 bb4, String string, int n) {
        super(arrby, bb4, string, n);
    }

    public BroadcastStateAndEventsTypes$EventPayload(byte[] arrby, Bb4 bb4) {
        super(arrby, bb4);
    }

    public BroadcastStateAndEventsTypes$EventPayload() {
    }
}

