package tfu;

import jaclib.hardware_info.HardwareInfo;
import java.util.HashMap;

public class Fr156 extends Ln265 {
   public static final int aa = 0;
   public static final int ag = 3;
   public static final int ap = 0;
   public static final int aq = 4;
   public static final int c = 2;
   private static final boolean d = false;
   public static final int e = 2;
   public static final int f = 1;
   private static final boolean g = true;
   public static final int h = 3;
   public static final int i = 22;
   public static final int j = 1;
   public static final int k = 21;
   public static final int m = 9;
   public static final int n = 20;
   public static final int o = 23;
   public static final int p = 4;
   private static final int q = 6;
   public static final int r = 1;
   public static final int s = 4;
   public static final int t = 8;
   public static final int u = 6;
   public static final int v = 2;
   public static final int w = 0;
   public static final int x = 5;
   public static final int y = 3;
   public static final int z = 7;
   public int a;
   public String ab;
   public String ac;
   public int ad;
   public int af;
   public int ah;
   public int ai;
   public String aj;
   public String ak;
   public int al;
   public int am;
   public int an;
   public int ao;
   public int ar;
   public String as;
   public String at;
   public int au;
   public int av;
   public int aw;
   public int ax;
   public int[] ay = new int[3];
   public boolean az;
   public int b;
   public boolean l;

   public Fr156() {
   }

   public static void d(Fr156 var0, Gg3 var1) {
      Gg3.k(var1, 6);
      Gg3.k(var1, var0.b);
      Gg3.k(var1, var0.l ? 1 : 0);
      Gg3.k(var1, var0.a);
      Gg3.k(var1, var0.ai);
      Gg3.k(var1, var0.al);
      Gg3.k(var1, var0.af);
      Gg3.k(var1, var0.av);
      Gg3.k(var1, var0.az ? 1 : 0);
      Gg3.i(var1, var0.ah);
      Gg3.k(var1, var0.ao);
      Gg3.o(var1, var0.an);
      Gg3.i(var1, var0.am);
      var1.ap(var0.as);
      var1.ap(var0.ac);
      var1.ap(var0.at);
      var1.ap(var0.ab);
      Gg3.k(var1, var0.ar);
      Gg3.i(var1, var0.aw);
      var1.ap(var0.aj);
      var1.ap(var0.ak);
      Gg3.k(var1, var0.ax);
      Gg3.k(var1, var0.au);

      for(int var2 = 0; var2 < var0.ay.length; ++var2) {
         Gg3.a(var1, var0.ay[var2]);
      }

      Gg3.a(var1, var0.ad);
   }

   public Fr156(Gg3 var1) {
      int var2 = Gg3.ar(var1);
      if (var2 > 6) {
         throw new RuntimeException("Invalid userstats version: " + var2);
      } else {
         this.b = Gg3.ar(var1);
         this.l = Gg3.ar(var1) == 1;
         if (var2 > 2) {
            this.a = Gg3.ar(var1);
         }

         this.ai = Gg3.ar(var1);
         this.al = Gg3.ar(var1);
         this.af = Gg3.ar(var1);
         if (var2 > 1) {
            this.av = Gg3.ar(var1);
         }

         this.az = Gg3.ar(var1) == 1;
         this.ah = Gg3.au(var1);
         this.ao = Gg3.ar(var1);
         this.an = Gg3.ay(var1);
         if (var2 == 3) {
            Gg3.bd(var1);
         }

         if (var2 > 3) {
            this.am = Gg3.au(var1);
            if (var2 <= 5) {
               Gg3.ar(var1);
               Gg3.ar(var1);
               Gg3.ar(var1);
            }

            this.as = var1.bh();
            this.ac = var1.bh();
            this.at = var1.bh();
            this.ab = var1.bh();
            this.ar = Gg3.ar(var1);
            this.aw = Gg3.au(var1);
         } else {
            this.as = this.ac = this.at = this.ab = "";
         }

         if (var2 > 5) {
            this.aj = var1.bh();
            this.ak = var1.bh();
            this.ax = Gg3.ar(var1);
            this.au = Gg3.ar(var1);

            for(int var3 = 0; var3 < this.ay.length; ++var3) {
               this.ay[var3] = Gg3.bd(var1);
            }

            this.ad = Gg3.bd(var1);
         } else {
            this.aj = this.ak = "";
         }

         g(this);
      }
   }

