package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JButton;
import javax.swing.JComponent;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("DDButton")
public class DebugDialogButton extends DebugDialogComponent {
   final JButton g;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static DebugDialogButton Create(String var0) {
      return new DebugDialogButton(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetToolTip(String var1) {
      this.g.setToolTipText(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetCaption(String var1) {
      this.g.setText(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String GetCaption() {
      return this.g.getText();
   }

   public JComponent g() {
      return this.g;
   }

   public DebugDialogButton(String var1) {
      this.g = new JButton(var1);
      this.g.addActionListener(new Q565(this));
   }
}
