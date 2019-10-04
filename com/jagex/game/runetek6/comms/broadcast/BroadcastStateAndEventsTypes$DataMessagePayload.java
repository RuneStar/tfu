/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessagePayload;
import tfu.Bb4;

public class BroadcastStateAndEventsTypes$DataMessagePayload
extends BroadcastStateAndEventsTypes$MessagePayload {
    public byte[] wire_data;

    public BroadcastStateAndEventsTypes$DataMessagePayload() {
    }

    public BroadcastStateAndEventsTypes$DataMessagePayload(byte[] arrby, Bb4 bb4) {
        super(bb4);
        this.wire_data = arrby;
    }

    public BroadcastStateAndEventsTypes$DataMessagePayload(byte[] arrby, Bb4 bb4, String string, int n) {
        super(bb4, string, n);
        this.wire_data = arrby;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[brd=" + this.broadcasterID + "/wra=" + this.wranglerID + "/area=" + this.areaID + "/data=" + StringTools.x(this.wire_data) + "]@" + Integer.toHexString(this.hashCode());
    }
}

