// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateEventManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class E219 implements ActionListener
{
    final /* synthetic */ RuntimeTool g;
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        StateEventManager.sendEvent(this.g.as.getText());
    }
    
    E219(final RuntimeTool g) {
        this.g = g;
    }
}
