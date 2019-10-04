package com.jagex.js5;

import java.util.BitSet;
import tfu.Gg3;
import tfu.Iw364;
import tfu.Mr366;

public class H362 {
   private static final int g = 7;
   Mr366 b;
   public int d;
   int e;
   int[] h;
   public int j;
   int l;
   BitSet[] m;
   int[][] p;
   public byte[] q;
   byte[][] r;
   int[] s;
   BitSet t;
   Mr366[] u;
   int[] v;
   int[] w;
   int[][] x;
   int[] y;
   int[] z;

   private void g(byte[] var1) {
      Gg3 var2 = new Gg3(js5.af(var1));
      int var3 = Gg3.ar(var2);
      if (var3 >= 5 && var3 <= 7) {
         if (var3 >= 6) {
            this.j = Gg3.bd(var2);
         } else {
            this.j = 0;
         }

         int var4 = Gg3.ar(var2);
         boolean var5 = (var4 & 1) != 0;
         boolean var6 = (var4 & 2) != 0;
         if (var3 >= 7) {
            this.e = Gg3.bv(var2);
         } else {
            this.e = Gg3.au(var2);
         }

         int var7 = 0;
         int var8 = -1;
         this.h = new int[this.e];
         int var9;
         if (var3 >= 7) {
            for(var9 = 0; var9 < this.e; ++var9) {
               this.h[var9] = var7 += Gg3.bv(var2);
               if (this.h[var9] > var8) {
                  var8 = this.h[var9];
               }
            }
         } else {
            for(var9 = 0; var9 < this.e; ++var9) {
               this.h[var9] = var7 += Gg3.au(var2);
               if (this.h[var9] > var8) {
                  var8 = this.h[var9];
               }
            }
         }

         this.l = var8 + 1;
         this.w = new int[this.l];
         if (var6) {
            this.r = new byte[this.l][];
         }

         this.v = new int[this.l];
         this.y = new int[this.l];
         this.p = new int[this.l][];
         this.z = new int[this.l];
         if (var5) {
            this.s = new int[this.l];

            for(var9 = 0; var9 < this.l; ++var9) {
               this.s[var9] = -1;
            }

            for(var9 = 0; var9 < this.e; ++var9) {
               this.s[this.h[var9]] = Gg3.bd(var2);
            }

            this.b = new Mr366(this.s);
         }

         for(var9 = 0; var9 < this.e; ++var9) {
            this.w[this.h[var9]] = Gg3.bd(var2);
         }

         if (var6) {
            for(var9 = 0; var9 < this.e; ++var9) {
               byte[] var10 = new byte[64];
               Gg3.bx(var2, var10, 0, 64);
               this.r[this.h[var9]] = var10;
            }
         }

         for(var9 = 0; var9 < this.e; ++var9) {
            this.v[this.h[var9]] = Gg3.bd(var2);
         }

         int var11;
         int var12;
         int var13;
         int var14;
         int var15;
         if (var3 >= 7) {
            for(var9 = 0; var9 < this.e; ++var9) {
               this.y[this.h[var9]] = Gg3.bv(var2);
            }

            for(var9 = 0; var9 < this.e; ++var9) {
               var15 = this.h[var9];
               var11 = this.y[var15];
               var7 = 0;
               var12 = -1;
               this.p[var15] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.p[var15][var13] = var7 += Gg3.bv(var2);
                  if (var14 > var12) {
                     var12 = var14;
                  }
               }

               this.z[var15] = var12 + 1;
               if (var12 + 1 == var11) {
                  this.p[var15] = null;
               }
            }
         } else {
            for(var9 = 0; var9 < this.e; ++var9) {
               this.y[this.h[var9]] = Gg3.au(var2);
            }

            for(var9 = 0; var9 < this.e; ++var9) {
               var15 = this.h[var9];
               var11 = this.y[var15];
               var7 = 0;
               var12 = -1;
               this.p[var15] = new int[var11];

               for(var13 = 0; var13 < var11; ++var13) {
                  var14 = this.p[var15][var13] = var7 += Gg3.au(var2);
                  if (var14 > var12) {
                     var12 = var14;
                  }
               }

               this.z[var15] = var12 + 1;
               if (var12 + 1 == var11) {
                  this.p[var15] = null;
               }
            }
         }

         if (var5) {
            this.x = new int[var8 + 1][];
            this.u = new Mr366[var8 + 1];

            for(var9 = 0; var9 < this.e; ++var9) {
               var15 = this.h[var9];
               var11 = this.y[var15];
               this.x[var15] = new int[this.z[var15]];

               for(var12 = 0; var12 < this.z[var15]; ++var12) {
                  this.x[var15][var12] = -1;
               }

               for(var12 = 0; var12 < var11; ++var12) {
                  if (this.p[var15] != null) {
                     var13 = this.p[var15][var12];
                  } else {
                     var13 = var12;
                  }

                  this.x[var15][var13] = Gg3.bd(var2);
               }

               this.u[var15] = new Mr366(this.x[var15]);
            }
         }

      } else {
         throw new RuntimeException("Incorrect JS5 protocol number: " + var3);
      }
   }

   H362(byte[] var1, boolean var2) {
      this.d = Gg3.m(var1, var1.length);
      if (var2) {
         this.q = Iw364.e(var1, 0, var1.length);
      }

      this.g(var1);
   }

   H362(byte[] var1, int var2, byte[] var3) {
      this.d = Gg3.m(var1, var1.length);
      if (this.d != var2) {
         throw new RuntimeException("Invalid CRC - expected:" + var2 + " got:" + this.d);
      } else {
         if (var3 != null) {
            if (var3.length != 64) {
               throw new RuntimeException("Invalid expectedwhirlpool - must be 64 bytes long");
            }

            this.q = Iw364.e(var1, 0, var1.length);

            for(int var4 = 0; var4 < 64; ++var4) {
               if (this.q[var4] != var3[var4]) {
                  throw new RuntimeException("Invalid Whirlpool - expected:" + js5.av(var3) + " got:" + js5.av(this.q));
               }
            }
         }

         this.g(var1);
      }
   }
}
