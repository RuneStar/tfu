package com.jagex.game.runetek6.comms.statestream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LossyStateStream {
   public static final byte FILTERGROUP_ALL = -1;
   static final CircularIDWidth STATE_ID_WIDTH;
   public static final CircularIDWidth TIMESTAMP_WIDTH;
   private static final Logger logger = LoggerFactory.getLogger(LossyStateStream.class);
   public final StateFactory factory;
   int highestStoredTimestamp = -1;
   public final int id;
   int lowestStoredTimestamp = -1;
   public final String name;
   StateWrapper stateBelowLowest = null;
   final List synchronizers = new LinkedList();
   final Map timestampsToStates = new HashMap();

   static {
      STATE_ID_WIDTH = CircularIDWidth.TWO_BYTES;
      TIMESTAMP_WIDTH = CircularIDWidth.TWO_BYTES;
   }

   public void finalize() {
      LossyStateStreamProfiler.streamFinalised(this.id);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Stream " + this.id + ":");
      if (this.lowestStoredTimestamp < 0) {
         var1.append(" <no states on timeline>");
      } else {
         for(int var2 = this.lowestStoredTimestamp; TIMESTAMP_WIDTH.diffIDs(this.highestStoredTimestamp, var2) >= 0; var2 = TIMESTAMP_WIDTH.sumIDs(var2, 1)) {
            StateWrapper var3 = (StateWrapper)this.timestampsToStates.get(var2);
            var1.append(" " + var2 + "[" + var3.uniqueID + "]:" + var3.state + "\n");
         }
      }

      return var1.toString();
   }

   public LossyStateStream(StateFactory var1, int var2, String var3) {
      this.factory = var1;
      this.id = var2;
      this.name = var3;
      LossyStateStreamProfiler.registerNewStream(var2, var3);
   }

   public State getState(int var1) {
      if (!this.timestampsToStates.isEmpty() && TIMESTAMP_WIDTH.diffIDs(this.lowestStoredTimestamp, var1) <= 0) {
         try {
            if (TIMESTAMP_WIDTH.diffIDs(var1, this.highestStoredTimestamp) > 0) {
               return ((StateWrapper)this.timestampsToStates.get(this.highestStoredTimestamp)).state;
            }
         } catch (NullPointerException var5) {
            System.out.println("GER-6147 bug occurred: please report this data!");
            System.out.println("highestStoredTimestamp: " + this.highestStoredTimestamp);
            System.out.println("lowestStoredTimestamp: " + this.lowestStoredTimestamp);
            System.out.println("Contents of timestampsToStates:");
            Iterator var3 = this.timestampsToStates.entrySet().iterator();

            while(var3.hasNext()) {
               Entry var4 = (Entry)var3.next();
               System.out.println(var4.getKey() + " -> " + var4.getValue());
            }

            throw var5;
         }

         return ((StateWrapper)this.timestampsToStates.get(var1)).state;
      } else {
         return this.stateBelowLowest != null ? this.stateBelowLowest.state : this.factory.createBaseState();
      }
   }

   public boolean hasExplicitState(int var1) {
      StateWrapper var2 = (StateWrapper)this.timestampsToStates.get(var1);
      if (var2 == null) {
         return false;
      } else {
         return var2.timestamp == var1;
      }
   }

   void reset() {
      this.timestampsToStates.clear();
      this.highestStoredTimestamp = this.lowestStoredTimestamp = -1;
      this.stateBelowLowest = null;
   }

   StateWrapper getKeyframeState(byte var1) {
      if (this.highestStoredTimestamp != -1) {
         int var2 = this.highestStoredTimestamp;

         while(true) {
            StateWrapper var3 = (StateWrapper)this.timestampsToStates.get(var2);
            if (var1 == -1 || var3.filterGroup == var1) {
               return var3;
            }

            if (var2 == this.lowestStoredTimestamp) {
               break;
            }

            var2 = TIMESTAMP_WIDTH.sumIDs(var2, -1);
         }
      }

      if (this.stateBelowLowest == null) {
         return null;
      } else if (var1 != -1 && this.stateBelowLowest.filterGroup != var1) {
         return null;
      } else {
         return this.stateBelowLowest;
      }
   }

   boolean putState(StateWrapper var1) {
      boolean var2;
      if (this.timestampsToStates.isEmpty()) {
         this.timestampsToStates.put(var1.timestamp, var1);
         this.lowestStoredTimestamp = this.highestStoredTimestamp = var1.timestamp;
         var2 = true;
      } else if (TIMESTAMP_WIDTH.diffIDs(this.lowestStoredTimestamp, var1.timestamp) > 0) {
         for(int var3 = var1.timestamp; TIMESTAMP_WIDTH.diffIDs(this.lowestStoredTimestamp, var3) > 0; var3 = TIMESTAMP_WIDTH.sumIDs(var3, 1)) {
            this.timestampsToStates.put(var3, var1);
         }

         this.lowestStoredTimestamp = var1.timestamp;
         var2 = true;
      } else {
         StateWrapper var6;
         if (TIMESTAMP_WIDTH.diffIDs(var1.timestamp, this.highestStoredTimestamp) > 0) {
            var6 = (StateWrapper)this.timestampsToStates.get(this.highestStoredTimestamp);

            for(int var4 = TIMESTAMP_WIDTH.sumIDs(this.highestStoredTimestamp, 1); TIMESTAMP_WIDTH.diffIDs(var1.timestamp, var4) > 0; var4 = TIMESTAMP_WIDTH.sumIDs(var4, 1)) {
               this.timestampsToStates.put(var4, var6);
            }

            this.timestampsToStates.put(var1.timestamp, var1);
            this.highestStoredTimestamp = var1.timestamp;
            var2 = true;
         } else {
            var6 = (StateWrapper)this.timestampsToStates.get(var1.timestamp);
            boolean var8 = false;
            if (var6.timestamp == var1.timestamp && STATE_ID_WIDTH.diffIDs(var6.uniqueID, var1.uniqueID) >= 0) {
               var8 = true;
            }

            if (!var8) {
               for(int var5 = var1.timestamp; TIMESTAMP_WIDTH.diffIDs(this.highestStoredTimestamp, var5) >= 0 && this.timestampsToStates.get(var5) == var6; var5 = TIMESTAMP_WIDTH.sumIDs(var5, 1)) {
                  this.timestampsToStates.put(var5, var1);
               }

               var2 = true;
            } else {
               var2 = false;
            }
         }
      }

      if (var2) {
         Iterator var7 = this.synchronizers.iterator();

         while(var7.hasNext()) {
            LossyStateStreamSynchronizer var9 = (LossyStateStreamSynchronizer)var7.next();
            var9.stateAdded(this, var1);
         }
      }

      return var2;
   }

   public void discardStates(int var1) {
      if (this.lowestStoredTimestamp >= 0) {
         if (TIMESTAMP_WIDTH.diffIDs(var1, this.lowestStoredTimestamp) > 0) {
            for(int var2 = this.lowestStoredTimestamp; TIMESTAMP_WIDTH.diffIDs(var1, var2) > 0; var2 = TIMESTAMP_WIDTH.sumIDs(var2, 1)) {
               StateWrapper var3 = (StateWrapper)this.timestampsToStates.remove(var2);
               if (var3 != null) {
                  this.stateBelowLowest = var3;
               }
            }

            if (this.timestampsToStates.isEmpty()) {
               this.lowestStoredTimestamp = this.highestStoredTimestamp = -1;
            } else {
               this.lowestStoredTimestamp = var1;
            }

         }
      }
   }
}
