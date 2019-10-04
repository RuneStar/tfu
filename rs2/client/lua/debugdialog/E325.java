// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class E325 implements DocumentListener
{
    final /* synthetic */ DebugDialogField g;
    
    @Override
    public void removeUpdate(final DocumentEvent documentEvent) {
        g(this);
    }
    
    E325(final DebugDialogField g) {
        this.g = g;
    }
    
    @Override
    public void changedUpdate(final DocumentEvent documentEvent) {
        g(this);
    }
    
    @Override
    public void insertUpdate(final DocumentEvent documentEvent) {
        g(this);
    }
    
    private static void g(final E325 e325) {
        final EventHandler eventHandler = e325.g.q.get(StringTools.l("onChange"));
        if (eventHandler != null) {
            DebugDialog.g(eventHandler, e325.g, null);
        }
    }
}
