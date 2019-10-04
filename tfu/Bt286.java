package tfu;

import java.util.AbstractList;

public final class Bt286 extends AbstractList {
   private final int d;
   private final Bb4[] g;

   public static Bb4 z(Bt286 var0, int var1) {
      return var0.g[var1];
   }

   public int size() {
      return this.g.length;
   }

   public static Bb4[] t(Bt286 var0) {
      return (Bb4[])var0.g.clone();
   }

   public static Bt286 m(Gg3 var0, Bc288 var1) {
      if (!Bz650.b(var1)) {
         throw new IllegalArgumentException("Client-side GameEntityId of type " + var1.name() + " cannot be sent to server");
      } else {
         Bb4[] var2 = new Bb4[Gg3.bn(var0)];
         int var3 = 0;
         if (var2.length != 0) {
            var3 = i(var0, var1, var2);
         }

         return new Bt286(var2, var3);
      }
   }

   public Object[] toArray(Object[] var1) {
      return (Object[])this.g.clone();
   }

   Bt286(Bb4[] var1, int var2) {
      this.g = var1;
      this.d = this.n(var2);
      Bb4[] var3 = this.g;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Bb4 var6 = var3[var5];
         if (var6.g != this.g[0].g) {
            throw new IllegalArgumentException();
         }
      }

   }

   private static int i(Gg3 var0, Bc288 var1, Bb4[] var2) {
      int var3 = 0;
      int var4 = 0;
      int var5 = -1;

      while(true) {
         while(var4 < var2.length) {
            int var6 = var4 + Gg3.bn(var0);
            if (var6 == var4) {
               ++var3;
            } else {
               int var7;
               if (var5 == -1) {
                  var7 = Gg3.au(var0);
               } else {
                  var7 = var5 + Gg3.bn(var0);
               }

               for(int var8 = var4; var8 < var6; ++var8) {
                  var2[var8] = new Bb4(var1, var7++);
               }

               var5 = var7;
               var4 = var6;
            }
         }

         return var3;
      }
   }

   private static void k(Bt286 var0, Gg3 var1) {
      int var2 = 0;

      int var5;
      for(int var3 = -1; var2 < var0.g.length; var2 = var5) {
         int var4 = var0.g[var2].d;
         var5 = var2 + 1;

         int var6;
         for(var6 = var4 + 1 & '\uffff'; var5 < var0.g.length && var0.g[var5].d == var6; var6 = var6 + 1 & '\uffff') {
            ++var5;
         }

         if (var3 == -1) {
            for(int var7 = 0; var7 < var0.d; ++var7) {
               Gg3.ab(var1, 0);
            }
         }

         Gg3.ab(var1, var5 - var2);
         if (var3 == -1) {
            Gg3.i(var1, var4);
         } else {
            Gg3.ab(var1, var4 - var3);
         }

         var3 = var6;
      }

   }

   private int n(int var1) {
      if (Bz650.d) {
         int var2 = this.g.length;
         if (var2 > var1) {
            var2 = var1;
         }

         int var3 = 0;
         if (var2 > 0) {
            byte var5 = 2;
            var3 = var5 + 3 * (var2 - 1);
            var3 += 3 * var2;
         }

         Gg3 var4 = new Gg3(var3);
         k(this, var4);
         return var3 - var4.v;
      } else {
         return 0;
      }
   }
}
