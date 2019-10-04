// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import rs2.client.sound.SoundManager;
import rs2.client.worldelement.Npc;
import org.slf4j.Logger;

public class Ac557 extends Am548
{
    private static final Logger logger;
    int c;
    
    public Ac557(final An52 an52) {
        super(an52);
    }
    
    @Override
    void g() {
        final int c = this.c;
        final boolean k = super.k;
        if (super.j instanceof Npc) {
            final int h = At476.h((Npc)super.j);
            if (c != h) {
                this.c = h;
            }
        }
        if ((this.c != c || super.k != k) && super.a != null) {
            Ac557.logger.trace("stopped bgsound stream due to multiloc/npc or player change");
            Dn555.s(SoundManager.t, super.a);
            super.a = null;
            super.o = null;
            super.i = null;
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(Ac557.class);
    }
}
