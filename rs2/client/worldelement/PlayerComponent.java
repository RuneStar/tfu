package rs2.client.worldelement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.variables.G53;
import rs2.client.lua.Q290;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class PlayerComponent extends Component implements Q290, G53 {
   public static final int d = StringTools.l(PlayerComponent.class.getName());
   public final player g;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeEventHandler(String var1, EventHandler var2) {
      this.g.removeEventHandler(var1, var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVar(String var1, Object var2) throws VarBitOverflowException {
      this.g.SetVar(var1, var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return d;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String GetName() {
      return this.g.aq == null ? "" : this.g.aq;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void triggerEvent(@ScriptID Integer var1, Object var2) {
      this.g.triggerEvent(var1, var2);
   }

   public boolean br(String var1) {
      return this.g.br(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object GetVar(String var1) {
      return this.g.GetVar(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVarByIndex(int var1, Object var2) {
      this.g.SetVarByIndex(var1, var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVarBit(int var1, Object var2) throws VarBitOverflowException {
      this.g.SetVarBit(var1, var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object GetVarByIndex(int var1) {
      return this.g.GetVarByIndex(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void addEventHandlerByID(@ScriptID Integer var1, EventHandler var2) {
      this.g.addEventHandlerByID(var1, var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void addEventHandler(String var1, EventHandler var2) {
      this.g.addEventHandler(var1, var2);
   }

   PlayerComponent(player var1) {
      this.g = var1;
   }

   public String toString() {
      return super.toString() + ":" + this.g.aq;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeAllEventHandlers(@ScriptID Integer var1) {
      this.g.removeAllEventHandlers(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object GetVarBit(int var1) {
      return this.g.GetVarBit(var1);
   }
}
