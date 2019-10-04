// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JComponent;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.awt.Component;
import javax.swing.JPanel;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("DDBorderPanel")
public class DebugDialogBorderPanel extends DebugDialogComponent
{
    final JPanel g;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddComponentSouth(final DebugDialogComponent debugDialogComponent) {
        this.g.add(debugDialogComponent.g(), "South");
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddComponentEast(final DebugDialogComponent debugDialogComponent) {
        this.g.add(debugDialogComponent.g(), "East");
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddComponentCentre(final DebugDialogComponent debugDialogComponent) {
        this.g.add(debugDialogComponent.g(), "Center");
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddComponentNorth(final DebugDialogComponent debugDialogComponent) {
        this.g.add(debugDialogComponent.g(), "North");
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogBorderPanel Create() {
        return new DebugDialogBorderPanel();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddComponentWest(final DebugDialogComponent debugDialogComponent) {
        this.g.add(debugDialogComponent.g(), "West");
    }
    
    @Override
    JComponent g() {
        return this.g;
    }
    
    public DebugDialogBorderPanel() {
        (this.g = new JPanel()).setLayout(new BorderLayout());
    }
}
