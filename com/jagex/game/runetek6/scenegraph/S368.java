package com.jagex.game.runetek6.scenegraph;

import com.jagex.game.runetek6.gameentity.Component;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

class S368 implements Collection {
   // $FF: synthetic field
   final Scene d;
   // $FF: synthetic field
   final Component[] g;

   public Iterator iterator() {
      return new B478(this);
   }

   public int size() {
      return this.g.length;
   }

   public boolean isEmpty() {
      return this.g.length == 0;
   }

   public boolean addAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public boolean removeAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public boolean containsAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public Object[] toArray(Object[] var1) {
      if (var1.length < this.g.length) {
         var1 = (Object[])((Object[])Array.newInstance(var1.getClass().getComponentType(), this.g.length));
      }

      System.arraycopy(this.g, 0, var1, 0, this.g.length);
      if (var1.length > this.g.length) {
         var1[this.g.length] = null;
      }

      return var1;
   }

   public boolean add(Object var1) {
      throw new UnsupportedOperationException();
   }

   S368(Scene var1, Component[] var2) {
      this.g = var2;
      this.d = var1;
   }

   public boolean retainAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public boolean remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public boolean contains(Object var1) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Object[] toArray() {
      return (Object[])this.g.clone();
   }
}
