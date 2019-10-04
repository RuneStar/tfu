// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import java.awt.Component;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("DDTabSet")
public class DebugDialogTabSet extends DebugDialogComponent
{
    final JTabbedPane g;
    
    public JComponent g() {
        return this.g;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetSelectedTab(final int selectedIndex) {
        this.g.setSelectedIndex(selectedIndex);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddTab(final String title, final DebugDialogComponent debugDialogComponent) {
        this.g.addTab(title, debugDialogComponent.g());
    }
    
    public DebugDialogTabSet() {
        this.g = new JTabbedPane();
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
    public void SetTabToolTip(final int index, final String toolTipText) {
        this.g.setToolTipTextAt(index, toolTipText);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogTabSet Create() {
        return new DebugDialogTabSet();
    }
}
