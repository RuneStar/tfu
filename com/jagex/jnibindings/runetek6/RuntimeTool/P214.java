// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

class P214 extends MouseAdapter
{
    final /* synthetic */ RuntimeTool g;
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        RuntimeTool.m(this.g, mouseEvent);
    }
    
    P214(final RuntimeTool g) {
        this.g = g;
    }
}
