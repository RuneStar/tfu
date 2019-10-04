package rs2.client.friends;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import rs2.client.client;
import rs2.client.chat.G232;
import tfu.Gz143;
import tfu.Jz233;
import tfu.Le231;
import tfu.Md230;
import tfu.Mk163;

public final class J228 {
   private final Q210[] d;
   public int g = 0;
   private final List j;
   private final Map q;

   public static Q210 q(J228 var0, int var1) {
      return var1 >= 0 && var1 < var0.g ? var0.d[var1] : null;
   }

   public void j(boolean var1, String var2, String var3, int var4, String var5, boolean var6, boolean var7) {
      Q210 var8;
      if (var1) {
         var8 = (Q210)this.q.get(var3);
         if (var8 != null) {
            var8.g = var2;
            var8.d = var3;
            this.q.put(var2, var8);
         }

      } else {
         var8 = (Q210)this.q.get(var2);
         if (var8 == null) {
            if (this.g < this.d.length) {
               Q210 var12 = new Q210();
               var12.g = var2;
               var12.q = var4;
               var12.j = var5;
               var12.e = var6;
               var12.h = var7;
               this.d[this.g++] = var12;
               this.q.put(var12.g, var12);
            }

         } else {
            if (var8.q != var4) {
               boolean var9 = true;
               Iterator var10 = this.j.iterator();

               label49:
               while(true) {
                  while(true) {
                     G229 var11;
                     do {
                        if (!var10.hasNext()) {
                           if (var9) {
                              this.j.add(new G229(var2, var4));
                           }

                           var8.q = var4;
                           break label49;
                        }

                        var11 = (G229)var10.next();
                     } while(!var11.d.equals(var2));

                     if (var4 != 0 && var11.q == 0) {
                        var10.remove();
                        var9 = false;
                     } else if (var4 == 0 && var11.q != 0) {
                        var10.remove();
                        var9 = false;
                     }
                  }
               }
            }

            var8.d = var3;
            var8.j = var5;
            var8.e = var6;
            var8.h = var7;
         }
      }
   }

   public static boolean e(J228 var0) {
      return var0.g >= var0.d.length;
   }

   public static boolean h(J228 var0, String var1) {
      if (var1 == null) {
         return false;
      } else {
         String var2 = Md230.j(var1);
         if (var2 == null) {
            return false;
         } else {
            for(int var3 = 0; var3 < var0.g; ++var3) {
               Q210 var4 = var0.d[var3];
               if (Le231.g(var1, var2, var4.g, Md230.j(var4.g))) {
                  var0.q.remove(var4.g);
                  if (var0.g < var0.d.length) {
                     System.arraycopy(var0.d, var3 + 1, var0.d, var3, var0.g - var3);
                  }

                  --var0.g;
                  var0.d[var0.g] = null;
                  return true;
               }
            }

            return false;
         }
      }
   }

   public static void s(J228 var0) {
      var0.g = 0;
      var0.q.clear();
   }

   public void b() {
      Iterator var1 = this.j.iterator();

      while(var1.hasNext()) {
         G229 var2 = (G229)var1.next();
         if ((long)var2.g < Gz143.g() / 1000L - 5L) {
            if (var2.q > 0) {
               G232.q(5, 0, "", "", "", var2.d + Mk163.g(Mk163.FRIENDLOGIN, client.n));
            }

            if (var2.q == 0) {
               G232.q(5, 0, "", "", "", var2.d + Mk163.g(Mk163.FRIENDLOGOUT, client.n));
            }

            var1.remove();
         }
      }

   }

   public J228(int var1) {
      this.d = new Q210[var1];
      this.q = new HashMap(Jz233.j(var1));
      this.j = new LinkedList();
   }

   public static int g(J228 var0, String var1) {
      if (var1 != null) {
         for(int var2 = 0; var2 < var0.g; ++var2) {
            if (var0.d[var2].g.equalsIgnoreCase(var1)) {
               return var2;
            }
         }
      }

      return -1;
   }

   public static Q210 d(J228 var0, String var1, boolean var2) {
      String var3 = Md230.e(var1, client.m.l);

      for(int var4 = 0; var4 < var0.g; ++var4) {
         if (Le231.g(var1, var3, var0.d[var4].g, Md230.e(var0.d[var4].g, client.m.l))) {
            return var0.d[var4];
         }

         if (var2 && var0.d[var4].d != null && Le231.g(var1, var3, var0.d[var4].d, Md230.e(var0.d[var4].d, client.m.l))) {
            return var0.d[var4];
         }
      }

      return null;
   }
}
