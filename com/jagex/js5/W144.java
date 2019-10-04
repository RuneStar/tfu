package com.jagex.js5;

import java.io.IOException;
import tfu.Gg3;
import tfu.Gz143;
import tfu.Hn359;
import tfu.Hx339;

public class W144 {
   protected static final boolean d = true;
   protected static final int e = 20;
   protected static final boolean g = false;
   protected static final int h = 512;
   protected static final int j = 50;
   protected static final int q = 3;
   protected Hn359 b = new Hn359();
   protected Hn359 l = new Hn359();
   protected B360 m;
   private Hx339 n;
   protected Gg3 p = new Gg3(6);
   protected Hn359 r = new Hn359();
   protected Gg3 t = new Gg3(10);
   public volatile int u = 0;
   protected int v;
   protected Hn359 w = new Hn359();
   protected byte x = 0;
   protected long y;
   public volatile int z = 0;

   public static void h(W144 var0) {
      try {
         var0.n.h();
      } catch (Exception var2) {
      }

      var0.n = null;
      ++var0.u;
      var0.z = -1;
      var0.x = (byte)((int)(Math.random() * 255.0D + 1.0D));
   }

   public synchronized B360 g(int var1, int var2, byte var3, boolean var4) {
      long var5 = ((long)var1 << 32) + (long)var2;
      B360 var7 = new B360();
      var7.p = var5;
      var7.q = var3;
      var7.s = var4;
      if (var4) {
         if (e(this) >= 50) {
            throw new RuntimeException("Urgent list exceeded max limit of 50");
         }

         Hn359.q(this.b, var7);
      } else {
         if (j(this) >= 20) {
            throw new RuntimeException("Prefetch list exceeded max limit of 20");
         }

         Hn359.q(this.w, var7);
      }

      return var7;
   }

   public synchronized boolean s() {
      if (this.n != null) {
         long var1 = Gz143.g();
         int var3 = (int)(var1 - this.y);
         this.y = var1;
         if (var3 > 200) {
            var3 = 200;
         }

         this.v += var3;
         if (this.v > 30000) {
            try {
               this.n.h();
            } catch (Exception var16) {
            }

            this.n = null;
         }
      }

      if (this.n == null) {
         return e(this) == 0 && j(this) == 0;
      } else {
         try {
            B360 var18;
            for(var18 = (B360)Hn359.h(this.b); var18 != null; var18 = (B360)Hn359.b(this.b)) {
               this.p.v = 0;
               Gg3.k(this.p, 1);
               Gg3.c(this.p, var18.p);
               this.n.e(this.p.r, 0, this.p.r.length);
               Hn359.q(this.l, var18);
            }

            for(var18 = (B360)Hn359.h(this.w); var18 != null; var18 = (B360)Hn359.b(this.w)) {
               this.p.v = 0;
               Gg3.k(this.p, 0);
               Gg3.c(this.p, var18.p);
               this.n.e(this.p.r, 0, this.p.r.length);
               Hn359.q(this.r, var18);
            }

            for(int var19 = 0; var19 < 100; ++var19) {
               int var2 = this.n.q();
               if (var2 < 0) {
                  throw new IOException();
               }

               if (var2 == 0) {
                  break;
               }

               this.v = 0;
               byte var20 = 0;
               if (this.m == null) {
                  var20 = 10;
               } else if (this.m.d == 0) {
                  var20 = 1;
               }

               int var4;
               int var5;
               int var6;
               byte[] var10000;
               int var10001;
               Gg3 var21;
               if (var20 > 0) {
                  var4 = var20 - this.t.v;
                  if (var4 > var2) {
                     var4 = var2;
                  }

                  this.n.j(this.t.r, this.t.v, var4);
                  if (this.x != 0) {
                     for(var5 = 0; var5 < var4; ++var5) {
                        var10000 = this.t.r;
                        var10001 = this.t.v + var5;
                        var10000[var10001] ^= this.x;
                     }
                  }

                  var21 = this.t;
                  var21.v += var4;
                  if (this.t.v >= var20) {
                     if (this.m == null) {
                        this.t.v = 0;
                        var5 = Gg3.ar(this.t);
                        var6 = Gg3.bd(this.t);
                        int var7 = Gg3.ar(this.t);
                        int var8 = Gg3.bd(this.t);
                        int var9 = var7 & 127;
                        boolean var10 = (var7 & 128) != 0;
                        long var11 = ((long)var5 << 32) + (long)var6;
                        B360 var13 = null;
                        if (var10) {
                           for(var13 = (B360)Hn359.h(this.r); var13 != null && var13.p != var11; var13 = (B360)Hn359.b(this.r)) {
                           }
                        } else {
                           for(var13 = (B360)Hn359.h(this.l); var13 != null && var13.p != var11; var13 = (B360)Hn359.b(this.l)) {
                           }
                        }

                        if (var13 == null) {
                           System.out.println("Could not find matching request - archiveid:" + var5 + " groupid:" + var6 + " ctype:" + var9 + " clen:" + var8 + " xorcode:" + this.x);
                           throw new IOException();
                        }

                        int var14 = var9 == 0 ? 5 : 9;
                        this.m = var13;
                        this.m.g = new Gg3(var8 + var14 + this.m.q);
                        Gg3.k(this.m.g, var9);
                        Gg3.a(this.m.g, var8);
                        this.m.d = 10;
                        this.t.v = 0;
                     } else {
                        if (this.m.d != 0) {
                           System.out.println("Error processing incoming header!");
                           throw new IOException();
                        }

                        if (this.t.r[0] == -1) {
                           this.m.d = 1;
                           this.t.v = 0;
                        } else {
                           this.m = null;
                        }
                     }
                  }
               } else {
                  var4 = this.m.g.r.length - this.m.q;
                  var5 = 512 - this.m.d;
                  if (var5 > var4 - this.m.g.v) {
                     var5 = var4 - this.m.g.v;
                  }

                  if (var5 > var2) {
                     var5 = var2;
                  }

                  this.n.j(this.m.g.r, this.m.g.v, var5);
                  if (this.x != 0) {
                     for(var6 = 0; var6 < var5; ++var6) {
                        var10000 = this.m.g.r;
                        var10001 = this.m.g.v + var6;
                        var10000[var10001] ^= this.x;
                     }
                  }

                  var21 = this.m.g;
                  var21.v += var5;
                  B360 var22 = this.m;
                  var22.d += var5;
                  if (this.m.g.v == var4) {
                     B360.t(this.m);
                     this.m.l = false;
                     this.m = null;
                  } else if (this.m.d == 512) {
                     this.m.d = 0;
                  }
               }
            }

            return true;
         } catch (IOException var17) {
            var17.printStackTrace();

            try {
               this.n.h();
            } catch (Exception var15) {
            }

            this.n = null;
            ++this.u;
            this.z = -2;
            return e(this) == 0 && j(this) == 0;
         }
      }
   }

