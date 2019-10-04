package tfu;

import java.util.Iterator;

class Jc528 implements Iterator {
   // $FF: synthetic field
   final Jr529 g;

   public boolean hasNext() {
      return this.g.g.hasNext() && this.g.d.hasNext();
   }

   public Jk523 g() {
      return new Jk523(this.g.g.next(), this.g.d.next());
   }

   public synchronized void remove() {
      this.g.g.remove();
      this.g.d.remove();
   }

   Jc528(Jr529 var1) {
      this.g = var1;
   }
}
