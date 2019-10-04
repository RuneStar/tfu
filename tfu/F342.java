package tfu;

import com.jagex.core.stringtools.general.J173;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.jnibindings.runetek6.Graphics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class F342 {
   public static final int b = 2;
   public static final int h = 0;
   private static String[] i = new String[100];
   public static final boolean j = false;
   private static int k = 0;
   public static final int l = 3;
   private static final Logger logger = LoggerFactory.getLogger(F342.class);
   private static int m = 0;
   private static int n = 0;
   private static int p = -1;
   public static final int r = 1;
   public static final int s = 1;
   private static int t = 0;
   private static int u = 0;
   public static final int v = 2;
   public static final int w = 0;
   private static int x = -1;
   public static final int y = 3;
   private static int z = 0;
   long d = 0L;
   protected Kj334 e;
   private byte[] o = new byte[512];
   int q = 0;

   private static void q(F342 var0, int var1, int var2) {
      p = -1;
      x = -1;
      u = var1;
      z = var1;
      n = 0;
      k = 0;
      if (var2 == -1) {
         var2 = 0;
      }

      t = var2;
      m = var2;
   }

   public static void g(F342 var0, String var1, int var2, int var3, int var4, int var5) {
      if (var1 != null) {
         q(var0, var4, var5);
         e(var0, var1, var2, var3, (A672[])null, (int[])null, (Fm462)null, 0, 0);
      }
   }

   private static void e(F342 var0, String var1, int var2, int var3, A672[] var4, int[] var5, Fm462 var6, int var7, int var8) {
      var3 -= var0.e.j;
      int var9 = -1;
      int var10 = -1;
      int var11 = var1.length();

      for(int var12 = 0; var12 < var11; ++var12) {
         char var13 = (char)(J173.g(var1.charAt(var12)) & 255);
         if (var13 == '<') {
            var9 = var12;
         } else {
            if (var13 == '>' && var9 != -1) {
               String var14 = var1.substring(var9 + 1, var12);
               var9 = -1;
               if (var14.equals("lt")) {
                  var13 = '<';
               } else if (var14.equals("gt")) {
                  var13 = '>';
               } else if (var14.equals("nbsp")) {
                  var13 = 160;
               } else if (var14.equals("shy")) {
                  var13 = 173;
               } else if (var14.equals("times")) {
                  var13 = 215;
               } else if (var14.equals("euro")) {
                  var13 = 8364;
               } else if (var14.equals("copy")) {
                  var13 = 169;
               } else {
                  if (!var14.equals("reg")) {
                     if (var14.startsWith("img=")) {
                        try {
                           int var15 = StringTools.j(var14.substring(4));
                           A672 var16 = var4[var15];
                           int var17 = var5 != null ? var5[var15] : var16.j();
                           if ((z & -16777216) == -16777216) {
                              A672.e(var16, var2, var3 + var0.e.j - var17, Fy467.PREBLEND_NORMAL, 0, Fb341.BLEND_NORMAL);
                           } else {
                              A672.e(var16, var2, var3 + var0.e.j - var17, Fy467.PREBLEND_MODULATE, z & -16777216 | 16777215, Fb341.BLEND_NORMAL);
                           }

                           var2 += var4[var15].q();
                           var10 = -1;
                        } catch (Exception var18) {
                        }
                     } else {
                        j(var0, var14);
                     }
                     continue;
                  }

                  var13 = 174;
               }
            }

            if (var9 == -1) {
               if (var10 != -1) {
                  var2 += Kj334.q(var0.e, var10, var13);
               }

               if (var13 != ' ') {
                  if (var6 == null) {
                     if ((m & -16777216) != 0) {
                        h(var0, var13, var2 + 1, var3 + 1, m, true);
                     }

                     h(var0, var13, var2, var3, z, false);
                  } else {
                     if ((m & -16777216) != 0) {
                        s(var0, var13, var2 + 1, var3 + 1, m, true, var6, var7, var8);
                     }

                     s(var0, var13, var2, var3, z, false, var6, var7, var8);
                  }
               } else if (n > 0) {
                  k += n;
                  var2 += k >> 8;
                  k &= 255;
               }

               int var19 = Kj334.j(var0.e, var13);
               var2 += var19;
               var10 = var13;
            }
         }
      }

   }

   protected static void h(F342 var0, char var1, int var2, int var3, int var4, boolean var5) {
      int var6 = var0.q / 16;
      int var7 = var0.q / 16;
      var2 += var0.o[var1 * 2];
      var3 += var0.o[var1 * 2 + 1];
      H149.s((float)var2, (float)var3, (float)(var2 + var6), (float)(var3 + var7), (float)(var1 % 16) / 16.0F, (float)(var1 / 16) / 16.0F, (float)(var1 % 16 + 1) / 16.0F, (float)(var1 / 16 + 1) / 16.0F, var0.d, var4);
   }

   protected static void s(F342 var0, char var1, int var2, int var3, int var4, boolean var5, Fm462 var6, int var7, int var8) {
   }

   public static void d(F342 var0, String var1, int var2, int var3, int var4, int var5) {
      if (var1 != null) {
         q(var0, var4, var5);
         e(var0, var1, var2 - Kj334.e(var0.e, var1), var3, (A672[])null, (int[])null, (Fm462)null, 0, 0);
      }
   }

   private static void j(F342 var0, String var1) {
      try {
         if (var1.startsWith("col=")) {
            z = z & -16777216 | StringTools.e(var1.substring(4), 16) & 16777215;
         } else if (var1.equals("/col")) {
            z = z & -16777216 | u & 16777215;
         }

         if (var1.startsWith("argb=")) {
            z = StringTools.e(var1.substring(5), 16);
         } else if (var1.equals("/argb")) {
            z = u;
         } else if (var1.startsWith("str=")) {
            p = z & -16777216 | StringTools.e(var1.substring(4), 16);
         } else if (var1.equals("str")) {
            p = z & -16777216 | 8388608;
         } else if (var1.equals("/str")) {
            p = -1;
         } else if (var1.startsWith("u=")) {
            x = z & -16777216 | StringTools.e(var1.substring(2), 16);
         } else if (var1.equals("u")) {
            x = z & -16777216;
         } else if (var1.equals("/u")) {
            x = -1;
         } else if (var1.equalsIgnoreCase("shad=-1")) {
            m = 0;
         } else if (var1.startsWith("shad=")) {
            m = z & -16777216 | StringTools.e(var1.substring(5), 16);
         } else if (var1.equals("shad")) {
            m = z & -16777216;
         } else if (var1.equals("/shad")) {
            m = t;
         } else if (var1.equals("br")) {
            q(var0, u, t);
         }
      } catch (Exception var3) {
      }

   }

   public F342(Kj334 var1, Fj373[] var2, boolean var3) {
      this.e = var1;
      int var4 = 0;

      for(int var5 = 0; var5 < 256; ++var5) {
         Fj373 var6 = var2[var5];
         if (var6.d > var4) {
            var4 = var6.d;
         }

         if (var6.g > var4) {
            var4 = var6.g;
         }
      }

      long var23 = H149.j;
      this.q = var4 * 16;
      int var12;
      int var13;
      int var14;
      int var15;
      int var17;
      int var18;
      int var24;
      Fj373 var25;
      if (var3) {
         byte[] var7 = new byte[this.q * this.q];

         int var8;
         for(var8 = 0; var8 < 256; ++var8) {
            Fj373 var9 = var2[var8];
            int var10 = var9.d;
            int var11 = var9.g;
            var12 = var8 % 16 * var4;
            var13 = var8 / 16 * var4;
            var14 = var13 * this.q + var12;
            var15 = 0;
            byte[] var16;
            if (var9.l == null) {
               var16 = var9.b;

               for(var17 = 0; var17 < var10; ++var17) {
                  for(var18 = 0; var18 < var11; ++var18) {
                     var7[var14++] = (byte)(var16[var15++] == 0 ? 0 : -1);
                  }

                  var14 += this.q - var11;
               }
            } else {
               var16 = var9.l;

               for(var17 = 0; var17 < var10; ++var17) {
                  for(var18 = 0; var18 < var11; ++var18) {
                     var7[var14++] = var16[var15++];
                  }

                  var14 += this.q - var11;
               }
            }
         }

         for(var8 = 0; var8 < var7.length; ++var8) {
            Kc180.r(var23 + (long)(var8 * 4), var7[var8] << 24 | var7[var8] << 16 | var7[var8] << 8 | var7[var8]);
         }
      } else {
         for(var24 = 0; var24 < 256; ++var24) {
            var25 = var2[var24];
            int[] var26 = var25.s;
            byte[] var27 = var25.l;
            byte[] var28 = var25.b;
            var12 = var25.d;
            var13 = var25.g;
            var14 = var24 % 16 * var4;
            var15 = var24 / 16 * var4;
            int var29 = var15 * this.q + var14;
            var17 = 0;
            int var19;
            if (var27 != null) {
               for(var18 = 0; var18 < var12; ++var18) {
                  for(var19 = 0; var19 < var13; ++var19) {
                     long var30 = var23 + (long)(var29 * 4);
                     Kc180.r(var30, var27[var17] << 24 | var26[var28[var17] & 255]);
                     ++var29;
                     ++var17;
                  }

                  var29 += this.q - var13;
               }
            } else {
               for(var18 = 0; var18 < var12; ++var18) {
                  for(var19 = 0; var19 < var13; ++var19) {
                     byte var20;
                     if ((var20 = var28[var17++]) != 0) {
                        long var21 = var23 + (long)(var29 * 4);
                        Kc180.r(var21, -16777216 | var26[var20 & 255]);
                        ++var29;
                     }
                  }

                  var29 += this.q - var13;
               }
            }
         }
      }

      this.d = Graphics.createTexture2D(21, this.q, this.q, 1, 0, var23, 1);

      for(var24 = 0; var24 < 256; ++var24) {
         var25 = var2[var24];
         this.o[var24 * 2] = (byte)var25.q;
         this.o[var24 * 2 + 1] = (byte)var25.e;
      }

   }
}
