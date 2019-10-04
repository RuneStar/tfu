package com.jagex.js5;

import java.math.BigInteger;
import tfu.Gg3;
import tfu.Hl134;
import tfu.Iw364;
import tfu.Lb33;

public class G137 {
   private L145 d;
   private B360 e;
   private W144 g;
   private Gg3 h;
   private BigInteger j;
   private BigInteger q;
   private Q138[] s;

   public G137(W144 var1, L145 var2, BigInteger var3, BigInteger var4) {
      this.g = var1;
      this.d = var2;
      this.q = var3;
      this.j = var4;
      if (!W144.q(this.g)) {
         this.e = this.g.g(255, 255, (byte)0, true);
      }

   }

   public boolean g() {
      if (this.h != null) {
         return true;
      } else {
         if (this.e == null) {
            if (W144.q(this.g)) {
               return false;
            }

            this.e = this.g.g(255, 255, (byte)0, true);
         }

         if (this.e.l) {
            return false;
         } else {
            Gg3 var1 = new Gg3(this.e.g());
            var1.v = 5;
            int var2 = Gg3.ar(var1);
            var1.v += var2 * 72;
            byte[] var3 = new byte[var1.r.length - var1.v];
            Gg3.bx(var1, var3, 0, var3.length);
            byte[] var4;
            if (this.q != null && this.j != null) {
               BigInteger var5 = new BigInteger(var3);
               BigInteger var6 = var5.modPow(this.q, this.j);
               var4 = var6.toByteArray();
            } else {
               var4 = var3;
            }

            if (var4.length != 65) {
               throw new RuntimeException("Incorrect Whirlpool length - got: " + var4.length + " bytes");
            } else {
               byte[] var7 = Iw364.e(var1.r, 5, var1.v - var3.length - 5);

               for(int var8 = 0; var8 < 64; ++var8) {
                  if (var7[var8] != var4[var8 + 1]) {
                     throw new RuntimeException("Masterindex Whirlpool from server does not match my calculation - expected:" + js5.av(var4) + " got:" + js5.av(var7));
                  }
               }

               this.s = new Q138[var2];
               this.h = var1;
               return true;
            }
         }
      }
   }

   public static Q138 d(G137 var0, int var1, Hl134 var2, Hl134 var3) {
      return var0.q(var1, var2, var3, true);
   }

   public Q138 q(int var1, Hl134 var2, Hl134 var3, boolean var4) {
      if (this.h == null) {
         throw new RuntimeException("Not ready!");
      } else if (var1 >= 0 && var1 < this.s.length) {
         if (this.s[var1] != null) {
            return this.s[var1];
         } else {
            this.h.v = var1 * 72 + 6;
            int var5 = Gg3.bd(this.h);
            int var6 = Gg3.bd(this.h);
            byte[] var7 = new byte[64];
            Gg3.bx(this.h, var7, 0, 64);
            if (var5 == 0) {
               System.out.println("Warning: indexcrc==0 - likely invalid archiveid requested - archiveid:" + var1);
            }

            Q138 var8 = new Q138(var1, var2, var3, this.g, this.d, var5, var7, var6, var4);
            this.s[var1] = var8;
            return var8;
         }
      } else {
         throw new RuntimeException("Invalid archiveid requested - archiveid:" + var1);
      }
   }

   public static void j(G137 var0) {
      if (var0.s != null) {
         Lb33.g(Lb33.Js5Archive);

         try {
            int var1;
            for(var1 = 0; var1 < var0.s.length; ++var1) {
               if (var0.s[var1] != null) {
                  Q138.e(var0.s[var1]);
               }
            }

            for(var1 = 0; var1 < var0.s.length; ++var1) {
               if (var0.s[var1] != null) {
                  var0.s[var1].h();
               }
            }

            Lb33.d(Lb33.Js5Archive);
         } finally {
            Lb33.d(Lb33.Js5Archive);
         }
      }
   }

   public G137(W144 var1, L145 var2) {
      this(var1, var2, (BigInteger)null, (BigInteger)null);
   }
}
