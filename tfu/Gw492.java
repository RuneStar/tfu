package tfu;

public final class Gw492 {
   static final int b = 4096;
   static final int d = 1;
   static final int e = 14;
   private static final boolean g = true;
   static final int h = 0;
   static final int j = 10;
   static final int l = 16;
   static final int p = 6;
   static final int q = 2;
   static final int r = 23;
   static final int s = 4;
   private static Ge473 t = new Ge473();
   static final int u = 4;
   static final int v = 0;
   static final int w = 258;
   static final int x = 50;
   static final int y = 1;
   static final int z = 18002;

   public static int g(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      Ge473 var5 = t;
      synchronized(var5) {
         t.r = var2;
         t.v = var4;
         t.u = var0;
         t.z = 0;
         t.y = var3;
         t.t = var1;
         t.f = 0;
         t.a = 0;
         t.p = 0;
         t.x = 0;
         t.m = 0;
         t.n = 0;
         t.ag = 0;
         q(t);
         var1 -= t.t;
         t.r = null;
         t.u = null;
         return var1;
      }
   }

   private static byte j(Ge473 var0) {
      return (byte)h(8, var0);
   }

   private static byte e(Ge473 var0) {
      return (byte)h(1, var0);
   }

   private static int h(int var0, Ge473 var1) {
      while(var1.f < var0) {
         var1.a = var1.a << 8 | var1.r[var1.v] & 255;
         var1.f += 8;
         ++var1.v;
         --var1.y;
         ++var1.p;
         if (var1.p == 0) {
            ++var1.x;
         }
      }

      int var2 = var1.a >> var1.f - var0 & (1 << var0) - 1;
      var1.f -= var0;
      return var2;
   }

