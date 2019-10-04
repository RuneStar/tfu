package com.jagex.game.runetek6.scenegraph;

import com.jagex.jnibindings.runetek6.ParticleEngine;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class D75 extends SceneGraphNode {
   private static final Logger logger = LoggerFactory.getLogger(D75.class);
   String n;

   public void l() {
      if (super.v != 0L) {
         ParticleEngine.deleteSystem(super.v);
         super.v = 0L;
      }

   }

   private static void j(D75 var0) {
      var0.v = ParticleEngine.createSystem(var0.n);
      if (var0.v == 0L) {
         logger.error("Uh-oh, failed to allocate another Particle System.  Particle System pool probably full.");
      }

   }

   protected void af(boolean var1) {
      if (super.v != 0L) {
         ParticleEngine.setEnabled(super.v, var1);
         ParticleEngine.reset(super.v);
      }

   }

   public D75(Vector3 var1, Quaternion var2, String var3) {
      this.n = var3;
      j(this);
      if (var1 != null) {
         w(this, var1);
      }

      if (var2 != null) {
         this.setObjectRotation(var2);
      }

   }
}
