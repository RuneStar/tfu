package com.jagex.game.runetek6.xelement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import tfu.Gg3;

public class Q79 {
   private Map d;
   private Vector g;

   public static void j(Q79 var0, Gg3 var1) {
      Gg3.i(var1, var0.g.size());
      Iterator var2 = var0.g.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         Gg3.ao(var1, var3);
      }

   }

   public Q79(int var1) {
      this.g = new Vector(var1);
      this.d = new HashMap(var1);
   }

   private Q79(List var1) {
      this(var1.size());
      int var2 = var1.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = (String)var1.get(var3);
         this.d.put(var4, var3);
         this.g.add(var4);
      }

   }

   public static Q79 e(Gg3 var0) {
      Vector var1 = new Vector();
      int var2 = Gg3.au(var0);

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = var0.bp();
         var1.add(var4);
      }

      return new Q79(var1);
   }

   public static int d(Q79 var0, String var1) {
      Integer var2 = (Integer)var0.d.get(var1);
      if (var2 == null) {
         var2 = var0.g.size();
         var0.d.put(var1, var2);
         var0.g.add(var1);
      }

      return var2;
   }

   public static String q(Q79 var0, int var1) {
      return (String)var0.g.get(var1);
   }

   public Q79() {
      this(4);
   }

   public static void g(Q79 var0, String var1) {
      if (!var0.d.containsKey(var1)) {
         var0.d.put(var1, var0.g.size());
         var0.g.add(var1);
      }

   }
}
