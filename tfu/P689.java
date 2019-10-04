package tfu;

import com.jagex.js5.js5;

public class P689 extends Ln265 {
   private static final boolean g = true;
   public Ha262 d;
   byte[] q;

   public static P689 g(js5 var0, int var1, int var2) {
      byte[] var3 = var0.getfile(var1, var2);
      return var3 == null ? null : new P689(new Gg3(var3));
   }

   public P689(Gg3 var1) {
      var1.v = var1.r.length - 3;
      int var2 = Gg3.ar(var1);
      int var3 = Gg3.au(var1);
      int var4 = 14 + var2 * 10;
      var1.v = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;
      int var12 = 0;

      int var13;
      int var14;
      int var15;
      for(var13 = 0; var13 < var2; ++var13) {
         var14 = -1;

         while(true) {
            var15 = Gg3.ar(var1);
            if (var15 != var14) {
               ++var4;
            }

            var14 = var15 & 15;
            if (var15 == 7) {
               break;
            }

            if (var15 == 23) {
               ++var5;
            } else if (var14 == 0) {
               ++var7;
            } else if (var14 == 1) {
               ++var8;
            } else if (var14 == 2) {
               ++var6;
            } else if (var14 == 3) {
               ++var9;
            } else if (var14 == 4) {
               ++var10;
            } else if (var14 == 5) {
               ++var11;
            } else {
               if (var14 != 6) {
                  throw new RuntimeException("Unrecognised status " + var15);
               }

               ++var12;
            }
         }
      }

      var4 += 5 * var5;
      var4 += 2 * (var7 + var8 + var6 + var9 + var11);
      var4 += var10 + var12;
      var13 = var1.v;
      var14 = var2 + var5 + var6 + var7 + var8 + var9 + var10 + var11 + var12;

      for(var15 = 0; var15 < var14; ++var15) {
         Gg3.bn(var1);
      }

      var4 += var1.v - var13;
      var15 = var1.v;
      int var16 = 0;
      int var17 = 0;
      int var18 = 0;
      int var19 = 0;
      int var20 = 0;
      int var21 = 0;
      int var22 = 0;
      int var23 = 0;
      int var24 = 0;
      int var25 = 0;
      int var26 = 0;
      int var27 = 0;
      int var28 = 0;

      int var29;
      for(var29 = 0; var29 < var6; ++var29) {
         var28 = var28 + Gg3.ar(var1) & 127;
         if (var28 != 0 && var28 != 32) {
            if (var28 == 1) {
               ++var16;
            } else if (var28 == 33) {
               ++var17;
            } else if (var28 == 7) {
               ++var18;
            } else if (var28 == 39) {
               ++var19;
            } else if (var28 == 10) {
               ++var20;
            } else if (var28 == 42) {
               ++var21;
            } else if (var28 == 99) {
               ++var22;
            } else if (var28 == 98) {
               ++var23;
            } else if (var28 == 101) {
               ++var24;
            } else if (var28 == 100) {
               ++var25;
            } else if (var28 != 64 && var28 != 65 && var28 != 120 && var28 != 121 && var28 != 123) {
               ++var27;
            } else {
               ++var26;
            }
         } else {
            ++var12;
         }
      }

      var29 = 0;
      int var30 = var1.v;
      var1.v += var26;
      int var31 = var1.v;
      var1.v += var11;
      int var32 = var1.v;
      var1.v += var10;
      int var33 = var1.v;
      var1.v += var9;
      int var34 = var1.v;
      var1.v += var16;
      int var35 = var1.v;
      var1.v += var18;
      int var36 = var1.v;
      var1.v += var20;
      int var37 = var1.v;
      var1.v += var7 + var8 + var11;
      int var38 = var1.v;
      var1.v += var7;
      int var39 = var1.v;
      var1.v += var27;
      int var40 = var1.v;
      var1.v += var8;
      int var41 = var1.v;
      var1.v += var17;
      int var42 = var1.v;
      var1.v += var19;
      int var43 = var1.v;
      var1.v += var21;
      int var44 = var1.v;
      var1.v += var12;
      int var45 = var1.v;
      var1.v += var9;
      int var46 = var1.v;
      var1.v += var22;
      int var47 = var1.v;
      var1.v += var23;
      int var48 = var1.v;
      var1.v += var24;
      int var49 = var1.v;
      var1.v += var25;
      int var50 = var1.v;
      var1.v += var5 * 3;
      if (var1.v != var1.r.length - 3) {
         throw new RuntimeException("Chunk lengths added up wrong");
      } else {
         this.q = new byte[var4];
         Gg3 var51 = new Gg3(this.q);
         Gg3.a(var51, 1297377380);
         Gg3.a(var51, 6);
         Gg3.i(var51, var2 > 1 ? 1 : 0);
         Gg3.i(var51, var2);
         Gg3.i(var51, var3);
         var1.v = var13;
         int var52 = 0;
         int var53 = 0;
         int var54 = 0;
         int var55 = 0;
         int var56 = 0;
         int var57 = 0;
         int var58 = 0;
         int[] var59 = new int[128];
         var28 = 0;

         label229:
         for(int var60 = 0; var60 < var2; ++var60) {
            Gg3.a(var51, 1297379947);
            var51.v += 4;
            int var61 = var51.v;
            int var62 = -1;

            while(true) {
               while(true) {
                  int var63 = Gg3.bn(var1);
                  Gg3.ab(var51, var63);
                  int var64 = var1.r[var29++] & 255;
                  boolean var65 = var64 != var62;
                  var62 = var64 & 15;
                  if (var64 == 7) {
                     if (var65) {
                        Gg3.k(var51, 255);
                     }

                     Gg3.k(var51, 47);
                     Gg3.k(var51, 0);
                     Gg3.am(var51, var51.v - var61);
                     continue label229;
                  }

                  if (var64 == 23) {
                     if (var65) {
                        Gg3.k(var51, 255);
                     }

                     Gg3.k(var51, 81);
                     Gg3.k(var51, 3);
                     Gg3.k(var51, var1.r[var50++]);
                     Gg3.k(var51, var1.r[var50++]);
                     Gg3.k(var51, var1.r[var50++]);
                  } else {
                     var52 ^= var64 >> 4;
                     if (var62 == 0) {
                        if (var65) {
                           Gg3.k(var51, 144 + var52);
                        }

                        var53 += var1.r[var37++];
                        var54 += var1.r[var38++];
                        Gg3.k(var51, var53 & 127);
                        Gg3.k(var51, var54 & 127);
                     } else if (var62 == 1) {
                        if (var65) {
                           Gg3.k(var51, 128 + var52);
                        }

                        var53 += var1.r[var37++];
                        var55 += var1.r[var40++];
                        Gg3.k(var51, var53 & 127);
                        Gg3.k(var51, var55 & 127);
                     } else if (var62 == 2) {
                        if (var65) {
                           Gg3.k(var51, 176 + var52);
                        }

                        var28 = var28 + var1.r[var15++] & 127;
                        Gg3.k(var51, var28);
                        byte var66;
                        if (var28 != 0 && var28 != 32) {
                           if (var28 == 1) {
                              var66 = var1.r[var34++];
                           } else if (var28 == 33) {
                              var66 = var1.r[var41++];
                           } else if (var28 == 7) {
                              var66 = var1.r[var35++];
                           } else if (var28 == 39) {
                              var66 = var1.r[var42++];
                           } else if (var28 == 10) {
                              var66 = var1.r[var36++];
                           } else if (var28 == 42) {
                              var66 = var1.r[var43++];
                           } else if (var28 == 99) {
                              var66 = var1.r[var46++];
                           } else if (var28 == 98) {
                              var66 = var1.r[var47++];
                           } else if (var28 == 101) {
                              var66 = var1.r[var48++];
                           } else if (var28 == 100) {
                              var66 = var1.r[var49++];
                           } else if (var28 != 64 && var28 != 65 && var28 != 120 && var28 != 121 && var28 != 123) {
                              var66 = var1.r[var39++];
                           } else {
                              var66 = var1.r[var30++];
                           }
                        } else {
                           var66 = var1.r[var44++];
                        }

                        int var67 = var66 + var59[var28];
                        var59[var28] = var67;
                        Gg3.k(var51, var67 & 127);
                     } else if (var62 == 3) {
                        if (var65) {
                           Gg3.k(var51, 224 + var52);
                        }

                        var56 += var1.r[var45++];
                        var56 += var1.r[var33++] << 7;
                        Gg3.k(var51, var56 & 127);
                        Gg3.k(var51, var56 >> 7 & 127);
                     } else if (var62 == 4) {
                        if (var65) {
                           Gg3.k(var51, 208 + var52);
                        }

                        var57 += var1.r[var32++];
                        Gg3.k(var51, var57 & 127);
                     } else if (var62 == 5) {
                        if (var65) {
                           Gg3.k(var51, 160 + var52);
                        }

                        var53 += var1.r[var37++];
                        var58 += var1.r[var31++];
                        Gg3.k(var51, var53 & 127);
                        Gg3.k(var51, var58 & 127);
                     } else {
                        if (var62 != 6) {
                           throw new RuntimeException("Unrecognised status " + var64);
                        }

                        if (var65) {
                           Gg3.k(var51, 192 + var52);
                        }

                        Gg3.k(var51, var1.r[var44++]);
                     }
                  }
               }
            }
         }

         if (var51.v != var51.r.length) {
            throw new RuntimeException(".mid size calculation was wrong");
         }
      }
   }

