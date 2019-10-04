/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import rs2.client.lua.debugdialog.DebugDialogComponent;
import rs2.client.lua.debugdialog.E325;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="DDField")
public class DebugDialogField
extends DebugDialogComponent {
    final JTextField g;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetToolTip(String string) {
        this.g.setToolTipText(string);
    }

    public DebugDialogField(String string) {
        this.g = new JTextField(string);
        this.g.getDocument().addDocumentListener(new E325(this));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetValue(String string) {
        this.g.setText(string);
    }

    @Override
    public JComponent g() {
        return this.g;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogField Create(String string) {
        return new DebugDialogField(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String GetValue() {
        return this.g.getText();
    }
}

