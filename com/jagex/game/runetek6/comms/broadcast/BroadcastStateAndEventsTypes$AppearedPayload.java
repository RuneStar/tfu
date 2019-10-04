/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessagePayload;
import com.jagex.maths.ScaleRotTrans;
import tfu.Bb4;

public class BroadcastStateAndEventsTypes$AppearedPayload
extends BroadcastStateAndEventsTypes$MessagePayload {
    public ScaleRotTrans transform;

    public BroadcastStateAndEventsTypes$AppearedPayload(Bb4 bb4, String string, int n, ScaleRotTrans scaleRotTrans) {
        super(bb4, string, n);
        this.transform = scaleRotTrans;
    }
}

