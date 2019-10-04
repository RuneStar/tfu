package tfu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Jf518 implements Iterator {
   private int d;
   private int g;
   // $FF: synthetic field
   final Jg365 q;

   Jf518(Jg365 var1) {
      this.q = var1;
      this.g = this.q.j;
      this.d = this.q.d;
   }

   public boolean hasNext() {
      if (this.q.j != this.g) {
         throw new ConcurrentModificationException();
      } else {
         return this.d != this.q.q;
      }
   }

   public Object next() {
      if (this.q.j != this.g) {
         throw new ConcurrentModificationException();
      } else if (this.d == this.q.q) {
         throw new NoSuchElementException();
      } else {
         Object var1 = this.q.g[this.d];
         this.d = this.d + 1 & this.q.g.length - 1;
         return var1;
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
