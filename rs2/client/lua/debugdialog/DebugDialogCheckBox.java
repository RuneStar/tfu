/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import rs2.client.lua.debugdialog.DebugDialogComponent;
import rs2.client.lua.debugdialog.J375;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="DDCheckBox")
public class DebugDialogCheckBox
extends DebugDialogComponent {
    final JCheckBox g;

    public DebugDialogCheckBox(boolean bl) {
        this.g = new JCheckBox("", bl);
        this.g.addChangeListener(new J375(this));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogCheckBox Create(boolean bl) {
        return new DebugDialogCheckBox(bl);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetValue(boolean bl) {
        this.g.setSelected(bl);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean GetValue() {
        return this.g.isSelected();
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

