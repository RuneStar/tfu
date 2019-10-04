package com.jagex.maths;

import java.util.Iterator;
import java.util.List;
import tfu.Gx298;
import tfu.Jz233;

public final class L296 {
   public J297[] g;

   private static J297[] h(J297[] var0, int var1) {
      J297[] var2 = new J297[var0.length];

      int var3;
      for(var3 = 0; var3 < var0.length; ++var3) {
         var2[var3] = new J297(var0[var3]);
      }

      var3 = var0.length;

      label49:
      while(var3 > 3) {
         int var4 = 0;

         while(true) {
            if (var4 >= var3) {
               break label49;
            }

            if (s(var2, var4, (var4 + 2) % var3, var3, (float)var1) != -1) {
               int var5 = (var4 + 2) % var3;

               do {
                  if (var4 == var5) {
                     break label49;
                  }

                  var4 = Jz233.w(var4 - 1, var3);
               } while(s(var2, var4, var5, var3, (float)var1) != -1);

               var4 = (var4 + 1) % var3;

               do {
                  if (var4 == var5) {
                     break label49;
                  }

                  var5 = (var5 + 1) % var3;
               } while(s(var2, var4, var5, var3, (float)var1) != -1);

               var5 = Jz233.w(var5 - 1, var3);
               if (var5 > var4) {
                  System.arraycopy(var2, var5, var2, var4 + 1, var3 - var5);
                  var3 -= var5 - var4 - 1;
               } else {
                  var3 = var4 + 1;
                  System.arraycopy(var2, var5, var2, 0, var3 - var5);
                  var3 -= var5;
               }
               break;
            }

            ++var4;
         }
      }

      J297[] var6 = new J297[var3];
      System.arraycopy(var2, 0, var6, 0, var3);
      return var6;
   }

   public L296(List var1, int var2) {
      if (var1.size() < 3) {
         throw new IllegalArgumentException("Must supply at least 3 points to generate a convex hull");
      } else {
         J297[] var3 = new J297[var1.size()];
         int var4 = 0;

         Vector3 var6;
         for(Iterator var5 = var1.iterator(); var5.hasNext(); var3[var4++] = new J297(var6.x, var6.z)) {
            var6 = (Vector3)var5.next();
         }

         this.g = g(var3);
         if (var2 != 0) {
            this.g = h(this.g, var2);
         }

      }
   }

   public L296(float[] var1, float[] var2, int var3, int var4) {
      J297[] var5 = new J297[var3];

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = new J297(var1[var6], var2[var6]);
      }

      if (var5.length < 3) {
         throw new IllegalArgumentException();
      } else {
         this.g = g(var5);
         if (var4 != 0) {
            this.g = h(this.g, var4);
         }
      }
   }

   private static J297[] g(J297[] var0) {
      float var1 = Float.MAX_VALUE;
      float var2 = 0.0F;

      int var3;
      for(var3 = 0; var3 < var0.length; ++var3) {
         J297 var4 = var0[var3];
         if (var4.d < var1) {
            var2 = var4.g;
            var1 = var4.d;
         } else if (var4.d == var1 && var2 < var4.g) {
            var2 = var4.g;
            var1 = var4.d;
         }
      }

      J297[] var11 = var0;
      int var12 = var0.length;

      int var5;
      J297 var6;
      double var9;
      for(var5 = 0; var5 < var12; ++var5) {
         var6 = var11[var5];
         float var7 = var6.g - var2;
         float var8 = var6.d - var1;
         var9 = Math.sqrt((double)(var7 * var7 + var8 * var8));
         if (Math.abs(var9) < 0.01D) {
            var6.q = 1.0D;
         } else {
            var6.q = (double)var7 / var9;
         }
      }

      q(var0);
      var3 = var0.length;

      for(var12 = 0; var12 < var3 - 1; ++var12) {
         J297 var13 = var0[var12];
         var6 = var0[var12 + 1];
         if (var13.q == var6.q) {
            double var16 = Math.sqrt((double)((var13.g - var2) * (var13.g - var2) + (var13.d - var1) * (var13.d - var1)));
            var9 = Math.sqrt((double)((var6.g - var2) * (var6.g - var2) + (var6.d - var1) * (var6.d - var1)));
            if (var16 < var9) {
               System.arraycopy(var0, var12 + 1, var0, var12, var3 - var12 - 1);
            } else if (var12 + 2 < var3) {
               System.arraycopy(var0, var12 + 2, var0, var12 + 1, var3 - var12 - 2);
            }

            --var3;
            --var12;
         }
      }

      Gx298 var14 = new Gx298();
      Gx298.t(var14, var0[0]);
      Gx298.t(var14, var0[1]);

      for(var5 = 2; var5 < var0.length; ++var5) {
         var6 = (J297)Gx298.a(var14);

         for(J297 var17 = (J297)Gx298.ag(var14); Gx298.aq(var14) >= 2 && !d(var17, var6, var0[var5]); var17 = (J297)Gx298.ag(var14)) {
            Gx298.k(var14);
            var6 = var17;
         }

         Gx298.t(var14, var0[var5]);
      }

      J297[] var15 = new J297[Gx298.aq(var14)];
      Gx298.al(var14, var15);
      return var15;
   }

   private static boolean d(J297 var0, J297 var1, J297 var2) {
      return (var1.g - var0.g) * (var2.d - var1.d) + (var1.d - var0.d) * (var1.g - var2.g) >= 0.0F;
   }

   private static void q(J297[] var0) {
      j(var0, var0.length);

      for(int var1 = var0.length - 1; var1 > 0; --var1) {
         J297 var2 = var0[var1];
         var0[var1] = var0[0];
         var0[0] = var2;
         e(var0, 0, var1 - 1);
      }

   }

   private static void e(J297[] var0, int var1, int var2) {
      int var5;
      for(int var3 = var1; var3 * 2 + 1 <= var2; var3 = var5) {
         int var4 = var3 * 2 + 1;
         var5 = var3;
         if (var0[var3].q > var0[var4].q) {
            var5 = var4;
         }

         if (var4 < var2 && var0[var5].q > var0[var4 + 1].q) {
            var5 = var4 + 1;
         }

         if (var5 == var3) {
            return;
         }

         J297 var6 = var0[var3];
         var0[var3] = var0[var5];
         var0[var5] = var6;
      }

   }

   public L296(int[] var1, int[] var2, int var3, int var4) {
      J297[] var5 = new J297[var3];

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = new J297((float)var1[var6], (float)var2[var6]);
      }

      if (var5.length < 3) {
         throw new IllegalArgumentException();
      } else {
         this.g = g(var5);
         if (var4 != 0) {
            this.g = h(this.g, var4);
         }
      }
   }

   private static int s(J297[] var0, int var1, int var2, int var3, float var4) {
      float var5 = var0[var2].g - var0[var1].g;
      float var6 = var0[var2].d - var0[var1].d;
      float var7 = 0.0F;
      int var8 = -2;

      for(int var9 = (var1 + 1) % var3; var9 != var2; var9 = (var9 + 1) % var3) {
         float var10 = (float)Math.abs((double)((var0[var9].d - var0[var1].d) * var5 - (var0[var9].g - var0[var1].g) * var6) / Math.sqrt((double)(var5 * var5 + var6 * var6)));
         if (var10 > var4) {
            return -1;
         }

         if (var10 > var7) {
            var7 = var10;
            var8 = var9;
         }
      }

      return var8;
   }

   private static void j(J297[] var0, int var1) {
      for(int var2 = var1 / 2; var2 >= 0; --var2) {
         e(var0, var2, var1 - 1);
      }

   }
}
