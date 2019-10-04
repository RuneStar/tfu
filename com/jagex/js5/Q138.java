package com.jagex.js5;

import java.util.zip.CRC32;
import tfu.Gx298;
import tfu.Gz143;
import tfu.Ha262;
import tfu.Hl134;
import tfu.Iw364;
import tfu.Ln265;

public class Q138 extends S136 {
   private static CRC32 ag = new CRC32();
   private static final int ai = 1;
   private static final int al = 2;
   private static final int aq = 0;
   private static final int c = 250;
   private static final int f = 1000;
   private static final byte r = 0;
   private static final byte v = 1;
   private static final byte y = -1;
   private long a = 0L;
   private byte[] b;
   private W144 d;
   private Hl134 e;
   private int g;
   private E361 h;
   private Gx298 i = new Gx298();
   private Hl134 j;
   private Gx298 k;
   private int l;
   private boolean m;
   private int n = 0;
   private boolean o;
   private byte[] p;
   private L145 q;
   private int s;
   private boolean t;
   public int u = 0;
   private H362 w;
   public int x = 0;
   private Ha262 z = new Ha262(16);

   public int s() {
      return this.u;
   }

   public H362 d() {
      if (this.w != null) {
         return this.w;
      } else {
         if (this.h == null) {
            if (W144.q(this.d)) {
               return null;
            }

            this.h = this.d.g(255, this.g, (byte)0, true);
         }

         if (this.h.l) {
            return null;
         } else {
            byte[] var1 = this.h.g();
            if (this.h instanceof D363) {
               try {
                  if (var1 == null) {
                     throw new RuntimeException("Index not found in disk cache");
                  }

                  this.w = new H362(var1, this.s, this.b);
                  if (this.w.j != this.l) {
                     throw new RuntimeException("Index version wrong - index.indexversion:" + this.w.j + " expected:" + this.l);
                  }
               } catch (RuntimeException var3) {
                  this.w = null;
                  if (W144.q(this.d)) {
                     this.h = null;
                  } else {
                     this.h = this.d.g(255, this.g, (byte)0, true);
                  }

                  return null;
               }
            } else {
               try {
                  if (var1 == null) {
                     throw new RuntimeException("Failed to download index from server!");
                  }

                  this.w = new H362(var1, this.s, this.b);
               } catch (RuntimeException var4) {
                  W144.h(this.d);
                  this.w = null;
                  if (W144.q(this.d)) {
                     this.h = null;
                  } else {
                     this.h = this.d.g(255, this.g, (byte)0, true);
                  }

                  return null;
               }

               if (this.e != null) {
                  this.q.j(this.g, var1, this.e);
               }
            }

            this.h = null;
            if (this.j != null) {
               this.p = new byte[this.w.l];
               this.u = 0;
               this.x = 0;
            }

            return this.w;
         }
      }
   }

   protected synchronized byte[] q(int var1) {
      E361 var2 = this.j(var1, 0);
      if (var2 == null) {
         return null;
      } else {
         byte[] var3 = var2.g();
         E361.ef(var2);
         return var3;
      }
   }

