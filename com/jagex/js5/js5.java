package com.jagex.js5;

import com.jagex.core.stringtools.general.StringTools;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.BitSet;
import java.util.concurrent.ConcurrentHashMap;
import tfu.Ao128;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;
import tfu.Gl480;
import tfu.Gw492;
import tfu.Ls502;
import tfu.Mr366;

public final class js5 {
   public static boolean a = false;
   static final int af = 2;
   static final int ai = 0;
   static final int al = 1;
   public static int aq;
   public static int[][] c;
   static final boolean d = false;
   private static final boolean e = false;
   public static boolean f = false;
   static final boolean g = true;
   public static boolean i = true;
   static final boolean j = false;
   public static boolean k = false;
   static Ls502 l = new Ls502();
   public static int o = 0;
   public static ConcurrentHashMap p = new ConcurrentHashMap();
   static final boolean q = false;
   public static int r = 0;
   public static final int t = 2;
   public static final int u = 0;
   public static int v = 0;
   public static ConcurrentHashMap y = new ConcurrentHashMap();
   public static final int z = 1;
   public int[][][] ag;
   private Object[][] b;
   private H362 h;
   public int m;
   private S136 n;
   private Object[] s;
   public boolean w;
   public boolean x;

   public js5(DataInputStream var1, boolean var2, int var3) throws IOException {
      this((S136)(new J135(var1, false)), var2, var3);
   }

   public js5(byte[] var1, boolean var2, int var3) throws IOException {
      this((S136)(new J135(var1, false)), var2, var3);
   }

   /** @deprecated */
   public js5(S136 var1, boolean var2, boolean var3) {
      this(var1, var2, var3 ? 1 : 0);
   }

   private synchronized byte[] s(int var1, int var2, int[] var3, boolean var4) {
      if (!this.j(var1, var2)) {
         return null;
      } else {
         byte[] var5 = null;
         if (this.b[var1] == null || this.b[var1][var2] == null) {
            boolean var6 = this.k(var1, var2, var3);
            if (!var6) {
               e(this, var1);
               var6 = this.k(var1, var2, var3);
               if (!var6) {
                  if (!var4 && this.fileExists(var1, var2)) {
                     (new Ao128("File not available yet (or already requested and discarded): " + var1 + " " + var2)).printStackTrace();
                  }

                  return null;
               }
            }
         }

         if (this.b[var1] == null) {
            throw new RuntimeException("");
         } else {
            if (this.b[var1][var2] != null) {
               var5 = Gl480.d(this.b[var1][var2], false);
               if (var5 == null) {
                  throw new RuntimeException("");
               }
            }

            if (var5 != null) {
               if (this.m == 1) {
                  this.b[var1][var2] = null;
                  if (this.h.z[var1] == 1) {
                     this.b[var1] = null;
                  }
               } else if (this.m == 2) {
                  this.b[var1] = null;
               }
            }

            if (var5 != null && !this.w) {
               Long var7 = new Long((long)(this.hashCode() << 0 | var1 << 16 | var2));
               if (y.get(var7) == null) {
                  y.put(var7, new Boolean(true));
                  r += var5.length;
               }
            }

            return var5;
         }
      }
   }

   public js5(URL var1, boolean var2, int var3) throws IOException {
      this((S136)(new J135(var1, false)), var2, var3);
   }

   public js5(byte[] var1, boolean var2, int var3, boolean var4) throws IOException {
      this((S136)(new J135(var1, var4)), var2, var3);
   }

   public js5(DataInputStream var1, boolean var2, int var3, boolean var4) throws IOException {
      this((S136)(new J135(var1, var4)), var2, var3);
   }

