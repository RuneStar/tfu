/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.sound.SoundManager;
import rs2.client.worldelement.Npc;
import tfu.Am548;
import tfu.An52;
import tfu.At476;
import tfu.Cg550;
import tfu.Cj551;
import tfu.Cv549;
import tfu.Dn555;

public class Ac557
extends Am548 {
    private static final Logger logger = LoggerFactory.getLogger(Ac557.class);
    int c;

    public Ac557(An52 an52) {
        super(an52);
    }

    @Override
    void g() {
        int n;
        int n2 = this.c;
        boolean bl = this.k;
        if (this.j instanceof Npc && n2 != (n = At476.h((Npc)this.j))) {
            this.c = n;
        }
        if ((this.c != n2 || this.k != bl) && this.a != null) {
            logger.trace("stopped bgsound stream due to multiloc/npc or player change");
            Dn555.s(SoundManager.t, this.a);
            this.a = null;
            this.o = null;
            this.i = null;
        }
    }
}

