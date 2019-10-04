package tfu;

import com.jagex.core.stringtools.general.Q280;

public class Ef450 {
   public static final byte aa = 3;
   public static final int ab = 100;
   public static final byte ac = -1;
   public static final byte af = 126;
   public static final byte ah = 6;
   public static final byte al = 127;
   public static final byte am = 1;
   public static final byte an = 2;
   public static final byte ao = 4;
   public static final byte ap = 5;
   public static final byte as = 0;
   public static final int at = 500;
   public static final byte av = 125;
   public static final byte az = 100;
   public static final boolean d = false;
   public static boolean g = false;
   static final int q = 6;
   public int a = -1;
   public String[] ag;
   public Ha262 ai;
   public String[] aq;
   public String b = null;
   public long[] c;
   boolean e;
   public int f;
   public long h;
   public boolean[] i;
   boolean j;
   public int[] k;
   public int l = 0;
   private int[] m;
   public int[] n;
   public int o = -1;
   public byte p;
   public boolean r;
   public int s = 0;
   public byte[] t;
   public int u;
   public byte v;
   public int w = 0;
   public byte x;
   public byte y;
   public long[] z;

   public Ef450(String var1, long var2) {
      this.j = true;
      this.b = var1;
      this.q(var2, (String)null, Gk481.q());
      this.l = (int)(System.currentTimeMillis() / 60000L);
   }

   private Ef450() {
   }

   private static void g(Ef450 var0, int var1) {
      if (var0.j) {
         if (var0.z != null) {
            System.arraycopy(var0.z, 0, var0.z = new long[var1], 0, var0.u);
         } else {
            var0.z = new long[var1];
         }
      }

      if (var0.e) {
         if (var0.ag != null) {
            System.arraycopy(var0.ag, 0, var0.ag = new String[var1], 0, var0.u);
         } else {
            var0.ag = new String[var1];
         }
      }

      if (var0.t != null) {
         System.arraycopy(var0.t, 0, var0.t = new byte[var1], 0, var0.u);
      } else {
         var0.t = new byte[var1];
      }

      if (var0.n != null) {
         System.arraycopy(var0.n, 0, var0.n = new int[var1], 0, var0.u);
      } else {
         var0.n = new int[var1];
      }

      if (var0.k != null) {
         System.arraycopy(var0.k, 0, var0.k = new int[var1], 0, var0.u);
      } else {
         var0.k = new int[var1];
      }

      if (var0.i != null) {
         System.arraycopy(var0.i, 0, var0.i = new boolean[var1], 0, var0.u);
      } else {
         var0.i = new boolean[var1];
      }

   }

   static int l(Ef450 var0, int var1, boolean var2) {
      if (var0.i[var1] == var2) {
         return -1;
      } else {
         var0.i[var1] = var2;
         return var1;
      }
   }

   public void j(int var1) {
      if (var1 >= 0 && var1 < this.u) {
         --this.u;
         this.m = null;
         if (this.u == 0) {
            this.z = null;
            this.ag = null;
            this.t = null;
            this.n = null;
            this.k = null;
            this.i = null;
            this.o = -1;
            this.a = -1;
         } else {
            System.arraycopy(this.t, var1 + 1, this.t, var1, this.u - var1);
            System.arraycopy(this.n, var1 + 1, this.n, var1, this.u - var1);
            System.arraycopy(this.k, var1 + 1, this.k, var1, this.u - var1);
            System.arraycopy(this.i, var1 + 1, this.i, var1, this.u - var1);
            if (this.z != null) {
               System.arraycopy(this.z, var1 + 1, this.z, var1, this.u - var1);
            }

            if (this.ag != null) {
               System.arraycopy(this.ag, var1 + 1, this.ag, var1, this.u - var1);
            }

            if (var1 == this.o || var1 == this.a) {
               e(this);
            }
         }

      } else {
         throw new RuntimeException("Invalid pos in doDeleteMember - pos:" + var1 + " memberCount:" + this.u);
      }
   }

