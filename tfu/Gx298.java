package tfu;

import java.util.Collection;
import java.util.Iterator;

public class Gx298 implements Iterable, Collection {
   private Ln265 d;
   public Ln265 g = new Ln265();

   public static void z(Gx298 var0) {
      while(var0.g.bo != var0.g) {
         Ln265.ef(var0.g.bo);
      }

   }

   public static void t(Gx298 var0, Ln265 var1) {
      if (var1.bl != null) {
         Ln265.ef(var1);
      }

      var1.bl = var0.g.bl;
      var1.bo = var0.g;
      var1.bl.bo = var1;
      var1.bo.bl = var1;
   }

   public static void m(Gx298 var0, Ln265 var1) {
      if (var1.bl != null) {
         Ln265.ef(var1);
      }

      var1.bl = var0.g;
      var1.bo = var0.g.bo;
      var1.bl.bo = var1;
      var1.bo.bl = var1;
   }

   public static void n(Ln265 var0, Ln265 var1) {
      if (var0.bl != null) {
         Ln265.ef(var0);
      }

      var0.bl = var1.bl;
      var0.bo = var1;
      var0.bl.bo = var0;
      var0.bo.bl = var0;
   }

   public static Ln265 k(Gx298 var0) {
      Ln265 var1 = var0.g.bl;
      if (var1 == var0.g) {
         return null;
      } else {
         Ln265.ef(var1);
         return var1;
      }
   }

   public static Ln265 i(Gx298 var0) {
      return o(var0, (Ln265)null);
   }

   public static Ln265 a(Gx298 var0) {
      return f(var0, (Ln265)null);
   }

   public static Ln265 o(Gx298 var0, Ln265 var1) {
      Ln265 var2;
      if (var1 == null) {
         var2 = var0.g.bo;
      } else {
         var2 = var1;
      }

      if (var2 == var0.g) {
         var0.d = null;
         return null;
      } else {
         var0.d = var2.bo;
         return var2;
      }
   }

   public static int aq(Gx298 var0) {
      int var1 = 0;

      for(Ln265 var2 = var0.g.bo; var2 != var0.g; var2 = var2.bo) {
         ++var1;
      }

      return var1;
   }

   public static boolean ai(Gx298 var0) {
      return var0.g.bo == var0.g;
   }

   public static Ln265[] af(Gx298 var0) {
      Ln265[] var1 = new Ln265[aq(var0)];
      int var2 = 0;

      for(Ln265 var3 = var0.g.bo; var3 != var0.g; var3 = var3.bo) {
         var1[var2++] = var3;
      }

      return var1;
   }

   public Iterator iterator() {
      return new Gr482(this);
   }

   public int size() {
      return aq(this);
   }

   public boolean isEmpty() {
      return ai(this);
   }

   public boolean containsAll(Collection var1) {
      throw new RuntimeException();
   }

   public Object[] toArray() {
      return af(this);
   }

   public static boolean av(Gx298 var0, Ln265 var1) {
      t(var0, var1);
      return true;
   }

   public boolean remove(Object var1) {
      throw new RuntimeException();
   }

   public boolean addAll(Collection var1) {
      throw new RuntimeException();
   }

   public boolean removeAll(Collection var1) {
      throw new RuntimeException();
   }

   public static int al(Gx298 var0, Ln265[] var1) {
      int var2 = 0;

      for(Ln265 var3 = var0.g.bo; var3 != var0.g; var3 = var3.bo) {
         var1[var2++] = var3;
      }

      return var2;
   }

   public void clear() {
      z(this);
   }

   public Gx298() {
      this.g.bo = this.g;
      this.g.bl = this.g;
   }

   public boolean contains(Object var1) {
      throw new RuntimeException();
   }

   public static Ln265 c(Gx298 var0) {
      Ln265 var1 = var0.d;
      if (var1 == var0.g) {
         var0.d = null;
         return null;
      } else {
         var0.d = var1.bo;
         return var1;
      }
   }

   public Object[] toArray(Object[] var1) {
      int var2 = 0;

      for(Ln265 var3 = this.g.bo; var3 != this.g; var3 = var3.bo) {
         var1[var2++] = var3;
      }

      return var1;
   }

   public boolean retainAll(Collection var1) {
      throw new RuntimeException();
   }

   public static Ln265 f(Gx298 var0, Ln265 var1) {
      Ln265 var2;
      if (var1 == null) {
         var2 = var0.g.bl;
      } else {
         var2 = var1;
      }

      if (var2 == var0.g) {
         var0.d = null;
         return null;
      } else {
         var0.d = var2.bl;
         return var2;
      }
   }

   public static Ln265 ag(Gx298 var0) {
      Ln265 var1 = var0.d;
      if (var1 == var0.g) {
         var0.d = null;
         return null;
      } else {
         var0.d = var1.bl;
         return var1;
      }
   }
}
