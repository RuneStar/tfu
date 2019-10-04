package tfu;

import com.jagex.core.constants.J204;

public enum Ig436 implements J204 {
   ALPHA_TESTED(1),
   OPAQUE(0),
   ALPHA_BLENDED(2);

   private final int j;

   private Ig436(int var3) {
      this.j = var3;
   }

   public int getId() {
      return this.j;
   }
}
