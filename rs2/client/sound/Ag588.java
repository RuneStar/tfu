package rs2.client.sound;

import java.util.Hashtable;

public class Ag588 {
   static final Hashtable e = new Hashtable();
   String d = "";
   Hashtable g = new Hashtable();
   String j = "";
   String q = "";

   private static String g(Ag588 var0, String var1) {
      return var0.g.containsKey(var1) ? (String)var0.g.get(var1) : null;
   }

   private static String q(Ag588 var0) {
      return !var0.q.equals("") ? var0.q : null;
   }

   public static String e(int var0, String var1) {
      return e.containsKey(var0) ? g((Ag588)e.get(var0), var1) : null;
   }

   public static String h(int var0) {
      return e.containsKey(var0) ? q((Ag588)e.get(var0)) : null;
   }

   public static void s(String var0) {
      V696 var1 = new V696();
      G593.g(var0 + ".dat", 100000L, false, var1, (Object)null);
   }

   private static String d(Ag588 var0) {
      return !var0.d.equals("") ? var0.d : null;
   }

   public static String j(int var0) {
      return e.containsKey(var0) ? d((Ag588)e.get(var0)) : null;
   }
}
