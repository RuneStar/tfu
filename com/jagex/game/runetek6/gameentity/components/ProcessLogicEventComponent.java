package com.jagex.game.runetek6.gameentity.components;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class ProcessLogicEventComponent extends Component {
   public static final int g = StringTools.l(ProcessLogicEventComponent.class.getName());

   public static void g(ProcessLogicEventComponent var0, float var1) {
      var0.getEntity().eh("__processLogic", var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return g;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static ProcessLogicEventComponent create() {
      return new ProcessLogicEventComponent();
   }
}
