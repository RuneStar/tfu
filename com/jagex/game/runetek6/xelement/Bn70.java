package com.jagex.game.runetek6.xelement;

import com.jagex.jnibindings.runetek6.Graphics;
import com.jagex.maths.Vector3;
import tfu.Gg3;
import tfu.H149;
import tfu.Kc180;

public class Bn70 {
   private static int p;
   private static int r = 255;
   private static int t;
   private static int u;
   private static int v;
   private static int x;
   private static int y;
   private static int z;
   public E175 b;
   public R176 d = new R176(this);
   public Vector3 e;
   public Ak177 g = new Ak177(this);
   public Vector3 h;
   public Vector3 j;
   public Bl69 l;
   public Vector3 q;
   public Ai178 s;
   public X179 w;

   public static void g(Bn70 var0, Gg3 var1) {
      Gg3.aq(var1, var0.g.g.x);
      Gg3.aq(var1, var0.g.g.y);
      Gg3.aq(var1, var0.g.g.z);
      Gg3.aq(var1, var0.g.d.x);
      Gg3.aq(var1, var0.g.d.y);
      Gg3.aq(var1, var0.g.d.z);
      Gg3.aq(var1, var0.g.q.x);
      Gg3.aq(var1, var0.g.q.y);
      Gg3.aq(var1, var0.g.q.z);
      Gg3.aq(var1, var0.g.j);
      Gg3.aq(var1, var0.g.e.x);
      Gg3.aq(var1, var0.g.e.y);
      Gg3.aq(var1, var0.g.e.z);
      Gg3.aq(var1, var0.g.h);
      Gg3.aq(var1, var0.g.s.x);
      Gg3.aq(var1, var0.g.s.y);
      Gg3.aq(var1, var0.g.s.z);
      Gg3.aq(var1, var0.g.b);
      Gg3.aq(var1, var0.g.l);
      Gg3.aq(var1, var0.g.w);
      Gg3.aq(var1, var0.d.g.x);
      Gg3.aq(var1, var0.d.g.y);
      Gg3.aq(var1, var0.d.g.z);
      Gg3.aq(var1, var0.d.d.x);
      Gg3.aq(var1, var0.d.d.y);
      Gg3.aq(var1, var0.d.d.z);
      Gg3.aq(var1, var0.d.q);
      Gg3.aq(var1, var0.d.j);
      Gg3.aq(var1, var0.d.e);
      Gg3.aq(var1, var0.h.x);
      Gg3.aq(var1, var0.h.y);
      Gg3.aq(var1, var0.h.z);
      Gg3.aq(var1, var0.q.x);
      Gg3.aq(var1, var0.q.y);
      Gg3.aq(var1, var0.q.z);
      Gg3.aq(var1, var0.j.x);
      Gg3.aq(var1, var0.j.y);
      Gg3.aq(var1, var0.j.z);
      Gg3.aq(var1, var0.e.x);
      Gg3.aq(var1, var0.e.y);
      Gg3.aq(var1, var0.e.z);
      Gg3.a(var1, var0.s.g ? 1 : 0);
      var1.af(var0.s.d);
      Gg3.aq(var1, var0.s.q);
      Gg3.a(var1, var0.s.j ? 1 : 0);
      Gg3.aq(var1, var0.s.e);
      Gg3.aq(var1, var0.s.h);
      Gg3.a(var1, var0.s.s ? 1 : 0);
      Gg3.aq(var1, var0.b.g);
      Gg3.aq(var1, var0.b.d);
      Gg3.aq(var1, var0.b.q);
      Gg3.aq(var1, var0.b.j);
      Gg3.aq(var1, var0.b.e);
      Gg3.aq(var1, var0.b.h.x);
      Gg3.aq(var1, var0.b.h.y);
      Gg3.aq(var1, var0.b.h.z);
      Gg3.a(var1, var0.l.g ? 1 : 0);
      Gg3.a(var1, var0.l.d);
      Gg3.aq(var1, var0.l.q);
      Gg3.aq(var1, var0.l.j);
      Gg3.aq(var1, var0.l.e);
      Gg3.aq(var1, var0.l.h);
      Gg3.a(var1, var0.l.s);
      Gg3.aq(var1, var0.l.b);
      Gg3.aq(var1, var0.l.l);
      Gg3.a(var1, var0.w.g);
      Gg3.aq(var1, var0.w.d);
      Gg3.a(var1, var0.w.q);
      Gg3.aq(var1, var0.w.j);
      Gg3.aq(var1, var0.w.e);

      for(int var2 = 0; var2 < 3; ++var2) {
         By167 var3 = var0.w.h[var2];
         Gg3.a(var1, var3.g ? 1 : 0);
         Gg3.aq(var1, var3.d);
         Gg3.aq(var1, var3.q);
         Gg3.aq(var1, var3.j);
         Gg3.aq(var1, var3.e);
         Gg3.aq(var1, var3.h);
         Gg3.aq(var1, var3.s);
         Gg3.aq(var1, var3.b);
         Gg3.aq(var1, var3.l);
         Gg3.aq(var1, var3.w.x);
         Gg3.aq(var1, var3.w.y);
         Gg3.aq(var1, var3.w.z);
         Gg3.aq(var1, var3.r.x);
         Gg3.aq(var1, var3.r.y);
         Gg3.aq(var1, var3.r.z);
         Gg3.aq(var1, var3.v);
         Gg3.aq(var1, var3.y);
         Gg3.aq(var1, var3.p);
         Gg3.aq(var1, var3.x);
         Gg3.aq(var1, var3.u);
      }

   }

