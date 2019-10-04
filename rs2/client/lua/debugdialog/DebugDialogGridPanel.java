package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("DDGridPanel")
public class DebugDialogGridPanel extends DebugDialogComponent {
   final JPanel g = new JPanel();

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static DebugDialogGridPanel Create(int var0, int var1) {
      return new DebugDialogGridPanel(var0, var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void AddComponent(DebugDialogComponent var1) {
      this.g.add(var1.g());
   }

   JComponent g() {
      return this.g;
   }

   public DebugDialogGridPanel(int var1, int var2) {
      this.g.setLayout(new GridLayout(var1, var2));
   }
}