   private synchronized E361 j(int var1, int var2) {
      Object var3 = (E361)Ha262.d(this.z, (long)var1);
      if (var3 != null && var2 == 0 && !((E361)var3).s && ((E361)var3).l) {
         E361.ef((Ln265)var3);
         var3 = null;
      }

      if (var3 == null) {
         if (var2 == 0) {
            if (this.j != null && this.p[var1] != -1) {
               var3 = this.q.q(var1, this.j);
            } else {
               if (W144.q(this.d)) {
                  return null;
               }

               var3 = this.d.g(this.g, var1, (byte)2, true);
            }
         } else if (var2 == 1) {
            if (this.j == null) {
               throw new RuntimeException("fetchgroup_inner - VERIFY requested but no datafs available!");
            }

            var3 = this.q.e(var1, this.j);
         } else {
            if (var2 != 2) {
               throw new RuntimeException("Invalid fetchgroup mode!");
            }

            if (this.j == null) {
               throw new RuntimeException("fetchgroup_inner - PREFETCH requested but no datafs available!");
            }

            if (this.p[var1] != -1) {
               throw new RuntimeException("fetchgroup_inner - PREFETCH requested, but cache isn't known invalid!");
            }

            if (W144.d(this.d)) {
               return null;
            }

            var3 = this.d.g(this.g, var1, (byte)2, false);
         }

         Ha262.q(this.z, (Ln265)var3, (long)var1);
      }

      if (((E361)var3).l) {
         return null;
      } else {
         byte[] var4 = ((E361)var3).g();
         int var5;
         byte[] var6;
         byte[] var7;
         int var8;
         B360 var11;
         if (var3 instanceof D363) {
            try {
               if (var4 != null && var4.length > 2) {
                  ag.reset();
                  ag.update(var4, 0, var4.length - 2);
                  var5 = (int)ag.getValue();
                  if (var5 != this.w.w[var1]) {
                     throw new RuntimeException("Disk fetch CRC incorrect");
                  } else {
                     if (this.w.r != null && this.w.r[var1] != null) {
                        var6 = this.w.r[var1];
                        var7 = Iw364.e(var4, 0, var4.length - 2);

                        for(var8 = 0; var8 < 64; ++var8) {
                           if (var7[var8] != var6[var8]) {
                              throw new RuntimeException("Disk fetch Whirlpool incorrect");
                           }
                        }
                     }

                     int var12 = ((var4[var4.length - 2] & 255) << 8) + (var4[var4.length - 1] & 255);
                     if (var12 != (this.w.v[var1] & '\uffff')) {
                        throw new RuntimeException("Version incorrect - wanted:" + this.w.v[var1] + " got:" + var12);
                     } else {
                        if (this.p[var1] != 1) {
                           if (this.p[var1] == 0) {
                              ++this.x;
                           }

                           ++this.u;
                           this.p[var1] = 1;
                        }

                        if (!((E361)var3).s) {
                           E361.ef((Ln265)var3);
                        }

                        return (E361)var3;
                     }
                  }
               } else {
                  throw new RuntimeException("Data not in cache - data:" + var4);
               }
            } catch (Exception var9) {
               this.p[var1] = -1;
               E361.ef((Ln265)var3);
               if (((E361)var3).s && !W144.q(this.d)) {
                  var11 = this.d.g(this.g, var1, (byte)2, true);
                  Ha262.q(this.z, var11, (long)var1);
               }

               return null;
            }
         } else {
            try {
               label162: {
                  if (var4 != null && var4.length > 2) {
                     ag.reset();
                     ag.update(var4, 0, var4.length - 2);
                     var5 = (int)ag.getValue();
                     if (var5 != this.w.w[var1]) {
                        throw new RuntimeException("Net fetch CRC incorrect");
                     }

                     if (this.w.r == null || this.w.r[var1] == null) {
                        break label162;
                     }

                     var6 = this.w.r[var1];
                     var7 = Iw364.e(var4, 0, var4.length - 2);
                     var8 = 0;

                     while(true) {
                        if (var8 >= 64) {
                           break label162;
                        }

                        if (var7[var8] != var6[var8]) {
                           throw new RuntimeException("Whirlpool for group " + var1 + " incorrect - got:" + js5.av(var7) + " expected:" + js5.av(var6));
                        }

                        ++var8;
                     }
                  }

                  throw new RuntimeException("Data from server too small - data:" + var4);
               }

               this.d.u = 0;
               this.d.z = 0;
            } catch (RuntimeException var10) {
               W144.h(this.d);
               E361.ef((Ln265)var3);
               if (((E361)var3).s && !W144.q(this.d)) {
                  var11 = this.d.g(this.g, var1, (byte)2, true);
                  Ha262.q(this.z, var11, (long)var1);
               }

               return null;
            }

            var4[var4.length - 2] = (byte)(this.w.v[var1] >>> 8);
            var4[var4.length - 1] = (byte)this.w.v[var1];
            if (this.j != null) {
               this.q.j(var1, var4, this.j);
               if (this.p[var1] != 1) {
                  ++this.u;
                  this.p[var1] = 1;
               }
            }

            if (!((E361)var3).s) {
               E361.ef((Ln265)var3);
            }

            return (E361)var3;
         }
      }
   }

   protected synchronized int w(int var1) {
      E361 var2 = (E361)Ha262.d(this.z, (long)var1);
      return var2 != null ? var2.d() : 0;
   }

