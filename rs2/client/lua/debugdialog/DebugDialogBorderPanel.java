/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua.debugdialog;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JComponent;
import javax.swing.JPanel;
import rs2.client.lua.debugdialog.DebugDialogComponent;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="DDBorderPanel")
public class DebugDialogBorderPanel
extends DebugDialogComponent {
    final JPanel g = new JPanel();

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddComponentSouth(DebugDialogComponent debugDialogComponent) {
        this.g.add((Component)debugDialogComponent.g(), "South");
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddComponentEast(DebugDialogComponent debugDialogComponent) {
        this.g.add((Component)debugDialogComponent.g(), "East");
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddComponentCentre(DebugDialogComponent debugDialogComponent) {
        this.g.add((Component)debugDialogComponent.g(), "Center");
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void AddComponentNorth(DebugDialogComponent debugDialogComponent) {
        this.g.add((Component)debugDialogComponent.g(), "North");
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
    public void AddComponentWest(DebugDialogComponent debugDialogComponent) {
        this.g.add((Component)debugDialogComponent.g(), "West");
    }

    @Override
    JComponent g() {
        return this.g;
    }

    public DebugDialogBorderPanel() {
        this.g.setLayout(new BorderLayout());
    }
}

