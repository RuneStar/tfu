package com.jagex.game.runetek6.scenegraph;

class J367 implements Runnable {
   // $FF: synthetic field
   final boolean d;
   // $FF: synthetic field
   final SceneGraphNode g;
   // $FF: synthetic field
   final Scene j;
   // $FF: synthetic field
   final boolean q;

   public void run() {
      this.j.remove(this.g, this.d, this.q);
   }

   J367(Scene var1, SceneGraphNode var2, boolean var3, boolean var4) {
      this.g = var2;
      this.d = var3;
      this.q = var4;
      this.j = var1;
   }
}
