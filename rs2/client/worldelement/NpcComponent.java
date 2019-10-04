// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.worldelement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.script.ScriptID;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.variables.G53;
import rs2.client.lua.Q290;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.gameentity.Component;

@ScriptEntryClass
public final class NpcComponent extends Component implements VarDomain, Q290, G53
{
    public static final int d;
    private final Npc g;
    
    @Override
    public boolean canModifyVarValue(final VarType varType) {
        return this.g.canModifyVarValue(varType);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static int getComponentTypeID() {
        return NpcComponent.d;
    }
    
    NpcComponent(final Npc g) {
        this.g = g;
    }
    
    @Override
    public int getVarValueInt(final VarType varType) {
        return this.g.getVarValueInt(varType);
    }
    
    @Override
    public void setVarValueInt(final VarType varType, final int n) {
        this.g.setVarValueInt(varType, n);
    }
    
    @Override
    public long getVarValueLong(final VarType varType) {
        return this.g.getVarValueLong(varType);
    }
    
    @Override
    public void setVarValueLong(final VarType varType, final long n) {
        this.g.setVarValueLong(varType, n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void triggerEvent(@ScriptID final Integer n, final Object o) {
        this.getEntity().triggerEvent(n, o);
    }
    
    @Override
    public void setVarValue(final VarType varType, final Object o) {
        this.g.setVarValue(varType, o);
    }
    
    @Override
    public int getVarBitValue(final VarBitType varBitType) {
        return this.g.getVarBitValue(varBitType);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeAllEventHandlers(@ScriptID final Integer n) {
        this.getEntity().removeAllEventHandlers(n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void SetVar(final String s, final Object o) throws VarBitOverflowException {
        this.g.SetVar(s, o);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandlerByID(@ScriptID final Integer n, final EventHandler eventHandler) {
        this.getEntity().addEventHandlerByID(n, eventHandler);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarByIndex(final int n, final Object o) {
        this.g.SetVarByIndex(n, o);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVarBit(final int n, final Object o) throws VarBitOverflowException {
        this.g.SetVarBit(n, o);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarByIndex(final int n) {
        return this.g.GetVarByIndex(n);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandler(final String s, final EventHandler eventHandler) {
        this.getEntity().addEventHandler(s, eventHandler);
    }
    
    @Override
    public void removeEventHandler(final String s, final EventHandler eventHandler) {
        this.getEntity().removeEventHandler(s, eventHandler);
    }
    
    @Override
    public boolean br(final String s) {
        return this.g.br(s);
    }
    
    @Override
    public Object getVarValue(final VarType varType) {
        return this.g.getVarValue(varType);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public Object GetVar(final String s) {
        return this.g.GetVar(s);
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
    public Object GetVarBit(final int n) {
        return this.g.GetVarBit(n);
    }
    
    static {
        d = StringTools.l(NpcComponent.class.getName());
    }
    
    @Override
    public void setVarBitValue(final VarBitType varBitType, final int n) throws VarBitOverflowException {
        this.g.setVarBitValue(varBitType, n);
    }
}
