/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import com.jagex.jnibindings.runetek6.StateEventManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class E219
implements ActionListener {
    final /* synthetic */ RuntimeTool g;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        StateEventManager.sendEvent(this.g.as.getText());
    }

    E219(RuntimeTool runtimeTool) {
        this.g = runtimeTool;
    }
}

