// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Q565 implements ActionListener
{
    final /* synthetic */ DebugDialogButton g;
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final EventHandler eventHandler = this.g.q.get(StringTools.l("onClick"));
        if (eventHandler != null) {
            DebugDialog.g(eventHandler, this.g, null);
        }
    }
    
    Q565(final DebugDialogButton g) {
        this.g = g;
    }
}
