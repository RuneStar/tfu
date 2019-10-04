package tfu;

import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ms517 {
   private static boolean d = false;
   private static final Logger logger = LoggerFactory.getLogger(Ms517.class);

   public DiscreteDynamicsWorld q(float var1, Vector3 var2) {
      g();
      byte var3 = 1;
      int var4 = 100000;
      int var5 = 100000;
      byte var6 = 100;
      short var7 = 1000;
      short var8 = 1000;
      short var9 = 1000;
      DiscreteDynamicsWorld var10 = new DiscreteDynamicsWorld(var3, var4, var5, var6, var7, var8, var9, var1);
      var10.d(var2);
      return var10;
   }

   public static Ms517 d() {
      if (!d) {
         g();
         d = true;
      }

      return new Ms517();
   }

   private static void g() {
      Ks126 var0 = Kt125.d();
      if (var0.j("jagbullet") && !var0.e("jagbullet")) {
         logger.info("Loading jagbullet!");
         if (!var0.h("jagbullet")) {
            throw new RuntimeException("Failed to load jagbullet");
         }
      }

   }
}
