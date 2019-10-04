package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class Bi663 extends WeakReference {
   Ao128 d;
   final int g;

   Bi663(Bb4 var1, ReferenceQueue var2) {
      super(var1, var2);
      this.g = var1.d;
   }
}
