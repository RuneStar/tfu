package com.jagex.game.runetek6.xelement;

import java.util.HashMap;
import java.util.Map;
import tfu.Gg3;
import tfu.Hp62;
import tfu.Ia63;

public class Bj61 implements Hp62 {
   public static final Ia63 d = new K67();
   private Map g = new HashMap();

   public static Bj61 q(Gg3 var0) throws Au64 {
      // $FF: Couldn't be decompiled
   }

   public static void g(Bj61 var0, Map var1) {
      var1.putAll(var0.g);
   }

   public static void d(Bj61 var0, Integer var1, Object var2) {
      var0.g.put(var1, var2);
   }

   public void onAllRefsReleased() {
   }
}
