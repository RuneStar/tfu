// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JComponent;
import java.awt.Component;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JPanel;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("DDGridPanel")
public class DebugDialogGridPanel extends DebugDialogComponent
{
    final JPanel g;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogGridPanel Create(final int n, final int n2) {
        return new DebugDialogGridPanel(n, n2);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddComponent(final DebugDialogComponent debugDialogComponent) {
        this.g.add(debugDialogComponent.g());
    }
    
    @Override
    JComponent g() {
        return this.g;
    }
    
    public DebugDialogGridPanel(final int rows, final int cols) {
        (this.g = new JPanel()).setLayout(new GridLayout(rows, cols));
    }
}
