/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

public class LossyStateStreamProfiler$StoredState {
    public final Object state;
    public final String streamName;
    public final long timeAdded;
    public final int timestamp;

    public LossyStateStreamProfiler$StoredState(String string, Object object, int n) {
        this.streamName = string;
        this.state = object;
        this.timestamp = n;
        this.timeAdded = System.currentTimeMillis();
    }
}

