package com.jagex.game.runetek6.xelement;

import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;
import tfu.Hp62;
import tfu.Ia63;

public class Bh77 extends N78 implements Hp62 {
   public static final Ia63 d = new Bp83();
   public String b;
   public Bn70 e;
   private Q79 h = new Q79();
   public W14 j;
   public String l;
   public byte[] q;
   public String r;
   private String s;
   public String w;

   public int d(String var1) {
      return Q79.d(this.h, var1);
   }

   public void j(String var1) {
      Q79.g(this.h, var1);
   }

   public static Bh77 w(Gg3 var0, D80 var1) throws Au64 {
      // $FF: Couldn't be decompiled
   }

   public String q(int var1) {
      return Q79.q(this.h, var1);
   }

   public void onAllRefsReleased() {
   }

   public Bh77(D80 var1) {
      super(var1);
   }

   public static void p(Bh77 var0, String var1) {
      var0.s = var1;
   }

   public static String v(Bh77 var0) {
      return var0.s;
   }

   public void r(Gg3 var1, Hk84 var2, Hg85 var3, Hi86 var4) {
      int var5;
      if (this.j != null) {
         Gg3.k(var1, Af81.TERRAIN.v);
         var5 = var1.v += 4;
         W14.j(this.j, var1);
         Gg3.am(var1, var1.v - var5);
      }

      if (v(this) != null) {
         Gg3.k(var1, Af81.NAVMESH_REF_CHUNK.v);
         Gg3.a(var1, Gg3.av(v(this)));
         var1.ap(v(this));
      }

      if (this.e != null) {
         Gg3.k(var1, Af81.ENVSETTINGS_CHUNK.v);
         var5 = var1.v += 4;
         Bn70.g(this.e, var1);
         Gg3.am(var1, var1.v - var5);
      }

      if (this.b != null) {
         Gg3.k(var1, Af81.GROUND_COVER_CHUNK.v);
         Gg3.a(var1, Gg3.av(this.b));
         var1.ap(this.b);
      }

      if (this.r != null) {
         Gg3.k(var1, Af81.SOURCE_PATH.v);
         Gg3.a(var1, Gg3.av(this.r));
         var1.ap(this.r);
      }

      if (this.l != null) {
         Gg3.k(var1, Af81.IRRADIANCE_VOLUMES_CHUNK.v);
         Gg3.a(var1, Gg3.av(this.l));
         var1.ap(this.l);
      }

      if (this.w != null) {
         Gg3.k(var1, Af81.UMBRA_SCENE_CHUNK.v);
         Gg3.a(var1, Gg3.av(this.w));
         var1.ap(this.w);
      }

      Gg3.k(var1, Af81.PROPERTY_NAME_TABLE.v);
      var5 = var1.v += 4;
      Q79.j(this.h, var1);
      Gg3.am(var1, var1.v - var5);
      Gg3.k(var1, Af81.SUPER_TYPE_PROPERTIES.v);
      var5 = var1.v += 4;
      super.r(var1, var2, var3, var4);
      Gg3.am(var1, var1.v - var5);
      Gg3.k(var1, 0);
   }
}
