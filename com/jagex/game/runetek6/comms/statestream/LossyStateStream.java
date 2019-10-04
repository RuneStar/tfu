/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamProfiler;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.game.runetek6.comms.statestream.StateWrapper;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LossyStateStream {
    public static final byte FILTERGROUP_ALL = -1;
    static final CircularIDWidth STATE_ID_WIDTH;
    public static final CircularIDWidth TIMESTAMP_WIDTH;
    private static final Logger logger;
    public final StateFactory factory;
    int highestStoredTimestamp = -1;
    public final int id;
    int lowestStoredTimestamp = -1;
    public final String name;
    StateWrapper stateBelowLowest = null;
    final List synchronizers;
    final Map timestampsToStates = new HashMap();

    static {
        logger = LoggerFactory.getLogger(LossyStateStream.class);
        STATE_ID_WIDTH = CircularIDWidth.TWO_BYTES;
        TIMESTAMP_WIDTH = CircularIDWidth.TWO_BYTES;
    }

    public void finalize() {
        LossyStateStreamProfiler.streamFinalised(this.id);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Stream " + this.id + ":");
        if (this.lowestStoredTimestamp < 0) {
            stringBuilder.append(" <no states on timeline>");
        } else {
            int n = this.lowestStoredTimestamp;
            while (TIMESTAMP_WIDTH.diffIDs(this.highestStoredTimestamp, n) >= 0) {
                StateWrapper stateWrapper = (StateWrapper)this.timestampsToStates.get(n);
                stringBuilder.append(" " + n + "[" + stateWrapper.uniqueID + "]:" + stateWrapper.state + "\n");
                n = TIMESTAMP_WIDTH.sumIDs(n, 1);
            }
        }
        return stringBuilder.toString();
    }

    public LossyStateStream(StateFactory stateFactory, int n, String string) {
        this.synchronizers = new LinkedList();
        this.factory = stateFactory;
        this.id = n;
        this.name = string;
        LossyStateStreamProfiler.registerNewStream(n, string);
    }

    public State getState(int n) {
        if (this.timestampsToStates.isEmpty() || TIMESTAMP_WIDTH.diffIDs(this.lowestStoredTimestamp, n) > 0) {
            if (this.stateBelowLowest != null) {
                return this.stateBelowLowest.state;
            }
            return this.factory.createBaseState();
        }
        try {
            if (TIMESTAMP_WIDTH.diffIDs(n, this.highestStoredTimestamp) > 0) {
                return ((StateWrapper)this.timestampsToStates.get((Object)Integer.valueOf((int)this.highestStoredTimestamp))).state;
            }
        }
        catch (NullPointerException nullPointerException) {
            System.out.println("GER-6147 bug occurred: please report this data!");
            System.out.println("highestStoredTimestamp: " + this.highestStoredTimestamp);
            System.out.println("lowestStoredTimestamp: " + this.lowestStoredTimestamp);
            System.out.println("Contents of timestampsToStates:");
            for (Map.Entry entry : this.timestampsToStates.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
            throw nullPointerException;
        }
        return ((StateWrapper)this.timestampsToStates.get((Object)Integer.valueOf((int)n))).state;
    }

    public boolean hasExplicitState(int n) {
        StateWrapper stateWrapper = (StateWrapper)this.timestampsToStates.get(n);
        if (stateWrapper == null) {
            return false;
        }
        return stateWrapper.timestamp == n;
    }

    void reset() {
        this.timestampsToStates.clear();
        this.lowestStoredTimestamp = -1;
        this.highestStoredTimestamp = -1;
        this.stateBelowLowest = null;
    }

    StateWrapper getKeyframeState(byte by) {
        if (this.highestStoredTimestamp != -1) {
            int n = this.highestStoredTimestamp;
            do {
                StateWrapper stateWrapper = (StateWrapper)this.timestampsToStates.get(n);
                if (by == -1 || stateWrapper.filterGroup == by) {
                    return stateWrapper;
                }
                if (n == this.lowestStoredTimestamp) break;
                n = TIMESTAMP_WIDTH.sumIDs(n, -1);
            } while (true);
        }
        if (this.stateBelowLowest == null) {
            return null;
        }
        if (by == -1 || this.stateBelowLowest.filterGroup == by) {
            return this.stateBelowLowest;
        }
        return null;
    }

    boolean putState(StateWrapper stateWrapper) {
        boolean bl;
        int n;
        if (this.timestampsToStates.isEmpty()) {
            this.timestampsToStates.put(stateWrapper.timestamp, stateWrapper);
            this.lowestStoredTimestamp = this.highestStoredTimestamp = stateWrapper.timestamp;
            bl = true;
        } else if (TIMESTAMP_WIDTH.diffIDs(this.lowestStoredTimestamp, stateWrapper.timestamp) > 0) {
            int n2 = stateWrapper.timestamp;
            while (TIMESTAMP_WIDTH.diffIDs(this.lowestStoredTimestamp, n2) > 0) {
                this.timestampsToStates.put(n2, stateWrapper);
                n2 = TIMESTAMP_WIDTH.sumIDs(n2, 1);
            }
            this.lowestStoredTimestamp = stateWrapper.timestamp;
            bl = true;
        } else if (TIMESTAMP_WIDTH.diffIDs(stateWrapper.timestamp, this.highestStoredTimestamp) > 0) {
            StateWrapper stateWrapper2 = (StateWrapper)this.timestampsToStates.get(this.highestStoredTimestamp);
            n = TIMESTAMP_WIDTH.sumIDs(this.highestStoredTimestamp, 1);
            while (TIMESTAMP_WIDTH.diffIDs(stateWrapper.timestamp, n) > 0) {
                this.timestampsToStates.put(n, stateWrapper2);
                n = TIMESTAMP_WIDTH.sumIDs(n, 1);
            }
            this.timestampsToStates.put(stateWrapper.timestamp, stateWrapper);
            this.highestStoredTimestamp = stateWrapper.timestamp;
            bl = true;
        } else {
            StateWrapper stateWrapper3 = (StateWrapper)this.timestampsToStates.get(stateWrapper.timestamp);
            n = 0;
            if (stateWrapper3.timestamp == stateWrapper.timestamp && STATE_ID_WIDTH.diffIDs(stateWrapper3.uniqueID, stateWrapper.uniqueID) >= 0) {
                n = 1;
            }
            if (n == 0) {
                int n3 = stateWrapper.timestamp;
                while (TIMESTAMP_WIDTH.diffIDs(this.highestStoredTimestamp, n3) >= 0 && this.timestampsToStates.get(n3) == stateWrapper3) {
                    this.timestampsToStates.put(n3, stateWrapper);
                    n3 = TIMESTAMP_WIDTH.sumIDs(n3, 1);
                }
                bl = true;
            } else {
                bl = false;
            }
        }
        if (bl) {
            for (LossyStateStreamSynchronizer lossyStateStreamSynchronizer : this.synchronizers) {
                lossyStateStreamSynchronizer.stateAdded(this, stateWrapper);
            }
        }
        return bl;
    }

    public void discardStates(int n) {
        if (this.lowestStoredTimestamp < 0) {
            return;
        }
        if (TIMESTAMP_WIDTH.diffIDs(n, this.lowestStoredTimestamp) <= 0) {
            return;
        }
        int n2 = this.lowestStoredTimestamp;
        while (TIMESTAMP_WIDTH.diffIDs(n, n2) > 0) {
            StateWrapper stateWrapper = (StateWrapper)this.timestampsToStates.remove(n2);
            if (stateWrapper != null) {
                this.stateBelowLowest = stateWrapper;
            }
            n2 = TIMESTAMP_WIDTH.sumIDs(n2, 1);
        }
        if (this.timestampsToStates.isEmpty()) {
            this.highestStoredTimestamp = -1;
            this.lowestStoredTimestamp = -1;
        } else {
            this.lowestStoredTimestamp = n;
        }
    }
}

