package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("DDBorderPanel")
public class DebugDialogBorderPanel extends DebugDialogComponent {
   final JPanel g = new JPanel();

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void AddComponentSouth(DebugDialogComponent var1) {
      this.g.add(var1.g(), "South");
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void AddComponentEast(DebugDialogComponent var1) {
      this.g.add(var1.g(), "East");
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void AddComponentCentre(DebugDialogComponent var1) {
      this.g.add(var1.g(), "Center");
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void AddComponentNorth(DebugDialogComponent var1) {
      this.g.add(var1.g(), "North");
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static DebugDialogBorderPanel Create() {
      return new DebugDialogBorderPanel();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void AddComponentWest(DebugDialogComponent var1) {
      this.g.add(var1.g(), "West");
   }

   JComponent g() {
      return this.g;
   }

   public DebugDialogBorderPanel() {
      this.g.setLayout(new BorderLayout());
   }
}
