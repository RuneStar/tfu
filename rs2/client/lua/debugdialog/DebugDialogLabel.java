// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import javax.swing.JComponent;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JLabel;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("DDLabel")
public class DebugDialogLabel extends DebugDialogComponent
{
    final JLabel g;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public String GetText() {
        return this.g.getText();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogLabel Create(final String s, final int n) {
        return new DebugDialogLabel(s, n);
    }
    
    public DebugDialogLabel(final String text, final int horizontalAlignment) {
        this.g = new JLabel(text, horizontalAlignment);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetText(final String text) {
        this.g.setText(text);
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
