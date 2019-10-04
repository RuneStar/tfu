package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class P214 extends MouseAdapter {
   // $FF: synthetic field
   final RuntimeTool g;

   public void mouseClicked(MouseEvent var1) {
      RuntimeTool.m(this.g, var1);
   }

   P214(RuntimeTool var1) {
      this.g = var1;
   }
}
