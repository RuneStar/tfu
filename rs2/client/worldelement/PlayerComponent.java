// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.worldelement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.variables.G53;
import rs2.client.lua.Q290;
import com.jagex.game.runetek6.gameentity.Component;

@ScriptEntryClass
public class PlayerComponent extends Component implements Q290, G53
{
    public static final int d;
    public final player g;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeEventHandler(final String s, final EventHandler eventHandler) {
        this.g.removeEventHandler(s, eventHandler);
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
    public static int getComponentTypeID() {
        return PlayerComponent.d;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public String GetName() {
        return (this.g.aq == null) ? "" : this.g.aq;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void triggerEvent(@ScriptID final Integer n, final Object o) {
        this.g.triggerEvent(n, o);
    }
    
    @Override
    public boolean br(final String s) {
        return this.g.br(s);
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
    public void addEventHandlerByID(@ScriptID final Integer n, final EventHandler eventHandler) {
        this.g.addEventHandlerByID(n, eventHandler);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandler(final String s, final EventHandler eventHandler) {
        this.g.addEventHandler(s, eventHandler);
    }
    
    PlayerComponent(final player g) {
        this.g = g;
    }
    
    @Override
    public String toString() {
        return super.toString() + ":" + this.g.aq;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeAllEventHandlers(@ScriptID final Integer n) {
        this.g.removeAllEventHandlers(n);
    }
    
    static {
        d = StringTools.l(PlayerComponent.class.getName());
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarBit(final int n) {
        return this.g.GetVarBit(n);
    }
}
