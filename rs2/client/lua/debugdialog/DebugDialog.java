// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptManager;
import org.slf4j.LoggerFactory;
import java.awt.Component;
import com.jagex.game.runetek6.event.EventHandler;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.Stack;
import org.slf4j.Logger;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;

@ScriptEntryClass
public class DebugDialog extends RuntimeTool
{
    private static final long d = 1L;
    public static DebugDialog j;
    private static final Logger logger;
    static Stack q;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialog Create(final String s) {
        if (DebugDialog.j != null) {
            DebugDialog.logger.error("creation of the second instance of DebugDialog");
        }
        return DebugDialog.j = new DebugDialog();
    }
    
    static void g(final EventHandler eventHandler, final DebugDialogComponent debugDialogComponent, final Object o) {
        synchronized (DebugDialog.q) {
            DebugDialog.q.push(new G697(eventHandler, debugDialogComponent, o));
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetTitle(final String title) {
        this.setTitle(title);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void Show() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public static void d(final DebugDialog debugDialog) {
        debugDialog.dispose();
        DebugDialog.j = null;
    }
    
    static {
        logger = LoggerFactory.getLogger(DebugDialog.class);
        DebugDialog.q = new Stack();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void Hide() {
        this.setVisible(false);
    }
    
    public static void q(final ScriptManager scriptManager) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        scriptManager.registerScriptAPI(DebugDialog.class);
        scriptManager.registerScriptAPI(DebugDialogBorderPanel.class);
        scriptManager.registerScriptAPI(DebugDialogButton.class);
        scriptManager.registerScriptAPI(DebugDialogCheckBox.class);
        scriptManager.registerScriptAPI(DebugDialogField.class);
        scriptManager.registerScriptAPI(DebugDialogGridPanel.class);
        scriptManager.registerScriptAPI(DebugDialogLabel.class);
        scriptManager.registerScriptAPI(DebugDialogSelectionBox.class);
        scriptManager.registerScriptAPI(DebugDialogTabSet.class);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetContent(final DebugDialogComponent debugDialogComponent) {
        super.v.addTab("DebugOptions", debugDialogComponent.g());
    }
}
