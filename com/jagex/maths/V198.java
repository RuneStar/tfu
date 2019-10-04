package com.jagex.maths;

import tfu.Gg3;
import tfu.Kl267;

public final class V198 implements Kl267, B164 {
   public static final V198 g = new V198(0.0F, 0.0F, 0.0F, 0.0F);
   public final float d;
   public final float e;
   public final float j;
   public final float q;

   public String toString() {
      return this.d + "," + this.q + "," + this.j + "," + this.e;
   }

   public V198(Gg3 var1) {
      this.d = Gg3.bl(var1);
      this.q = Gg3.bl(var1);
      this.j = Gg3.bl(var1);
      this.e = Gg3.bl(var1);
   }

   public static void g(V198 var0, Gg3 var1) {
      Gg3.aq(var1, var0.d);
      Gg3.aq(var1, var0.q);
      Gg3.aq(var1, var0.j);
      Gg3.aq(var1, var0.e);
   }

   public static V198 d(V198 var0) {
      return var0;
   }

   public V198(float var1, float var2, float var3, float var4) {
      this.d = var1;
      this.q = var2;
      this.j = var3;
      this.e = var4;
   }
}
