package com.jagex.game.runetek6.scenegraph;

import java.util.Iterator;

class G484 implements Iterator {
   private SceneGraphNode d;
   private SceneGraphNode g;
   // $FF: synthetic field
   final Q255 q;

   public boolean hasNext() {
      return this.d != null;
   }

   public static SceneGraphNode g(G484 var0) {
      var0.g = var0.d;
      var0.d = var0.d.b;
      return var0.g;
   }

   public void remove() {
      this.g.ag((SceneGraphNode)null, (String)null);
      Scene var1 = this.g.getScene();
      if (var1 != null) {
         Scene.w(var1, this.g);
      }

      this.g = null;
   }

   G484(Q255 var1) {
      this.q = var1;
      this.d = this.q.g.s;
   }
}
