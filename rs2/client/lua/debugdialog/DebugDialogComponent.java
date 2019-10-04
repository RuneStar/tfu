/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.HashMap;
import javax.swing.JComponent;
import tfu.Be2;
import tfu.Bs1;

public abstract class DebugDialogComponent {
    final HashMap q = new HashMap<K, V>();

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetEventHandler(String string, EventHandler eventHandler) {
        if (eventHandler == null) {
            this.q.remove(StringTools.l(string));
        } else {
            this.q.put(StringTools.l(string), eventHandler);
        }
    }

    abstract JComponent g();
}

