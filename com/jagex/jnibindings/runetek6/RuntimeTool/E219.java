package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateEventManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class E219 implements ActionListener {
   // $FF: synthetic field
   final RuntimeTool g;

   public void actionPerformed(ActionEvent var1) {
      StateEventManager.sendEvent(this.g.as.getText());
   }

   E219(RuntimeTool var1) {
      this.g = var1;
   }
}
