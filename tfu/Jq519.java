package tfu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Jq519 implements Iterator {
   private int d;
   private int g;
   // $FF: synthetic field
   final Jg365 q;

   Jq519(Jg365 var1) {
      this.q = var1;
      this.g = this.q.j;
      this.d = this.q.q;
   }

   public boolean hasNext() {
      if (this.q.j != this.g) {
         throw new ConcurrentModificationException();
      } else {
         return this.d != this.q.d;
      }
   }

   public Object next() {
      if (this.q.j != this.g) {
         throw new ConcurrentModificationException();
      } else if (this.d == this.q.d) {
         throw new NoSuchElementException();
      } else {
         this.d = this.d - 1 & this.q.g.length - 1;
         return this.q.g[this.d];
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
