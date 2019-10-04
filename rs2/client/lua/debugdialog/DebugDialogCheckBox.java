package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("DDCheckBox")
public class DebugDialogCheckBox extends DebugDialogComponent {
   final JCheckBox g;

   public DebugDialogCheckBox(boolean var1) {
      this.g = new JCheckBox("", var1);
      this.g.addChangeListener(new J375(this));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static DebugDialogCheckBox Create(boolean var0) {
      return new DebugDialogCheckBox(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetValue(boolean var1) {
      this.g.setSelected(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean GetValue() {
      return this.g.isSelected();
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
