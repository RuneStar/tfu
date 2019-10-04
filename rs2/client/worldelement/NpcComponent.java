package rs2.client.worldelement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
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
public final class NpcComponent extends Component implements VarDomain, Q290, G53 {
   public static final int d = StringTools.l(NpcComponent.class.getName());
   private final Npc g;

   public boolean canModifyVarValue(VarType var1) {
      return this.g.canModifyVarValue(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return d;
   }

   NpcComponent(Npc var1) {
      this.g = var1;
   }

   public int getVarValueInt(VarType var1) {
      return this.g.getVarValueInt(var1);
   }

   public void setVarValueInt(VarType var1, int var2) {
      this.g.setVarValueInt(var1, var2);
   }

   public long getVarValueLong(VarType var1) {
      return this.g.getVarValueLong(var1);
   }

   public void setVarValueLong(VarType var1, long var2) {
      this.g.setVarValueLong(var1, var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void triggerEvent(@ScriptID Integer var1, Object var2) {
      this.getEntity().triggerEvent(var1, var2);
   }

   public void setVarValue(VarType var1, Object var2) {
      this.g.setVarValue(var1, var2);
   }

   public int getVarBitValue(VarBitType var1) {
      return this.g.getVarBitValue(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeAllEventHandlers(@ScriptID Integer var1) {
      this.getEntity().removeAllEventHandlers(var1);
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
   public void addEventHandlerByID(@ScriptID Integer var1, EventHandler var2) {
      this.getEntity().addEventHandlerByID(var1, var2);
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
   public void addEventHandler(String var1, EventHandler var2) {
      this.getEntity().addEventHandler(var1, var2);
   }

   public void removeEventHandler(String var1, EventHandler var2) {
      this.getEntity().removeEventHandler(var1, var2);
   }

   public boolean br(String var1) {
      return this.g.br(var1);
   }

   public Object getVarValue(VarType var1) {
      return this.g.getVarValue(var1);
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
   public String GetName() {
      return this.g.GetName();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object GetVarBit(int var1) {
      return this.g.GetVarBit(var1);
   }

   public void setVarBitValue(VarBitType var1, int var2) throws VarBitOverflowException {
      this.g.setVarBitValue(var1, var2);
   }
}
