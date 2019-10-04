package tfu;

import com.jagex.maths.Z165;

public class Kw23 extends It12 {
   public final float d;
   public final float g;
   public final String q;

   public static Kw23 e(Gg3 var0, Z165 var1, boolean var2, boolean var3) {
      Gg3.bm(var0);
      String var4 = var0.bp();
      var1.g.j = Gg3.bw(var0);
      var1.g.e = Gg3.bw(var0);
      var1.g.h = Gg3.bw(var0);
      var1.g.s = Gg3.bw(var0);
      var1.d.j = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
      var1.d.e = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
      var1.d.h = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
      float var5 = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
      float var6 = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
      return new Kw23(var5, var6, var4);
   }

   public Ie21 g() {
      return Ie21.CAPSULE;
   }

   public Kw23(float var1, float var2, String var3) {
      this.g = var1;
      this.d = var2;
      this.q = var3;
   }
}