   public boolean r(int var1, int var2) {
      if (this.ai != null) {
         Ln265 var3 = Ha262.d(this.ai, (long)var1);
         if (var3 != null) {
            if (var3 instanceof Kq264) {
               Kq264 var4 = (Kq264)var3;
               if (var4.g == var2) {
                  return false;
               }

               var4.g = var2;
               return true;
            }

            Ln265.ef(var3);
         }
      } else {
         this.ai = new Ha262(4);
      }

      Ha262.q(this.ai, new Kq264(var2), (long)var1);
      return true;
   }

   void h(long var1, String var3) {
      if (var3 != null && var3.length() == 0) {
         var3 = null;
      }

      if (var1 > 0L != this.j) {
         throw new RuntimeException("Invalid UserHash arg to this method - useUserHashes:" + this.j + " but userhash:" + var1);
      } else if (var3 != null != this.e) {
         throw new RuntimeException("Invalid DisplayName arg to this method - useDisplayNames:" + this.e + " but displayname:" + var3);
      } else {
         if (var1 > 0L && (this.c == null || this.f >= this.c.length) || var3 != null && (this.aq == null || this.f >= this.aq.length)) {
            d(this, this.f + 5);
         }

         if (this.c != null) {
            this.c[this.f] = var1;
         }

         if (this.aq != null) {
            this.aq[this.f] = var3;
         }

         ++this.f;
      }
   }

   public static void s(Ef450 var0, int var1) {
      --var0.f;
      if (var0.f == 0) {
         var0.c = null;
         var0.aq = null;
      } else {
         if (var0.c != null) {
            System.arraycopy(var0.c, var1 + 1, var0.c, var1, var0.f - var1);
         }

         if (var0.aq != null) {
            System.arraycopy(var0.aq, var1 + 1, var0.aq, var1, var0.f - var1);
         }
      }

   }

   static int b(Ef450 var0, int var1, byte var2) {
      if (var2 != 126 && var2 != 127) {
         if (var1 != var0.o || var0.a != -1 && var0.t[var0.a] >= 125) {
            if (var0.t[var1] == var2) {
               return -1;
            } else {
               var0.t[var1] = var2;
               e(var0);
               return var1;
            }
         } else {
            return -1;
         }
      } else {
         return -1;
      }
   }

   static int w(Ef450 var0, int var1, int var2, int var3, int var4) {
      int var5 = (1 << var3) - 1;
      int var6 = var4 == 31 ? -1 : (1 << var4 + 1) - 1;
      int var7 = var6 ^ var5;
      var2 <<= var3;
      var2 &= var7;
      int var8 = var0.n[var1];
      if ((var8 & var7) == var2) {
         return -1;
      } else {
         var8 &= ~var7;
         var0.n[var1] = var8 | var2;
         return var1;
      }
   }

   private static void e(Ef450 var0) {
      if (var0.u == 0) {
         var0.o = -1;
         var0.a = -1;
      } else {
         var0.o = -1;
         var0.a = -1;
         int var1 = 0;
         byte var2 = var0.t[0];

         for(int var3 = 1; var3 < var0.u; ++var3) {
            if (var0.t[var3] > var2) {
               if (var2 == 125) {
                  var0.a = var1;
               }

               var1 = var3;
               var2 = var0.t[var3];
            } else if (var0.a == -1 && var0.t[var3] == 125) {
               var0.a = var3;
            }
         }

         var0.o = var1;
         if (var0.o != -1) {
            var0.t[var0.o] = 126;
         }

      }
   }

   boolean v(int var1, int var2, int var3, int var4) {
      int var5 = (1 << var3) - 1;
      int var6 = var4 == 31 ? -1 : (1 << var4 + 1) - 1;
      int var7 = var6 ^ var5;
      var2 <<= var3;
      var2 &= var7;
      if (this.ai != null) {
         Ln265 var8 = Ha262.d(this.ai, (long)var1);
         if (var8 != null) {
            if (var8 instanceof Kq264) {
               Kq264 var9 = (Kq264)var8;
               if ((var9.g & var7) == var2) {
                  return false;
               }

               var9.g &= ~var7;
               var9.g |= var2;
               return true;
            }

            Ln265.ef(var8);
         }
      } else {
         this.ai = new Ha262(4);
      }

      Ha262.q(this.ai, new Kq264(var2), (long)var1);
      return true;
   }

