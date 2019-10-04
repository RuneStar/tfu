/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import rs2.client.lua.debugdialog.DebugDialogComponent;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="DDTabSet")
public class DebugDialogTabSet
extends DebugDialogComponent {
    final JTabbedPane g = new JTabbedPane();

    @Override
    public JComponent g() {
        return this.g;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetSelectedTab(int n) {
        this.g.setSelectedIndex(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddTab(String string, DebugDialogComponent debugDialogComponent) {
        this.g.addTab(string, debugDialogComponent.g());
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetSelectedTab() {
        return this.g.getSelectedIndex();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetTabToolTip(int n, String string) {
        this.g.setToolTipTextAt(n, string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogTabSet Create() {
        return new DebugDialogTabSet();
    }
}

