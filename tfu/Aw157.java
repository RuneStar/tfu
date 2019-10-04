package tfu;

import com.jagex.js5.js5;
import java.util.HashMap;
import java.util.Map;

public class Aw157 {
   final js5 d;
   Map e = null;
   final js5 g;
   final int[] j;
   final Eq28 q = new Eq28(20);

   public void g(Ab158 var1) {
      this.e = new HashMap(this.j.length);

      for(int var2 = 0; var2 < this.j.length; ++var2) {
         int var3 = this.j[var2];
         Kj334 var4 = Kj334.g(this.d, var3);
         byte[] var5 = js5.v(this.g, var3);
         Object var6 = var1.d(var5, var4, true);
         this.e.put(var2, new Jk523(var6, var4));
      }

   }

   public static int q(Aw157 var0, boolean var1) {
      if (var0.j == null) {
         return 0;
      } else if (!var1 && var0.e != null) {
         return var0.j.length * 2;
      } else {
         int var2 = 0;

         for(int var3 = 0; var3 < var0.j.length; ++var3) {
            int var4 = var0.j[var3];
            if (var0.g.b(var4)) {
               ++var2;
            }

            if (var0.d.b(var4)) {
               ++var2;
            }
         }

         return var2;
      }
   }

   public static int d(Aw157 var0) {
      return q(var0, false);
   }

   public static Object e(Aw157 var0, Ab158 var1, int var2, boolean var3, boolean var4) {
      Jk523 var5 = var0.s(var1, var2, var3, var4);
      return var5 == null ? null : var5.g;
   }

   private Jk523 s(Ab158 var1, int var2, boolean var3, boolean var4) {
      if (var2 == -1) {
         return null;
      } else {
         if (this.j != null) {
            for(int var5 = 0; var5 < this.j.length; ++var5) {
               if (this.j[var5] == var2) {
                  return (Jk523)this.e.get(var5);
               }
            }
         }

         Jk523 var8 = (Jk523)this.q.g((long)(var2 << 1 | (var4 ? 1 : 0)));
         if (var8 != null) {
            if (var3 && var8.d == null) {
               Kj334 var9 = Kj334.g(this.d, var2);
               if (var9 == null) {
                  return null;
               }

               var8.d = var9;
            }

            return var8;
         } else {
            byte[] var6 = js5.v(this.g, var2);
            if (var6 == null) {
               return null;
            } else {
               Kj334 var7 = Kj334.g(this.d, var2);
               if (var7 == null) {
                  return null;
               } else {
                  if (var3) {
                     var8 = new Jk523(var1.d(var6, var7, var4), var7);
                  } else {
                     var8 = new Jk523(var1.d(var6, var7, var4), (Object)null);
                  }

                  Eq28.j(this.q, var8, (long)(var2 << 1 | (var4 ? 1 : 0)));
                  return var8;
               }
            }
         }
      }
   }

   public Aw157(js5 var1, js5 var2, int[] var3) {
      this.g = var1;
      this.d = var2;
      if (var3 != null) {
         this.j = var3;
      } else {
         this.j = null;
      }

   }

   public static Kj334 h(Aw157 var0, Ab158 var1, int var2) {
      Jk523 var3 = var0.s(var1, var2, true, true);
      return var3 == null ? null : (Kj334)var3.d;
   }

   public static void w(Aw157 var0) {
      Eq28.b(var0.q);
   }

   public static int j(Aw157 var0) {
      return var0.j == null ? 0 : var0.j.length * 2;
   }

   public static void l(Aw157 var0, int var1) {
      var0.q.h(var1);
   }

   public static void b(Aw157 var0) {
      Eq28.s(var0.q);
   }
}
