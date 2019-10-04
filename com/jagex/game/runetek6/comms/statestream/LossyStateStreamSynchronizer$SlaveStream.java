package com.jagex.game.runetek6.comms.statestream;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

class LossyStateStreamSynchronizer$SlaveStream {
   public final Map acknowledgedStates = new TreeMap();
   public final LossyStateStream stream;

   public void cleanupAcknowledgedStateCache() {
      int var1 = this.acknowledgedStates.size();
      if (var1 > 5) {
         LinkedList var2 = new LinkedList();
         int var3 = var1 - 5;
         Iterator var4 = this.acknowledgedStates.keySet().iterator();

         while(var4.hasNext()) {
            Integer var5 = (Integer)var4.next();
            var2.add(var5);
            --var3;
            if (var3 == 0) {
               break;
            }
         }

         var4 = var2.iterator();

         while(var4.hasNext()) {
            int var6 = (Integer)var4.next();
            this.acknowledgedStates.remove(var6);
         }
      }

   }

   public LossyStateStreamSynchronizer$SlaveStream(LossyStateStream var1) {
      this.stream = var1;
   }
}
