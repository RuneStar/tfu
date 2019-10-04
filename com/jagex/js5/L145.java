package com.jagex.js5;

import tfu.Hl134;
import tfu.Hn359;
import tfu.Ku323;

public class L145 implements Runnable {
   int d = 0;
   private Hn359 g = new Hn359();
   private Thread j = new Thread(this);
   private boolean q = false;

   public L145() {
      this.j.setDaemon(true);
      this.j.start();
      this.j.setPriority(1);
   }

   D363 j(int var1, byte[] var2, Hl134 var3) {
      D363 var4 = new D363();
      var4.j = 2;
      var4.p = (long)var1;
      var4.h = var2;
      var4.e = var3;
      var4.s = false;
      h(this, var4);
      return var4;
   }

   private static void h(L145 var0, D363 var1) {
      Hn359 var2 = var0.g;
      synchronized(var2) {
         Hn359.q(var0.g, var1);
         ++var0.d;
         var0.g.notifyAll();
      }
   }

   public void run() {
      while(!this.q) {
         Hn359 var2 = this.g;
         D363 var1;
         synchronized(var2) {
            var1 = (D363)Hn359.e(this.g);
            if (var1 == null) {
               try {
                  this.g.wait();
               } catch (InterruptedException var6) {
               }
               continue;
            }

            --this.d;
         }

         try {
            if (var1.j == 2) {
               var1.e.d((int)var1.p, var1.h, var1.h.length);
            } else if (var1.j == 3) {
               var1.h = Hl134.g(var1.e, (int)var1.p);
            }
         } catch (Exception var5) {
            Ku323.g((String)null, var5);
         }

         var1.l = false;
      }

   }

   D363 q(int var1, Hl134 var2) {
      D363 var3 = new D363();
      var3.j = 1;
      Hn359 var4 = this.g;
      synchronized(var4) {
         D363 var5 = (D363)Hn359.h(this.g);

         while(true) {
            if (var5 == null) {
               break;
            }

            if (var5.p == (long)var1 && var5.e == var2 && var5.j == 2) {
               var3.h = var5.h;
               var3.l = false;
               return var3;
            }

            var5 = (D363)Hn359.b(this.g);
         }
      }

      var3.h = Hl134.g(var2, var1);
      var3.l = false;
      var3.s = true;
      return var3;
   }

   D363 e(int var1, Hl134 var2) {
      D363 var3 = new D363();
      var3.j = 3;
      var3.p = (long)var1;
      var3.e = var2;
      var3.s = false;
      h(this, var3);
      return var3;
   }

   public static void s(L145 var0) {
      var0.q = true;
      Hn359 var1 = var0.g;
      synchronized(var1) {
         var0.g.notifyAll();
      }

      try {
         var0.j.join();
      } catch (InterruptedException var3) {
      }

      var0.j = null;
   }
}
