package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

class SyncPacket$DeltaSection extends SyncPacket$Section {
   public final long addedTime;
   public final byte[] deltaPacket;
   public final byte filterGroup;
   public final int sourceStateID;
   public final Class stateType;
   public final int targetStateID;
   public final int timestamp;

   SyncPacket$DeltaSection(Class var1, int var2, int var3, int var4, byte var5, byte[] var6, long var7) {
      this.stateType = var1;
      this.sourceStateID = var2;
      this.targetStateID = var3;
      this.timestamp = var4;
      this.deltaPacket = var6;
      this.filterGroup = var5;
      this.addedTime = var7;
   }

   public SyncPacket$SectionType getType() {
      return SyncPacket$SectionType.DELTA;
   }

   public int getBodySize() {
      int var1 = 2 * LossyStateStream.STATE_ID_WIDTH.bytes + 1 + this.deltaPacket.length + 8;
      if (this.timestamp == -1) {
         var1 += 4;
      } else {
         var1 += 4;
         var1 += LossyStateStream.TIMESTAMP_WIDTH.bytes;
      }

      return var1;
   }

   public String toString() {
      return "DELTA: " + this.sourceStateID + " -> " + this.targetStateID + " @ " + this.timestamp;
   }

   SyncPacket$DeltaSection(ByteBuffer var1) {
      this.stateType = null;
      this.sourceStateID = LossyStateStream.STATE_ID_WIDTH.getID(var1);
      this.targetStateID = LossyStateStream.STATE_ID_WIDTH.getID(var1);
      this.filterGroup = var1.get();
      int var2 = var1.getInt();
      if (var2 < 0) {
         var2 = -var2;
         this.timestamp = -1;
      } else {
         this.timestamp = LossyStateStream.TIMESTAMP_WIDTH.getID(var1);
      }

      this.deltaPacket = new byte[var2];
      var1.get(this.deltaPacket);
      this.addedTime = var1.getLong();
   }

   public int compareTo(SyncPacket$DeltaSection var1) {
      return this.timestamp - var1.timestamp;
   }

   public String toStringForDebug() {
      StringBuilder var1 = new StringBuilder();
      if (this.stateType != null) {
         var1.append("State Type: " + this.stateType.getSimpleName() + "\n");
      }

      var1.append("SourceState ID: " + this.sourceStateID + "\n");
      var1.append("TargetState ID: " + this.targetStateID + "\n");
      var1.append("Timestamp: " + this.timestamp + "\n");
      var1.append("Delta Length: " + this.deltaPacket.length + "\n");
      return var1.toString();
   }

   public void writeBody(ByteBuffer var1) {
      LossyStateStream.STATE_ID_WIDTH.putID(this.sourceStateID, var1);
      LossyStateStream.STATE_ID_WIDTH.putID(this.targetStateID, var1);
      var1.put(this.filterGroup);
      if (this.timestamp == -1) {
         var1.putInt(-this.deltaPacket.length);
      } else {
         var1.putInt(this.deltaPacket.length);
         LossyStateStream.TIMESTAMP_WIDTH.putID(this.timestamp, var1);
      }

      var1.put(this.deltaPacket);
      var1.putLong(this.addedTime);
   }
}
