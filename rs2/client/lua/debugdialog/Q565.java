/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import rs2.client.lua.debugdialog.DebugDialog;
import rs2.client.lua.debugdialog.DebugDialogButton;
import rs2.client.lua.debugdialog.DebugDialogComponent;

class Q565
implements ActionListener {
    final /* synthetic */ DebugDialogButton g;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        EventHandler eventHandler = (EventHandler)this.g.q.get(StringTools.l("onClick"));
        if (eventHandler != null) {
            DebugDialog.g(eventHandler, this.g, null);
        }
    }

    Q565(DebugDialogButton debugDialogButton) {
        this.g = debugDialogButton;
    }
}

