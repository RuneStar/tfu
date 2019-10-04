package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class E325 implements DocumentListener {
   // $FF: synthetic field
   final DebugDialogField g;

   public void removeUpdate(DocumentEvent var1) {
      g(this);
   }

   E325(DebugDialogField var1) {
      this.g = var1;
   }

   public void changedUpdate(DocumentEvent var1) {
      g(this);
   }

   public void insertUpdate(DocumentEvent var1) {
      g(this);
   }

   private static void g(E325 var0) {
      EventHandler var1 = (EventHandler)var0.g.q.get(StringTools.l("onChange"));
      if (var1 != null) {
         DebugDialog.g(var1, var0.g, (Object)null);
      }

   }
}
