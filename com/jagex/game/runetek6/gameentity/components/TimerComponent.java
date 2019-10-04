package com.jagex.game.runetek6.gameentity.components;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.ArrayList;
import java.util.List;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("Timer")
public class TimerComponent extends Component {
   public static final int d = StringTools.l(TimerComponent.class.getName());
   private List g = new ArrayList();

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return d;
   }

   public static void g(TimerComponent var0, float var1) {
      for(int var2 = var0.g.size() - 1; var2 >= 0; --var2) {
         G268 var3 = (G268)var0.g.get(var2);
         if ((var3.g -= var1) < 0.0F) {
            var3.d.trigger(var0.getEntity(), (Object)null);
            var0.g.remove(var2);
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void addEvent(float var1, EventHandler var2) {
      this.g.add(new G268(var1, var2));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static TimerComponent create() {
      return new TimerComponent();
   }
}
