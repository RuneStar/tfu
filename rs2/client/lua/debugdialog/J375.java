// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class J375 implements ChangeListener
{
    final /* synthetic */ DebugDialogCheckBox g;
    
    @Override
    public void stateChanged(final ChangeEvent changeEvent) {
        final EventHandler eventHandler = this.g.q.get(StringTools.l("onChange"));
        if (eventHandler != null) {
            DebugDialog.g(eventHandler, this.g, null);
        }
    }
    
    J375(final DebugDialogCheckBox g) {
        this.g = g;
    }
}
