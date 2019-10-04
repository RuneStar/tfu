/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JComponent;
import javax.swing.JPanel;
import rs2.client.lua.debugdialog.DebugDialogComponent;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="DDGridPanel")
public class DebugDialogGridPanel
extends DebugDialogComponent {
    final JPanel g = new JPanel();

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogGridPanel Create(int n, int n2) {
        return new DebugDialogGridPanel(n, n2);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddComponent(DebugDialogComponent debugDialogComponent) {
        this.g.add(debugDialogComponent.g());
    }

    @Override
    JComponent g() {
        return this.g;
    }

    public DebugDialogGridPanel(int n, int n2) {
        this.g.setLayout(new GridLayout(n, n2));
    }
}

