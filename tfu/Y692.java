package tfu;

import com.jagex.js5.js5;

public class Y692 extends Ln265 {
   private int[] b;
   public Cw634[] d;
   public byte[] e;
   public int g;
   public V686[] h;
   public byte[] j;
   public short[] q;
   public byte[] s;

   public Y692(byte[] var1) {
      this.d = new Cw634[128];
      this.q = new short[128];
      this.j = new byte[128];
      this.e = new byte[128];
      this.h = new V686[128];
      this.s = new byte[128];
      this.b = new int[128];
      Gg3 var2 = new Gg3(var1);

      int var3;
      for(var3 = 0; var2.r[var2.v + var3] != 0; ++var3) {
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = Gg3.ax(var2);
      }

      ++var2.v;
      ++var3;
      var5 = var2.v;
      var2.v += var3;

      int var6;
      for(var6 = 0; var2.r[var2.v + var6] != 0; ++var6) {
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = Gg3.ax(var2);
      }

      ++var2.v;
      ++var6;
      var8 = var2.v;
      var2.v += var6;

      int var9;
      for(var9 = 0; var2.r[var2.v + var9] != 0; ++var9) {
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = Gg3.ax(var2);
      }

      ++var2.v;
      ++var9;
      byte[] var36 = new byte[var9];
      int var12;
      int var14;
      if (var9 > 1) {
         var36[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = Gg3.ar(var2);
            if (var15 == 0) {
               var13 = var12++;
            } else {
               if (var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var36[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      V686[] var37 = new V686[var12];

      V686 var38;
      for(var14 = 0; var14 < var37.length; ++var14) {
         var38 = var37[var14] = new V686();
         int var16 = Gg3.ar(var2);
         if (var16 > 0) {
            var38.g = new byte[var16 * 2];
         }

         var16 = Gg3.ar(var2);
         if (var16 > 0) {
            var38.d = new byte[var16 * 2 + 2];
            var38.d[1] = 64;
         }
      }

      var14 = Gg3.ar(var2);
      byte[] var39 = var14 > 0 ? new byte[var14 * 2] : null;
      var14 = Gg3.ar(var2);
      byte[] var40 = var14 > 0 ? new byte[var14 * 2] : null;

      int var17;
      for(var17 = 0; var2.r[var2.v + var17] != 0; ++var17) {
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = Gg3.ax(var2);
      }

      ++var2.v;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += Gg3.ar(var2);
         this.q[var20] = (short)var19;
      }

      var19 = 0;

      short[] var48;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += Gg3.ar(var2);
         var48 = this.q;
         var48[var20] = (short)(var48[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if (var20 == 0) {
            if (var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = Gg3.bn(var2);
         }

         var48 = this.q;
         var48[var23] = (short)(var48[var23] + ((var22 - 1 & 2) << 14));
         this.b[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if (this.b[var24] != 0) {
            if (var20 == 0) {
               if (var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.r[var5++] - 1;
            }

            this.s[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if (this.b[var25] != 0) {
            if (var20 == 0) {
               if (var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.r[var8++] + 16 << 2;
            }

            this.e[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      V686 var42 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if (this.b[var26] != 0) {
            if (var20 == 0) {
               var42 = var37[var36[var21]];
               if (var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.h[var26] = var42;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if (var20 == 0) {
            if (var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if (this.b[var27] > 0) {
               var26 = Gg3.ar(var2) + 1;
            }
         }

         this.j[var27] = (byte)var26;
         --var20;
      }

      this.g = Gg3.ar(var2) + 1;

      V686 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.g != null) {
            for(var29 = 1; var29 < var28.g.length; var29 += 2) {
               var28.g[var29] = Gg3.ax(var2);
            }
         }

         if (var28.d != null) {
            for(var29 = 3; var29 < var28.d.length - 2; var29 += 2) {
               var28.d[var29] = Gg3.ax(var2);
            }
         }
      }

      if (var39 != null) {
         for(var27 = 1; var27 < var39.length; var27 += 2) {
            var39[var27] = Gg3.ax(var2);
         }
      }

      if (var40 != null) {
         for(var27 = 1; var27 < var40.length; var27 += 2) {
            var40[var27] = Gg3.ax(var2);
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.d != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.d.length; var29 += 2) {
               var19 = var19 + 1 + Gg3.ar(var2);
               var28.d[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.g != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.g.length; var29 += 2) {
               var19 = var19 + 1 + Gg3.ar(var2);
               var28.g[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var45;
      byte var47;
      if (var39 != null) {
         var19 = Gg3.ar(var2);
         var39[0] = (byte)var19;

         for(var27 = 2; var27 < var39.length; var27 += 2) {
            var19 = var19 + 1 + Gg3.ar(var2);
            var39[var27] = (byte)var19;
         }

         var47 = var39[0];
         byte var43 = var39[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.j[var29] = (byte)(this.j[var29] * var43 + 32 >> 6);
         }

         for(var29 = 2; var29 < var39.length; var29 += 2) {
            var30 = var39[var29];
            byte var31 = var39[var29 + 1];
            var32 = var43 * (var30 - var47) + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = Jz233.l(var32, var30 - var47);
               this.j[var33] = (byte)(this.j[var33] * var34 + 32 >> 6);
               var32 += var31 - var43;
            }

            var47 = var30;
            var43 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.j[var45] = (byte)(this.j[var45] * var43 + 32 >> 6);
         }

         var38 = null;
      }

      if (var40 != null) {
         var19 = Gg3.ar(var2);
         var40[0] = (byte)var19;

         for(var27 = 2; var27 < var40.length; var27 += 2) {
            var19 = var19 + 1 + Gg3.ar(var2);
            var40[var27] = (byte)var19;
         }

         var47 = var40[0];
         int var44 = var40[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = (this.e[var29] & 255) + var44;
            if (var45 < 0) {
               var45 = 0;
            }

            if (var45 > 128) {
               var45 = 128;
            }

            this.e[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var40.length; var29 += 2) {
            var30 = var40[var29];
            var46 = var40[var29 + 1] << 1;
            var32 = var44 * (var30 - var47) + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = Jz233.l(var32, var30 - var47);
               int var35 = (this.e[var33] & 255) + var34;
               if (var35 < 0) {
                  var35 = 0;
               }

               if (var35 > 128) {
                  var35 = 128;
               }

               this.e[var33] = (byte)var35;
               var32 += var46 - var44;
            }

            var47 = var30;
            var44 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = (this.e[var45] & 255) + var44;
            if (var46 < 0) {
               var46 = 0;
            }

            if (var46 > 128) {
               var46 = 128;
            }

            this.e[var45] = (byte)var46;
         }

         Object var41 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].q = Gg3.ar(var2);
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.g != null) {
            var28.j = Gg3.ar(var2);
         }

         if (var28.d != null) {
            var28.e = Gg3.ar(var2);
         }

         if (var28.q > 0) {
            var28.h = Gg3.ar(var2);
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].b = Gg3.ar(var2);
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.b > 0) {
            var28.s = Gg3.ar(var2);
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.s > 0) {
            var28.l = Gg3.ar(var2);
         }
      }

   }

   public static Y692 g(js5 var0, int var1) {
      byte[] var2 = js5.v(var0, var1);
      return var2 == null ? null : new Y692(var2);
   }

   public static boolean d(Y692 var0, Ca649 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      Object var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if (var2 == null || var2[var7] != 0) {
            int var8 = var0.b[var7];
            if (var8 != 0) {
               if (var8 != var5) {
                  var5 = var8--;
                  if ((var8 & 1) == 0) {
                     var6 = var1.q(var8 >> 2, var3);
                  } else {
                     var6 = var1.j(var8 >> 2, var3);
                  }

                  if (var6 == null) {
                     var4 = false;
                  }
               }

               if (var6 != null) {
                  var0.d[var7] = (Cw634)var6;
                  var0.b[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   public static void q(Y692 var0) {
      var0.b = null;
   }

   public Y692() {
   }
}