   static final byte[] af(byte[] var0) {
      Gg3 var1 = new Gg3(var0);
      int var2 = Gg3.ar(var1);
      if (a || f) {
         aq = var2;
      }

      int var3 = Gg3.bd(var1);
      if (var3 >= 0 && (o == 0 || var3 <= o)) {
         if (var2 == 0) {
            byte[] var9 = new byte[var3];
            Gg3.bx(var1, var9, 0, var3);
            return var9;
         } else {
            int var4 = Gg3.bd(var1);
            if (var4 < 0 || o != 0 && var4 > o) {
               throw new RuntimeException("ctype=" + var2 + " clen=" + var3 + " ulen=" + var4 + " maxsize=" + o);
            } else {
               byte[] var5 = new byte[var4];
               if (var2 == 1) {
                  Gw492.g(var5, var4, var0, var3, 9);
               } else {
                  Ls502 var6 = l;
                  synchronized(var6) {
                     l.g(var1, var5);
                  }
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException("ctype=" + var2 + " clen=" + var3 + " maxsize=" + o);
      }
   }

   /** @deprecated */
   public js5(byte[] var1, boolean var2, boolean var3, boolean var4) throws IOException {
      this((S136)(new J135(var1, var4)), var2, var3);
   }

   public static void n(js5 var0, boolean var1, boolean var2) {
      if (g(var0)) {
         if (var1) {
            var0.h.s = null;
            var0.h.b = null;
         }

         if (var2) {
            var0.h.x = (int[][])null;
            var0.h.u = null;
         }

      }
   }

   /** @deprecated */
   public js5(byte[] var1, boolean var2, boolean var3) throws IOException {
      this((S136)(new J135(var1, false)), var2, var3);
   }

   /** @deprecated */
   public js5(DataInputStream var1, boolean var2, boolean var3) throws IOException {
      this((S136)(new J135(var1, false)), var2, var3);
   }

   /** @deprecated */
   public js5(File var1, boolean var2, boolean var3) throws IOException {
      this((S136)(new J135(var1, false)), var2, var3);
   }

   public js5(File var1, boolean var2, int var3) throws IOException {
      this((S136)(new J135(var1, false)), var2, var3);
   }

   /** @deprecated */
   public js5(File var1, boolean var2, boolean var3, boolean var4) throws IOException {
      this((S136)(new J135(var1, var4)), var2, var3);
   }

   /** @deprecated */
   public js5(URL var1, boolean var2, boolean var3, boolean var4) throws IOException {
      this((S136)(new J135(var1, var4)), var2, var3);
   }

   public synchronized boolean q(int var1) {
      if (!g(this)) {
         return false;
      } else if (var1 >= 0 && var1 < this.h.z.length && this.h.z[var1] != 0) {
         return true;
      } else if (k) {
         throw new IllegalArgumentException(Integer.toString(var1));
      } else {
         return false;
      }
   }

   public int d() {
      if (!g(this)) {
         throw new IllegalStateException("Index not ready");
      } else {
         return this.h.d;
      }
   }

   /** @deprecated */
   public js5(URL var1, boolean var2, boolean var3) throws IOException {
      this((S136)(new J135(var1, false)), var2, var3);
   }

   private synchronized byte[] x(int var1, boolean var2) {
      if (!g(this)) {
         return null;
      } else if (this.h.z.length == 1) {
         return this.s(0, var1, (int[])null, var2);
      } else if (!this.q(var1)) {
         return null;
      } else if (this.h.z[var1] == 1) {
         return this.s(var1, 0, (int[])null, var2);
      } else {
         throw new RuntimeException("Unable to determine if id is groupid or fileid");
      }
   }

   private static synchronized void e(js5 var0, int var1) {
      if (var0.x) {
         var0.s[var1] = var0.n.q(var1);
      } else {
         var0.s[var1] = Gl480.g(var0.n.q(var1), false);
      }

   }

   @Be2
   @Bs1
   public boolean fileExists(int var1, int var2) {
      if (!g(this)) {
         throw new IllegalStateException("Not ready");
      } else if (var1 >= 0 && var2 >= 0 && var1 < this.h.z.length && var2 < this.h.z[var1]) {
         int[] var3;
         int var4;
         int var5;
         int var6;
         if (this.h.h != null) {
            if (this.h.t == null) {
               this.h.t = new BitSet(this.h.z.length);
               var3 = this.h.h;
               var4 = var3.length;

               for(var5 = 0; var5 < var4; ++var5) {
                  var6 = var3[var5];
                  this.h.t.set(var6);
               }
            }

            if (!this.h.t.get(var1)) {
               return false;
            }
         }

         if (this.h.p[var1] != null) {
            if (this.h.m == null) {
               this.h.m = new BitSet[this.h.z.length];
            }

            if (this.h.m[var1] == null) {
               this.h.m[var1] = new BitSet(this.h.z[var1]);
               var3 = this.h.p[var1];
               var4 = var3.length;

               for(var5 = 0; var5 < var4; ++var5) {
                  var6 = var3[var5];
                  this.h.m[var1].set(var6);
               }
            }

            if (!this.h.m[var1].get(var2)) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public static synchronized boolean g(js5 var0) {
      if (var0.h == null) {
         var0.h = var0.n.d();
         if (var0.h == null) {
            return false;
         }

         var0.s = new Object[var0.h.l];
         var0.b = new Object[var0.h.l][];
      }

      return true;
   }

   /** @deprecated */
   @Deprecated
   @Be2
   @Bs1
   public byte[] getfile(int var1, int var2) {
      return this.s(var1, var2, (int[])null, i);
   }

   public static byte[] h(js5 var0, int var1, int var2) {
      return var0.s(var1, var2, (int[])null, true);
   }

   @Be2
   @Bs1
   public boolean fileIsReady(int var1, int var2) {
      if (!this.j(var1, var2)) {
         return false;
      } else {
         if (this.b[var1] == null || this.b[var1][var2] == null) {
            boolean var3 = this.k(var1, var2, (int[])null);
            if (!var3) {
               e(this, var1);
               var3 = this.k(var1, var2, (int[])null);
               if (!var3) {
                  return false;
               }
            }
         }

         if (this.b[var1] == null) {
            throw new RuntimeException("");
         } else {
            return this.b[var1][var2] != null;
         }
      }
   }

   public js5(File var1, boolean var2, int var3, boolean var4) throws IOException {
      this((S136)(new J135(var1, var4)), var2, var3);
   }

   @Be2
   public synchronized boolean requestgroupdownload(int var1) {
      if (!this.q(var1)) {
         return false;
      } else if (this.s[var1] != null) {
         return true;
      } else {
         e(this, var1);
         return this.s[var1] != null;
      }
   }

   public static synchronized boolean l(js5 var0) {
      if (!g(var0)) {
         return false;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < var0.h.h.length; ++var2) {
            int var3 = var0.h.h[var2];
            if (var0.s[var3] == null) {
               e(var0, var3);
               if (var0.s[var3] == null) {
                  var1 = false;
               }
            }
         }

         return var1;
      }
   }

   public synchronized boolean j(int var1, int var2) {
      if (!g(this)) {
         return false;
      } else if (var1 >= 0 && var2 >= 0 && var1 < this.h.z.length && var2 < this.h.z[var1]) {
         return true;
      } else if (k) {
         throw new IllegalArgumentException(var1 + " " + var2);
      } else {
         return false;
      }
   }

   public static synchronized int r(js5 var0) {
      if (!g(var0)) {
         return 0;
      } else {
         int var1 = 0;
         int var2 = 0;

         int var3;
         for(var3 = 0; var3 < var0.s.length; ++var3) {
            if (var0.h.y[var3] > 0) {
               var1 += 100;
               var2 += w(var0, var3);
            }
         }

         if (var1 == 0) {
            return 100;
         } else {
            var3 = var2 * 100 / var1;
            return var3;
         }
      }
   }

   /** @deprecated */
   @Deprecated
   public static synchronized byte[] v(js5 var0, int var1) {
      return var0.x(var1, i);
   }

   public static synchronized byte[] y(js5 var0, int var1) {
      return var0.x(var1, false);
   }

   public static synchronized byte[] p(js5 var0, int var1) {
      return var0.x(var1, true);
   }

   public static boolean i(js5 var0) {
      if (!g(var0)) {
         return false;
      } else {
         return var0.h.s != null;
      }
   }

   public static synchronized int[] u(js5 var0, int var1) {
      if (!var0.q(var1)) {
         return null;
      } else {
         int[] var2 = var0.h.p[var1];
         if (var2 == null) {
            var2 = new int[var0.h.y[var1]];

            for(int var3 = 0; var3 < var2.length; var2[var3] = var3++) {
            }
         }

         return var2;
      }
   }

   public static int z(js5 var0, int var1) {
      return !var0.q(var1) ? 0 : var0.h.z[var1];
   }

   public static boolean aq(js5 var0, String var1) {
      int var2 = var0.getgroupid("");
      return var2 != -1 ? ag(var0, "", var1) : ag(var0, var1, "");
   }

   public static synchronized void m(js5 var0) {
      if (var0.b != null) {
         for(int var1 = 0; var1 < var0.b.length; ++var1) {
            var0.b[var1] = null;
         }
      }

   }

   @Be2
   @Bs1
   public synchronized boolean requestdownload(int var1, int var2) {
      if (!this.j(var1, var2)) {
         return false;
      } else if (this.b[var1] != null && this.b[var1][var2] != null) {
         return true;
      } else if (this.s[var1] != null) {
         return true;
      } else {
         e(this, var1);
         return this.s[var1] != null;
      }
   }

   public synchronized boolean k(int var1, int var2, int[] var3) {
      if (!this.q(var1)) {
         return false;
      } else if (this.s[var1] == null) {
         return false;
      } else {
         int var4 = this.h.y[var1];
         int[] var5 = this.h.p[var1];
         if (this.b[var1] == null) {
            this.b[var1] = new Object[this.h.z[var1]];
         }

         Object[] var6 = this.b[var1];
         boolean var7 = true;

         for(int var8 = 0; var8 < var4; ++var8) {
            int var9;
            if (var5 == null) {
               var9 = var8;
            } else {
               var9 = var5[var8];
            }

            if (var6[var9] == null) {
               var7 = false;
               break;
            }
         }

         if (var7) {
            return true;
         } else {
            byte[] var21;
            if (var3 == null || var3[0] == 0 && var3[1] == 0 && var3[2] == 0 && var3[3] == 0) {
               var21 = Gl480.d(this.s[var1], false);
            } else {
               var21 = Gl480.d(this.s[var1], true);
               Gg3 var22 = new Gg3(var21);
               Gg3.bi(var22, var3, 5, var22.r.length);
            }

            if (var21 != null && !this.w) {
               Long var23 = new Long((long)(this.hashCode() << 0 | var1));
               if (p.get(var23) == null) {
                  p.put(var23, new Boolean(true));
                  v += var21.length;
               }
            }

            byte[] var24 = af(var21);
            if (this.x) {
               this.s[var1] = null;
            }

            if (f && this.ag == null) {
               this.ag = new int[this.h.l][][];
            }

            int var10;
            if (var4 > 1) {
               int var11;
               Gg3 var12;
               int var14;
               int var15;
               int var16;
               int var17;
               int var18;
               if (this.m != 2) {
                  var10 = var24.length;
                  --var10;
                  var11 = var24[var10] & 255;
                  var10 -= var4 * var11 * 4;
                  var12 = new Gg3(var24);
                  int[] var13 = new int[var4];
                  var12.v = var10;
                  if (a || f) {
                     c = new int[var6.length][var11];
                     if (f) {
                        this.ag[var1] = c;
                     }
                  }

                  for(var14 = 0; var14 < var11; ++var14) {
                     var15 = 0;

                     for(var16 = 0; var16 < var4; ++var16) {
                        var15 += Gg3.bd(var12);
                        var13[var16] += var15;
                        if (a || f) {
                           if (var5 == null) {
                              var17 = var16;
                           } else {
                              var17 = var5[var16];
                           }

                           c[var17][var14] = var15;
                        }
                     }
                  }

                  byte[][] var26 = new byte[var4][];

                  for(var15 = 0; var15 < var4; ++var15) {
                     var26[var15] = new byte[var13[var15]];
                     var13[var15] = 0;
                  }

                  var12.v = var10;
                  var15 = 0;

                  for(var16 = 0; var16 < var11; ++var16) {
                     var17 = 0;

                     for(var18 = 0; var18 < var4; ++var18) {
                        var17 += Gg3.bd(var12);
                        System.arraycopy(var24, var15, var26[var18], var13[var18], var17);
                        var13[var18] += var17;
                        var15 += var17;
                     }
                  }

                  for(var16 = 0; var16 < var4; ++var16) {
                     if (var5 == null) {
                        var17 = var16;
                     } else {
                        var17 = var5[var16];
                     }

                     if (this.m == 0) {
                        var6[var17] = Gl480.g(var26[var16], false);
                     } else {
                        var6[var17] = var26[var16];
                     }
                  }
               } else {
                  var10 = var24.length;
                  --var10;
                  var11 = var24[var10] & 255;
                  var10 -= var4 * var11 * 4;
                  var12 = new Gg3(var24);
                  int var25 = 0;
                  var14 = 0;
                  var12.v = var10;
                  if (a || f) {
                     c = new int[var6.length][var11];
                     if (f) {
                        this.ag[var1] = c;
                     }
                  }

                  for(var15 = 0; var15 < var11; ++var15) {
                     var16 = 0;

                     for(var17 = 0; var17 < var4; ++var17) {
                        var16 += Gg3.bd(var12);
                        if (var5 == null) {
                           var18 = var17;
                        } else {
                           var18 = var5[var17];
                        }

                        if (var18 == var2) {
                           var25 += var16;
                           var14 = var18;
                           if (a || f) {
                              c[var18][var15] = var16;
                           }
                        }
                     }
                  }

                  if (var25 == 0) {
                     return true;
                  }

                  byte[] var27 = new byte[var25];
                  var25 = 0;
                  var12.v = var10;
                  var16 = 0;

                  for(var17 = 0; var17 < var11; ++var17) {
                     var18 = 0;

                     for(int var19 = 0; var19 < var4; ++var19) {
                        var18 += Gg3.bd(var12);
                        int var20;
                        if (var5 == null) {
                           var20 = var19;
                        } else {
                           var20 = var5[var19];
                        }

                        if (var20 == var2) {
                           System.arraycopy(var24, var16, var27, var25, var18);
                           var25 += var18;
                        }

                        var16 += var18;
                     }
                  }

                  var6[var14] = var27;
               }
            } else {
               if (var5 == null) {
                  var10 = 0;
               } else {
                  var10 = var5[0];
               }

               if (this.m == 0) {
                  var6[var10] = Gl480.g(var24, false);
               } else {
                  var6[var10] = var24;
               }

               if (a || f) {
                  if (f) {
                     this.ag[var1] = (int[][])null;
                  }

                  c = (int[][])null;
               }
            }

            return true;
         }
      }
   }

   public static boolean ag(js5 var0, String var1, String var2) {
      if (!g(var0)) {
         return false;
      } else {
         var1 = var1.toLowerCase();
         var2 = var2.toLowerCase();
         int var3 = Mr366.g(var0.h.b, StringTools.b(var1));
         if (!var0.q(var3)) {
            return false;
         } else {
            int var4 = Mr366.g(var0.h.u[var3], StringTools.b(var2));
            return var0.requestdownload(var3, var4);
         }
      }
   }

   public static int t(js5 var0) {
      return !g(var0) ? -1 : var0.h.z.length;
   }

   @Be2
   @Bs1
   public int getfileid(int var1, String var2) {
      if (!this.q(var1)) {
         return -1;
      } else {
         var2 = var2.toLowerCase();
         int var3 = Mr366.g(this.h.u[var1], StringTools.b(var2));
         return !this.j(var1, var3) ? -1 : var3;
      }
   }

   public static boolean o(js5 var0, String var1, String var2) {
      if (!g(var0)) {
         return false;
      } else {
         var1 = var1.toLowerCase();
         var2 = var2.toLowerCase();
         int var3 = Mr366.g(var0.h.b, StringTools.b(var1));
         if (var3 < 0) {
            return false;
         } else {
            int var4 = Mr366.g(var0.h.u[var3], StringTools.b(var2));
            return var4 >= 0;
         }
      }
   }

   /** @deprecated */
   @Deprecated
   public static synchronized byte[] a(js5 var0, String var1, String var2) {
      return c(var0, var1, var2, (int[])null, i);
   }

   public static synchronized byte[] f(js5 var0, String var1, String var2) {
      return c(var0, var1, var2, (int[])null, false);
   }

   private static synchronized byte[] c(js5 var0, String var1, String var2, int[] var3, boolean var4) {
      if (!g(var0)) {
         return null;
      } else {
         var1 = var1.toLowerCase();
         var2 = var2.toLowerCase();
         int var5 = Mr366.g(var0.h.b, StringTools.b(var1));
         if (!var0.q(var5)) {
            return null;
         } else {
            int var6 = Mr366.g(var0.h.u[var5], StringTools.b(var2));
            return var0.s(var5, var6, var3, var4);
         }
      }
   }

   public js5(URL var1, boolean var2, int var3, boolean var4) throws IOException {
      this((S136)(new J135(var1, var4)), var2, var3);
   }

   public static boolean ai(js5 var0, String var1) {
      if (!g(var0)) {
         return false;
      } else {
         var1 = var1.toLowerCase();
         int var2 = Mr366.g(var0.h.b, StringTools.b(var1));
         return var0.requestgroupdownload(var2);
      }
   }

   @Be2
   @Bs1
   public boolean grouphasdata(int var1) {
      return g(this) && this.q(var1);
   }

   public static int al(js5 var0, String var1) {
      if (!g(var0)) {
         return 0;
      } else {
         var1 = var1.toLowerCase();
         int var2 = Mr366.g(var0.h.b, StringTools.b(var1));
         return w(var0, var2);
      }
   }

   static String av(byte[] var0) {
      StringBuffer var1 = new StringBuffer(var0.length * 2 + 2);
      var1.append("0x");
      byte[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         byte var5 = var2[var4];
         if (var5 >= 0 && var5 < 16) {
            var1.append("0" + StringTools.s(var5, 16, false));
         } else {
            var1.append(StringTools.s(var5 & 255, 16, false));
         }
      }

      return var1.toString();
   }

   public static synchronized int w(js5 var0, int var1) {
      if (!var0.q(var1)) {
         return 0;
      } else {
         return var0.s[var1] != null ? 100 : var0.n.w(var1);
      }
   }

   /** @deprecated */
   public js5(DataInputStream var1, boolean var2, boolean var3, boolean var4) throws IOException {
      this((S136)(new J135(var1, var4)), var2, var3);
   }

   public js5(S136 var1, boolean var2, int var3) {
      this.h = null;
      this.w = false;
      if (var3 >= 0 && var3 <= 2) {
         this.n = var1;
         this.x = var2;
         this.m = var3;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @Be2
   @Bs1
   public int getgroupid(String var1) {
      if (!g(this)) {
         return -1;
      } else {
         var1 = var1.toLowerCase();
         int var2 = Mr366.g(this.h.b, StringTools.b(var1));
         return !this.q(var2) ? -1 : var2;
      }
   }

   public synchronized boolean b(int var1) {
      if (!g(this)) {
         return false;
      } else if (this.h.z.length == 1) {
         return this.requestdownload(0, var1);
      } else if (!this.q(var1)) {
         return false;
      } else if (this.h.z[var1] == 1) {
         return this.requestdownload(var1, 0);
      } else {
         throw new RuntimeException("Unable to determine if id is groupid or fileid");
      }
   }
}
