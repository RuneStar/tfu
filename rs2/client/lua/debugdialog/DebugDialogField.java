package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JComponent;
import javax.swing.JTextField;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("DDField")
public class DebugDialogField extends DebugDialogComponent {
   final JTextField g;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetToolTip(String var1) {
      this.g.setToolTipText(var1);
   }

   public DebugDialogField(String var1) {
      this.g = new JTextField(var1);
      this.g.getDocument().addDocumentListener(new E325(this));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetValue(String var1) {
      this.g.setText(var1);
   }

   public JComponent g() {
      return this.g;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static DebugDialogField Create(String var0) {
      return new DebugDialogField(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String GetValue() {
      return this.g.getText();
   }
}
