package tfu;

import com.jagex.maths.C306;
import com.jagex.maths.Vector3;
import com.jagex.maths.Z165;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kb24 extends It12 {
   private static final Logger logger = LoggerFactory.getLogger(Kb24.class);
   public final Vector3[] d;
   private C306[] j = null;
   public final String q;

   public static Kb24 e(Gg3 var0, Z165 var1, boolean var2, boolean var3) {
      Z165.q(var1);
      Gg3.bm(var0);
      String var4 = var0.bp();
      int var5 = Gg3.bm(var0);
      Vector3[] var6 = new Vector3[var5];

      for(int var7 = 0; var7 < var5; ++var7) {
         float var8 = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
         float var9 = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
         float var10 = Gg3.bw(var0) * (var3 ? Ai354.q : 1.0F);
         var6[var7] = new Vector3(var8, var9, var10);
      }

      if (var2) {
         logger.info("    convex hull: material = \"{}\" numVertices = {}", var4, var5);
      }

      return new Kb24(var6, var4);
   }

   public Ie21 g() {
      return Ie21.CONVEX_HULL;
   }

   public Kb24(Vector3[] var1, String var2) {
      this.d = var1;
      this.q = var2;
   }
}
