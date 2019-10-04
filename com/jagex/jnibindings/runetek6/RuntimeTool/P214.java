/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class P214
extends MouseAdapter {
    final /* synthetic */ RuntimeTool g;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        RuntimeTool.m(this.g, mouseEvent);
    }

    P214(RuntimeTool runtimeTool) {
        this.g = runtimeTool;
    }
}

