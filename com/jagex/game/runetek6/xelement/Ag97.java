package com.jagex.game.runetek6.xelement;

import com.jagex.maths.V198;
import com.jagex.maths.Vector3;

public enum Ag97 {
   d(Double.class, "number"),
   e(V198.class, "vector4"),
   g(String.class, "string"),
   j(Vector3.class, "vector3"),
   q(Boolean.class, "boolean");

   public final Class h;
   public final String s;

   private Ag97(Class var3, String var4) {
      this.h = var3;
      this.s = var4;
   }

   // $FF: synthetic method
   Ag97(Class var3, String var4, Z98 var5) {
      this(var3, var4);
   }
}
