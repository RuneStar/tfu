// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class W224 implements ActionListener
{
    final /* synthetic */ RuntimeTool d;
    final /* synthetic */ String g;
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        RuntimeTool.i(this.d, this.g);
    }
    
    W224(final RuntimeTool d, final String g) {
        this.g = g;
        this.d = d;
    }
}
