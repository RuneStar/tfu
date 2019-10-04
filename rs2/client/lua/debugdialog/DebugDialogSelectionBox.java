/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import rs2.client.lua.debugdialog.D374;
import rs2.client.lua.debugdialog.DebugDialogComponent;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="DDSelectionBox")
public class DebugDialogSelectionBox
extends DebugDialogComponent {
    final JComboBox d;
    final DefaultComboBoxModel g = new DefaultComboBoxModel();

    public DebugDialogSelectionBox(String[] arrstring) {
        for (String string : arrstring) {
            this.g.addElement(string);
        }
        this.d = new JComboBox(this.g);
        this.d.addActionListener(new D374(this));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetValues(String[] arrstring) {
        this.g.removeAllElements();
        for (String string : arrstring) {
            this.g.addElement(string);
        }
    }

    @Override
    public JComponent g() {
        return this.d;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetSelectedIndex(int n) {
        this.d.setSelectedIndex(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int GetSelectedIndex() {
        return this.d.getSelectedIndex();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetToolTip(String string) {
        this.d.setToolTipText(string);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogSelectionBox Create(String[] arrstring) {
        return new DebugDialogSelectionBox(arrstring);
    }
}

