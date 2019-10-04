package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class K225 implements ActionListener {
   N220 g;
   // $FF: synthetic field
   final RuntimeTool d;

   K225(RuntimeTool var1) {
      this.d = var1;
      this.g = (N220)this.d.ac.lastElement();
   }

   public void actionPerformed(ActionEvent var1) {
      this.g.s.setText(this.g.s.getText().equals("true") ? "false" : "true");
      this.g.j();
   }
}
