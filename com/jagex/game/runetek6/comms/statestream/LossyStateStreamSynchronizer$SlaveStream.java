/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class LossyStateStreamSynchronizer$SlaveStream {
    public final Map acknowledgedStates = new TreeMap();
    public final LossyStateStream stream;

    public void cleanupAcknowledgedStateCache() {
        int n = this.acknowledgedStates.size();
        if (n > 5) {
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            int n2 = n - 5;
            for (Integer n3 : this.acknowledgedStates.keySet()) {
                linkedList.add(n3);
                if (--n2 != 0) continue;
                break;
            }
            Iterator<Object> iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                int n4 = (Integer)iterator.next();
                this.acknowledgedStates.remove(n4);
            }
        }
    }

    public LossyStateStreamSynchronizer$SlaveStream(LossyStateStream lossyStateStream) {
        this.stream = lossyStateStream;
    }
}

