/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import java.util.HashMap;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import rs2.client.lua.debugdialog.DebugDialog;
import rs2.client.lua.debugdialog.DebugDialogCheckBox;
import rs2.client.lua.debugdialog.DebugDialogComponent;

class J375
implements ChangeListener {
    final /* synthetic */ DebugDialogCheckBox g;

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        EventHandler eventHandler = (EventHandler)this.g.q.get(StringTools.l("onChange"));
        if (eventHandler != null) {
            DebugDialog.g(eventHandler, this.g, null);
        }
    }

    J375(DebugDialogCheckBox debugDialogCheckBox) {
        this.g = debugDialogCheckBox;
    }
}

