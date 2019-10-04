package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;

public class Q7 {
   public static final Q7 q;
   public final M47 d;
   public final Vector3 g;

   public boolean equals(Object var1) {
      if (!(var1 instanceof Q7)) {
         return false;
      } else {
         Q7 var2 = (Q7)var1;
         return var2.d.equals(this.d) && Vector3.v(var2.g, this.g);
      }
   }

   public Q7 h(I48 var1) {
      Vector3 var2 = Vector3.t(this.g, var1);
      return new Q7(this.d, var2);
   }

   public static Q7 g(RotTrans var0) {
      return new Q7(var0.rot.m(), var0.trans);
   }

   public Q7(M47 var1, Vector3 var2) {
      this.g = var2;
      this.d = var1;
   }

   public Q7 s(M47 var1) {
      M47 var2 = this.d.h(var1);
      return new Q7(var2, this.g);
   }

   public Q7 e(Vector3 var1) {
      Vector3 var2 = Vector3.z(this.g, var1);
      return new Q7(this.d, var2);
   }

   public static RotTrans d(Q7 var0) {
      return var0 == null ? null : var0.q();
   }

   static {
      q = new Q7(M47.g, Vector3.g);
   }

   public Q7 j(float var1) {
      return new Q7(this.d, this.g.an(var1));
   }

   public RotTrans q() {
      return new RotTrans(this.d.q(), this.g);
   }
}
