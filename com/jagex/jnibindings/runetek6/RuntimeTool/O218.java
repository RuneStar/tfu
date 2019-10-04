/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class O218
implements ActionListener {
    final /* synthetic */ RuntimeTool g;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        RuntimeTool.v(this.g);
    }

    O218(RuntimeTool runtimeTool) {
        this.g = runtimeTool;
    }
}

