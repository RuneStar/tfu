package tfu;

import java.lang.ref.SoftReference;

class Ew569 extends Fv466 {
   private SoftReference g;

   Ew569(Object var1, int var2) {
      super(var2);
      this.g = new SoftReference(var1);
   }

   boolean d() {
      return true;
   }

   Object g() {
      return this.g.get();
   }
}
