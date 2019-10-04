package com.jagex.game.runetek6.scenegraph;

import com.jagex.jnibindings.runetek6.Light;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class L170 extends SceneGraphNode {
   private static final Logger logger = LoggerFactory.getLogger(L170.class);
   Vector3 k;
   float n;

   private static void j(L170 var0) {
      var0.v = Light.create();
      if (var0.v == 0L) {
         logger.error("Uh-oh, failed to allocate another Light.  Light pool probably full.");
      } else {
         Light.setParams(var0.v, 0.0F, 0.0F, 0.0F, var0.n, var0.k.x, var0.k.y, var0.k.z);
      }
   }

   public void l() {
      if (super.v != 0L) {
         Light.destroy(super.v);
         super.v = 0L;
      }

   }

   public L170(Vector3 var1, float var2, Vector3 var3) {
      this.n = var2;
      this.k = var3;
      j(this);
      if (var1 != null) {
         w(this, var1);
      }

   }
}
