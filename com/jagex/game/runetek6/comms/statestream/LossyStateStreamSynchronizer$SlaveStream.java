// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.util.TreeMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class LossyStateStreamSynchronizer$SlaveStream
{
    public final Map acknowledgedStates;
    public final LossyStateStream stream;
    
    public void cleanupAcknowledgedStateCache() {
        final int size = this.acknowledgedStates.size();
        if (size > 5) {
            final LinkedList<Integer> list = new LinkedList<Integer>();
            int n = size - 5;
            final Iterator<Integer> iterator = this.acknowledgedStates.keySet().iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next());
                if (--n == 0) {
                    break;
                }
            }
            final Iterator<Object> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                this.acknowledgedStates.remove(iterator2.next());
            }
        }
    }
    
    public LossyStateStreamSynchronizer$SlaveStream(final LossyStateStream stream) {
        this.acknowledgedStates = new TreeMap();
        this.stream = stream;
    }
}