   public Bn70() {
      this.q = Vector3.g;
      this.j = Vector3.g;
      this.e = Vector3.g;
      this.h = new Vector3(1.0F, 1.0F, 1.0F);
      this.s = new Ai178(this);
      this.b = new E175(this);
      this.l = new Bl69(this);
      this.w = new X179(this);
   }

   public void d(Gg3 var1) {
      this.g.g = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.g.d = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.g.q = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.g.j = Gg3.bl(var1);
      this.g.e = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.g.h = Gg3.bl(var1);
      this.g.s = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.g.b = Gg3.bl(var1);
      this.g.l = Gg3.bl(var1);
      this.g.w = Gg3.bl(var1);
      this.d.g = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.d.d = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.d.q = Gg3.bl(var1);
      this.d.j = Gg3.bl(var1);
      this.d.e = Gg3.bl(var1);
      this.h = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.q = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.j = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.e = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.s.g = Gg3.bd(var1) == 1;
      this.s.d = Gg3.bk(var1);
      this.s.q = Gg3.bl(var1);
      this.s.j = Gg3.bd(var1) == 1;
      this.s.e = Gg3.bl(var1);
      this.s.h = Gg3.bl(var1);
      this.s.s = Gg3.bd(var1) == 1;
      this.b.g = Gg3.bl(var1);
      this.b.d = Gg3.bl(var1);
      this.b.q = Gg3.bl(var1);
      this.b.j = Gg3.bl(var1);
      this.b.e = Gg3.bl(var1);
      this.b.h = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
      this.l.g = Gg3.bd(var1) == 1;
      this.l.d = Gg3.bd(var1);
      this.l.q = Gg3.bl(var1);
      this.l.j = Gg3.bl(var1);
      this.l.e = Gg3.bl(var1);
      this.l.h = Gg3.bl(var1);
      this.l.s = Gg3.bd(var1);
      this.l.b = Gg3.bl(var1);
      this.l.l = Gg3.bl(var1);
      this.w.g = Gg3.bd(var1);
      this.w.d = Gg3.bl(var1);
      this.w.q = Gg3.bd(var1);
      this.w.j = Gg3.bl(var1);
      this.w.e = Gg3.bl(var1);

      for(int var2 = 0; var2 < 3; ++var2) {
         By167 var3 = this.w.h[var2];
         var3.g = Gg3.bd(var1) == 1;
         var3.d = Gg3.bl(var1);
         var3.q = Gg3.bl(var1);
         var3.j = Gg3.bl(var1);
         var3.e = Gg3.bl(var1);
         var3.h = Gg3.bl(var1);
         var3.s = Gg3.bl(var1);
         var3.b = Gg3.bl(var1);
         var3.l = Gg3.bl(var1);
         var3.w = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
         var3.r = new Vector3(Gg3.bl(var1), Gg3.bl(var1), Gg3.bl(var1));
         var3.v = Gg3.bl(var1);
         var3.y = Gg3.bl(var1);
         var3.p = Gg3.bl(var1);
         var3.x = Gg3.bl(var1);
         var3.u = Gg3.bl(var1);
      }

   }

