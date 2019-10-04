package rs2.shared.movement;

import com.jagex.maths.Vector3;

public class Av190 {
   public final float d;
   public final Vector3 g;
   public final int j;
   public final float q;

   public static boolean g(Av190 var0, Av190 var1) {
      return var1 != null && Vector3.v(var0.g, var1.g) && var0.d == var1.d && var0.j == var1.j && var0.q == var1.q;
   }

   public Av190(Vector3 var1, float var2, int var3, float var4) {
      this.g = var1;
      this.d = var2;
      this.j = var3;
      this.q = var4;
   }
}
