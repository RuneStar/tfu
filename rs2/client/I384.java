package rs2.client;

import com.jagex.core.constants.J204;

public enum I384 implements J204 {
   _1024X768(1),
   ANY(0),
   _800X600(2);

   private final int j;

   private I384(int var3) {
      this.j = var3;
   }

   public int getId() {
      return this.j;
   }
}
