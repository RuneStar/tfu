package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class D374 implements ActionListener {
   // $FF: synthetic field
   final DebugDialogSelectionBox g;

   D374(DebugDialogSelectionBox var1) {
      this.g = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      EventHandler var2 = (EventHandler)this.g.q.get(StringTools.l("onChange"));
      if (var2 != null) {
         DebugDialog.g(var2, this.g, (Object)null);
      }

   }
}
