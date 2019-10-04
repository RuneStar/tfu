package fmod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Z256 {
   private static final Logger logger = LoggerFactory.getLogger(Z256.class);
   long d;

   public J251 d(int var1, boolean var2) {
      return new J251(fmod.EventProject_getGroupByIndex(this.d, var1, var2));
   }

   public W242 j() {
      W242 var1 = new W242();
      if (this.d == 0L) {
         return null;
      } else {
         String var2 = fmod.EventProject_getInfo(this.d);
         R257[] var3 = fmod.j(var2);
         R257[] var4 = var3;
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            R257 var7 = var4[var6];
            if (var7.g.equals("index")) {
               var1.g = Integer.parseInt((String)var7.d);
            }

            if (var7.g.equals("name")) {
               var1.d = (String)var7.d;
            }

            if (var7.g.equals("numevents")) {
               var1.q = Integer.parseInt((String)var7.d);
            }

            if (var7.g.equals("maxwavebanks")) {
               var1.e = Integer.parseInt((String)var7.d);
            }

            if (var7.g.equals("numinstances")) {
               var1.j = Integer.parseInt((String)var7.d);
            }

            if (var7.g.equals("numplayingevents")) {
               var1.h = Integer.parseInt((String)var7.d);
            }
         }

         return var1;
      }
   }

   public String[] e() {
      if (!g(this)) {
         return null;
      } else {
         String var1 = fmod.EventProject_getWaveBanksNeeded(this.d);
         String[] var2 = var1.split("\\|");

         for(int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = var2[var3] + ".fsb";
         }

         return var2;
      }
   }

   public static int h(Z256 var0) {
      return fmod.EventProject_getNumGroups(var0.d);
   }

   public static void s(Z256 var0, boolean var1) {
      fmod.EventProject_stopAllEvents(var0.d, var1);
   }

   public Z256(long var1) {
      this.d = var1;
   }

   public static boolean g(Z256 var0) {
      return var0.d != 0L;
   }

   public static J251[] q(Z256 var0) {
      int var1 = h(var0);
      J251[] var2 = new J251[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0.d(var3, false);
      }

      return var2;
   }
}
