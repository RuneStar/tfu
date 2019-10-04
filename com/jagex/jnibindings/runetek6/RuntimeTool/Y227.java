/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.G510;
import com.jagex.jnibindings.runetek6.RuntimeTool.H221;
import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import com.jagex.jnibindings.runetek6.RuntimeTool.T516;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Y227
extends H221 {
    JPanel e;
    String[] h = new String[5];
    JPanel j;
    float[] s = new float[16];

    JTextField j() {
        JTextField jTextField = new JTextField();
        jTextField.setMinimumSize(new Dimension(100, 30));
        T516 t516 = new T516(this, null);
        jTextField.addActionListener(t516);
        return jTextField;
    }

    public Y227(String string) {
        this.d = string;
        this.j = new JPanel(new BorderLayout());
        this.e = new JPanel(new GridLayout(4, 3));
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
        this.e.add(this.j());
        this.j.add((Component)this.e, "Center");
        JLabel jLabel = new JLabel(this.d);
        this.j.add((Component)jLabel, "North");
    }

    @Override
    public void g() {
        long l = this.g;
        RuntimeTool.h.add(new G510(this, l));
    }
}

