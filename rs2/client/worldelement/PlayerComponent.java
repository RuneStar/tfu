/*
 * Decompiled with CFR 0.146.
 */
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
import rs2.client.worldelement.player;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class PlayerComponent
extends Component
implements Q290,
G53 {
    public static final int d = StringTools.l(PlayerComponent.class.getName());
    public final player g;

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeEventHandler(String string, EventHandler eventHandler) {
        this.g.removeEventHandler(string, eventHandler);
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
    public static int getComponentTypeID() {
        return d;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public String GetName() {
        return this.g.aq == null ? "" : this.g.aq;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void triggerEvent(@ScriptID Integer n, Object object) {
        this.g.triggerEvent(n, object);
    }

    @Override
    public boolean br(String string) {
        return this.g.br(string);
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
    public void addEventHandlerByID(@ScriptID Integer n, EventHandler eventHandler) {
        this.g.addEventHandlerByID(n, eventHandler);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void addEventHandler(String string, EventHandler eventHandler) {
        this.g.addEventHandler(string, eventHandler);
    }

    PlayerComponent(player player2) {
        this.g = player2;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + this.g.aq;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    @Override
    public void removeAllEventHandlers(@ScriptID Integer n) {
        this.g.removeAllEventHandlers(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVarBit(int n) {
        return this.g.GetVarBit(n);
    }
}

