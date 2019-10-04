// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class S226 implements ActionListener
{
    final /* synthetic */ RuntimeTool g;
    
    S226(final RuntimeTool g) {
        this.g = g;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.g.z.setText(this.g.x());
    }
}
