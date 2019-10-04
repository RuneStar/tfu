package rs2.shared.movement;

import com.jagex.game.runetek6.client.GameShell3;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class M188 {
   private static int b = 0;
   static float h = 0.0F;
   private static List l = new LinkedList();
   private static final Logger logger = LoggerFactory.getLogger(M188.class);
   public static boolean q = false;
   public static boolean s = false;
   private final boolean d;
   final List e = new LinkedList();
   final List j = new LinkedList();

   public static void e() {
      ++b;
   }

   private static void b(M188 var0) {
      while(var0.j.size() > b && !var0.j.isEmpty()) {
         var0.e.add(var0.j.remove(0));
      }

   }

   public static Object j(M188 var0) {
      int var1 = var0.j.size();
      if (var1 == 0) {
         return null;
      } else if (var1 == 1) {
         return var0.j.get(0);
      } else {
         int var2 = (int)Math.floor((double)h) + 1;
         if (var2 < 0) {
            return null;
         } else {
            return var2 >= var1 - 1 ? var0.j.get(var1 - 1) : var0.j.get(var2);
         }
      }
   }

   public M188(boolean var1) {
      this.d = var1;
      l.add(new WeakReference(this));
   }

   public static void h(float var0) {
      float var1 = 1.0F / GameShell3.getPhysicsSpeed();
      float var2 = var0 / var1;
      h += var2;
      int var3 = (int)h;
      b -= var3;
      h -= (float)var3;
      ListIterator var4 = l.listIterator();

      while(var4.hasNext()) {
         WeakReference var5 = (WeakReference)var4.next();
         M188 var6 = (M188)var5.get();
         if (var6 == null) {
            var4.remove();
         } else {
            b(var6);
         }
      }

   }

   public static void d(M188 var0, Object var1) {
      var0.j.add(var1);
      if (var1 instanceof U186) {
         ((U186)var1).z = System.nanoTime();
      }

   }

   public static float l(M188 var0) {
      int var1 = var0.j.size();
      if (h >= (float)(var1 - 1)) {
         if (var0.d) {
            q = true;
         }

         return h + 2.0F - (float)var1;
      } else {
         if (var0.d) {
            q = false;
         }

         return h;
      }
   }

   private static void r(M188 var0) {
      while(!var0.j.isEmpty()) {
         var0.e.add(var0.j.remove(0));
      }

   }

   public static float s() {
      return (float)(b - 1) - h;
   }

   public static Object q(M188 var0) {
      int var1 = var0.j.size();
      if (var1 == 0) {
         return null;
      } else if (var1 == 1) {
         return var0.j.get(0);
      } else {
         int var2 = (int)Math.floor((double)h);
         if (var2 < 0) {
            return null;
         } else {
            return var2 >= var1 - 1 ? var0.j.get(var1 - 2) : var0.j.get(var2);
         }
      }
   }

   public static void w() {
      ListIterator var0 = l.listIterator();

      while(var0.hasNext()) {
         WeakReference var1 = (WeakReference)var0.next();
         M188 var2 = (M188)var1.get();
         if (var2 == null) {
            var0.remove();
         } else {
            r(var2);
         }
      }

      h = 0.0F;
      b = 0;
   }

   public static Object g(M188 var0) {
      return var0.e.isEmpty() ? null : var0.e.remove(0);
   }
}
