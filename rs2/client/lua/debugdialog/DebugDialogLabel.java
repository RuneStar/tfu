package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JComponent;
import javax.swing.JLabel;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("DDLabel")
public class DebugDialogLabel extends DebugDialogComponent {
   final JLabel g;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String GetText() {
      return this.g.getText();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static DebugDialogLabel Create(String var0, int var1) {
      return new DebugDialogLabel(var0, var1);
   }

   public DebugDialogLabel(String var1, int var2) {
      this.g = new JLabel(var1, var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetText(String var1) {
      this.g.setText(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetToolTip(String var1) {
      this.g.setToolTipText(var1);
   }

   public JComponent g() {
      return this.g;
   }
}
