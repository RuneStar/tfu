// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class J217 implements ActionListener
{
    final /* synthetic */ RuntimeTool g;
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        RuntimeTool.r(this.g);
    }
    
    J217(final RuntimeTool g) {
        this.g = g;
    }
}
