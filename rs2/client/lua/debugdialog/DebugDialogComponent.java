package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.HashMap;
import javax.swing.JComponent;
import tfu.Be2;
import tfu.Bs1;

public abstract class DebugDialogComponent {
   final HashMap q = new HashMap();

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetEventHandler(String var1, EventHandler var2) {
      if (var2 == null) {
         this.q.remove(StringTools.l(var1));
      } else {
         this.q.put(StringTools.l(var1), var2);
      }

   }

   abstract JComponent g();
}
