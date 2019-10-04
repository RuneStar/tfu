package tfu;

import com.jagex.core.constants.J204;

public enum Fy467 implements J204 {
   PREBLEND_NORMAL(1),
   PREBLEND_SUBTRACT(4),
   PREBLEND_MODULATE(0),
   PREBLEND_ADD(3),
   PREBLEND_FOGGED(2);

   private final int h;

   public int getId() {
      return this.h;
   }

   private Fy467(int var3) {
      this.h = var3;
   }
}
