/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.B505;
import com.jagex.jnibindings.runetek6.RuntimeTool.C504;
import com.jagex.jnibindings.runetek6.RuntimeTool.H221;
import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import com.jagex.jnibindings.runetek6.RuntimeTool.V503;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.JTextField;

public class N220
extends H221 {
    String e;
    String h;
    int j = 0;
    public JTextField s = new JTextField(10);

    void j() {
        String string = this.s.getText();
        long l = this.g;
        RuntimeTool.h.add(new V503(this, string, l));
    }

    @Override
    public void g() {
        long l = this.g;
        RuntimeTool.h.add(new C504(this, l));
    }

    public N220(String string, String string2, String string3) {
        this.d = string;
        this.e = string2;
        this.h = string3;
        this.s.addActionListener(new B505(this));
    }
}

