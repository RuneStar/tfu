// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import javax.swing.JComponent;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("DDSelectionBox")
public class DebugDialogSelectionBox extends DebugDialogComponent
{
    final JComboBox d;
    final DefaultComboBoxModel g;
    
    public DebugDialogSelectionBox(final String[] array) {
        this.g = new DefaultComboBoxModel();
        for (int length = array.length, i = 0; i < length; ++i) {
            this.g.addElement(array[i]);
        }
        (this.d = new JComboBox(this.g)).addActionListener(new D374(this));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetValues(final String[] array) {
        this.g.removeAllElements();
        for (int length = array.length, i = 0; i < length; ++i) {
            this.g.addElement(array[i]);
        }
    }
    
    public JComponent g() {
        return this.d;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetSelectedIndex(final int selectedIndex) {
        this.d.setSelectedIndex(selectedIndex);
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
    public void SetToolTip(final String toolTipText) {
        this.d.setToolTipText(toolTipText);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogSelectionBox Create(final String[] array) {
        return new DebugDialogSelectionBox(array);
    }
}
