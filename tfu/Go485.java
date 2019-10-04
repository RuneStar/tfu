package tfu;

import com.jagex.core.constants.J204;

public enum Go485 implements J204 {
   SERVERFULL(7),
   NONE(-2),
   TIMEOUT(-5),
   EOF(-1),
   OK(2),
   IOERROR(-4),
   IP_BLOCKED1(9),
   INPROGRESS(-3),
   SERVERERROR(3),
   OUTOFDATE(37);

   private final int r;

   private Go485(int var3) {
      this.r = var3;
   }

   public int getId() {
      return this.r;
   }
}
