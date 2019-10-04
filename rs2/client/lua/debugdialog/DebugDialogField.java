// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua.debugdialog;

import javax.swing.JComponent;
import javax.swing.event.DocumentListener;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import javax.swing.JTextField;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("DDField")
public class DebugDialogField extends DebugDialogComponent
{
    final JTextField g;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetToolTip(final String toolTipText) {
        this.g.setToolTipText(toolTipText);
    }
    
    public DebugDialogField(final String text) {
        this.g = new JTextField(text);
        this.g.getDocument().addDocumentListener(new E325(this));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetValue(final String text) {
        this.g.setText(text);
    }
    
    public JComponent g() {
        return this.g;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static DebugDialogField Create(final String s) {
        return new DebugDialogField(s);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public String GetValue() {
        return this.g.getText();
    }
}
