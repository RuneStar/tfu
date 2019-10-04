// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class D374 implements ActionListener
{
    final /* synthetic */ DebugDialogSelectionBox g;
    
    D374(final DebugDialogSelectionBox g) {
        this.g = g;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final EventHandler eventHandler = this.g.q.get(StringTools.l("onChange"));
        if (eventHandler != null) {
            DebugDialog.g(eventHandler, this.g, null);
        }
    }
}
