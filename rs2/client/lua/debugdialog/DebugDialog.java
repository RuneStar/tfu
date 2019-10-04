/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import java.awt.Component;
import java.util.Stack;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.lua.debugdialog.DebugDialogBorderPanel;
import rs2.client.lua.debugdialog.DebugDialogButton;
import rs2.client.lua.debugdialog.DebugDialogCheckBox;
import rs2.client.lua.debugdialog.DebugDialogComponent;
import rs2.client.lua.debugdialog.DebugDialogField;
import rs2.client.lua.debugdialog.DebugDialogGridPanel;
import rs2.client.lua.debugdialog.DebugDialogLabel;
import rs2.client.lua.debugdialog.DebugDialogSelectionBox;
import rs2.client.lua.debugdialog.DebugDialogTabSet;
import rs2.client.lua.debugdialog.G697;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class DebugDialog
extends RuntimeTool {
    private static final long d = 1L;
    public static DebugDialog j;
    private static final Logger logger;
    static Stack q;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialog Create(String string) {
        if (j != null) {
            logger.error("creation of the second instance of DebugDialog");
        }
        j = new DebugDialog();
        return j;
    }

    static void g(EventHandler eventHandler, DebugDialogComponent debugDialogComponent, Object object) {
        Stack stack = q;
        synchronized (stack) {
            q.push(new G697(eventHandler, debugDialogComponent, object));
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetTitle(String string) {
        this.setTitle(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void Show() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void d(DebugDialog debugDialog) {
        debugDialog.dispose();
        j = null;
    }

    static {
        logger = LoggerFactory.getLogger(DebugDialog.class);
        q = new Stack();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void Hide() {
        this.setVisible(false);
    }

    public static void q(ScriptManager scriptManager) {
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
    public void SetContent(DebugDialogComponent debugDialogComponent) {
        this.v.addTab("DebugOptions", debugDialogComponent.g());
    }
}

