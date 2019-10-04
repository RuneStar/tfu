/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.worldelement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.variables.G53;
import rs2.client.lua.Q290;
import rs2.client.worldelement.Npc;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public final class NpcComponent
extends Component
implements VarDomain,
Q290,
G53 {
    public static final int d = StringTools.l(NpcComponent.class.getName());
    private final Npc g;

    @Override
    public boolean canModifyVarValue(VarType varType) {
        return this.g.canModifyVarValue(varType);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return d;
    }

    NpcComponent(Npc npc) {
        this.g = npc;
    }

    @Override
    public int getVarValueInt(VarType varType) {
        return this.g.getVarValueInt(varType);
    }

    @Override
    public void setVarValueInt(VarType varType, int n) {
        this.g.setVarValueInt(varType, n);
    }

    @Override
    public long getVarValueLong(VarType varType) {
        return this.g.getVarValueLong(varType);
    }

    @Override
    public void setVarValueLong(VarType varType, long l) {
        this.g.setVarValueLong(varType, l);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void triggerEvent(@ScriptID Integer n, Object object) {
        this.getEntity().triggerEvent(n, object);
    }

    @Override
    public void setVarValue(VarType varType, Object object) {
        this.g.setVarValue(varType, object);
    }

    @Override
    public int getVarBitValue(VarBitType varBitType) {
        return this.g.getVarBitValue(varBitType);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeAllEventHandlers(@ScriptID Integer n) {
        this.getEntity().removeAllEventHandlers(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void SetVar(String string, Object object) throws VarBitOverflowException {
        this.g.SetVar(string, object);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandlerByID(@ScriptID Integer n, EventHandler eventHandler) {
        this.getEntity().addEventHandlerByID(n, eventHandler);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarByIndex(int n, Object object) {
        this.g.SetVarByIndex(n, object);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarBit(int n, Object object) throws VarBitOverflowException {
        this.g.SetVarBit(n, object);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarByIndex(int n) {
        return this.g.GetVarByIndex(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandler(String string, EventHandler eventHandler) {
        this.getEntity().addEventHandler(string, eventHandler);
    }

    @Override
    public void removeEventHandler(String string, EventHandler eventHandler) {
        this.getEntity().removeEventHandler(string, eventHandler);
    }

    @Override
    public boolean br(String string) {
        return this.g.br(string);
    }

    @Override
    public Object getVarValue(VarType varType) {
        return this.g.getVarValue(varType);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public Object GetVar(String string) {
        return this.g.GetVar(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public String GetName() {
        return this.g.GetName();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarBit(int n) {
        return this.g.GetVarBit(n);
    }

    @Override
    public void setVarBitValue(VarBitType varBitType, int n) throws VarBitOverflowException {
        this.g.setVarBitValue(varBitType, n);
    }
}

