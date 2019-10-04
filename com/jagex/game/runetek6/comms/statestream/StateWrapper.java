/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.State;

public class StateWrapper {
    public final byte filterGroup;
    public final State state;
    public final int timestamp;
    public final int uniqueID;

    public String toString() {
        return "StateWrapper(id=" + this.uniqueID + ";ts=" + this.timestamp + ";\"" + this.state.toString() + "\")";
    }

    public StateWrapper(State state, int n, int n2, byte by) {
        this.state = state;
        this.uniqueID = n;
        this.timestamp = n2;
        this.filterGroup = by;
    }
}

