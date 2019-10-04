package tfu;

import java.util.Iterator;

public class Hn359 implements Iterable {
   private Kp349 d;
   public Kp349 g = new Kp349();

   public Hn359() {
      this.g.x = this.g;
      this.g.u = this.g;
   }

   public static void d(Hn359 var0) {
      while(var0.g.x != var0.g) {
         Kp349.t(var0.g.x);
      }

   }

   public static void q(Hn359 var0, Kp349 var1) {
      if (var1.u != null) {
         Kp349.t(var1);
      }

      var1.u = var0.g.u;
      var1.x = var0.g;
      var1.u.x = var1;
      var1.x.u = var1;
   }

   public static Kp349 e(Hn359 var0) {
      Kp349 var1 = var0.g.x;
      if (var1 == var0.g) {
         return null;
      } else {
         Kp349.t(var1);
         return var1;
      }
   }

   public static Kp349 s(Hn359 var0, Kp349 var1) {
      Kp349 var2;
      if (var1 == null) {
         var2 = var0.g.x;
      } else {
         var2 = var1;
      }

      if (var2 == var0.g) {
         var0.d = null;
         return null;
      } else {
         var0.d = var2.x;
         return var2;
      }
   }

   public static Kp349 b(Hn359 var0) {
      Kp349 var1 = var0.d;
      if (var1 == var0.g) {
         var0.d = null;
         return null;
      } else {
         var0.d = var1.x;
         return var1;
      }
   }

   public static int l(Hn359 var0) {
      int var1 = 0;

      for(Kp349 var2 = var0.g.x; var2 != var0.g; var2 = var2.x) {
         ++var1;
      }

      return var1;
   }

   public Iterator iterator() {
      return new Hr428(this);
   }

   public static Kp349 h(Hn359 var0) {
      return s(var0, (Kp349)null);
   }

   public static void j(Kp349 var0, Kp349 var1) {
      if (var0.u != null) {
         Kp349.t(var0);
      }

      var0.u = var1;
      var0.x = var1.x;
      var0.u.x = var0;
      var0.x.u = var0;
   }
}
