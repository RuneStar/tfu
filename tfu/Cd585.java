package tfu;

import java.util.Arrays;

public class Cd585 {
   private static final int ag = 8;
   public static boolean ah = true;
   private static final int ai = 4;
   private static final int al = 286331153;
   private static boolean ap;
   private static final int aq = 2;
   private static int b;
   private static final int c = 3;
   private static final boolean d = false;
   private static final boolean g = true;
   public static int h;
   private static final boolean j = true;
   private static Cq640 l;
   private static final boolean q = false;
   private static final int r = 16384;
   public static boolean s;
   public static final int w = 256;
   private long a = 0L;
   private int af = 0;
   private Cx556[] av = new Cx556[8];
   private Cx556[] az = new Cx556[8];
   private boolean e = false;
   private boolean f = true;
   private int i = 0;
   private int k = 0;
   private int m;
   private long n = 0L;
   private int o = 0;
   private Cx556 p;
   private int t;
   private long u = Gz143.g();
   int[] v;
   public int x = 32;
   boolean y = false;
   private int z;

   static void w(Cd585 var0) throws Exception {
   }

   private static final void j(Cd585 var0, int var1) {
      var0.af -= var1;
      if (var0.af < 0) {
         var0.af = 0;
      }

      if (var0.p != null) {
         var0.p.e(var1);
      }

   }

   private final void e(int[] var1, int var2) {
      int var3 = var2;
      if (s) {
         var3 = var2 << 1;
      }

      Arrays.fill(var1, 0, var3, 0);
      this.af -= var2;
      if (this.p != null && this.af <= 0) {
         this.af += h >> 4;
         h(this.p);
         s(this, this.p, this.p.cd());
         int var4 = 0;
         int var5 = 255;

         int var6;
         label114:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if (var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if ((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  Cx556 var10 = null;
                  Cx556 var11 = this.av[var7];

                  label108:
                  while(true) {
                     while(true) {
                        if (var11 == null) {
                           break label108;
                        }

                        Cb633 var12 = var11.bm;
                        if (var12 != null && var12.h > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.ae;
                        } else {
                           var11.w = true;
                           int var13 = var11.q();
                           var4 += var13;
                           if (var12 != null) {
                              var12.h += var13;
                           }

                           if (var4 >= this.x) {
                              break label114;
                           }

                           Cx556 var14 = var11.g();
                           if (var14 != null) {
                              if (ap && var12 != null && var11.g() != null) {
                                 System.out.println("Warning: a pcm_stream with substreams has set its 'w' - this can cause");
                                 System.out.println("         parent duplicate demotion, and high-pri substreams will be lost!");
                                 System.out.println("         Guilty class name: " + var11.getClass().getName());
                                 ap = true;
                              }

                              for(int var15 = var11.bd; var14 != null; var14 = var11.d()) {
                                 s(this, var14, var15 * var14.cd() >> 8);
                              }
                           }

                           Cx556 var18 = var11.ae;
                           var11.ae = null;
                           if (var10 == null) {
                              this.av[var7] = var18;
                           } else {
                              var10.ae = var18;
                           }

                           if (var18 == null) {
                              this.az[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            Cx556 var16 = this.av[var6];

            Cx556 var17;
            for(this.av[var6] = this.az[var6] = null; var16 != null; var16 = var17) {
               var17 = var16.ae;
               var16.ae = null;
            }
         }
      }

      if (this.af < 0) {
         this.af = 0;
      }

      if (this.p != null) {
         this.p.j(var1, 0, var2);
      }

      this.u = Gz143.g();
   }

   private static final void h(Cx556 var0) {
      var0.w = false;
      if (var0.bm != null) {
         var0.bm.h = 0;
      }

      for(Cx556 var1 = var0.g(); var1 != null; var1 = var0.d()) {
         h(var1);
      }

   }

   private static final void s(Cd585 var0, Cx556 var1, int var2) {
      int var3 = var2 >> 5;
      Cx556 var4 = var0.az[var3];
      if (var4 == null) {
         var0.av[var3] = var1;
      } else {
         var4.ae = var1;
      }

      var0.az[var3] = var1;
      var1.bd = var2;
   }

   static void b(Cd585 var0, int var1) throws Exception {
   }

   static int l(Cd585 var0) throws Exception {
      return var0.z;
   }

   static void r(Cd585 var0) {
   }

   static void v(Cd585 var0) throws Exception {
   }

   public static final synchronized void g(Cd585 var0, Cx556 var1) {
      var0.p = var1;
   }

   public final synchronized void q() {
      this.f = true;

      try {
         v(this);
      } catch (Exception var2) {
         System.out.println("pcm_player - discardbuffer error: " + var2.getMessage());
         var2.printStackTrace();
         r(this);
         this.n = Gz143.g() + 2000L;
      }

   }
}
