/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class W224
implements ActionListener {
    final /* synthetic */ RuntimeTool d;
    final /* synthetic */ String g;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        RuntimeTool.i(this.d, this.g);
    }

    W224(RuntimeTool runtimeTool, String string) {
        this.g = string;
        this.d = runtimeTool;
    }
}

