package com.jagex.core.constants;

import java.util.HashMap;
import java.util.Map;

public class E294 {
   private static Map g = new HashMap();

   public static J204 d(J204[] var0, int var1) {
      J204[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         J204 var5 = var2[var4];
         if (var1 == var5.getId()) {
            return var5;
         }
      }

      return null;
   }

   public static J204 g(Class var0, int var1) {
      Map var2 = g;
      synchronized(var2) {
         Object var3 = (Map)g.get(var0);
         if (var3 == null) {
            var3 = new HashMap();
            J204[] var4 = (J204[])var0.getEnumConstants();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               J204 var7 = var4[var6];
               ((Map)var3).put(var7.getId(), var7);
            }

            g.put(var0, var3);
         }

         return (J204)((Map)var3).get(var1);
      }
   }
}
