/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import java.util.HashMap;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import rs2.client.lua.debugdialog.DebugDialog;
import rs2.client.lua.debugdialog.DebugDialogComponent;
import rs2.client.lua.debugdialog.DebugDialogField;

class E325
implements DocumentListener {
    final /* synthetic */ DebugDialogField g;

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        E325.g(this);
    }

    E325(DebugDialogField debugDialogField) {
        this.g = debugDialogField;
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        E325.g(this);
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        E325.g(this);
    }

    private static void g(E325 e325) {
        EventHandler eventHandler = (EventHandler)e325.g.q.get(StringTools.l("onChange"));
        if (eventHandler != null) {
            DebugDialog.g(eventHandler, e325.g, null);
        }
    }
}

