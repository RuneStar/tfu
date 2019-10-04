// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Y227 extends H221
{
    JPanel e;
    String[] h;
    JPanel j;
    float[] s;
    
    JTextField j() {
        final JTextField textField = new JTextField();
        textField.setMinimumSize(new Dimension(100, 30));
        textField.addActionListener(new T516(this, null));
        return textField;
    }
    
    public Y227(final String d) {
        this.h = new String[5];
        this.s = new float[16];
        super.d = d;
        this.j = new JPanel(new BorderLayout());
        (this.e = new JPanel(new GridLayout(4, 3))).add(this.j());
        this.e.add(this.j());
        this.e.add(this.j());
        this.e.add(this.j());
        this.e.add(this.j());
        this.e.add(this.j());
        this.e.add(this.j());
        this.e.add(this.j());
        this.e.add(this.j());
        this.e.add(this.j());
        this.e.add(this.j());
        this.e.add(this.j());
        this.j.add(this.e, "Center");
        this.j.add(new JLabel(super.d), "North");
    }
    
    @Override
    public void g() {
        RuntimeTool.h.add(new G510(this, super.g));
    }
}
