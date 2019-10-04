// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class K225 implements ActionListener
{
    N220 g;
    final /* synthetic */ RuntimeTool d;
    
    K225(final RuntimeTool d) {
        this.d = d;
        this.g = this.d.ac.lastElement();
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.g.s.setText(this.g.s.getText().equals("true") ? "false" : "true");
        this.g.j();
    }
}
