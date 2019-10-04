// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.Component;
import javax.swing.JTextField;
import com.jagex.jnibindings.runetek6.StateManager;

class G510 implements Runnable
{
    final /* synthetic */ Y227 d;
    final /* synthetic */ long g;
    
    G510(final Y227 d, final long g) {
        this.g = g;
        this.d = d;
    }
    
    @Override
    public void run() {
        if (this.g != 0L) {
            int n = 0;
            StateManager.callMatrixCommand(this.g, "Get" + this.d.d, this.d.s);
            for (final Component component : this.d.e.getComponents()) {
                if (component instanceof JTextField) {
                    ((JTextField)component).setText(String.valueOf(this.d.s[n]).toString());
                    if (++n == 3 || n == 7 || n == 11 || n == 15) {
                        ++n;
                    }
                }
            }
        }
    }
}