   private static void g(Fr156 var0) {
      if (var0.as.length() > 40) {
         var0.as = var0.as.substring(0, 40);
      }

      if (var0.ac.length() > 40) {
         var0.ac = var0.ac.substring(0, 40);
      }

      if (var0.at.length() > 10) {
         var0.at = var0.at.substring(0, 10);
      }

      if (var0.ab.length() > 10) {
         var0.ab = var0.ab.substring(0, 10);
      }

   }

   public Fr156(boolean var1) {
      if (var1) {
         if (Dl463.bc.startsWith("win")) {
            this.b = 1;
         } else if (Dl463.bc.startsWith("mac")) {
            this.b = 2;
         } else if (Dl463.bc.startsWith("linux")) {
            this.b = 3;
         } else {
            this.b = 4;
         }

         if (!Dl463.bs.startsWith("amd64") && !Dl463.bs.startsWith("x86_64")) {
            this.l = false;
         } else {
            this.l = true;
         }

         if (this.b == 1) {
            if (Dl463.cw.indexOf("4.0") != -1) {
               this.a = 1;
            } else if (Dl463.cw.indexOf("4.1") != -1) {
               this.a = 2;
            } else if (Dl463.cw.indexOf("4.9") != -1) {
               this.a = 3;
            } else if (Dl463.cw.indexOf("5.0") != -1) {
               this.a = 4;
            } else if (Dl463.cw.indexOf("5.1") != -1) {
               this.a = 5;
            } else if (Dl463.cw.indexOf("5.2") != -1) {
               this.a = 8;
            } else if (Dl463.cw.indexOf("6.0") != -1) {
               this.a = 6;
            } else if (Dl463.cw.indexOf("6.1") != -1) {
               this.a = 7;
            } else if (Dl463.cw.indexOf("6.2") != -1) {
               this.a = 9;
            }
         } else if (this.b == 2) {
            if (Dl463.cw.indexOf("10.4") != -1) {
               this.a = 20;
            } else if (Dl463.cw.indexOf("10.5") != -1) {
               this.a = 21;
            } else if (Dl463.cw.indexOf("10.6") != -1) {
               this.a = 22;
            } else if (Dl463.cw.indexOf("10.7") != -1) {
               this.a = 23;
            }
         }

         if (Dl463.bt.toLowerCase().indexOf("sun") != -1) {
            this.ai = 1;
         } else if (Dl463.bt.toLowerCase().indexOf("microsoft") != -1) {
            this.ai = 2;
         } else if (Dl463.bt.toLowerCase().indexOf("apple") != -1) {
            this.ai = 3;
         } else {
            this.ai = 4;
         }

         int var2 = 2;
         int var3 = 0;

         char var4;
         try {
            while(var2 < Dl463.bz.length()) {
               var4 = Dl463.bz.charAt(var2);
               if (var4 < '0' || var4 > '9') {
                  break;
               }

               var3 = var3 * 10 + (var4 - 48);
               ++var2;
            }
         } catch (Exception var18) {
         }

         this.al = var3;
         var2 = Dl463.bz.indexOf(46, 2) + 1;
         var3 = 0;

         try {
            while(var2 < Dl463.bz.length()) {
               var4 = Dl463.bz.charAt(var2);
               if (var4 < '0' || var4 > '9') {
                  break;
               }

               var3 = var3 * 10 + (var4 - 48);
               ++var2;
            }
         } catch (Exception var17) {
         }

         this.af = var3;
         var2 = Dl463.bz.indexOf(95, 4) + 1;
         var3 = 0;

         try {
            while(var2 < Dl463.bz.length()) {
               var4 = Dl463.bz.charAt(var2);
               if (var4 < '0' || var4 > '9') {
                  break;
               }

               var3 = var3 * 10 + (var4 - 48);
               ++var2;
            }
         } catch (Exception var16) {
         }

         this.av = var3;
         this.az = false;
         this.ah = Dl463.bb;
         if (this.al > 3) {
            this.ao = Dl463.ba;
         } else {
            this.ao = 0;
         }

         try {
            int[] var19 = HardwareInfo.getCPUInfo();
            if (var19 != null && var19.length == 3) {
               this.ax = var19[0];
               this.am = var19[1];
               this.an = var19[2];
            }

            int[] var5 = HardwareInfo.getRawCPUInfo();
            int var7;
            int var9;
            int var10;
            int var11;
            if (var5 != null) {
               int var10000 = var5.length;
               boolean var10001 = true;
               HashMap var6 = new HashMap();

               for(var7 = 0; var7 < var5.length / 5; ++var7) {
                  int var8 = var5[var7 * 5];
                  var9 = var5[var7 * 5 + 1];
                  var10 = var5[var7 * 5 + 2];
                  var11 = var5[var7 * 5 + 3];
                  int var12 = var5[var7 * 5 + 4];
                  Ft464 var13 = new Ft464(var8, var9, var10, var11, var12);
                  var6.put(var8, var13);
               }

               Ft464 var21 = (Ft464)var6.get(0);
               if (var21 != null) {
                  Gg3 var22 = new Gg3(13);
                  Gg3.f(var22, var21.q);
                  Gg3.f(var22, var21.e);
                  Gg3.f(var22, var21.j);
                  var22.v = 0;
                  this.aj = Gg3.bk(var22);
               }

               Ft464 var24 = (Ft464)var6.get(1);
               if (var24 != null) {
                  this.ad = var24.d;
                  var9 = var24.q;
                  this.au = var9 >> 16 & 255;
                  this.ay[0] = var24.j;
                  this.ay[1] = var24.e;
               }

               Ft464 var26 = (Ft464)var6.get(-2147483647);
               if (var26 != null) {
                  this.ay[2] = var26.e;
               }

               Gg3 var28 = new Gg3(49);

               for(var11 = -2147483646; var11 <= -2147483644; ++var11) {
                  Ft464 var30 = (Ft464)var6.get(var11);
                  if (var30 != null) {
                     Gg3.f(var28, var30.d);
                     Gg3.f(var28, var30.q);
                     Gg3.f(var28, var30.j);
                     Gg3.f(var28, var30.e);
                  }
               }

               var28.v = 0;
               this.ak = Gg3.bk(var28);
            }

            String[][] var20 = HardwareInfo.getDXDiagDisplayDevicesProps();
            String var25;
            if (var20 != null && var20.length > 0 && var20[0] != null) {
               for(var7 = 0; var7 < var20[0].length; var7 += 2) {
                  if (var20[0][var7].equalsIgnoreCase("szDescription")) {
                     this.as = var20[0][var7 + 1];
                  } else if (var20[0][var7].equalsIgnoreCase("szDriverDateEnglish")) {
                     var25 = var20[0][var7 + 1];

                     try {
                        var9 = var25.indexOf("/");
                        var10 = var25.indexOf("/", var9 + 1);
                        this.ar = Integer.parseInt(var25.substring(0, var9));
                        this.aw = Integer.parseInt(var25.substring(var10 + 1, var25.indexOf(" ", var10)));
                     } catch (Exception var14) {
                     }
                  }
               }
            }

            String[] var23 = HardwareInfo.getDXDiagSystemProps();
            if (var23 != null) {
               var25 = "";
               String var27 = "";
               String var29 = "";

               for(var11 = 0; var11 < var23.length; var11 += 2) {
                  if (var23[var11].equalsIgnoreCase("dwDirectXVersionMajor")) {
                     var25 = var23[var11 + 1];
                  } else if (var23[var11].equalsIgnoreCase("dwDirectXVersionMinor")) {
                     var27 = var23[var11 + 1];
                  } else if (var23[var11].equalsIgnoreCase("dwDirectXVersionLetter")) {
                     var29 = var23[var11 + 1];
                  }
               }

               this.at = var25 + "." + var27 + var29;
            }
         } catch (Throwable var15) {
            var15.printStackTrace();
            this.an = 0;
         }
      }

      if (this.as == null) {
         this.as = "";
      }

      if (this.ac == null) {
         this.ac = "";
      }

      if (this.at == null) {
         this.at = "";
      }

      if (this.ab == null) {
         this.ab = "";
      }

      if (this.aj == null) {
         this.aj = "";
      }

      if (this.ak == null) {
         this.ak = "";
      }

      g(this);
   }

   public static int q(Fr156 var0) {
      byte var1 = 38;
      int var2 = var1 + Gg3.av(var0.as);
      var2 += Gg3.av(var0.ac);
      var2 += Gg3.av(var0.at);
      var2 += Gg3.av(var0.ab);
      var2 += Gg3.av(var0.aj);
      var2 += Gg3.av(var0.ak);
      return var2;
   }
}
