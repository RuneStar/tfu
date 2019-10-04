package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class Fh453 extends WeakReference {
   Fa452 d;
   final int g;
   Fh453 q;

   Fh453(Object var1, ReferenceQueue var2, int var3, Object var4, ReferenceQueue var5) {
      super(var1, var2);
      this.g = var3;
      this.g(var4, var5);
   }

   void g(Object var1, ReferenceQueue var2) {
      this.d = new Fa452(var1, var2, this);
   }
}
