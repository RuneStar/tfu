// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import java.awt.event.ActionListener;
import javax.swing.JComponent;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JButton;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("DDButton")
public class DebugDialogButton extends DebugDialogComponent
{
    final JButton g;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogButton Create(final String s) {
        return new DebugDialogButton(s);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetToolTip(final String toolTipText) {
        this.g.setToolTipText(toolTipText);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetCaption(final String text) {
        this.g.setText(text);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public String GetCaption() {
        return this.g.getText();
    }
    
    public JComponent g() {
        return this.g;
    }
    
    public DebugDialogButton(final String text) {
        (this.g = new JButton(text)).addActionListener(new Q565(this));
    }
}
