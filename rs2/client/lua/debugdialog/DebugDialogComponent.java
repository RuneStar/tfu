// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import javax.swing.JComponent;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import java.util.HashMap;

public abstract class DebugDialogComponent
{
    final HashMap q;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetEventHandler(final String s, final EventHandler value) {
        if (value == null) {
            this.q.remove(StringTools.l(s));
        }
        else {
            this.q.put(StringTools.l(s), value);
        }
    }
    
    abstract JComponent g();
    
    public DebugDialogComponent() {
        this.q = new HashMap();
    }
}
