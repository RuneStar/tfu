package rs2.client.sound;

import fmod.X243;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import tfu.Gg3;

class X675 {
   public float b = 1.0F;
   public String d;
   public LinkedList e = new LinkedList();
   private Random g = new Random();
   private long[] h = new long[]{0L, 0L};
   long i = 0L;
   public ArrayList j = new ArrayList();
   int k;
   public long l = 0L;
   int m;
   int n;
   float o = 0.0F;
   public int p;
   private ArrayList q = new ArrayList();
   public int r;
   private float[] s = new float[]{1.0F, 1.0F};
   int t;
   int u;
   public int v;
   public int w;
   int x;
   public int y;
   int z;

   public static void g(X675 var0) {
      j(var0, 1.0F);
      var0.o = 0.0F;
      l(var0, (String)null);
      Iterator var1 = var0.e.iterator();

      Av695 var2;
      while(var1.hasNext()) {
         var2 = (Av695)var1.next();
         Av695.e(var2);
      }

      var1 = var0.e.iterator();

      while(var1.hasNext()) {
         var2 = (Av695)var1.next();
         X243.n(var2.g, false);
      }

      var0.l = K589.g();
      K589.s = var0;
      b(var0);
   }

   public static void h(X675 var0) {
      var0.q.clear();
   }

   public static void q(X675 var0) {
      Iterator var1 = var0.e.iterator();

      while(var1.hasNext()) {
         Av695 var2 = (Av695)var1.next();
         Av695.s(var2);
      }

   }

   public static void j(X675 var0, float var1) {
      var0.b = var1;
   }

   public static float e(X675 var0) {
      return var0.b;
   }

   public static void l(X675 var0, String var1) {
      Iterator var2;
      Av695 var3;
      if (var1 == null) {
         for(var2 = var0.e.iterator(); var2.hasNext(); var3.j = 0.0F) {
            var3 = (Av695)var2.next();
         }

         if (var0.e.size() > 0) {
            ((Av695)var0.e.get(0)).j = 1.0F;
         }
      } else {
         var2 = var0.e.iterator();

         while(var2.hasNext()) {
            var3 = (Av695)var2.next();
            Av695.j(var3, var1, !w(var0));
         }
      }

   }

   public X675() {
   }

   public static synchronized void r(X675 var0) {
      long var1 = K589.s == null ? 0L : x(K589.s);
      if (var0.o != 0.0F) {
         float var3 = e(var0) + var0.o;
         if (var3 < 0.0F) {
            var3 = 0.0F;
            var0.o = 0.0F;
            q(var0);
         } else {
            j(var0, var3);
         }
      }

      int var7 = var0.q.size();
      if (var7 > 0) {
         for(int var4 = var7 - 1; var4 >= 0; --var4) {
            N680 var5 = (N680)var0.q.get(var4);
            if (var1 > var5.s) {
               switch(var5.w) {
               case 0:
                  if (K589.s != null) {
                     K589.s.o = -(33.333332F / (float)var0.y);
                  }

                  d(var0, (int)(var1 - var5.s));
                  K589.b = null;
                  break;
               case 1:
                  q(var0);
                  break;
               case 2:
                  var0.h[0] = var5.s;
                  var0.h[1] = var5.b;
                  var0.s[0] = e(var0);
                  var0.s[1] = var5.h;
                  break;
               case 3:
                  l(var0, var5.l);
                  break;
               case 4:
                  float var6 = (float)(var5.b - var5.s) / 1000.0F;
                  var0.o = -0.01F;
               }

               var0.q.remove(var4);
            }
         }
      }

      Iterator var8 = var0.e.iterator();

      while(var8.hasNext()) {
         Av695 var9 = (Av695)var8.next();
         Av695.b(var9);
      }

   }

   public void v() {
      M682 var1 = new M682(this);
      if (K589.s != this) {
         if (this.e.size() > 0) {
            if (SoundManager.c.r(((Av695)this.e.get(0)).e, 4).ai()) {
               var1.g("", this);
            } else {
               String[] var2 = SoundManager.c.r(((Av695)this.e.get(0)).e, 4).aq();
               if (var2 != null && var2.length > 0) {
                  G593.g(var2[0], 180000L, true, var1, this);
               }
            }
         }

      }
   }

   public static void y(X675 var0) {
      if (var0.j.size() > 0) {
         X675 var1;
         do {
            int var2 = var0.g.nextInt(var0.j.size());
            var1 = K589.e((String)var0.j.get(var2));
         } while(var1 == K589.s);

         if (var1 != null) {
            var1.v();
            return;
         }
      }

      var0.v();
   }

   public void p(Gg3 var1) {
      this.d = Gg3.bk(var1);
      this.x = Gg3.ar(var1);
      this.u = Gg3.ar(var1);
      this.z = Gg3.ar(var1);
      this.t = Gg3.ar(var1);
      this.m = Gg3.ar(var1);
      this.n = Gg3.ar(var1);
      this.k = Gg3.ar(var1);
      int var2 = Gg3.au(var1);

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         this.j.add(Gg3.bk(var1));
      }

      var3 = Gg3.ar(var1);

      for(int var4 = 0; var4 < var3; ++var4) {
         Av695 var5 = new Av695("", this);
         Av695.w(var5, var1);
         this.e.add(var5);
      }

   }

   public static int u(X675 var0) {
      return var0.e.size() == 0 ? 0 : Av695.d((Av695)var0.e.get(0));
   }

   // $FF: synthetic method
   static void z(X675 var0) {
      b(var0);
   }

   private static void b(X675 var0) {
      var0.w = (int)(60000.0F / (float)var0.x);
      var0.r = var0.w * var0.t;
      var0.v = var0.w * var0.m;
      var0.y = var0.w * var0.n;
      var0.p = var0.w * var0.k;
   }

   public static void s(X675 var0, N680 var1) {
      int var2 = var0.q.size();
      if (var2 != 0 && ((N680)var0.q.get(var2 - 1)).s > var1.s) {
         for(int var3 = 0; var3 < var2; ++var3) {
            if (((N680)var0.q.get(var3)).s > var1.s) {
               var0.q.add(var3, var1);
               break;
            }
         }
      } else {
         var0.q.add(var1);
      }

   }

   public static void d(X675 var0, int var1) {
      j(var0, 1.0F);
      var0.o = 0.0F;
      l(var0, (String)null);
      Iterator var2 = var0.e.iterator();

      Av695 var3;
      while(var2.hasNext()) {
         var3 = (Av695)var2.next();
         Av695.h(var3, var1);
      }

      var2 = var0.e.iterator();

      while(var2.hasNext()) {
         var3 = (Av695)var2.next();
         X243.n(var3.g, false);
      }

      var0.l = K589.g();
      K589.s = var0;
      b(var0);
   }

   public static boolean w(X675 var0) {
      boolean var1 = false;

      Av695 var3;
      for(Iterator var2 = var0.e.iterator(); var2.hasNext(); var1 |= Av695.q(var3)) {
         var3 = (Av695)var2.next();
      }

      return var1;
   }

   public static long x(X675 var0) {
      return var0.e.size() == 0 ? 0L : Av695.g((Av695)var0.e.get(0));
   }
}
