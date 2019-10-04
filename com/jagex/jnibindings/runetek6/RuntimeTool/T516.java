// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.Component;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class T516 implements ActionListener
{
    final /* synthetic */ Y227 g;
    
    private T516(final Y227 g) {
        this.g = g;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final float[] array = new float[16];
        if (this.g.g != 0L) {
            int n = 0;
            String str = "final_position=\"";
            for (final Component component : this.g.e.getComponents()) {
                if (component instanceof JTextField) {
                    if (n > 0) {
                        str += ",";
                    }
                    str += ((JTextField)component).getText();
                    if (++n == 3 || n == 7 || n == 11 || n == 15) {
                        ++n;
                    }
                }
            }
            System.out.println(str + "\"");
        }
    }
}
