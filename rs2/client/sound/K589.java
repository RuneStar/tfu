package rs2.client.sound;

import fmod.Z256;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class K589 {
   protected static X675 b = null;
   protected static boolean d = false;
   static String e = null;
   static Z256 g;
   static String h = null;
   protected static ArrayList j = new ArrayList();
   static long l = 0L;
   protected static LinkedList q = new LinkedList();
   protected static X675 s = null;
   static long w = 0L;

   public static void j() {
      Iterator var0 = q.iterator();

      while(var0.hasNext()) {
         X675 var1 = (X675)var0.next();
         X675.r(var1);
      }

   }

   protected static X675 e(String var0) {
      Iterator var1 = q.iterator();

      X675 var2;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         var2 = (X675)var1.next();
      } while(!var2.d.equals(var0));

      return var2;
   }

   public static void s(String var0) {
      if (var0 != null && !var0.equals("")) {
         Iterator var1 = q.iterator();

         while(var1.hasNext()) {
            X675 var2 = (X675)var1.next();
            X675.l(var2, var0);
         }
      }

   }

   public static void b() {
      if (s != null) {
         X675.q(s);
      }

      if (b != null) {
         X675.h(b);
      }

      b = null;
      s = null;
   }

   static long g() {
      return System.currentTimeMillis();
   }

   public static void q() {
      if (d) {
         if (System.currentTimeMillis() - w > 1000L) {
            w = System.currentTimeMillis() - 1L;
         }

         while(w < System.currentTimeMillis()) {
            w += 33L;
            j();
         }
      }

   }

   public static void d(String var0) {
      E673 var1 = new E673();
      d = false;
      G593.g(var0 + ".dat", 100000L, false, var1, (Object)null);
   }

   public static void h(String var0, String var1) {
      if (!d) {
         e = var0;
         h = var1;
      } else {
         X675 var2 = e(var0);
         if (var2 != null) {
            X675.y(var2);
            if (var1 != null && !var1.equals("")) {
               X675.l(var2, var1);
            } else {
               X675.l(var2, "GARBAGEMOOD");
            }
         }

      }
   }
}
