package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class W224 implements ActionListener {
   // $FF: synthetic field
   final RuntimeTool d;
   // $FF: synthetic field
   final String g;

   public void actionPerformed(ActionEvent var1) {
      RuntimeTool.i(this.d, this.g);
   }

   W224(RuntimeTool var1, String var2) {
      this.g = var2;
      this.d = var1;
   }
}