   private static void q(Ge473 var0) {
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      boolean var10 = false;
      boolean var11 = false;
      boolean var12 = false;
      boolean var13 = false;
      boolean var14 = false;
      boolean var15 = false;
      boolean var16 = false;
      boolean var17 = false;
      boolean var18 = false;
      boolean var19 = false;
      boolean var20 = false;
      boolean var21 = false;
      int var22 = 0;
      int[] var23 = null;
      int[] var24 = null;
      int[] var25 = null;
      var0.c = 1;
      if (Ge473.ap == null) {
         Ge473.ap = new int[var0.c * 100000];
      }

      boolean var26 = true;

      while(true) {
         while(var26) {
            byte var1 = j(var0);
            if (var1 == 23) {
               return;
            }

            var1 = j(var0);
            var1 = j(var0);
            var1 = j(var0);
            var1 = j(var0);
            var1 = j(var0);
            ++var0.ag;
            var1 = j(var0);
            var1 = j(var0);
            var1 = j(var0);
            var1 = j(var0);
            var1 = e(var0);
            if (var1 != 0) {
               var0.o = true;
            } else {
               var0.o = false;
            }

            if (var0.o) {
               System.out.println("PANIC! RANDOMISED BLOCK!");
            }

            var0.aq = 0;
            var1 = j(var0);
            var0.aq = var0.aq << 8 | var1 & 255;
            var1 = j(var0);
            var0.aq = var0.aq << 8 | var1 & 255;
            var1 = j(var0);
            var0.aq = var0.aq << 8 | var1 & 255;

            int var35;
            for(var35 = 0; var35 < 16; ++var35) {
               var1 = e(var0);
               if (var1 == 1) {
                  var0.an[var35] = true;
               } else {
                  var0.an[var35] = false;
               }
            }

            for(var35 = 0; var35 < 256; ++var35) {
               var0.aa[var35] = false;
            }

            int var36;
            for(var35 = 0; var35 < 16; ++var35) {
               if (var0.an[var35]) {
                  for(var36 = 0; var36 < 16; ++var36) {
                     var1 = e(var0);
                     if (var1 == 1) {
                        var0.aa[var35 * 16 + var36] = true;
                     }
                  }
               }
            }

            s(var0);
            int var38 = var0.ao + 2;
            int var39 = h(3, var0);
            int var40 = h(15, var0);

            for(var35 = 0; var35 < var40; ++var35) {
               var36 = 0;

               while(true) {
                  var1 = e(var0);
                  if (var1 == 0) {
                     var0.ab[var35] = (byte)var36;
                     break;
                  }

                  ++var36;
               }
            }

            byte[] var27 = new byte[6];

            byte var29;
            for(var29 = 0; var29 < var39; var27[var29] = var29++) {
            }

            for(var35 = 0; var35 < var40; ++var35) {
               var29 = var0.ab[var35];

               byte var28;
               for(var28 = var27[var29]; var29 > 0; --var29) {
                  var27[var29] = var27[var29 - 1];
               }

               var27[0] = var28;
               var0.at[var35] = var28;
            }

            int var37;
            for(var37 = 0; var37 < var39; ++var37) {
               int var49 = h(5, var0);

               for(var35 = 0; var35 < var38; ++var35) {
                  while(true) {
                     var1 = e(var0);
                     if (var1 == 0) {
                        var0.aw[var37][var35] = (byte)var49;
                        break;
                     }

                     var1 = e(var0);
                     if (var1 == 0) {
                        ++var49;
                     } else {
                        --var49;
                     }
                  }
               }
            }

            for(var37 = 0; var37 < var39; ++var37) {
               byte var2 = 32;
               byte var3 = 0;

               for(var35 = 0; var35 < var38; ++var35) {
                  if (var0.aw[var37][var35] > var3) {
                     var3 = var0.aw[var37][var35];
                  }

                  if (var0.aw[var37][var35] < var2) {
                     var2 = var0.aw[var37][var35];
                  }
               }

               b(var0.ar[var37], var0.ax[var37], var0.au[var37], var0.aw[var37], var2, var3, var38);
               var0.aj[var37] = var2;
            }

            int var41 = var0.ao + 1;
            int var42 = -1;
            byte var43 = 0;

            for(var35 = 0; var35 <= 255; ++var35) {
               var0.af[var35] = 0;
            }

            int var56 = 4095;

            int var54;
            int var55;
            for(var54 = 15; var54 >= 0; --var54) {
               for(var55 = 15; var55 >= 0; --var55) {
                  var0.as[var56] = (byte)(var54 * 16 + var55);
                  --var56;
               }

               var0.ac[var54] = var56 + 1;
            }

            int var46 = 0;
            byte var53;
            if (var43 == 0) {
               ++var42;
               var43 = 50;
               var53 = var0.at[var42];
               var22 = var0.aj[var53];
               var23 = var0.ar[var53];
               var25 = var0.au[var53];
               var24 = var0.ax[var53];
            }

            int var44 = var43 - 1;
            int var50 = var22;

            int var51;
            byte var52;
            for(var51 = h(var22, var0); var51 > var23[var50]; var51 = var51 << 1 | var52) {
               ++var50;
               var52 = e(var0);
            }

            int var45 = var25[var51 - var24[var50]];

            while(true) {
               int[] var10000;
               int var10002;
               while(var45 != var41) {
                  if (var45 != 0 && var45 != 1) {
                     int var33 = var45 - 1;
                     int var30;
                     if (var33 < 16) {
                        var30 = var0.ac[0];

                        for(var1 = var0.as[var30 + var33]; var33 > 3; var33 -= 4) {
                           int var34 = var30 + var33;
                           var0.as[var34] = var0.as[var34 - 1];
                           var0.as[var34 - 1] = var0.as[var34 - 2];
                           var0.as[var34 - 2] = var0.as[var34 - 3];
                           var0.as[var34 - 3] = var0.as[var34 - 4];
                        }

                        while(var33 > 0) {
                           var0.as[var30 + var33] = var0.as[var30 + var33 - 1];
                           --var33;
                        }

                        var0.as[var30] = var1;
                     } else {
                        int var31 = var33 / 16;
                        int var32 = var33 % 16;
                        var30 = var0.ac[var31] + var32;

                        for(var1 = var0.as[var30]; var30 > var0.ac[var31]; --var30) {
                           var0.as[var30] = var0.as[var30 - 1];
                        }

                        for(var10002 = var0.ac[var31]++; var31 > 0; --var31) {
                           var10002 = var0.ac[var31]--;
                           var0.as[var0.ac[var31]] = var0.as[var0.ac[var31 - 1] + 16 - 1];
                        }

                        var10002 = var0.ac[0]--;
                        var0.as[var0.ac[0]] = var1;
                        if (var0.ac[0] == 0) {
                           var56 = 4095;

                           for(var54 = 15; var54 >= 0; --var54) {
                              for(var55 = 15; var55 >= 0; --var55) {
                                 var0.as[var56] = var0.as[var0.ac[var54] + var55];
                                 --var56;
                              }

                              var0.ac[var54] = var56 + 1;
                           }
                        }
                     }

                     var10002 = var0.af[var0.am[var1 & 255] & 255]++;
                     Ge473.ap[var46] = var0.am[var1 & 255] & 255;
                     ++var46;
                     if (var44 == 0) {
                        ++var42;
                        var44 = 50;
                        var53 = var0.at[var42];
                        var22 = var0.aj[var53];
                        var23 = var0.ar[var53];
                        var25 = var0.au[var53];
                        var24 = var0.ax[var53];
                     }

                     --var44;
                     var50 = var22;

                     for(var51 = h(var22, var0); var51 > var23[var50]; var51 = var51 << 1 | var52) {
                        ++var50;
                        var52 = e(var0);
                     }

                     var45 = var25[var51 - var24[var50]];
                  } else {
                     int var47 = -1;
                     int var48 = 1;

                     do {
                        if (var45 == 0) {
                           var47 += 1 * var48;
                        } else if (var45 == 1) {
                           var47 += 2 * var48;
                        }

                        var48 *= 2;
                        if (var44 == 0) {
                           ++var42;
                           var44 = 50;
                           var53 = var0.at[var42];
                           var22 = var0.aj[var53];
                           var23 = var0.ar[var53];
                           var25 = var0.au[var53];
                           var24 = var0.ax[var53];
                        }

                        --var44;
                        var50 = var22;

                        for(var51 = h(var22, var0); var51 > var23[var50]; var51 = var51 << 1 | var52) {
                           ++var50;
                           var52 = e(var0);
                        }

                        var45 = var25[var51 - var24[var50]];
                     } while(var45 == 0 || var45 == 1);

                     ++var47;
                     var1 = var0.am[var0.as[var0.ac[0]] & 255];
                     var10000 = var0.af;

                     for(var10000[var1 & 255] += var47; var47 > 0; --var47) {
                        Ge473.ap[var46] = var1 & 255;
                        ++var46;
                     }
                  }
               }

               var0.i = 0;
               var0.k = 0;
               var0.az[0] = 0;

               for(var35 = 1; var35 <= 256; ++var35) {
                  var0.az[var35] = var0.af[var35 - 1];
               }

               for(var35 = 1; var35 <= 256; ++var35) {
                  var10000 = var0.az;
                  var10000[var35] += var0.az[var35 - 1];
               }

               for(var35 = 0; var35 < var46; ++var35) {
                  var1 = (byte)(Ge473.ap[var35] & 255);
                  var10000 = Ge473.ap;
                  int var10001 = var0.az[var1 & 255];
                  var10000[var10001] |= var35 << 8;
                  var10002 = var0.az[var1 & 255]++;
               }

               var0.ai = Ge473.ap[var0.aq] >> 8;
               var0.av = 0;
               var0.ai = Ge473.ap[var0.ai];
               var0.al = (byte)(var0.ai & 255);
               var0.ai >>= 8;
               ++var0.av;
               var0.ak = var46;
               d(var0);
               if (var0.av == var0.ak + 1 && var0.i == 0) {
                  var26 = true;
                  break;
               }

               var26 = false;
               break;
            }
         }

         return;
      }
   }