   private static void d(Ef450 var0, int var1) {
      if (var0.j) {
         if (var0.c != null) {
            System.arraycopy(var0.c, 0, var0.c = new long[var1], 0, var0.f);
         } else {
            var0.c = new long[var1];
         }
      }

      if (var0.e) {
         if (var0.aq != null) {
            System.arraycopy(var0.aq, 0, var0.aq = new String[var1], 0, var0.f);
         } else {
            var0.aq = new String[var1];
         }
      }

   }

   boolean p(int var1, String var2) {
      if (var2 == null) {
         var2 = "";
      } else if (var2.length() > 80) {
         var2 = var2.substring(0, 80);
      }

      if (this.ai != null) {
         Ln265 var3 = Ha262.d(this.ai, (long)var1);
         if (var3 != null) {
            if (var3 instanceof Ld263) {
               Ld263 var4 = (Ld263)var3;
               if (var4.g instanceof String) {
                  if (var2.equals(var4.g)) {
                     return false;
                  }

                  Ld263.ef(var4);
                  Ha262.q(this.ai, new Ld263(var2), var4.bq);
                  return true;
               }
            }

            Ln265.ef(var3);
         }
      } else {
         this.ai = new Ha262(4);
      }

      Ha262.q(this.ai, new Ld263(var2), (long)var1);
      return true;
   }

   public void x(Gg3 var1) {
      int var2 = Gg3.ar(var1);
      if (var2 >= 1 && var2 <= 6) {
         int var3 = Gg3.ar(var1);
         if ((var3 & 1) != 0) {
            this.j = true;
         }

         if ((var3 & 2) != 0) {
            this.e = true;
         }

         if (!this.j) {
            this.z = null;
            this.c = null;
         }

         if (!this.e) {
            this.ag = null;
            this.aq = null;
         }

         this.s = Gg3.bd(var1);
         this.l = Gg3.bd(var1);
         if (var2 <= 3 && this.l != 0) {
            this.l += 16912800;
         }

         this.u = Gg3.au(var1);
         this.f = Gg3.ar(var1);
         this.b = Gg3.bk(var1);
         if (var2 >= 4) {
            this.w = Gg3.bd(var1);
         }

         this.r = Gg3.ar(var1) == 1;
         this.v = Gg3.ax(var1);
         this.y = Gg3.ax(var1);
         this.p = Gg3.ax(var1);
         this.x = Gg3.ax(var1);
         int var4;
         if (this.u > 0) {
            if (this.j && (this.z == null || this.z.length < this.u)) {
               this.z = new long[this.u];
            }

            if (this.e && (this.ag == null || this.ag.length < this.u)) {
               this.ag = new String[this.u];
            }

            if (this.t == null || this.t.length < this.u) {
               this.t = new byte[this.u];
            }

            if (this.n == null || this.n.length < this.u) {
               this.n = new int[this.u];
            }

            if (this.k == null || this.k.length < this.u) {
               this.k = new int[this.u];
            }

            if (this.i == null || this.i.length < this.u) {
               this.i = new boolean[this.u];
            }

            for(var4 = 0; var4 < this.u; ++var4) {
               if (this.j) {
                  this.z[var4] = Gg3.bq(var1);
               }

               if (this.e) {
                  this.ag[var4] = Gg3.bj(var1);
               }

               this.t[var4] = Gg3.ax(var1);
               if (var2 >= 2) {
                  this.n[var4] = Gg3.bd(var1);
               }

               if (var2 >= 5) {
                  this.k[var4] = Gg3.au(var1);
               } else {
                  this.k[var4] = 0;
               }

               if (var2 >= 6) {
                  this.i[var4] = Gg3.ar(var1) == 1;
               } else {
                  this.i[var4] = false;
               }
            }

            e(this);
         }

         if (this.f > 0) {
            if (this.j && (this.c == null || this.c.length < this.f)) {
               this.c = new long[this.f];
            }

            if (this.e && (this.aq == null || this.aq.length < this.f)) {
               this.aq = new String[this.f];
            }

            for(var4 = 0; var4 < this.f; ++var4) {
               if (this.j) {
                  this.c[var4] = Gg3.bq(var1);
               }

               if (this.e) {
                  this.aq[var4] = Gg3.bj(var1);
               }
            }
         }

         if (var2 >= 3) {
            var4 = Gg3.au(var1);
            if (var4 > 0) {
               this.ai = new Ha262(var4 < 16 ? Jz233.j(var4) : 16);

               while(var4-- > 0) {
                  int var5 = Gg3.bd(var1);
                  int var6 = var5 & 1073741823;
                  int var7 = var5 >>> 30;
                  if (var7 == 0) {
                     int var8 = Gg3.bd(var1);
                     Ha262.q(this.ai, new Kq264(var8), (long)var6);
                  } else if (var7 == 1) {
                     long var10 = Gg3.bq(var1);
                     Ha262.q(this.ai, new Lo465(var10), (long)var6);
                  } else if (var7 == 2) {
                     String var11 = Gg3.bk(var1);
                     Ha262.q(this.ai, new Ld263(var11), (long)var6);
                  }
               }
            }
         }

      } else {
         throw new RuntimeException("Unsupported ClanSettings version: " + var2);
      }
   }

