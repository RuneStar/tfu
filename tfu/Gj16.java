package tfu;

public enum Gj16 {
   GATE7_CLOSE(65279),
   GATE14_CLOSE(32767),
   GATE10_CLOSE(63487),
   GATE12_CLOSE(57343),
   GATE13_CLOSE(49151),
   GATE11_CLOSE(61439),
   ALL_GATES(65532),
   GATE5_OPEN(64),
   GATE9_CLOSE(64511),
   PLAYER(1),
   GATE2_OPEN(8),
   GATE8_CLOSE(65023),
   NONE(0),
   GATE3_OPEN(16),
   GATE5_CLOSE(65471),
   GATE1_OPEN(4),
   GATE4_CLOSE(65503),
   GATE6_OPEN(128),
   GATE2_CLOSE(65527),
   GATE3_CLOSE(65519),
   GATE6_CLOSE(65407),
   GATE11_OPEN(4096),
   NPC(2),
   GATE8_OPEN(512),
   GATE4_OPEN(32),
   GATE1_CLOSE(65531),
   GATE13_OPEN(16384),
   GATE9_OPEN(1024),
   GATE7_OPEN(256),
   GATE12_OPEN(8192),
   GATE10_OPEN(2048),
   GATE14_OPEN(32768);

   public final int az;

   private Gj16(int var3) {
      this.az = var3;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer(16);
      var1.append(Integer.toBinaryString(this.az));

      while(var1.length() < 16) {
         var1.insert(0, '0');
      }

      return String.format("{ CollisionMask: %s - 0b%s }", this.name(), var1.toString());
   }

   public static void g(int var0) {
      if ((var0 & -65536) != 0) {
         throw new IllegalArgumentException("Collision masks cannot use more than 16-bits (note: two bits are reserved, so only 14 bits can be used for gate types).");
      } else if ((var0 & 1) == 0 && (var0 & 2) == 0) {
         if (var0 != NONE.az && var0 != GATE1_OPEN.az && var0 != GATE2_OPEN.az && var0 != GATE3_OPEN.az && var0 != GATE4_OPEN.az && var0 != GATE5_OPEN.az && var0 != GATE6_OPEN.az && var0 != GATE7_OPEN.az && var0 != GATE8_OPEN.az && var0 != GATE9_OPEN.az && var0 != GATE10_OPEN.az && var0 != GATE11_OPEN.az && var0 != GATE12_OPEN.az && var0 != GATE13_OPEN.az && var0 != GATE14_OPEN.az) {
            throw new IllegalArgumentException("Gate collision masks can only have a single bit field set.");
         }
      } else {
         throw new IllegalArgumentException("First two bits of collision masks are reserved for players & NPCs.");
      }
   }
}
