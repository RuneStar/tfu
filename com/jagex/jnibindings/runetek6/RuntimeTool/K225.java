/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.N220;
import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JTextField;

class K225
implements ActionListener {
    N220 g;
    final /* synthetic */ RuntimeTool d;

    K225(RuntimeTool runtimeTool) {
        this.d = runtimeTool;
        this.g = (N220)this.d.ac.lastElement();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.g.s.setText(this.g.s.getText().equals("true") ? "false" : "true");
        this.g.j();
    }
}