   public P689(byte[] var1) {
      this.q = var1;
   }

   public static void q(P689 var0) {
      var0.d = null;
   }

   public void d() {
      if (this.d == null) {
         this.d = new Ha262(16);
         int[] var1 = new int[16];
         int[] var2 = new int[16];
         var1[9] = var2[9] = 128;
         Z693 var3 = new Z693(this.q);
         int var4 = Z693.j(var3);

         int var5;
         for(var5 = 0; var5 < var4; ++var5) {
            Z693.e(var3, var5);
            Z693.b(var3, var5);
            Z693.h(var3, var5);
         }

         label53:
         do {
            while(true) {
               var5 = Z693.y(var3);
               int var6 = var3.s[var5];

               while(var3.s[var5] == var6) {
                  Z693.e(var3, var5);
                  int var7 = var3.l(var5);
                  if (var7 == 1) {
                     Z693.s(var3);
                     Z693.h(var3, var5);
                     continue label53;
                  }

                  int var8 = var7 & 240;
                  int var9;
                  int var10;
                  int var11;
                  if (var8 == 176) {
                     var9 = var7 & 15;
                     var10 = var7 >> 8 & 127;
                     var11 = var7 >> 16 & 127;
                     if (var10 == 0) {
                        var1[var9] = (var1[var9] & -2080769) + (var11 << 14);
                     }

                     if (var10 == 32) {
                        var1[var9] = (var1[var9] & -16257) + (var11 << 7);
                     }
                  }

                  if (var8 == 192) {
                     var9 = var7 & 15;
                     var10 = var7 >> 8 & 127;
                     var2[var9] = var1[var9] + var10;
                  }

                  if (var8 == 144) {
                     var9 = var7 & 15;
                     var10 = var7 >> 8 & 127;
                     var11 = var7 >> 16 & 127;
                     if (var11 > 0) {
                        int var12 = var2[var9];
                        Ld263 var13 = (Ld263)Ha262.d(this.d, (long)var12);
                        if (var13 == null) {
                           var13 = new Ld263(new byte[128]);
                           Ha262.q(this.d, var13, (long)var12);
                        }

                        ((byte[])var13.g)[var10] = 1;
                     }
                  }

                  Z693.b(var3, var5);
                  Z693.h(var3, var5);
               }
            }
         } while(!Z693.p(var3));

      }
   }
}
