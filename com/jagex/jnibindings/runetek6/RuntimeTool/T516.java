/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.G510;
import com.jagex.jnibindings.runetek6.RuntimeTool.H221;
import com.jagex.jnibindings.runetek6.RuntimeTool.Y227;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JPanel;
import javax.swing.JTextField;

class T516
implements ActionListener {
    final /* synthetic */ Y227 g;

    /* synthetic */ T516(Y227 y227, G510 g510) {
        this(y227);
    }

    private T516(Y227 y227) {
        this.g = y227;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        float[] arrf = new float[16];
        if (this.g.g != 0L) {
            int n = 0;
            String string = "final_position=\"";
            for (Component component : this.g.e.getComponents()) {
                if (!(component instanceof JTextField)) continue;
                if (n > 0) {
                    string = string + ",";
                }
                string = string + ((JTextField)component).getText();
                if (++n != 3 && n != 7 && n != 11 && n != 15) continue;
                ++n;
            }
            System.out.println(string + "\"");
        }
    }
}

