package tfu;

import java.util.Iterator;

final class Jr529 implements Iterable {
   // $FF: synthetic field
   final Iterator d;
   // $FF: synthetic field
   final Iterator g;

   public Iterator iterator() {
      return new Jc528(this);
   }

   Jr529(Iterator var1, Iterator var2) {
      this.d = var2;
      this.g = var1;
   }
}
