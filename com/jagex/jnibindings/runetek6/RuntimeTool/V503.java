// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;

class V503 implements Runnable
{
    final /* synthetic */ long d;
    final /* synthetic */ String g;
    final /* synthetic */ N220 q;
    
    @Override
    public void run() {
        if (this.q.j == 0) {
            if (this.g.equals("true") || this.g.equals("false")) {
                StateManager.callStateCommand(this.d, this.q.h.replace("%value%", this.g));
            }
        }
        else if (this.q.j == 3) {
            StateManager.callStateCommand(this.d, this.q.h.replace("%value%", "'" + this.g + "'"));
        }
        else if (this.q.j == 2) {
            final Float n = new Float(this.g);
            this.q.s.setText(Float.toString(n));
            StateManager.callStateCommand(this.d, this.q.h.replace("%value%", n.toString()));
        }
        else {
            StateManager.callStateCommand(this.d, this.q.h.replace("%value%", this.g));
        }
    }
    
    V503(final N220 q, final String g, final long d) {
        this.g = g;
        this.d = d;
        this.q = q;
    }
}