   public static synchronized boolean q(W144 var0) {
      return e(var0) >= 50;
   }

   public static synchronized int j(W144 var0) {
      return Hn359.l(var0.w) + Hn359.l(var0.r);
   }

   public static synchronized int e(W144 var0) {
      return Hn359.l(var0.b) + Hn359.l(var0.l);
   }

   public static void r(W144 var0) {
      if (var0.n != null) {
         try {
            var0.p.v = 0;
            Gg3.k(var0.p, 7);
            Gg3.c(var0.p, 0L);
            var0.n.e(var0.p.r, 0, var0.p.r.length);
         } catch (IOException var4) {
            var4.printStackTrace();

            try {
               var0.n.h();
            } catch (Exception var3) {
            }

            var0.n = null;
            ++var0.u;
            var0.z = -2;
         }

      }
   }

   public static void v(W144 var0) {
      if (var0.n != null) {
         var0.n.h();
      }

   }

   public static void b(W144 var0, Object var1, boolean var2) {
      if (var0.n != null) {
         try {
            var0.n.h();
         } catch (Exception var7) {
         }

         var0.n = null;
      }

      var0.n = (Hx339)var1;
      l(var0);
      w(var0, var2);
      var0.t.v = 0;
      var0.m = null;

      while(true) {
         B360 var3 = (B360)Hn359.e(var0.l);
         if (var3 == null) {
            while(true) {
               var3 = (B360)Hn359.e(var0.r);
               if (var3 == null) {
                  if (var0.x != 0) {
                     try {
                        var0.p.v = 0;
                        Gg3.k(var0.p, 4);
                        Gg3.k(var0.p, var0.x);
                        Gg3.a(var0.p, 0);
                        var0.n.e(var0.p.r, 0, var0.p.r.length);
                     } catch (IOException var6) {
                        var6.printStackTrace();

                        try {
                           var0.n.h();
                        } catch (Exception var5) {
                        }

                        var0.n = null;
                        ++var0.u;
                        var0.z = -2;
                     }
                  }

                  var0.v = 0;
                  var0.y = Gz143.g();
                  return;
               }

               Hn359.q(var0.w, var3);
            }
         }

         Hn359.q(var0.b, var3);
      }
   }

   protected static void l(W144 var0) {
      if (var0.n != null) {
         try {
            var0.p.v = 0;
            Gg3.k(var0.p, 6);
            Gg3.o(var0.p, 3);
            Gg3.i(var0.p, 0);
            var0.n.e(var0.p.r, 0, var0.p.r.length);
         } catch (IOException var4) {
            var4.printStackTrace();

            try {
               var0.n.h();
            } catch (Exception var3) {
            }

            var0.n = null;
            ++var0.u;
            var0.z = -2;
         }

      }
   }

   public static void w(W144 var0, boolean var1) {
      if (var0.n != null) {
         try {
            var0.p.v = 0;
            Gg3.k(var0.p, var1 ? 2 : 3);
            Gg3.c(var0.p, 0L);
            var0.n.e(var0.p.r, 0, var0.p.r.length);
         } catch (IOException var5) {
            var5.printStackTrace();

            try {
               var0.n.h();
            } catch (Exception var4) {
            }

            var0.n = null;
            ++var0.u;
            var0.z = -2;
         }

      }
   }

   public static void y(W144 var0) {
      if (var0.n != null) {
         var0.n.s();
      }

   }

   public static synchronized boolean d(W144 var0) {
      return j(var0) >= 20;
   }
}
