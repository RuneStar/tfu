// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.worldelement;

import rs2.shared.movement.Ai37;
import rs2.shared.movement.Z36;

class B35 implements Z36
{
    final /* synthetic */ Npc g;
    
    @Override
    public void d() {
        this.g.cw();
    }
    
    @Override
    public Ai37 g() {
        return this.g.aq;
    }
    
    B35(final Npc g) {
        this.g = g;
    }
    
    @Override
    public void q(final float n) {
        this.g.cq(n);
    }
}
