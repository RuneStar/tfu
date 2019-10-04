// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;
import org.slf4j.LoggerFactory;
import java.util.Map;
import java.util.List;
import org.slf4j.Logger;

public class LossyStateStream
{
    public static final byte FILTERGROUP_ALL = -1;
    static final CircularIDWidth STATE_ID_WIDTH;
    public static final CircularIDWidth TIMESTAMP_WIDTH;
    private static final Logger logger;
    public final StateFactory factory;
    int highestStoredTimestamp;
    public final int id;
    int lowestStoredTimestamp;
    public final String name;
    StateWrapper stateBelowLowest;
    final List synchronizers;
    final Map timestampsToStates;
    
    static {
        logger = LoggerFactory.getLogger(LossyStateStream.class);
        STATE_ID_WIDTH = CircularIDWidth.TWO_BYTES;
        TIMESTAMP_WIDTH = CircularIDWidth.TWO_BYTES;
    }
    
    public void finalize() {
        LossyStateStreamProfiler.streamFinalised(this.id);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stream " + this.id + ":");
        if (this.lowestStoredTimestamp < 0) {
            sb.append(" <no states on timeline>");
        }
        else {
            for (int n = this.lowestStoredTimestamp; LossyStateStream.TIMESTAMP_WIDTH.diffIDs(this.highestStoredTimestamp, n) >= 0; n = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(n, 1)) {
                final StateWrapper stateWrapper = this.timestampsToStates.get(n);
                sb.append(" " + n + "[" + stateWrapper.uniqueID + "]:" + stateWrapper.state + "\n");
            }
        }
        return sb.toString();
    }
    
    public LossyStateStream(final StateFactory factory, final int id, final String name) {
        this.stateBelowLowest = null;
        this.timestampsToStates = new HashMap();
        this.lowestStoredTimestamp = -1;
        this.highestStoredTimestamp = -1;
        this.synchronizers = new LinkedList();
        this.factory = factory;
        LossyStateStreamProfiler.registerNewStream(this.id = id, this.name = name);
    }
    
    public State getState(final int i) {
        if (!this.timestampsToStates.isEmpty() && LossyStateStream.TIMESTAMP_WIDTH.diffIDs(this.lowestStoredTimestamp, i) <= 0) {
            try {
                if (LossyStateStream.TIMESTAMP_WIDTH.diffIDs(i, this.highestStoredTimestamp) > 0) {
                    return this.timestampsToStates.get(this.highestStoredTimestamp).state;
                }
            }
            catch (NullPointerException ex) {
                System.out.println("GER-6147 bug occurred: please report this data!");
                System.out.println("highestStoredTimestamp: " + this.highestStoredTimestamp);
                System.out.println("lowestStoredTimestamp: " + this.lowestStoredTimestamp);
                System.out.println("Contents of timestampsToStates:");
                for (final Map.Entry<Object, V> entry : this.timestampsToStates.entrySet()) {
                    System.out.println(entry.getKey() + " -> " + entry.getValue());
                }
                throw ex;
            }
            return this.timestampsToStates.get(i).state;
        }
        if (this.stateBelowLowest != null) {
            return this.stateBelowLowest.state;
        }
        return this.factory.createBaseState();
    }
    
    public boolean hasExplicitState(final int i) {
        final StateWrapper stateWrapper = this.timestampsToStates.get(i);
        return stateWrapper != null && stateWrapper.timestamp == i;
    }
    
    void reset() {
        this.timestampsToStates.clear();
        final int n = -1;
        this.lowestStoredTimestamp = n;
        this.highestStoredTimestamp = n;
        this.stateBelowLowest = null;
    }
    
    StateWrapper getKeyframeState(final byte b) {
        if (this.highestStoredTimestamp != -1) {
            int i = this.highestStoredTimestamp;
            while (true) {
                final StateWrapper stateWrapper = this.timestampsToStates.get(i);
                if (b == -1 || stateWrapper.filterGroup == b) {
                    return stateWrapper;
                }
                if (i == this.lowestStoredTimestamp) {
                    break;
                }
                i = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(i, -1);
            }
        }
        if (this.stateBelowLowest == null) {
            return null;
        }
        if (b == -1 || this.stateBelowLowest.filterGroup == b) {
            return this.stateBelowLowest;
        }
        return null;
    }
    
