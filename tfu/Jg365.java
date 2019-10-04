package tfu;

import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Jg365 extends AbstractCollection implements Deque {
   int d;
   Object[] g;
   int j;
   int q;

   public boolean removeLastOccurrence(Object var1) {
      throw new UnsupportedOperationException();
   }

   public void addFirst(Object var1) {
      this.d = this.d - 1 & this.g.length - 1;
      this.g[this.d] = var1;
      if (this.q == this.d) {
         z(this);
      }

      ++this.j;
   }

   public void addLast(Object var1) {
      this.g[this.q] = var1;
      this.q = this.q + 1 & this.g.length - 1;
      if (this.q == this.d) {
         z(this);
      }

      ++this.j;
   }

   public Object removeLast() {
      if (this.q == this.d) {
         throw new NoSuchElementException();
      } else {
         this.q = this.q - 1 & this.g.length - 1;
         Object var1 = this.g[this.q];
         this.g[this.q] = null;
         ++this.j;
         return var1;
      }
   }

   public Object removeFirst() {
      if (this.q == this.d) {
         throw new NoSuchElementException();
      } else {
         Object var1 = this.g[this.d];
         this.g[this.d] = null;
         this.d = this.d + 1 & this.g.length - 1;
         ++this.j;
         return var1;
      }
   }

   public boolean offerLast(Object var1) {
      this.addLast(var1);
      return true;
   }

   public void clear() {
      for(int var1 = this.d; var1 != this.q; var1 = var1 + 1 & this.g.length - 1) {
         this.g[var1] = null;
      }

      this.q = this.d;
      ++this.j;
   }

   public Object pollLast() {
      if (this.q == this.d) {
         return null;
      } else {
         this.q = this.q - 1 & this.g.length - 1;
         Object var1 = this.g[this.q];
         this.g[this.q] = null;
         ++this.j;
         return var1;
      }
   }

   public Object getFirst() {
      if (this.q == this.d) {
         throw new NoSuchElementException();
      } else {
         return this.g[this.d];
      }
   }

   public Object getLast() {
      if (this.q == this.d) {
         throw new NoSuchElementException();
      } else {
         return this.g[this.q - 1 & this.g.length - 1];
      }
   }

   public Jg365() {
      this(8);
   }

   public Object peekLast() {
      return this.q == this.d ? null : this.g[this.q - 1 & this.g.length - 1];
   }

   public Iterator iterator() {
      return new Jf518(this);
   }

   public boolean add(Object var1) {
      this.addLast(var1);
      return true;
   }

   public boolean offer(Object var1) {
      this.addLast(var1);
      return true;
   }

   public Object remove() {
      return this.removeFirst();
   }

   public Object pop() {
      return this.removeFirst();
   }

   public Object element() {
      return this.getFirst();
   }

   public Object peek() {
      return this.peekFirst();
   }

   public void push(Object var1) {
      this.addFirst(var1);
   }

   public Iterator descendingIterator() {
      return new Jq519(this);
   }

   public boolean isEmpty() {
      return this.q == this.d;
   }

   private static void z(Jg365 var0) {
      Object[] var1 = new Object[var0.g.length << 1];
      int var2 = var0.g.length - var0.d;
      int var3 = var1.length - var2;
      System.arraycopy(var0.g, 0, var1, 0, var0.q);
      System.arraycopy(var0.g, var0.d, var1, var3, var2);
      var0.g = var1;
      var0.d = var3;
   }

   public boolean offerFirst(Object var1) {
      this.addFirst(var1);
      return true;
   }

   public Object peekFirst() {
      return this.q == this.d ? null : this.g[this.d];
   }

   public Jg365(int var1) {
      int var2;
      for(var2 = 1; var2 < var1; var2 <<= 1) {
      }

      if (var2 <= 0) {
         throw new IllegalArgumentException(var1 + " is out of range");
      } else {
         this.g = new Object[var2];
         this.d = this.q = 0;
      }
   }

   public int size() {
      return this.q - this.d & this.g.length - 1;
   }

   public boolean removeFirstOccurrence(Object var1) {
      throw new UnsupportedOperationException();
   }

   public Object pollFirst() {
      if (this.q == this.d) {
         return null;
      } else {
         Object var1 = this.g[this.d];
         this.g[this.d] = null;
         this.d = this.d + 1 & this.g.length - 1;
         ++this.j;
         return var1;
      }
   }

   public Object poll() {
      return this.pollFirst();
   }
}
