/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.worldelement;

import rs2.client.worldelement.Npc;
import rs2.shared.movement.Ai37;
import rs2.shared.movement.Z36;
import tfu.Jt38;

class B35
implements Z36 {
    final /* synthetic */ Npc g;

    @Override
    public void d() {
        this.g.cw();
    }

    @Override
    public Ai37 g() {
        return this.g.aq;
    }

    B35(Npc npc) {
        this.g = npc;
    }

    @Override
    public void q(float f) {
        this.g.cq(f);
    }
}

