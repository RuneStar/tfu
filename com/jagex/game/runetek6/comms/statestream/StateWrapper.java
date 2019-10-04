// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

public class StateWrapper
{
    public final byte filterGroup;
    public final State state;
    public final int timestamp;
    public final int uniqueID;
    
    @Override
    public String toString() {
        return "StateWrapper(id=" + this.uniqueID + ";ts=" + this.timestamp + ";\"" + this.state.toString() + "\")";
    }
    
    public StateWrapper(final State state, final int uniqueID, final int timestamp, final byte filterGroup) {
        this.state = state;
        this.uniqueID = uniqueID;
        this.timestamp = timestamp;
        this.filterGroup = filterGroup;
    }
}
