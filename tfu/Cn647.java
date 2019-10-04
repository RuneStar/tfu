package tfu;

class Cn647 {
   private int d;
   private float[][] e;
   int g;
   private int[] h;
   private int[] j;
   private int[] q;

   private static int g(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; Jz233.g(var2, var1) > var0; --var2) {
      }

      return var2;
   }

   private static void d(Cn647 var0) {
      int[] var1 = new int[var0.d];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < var0.d; ++var3) {
         var4 = var0.q[var3];
         if (var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var2[var4];
            var1[var3] = var6;
            int var9;
            if ((var6 & var5) != 0) {
               var7 = var2[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var9 = var2[var8];
                  if (var9 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if ((var9 & var10) != 0) {
                     var2[var8] = var2[var8 - 1];
                     break;
                  }

                  var2[var8] = var9 | var10;
               }
            }

            var2[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var9 = var2[var8];
               if (var9 == var6) {
                  var2[var8] = var7;
               }
            }
         }
      }

      var0.h = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < var0.d; ++var3) {
         var4 = var0.q[var3];
         if (var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if ((var5 & var8) != 0) {
                  if (var0.h[var6] == 0) {
                     var0.h[var6] = var11;
                  }

                  var6 = var0.h[var6];
               } else {
                  ++var6;
               }

               if (var6 >= var0.h.length) {
                  int[] var12 = new int[var0.h.length * 2];

                  for(var10 = 0; var10 < var0.h.length; ++var10) {
                     var12[var10] = var0.h[var10];
                  }

                  var0.h = var12;
               }

               var8 >>>= 1;
            }

            var0.h[var6] = ~var3;
            if (var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   Cn647() {
      Cg550.j(24);
      this.g = Cg550.j(16);
      this.d = Cg550.j(24);
      this.q = new int[this.d];
      boolean var1 = Cg550.q() != 0;
      int var2;
      int var3;
      int var5;
      if (var1) {
         var2 = 0;

         for(var3 = Cg550.j(5) + 1; var2 < this.d; ++var3) {
            int var4 = Cg550.j(Jz233.s(this.d - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.q[var2++] = var3;
            }
         }
      } else {
         boolean var14 = Cg550.q() != 0;

         for(var3 = 0; var3 < this.d; ++var3) {
            if (var14 && Cg550.q() == 0) {
               this.q[var3] = 0;
            } else {
               this.q[var3] = Cg550.j(5) + 1;
            }
         }
      }

      d(this);
      var2 = Cg550.j(4);
      if (var2 > 0) {
         float var15 = Cg550.g(Cg550.j(32));
         float var16 = Cg550.g(Cg550.j(32));
         var5 = Cg550.j(4) + 1;
         boolean var6 = Cg550.q() != 0;
         int var7;
         if (var2 == 1) {
            var7 = g(this.d, this.g);
         } else {
            var7 = this.d * this.g;
         }

         this.j = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.j[var8] = Cg550.j(var5);
         }

         this.e = new float[this.d][this.g];
         float var9;
         int var10;
         int var11;
         if (var2 == 1) {
            for(var8 = 0; var8 < this.d; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.g; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.j[var12] * var16 + var15 + var9;
                  this.e[var8][var11] = var13;
                  if (var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.d; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.g;

               for(var11 = 0; var11 < this.g; ++var11) {
                  float var17 = (float)this.j[var10] * var16 + var15 + var9;
                  this.e[var8][var11] = var17;
                  if (var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }
}
