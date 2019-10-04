package tfu;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Bz650 {
   static boolean d;
   private static HashMap j;
   private static final Logger logger = LoggerFactory.getLogger(Bz650.class);
   private static Bc288[] q;

   public static void j(Bc288 var0) {
      if (q == null) {
         throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
      } else {
         if (q[var0.ordinal()] != var0) {
            if (q[var0.ordinal()] != null) {
               throw new IllegalArgumentException(var0.ordinal() + " used for both " + q[var0.ordinal()].name() + " and " + var0.name());
            }

            q[var0.ordinal()] = var0;
         }

         h(var0);
      }
   }

   public static void g(boolean var0) {
      if (q != null) {
         throw new IllegalStateException("GameEntityIdTypes.init() called twice!");
      } else {
         q = new Bc288[256];
         j = new HashMap();
         d = var0;
         logger.info(d ? "Simulating worst-case bandwidth" : "Optimising for bandwidth (worst-case simulation is off)");
      }
   }

   public static void d(Bc288... var0) {
      Bc288[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Bc288 var4 = var1[var3];
         j(var4);
      }

   }

   private static String s(Bc288 var0) {
      return var0.toString() + "(" + var0.getClass().getSimpleName() + "@" + System.identityHashCode(var0) + ")";
   }

   public static void e(Bc288 var0) {
      if (q == null) {
         throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
      } else {
         h(var0);
      }
   }

   static boolean b(Bc288 var0) {
      if (q == null) {
         throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
      } else {
         return (var0.ordinal() & 255) == var0.ordinal() && q[var0.ordinal()] == var0;
      }
   }

   public static void q(Bc288... var0) {
      Bc288[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Bc288 var4 = var1[var3];
         e(var4);
      }

   }

   static Bc288 w(String var0) {
      if (q == null) {
         throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
      } else {
         String var1 = var0.toLowerCase();
         Bc288 var2 = (Bc288)j.get(var1);
         if (var2 != null) {
            return var2;
         } else {
            throw new IllegalArgumentException("GameEntityIdType " + var0 + " is not a valid type.");
         }
      }
   }

   static Bc288 l(int var0) {
      if (q == null) {
         throw new IllegalStateException("Don't forget GameEntityIdTypes.init()!");
      } else {
         if ((var0 & 255) == var0) {
            Bc288 var1 = q[var0];
            if (var1 != null) {
               return var1;
            }
         }

         throw new IllegalArgumentException("GameEntityIdType " + var0 + " is not a valid server-generated type.");
      }
   }

   private static void h(Bc288 var0) {
      String var1 = var0.name().toLowerCase();
      if (j.get(var1) != var0) {
         if (j.get(var1) != null) {
            throw new IllegalArgumentException(var0.name() + " used for both " + s((Bc288)j.get(var1)) + " and " + s(var0));
         }

         j.put(var1, var0);
      }

   }
}
