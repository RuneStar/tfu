package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("DDTabSet")
public class DebugDialogTabSet extends DebugDialogComponent {
   final JTabbedPane g = new JTabbedPane();

   public JComponent g() {
      return this.g;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetSelectedTab(int var1) {
      this.g.setSelectedIndex(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void AddTab(String var1, DebugDialogComponent var2) {
      this.g.addTab(var1, var2.g());
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetSelectedTab() {
      return this.g.getSelectedIndex();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetTabToolTip(int var1, String var2) {
      this.g.setToolTipTextAt(var1, var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static DebugDialogTabSet Create() {
      return new DebugDialogTabSet();
   }
}
