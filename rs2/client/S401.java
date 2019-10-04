// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import rs2.client.loading.Q162;
import java.awt.Color;

class S401 implements Runnable
{
    final /* synthetic */ B402 g;
    
    S401(final B402 g) {
        this.g = g;
    }
    
    @Override
    public void run() {
        while (!this.g.q) {
            final Q162 h = this.g.h;
            this.g.h(h.d, h.g, Av403.g, Av403.q, Av403.d, Color.WHITE);
            try {
                Thread.sleep(20L);
            }
            catch (InterruptedException ex) {
                break;
            }
        }
        B402.e(this.g);
        this.g.q = false;
        this.g.l = null;
        this.g.s = null;
        this.g.d = null;
    }
}