   private static void b(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
      int var7 = 0;

      int var8;
      for(var8 = var4; var8 <= var5; ++var8) {
         for(int var9 = 0; var9 < var6; ++var9) {
            if (var3[var9] == var8) {
               var2[var7] = var9;
               ++var7;
            }
         }
      }

      for(var8 = 0; var8 < 23; ++var8) {
         var1[var8] = 0;
      }

      for(var8 = 0; var8 < var6; ++var8) {
         ++var1[var3[var8] + 1];
      }

      for(var8 = 1; var8 < 23; ++var8) {
         var1[var8] += var1[var8 - 1];
      }

      for(var8 = 0; var8 < 23; ++var8) {
         var0[var8] = 0;
      }

      int var10 = 0;

      for(var8 = var4; var8 <= var5; ++var8) {
         var10 += var1[var8 + 1] - var1[var8];
         var0[var8] = var10 - 1;
         var10 <<= 1;
      }

      for(var8 = var4 + 1; var8 <= var5; ++var8) {
         var1[var8] = (var0[var8 - 1] + 1 << 1) - var1[var8];
      }

   }

   private static void s(Ge473 var0) {
      var0.ao = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if (var0.aa[var1]) {
            var0.am[var0.ao] = (byte)var1;
            ++var0.ao;
         }
      }

   }

   private static void d(Ge473 var0) {
      byte var2 = var0.k;
      int var3 = var0.i;
      int var4 = var0.av;
      int var5 = var0.al;
      int[] var6 = Ge473.ap;
      int var7 = var0.ai;
      byte[] var8 = var0.u;
      int var9 = var0.z;
      int var10 = var0.t;
      int var12 = var0.ak + 1;

      label64:
      while(true) {
         if (var3 > 0) {
            while(true) {
               if (var10 == 0) {
                  break label64;
               }

               if (var3 == 1) {
                  if (var10 == 0) {
                     var3 = 1;
                     break label64;
                  }

                  var8[var9] = var2;
                  ++var9;
                  --var10;
                  break;
               }

               var8[var9] = var2;
               --var3;
               ++var9;
               --var10;
            }
         }

         while(var4 != var12) {
            var2 = (byte)var5;
            var7 = var6[var7];
            byte var1 = (byte)var7;
            var7 >>= 8;
            ++var4;
            if (var1 != var5) {
               var5 = var1;
               if (var10 == 0) {
                  var3 = 1;
                  break label64;
               }

               var8[var9] = var2;
               ++var9;
               --var10;
            } else {
               if (var4 != var12) {
                  var3 = 2;
                  var7 = var6[var7];
                  var1 = (byte)var7;
                  var7 >>= 8;
                  ++var4;
                  if (var4 != var12) {
                     if (var1 != var5) {
                        var5 = var1;
                     } else {
                        var3 = 3;
                        var7 = var6[var7];
                        var1 = (byte)var7;
                        var7 >>= 8;
                        ++var4;
                        if (var4 != var12) {
                           if (var1 != var5) {
                              var5 = var1;
                           } else {
                              var7 = var6[var7];
                              var1 = (byte)var7;
                              var7 >>= 8;
                              ++var4;
                              var3 = (var1 & 255) + 4;
                              var7 = var6[var7];
                              var5 = (byte)var7;
                              var7 >>= 8;
                              ++var4;
                           }
                        }
                     }
                  }
                  continue label64;
               }

               if (var10 == 0) {
                  var3 = 1;
                  break label64;
               }

               var8[var9] = var2;
               ++var9;
               --var10;
            }
         }

         var3 = 0;
         break;
      }

      int var13 = var0.m;
      var0.m += var10 - var10;
      if (var0.m < var13) {
         ++var0.n;
      }

      var0.k = var2;
      var0.i = var3;
      var0.av = var4;
      var0.al = var5;
      Ge473.ap = var6;
      var0.ai = var7;
      var0.u = var8;
      var0.z = var9;
      var0.t = var10;
   }

   private Gw492() {
   }
}
