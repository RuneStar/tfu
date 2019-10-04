package tfu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ai354 {
   static final int b = 81920;
   public static final float d = 4.0F;
   static final int e = 65536;
   static final int h = 65536;
   static final int j = g('M', 'E', 'S', 'H');
   static final int l = 114688;
   private static final Logger logger = LoggerFactory.getLogger(Ai354.class);
   public static float q = 0.015625F;
   private static final Ir421 r = new K547();
   static final int s = 98304;
   static boolean w = true;

   public static int g(char var0, char var1, char var2, char var3) {
      return (var0 & 255) << 0 | (var1 & 255) << 8 | (var2 & 255) << 16 | (var3 & 255) << 24;
   }

   private static Aq544 q(long var0, Fk353 var2, Fp460 var3, Hi86 var4, Map var5, Map var6) {
      Aq544 var7 = new Aq544();
      boolean var8 = var2.y != null;
      int var9 = Kc180.e();
      Kc180.r(var0, j);
      long var10 = var0 + 4L;
      Kc180.r(var10, 65536);
      var10 += 4L;
      Fc454 var12;
      if (var4 != null) {
         try {
            if (var3.b != -1) {
               var12 = (Fc454)var4.j(Fc454.class, var3.b);
            } else {
               var12 = null;
            }
         } catch (Ik357 var72) {
            var12 = null;
         }
      } else {
         var12 = var3.b != -1 ? (Fc454)var5.get(var3.b) : null;
      }

      Fs455 var10001;
      label321: {
         if (var12 != null) {
            var10001 = var12.t;
            if (var12.t == Fs455.TWO_TONE_PPL) {
               Kc180.r(var10, var8 ? 114688 : 81920);
               var10 += 4L;
               Kc180.r(var10, 104);
               var10 += 4L;
               break label321;
            }
         }

         Kc180.r(var10, var8 ? 98304 : 65536);
         var10 += 4L;
         Kc180.r(var10, 80);
         var10 += 4L;
      }

      float[] var13 = new float[]{0.4F, 0.3F, 0.27F};
      float[] var14 = new float[]{2.0F};
      float[] var15 = new float[]{0.0F};
      float[] var16 = new float[]{1.0F, 1.0F, 1.0F};
      float[] var17 = new float[]{1.0F};
      if (var12 != null && Fs455.d(var12.t)) {
         Fc454.g(var12, "SpecularColour", var13);
         Fc454.g(var12, "SpecularExponent", var14);
         Fc454.g(var12, "EnvMappingWeight", var15);
         Fc454.g(var12, "EmissiveColour", var16);
         Fc454.g(var12, "EmissiveBoost", var17);
      }

      if (var16[0] == 0.0F && var16[1] == 0.0F && var16[2] == 0.0F) {
         var16[0] = 1.0F;
         var16[1] = 1.0F;
         var16[2] = 1.0F;
      }

      Kc180.v(var10, var13[0]);
      var10 += 4L;
      Kc180.v(var10, var13[1]);
      var10 += 4L;
      Kc180.v(var10, var13[2]);
      var10 += 4L;
      Kc180.v(var10, var14[0]);
      var10 += 4L;
      Kc180.v(var10, var15[0]);
      var10 += 4L;
      Kc180.v(var10, var16[0]);
      var10 += 4L;
      Kc180.v(var10, var16[1]);
      var10 += 4L;
      Kc180.v(var10, var16[2]);
      var10 += 4L;
      Kc180.v(var10, var17[0]);
      var10 += 4L;
      float[] var18 = new float[]{0.0F, 0.0F};
      float[] var19 = new float[]{0.0F, 0.0F};
      float[] var20 = new float[]{0.0F, 0.0F};
      if (var12 != null) {
         Fc454.g(var12, "UVTransSpeed", var18);
         Fc454.g(var12, "UVRotOrigin", var19);
         Fc454.g(var12, "UVRotSpeed", var20);
      }

      Kc180.v(var10, var18[0]);
      var10 += 4L;
      Kc180.v(var10, var18[1]);
      var10 += 4L;
      Kc180.v(var10, var19[0]);
      var10 += 4L;
      Kc180.v(var10, var19[1]);
      var10 += 4L;
      Kc180.v(var10, var20[0]);
      var10 += 4L;
      Kc180.v(var10, 1.0F);
      var10 += 4L;
      Kc180.v(var10, 1.0F);
      var10 += 4L;
      Kc180.v(var10, 1.0F);
      var10 += 4L;
      Kc180.v(var10, 0.0F);
      var10 += 4L;
      Kc180.v(var10, 0.0F);
      var10 += 4L;
      Kc180.v(var10, 0.0F);
      var10 += 4L;
      if (var12 != null) {
         var10001 = var12.t;
         if (var12.t == Fs455.TWO_TONE_PPL) {
            Kc180.v(var10, 1.0F);
            var10 += 4L;
            Kc180.v(var10, 1.0F);
            var10 += 4L;
            Kc180.v(var10, 1.0F);
            var10 += 4L;
            Kc180.v(var10, 1.0F);
            var10 += 4L;
            Kc180.v(var10, 1.0F);
            var10 += 4L;
            Kc180.v(var10, 1.0F);
            var10 += 4L;
         }
      }

      Kc180.r(var10, 2);
      var10 += 4L;
      Ig436 var21;
      int var22;
      int var23;
      int var75;
      int var76;
      if (var4 != null) {
         var22 = -1;
         var23 = -1;
         if (var12 != null) {
            var22 = var12.p;
            var23 = var12.x;
            var21 = var12.z;
         } else {
            var21 = Ig436.OPAQUE;
         }

         Kc180.r(var10, var22);
         var10 += 4L;
         Kc180.r(var10, var23);
         var10 += 4L;
      } else {
         String var73 = "default_diff";
         String var74 = "default_mat2";
         if (var12 == null) {
            logger.info("Glue failed to load material with id {}", var3.b);
            var21 = Ig436.OPAQUE;
         } else {
            logger.info("Glue succeeded in loading material with id {}", var3.b);
            I545 var24 = null;
            String var25 = new String("");
            if (var12.p != -1) {
               var24 = (I545)var6.get(var12.p);
            } else {
               var73 = var12.r;
               var24 = (I545)var6.get(var12.r.hashCode());
            }

            if (var24 != null) {
               var73 = var24.d.getAbsolutePath();
               var25 = "." + Iu445.g(var24.d);
            }

            if (var12.x != -1) {
               I545 var26 = (I545)var6.get(var12.x);
               if (var26 != null) {
                  var74 = var26.d.getAbsolutePath();
               }
            } else {
               var74 = var73.toLowerCase();
               var76 = var74.lastIndexOf(46);
               if (var76 > 0) {
                  var74 = var74.substring(0, var76);
               }

               if (var12.v != null) {
                  var74 = var12.v;
               } else {
                  String var27 = "_diff";
                  String var28 = "_diffa";
                  String var29 = "_diffm";
                  if (var74.endsWith(var28)) {
                     var74 = var74.substring(0, var74.length() - var28.length()) + "_mat2" + var25;
                  } else if (var74.endsWith(var29)) {
                     var74 = var74.substring(0, var74.length() - var29.length()) + "_mat2" + var25;
                  } else if (var74.endsWith(var27)) {
                     var74 = var74.substring(0, var74.length() - var27.length()) + "_mat2" + var25;
                  }
               }
            }

            var21 = var12.z;
         }

         Kc180.r(var10, var73.length());
         var10 += 4L;

         for(var75 = 0; var75 < var73.length(); ++var75) {
            Kc180.l(var10, var73.charAt(var75));
            ++var10;
         }

         Kc180.r(var10, var74.length());
         var10 += 4L;

         for(var75 = 0; var75 < var74.length(); ++var75) {
            Kc180.l(var10, var74.charAt(var75));
            ++var10;
         }
      }

      var22 = 20;
      var23 = 3;
      if (var8) {
         var22 += 8;
         var23 += 2;
      }

      if (w) {
         var22 += 4;
         ++var23;
      }

      Kc180.r(var10, var23);
      var10 += 4L;
      Kc180.r(var10, 0);
      var10 += 4L;
      Kc180.r(var10, 2);
      var10 += 4L;
      Kc180.r(var10, 0);
      var10 += 4L;
      Kc180.r(var10, 0);
      var10 += 4L;
      Kc180.r(var10, 0);
      var10 += 4L;
      Kc180.r(var10, 6);
      var10 += 4L;
      Kc180.r(var10, 5);
      var10 += 4L;
      Kc180.r(var10, 0);
      var10 += 4L;
      Kc180.r(var10, 0);
      var10 += 4L;
      Kc180.r(var10, 8);
      var10 += 4L;
      Kc180.r(var10, 3);
      var10 += 4L;
      Kc180.r(var10, 0);
      var10 += 4L;
      if (var8) {
         Kc180.r(var10, 0);
         var10 += 4L;
         Kc180.r(var10, 5);
         var10 += 4L;
         Kc180.r(var10, 2);
         var10 += 4L;
         Kc180.r(var10, 0);
         var10 += 4L;
         Kc180.r(var10, 0);
         var10 += 4L;
         Kc180.r(var10, 8);
         var10 += 4L;
         Kc180.r(var10, 1);
         var10 += 4L;
         Kc180.r(var10, 0);
         var10 += 4L;
      }

      if (w) {
         Kc180.r(var10, 0);
         var10 += 4L;
         Kc180.r(var10, 8);
         var10 += 4L;
         Kc180.r(var10, 10);
         var10 += 4L;
         Kc180.r(var10, 0);
         var10 += 4L;
      }

      Kc180.r(var10, var22);
      var10 += 4L;
      boolean var77 = false;
      boolean var78 = false;
      boolean var79 = false;
      var75 = var3.g * 3;
      var76 = var2.t;
      int var80 = var2.s;
      long var81 = var10;
      var10 += 4L;
      Kc180.r(var10, var75);
      var10 += 4L;
      long var82 = var10;
      long var31 = var10 + (long)(var22 * var76);
      O546[] var37 = null;
      int var38;
      int var41;
      if (var8) {
         var37 = new O546[var80];
         if (var2.y != null) {
            var38 = 0;

            for(int var39 = 0; var39 < var2.s; ++var39) {
               O546 var40 = var37[var39] = new O546(var2.y[var39]);

               for(var41 = 0; var41 < var2.y[var39]; ++var41) {
                  var40.d[var41] = var2.p[var38];
                  var40.q[var41] = (float)(var2.x[var38] & 255) / 255.0F;
                  ++var38;
               }
            }
         }
      }

      var38 = 0;
      int[] var83 = new int[var80];
      HashMap var84 = new HashMap(var80);

      for(var41 = 0; var41 < var80; ++var41) {
         Ag543 var42 = new Ag543(var2.b[var41], var2.l[var41], var2.w[var41]);
         Integer var43 = (Integer)var84.get(var42);
         if (var43 == null) {
            var84.put(var42, var38);
            var83[var41] = var38++;
         } else {
            var83[var41] = var43;
         }
      }

      var41 = 0;
      int[] var85 = new int[var76];
      float[] var86 = new float[var76];
      float[] var44 = new float[var76];
      float[] var45 = new float[var76];
      Ha262 var46 = new Ha262(Jz233.e(var76));

      int var47;
      int var48;
      int var49;
      int var50;
      for(var47 = 0; var47 < var3.g; ++var47) {
         var48 = var3.e[var47] & '\uffff';
         var49 = var3.h[var47] & '\uffff';
         var50 = var3.s[var47] & '\uffff';
         float var51 = (float)(var2.b[var50] - var2.b[var49]);
         float var52 = (float)(var2.b[var48] - var2.b[var49]);
         float var53 = (float)(var2.l[var50] - var2.l[var49]);
         float var54 = (float)(var2.l[var48] - var2.l[var49]);
         float var55 = (float)(var2.w[var50] - var2.w[var49]);
         float var56 = (float)(var2.w[var48] - var2.w[var49]);
         float var57 = var53 * var56 - var55 * var54;
         float var58 = var55 * var52 - var51 * var56;
         float var59 = var51 * var54 - var53 * var52;
         float var60 = (float)(1.0D / Math.sqrt((double)(var57 * var57 + var58 * var58 + var59 * var59)));
         var57 *= var60;
         var58 *= var60;
         var59 *= var60;
         long var61 = (long)(var3.j[var47] & 255);

         for(int var63 = 0; var63 < 3; ++var63) {
            int var65 = 0;
            switch(var63) {
            case 0:
               var65 = var48;
               break;
            case 1:
               var65 = var49;
               break;
            case 2:
               var65 = var50;
            }

            long var66 = var61 << 48 | (long)var83[var65];
            Kq264 var68 = (Kq264)Ha262.d(var46, var66);
            int var64;
            if (var68 == null) {
               Ha262.q(var46, new Kq264(var64 = var41++), var66);
            } else {
               var64 = var68.g;
            }

            var86[var64] += var57;
            var44[var64] += var58;
            var45[var64] += var59;
            int var10002 = var85[var64]++;
         }
      }

      for(var47 = 0; var47 < var41; ++var47) {
         if (var85[var47] > 1) {
            float var88 = (float)(1.0D / Math.sqrt((double)(var86[var47] * var86[var47] + var44[var47] * var44[var47] + var45[var47] * var45[var47])));
            var86[var47] *= var88;
            var44[var47] *= var88;
            var45[var47] *= var88;
         }
      }

      Ha262 var87 = new Ha262(Jz233.e(var76));
      var48 = 0;
      var49 = 0;

      for(var50 = 0; var50 < var3.g; ++var50) {
         int var89 = 0;
         int var90 = 0;
         int var91 = var3.d[var50] & '\uffff';
         long var92 = (long)(var3.j[var50] & 255);

         for(int var93 = 0; var93 < 3; ++var93) {
            int var95 = 0;
            switch(var93) {
            case 0:
               var95 = var3.e[var50] & '\uffff';
               break;
            case 1:
               var95 = var3.h[var50] & '\uffff';
               break;
            case 2:
               var95 = var3.s[var50] & '\uffff';
            }

            long var96 = var92 << 48 | (long)var83[var95];
            Kq264 var97 = (Kq264)Ha262.d(var46, var96);
            int var62 = var97.g;
            long var98 = (long)var91 << 32 | (long)(var62 << 16) | (long)var95;
            Kq264 var100 = (Kq264)Ha262.d(var87, var98);
            int var94;
            if (var100 != null) {
               var94 = var100.g;
            } else {
               var100 = new Kq264(var94 = var49++);
               Kc180.v(var82, (float)var2.b[var95] * q / var2.n);
               var82 += 4L;
               Kc180.v(var82, (float)var2.l[var95] * q / var2.n);
               var82 += 4L;
               Kc180.v(var82, (float)var2.w[var95] * q / var2.n);
               var82 += 4L;
               float var99 = (float)var2.r[var95] / 2048.0F;
               float var67 = 1.0F - (float)var2.v[var95] / 2048.0F;
               if (var99 <= -16.0F || var67 <= -16.0F || var99 >= 16.0F || var67 >= 16.0F) {
                  logger.info("Texcoords exceed compressable range! {},{}", var99, var67);
               }

               Kc180.w(var82, h(var99));
               var82 += 2L;
               Kc180.w(var82, h(var67));
               var82 += 2L;
               byte var101 = 0;
               int var102 = var101 | ((int)((var86[var62] * 0.5F + 0.5F) * 255.0F) & 255) << 0;
               var102 |= ((int)((var44[var62] * 0.5F + 0.5F) * 255.0F) & 255) << 8;
               var102 |= ((int)((var45[var62] * 0.5F + 0.5F) * 255.0F) & 255) << 16;
               Kc180.r(var82, var102);
               var82 += 4L;
               int var70;
               int var71;
               if (var8) {
                  O546 var69 = var37[var95];

                  for(var70 = 0; var70 < var69.g; ++var70) {
                     Kc180.b(var82, var69.d[var70]);
                     ++var82;
                  }

                  while(var70 < 4) {
                     Kc180.b(var82, (byte)0);
                     ++var82;
                     ++var70;
                  }

                  for(var71 = 0; var71 < var69.g; ++var71) {
                     Kc180.b(var82, (byte)((int)(var69.q[var71] * 255.0F)));
                     ++var82;
                  }

                  while(var71 < 4) {
                     Kc180.b(var82, (byte)0);
                     ++var82;
                     ++var71;
                  }
               }

               if (w) {
                  int var103 = Gy491.j[var91] >> 16 & 255;
                  var70 = Gy491.j[var91] >> 8 & 255;
                  var71 = Gy491.j[var91] >> 0 & 255;
                  Kc180.r(var82, -16777216 | var103 << 0 | var70 << 8 | var71 << 16);
                  var82 += 4L;
               }

               Ha262.q(var87, var100, var98);
            }

            if (var93 >= 2) {
               Kc180.w(var31, (short)var89);
               var31 += 2L;
               Kc180.w(var31, (short)var90);
               var31 += 2L;
               Kc180.w(var31, (short)var94);
               var31 += 2L;
               var48 += 3;
            } else if (var93 == 0) {
               var89 = var94;
            }

            var90 = var94;
         }
      }

      Kc180.r(var81, var49);
      if (var49 != var76) {
         Kc180.j(var31, var10 + (long)(var22 * var49), var48 * 2);
      }

      var7.g = var0;
      var7.d = (int)(var82 + (long)(var48 * 2) - var0);
      var7.j = var21;
      var7.q = var8;
      return var7;
   }

   public static float j(float var0) {
      float var1 = var0 / (float)H149.p * 2.0F - 1.0F;
      return var1;
   }

   public static short h(float var0) {
      return (short)((int)(var0 * 2048.0F));
   }

   public static Bn279 s(Set var0, Hi86 var1, int var2) {
      return !var0.isEmpty() ? Hi86.s(var1, N105.class, Fk353.class, var0, r, var2, (Bv351)null, (Object)null) : null;
   }

   public static float e(float var0) {
      float var1 = (1.0F - var0 / (float)H149.x) * 2.0F - 1.0F;
      return var1;
   }

   public static N105 d(Fk353[] var0, Hi86 var1) {
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      boolean var5 = false;
      Fk353[] var6 = var0;
      int var7 = var0.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         Fk353 var9 = var6[var8];
         var5 |= var9.y != null;
         var4 += var9.t;
         var3 += var9.m;
         var2 += var9.u;
      }

      N105 var14 = new N105(var1, var2, var5, 1048576 + var4 * 32 + var3 * 2);
      long var15 = N105.j(var14);
      int var16 = 0;

      for(int var10 = 0; var10 < var0.length; ++var10) {
         Fk353 var11 = var0[var10];

         for(int var12 = 0; var12 < var11.u; ++var12) {
            Aq544 var13 = q(var15, var11, var11.z[var12], var1, (Map)null, (Map)null);
            var15 += (long)var13.d;
            N105.h(var14, var16++, var13);
         }
      }

      return var14;
   }
}