    boolean putState(final StateWrapper stateWrapper) {
        boolean b;
        if (this.timestampsToStates.isEmpty()) {
            this.timestampsToStates.put(stateWrapper.timestamp, stateWrapper);
            final int timestamp = stateWrapper.timestamp;
            this.highestStoredTimestamp = timestamp;
            this.lowestStoredTimestamp = timestamp;
            b = true;
        }
        else if (LossyStateStream.TIMESTAMP_WIDTH.diffIDs(this.lowestStoredTimestamp, stateWrapper.timestamp) > 0) {
            for (int i = stateWrapper.timestamp; LossyStateStream.TIMESTAMP_WIDTH.diffIDs(this.lowestStoredTimestamp, i) > 0; i = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(i, 1)) {
                this.timestampsToStates.put(i, stateWrapper);
            }
            this.lowestStoredTimestamp = stateWrapper.timestamp;
            b = true;
        }
        else if (LossyStateStream.TIMESTAMP_WIDTH.diffIDs(stateWrapper.timestamp, this.highestStoredTimestamp) > 0) {
            final StateWrapper stateWrapper2 = this.timestampsToStates.get(this.highestStoredTimestamp);
            for (int j = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(this.highestStoredTimestamp, 1); LossyStateStream.TIMESTAMP_WIDTH.diffIDs(stateWrapper.timestamp, j) > 0; j = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(j, 1)) {
                this.timestampsToStates.put(j, stateWrapper2);
            }
            this.timestampsToStates.put(stateWrapper.timestamp, stateWrapper);
            this.highestStoredTimestamp = stateWrapper.timestamp;
            b = true;
        }
        else {
            final StateWrapper stateWrapper3 = this.timestampsToStates.get(stateWrapper.timestamp);
            boolean b2 = false;
            if (stateWrapper3.timestamp == stateWrapper.timestamp && LossyStateStream.STATE_ID_WIDTH.diffIDs(stateWrapper3.uniqueID, stateWrapper.uniqueID) >= 0) {
                b2 = true;
            }
            if (!b2) {
                for (int n = stateWrapper.timestamp; LossyStateStream.TIMESTAMP_WIDTH.diffIDs(this.highestStoredTimestamp, n) >= 0 && this.timestampsToStates.get(n) == stateWrapper3; n = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(n, 1)) {
                    this.timestampsToStates.put(n, stateWrapper);
                }
                b = true;
            }
            else {
                b = false;
            }
        }
        if (b) {
            final Iterator<LossyStateStreamSynchronizer> iterator = (Iterator<LossyStateStreamSynchronizer>)this.synchronizers.iterator();
            while (iterator.hasNext()) {
                iterator.next().stateAdded(this, stateWrapper);
            }
        }
        return b;
    }
    
    public void discardStates(final int lowestStoredTimestamp) {
        if (this.lowestStoredTimestamp < 0) {
            return;
        }
        if (LossyStateStream.TIMESTAMP_WIDTH.diffIDs(lowestStoredTimestamp, this.lowestStoredTimestamp) <= 0) {
            return;
        }
        for (int i = this.lowestStoredTimestamp; LossyStateStream.TIMESTAMP_WIDTH.diffIDs(lowestStoredTimestamp, i) > 0; i = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(i, 1)) {
            final StateWrapper stateBelowLowest = this.timestampsToStates.remove(i);
            if (stateBelowLowest != null) {
                this.stateBelowLowest = stateBelowLowest;
            }
        }
        if (this.timestampsToStates.isEmpty()) {
            final int n = -1;
            this.highestStoredTimestamp = n;
            this.lowestStoredTimestamp = n;
        }
        else {
            this.lowestStoredTimestamp = lowestStoredTimestamp;
        }
    }
}
