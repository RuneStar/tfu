package rs2.client.login;

import com.jagex.game.runetek6.event.EventHandler;
import rs2.client.N272;
import tfu.Gg3;
import tfu.Mf509;

abstract class Y276 {
   static final int r = 4;
   final EventHandler m;
   float p;
   int t;
   int[] u;
   N272 v;
   float x;
   W274 y;
   int z;

   Y276(N272 var1, float var2, EventHandler var3) {
      this.v = var1;
      this.v.o = false;
      this.p = var2;
      this.m = var3;
      n(this);
   }

   static void n(Y276 var0) {
      var0.x = 0.0F;
      var0.z = 1;
      var0.y = null;
   }

   static void k(Y276 var0, E275 var1) {
      var0.i(var1, (Mf509)null);
   }

   void i(E275 var1, Mf509 var2) {
      this.y = new W274(var1, var2, this.m);
   }

   public W274 h() {
      return this.y;
   }

   abstract void d(float var1);

   Gg3 o() {
      Gg3 var1 = new Gg3(518);
      this.u = new int[4];
      this.u[0] = (int)(Math.random() * 9.9999999E7D);
      this.u[1] = (int)(Math.random() * 9.9999999E7D);
      this.u[2] = (int)(Math.random() * 9.9999999E7D);
      this.u[3] = (int)(Math.random() * 9.9999999E7D);
      Gg3.k(var1, 10);
      Gg3.a(var1, this.u[0]);
      Gg3.a(var1, this.u[1]);
      Gg3.a(var1, this.u[2]);
      Gg3.a(var1, this.u[3]);
      return var1;
   }

   abstract void g();
}
