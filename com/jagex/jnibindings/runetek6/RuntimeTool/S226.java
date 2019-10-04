/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

class S226
implements ActionListener {
    final /* synthetic */ RuntimeTool g;

    S226(RuntimeTool runtimeTool) {
        this.g = runtimeTool;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.g.z.setText(RuntimeTool.a(this.g));
    }
}

