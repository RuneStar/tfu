package tfu;

import java.util.Iterator;

final class Jw531 implements Iterable {
   // $FF: synthetic field
   final Iterator d;
   // $FF: synthetic field
   final Iterator g;

   Jw531(Iterator var1, Iterator var2) {
      this.d = var2;
      this.g = var1;
   }

   public Iterator iterator() {
      return new Je530(this);
   }
}
