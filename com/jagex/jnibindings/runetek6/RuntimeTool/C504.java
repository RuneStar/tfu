// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;

class C504 implements Runnable
{
    final /* synthetic */ N220 d;
    final /* synthetic */ long g;
    
    @Override
    public void run() {
        if (this.d.j == 0) {
            this.d.s.setText(Boolean.toString(StateManager.callBoolCommand(this.g, this.d.e)));
        }
        else if (this.d.j == 1) {
            this.d.s.setText(Integer.toString(StateManager.callIntCommand(this.g, this.d.e)));
        }
        else if (this.d.j == 2) {
            this.d.s.setText(Float.toString(StateManager.callFloatCommand(this.g, this.d.e)));
        }
        else if (this.d.j == 3) {
            this.d.s.setText(StateManager.callStringCommand(this.g, this.d.e));
        }
    }
    
    C504(final N220 d, final long g) {
        this.g = g;
        this.d = d;
    }
}
