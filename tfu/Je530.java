package tfu;

import java.util.Iterator;

class Je530 implements Iterator {
   // $FF: synthetic field
   final Jw531 g;

   public synchronized void remove() {
      this.g.g.remove();
      this.g.d.remove();
   }

   Je530(Jw531 var1) {
      this.g = var1;
   }

   public Js343 g() {
      return new Js343(this.g.g.next(), this.g.d.next());
   }

   public boolean hasNext() {
      return this.g.g.hasNext() && this.g.d.hasNext();
   }
}
