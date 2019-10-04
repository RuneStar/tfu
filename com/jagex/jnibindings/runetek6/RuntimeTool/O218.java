// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class O218 implements ActionListener
{
    final /* synthetic */ RuntimeTool g;
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        RuntimeTool.v(this.g);
    }
    
    O218(final RuntimeTool g) {
        this.g = g;
    }
}
