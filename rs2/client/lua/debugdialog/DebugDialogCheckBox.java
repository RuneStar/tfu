// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import javax.swing.JComponent;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.event.ChangeListener;
import javax.swing.JCheckBox;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("DDCheckBox")
public class DebugDialogCheckBox extends DebugDialogComponent
{
    final JCheckBox g;
    
    public DebugDialogCheckBox(final boolean selected) {
        (this.g = new JCheckBox("", selected)).addChangeListener(new J375(this));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogCheckBox Create(final boolean b) {
        return new DebugDialogCheckBox(b);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetValue(final boolean selected) {
        this.g.setSelected(selected);
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
    public void SetToolTip(final String toolTipText) {
        this.g.setToolTipText(toolTipText);
    }
    
    public JComponent g() {
        return this.g;
    }
}