   public String u() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Clan Name: ").append(this.b).append("\ncurrentOwnerSlot: ").append(this.o).append(", replacementOwnerSlot: ").append(this.a).append("\nallowNonMembers: ").append(this.r).append(", rankTalk: ").append(this.v).append(", rankKick: ").append(this.y).append(",  rankLootShare: ").append(this.p);
      var1.append("\nMembers:");

      int var2;
      for(var2 = 0; var2 < this.u; ++var2) {
         var1.append("\n").append(this.z != null ? Q280.g(this.z[var2]) : "null").append(" - ").append(this.ag[var2]).append(" - rank:").append(this.t[var2]);
      }

      var1.append("\nBanned:");

      for(var2 = 0; var2 < this.u; ++var2) {
         var1.append("\n").append(this.z != null ? Q280.g(this.z[var2]) : "null").append(" - ").append(this.ag[var2]).append(" - rank:").append(this.t[var2]);
      }

      return var1.toString();
   }

   public Ef450(long var1, Gg3 var3) {
      this.h = var1;
      this.x(var3);
   }

   boolean y(int var1, long var2) {
      if (this.ai != null) {
         Ln265 var4 = Ha262.d(this.ai, (long)var1);
         if (var4 != null) {
            if (var4 instanceof Lo465) {
               Lo465 var5 = (Lo465)var4;
               if (var5.g == var2) {
                  return false;
               }

               var5.g = var2;
               return true;
            }

            Ln265.ef(var4);
         }
      } else {
         this.ai = new Ha262(4);
      }

      Ha262.q(this.ai, new Lo465(var2), (long)var1);
      return true;
   }

   void q(long var1, String var3, int var4) {
      if (var3 != null && var3.length() == 0) {
         var3 = null;
      }

      if (var1 > 0L != this.j) {
         throw new RuntimeException("Invalid UserHash arg to this method - useUserHashes:" + this.j + " but userhash:" + var1);
      } else if (var3 != null != this.e) {
         throw new RuntimeException("Invalid DisplayName arg to this method - useDisplayNames:" + this.e + " but displayname:" + var3);
      } else {
         if (var1 > 0L && (this.z == null || this.u >= this.z.length) || var3 != null && (this.ag == null || this.u >= this.ag.length)) {
            g(this, this.u + 5);
         }

         if (this.z != null) {
            this.z[this.u] = var1;
         }

         if (this.ag != null) {
            this.ag[this.u] = var3;
         }

         if (this.o == -1) {
            this.o = this.u;
            this.t[this.u] = 126;
         } else {
            this.t[this.u] = 0;
         }

         this.n[this.u] = 0;
         this.k[this.u] = var4;
         this.i[this.u] = false;
         ++this.u;
         this.m = null;
      }
   }

   public Ef450(Gg3 var1) {
      this.x(var1);
   }
}
