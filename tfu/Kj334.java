package tfu;

import com.jagex.core.stringtools.general.J173;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.js5.js5;

public class Kj334 {
   public static final boolean g = false;
   private static String[] l = new String[100];
   public int b;
   private byte[] d;
   public int e;
   public int h;
   public int j;
   private byte[][] q;
   public int s;

   private Kj334(byte[] var1) {
      Gg3 var2 = new Gg3(var1);
      int var3 = Gg3.ar(var2);
      if (var3 != 0) {
         throw new RuntimeException("");
      } else {
         boolean var4 = Gg3.ar(var2) == 1;
         this.d = new byte[256];
         Gg3.bx(var2, this.d, 0, 256);
         if (var4) {
            int[] var5 = new int[256];
            int[] var6 = new int[256];

            int var7;
            for(var7 = 0; var7 < 256; ++var7) {
               var5[var7] = Gg3.ar(var2);
            }

            for(var7 = 0; var7 < 256; ++var7) {
               var6[var7] = Gg3.ar(var2);
            }

            byte[][] var12 = new byte[256][];

            int var10;
            for(int var8 = 0; var8 < 256; ++var8) {
               var12[var8] = new byte[var5[var8]];
               byte var9 = 0;

               for(var10 = 0; var10 < var12[var8].length; ++var10) {
                  var9 += Gg3.ax(var2);
                  var12[var8][var10] = var9;
               }
            }

            byte[][] var13 = new byte[256][];

            int var14;
            for(var14 = 0; var14 < 256; ++var14) {
               var13[var14] = new byte[var5[var14]];
               byte var15 = 0;

               for(int var11 = 0; var11 < var13[var14].length; ++var11) {
                  var15 += Gg3.ax(var2);
                  var13[var14][var11] = var15;
               }
            }

            this.q = new byte[256][256];

            for(var14 = 0; var14 < 256; ++var14) {
               if (var14 != 32 && var14 != 160) {
                  for(var10 = 0; var10 < 256; ++var10) {
                     if (var10 != 32 && var10 != 160) {
                        this.q[var14][var10] = (byte)d(var12, var13, var6, this.d, var5, var14, var10);
                     }
                  }
               }
            }

            this.j = var6[32] + var5[32];
         } else {
            this.j = Gg3.ar(var2);
         }

         this.s = Gg3.ar(var2);
         this.b = Gg3.ar(var2);
         this.e = Gg3.ar(var2);
         this.h = Gg3.ar(var2);
      }
   }

   public static Kj334 g(js5 var0, int var1) {
      byte[] var2 = js5.v(var0, var1);
      return var2 == null ? null : new Kj334(var2);
   }

   public static int j(Kj334 var0, int var1) {
      return var0.d[var1] & 255;
   }

   static int d(byte[][] var0, byte[][] var1, int[] var2, byte[] var3, int[] var4, int var5, int var6) {
      int var7 = var2[var5];
      int var8 = var7 + var4[var5];
      int var9 = var2[var6];
      int var10 = var9 + var4[var6];
      int var11 = var7;
      if (var9 > var7) {
         var11 = var9;
      }

      int var12 = var8;
      if (var10 < var8) {
         var12 = var10;
      }

      int var13 = var3[var5] & 255;
      if ((var3[var6] & 255) < var13) {
         var13 = var3[var6] & 255;
      }

      byte[] var14 = var1[var5];
      byte[] var15 = var0[var6];
      int var16 = var11 - var7;
      int var17 = var11 - var9;

      for(int var18 = var11; var18 < var12; ++var18) {
         int var19 = var14[var16++] + var15[var17++];
         if (var19 < var13) {
            var13 = var19;
         }
      }

      return -var13;
   }

   public Kj334(byte[] var1, byte[][] var2, int var3, int var4, int var5, int var6, int var7) {
      this.d = var1;
      this.q = var2;
      this.j = var3;
      this.e = var4;
      this.h = var5;
      this.s = var6;
      this.b = var7;
   }

   public static int e(Kj334 var0, String var1) {
      return h(var0, var1, (Km535[])null);
   }

   public static int h(Kj334 var0, String var1, Km535[] var2) {
      if (var1 == null) {
         return 0;
      } else {
         int var3 = -1;
         int var4 = -1;
         int var5 = 0;
         int var6 = var1.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var1.charAt(var7);
            if (var8 == '<') {
               var3 = var7;
            } else {
               if (var8 == '>' && var3 != -1) {
                  String var9 = var1.substring(var3 + 1, var7);
                  var3 = -1;
                  if (var9.equals("lt")) {
                     var8 = '<';
                  } else if (var9.equals("gt")) {
                     var8 = '>';
                  } else if (var9.equals("nbsp")) {
                     var8 = 160;
                  } else if (var9.equals("shy")) {
                     var8 = 173;
                  } else if (var9.equals("times")) {
                     var8 = 215;
                  } else if (var9.equals("euro")) {
                     var8 = 8364;
                  } else if (var9.equals("copy")) {
                     var8 = 169;
                  } else {
                     if (!var9.equals("reg")) {
                        if (var9.startsWith("img=") && var2 != null) {
                           try {
                              int var10 = StringTools.j(var9.substring(4));
                              var5 += var2[var10].q();
                              var4 = -1;
                           } catch (Exception var11) {
                           }
                        }
                        continue;
                     }

                     var8 = 174;
                  }
               }

               if (var3 == -1) {
                  var5 += var0.d[J173.g(var8) & 255] & 255;
                  if (var0.q != null && var4 != -1) {
                     var5 += var0.q[var4][var8];
                  }

                  var4 = var8;
               }
            }
         }

         return var5;
      }
   }

   public static int q(Kj334 var0, int var1, char var2) {
      return var0.q != null ? var0.q[var1][var2] : 0;
   }
}
