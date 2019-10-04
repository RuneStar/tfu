package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class J375 implements ChangeListener {
   // $FF: synthetic field
   final DebugDialogCheckBox g;

   public void stateChanged(ChangeEvent var1) {
      EventHandler var2 = (EventHandler)this.g.q.get(StringTools.l("onChange"));
      if (var2 != null) {
         DebugDialog.g(var2, this.g, (Object)null);
      }

   }

   J375(DebugDialogCheckBox var1) {
      this.g = var1;
   }
}