   public synchronized void h() {
      if (this.k != null) {
         if (this.d() == null) {
            return;
         }

         boolean var1;
         Ln265 var2;
         int var3;
         if (this.m) {
            var1 = true;

            for(var2 = Gx298.i(this.k); var2 != null; var2 = Gx298.c(this.k)) {
               var3 = (int)var2.bq;
               if (this.p[var3] == 0) {
                  this.j(var3, 1);
               }

               if (this.p[var3] != 0) {
                  Ln265.ef(var2);
               } else {
                  var1 = false;
               }
            }

            while(this.n < this.w.y.length) {
               if (this.w.y[this.n] == 0) {
                  ++this.n;
               } else {
                  if (this.q.d >= 250) {
                     var1 = false;
                     break;
                  }

                  if (this.p[this.n] == 0) {
                     this.j(this.n, 1);
                  }

                  if (this.p[this.n] == 0) {
                     var2 = new Ln265();
                     var2.bq = (long)this.n;
                     Gx298.t(this.k, var2);
                     var1 = false;
                  }

                  ++this.n;
               }
            }

            if (var1) {
               this.m = false;
               this.n = 0;
            }
         } else if (this.t) {
            var1 = true;

            for(var2 = Gx298.i(this.k); var2 != null; var2 = Gx298.c(this.k)) {
               var3 = (int)var2.bq;
               if (this.p[var3] != 1) {
                  this.j(var3, 2);
               }

               if (this.p[var3] == 1) {
                  Ln265.ef(var2);
               } else {
                  var1 = false;
               }
            }

            while(this.n < this.w.y.length) {
               if (this.w.y[this.n] == 0) {
                  ++this.n;
               } else {
                  if (W144.d(this.d)) {
                     var1 = false;
                     break;
                  }

                  if (this.p[this.n] != 1) {
                     this.j(this.n, 2);
                  }

                  if (this.p[this.n] != 1) {
                     var2 = new Ln265();
                     var2.bq = (long)this.n;
                     Gx298.t(this.k, var2);
                     var1 = false;
                  }

                  ++this.n;
               }
            }

            if (var1) {
               this.t = false;
               this.n = 0;
            }
         } else {
            this.k = null;
         }
      }

      if (this.o && Gz143.g() >= this.a) {
         for(E361 var4 = (E361)Ha262.e(this.z); var4 != null; var4 = (E361)Ha262.h(this.z)) {
            if (!var4.l) {
               if (var4.b) {
                  if (!var4.s) {
                     throw new RuntimeException("Unexpected non-urgent orphan! archiveid:" + this.g + " group:" + var4.p);
                  }

                  E361.ef(var4);
               } else {
                  var4.b = true;
               }
            }
         }

         this.a = Gz143.g() + 1000L;
      }

   }

   Q138(int var1, Hl134 var2, Hl134 var3, W144 var4, L145 var5, int var6, byte[] var7, int var8, boolean var9) {
      this.g = var1;
      this.j = var2;
      if (this.j == null) {
         this.m = false;
      } else {
         this.m = true;
         this.k = new Gx298();
      }

      this.e = var3;
      this.d = var4;
      this.q = var5;
      this.s = var6;
      this.b = var7;
      this.l = var8;
      this.o = var9;
      if (this.e != null) {
         this.h = this.q.q(this.g, this.e);
      }

   }

   public synchronized void l() {
      if (this.j != null) {
         this.t = true;
         if (this.k == null) {
            this.k = new Gx298();
         }

      }
   }

   public static synchronized void e(Q138 var0) {
      if (var0.k != null) {
         if (var0.d() != null) {
            for(Ln265 var1 = Gx298.i(var0.i); var1 != null; var1 = Gx298.c(var0.i)) {
               int var2 = (int)var1.bq;
               if (var2 >= 0 && var2 < var0.w.l && var0.w.y[var2] != 0) {
                  if (var0.p[var2] == 0) {
                     var0.j(var2, 1);
                  }

                  if (var0.p[var2] == -1) {
                     var0.j(var2, 2);
                  }

                  if (var0.p[var2] == 1) {
                     Ln265.ef(var1);
                  }
               } else {
                  Ln265.ef(var1);
               }
            }

         }
      }
   }

   public int g() {
      if (this.d() == null) {
         return this.h == null ? 0 : this.h.d();
      } else {
         return 100;
      }
   }

   public synchronized int b() {
      if (this.w == null) {
         return 0;
      } else if (!this.m) {
         return this.w.e;
      } else {
         Ln265 var1 = Gx298.i(this.k);
         return var1 == null ? 0 : (int)var1.bq;
      }
   }
}
