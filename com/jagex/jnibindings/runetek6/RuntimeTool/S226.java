package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class S226 implements ActionListener {
   // $FF: synthetic field
   final RuntimeTool g;

   S226(RuntimeTool var1) {
      this.g = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.g.z.setText(RuntimeTool.a(this.g));
   }
}
