// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.lua;

import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.event.EventForwarder;

public interface LuaSharedEntityInterface extends EventForwarder
{
    @ScriptEntryPoint
    @Be2
    @Bs1
    String GetName();
}
