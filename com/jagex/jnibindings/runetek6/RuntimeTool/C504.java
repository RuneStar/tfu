/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.N220;
import com.jagex.jnibindings.runetek6.StateManager;
import javax.swing.JTextField;

class C504
implements Runnable {
    final /* synthetic */ N220 d;
    final /* synthetic */ long g;

    @Override
    public void run() {
        if (this.d.j == 0) {
            boolean bl = StateManager.callBoolCommand(this.g, this.d.e);
            this.d.s.setText(Boolean.toString(bl));
        } else if (this.d.j == 1) {
            int n = StateManager.callIntCommand(this.g, this.d.e);
            this.d.s.setText(Integer.toString(n));
        } else if (this.d.j == 2) {
            float f = StateManager.callFloatCommand(this.g, this.d.e);
            this.d.s.setText(Float.toString(f));
        } else if (this.d.j == 3) {
            String string = StateManager.callStringCommand(this.g, this.d.e);
            this.d.s.setText(string);
        }
    }

    C504(N220 n220, long l) {
        this.g = l;
        this.d = n220;
    }
}

