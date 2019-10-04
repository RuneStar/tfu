/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JComponent;
import javax.swing.JLabel;
import rs2.client.lua.debugdialog.DebugDialogComponent;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="DDLabel")
public class DebugDialogLabel
extends DebugDialogComponent {
    final JLabel g;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String GetText() {
        return this.g.getText();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogLabel Create(String string, int n) {
        return new DebugDialogLabel(string, n);
    }

    public DebugDialogLabel(String string, int n) {
        this.g = new JLabel(string, n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetText(String string) {
        this.g.setText(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetToolTip(String string) {
        this.g.setToolTipText(string);
    }

    @Override
    public JComponent g() {
        return this.g;
    }
}

