/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.H221;
import com.jagex.jnibindings.runetek6.RuntimeTool.Y227;
import com.jagex.jnibindings.runetek6.StateManager;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

class G510
implements Runnable {
    final /* synthetic */ Y227 d;
    final /* synthetic */ long g;

    G510(Y227 y227, long l) {
        this.g = l;
        this.d = y227;
    }

    @Override
    public void run() {
        if (this.g != 0L) {
            int n = 0;
            StateManager.callMatrixCommand(this.g, "Get" + this.d.d, this.d.s);
            for (Component component : this.d.e.getComponents()) {
                if (!(component instanceof JTextField)) continue;
                ((JTextField)component).setText(String.valueOf(this.d.s[n]).toString());
                if (++n != 3 && n != 7 && n != 11 && n != 15) continue;
                ++n;
            }
        }
    }
}

