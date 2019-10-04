package rs2.shared.lua;

import com.jagex.game.runetek6.event.EventForwarder;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;

public interface LuaSharedEntityInterface extends EventForwarder {
   @ScriptEntryPoint
   @Be2
   @Bs1
   String GetName();
}
