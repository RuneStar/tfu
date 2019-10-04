package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("DDSelectionBox")
public class DebugDialogSelectionBox extends DebugDialogComponent {
   final JComboBox d;
   final DefaultComboBoxModel g = new DefaultComboBoxModel();

   public DebugDialogSelectionBox(String[] var1) {
      String[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         this.g.addElement(var5);
      }

      this.d = new JComboBox(this.g);
      this.d.addActionListener(new D374(this));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetValues(String[] var1) {
      this.g.removeAllElements();
      String[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         this.g.addElement(var5);
      }

   }

   public JComponent g() {
      return this.d;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetSelectedIndex(int var1) {
      this.d.setSelectedIndex(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetSelectedIndex() {
      return this.d.getSelectedIndex();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetToolTip(String var1) {
      this.d.setToolTipText(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static DebugDialogSelectionBox Create(String[] var0) {
      return new DebugDialogSelectionBox(var0);
   }
}