   public static void q(Bn70 var0, long var1) {
      long var3 = H149.j;
      Kc180.r(var3, v);
      long var5 = var3 + 4L;
      Kc180.v(var5, var0.g.g.x);
      var5 += 4L;
      Kc180.v(var5, var0.g.g.y);
      var5 += 4L;
      Kc180.v(var5, var0.g.g.z);
      var5 += 4L;
      Kc180.v(var5, var0.g.d.x);
      var5 += 4L;
      Kc180.v(var5, var0.g.d.y);
      var5 += 4L;
      Kc180.v(var5, var0.g.d.z);
      var5 += 4L;
      Kc180.v(var5, var0.g.q.x);
      var5 += 4L;
      Kc180.v(var5, var0.g.q.y);
      var5 += 4L;
      Kc180.v(var5, var0.g.q.z);
      var5 += 4L;
      Kc180.v(var5, var0.g.j);
      var5 += 4L;
      Kc180.v(var5, var0.g.e.x);
      var5 += 4L;
      Kc180.v(var5, var0.g.e.y);
      var5 += 4L;
      Kc180.v(var5, var0.g.e.z);
      var5 += 4L;
      Kc180.v(var5, var0.g.h);
      var5 += 4L;
      Kc180.v(var5, var0.g.s.x);
      var5 += 4L;
      Kc180.v(var5, var0.g.s.y);
      var5 += 4L;
      Kc180.v(var5, var0.g.s.z);
      var5 += 4L;
      Kc180.v(var5, var0.g.b);
      var5 += 4L;
      Kc180.v(var5, var0.g.l);
      var5 += 4L;
      Kc180.v(var5, var0.g.w);
      var5 += 4L;
      Kc180.r(var5, y);
      var5 += 4L;
      Kc180.v(var5, var0.d.d.x);
      var5 += 4L;
      Kc180.v(var5, var0.d.d.y);
      var5 += 4L;
      Kc180.v(var5, var0.d.d.z);
      var5 += 4L;
      Kc180.v(var5, var0.d.g.x);
      var5 += 4L;
      Kc180.v(var5, var0.d.g.y);
      var5 += 4L;
      Kc180.v(var5, var0.d.g.z);
      var5 += 4L;
      Kc180.v(var5, var0.d.q);
      var5 += 4L;
      Kc180.v(var5, var0.d.e);
      var5 += 4L;
      Kc180.v(var5, var0.d.j);
      var5 += 4L;
      Kc180.r(var5, p);
      var5 += 4L;
      Kc180.v(var5, var0.h.x);
      var5 += 4L;
      Kc180.v(var5, var0.h.y);
      var5 += 4L;
      Kc180.v(var5, var0.h.z);
      var5 += 4L;
      Kc180.v(var5, var0.q.x);
      var5 += 4L;
      Kc180.v(var5, var0.q.y);
      var5 += 4L;
      Kc180.v(var5, var0.q.z);
      var5 += 4L;
      Kc180.v(var5, var0.j.x);
      var5 += 4L;
      Kc180.v(var5, var0.j.y);
      var5 += 4L;
      Kc180.v(var5, var0.j.z);
      var5 += 4L;
      Kc180.v(var5, var0.e.x);
      var5 += 4L;
      Kc180.v(var5, var0.e.y);
      var5 += 4L;
      Kc180.v(var5, var0.e.z);
      var5 += 4L;
      Kc180.r(var5, x);
      var5 += 4L;
      Kc180.r(var5, var0.s.g ? 1 : 0);
      var5 += 4L;
      Kc180.r(var5, var0.s.d.length());
      var5 += 4L;

      int var7;
      for(var7 = 0; var7 < var0.s.d.length(); ++var7) {
         Kc180.l(var5, var0.s.d.charAt(var7));
         ++var5;
      }

      Kc180.v(var5, var0.s.q);
      var5 += 4L;
      Kc180.r(var5, var0.s.j ? 1 : 0);
      var5 += 4L;
      Kc180.v(var5, var0.s.e);
      var5 += 4L;
      Kc180.v(var5, var0.s.h);
      var5 += 4L;
      Kc180.r(var5, var0.s.s ? 1 : 0);
      var5 += 4L;
      Kc180.r(var5, u);
      var5 += 4L;
      Kc180.v(var5, var0.b.g);
      var5 += 4L;
      Kc180.v(var5, var0.b.d);
      var5 += 4L;
      Kc180.v(var5, var0.b.q);
      var5 += 4L;
      Kc180.v(var5, var0.b.j);
      var5 += 4L;
      Kc180.v(var5, var0.b.e);
      var5 += 4L;
      Kc180.v(var5, var0.b.h.x);
      var5 += 4L;
      Kc180.v(var5, var0.b.h.y);
      var5 += 4L;
      Kc180.v(var5, var0.b.h.z);
      var5 += 4L;
      Kc180.r(var5, z);
      var5 += 4L;
      Kc180.r(var5, var0.l.g ? 1 : 0);
      var5 += 4L;
      Kc180.r(var5, var0.l.d);
      var5 += 4L;
      Kc180.v(var5, var0.l.q);
      var5 += 4L;
      Kc180.v(var5, var0.l.j);
      var5 += 4L;
      Kc180.v(var5, var0.l.e);
      var5 += 4L;
      Kc180.v(var5, var0.l.h);
      var5 += 4L;
      Kc180.r(var5, var0.l.s);
      var5 += 4L;
      Kc180.v(var5, var0.l.b);
      var5 += 4L;
      Kc180.v(var5, var0.l.l);
      var5 += 4L;
      Kc180.r(var5, t);
      var5 += 4L;
      Kc180.r(var5, var0.w.g);
      var5 += 4L;
      Kc180.v(var5, var0.w.d);
      var5 += 4L;
      Kc180.r(var5, var0.w.q);
      var5 += 4L;
      Kc180.v(var5, var0.w.j);
      var5 += 4L;
      Kc180.v(var5, var0.w.e);
      var5 += 4L;

      for(var7 = 0; var7 < 3; ++var7) {
         By167 var8 = var0.w.h[var7];
         Kc180.r(var5, var8.g ? 1 : 0);
         var5 += 4L;
         Kc180.v(var5, var8.d);
         var5 += 4L;
         Kc180.v(var5, var8.q);
         var5 += 4L;
         Kc180.v(var5, var8.j);
         var5 += 4L;
         Kc180.v(var5, var8.e);
         var5 += 4L;
         Kc180.v(var5, var8.h);
         var5 += 4L;
         Kc180.v(var5, var8.s);
         var5 += 4L;
         Kc180.v(var5, var8.b);
         var5 += 4L;
         Kc180.v(var5, var8.l);
         var5 += 4L;
         Kc180.v(var5, var8.w.x);
         var5 += 4L;
         Kc180.v(var5, var8.w.y);
         var5 += 4L;
         Kc180.v(var5, var8.w.z);
         var5 += 4L;
         Kc180.v(var5, var8.r.x);
         var5 += 4L;
         Kc180.v(var5, var8.r.y);
         var5 += 4L;
         Kc180.v(var5, var8.r.z);
         var5 += 4L;
         Kc180.v(var5, var8.v);
         var5 += 4L;
         Kc180.v(var5, var8.y);
         var5 += 4L;
         Kc180.v(var5, var8.p);
         var5 += 4L;
         Kc180.v(var5, var8.x);
         var5 += 4L;
         Kc180.v(var5, var8.u);
         var5 += 4L;
      }

      Graphics.setEnvSettings(var1, var3);
   }

   static {
      v = r + 1;
      y = r + 2;
      p = r + 3;
      x = r + 4;
      u = r + 5;
      z = r + 6;
      t = r + 7;
   }
}
