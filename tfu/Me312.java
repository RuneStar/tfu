package tfu;

import java.util.AbstractSet;
import java.util.IdentityHashMap;
import java.util.Iterator;

public class Me312 extends AbstractSet {
   private static final Object g = new Object();
   private IdentityHashMap d = new IdentityHashMap();

   public Iterator iterator() {
      return this.d.keySet().iterator();
   }

   public int size() {
      return this.d.size();
   }

   public boolean isEmpty() {
      return this.d.isEmpty();
   }

   public boolean contains(Object var1) {
      return this.d.containsKey(var1);
   }

   public boolean remove(Object var1) {
      return this.d.remove(var1) != null;
   }

   public void clear() {
      this.d.clear();
   }

   public boolean add(Object var1) {
      return this.d.put(var1, g) == null;
   }
}
