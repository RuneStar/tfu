/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.N220;
import com.jagex.jnibindings.runetek6.StateManager;
import javax.swing.JTextField;

class V503
implements Runnable {
    final /* synthetic */ long d;
    final /* synthetic */ String g;
    final /* synthetic */ N220 q;

    @Override
    public void run() {
        if (this.q.j == 0) {
            if (this.g.equals("true") || this.g.equals("false")) {
                StateManager.callStateCommand(this.d, this.q.h.replace("%value%", this.g));
            }
        } else if (this.q.j == 3) {
            StateManager.callStateCommand(this.d, this.q.h.replace("%value%", "'" + this.g + "'"));
        } else if (this.q.j == 2) {
            Float f = new Float(this.g);
            this.q.s.setText(Float.toString(f.floatValue()));
            StateManager.callStateCommand(this.d, this.q.h.replace("%value%", f.toString()));
        } else {
            StateManager.callStateCommand(this.d, this.q.h.replace("%value%", this.g));
        }
    }

    V503(N220 n220, String string, long l) {
        this.g = string;
        this.d = l;
        this.q = n220;
    }
}

