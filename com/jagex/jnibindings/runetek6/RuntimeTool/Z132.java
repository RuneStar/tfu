package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Z132 {
   public static final String d = "PACKAGE_";
   public static final String g = "LOAD_";
   private static ConcurrentHashMap j = new ConcurrentHashMap();
   private static final Logger logger = LoggerFactory.getLogger(Z132.class);

   public static synchronized void g(String var0) {
      d(var0, "");
   }

   public static synchronized void q(String var0) {
      if (!j.containsKey(var0)) {
         logger.error("Event " + var0 + " cannot be found!");
      } else {
         X513.q((X513)j.get(var0));
      }
   }

   public static synchronized String[][] j() {
      int var0 = j.size();
      ArrayList var1 = new ArrayList(var0);
      Iterator var2 = j.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         D222 var4 = new D222((String)var3.getKey(), X513.b((X513)var3.getValue()), X513.s((X513)var3.getValue()), ((X513)var3.getValue()).h());
         var1.add(var4);
      }

      Collections.sort(var1, D222.q);
      String[][] var6 = new String[var0][4];
      int var7 = var0;

      D222 var5;
      for(Iterator var8 = var1.iterator(); var8.hasNext(); var6[var7][3] = var5.e) {
         var5 = (D222)var8.next();
         --var7;
         var6[var7][0] = var5.j;
         var6[var7][1] = String.format("%1.3f", (float)var5.h * 0.001F);
         var6[var7][2] = String.format("%1.3f", (float)var5.s * 0.001F);
      }

      return var6;
   }

   public static synchronized void d(String var0, String var1) {
      if (j.containsKey(var0)) {
         logger.error("Event " + var0 + " is started already!");
      }

      X513 var2 = new X513();
      X513.d(var2);
      X513.e(var2, var1);
      j.put(var0, var2);
   }
}
