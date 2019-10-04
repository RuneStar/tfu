/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import rs2.client.lua.debugdialog.DebugDialogComponent;
import rs2.client.lua.debugdialog.Q565;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="DDButton")
public class DebugDialogButton
extends DebugDialogComponent {
    final JButton g;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogButton Create(String string) {
        return new DebugDialogButton(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetToolTip(String string) {
        this.g.setToolTipText(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetCaption(String string) {
        this.g.setText(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String GetCaption() {
        return this.g.getText();
    }

    @Override
    public JComponent g() {
        return this.g;
    }

    public DebugDialogButton(String string) {
        this.g = new JButton(string);
        this.g.addActionListener(new Q565(this));
    }
}

