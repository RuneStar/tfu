/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.D222;
import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class L223
implements ActionListener {
    final /* synthetic */ RuntimeTool g;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String[][] arrstring = Z132.j();
        this.g.z(arrstring, D222.d);
    }

    L223(RuntimeTool runtimeTool) {
        this.g = runtimeTool;
    }
}

