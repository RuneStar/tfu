package tfu;

import com.jagex.maths.O166;
import com.jagex.maths.Z165;

public class Kk26 extends It12 {
   public final String d;
   public final float g;

   public static Kk26 e(Gg3 var0, Z165 var1, boolean var2, boolean var3) {
      Gg3.bm(var0);
      String var4 = var0.bp();
      O166.v(var1.g);
      var1.d.j = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
      var1.d.e = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
      var1.d.h = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
      float var5 = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
      return new Kk26(var5, var4);
   }

   public Kk26(float var1, String var2) {
      this.g = var1;
      this.d = var2;
   }

   public Ie21 g() {
      return Ie21.SPHERE;
   }
}
