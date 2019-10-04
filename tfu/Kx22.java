package tfu;

import com.jagex.maths.Z165;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kx22 extends It12 {
   static final int[] h = new int[]{0, 1, 1, 5, 5, 4, 4, 0, 2, 3, 3, 7, 7, 6, 6, 2, 0, 2, 1, 3, 5, 7, 4, 6};
   private static final Logger logger = LoggerFactory.getLogger(Kx22.class);
   public final float d;
   public final String e;
   public final float j;
   public final float q;

   public static Kx22 e(Gg3 var0, Z165 var1, boolean var2, boolean var3) {
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
      float var7 = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
      if (var2) {
         Object[] var8 = new Object[]{var5, var6, var7, var1.g, var1.d};
         logger.info("    box sizes: {},{},{}, orientation: {} local position: {}", var8);
      }

      return new Kx22(var5, var6, var7, var4);
   }

   public Ie21 g() {
      return Ie21.BOX;
   }

   public Kx22(float var1, float var2, float var3, String var4) {
      this.d = var1;
      this.q = var2;
      this.j = var3;
      this.e = var4;
   }
}
