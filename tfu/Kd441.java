package tfu;

import com.jagex.maths.Z165;

public class Kd441 extends It12 {
   public final float[] d;
   public final float[] g;

   private Kd441(float[] var1, float[] var2) {
      this.g = var1;
      this.d = var2;
   }

   public static Kd441 e(Gg3 var0, Z165 var1, boolean var2, boolean var3) {
      Z165.q(var1);
      Gg3.bm(var0);
      int var4 = Gg3.bm(var0);
      float[] var5 = new float[var4];
      float[] var6 = new float[var4];

      for(int var7 = 0; var7 < var4; ++var7) {
         var5[var7] = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
         var6[var7] = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
      }

      return new Kd441(var5, var6);
   }

   public Ie21 g() {
      return Ie21.CONVEX_2D_POLYGON;
   }
}
