package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import java.awt.Component;
import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class DebugDialog extends RuntimeTool {
   private static final long d = 1L;
   public static DebugDialog j;
   private static final Logger logger = LoggerFactory.getLogger(DebugDialog.class);
   static Stack q = new Stack();

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static DebugDialog Create(String var0) {
      if (j != null) {
         logger.error("creation of the second instance of DebugDialog");
      }

      j = new DebugDialog();
      return j;
   }

   static void g(EventHandler var0, DebugDialogComponent var1, Object var2) {
      Stack var3 = q;
      synchronized(var3) {
         q.push(new G697(var0, var1, var2));
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetTitle(String var1) {
      this.setTitle(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void Show() {
      this.pack();
      this.setLocationRelativeTo((Component)null);
      this.setVisible(true);
   }

   public static void d(DebugDialog var0) {
      var0.dispose();
      j = null;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void Hide() {
      this.setVisible(false);
   }

   public static void q(ScriptManager var0) {
      if (var0 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else {
         var0.registerScriptAPI(DebugDialog.class);
         var0.registerScriptAPI(DebugDialogBorderPanel.class);
         var0.registerScriptAPI(DebugDialogButton.class);
         var0.registerScriptAPI(DebugDialogCheckBox.class);
         var0.registerScriptAPI(DebugDialogField.class);
         var0.registerScriptAPI(DebugDialogGridPanel.class);
         var0.registerScriptAPI(DebugDialogLabel.class);
         var0.registerScriptAPI(DebugDialogSelectionBox.class);
         var0.registerScriptAPI(DebugDialogTabSet.class);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetContent(DebugDialogComponent var1) {
      super.v.addTab("DebugOptions", var1.g());
   }
}
