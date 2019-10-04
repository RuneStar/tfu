// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class N220 extends H221
{
    String e;
    String h;
    int j;
    public JTextField s;
    
    void j() {
        RuntimeTool.h.add(new V503(this, this.s.getText(), super.g));
    }
    
    @Override
    public void g() {
        RuntimeTool.h.add(new C504(this, super.g));
    }
    
    public N220(final String d, final String e, final String h) {
        this.j = 0;
        this.s = new JTextField(10);
        super.d = d;
        this.e = e;
        this.h = h;
        this.s.addActionListener(new B505(this));
    }
}
