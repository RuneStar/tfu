package com.jagex.game.runetek6.xelement;

import tfu.Gg3;

public class W14 {
   private int d;
   public float e = 1.0F;
   public String g;
   public float h = 512.0F;
   public float j = 0.0F;
   private int q;
   public short[] s;

   public static int g(W14 var0) {
      return var0.d;
   }

   public static int d(W14 var0) {
      return var0.q;
   }

   public static void j(W14 var0, Gg3 var1) {
      Gg3.k(var1, O558.MISC_PROPERTIES.e);
      Gg3.i(var1, g(var0));
      Gg3.i(var1, d(var0));
      Gg3.aq(var1, var0.j);
      Gg3.aq(var1, var0.e);
      Gg3.aq(var1, var0.h);
      Gg3.k(var1, O558.HEIGHT_MAP.e);
      int var2 = var1.v += 4;
      short var3 = 0;

      for(int var4 = 0; var4 < var0.s.length; ++var4) {
         Gg3.aw(var1, var0.s[var4] - var3);
         var3 = var0.s[var4];
      }

      Gg3.am(var1, var1.v - var2);
      if (var0.g != null) {
         Gg3.k(var1, O558.XML.e);
         Gg3.a(var1, Gg3.av(var0.g));
         var1.ap(var0.g);
      }

      Gg3.k(var1, 0);
   }

   public static W14 q(Gg3 var0) throws Au64 {
      // $FF: Couldn't be decompiled
   }
}
